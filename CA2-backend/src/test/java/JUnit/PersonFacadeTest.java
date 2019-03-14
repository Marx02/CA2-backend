/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.constraints.AssertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import data.PersonFacade;

/**
 *
 * @author Esben
 */
public class PersonFacadeTest {
    
    public PersonFacadeTest() {
    }
    
//    @BeforeClass
//    public static void setupClass(){
//        PersonFacadeTest t1 = new PersonFacadeTest();
//        PersonFacade pf = t1.setEMF();
//        Person p = new Person("ms@stevia.com");
//        p.setLastName("Sommer");
//        p.setFirstName("Michael");
//        pf.addPerson(p);
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//    
//    @Test
//    public void addEntityManager(){
//        PersonFacade pf = new PersonFacade();
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2DB");
//        try{
//        pf.addEntityManager(emf);
//        } catch(Exception e){
//            assertTrue(false);
//        }
//        assertTrue(true);
//    }
//    @Test
//    public void addPersonTest(){
//        PersonFacade pf = setEMF();
//        Person xtra = new Person("gustaff@gmail.com");
//        xtra.setFirstName("Gustaff");
//        xtra.setLastName("Graff");
//        pf.addPerson(xtra);
//        Person p = new Person("John@hotmail.com");
//        p.setFirstName("John");
//        p.setLastName("Johnson");
//        Person tp = pf.addPerson(p);
//        assertEquals(p.getFirstName(),tp.getFirstName());
//    }
//    @Test
//    public void getPersonByNameTest(){
//        PersonFacade pf = setEMF();
//        String name = "John";
//        Person tp = pf.getPersonByName(name);
//        assertEquals(name,tp.getFirstName());
//    }
//    @Test
//    public void getPersonById(){
//        PersonFacade pf = setEMF();
//        int id = 1;
//        Person tp = pf.getPersonById(id);
//        assertEquals(tp.getFirstName(),"Michael");
//    }
//    
//    @Test
//    public void deletePersonById(){
//        PersonFacade pf = setEMF();
//        int id = 1;
//        Person tp = pf.deletePersonById(id);
//        assertEquals(id,tp.getId(),0.1);
//    }
//    @Test
//    public void getPersonsByNameTest(){
//        PersonFacade pf = setEMF();
//        String tName = "john";
//        List<Person> tList = pf.getPersonsByName(tName);
//        assertTrue(!tList.isEmpty());
//    }
//    
//    @Test
//    public void getPersonByEmail(){
//        PersonFacade pf = setEMF();
//        String tEmail = "John@hotmail.com";
//        Person p = pf.getPersonByEmail(tEmail);
//        assertEquals(tEmail,p.getEmail());
//    }
//
//    private PersonFacade setEMF(){
//        PersonFacade pf = new PersonFacade();
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2DB");
//        pf.addEntityManager(emf);
//        return pf;
//    }
    
}
