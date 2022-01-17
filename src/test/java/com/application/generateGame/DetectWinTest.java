package com.application.generateGame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

    @DataMongoTest
    public class DetectWinTest {
        @Autowired
        private gameRepository repository;

        @Test
        public void detect_not_win_game() {
            String id = "61cc1d678c1dd322b3ef1f28";
            Optional<GenerateGame> getGame = repository.findById(id);
            GenerateGame game = getGame.get();
            game.detectWin();
            assertFalse(game.isWin);
        }

        @Test
        public void detect_win_game() {
            String id = "61e53da24efbd6668da6d9db";
            Optional<GenerateGame> getGame = repository.findById(id);
            GenerateGame game = getGame.get();
            game.detectWin();
            assertTrue(game.isWin);
        }
    }

