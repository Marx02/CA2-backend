/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Hobby;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author KimPPedersen
 */
public class HobbyFacade {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2DB");

    public EntityManager getManager() {
        return emf.createEntityManager();
    }

    public void addEntityManager(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Hobby addHobby(Hobby h) {
        EntityManager em = getManager();
        try {
            em.getTransaction().begin();
            em.persist(h);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return h;
    }

    public List<Hobby> getAllHobbys() {
        EntityManager em = getManager();
        return em.createQuery("SELECT h FROM Hobby h").getResultList();
    }

    public Hobby getHobbyById(int id) {
        EntityManager em = getManager();
        return em.find(Hobby.class, id);
    }

    public Hobby deleteHobbyById(int id) {
        EntityManager em = getManager();
        Hobby h = em.find(Hobby.class, id);
        try {
            em.getTransaction().begin();
            em.remove(h);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return h;
    }

    public Hobby editHobby(Hobby h) {
        EntityManager em = getManager();
        Hobby hh = em.find(Hobby.class, h.getId());
        System.out.println(h.getId() + " " + h.getName());
        try {
            em.getTransaction().begin();
            hh.setName(h.getName());
            hh.setDescription(h.getDescription());
            hh.setId(h.getId());
            em.getTransaction().commit();
            return hh;
        } finally {
            em.close();
        }
    }
}
