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
public class PersonContactInfoDTO {

    String firstName;
    String lastName;
    String email;
    PhoneDTO phone;

    public PersonContactInfoDTO(Person p) {
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.email = p.getEmail();
        if (p.getPhoneCollection() != null) {
            for (Phone ph : p.getPhoneCollection()) {
                this.phone = new PhoneDTO(ph);
            }
        }
    }

}
