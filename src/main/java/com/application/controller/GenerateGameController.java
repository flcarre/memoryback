package com.application.controller;

import com.application.generateGame.GenerateGame;
import com.application.generateGame.gameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GenerateGameController  {
    @Autowired
    private gameRepository repository;

    @GetMapping("/newGame")
    public GenerateGame newGame(@RequestParam(value = "size", defaultValue = "10") int size) {
        GenerateGame game = new GenerateGame(size);

        repository.save(game);
        return game;
    }

    @GetMapping("/getGame")
    public Optional<GenerateGame> getGame(@RequestParam(value = "id") String id) {
        return repository.findById(id);
    }
}
