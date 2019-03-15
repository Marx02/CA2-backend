/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import data.PhoneFacade;
import dto.PersonDTO;
import dto.PhoneDTO;
import entity.Person;
import entity.Phone;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author caspe
 */
@Stateless
@Path("phone")
public class PhoneFacadeREST {

    Gson gson = new Gson();

    PhoneFacade pf = new PhoneFacade();

    public PhoneFacadeREST() {

    }

    @GET
    @Path("/number/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonFromNumber(@PathParam("number") int number) {
        
        return Response.ok().entity(gson.toJson(new PersonDTO(pf.getPersonByNumber(number)))).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllNumbers() {

        List<PhoneDTO> phoneList = pf.getAllNumbersDTO();

        return Response.ok().entity(gson.toJson(phoneList)).build();
    }

}
