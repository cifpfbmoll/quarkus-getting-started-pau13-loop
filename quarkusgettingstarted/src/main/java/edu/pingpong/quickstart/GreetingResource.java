package edu.pingpong.quickstart;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Carrefull with the path param you import don't get the wrong one --> javas.ws.rs.PathParam
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import edu.pingpong.quickstart.service.GreetingService;

@Path("/hello")
public class GreetingResource {

    // curl -w "\n" ---> Automatically add newline
    // -v ---> verbose mode

    @Inject
    GreetingService service;

    // curl -v -w "/n" http://localhost:8080/hello/welcome/Lily
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/welcome/{name}")
    public String greeting(@PathParam String name) {
        return service.greeting(name);
    }

    // curl -v -w "\n" http://localhost:8080/hello
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Aloha Quarkus";
    }
}