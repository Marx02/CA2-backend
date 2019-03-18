/* Esben Dalgaard; DECK-CS */
package data;

import entity.Address;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Esben All rights belong to respective contributors.
 */
public class PersonFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2DB");

    public PersonFacade(EntityManagerFactory emf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PersonFacade() {
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
    public void addEntityManager(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getManager() {
        return emf.createEntityManager();
    }

        public Person addPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p.getAddress());
            for(Phone ph : p.getPhoneCollection()){
                ph.setPerson(p);
                em.persist(ph);
            }
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

//    public Person getPersonByName(String name) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            Query q = em.createQuery("select c from Person c where c.firstname = :name");
//            q.setParameter("name", name);
//            return (Person) q.getResultList().get(0);
//        } finally {
//            em.close();
//        }
//    }
    public Person getPersonByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("select c from Person c where c.firstname = :name");
            q.setParameter("name", name);   
            Person p = (Person) q.getResultList().get(0);
            return getPersonById(p.getId());
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

    public Person getPersonWithAddressById(int id) {
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
            em.remove(p.getAddress());
            em.remove(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    public List<Person> getPersonsByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("select c from Person c where c.firstname = :name").setParameter("name", name);
            Query v = em.createQuery("select c from Person c where c.lastname = :name").setParameter("name", name);
            List<Person> ls = q.getResultList();
            ls.addAll(v.getResultList());
            return ls;
        } finally {
            em.close();
        }
    }

    public Person getPersonByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("select c from Person c where c.email = :email").setParameter("email", email);
            return (Person) q.getResultList().get(0);
        } finally {
            em.close();
        }
    }

    public Object getAllPersons() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT p FROM Person p").getResultList();
    }
    public int getPersonCount(){
        EntityManager em = emf.createEntityManager();
        try{
            Query q = em.createQuery("select count(e) from Person e");
            return (int) q.getSingleResult();
        }finally{
            em.close();
        }
    }
    
        public Person editPerson(Person p) {
        EntityManager em = getManager();
        Person pg = em.find(Person.class, p.getId());
        try {
            em.getTransaction().begin();
            pg.setFirstName(p.getFirstName());
            pg.setLastName(p.getLastName());
            pg.setEmail(p.getEmail());
            pg.setAddress(p.getAddress());
            //em.merge(pg);
            em.getTransaction().commit();
            //Query methode:
//            em.getTransaction().begin();
//            int id = p.getId();
//            String fname = pg.getfName();
//            String lName = pg.getlName();
//            String phone = pg.getPhone();
//            em.createQuery("UPDATE Person p SET p.fName = :fName, p.lName = :lName, p.phone = :phone  WHERE p.id = :id")
//                    .setParameter("id", id)
//                    .setParameter("fName", fname)
//                    .setParameter("lName", lName)
//                    .setParameter("phone", phone)
//                    .executeUpdate();
//            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return pg;
    }

    
}
