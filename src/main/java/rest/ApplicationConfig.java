/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author caspe
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(filter.CorsFilter.class);
        resources.add(filter.CorsRequestFilter.class);
        resources.add(rest.AddressFacadeREST.class);
        resources.add(rest.CityInfoFacadeREST.class);
        resources.add(rest.HobbyFacadeREST.class);
        resources.add(rest.PersonFacadeREST.class);
        resources.add(rest.PhoneFacadeREST.class);
    }
    
}
