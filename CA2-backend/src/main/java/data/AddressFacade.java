/* Esben Dalgaard; DECK-CS */
package data;

import entity.Address;
import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Esben All rights belong to respective contributors.
 */
public class AddressFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2DB");

    public void addEntityManager(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Address addAddress(Address a) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            return a;
        } finally {
            em.close();
        }
    }

    public Address getAddressByStreet(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("select c from Address c where c.street = :name").setParameter("name", name);
            return (Address) q.getResultList().get(0);
        } finally {
            em.close();
        }
    }

    public Address getAddressById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Address p = em.find(Address.class, (Integer) id);
            return p;
        } finally {
            em.close();
        }
    }

    public Address deleteAddressById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Address a = em.find(Address.class, id);
            em.remove(a);
            em.getTransaction().commit();
            return a;
        } finally {
            em.close();
        }
    }

}
