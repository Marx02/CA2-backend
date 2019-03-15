/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Person;
import entity.Phone;

/**
 *
 * @author caspe
 */
public class PhoneDTO {

    int number;
    String description;
    //Person person;

    public PhoneDTO(Phone phone) {
        this.number = phone.getNumber();
        this.description = phone.getDescription();
        //this.person = phone.getPerson();
    }

//    public PhoneDTO(Phone personByPhone) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    PhoneDTO(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
