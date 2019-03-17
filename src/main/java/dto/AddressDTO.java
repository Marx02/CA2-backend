/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Address;

/**
 *
 * @author uber
 */
public class AddressDTO {

    String additionalinfo;
    String street;
    int zip;
    String city;

    public AddressDTO(Address a) {
        this.street = a.getStreet();
        this.additionalinfo = a.getAdditionalinfo();
        this.zip = a.getCityinfo().getZip();
        this.city = a.getCityinfo().getCity();
    }
}
