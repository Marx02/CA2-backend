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
    
   CityInfoDTO cityInfo;
   String additionalInfo;
   String street;
   
    
    
    public AddressDTO(Address a){
        this.cityInfo = new CityInfoDTO(a.getCityinfo());
        this.street = a.getStreet();
        this.additionalInfo = a.getAdditionalinfo();
    }
}
