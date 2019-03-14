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
    List<Phone> phoneList;
    Address address;
    List<Hobby> hobbyList;

    public PersonDTO(Person p) {
        this.id = p.getId();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.email = p.getEmail();
        if (p.getPhoneCollection() != null) {
            for (Phone ph : p.getPhoneCollection()) {
                phoneList.add(ph);
            }
        }
        if (p.getHobbyCollection() != null) {
            for (Hobby h : hobbyList) {
                hobbyList.add(h);
            }
        }
        this.address = p.getAddress();

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

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Hobby> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Hobby> hobbyList) {
        this.hobbyList = hobbyList;
    }

}
