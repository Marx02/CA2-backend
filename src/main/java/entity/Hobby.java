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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author caspe
 */
@Entity
@Table(name = "hobby")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hobby.findAll", query = "SELECT h FROM Hobby h")
    , @NamedQuery(name = "Hobby.findById", query = "SELECT h FROM Hobby h WHERE h.id = :id")
    , @NamedQuery(name = "Hobby.findByName", query = "SELECT h FROM Hobby h WHERE h.name = :name")
    , @NamedQuery(name = "Hobby.findByDescription", query = "SELECT h FROM Hobby h WHERE h.description = :description")})
public class Hobby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 45)
    @Column(name = "name", length = 45)
    private String name;
    @Size(max = 45)
    @Column(name = "description", length = 45)
    private String description;
    @JoinTable(name = "person_has_hobby", joinColumns = {
        @JoinColumn(name = "hobby_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Person> personCollection = new ArrayList();

    public Hobby() {
    }

    public Hobby( String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    

    public Hobby(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }
    
        public void addToPersonCollection(Person p) {
        this.personCollection.add(p);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hobby)) {
            return false;
        }
        Hobby other = (Hobby) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hobby[ id=" + id + " ]";
    }
    
}
