/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Hobby;
import entity.Person;
import entity.Phone;

/**
 *
 * @author Lenovo
 */
public class PersonSimpleDTO {

    int id;
    String fName;
    String lName;
    PhoneDTO phdto;
    CityInfoDTO cdto;
    PhoneDTO phoneDTO;
    AddressDTO adto;

    public PersonSimpleDTO(Person p) {
        this.id = p.getId();
        this.fName = p.getFirstName();
        this.lName = p.getLastName();
        if (p.getPhoneCollection() != null) {
            for (Phone ph : p.getPhoneCollection()) {
                this.phoneDTO = new PhoneDTO(ph);
            }
        }
        this.adto = new AddressDTO(p.getAddress());

    }

}
