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
    
   CityInfoDTO cdto;
   String additionalinfo;
   String street;
   
    
    
    public AddressDTO(Address a){
        this.cdto = new CityInfoDTO(a.getCityinfo());
        this.street = a.getStreet();
        this.additionalinfo = a.getAdditionalinfo();
    }
    
}
