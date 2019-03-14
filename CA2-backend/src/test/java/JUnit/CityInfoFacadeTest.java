/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import entity.Address;
import entity.CityInfo;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import data.CityInfoFacade;

/**
 *
 * @author Esben
 */
public class CityInfoFacadeTest {

    public CityInfoFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        CityInfoFacadeTest t1 = new CityInfoFacadeTest();
        CityInfoFacade db = t1.setEMF();
        CityInfo city = new CityInfo(2900);
        city.setCity("Hellerup");
        try {
            db.addCity(city);
        } catch (Exception e) {

        }
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addCityTest() {
        CityInfoFacade db = setEMF();
        CityInfo city = new CityInfo(8600);
        city.setCity("Silkeborg");
//        Address adr = new Address();
//        adr.setStreet("Nygade");
//        city.addAddress(adr);
        CityInfo tc = db.addCity(city);
        assertEquals(tc.getCity(), city.getCity());
    }

    @Test
    public void getCityByNameTest() {
        CityInfoFacade db = setEMF();
        String ntest = db.getCityByName("Hellerup").getCity();
        String teststring = "Hellerup";
        assertEquals(ntest, teststring);
    }

    @Test
    public void getCityByIdTest() {
        int id = 1;
        CityInfoFacade db = setEMF();
        String name = db.getCityById(id).getCity();
        String rname = "Hellerup";
        assertEquals(name, rname);
    }

    @Test
    public void getCityByZipTest() {
        CityInfoFacade db = setEMF();
        int zip = 2900;
        CityInfo city = db.getCityByZip(2900);
        assertEquals(zip, city.getZip(), 0.1);
    }

//    @Test
//    public void deleteCityByIdTest() {
//        int id = 1;
//        CityInfoFacade db = setEMF();
//        CityInfo tp = db.deleteCityById(id);
//        assertEquals(id, tp.getId(), 0.1);
//        assertTrue(true);
//    }
    private CityInfoFacade setEMF() {
        CityInfoFacade db = new CityInfoFacade();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2DB");
        return db;
    }

}
