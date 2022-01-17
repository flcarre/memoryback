package com.application.controller;

import com.application.generateGame.Card;
import com.application.generateGame.GenerateGame;
import com.application.generateGame.gameRepository;
import com.application.generateGame.updateVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UpdateGameController {
    @Autowired
    private gameRepository repository;

    @PostMapping("/setVisibility")
    public GenerateGame updateVisibility(@RequestParam(value = "id") String id,
                                         @RequestParam(value = "position") int position,
                                         @RequestParam(value = "value") boolean value) {
        Optional<GenerateGame> getGame = repository.findById(id);
        GenerateGame game = getGame.get();
        new updateVisibility(game, position, value);

        game.detectWin();

        repository.save(game);

        return game;
    }
}
