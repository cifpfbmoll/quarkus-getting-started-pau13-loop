package edu.pingpong.quickstart;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// Carrefull with the path param you import don't get the wrong one --> javas.ws.rs.PathParam
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import edu.pingpong.quickstart.domain.Erudite;
import edu.pingpong.quickstart.service.GreetingService;
import edu.pingpong.quickstart.service.QuestionService;

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

    // The injection must be implemented right on top of the method where we want to
    // use it
    @Inject
    QuestionService question;

    // curl -v -w "\n" http://localhost:8080/hello/question
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/question")
    public String getRandomQuestion() {
        return question.randomQuestion();
    }

    // RETURN JSON
    // curl -v -w "\n" http://localhost:8080/hello/erudite
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/erudite")
    public Erudite getErudite() {
        return new Erudite("Einstein", "Try not to become a man of success, but rather try to become a man of value", LocalDate.of(1879, 05, 14));
    }

    // Validation not working like desired
    // curl -H "Content-Type:application/json" -X POST http://localhost:8080/hello/erudite -v -d "{\"name\":\"Einsten\", \"quote\":\"Try not to\", \"bornDate\":\"1879-05-14\"}" 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/erudite")
    public Response createErudite(@Valid Erudite erudite) {
        // We should or we shouldn't add erudite into ok() to be able to test the post method ? 
        return Response.ok(erudite).build();
    }

    // curl -v -w "\n" http://localhost:8080/hello
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Aloha Quarkus";
    }
}