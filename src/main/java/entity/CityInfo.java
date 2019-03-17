/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author caspe
 */
@Entity
@Table(name = "CITYINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cityinfo.findAll", query = "SELECT c FROM CityInfo c")
    , @NamedQuery(name = "Cityinfo.findByZip", query = "SELECT c FROM CityInfo c WHERE c.zip = :zip")
    , @NamedQuery(name = "Cityinfo.findByCity", query = "SELECT c FROM CityInfo c WHERE c.city = :city")})
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "zip", nullable = false)
    private Integer zip;
    @Size(max = 45)
    @Column(name = "city", length = 45)
    private String city;
    @OneToMany(mappedBy = "cityinfo",cascade = CascadeType.ALL)
    @JoinColumn(name = "address_zip", referencedColumnName = "zip")
    private Collection<Address> addressCollection = new ArrayList();

    public CityInfo() {
    }

    public CityInfo(Integer zip) {
        this.zip = zip;
    }

    public CityInfo(Integer zip, String city) {
        this.zip = zip;
        this.city = city;
    }
  
    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }
    public void setAddressCollection(Collection<Address> a){
        this.addressCollection= a;
    }
    
    public void addAddress(Address a){
        this.addressCollection.add(a);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zip != null ? zip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityInfo)) {
            return false;
        }
        CityInfo other = (CityInfo) object;
        if ((this.zip == null && other.zip != null) || (this.zip != null && !this.zip.equals(other.zip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cityinfo[ zip=" + zip + " ]";
    }
    
}
