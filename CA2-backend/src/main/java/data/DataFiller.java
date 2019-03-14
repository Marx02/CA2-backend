/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import entity.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Lenovo
 */
public class DataFiller {
        
        PersonFacade pf = new PersonFacade();
        HobbyFacade hf = new HobbyFacade();
        CityInfoFacade cif = new CityInfoFacade();
        AddressFacade af = new AddressFacade();
        PhoneFacade phf = new PhoneFacade();
        
        public static void main(String[] args) {
            DataFiller df = new DataFiller();
            df.addPersonToDB();
            //df.delete();
    }
    
      void addPersonToDB(){
          
          
          
          Person p = new Person();
          p.setEmail("dan.tomicic@gmail.com");
          p.setFirstname("Dan");
          p.setLastname("Tomicic");
          
          CityInfo ci = new CityInfo();
          ci.setZip(2900);
          ci.setCity("Lyngby");
          
          Hobby h = new Hobby();
          h.setName("Pwning n00bs");
          h.setDescription("ez");
          h.addToPersonCollection(p);
          p.addToHobbyCollection(h);
//          p.addToHobbyCollection(h);
          
          Address a = new Address();
 
          a.setStreet("Hyggevej 25");
          a.setAdditionalinfo("3th");
          a.addPerson(p);
          ci.addAddress(a);
          a.setCityinfo(ci);
          p.setAddress(a);
          cif.addCity(ci);
//          System.out.println(p2.getHobbyCollection());
          
         // Person ptest = new Person("kim@hotmail.dk", "Kim", "Pedersen", Address address);
          
      }
      
      private void delete(){
          System.out.println(pf.deletePersonById(2).getFirstname());
          
      }
        
}
