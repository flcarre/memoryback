package com.application.generateGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CardPairTest {
    CardPair cardPair = new CardPair();
    List<Integer> registeredPositions = new ArrayList<>(List.of());

    @BeforeEach
    public void beforeEach() {
        registeredPositions = new ArrayList<>(List.of());
    }

    @Test
    public void card_should_have_string_in_icon_field() {
        cardPair.generateCardPair(2, registeredPositions );

        assertNotNull(cardPair.icon);
    }

    @Test
    public void should_have_2_different_position() {
        cardPair.generateCardPair(2, registeredPositions );

        assertNotEquals(cardPair.positions[0], cardPair.positions[1]);
    }

    @Test
    public void should_return_valid_position_and_add_the_new_position_to_registered_positions() {
        registeredPositions = new ArrayList<>(List.of(0, 1));
        cardPair.generateCardPair(2, registeredPositions );

        assertTrue(cardPair.positions[0] == 2 || cardPair.positions[0] == 3);
        assertTrue(cardPair.positions[1] == 2 || cardPair.positions[1] == 3);
        assertTrue(registeredPositions.equals(new ArrayList<>(List.of(0, 1, 2, 3))) || registeredPositions.equals(new ArrayList<>(List.of(0, 1, 3, 2))));
    }
}
