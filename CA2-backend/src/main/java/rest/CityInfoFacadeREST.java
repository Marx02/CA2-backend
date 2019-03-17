/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entity.CityInfo;
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
import data.CityInfoFacade;
import dto.CityInfoDTO;
import dto.PersonDTO;

/**
 *
 * @author caspe
 */
@Path("CityInfo")
public class CityInfoFacadeREST {

    Gson gson = new Gson();

    CityInfoFacade cif = new CityInfoFacade();

    @Context
    private UriInfo context;

    public CityInfoFacadeREST() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postCityInfo(String content) {
        CityInfo ci = gson.fromJson(content, CityInfo.class);
        cif.addCity(ci);
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCityInfoFromName(@PathParam("name") String name) {

        CityInfoDTO cidto = new CityInfoDTO(cif.getCityByName(name));
        return Response.ok().entity(gson.toJson(cidto)).build();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCityInfoFromID(@PathParam("id") int id) {

        CityInfo ci = cif.getCityById(id);
        return Response.ok().entity(gson.toJson(ci)).build();
    }

    @GET
    @Path("/complete/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCitiesByName(@PathParam("name") String name) {

        List<CityInfo> cil = cif.getCitiesByName(name);
        return Response.ok().entity(gson.toJson(cil)).build();
    }

    @GET
    @Path("/zip/{zip}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCityByZip(@PathParam("zip") int zip) {

        CityInfo ci = cif.getCityByZip(zip);
        return Response.ok().entity(gson.toJson(ci)).build();
    }
    
    @GET
    @Path("/person/zip/{zip}")
    public Response getPersonsByZip(@PathParam("zip") int zip) {
        List<PersonDTO> pdto = cif.getPersonsByZip(zip);
        return Response.ok().entity(gson.toJson(pdto)).build();
    }
    
        @GET
    @Path("/person/city/{city}")
    public Response getPersonsByZip(@PathParam("city") String city) {
        List<PersonDTO> pdto = cif.getPersonsByCity(city);
        return Response.ok().entity(gson.toJson(pdto)).build();
    }

    @DELETE
    @Path("/{zip}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam("zip") int zip) {
        CityInfo ci = cif.deleteCityByZip(zip);
        return Response.ok().entity(gson.toJson(ci)).build();
    }

}
