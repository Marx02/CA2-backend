/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Address;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caspe
 */
public class PersonDTO {

    int id;
    String firstName;
    String lastName;
    String email;
    ArrayList<PhoneDTO> phoneList = new ArrayList();
    AddressDTO address;
    ArrayList<HobbyDTO> hobbyList = new ArrayList();

    public PersonDTO(Person p) {
        this.id = p.getId();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.email = p.getEmail();
        if (p.getPhoneCollection() != null) {
            for (Phone ph : p.getPhoneCollection()) {
                this.phoneList.add(new PhoneDTO(ph));
            }
        }
        if (p.getHobbyCollection() != null) {
            for (Hobby h : p.getHobbyCollection()) {
                this.hobbyList.add(new HobbyDTO(h));
            }
        }
        this.address = new AddressDTO(p.getAddress());
    }

    public PersonDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<PhoneDTO> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(ArrayList<PhoneDTO> phoneList) {
        this.phoneList = phoneList;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public ArrayList<HobbyDTO> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(ArrayList<HobbyDTO> hobbyList) {
        this.hobbyList = hobbyList;
    }

}