/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import data.PersonFacade;
import entity.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author caspe
 */
@Path("person")
public class PersonFacadeREST {

    Gson gson = new Gson();
    PersonFacade pf = new PersonFacade();
    @Context
    private UriInfo context;

    public PersonFacadeREST() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() {
        
        return Response.ok().entity(gson.toJson(pf.getAllPersons())).build();
    }
    
//    @GET
//    @Path("/complete")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAllPerson(@PathParam("id") int id) {
//        TODO return proper representation object
//        return Response.ok().entity(gson.toJson(dbf.g).build();
//    }
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonFromID(@PathParam("id") int id) {

        Person p = pf.getPersonById(id);
        //  PersonFullDTO pdto = new PersonFullDTO(p);
        return Response.ok().entity(gson.toJson(p)).build();
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonFromName(@PathParam("name") String name) {

        Person p = pf.getPersonByName(name);
        System.out.println(p);
        //  PersonFullDTO pdto = new PersonFullDTO(p);
        return Response.ok().entity(gson.toJson(p)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postPerson(String content) {
        Person p = gson.fromJson(content, Person.class);
        pf.addPerson(p);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam("id") int id) {
        Person p = pf.deletePersonById(id);
        return Response.ok().entity(gson.toJson(p)).build();
    }

}
