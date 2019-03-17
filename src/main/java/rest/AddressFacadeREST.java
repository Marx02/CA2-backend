/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import data.AddressFacade;
import dto.AddressDTO;
import entity.CityInfo;
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
@Path("address")
public class AddressFacadeREST {

    @Context
    private UriInfo context;

    Gson gson = new Gson();
    AddressFacade af = new AddressFacade();

    //@PersistenceContext(unitName = "CA2DB")
    private EntityManager em;

    public AddressFacadeREST() {
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCityInfoFromName(@PathParam("name") String name) {

        AddressDTO cidto = new AddressDTO(af.getAddressByStreet(name));
        return Response.ok().entity(gson.toJson(cidto)).build();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCityInfoFromID(@PathParam("id") int id) {
                
        AddressDTO ci = new AddressDTO(af.getAddressById(id));
        return Response.ok().entity(gson.toJson(ci)).build();
    }

}
