/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.CityInfoFacade;
import data.PersonFacade;
import entity.CityInfo;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author caspe
 */
public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2DB");
        CityInfoFacade facade = new CityInfoFacade(emf);
//        Employee emp = facade.createEmployee("hej", "med", "dig", "du", "er sej", "1");
//        System.out.println(emp.getFirstName()+","+emp.getEmployeeNumber());

        CityInfo emp = facade.getCityById(1);
            System.out.println(emp);
    }
}
