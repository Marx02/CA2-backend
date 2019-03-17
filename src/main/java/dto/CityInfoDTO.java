/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.CityInfo;

/**
 *
 * @author uber
 */
public class CityInfoDTO {
    
    int zip;
    String city;

    public CityInfoDTO(CityInfo ci) {
        this.city = ci.getCity();
        this.zip = ci.getZip();
    }
    
    
    
}
