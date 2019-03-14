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
    String address;

    public PersonSimpleDTO(Person p) {
        this.id = p.getId();
        this.fName = p.getFirstname();
        this.lName = p.getLastname();
        if (p.getPhoneCollection() != null) {
            this.phoneDTO = new PhoneDTO((Phone) p.getPhoneCollection().toArray()[0]);
        }
        this.address = p.getAddress().getStreet() + p.getAddress().getAdditionalinfo();
        this.cdto = new CityInfoDTO(p.getAddress().getCityinfo());

    }

}
