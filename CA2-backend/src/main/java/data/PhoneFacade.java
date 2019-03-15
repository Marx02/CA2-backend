/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dto.PhoneDTO;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author caspe
 */
public class PhoneFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2DB");

    public PhoneFacade(EntityManagerFactory emf) {

    }

    public PhoneFacade() {

    }

//    public List<Phone> getAllNumbers() {
//        EntityManager em = emf.createEntityManager();
//        try {
//            Query q = em.createQuery("SELECT p FROM Phone p").getResultList();
//            List<Phone> pl = q.getResultList();
//            return pl;
//        } finally {
//            em.close();
//        }
//    }
    public List<PhoneDTO> getAllNumbersDTO() {
        EntityManager em = emf.createEntityManager();
        List<PhoneDTO> pList = new ArrayList();
        for (Phone p : (List<Phone>) em.createQuery("SELECT p FROM Phone p").getResultList()) {
            pList.add(new PhoneDTO(p));
        }
        return pList;
    }

    public Person getPersonByNumber(int pnumber) {
        EntityManager em = emf.createEntityManager();
        try {
            Phone p = em.find(Phone.class, (Integer) pnumber);
            return p.getPerson();
        } finally {
            em.close();
        }
    }

}
