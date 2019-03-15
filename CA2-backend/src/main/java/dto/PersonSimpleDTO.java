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
    String email;
    int zipDTO;
    String cityDTO;
    HobbyDTO hobbyDTO;

    public PersonSimpleDTO(Person p) {
        this.id = p.getId();
        this.fName = p.getFirstName();
        this.lName = p.getLastName();
        if (p.getPhoneCollection() != null) {
            for (Phone ph : p.getPhoneCollection()) {
                this.phoneDTO = new PhoneDTO(ph);
            }
        }else{
            Phone ph = new Phone();
            ph.setNumber(0);
            ph.setDescription("N/A");
            this.phoneDTO = new PhoneDTO(ph);
        }
        this.email = p.getEmail();
        this.adto = new AddressDTO(p.getAddress());
        this.zipDTO = p.getAddress().getCityinfo().getZip();
        this.cityDTO = p.getAddress().getCityinfo().getCity();
        if (p.getHobbyCollection() != null) {
            for (Hobby h : p.getHobbyCollection()) {
                this.hobbyDTO = new HobbyDTO(h);
            }
        }else{
            Hobby ho = new Hobby();
            ho.setName("N/A");
            ho.setId(0);
            ho.setDescription("N/A");
            this.hobbyDTO = new HobbyDTO(ho);
        }
    }

}
