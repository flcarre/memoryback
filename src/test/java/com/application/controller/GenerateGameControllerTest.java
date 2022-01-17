package com.application.controller;

import com.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@SpringBootTest(classes = Application.class)
public class GenerateGameControllerTest {

    @Test
    public void should_generate_game() {
        int size = 20;

        given()
                .when().get("newGame?size=20")
                    .then()
                    .statusCode(200)
                    .body("size", is(size), "cards[39].isVisible", is(false), "id", is(notNullValue()));
    }

    @Test
    public void should_get_game_id_in_db() {
        String id = "61cc1d678c1dd322b3ef1f28";
        int size = 20;

        given()
                .when().get("getGame?id=" + id)
                .then()
                .statusCode(200)
                .body("size", is(size), "cards[39].isVisible", is(false), "id", is(id));
    }
}
