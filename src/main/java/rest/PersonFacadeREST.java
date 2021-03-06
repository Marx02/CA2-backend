/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import data.PersonFacade;
import dto.PersonContactInfoDTO;
import dto.PersonDTO;
import dto.PersonSimpleDTO;
import entity.Address;
import entity.Hobby;
import entity.Person;
import java.util.ArrayList;
import java.util.Collection;
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
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() {
        ArrayList<PersonDTO> plist = new ArrayList();
        for (Person p : (Collection<Person>) pf.getAllPersons()) {
            plist.add(new PersonDTO(p));
        }
        return Response.ok().entity(gson.toJson(plist)).build();
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
        PersonDTO pdto = new PersonDTO(pf.getPersonById(id));
        return Response.ok().entity(gson.toJson(pdto)).build();
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonFromName(@PathParam("name") String name) {
        List<PersonDTO> pList = new ArrayList();
        for(Person p : pf.getPersonsByName(name)){
            pList.add(new PersonDTO(p));
        }
        return Response.ok().entity(gson.toJson(pList)).build();
    }

    @GET
    @Path("/contactinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContactInfo() {
        ArrayList<PersonContactInfoDTO> cList = new ArrayList();
        for (Person p : (Collection<Person>) pf.getAllPersons()) {
            cList.add(new PersonContactInfoDTO(p));
        }
        return Response.ok().entity(gson.toJson(cList)).build();
    }

    @GET
    @Path("/contactinfo/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContactInfoById(@PathParam("id") int id) {
        PersonContactInfoDTO pcidto = new PersonContactInfoDTO(pf.getPersonById(id));
        return Response.ok().entity(gson.toJson(pcidto)).build();
    }
    
    @GET
    @Path("/contactinfo/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContactInfoByName(@PathParam("name") String name){
        PersonContactInfoDTO pcidto = new PersonContactInfoDTO(pf.getPersonByName(name));
        return Response.ok().entity(gson.toJson(pcidto)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postPerson(String content) {
        Person p = gson.fromJson(content, Person.class);
        pf.addPerson(p);
        return Response.ok().entity(gson.toJson(new PersonDTO(p))).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putPerson(String content) {
        Person p = gson.fromJson(content, Person.class);
        pf.editPerson(p);
        return Response.ok().entity(gson.toJson(new PersonDTO(p))).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("id") int id) {
        Person p = pf.deletePersonById(id);
        return Response.ok().entity(gson.toJson(new PersonDTO(p))).build();
    }
}
