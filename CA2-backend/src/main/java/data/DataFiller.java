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
            df.addPersonTest();
            //df.delete();
    }
        
      void addPersonTest(){
          
//        Address a = new Address("Hundigevej 2", "2tv", cif.getCityByZip(2670));
//        Person p = new Person("kim@hotmail.dk", "Kim", "Pedersen", a);
//        a.addPerson(p);
//        
//        Hobby h = new Hobby("Dumspilning", "Kim har opnået sort bælte inde for denne disciplin");
//        p.addToHobbyCollection(h);
//        h.addToPersonCollection(p);
//        
//        Phone ph = new Phone(43434388, "Arbejde", p);
//        ph.setPerson(p);
//        p.addToPhoneCollection(ph);
//        
//        pf.addPerson(p, a);
        //pf.deletePersonById(69);
        
        Person p = pf.getPersonById(1);
          System.out.println(p.getAddress().getStreet());;
        
      }
    
      void addPersonToDB(){
          
          
          
          Person p = new Person();
          p.setEmail("dan.tomicic@gmail.com");
          p.setFirstName("Dan");
          p.setLastName("Tomicic");
          
          CityInfo ci = new CityInfo();
          ci.setZip(2900);
          ci.setCity("Lyngby");
          
          Phone pwn = new Phone();
          pwn.setNumber(23894567);
          pwn.setDescription("Privat");
          
          p.addToPhoneCollection(pwn);
          pwn.setPerson(p);
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
      

        
}
