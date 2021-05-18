package edu.pingpong.quickstart;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Aloha Quarkus"));
    }

    @Test
    public void testWelcome() {
        given()
        .when().get("/hello/welcome/Lily")
        .then()
        .body(is("Welcome to the Ethernal Questions Lily"));
    }

    @Test
    public void testQuestion() {
        given()
        .when().get("/hello/question")
        .then()
        .body(is("We accept the love we think we deserve ?"));
    }
}