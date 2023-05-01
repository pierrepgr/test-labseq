package com.labseq.api.resource;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LabSeqResourceTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = this.port;
        RestAssured.basePath = "/api/labseq/";
    }

    @Test
    void shouldReturnStatus200WhenLabSeqIsCalculated() {
        var response = given()
                .header("Content-Type", "application/json")
                .accept(ContentType.JSON)
            .when()
                .get("/" + 10)
            .then()
                .extract().response();

        assertEquals(200, response.getStatusCode());
        assertEquals("3", response.getBody().print());
    }
}
