package com.application.generateGame;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface gameRepository extends MongoRepository<GenerateGame, String> {
}
