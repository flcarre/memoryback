package com.application.generateGame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class updateVisibilityTest {
    @Autowired
    private gameRepository repository;

    @Test
    public void updateVisibilityFromDB() {
        String id = "61cc1d678c1dd322b3ef1f28";
        int position = 20;
        Optional<GenerateGame> getGame = repository.findById(id);
        GenerateGame game = getGame.get();
        new updateVisibility(game, position, true);
        Card modifiedCard = game.cards.get(position);
        assertTrue(modifiedCard.isVisible);
    }
}
