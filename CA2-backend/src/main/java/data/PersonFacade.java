/* Esben Dalgaard; DECK-CS */
package data;

import entity.Hobby;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * @author Esben All rights belong to respective contributors.
 */
public class PersonFacade {

    private EntityManagerFactory emf;

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
    public void addEntityManager(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Person addPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    public Person getPersonByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("select c from Person c where c.firstName = :name").setParameter("name", name);
            return (Person) q.getResultList().get(0);
        } finally {
            em.close();
        }
    }

    public Person getPersonById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Person p = em.find(Person.class, (Integer) id);
            return p;
        } finally {
            em.close();
        }
    }

    public Person deletePersonById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Person p = em.find(Person.class, (Integer) id);
            em.remove(p);
            return p;
        } finally {
            em.close();
        }
    }

    public List<Person> getPersonsByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("select c from Person c where c.firstName = :name").setParameter("name", name);
            Query v = em.createQuery("select c from Person c where c.lastName = :name").setParameter("name", name);
            List<Person> ls = q.getResultList();
            ls.addAll(v.getResultList());
            return ls;
        }finally{
            em.close();
        }
    }

    public Person getPersonByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("select c from Person c where c.email = :email").setParameter("email", email);
            return (Person) q.getResultList().get(0);
        }finally{
            em.close();
        }
    }
}
