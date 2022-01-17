package com.application.generateGame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataMongoTest
public class IsSameCardTest {
    @Autowired
    private gameRepository repository;

    @Test
    public void detect_same_card() {
        String id = "61cc1d678c1dd322b3ef1f28";
        Optional<GenerateGame> getGame = repository.findById(id);
        GenerateGame game = getGame.get();
        int firstCard = 1;
        int secondCard = 0;
        game.selectedCards.add(firstCard);
        game.selectedCards.add(secondCard);
        new updateVisibility(game, firstCard, true);
        new updateVisibility(game, secondCard, true);
        game.isSameCard();
        Card firstGameCard = game.cards.get(firstCard);
        Card secondGameCard = game.cards.get(secondCard);
        assertTrue(firstGameCard.isVisible);
        assertTrue(secondGameCard.isVisible);
    }

    @Test
    public void detect_different_card() {
        String id = "61cc1d678c1dd322b3ef1f28";
        Optional<GenerateGame> getGame = repository.findById(id);
        GenerateGame game = getGame.get();
        int firstCard = 1;
        int secondCard = 2;
        game.selectedCards.add(firstCard);
        game.selectedCards.add(secondCard);
        game.isSameCard();
        Card firstGameCard = game.cards.get(firstCard);
        Card secondGameCard = game.cards.get(secondCard);
        assertFalse(firstGameCard.isVisible);
        assertFalse(secondGameCard.isVisible);
    }
}
