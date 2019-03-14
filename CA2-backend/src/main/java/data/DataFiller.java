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
            //df.addPersonToDB();
            df.delete();
    }
    
      void addPersonToDB(){
          
          Person p = new Person();
          p.setEmail("dan.tomicic@gmail.com");
          p.setFirstname("Dan");
          p.setLastname("Tomicic");
          
          CityInfo ci = cif.getCityByZip(2900);
          
          Hobby h = new Hobby();
          h.setName("Pwning n00bs");
          h.setDescription("ez");
          hf.addHobby(h);
          p.addToHobbyCollection(h);
          Address a = new Address();
          a.setCityinfo(ci);
          a.setStreet("Hyggevej 25");
          a.setAdditionalinfo("3th");
          af.addAddress(a);
          p.setAddress(a);
          
          Phone ph = new Phone();
          ph.setNumber(21861590);
          ph.setPerson(p);
          pf.addPerson(p);
          
          
      }
      
      private void delete(){
          System.out.println(pf.deletePersonById(2).getFirstname());
          
      }
        
}
