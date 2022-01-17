package com.application.controller;

import com.application.Application;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest(classes = Application.class)
public class UpdateGameControllerTest {
    String id = "61cc1d678c1dd322b3ef1f28";

    @BeforeEach
    public void before_each() {
        given()
                .when().get("getGame?id=" + id)
                .then()
                .statusCode(200)
                .body("cards[20].isVisible", is(false),  "id", is(id));
    }

    @AfterEach
    public void after_each(){
        given().when().post("setVisibility?id=61cc1d678c1dd322b3ef1f28&position=20&value=false")
                .then()
                .statusCode(200)
                .body("cards[20].isVisible", is(false),  "id", is(id));
    }

    @Test
    public void should_update_visibility_in_db() {
        given()
                .when().post("setVisibility?id=61cc1d678c1dd322b3ef1f28&position=20&value=true")
                .then()
                .statusCode(200)
                .body("cards[20].isVisible", is(true), "id", is(id))
        ;
    }

}
