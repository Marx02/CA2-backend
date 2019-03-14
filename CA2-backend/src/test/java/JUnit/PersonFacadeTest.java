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
import exceptions.CustomerNotFoundException;
import org.junit.AfterClass;

/**
 *
 * @author Esben
 */
public class PersonFacadeTest {
    
    public PersonFacadeTest() {
    }
    
    @BeforeClass
    public static void setupClass(){
        PersonFacadeTest t1 = new PersonFacadeTest();
        PersonFacade pf = t1.setEMF();
        Person p = new Person();
        p.setEmail("ms@stevia.com");
        p.setLastName("Sommer");
        p.setFirstName("Michael");
        pf.addPerson(p);
        Person p2 = new Person();
        p2.setEmail("jim@raynor.com");
        p2.setLastName("Jim");
        p2.setFirstName("Raynor");
        pf.addPerson(p2);
    }
    
    @AfterClass
    public static void tearDownClass() throws CustomerNotFoundException {
        PersonFacadeTest t1 = new PersonFacadeTest();
        PersonFacade pf = t1.setEMF();
        String name = "Raynor";
        Person tp = pf.getPersonByName(name);
        int id = tp.getId();
        Person tp1 = pf.deletePersonById(id);
        String name2 = "John";
        Person tp2 = pf.getPersonByName(name2);
        int id2 = tp2.getId();
        pf.deletePersonById(id2);
    }
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addEntityManager(){
        PersonFacade pf = new PersonFacade();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2DB");
        try{
        pf.addEntityManager(emf);
        } catch(Exception e){
            assertTrue(false);
        }
        assertTrue(true);
    }
    @Test
    public void addPersonTest(){
        PersonFacade pf = setEMF();
        Person p = new Person();
        p.setEmail("John@hotmail.com");
        p.setFirstName("John");
        p.setLastName("Johnson");
        Person tp = pf.addPerson(p);
        assertEquals(p.getFirstName(),tp.getFirstName());
    }
    @Test
    public void getPersonByNameTest(){
        PersonFacade pf = setEMF();
        String name = "John";
        Person tp = pf.getPersonByName(name);
        assertEquals(name,tp.getFirstName());
    }
    @Test
    public void getPersonById(){
        PersonFacade pf = setEMF();
        String name = "Jim";
        List<Person> tp = pf.getPersonsByName(name);
        int id = tp.get(0).getId();
        System.out.println(id);
        Person tp1 = pf.getPersonById(id);
        assertEquals(tp1.getFirstName(),"Raynor");
    }
    
    @Test
    public void deletePersonById() throws CustomerNotFoundException{
        PersonFacade pf = setEMF();
        String name = "Michael";
        Person tp = pf.getPersonByName(name);
        int id = tp.getId();
        Person tp1 = pf.deletePersonById(id);
        assertEquals(id,tp.getId(),0.1);
    }
    @Test
    public void getPersonsByNameTest(){
        PersonFacade pf = setEMF();
        String tName = "jim";
        List<Person> tList = pf.getPersonsByName(tName);
        assertTrue(!tList.isEmpty());
    }
    
    @Test
    public void getPersonByEmail(){
        PersonFacade pf = setEMF();
        String tEmail = "jim@raynor.com";
        Person p = pf.getPersonByEmail(tEmail);
        assertEquals(tEmail,p.getEmail());
    }

    private PersonFacade setEMF(){
        PersonFacade pf = new PersonFacade();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2DB");
        pf.addEntityManager(emf);
        return pf;
    }
    
}
