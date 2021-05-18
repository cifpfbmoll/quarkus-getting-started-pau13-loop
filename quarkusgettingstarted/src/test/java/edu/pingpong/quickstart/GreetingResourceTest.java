package edu.pingpong.quickstart;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import edu.pingpong.quickstart.domain.Erudite;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testGetHello() {
        given()
        .when().get("/hello")
            .then()
            .statusCode(200)
            .body(is("Aloha Quarkus"));
    }

    @Test
    public void testGetWelcome() {
        given()
        .when().get("/hello/welcome/Lily")
        .then()
        .statusCode(200)
        .body(is("Welcome to the Ethernal Questions Lily"));
    }

    @Test
    public void testGetQuestion() {
        given()
        .when().get("/hello/question")
        .then()
        .statusCode(200)
        .body(is("We accept the love we think we deserve ?"));
    }

    @Test
    public void testGetErudite() {
        given()
        .when().get("/hello/erudite")
        .then()
        .statusCode(200)
        .assertThat()
        .body("name", equalTo("Einstein"))
        .body("quote", equalTo("Try not to become a man of success, but rather try to become a man of value"))
        .body("bornDate", equalTo("1879-05-14"));
    }

    @Test
    public void testPostErudite() {
        
        Erudite erudite = new Erudite("Gandhi", "A man is but a product of his thoughts. What he thinks he becomes", LocalDate.of(1948, 01, 30));
        
        given()
        .contentType("application/json")
        .body(erudite)
            .when()
            .post("/hello/erudite")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("Gandhi"))
                .body("quote", equalTo("A man is but a product of his thoughts. What he thinks he becomes"))
                .body("bornDate", equalTo("1948-01-30"));
    }
}