/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Phone;
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

    public List<Phone> getAllNumbers(int number) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT p FROM Phone p").setParameter("number", number);
            List<Phone> pl = q.getResultList();
            return pl;
        } finally {
            em.close();
        }
    }

    public Phone getPersonByPhone(int number) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT p FROM Phone p WHERE p.number = :number").setParameter("number", number);
            return (Phone) q.getResultList().get(0);
        } finally {
            em.close();
        }
    }
}
