package com.application.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.given;

@SpringBootTest
public class DefaultControllerTest {

    @Test
    public void should_get_hello_on_request() {
        given()
                .when().get("hello")
                .then()
                .statusCode(200)
                .body(is("hello"));
    }
}
