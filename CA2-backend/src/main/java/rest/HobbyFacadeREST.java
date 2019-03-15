/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import data.HobbyFacade;
import dto.HobbyDTO;
import entity.Hobby;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author caspe
 */
@Stateless
@Path("hobby")
public class HobbyFacadeREST {

    Gson gson = new Gson();

    HobbyFacade hf = new HobbyFacade();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2DB");

    public HobbyFacadeREST() {

    }

    public HobbyFacadeREST(EntityManagerFactory emf) {

    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllHobbies() {

        List<HobbyDTO> hdto = hf.getAllHobbiesDTO();
        //  PersonFullDTO pdto = new PersonFullDTO(p);
        return Response.ok().entity(gson.toJson(hdto)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHobbyById(@PathParam("id") int id) {
        Hobby hobby = hf.getHobbyById(id);
        return Response.ok().entity(gson.toJson(hobby)).build();
    }

}
