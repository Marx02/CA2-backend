/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dto.PersonDTO;
import entity.CityInfo;
import entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Lenovo
 */
public class CityInfoFacade {

    /* Esben Dalgaard; DECK-CS */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2DB");

    public CityInfoFacade(EntityManagerFactory emf) {

    }

    public CityInfoFacade() {
    }

//    public static void main(String[] args) {
//        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("CA2DB");
//        EntityManager em1 = emf1.createEntityManager();
//
//        try {
//            em1.getTransaction().begin();
//            Person pm = new Person("Lars");
//            pm.addHobby(new Hobby("Skiing"));
//            pm.addHobby(new Hobby("Swinger clubbing"));
//            em1.persist(pm);
//            em1.getTransaction().commit();
//
//        } finally {
//            em1.close();
//        }
//
//    }
//    public void addEntityManager(EntityManagerFactory emf) {
//        this.emf = emf;
//    }
    public CityInfo addCity(CityInfo c) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return c;
        } finally {
            em.close();
        }
    }

    public CityInfo getCityByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("select c from CityInfo c where c.city = :name").setParameter("name", name);
            return (CityInfo) q.getResultList().get(0);
        } finally {
            em.close();
        }
    }

    public CityInfo getCityById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            CityInfo p = em.find(CityInfo.class, (Integer) id);
            return p;
        } finally {
            em.close();
        }
    }

    public CityInfo deleteCityByZip(int zip) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            CityInfo p = em.find(CityInfo.class, (Integer) zip);
            em.remove(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    public List<CityInfo> getCitiesByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("select c from CityInfo c where c.city = :name").setParameter("name", name);
            List<CityInfo> ls = q.getResultList();
            return ls;
        } finally {
            em.close();
        }
    }

    public CityInfo getCityByZip(int zip) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("select c from CityInfo c where c.zip = :zip").setParameter("zip", zip);
            return (CityInfo) q.getResultList().get(0);
        } finally {
            em.close();
        }
    }

    public List<PersonDTO> getPersonsByZip(int zip) {
        EntityManager em = emf.createEntityManager();
        List<PersonDTO> pList = new ArrayList();
        try {
//            Query q = em.createQuery("select a.id from Address a where a.cityinfo.zip = :zip").setParameter("zip", zip);
//            List<Address> ad = q.getResultList();
//            for (int i = 0; i < ad.size(); i++) {
            Query q2 = em.createQuery("select p from Person p where p.address.cityinfo.zip = :zip").setParameter("zip", zip);
            List<Person> pl = q2.getResultList();
            for (int j = 0; j < pl.size(); j++) {
                pList.add(new PersonDTO(pl.get(j))); // q2.getResultList();
            }
//            }
            return pList;
        } finally {
            em.close();
        }

    }
    
        public List<PersonDTO> getPersonsByCity(String city) {
        EntityManager em = emf.createEntityManager();
        List<PersonDTO> pList = new ArrayList();
        try {
            Query q2 = em.createQuery("select p from Person p where p.address.cityinfo.city = :city").setParameter("city", city);
            List<Person> pl = q2.getResultList();
            for (int j = 0; j < pl.size(); j++) {
                pList.add(new PersonDTO(pl.get(j)));
            }
            return pList;
        } finally {
            em.close();
        }
    }

    public int getCityCount() {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("select count(e) from CityInfo e");
            return (int) q.getSingleResult();
        } finally {
            em.close();
        }
    }

}
