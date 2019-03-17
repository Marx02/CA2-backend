/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import entity.Address;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import data.AddressFacade;

/**
 *
 * @author Esben
 */
public class AddressFacadeTest {

    public AddressFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        AddressFacadeTest t1 = new AddressFacadeTest();
        AddressFacade db = t1.setEMF();
        Address tA = new Address();
        tA.setStreet("Bowlerstreet 10");
        tA.setAdditionalinfo("Beyond the scope of mere immortals!");
        Address retA = db.addAddress(tA);
    }

    @AfterClass
    public static void tearDownClass() {
        AddressFacadeTest t1 = new AddressFacadeTest();
        AddressFacade db = t1.setEMF();
        Address tA = new Address();
        String street2 = "Bowlerstreet 8";
        Address tA3 = db.getAddressByStreet(street2);
        Address tA4 = db.deleteAddressById(tA3.getId());
    }

    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void addAdressTest(){
        AddressFacade db = setEMF();
        Address tA = new Address();
        tA.setStreet("Bowlerstreet 8");
        tA.setAdditionalinfo("Beyond the scope of mere mortals!");
        Address retA = db.addAddress(tA);
        assertEquals(retA.getStreet(),tA.getStreet());
    }

    @Test
    public void getPersonsByAddressTest() {
        AddressFacade db = setEMF();
        
    }

    @Test
    public void getAddressByStreetTest() {
        AddressFacade db = setEMF();
        String street = "Bowlerstreet 10";
        Address tA = db.getAddressByStreet(street);
        assertEquals(tA.getStreet(),street);
    }

    @Test
    public void getAddressByIdTest() {
        AddressFacade db = setEMF();
        int tID = 1;
        Address tA = db.getAddressById(tID);
        assertEquals(tA.getId(),tID,0.1);
        
    }
    
    @Test
    public void deleteAddressByIdTest(){
        AddressFacade db = setEMF();
        String street = "Bowlerstreet 10";
        Address tA = db.getAddressByStreet(street);
        Address tA2 = db.deleteAddressById(tA.getId());
        
        assertEquals(tA.getStreet(),tA2.getStreet());
    }

    private AddressFacade setEMF() {
        AddressFacade db = new AddressFacade();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2DB");
        db.addEntityManager(emf);
        return db;
    }

}


