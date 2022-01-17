package com.application.generateGame;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GenerateGame {

    @Id
    public String id;

    public int size;
    public List<Card> cards = new ArrayList<>(List.of());
    public List<Integer> registeredPositions = new ArrayList<>(List.of());
    public List<Integer> selectedCards = new ArrayList<>(List.of());

    public boolean isWin = false;

    public void setSize(int size) {
        this.size = size;
    }

    public void detectWin() {
        boolean isWin = true;
        for(Card card : cards) {
            if(!card.isVisible) {
                isWin = false;
                break;
            }
        }

        this.isWin = isWin;
    }

    public void isSameCard() {
        if (selectedCards.size() == 2) {
            int firstPosition = selectedCards.get(0);
            int secondPosition = selectedCards.get(1);
            Card firstCard = cards.get(firstPosition);
            Card secondCard = cards.get(secondPosition);
            if(!Objects.equals(firstCard.icon, secondCard.icon)) {
                firstCard.isVisible = false;
                secondCard.isVisible = false;
                cards.set(firstPosition, firstCard);
                cards.set(secondPosition, secondCard);
            }
        }
    }

    public void addPairOfCards(String icon,  int[] positions) {
        Card firstCard = new Card();
        firstCard.setIcon(icon);
        firstCard.setPosition(positions[0]);
        Card secondCard = new Card();
        secondCard.setIcon(icon);
        secondCard.setPosition(positions[1]);
        cards.addAll(Arrays.asList(firstCard, secondCard));
    }

    public GenerateGame (int size) {
        CardPair cardPair = new CardPair();
        setSize(size);

        for (int i = 0; i < size; i++) {
            cardPair.generateCardPair(size, registeredPositions);
            addPairOfCards(cardPair.icon, cardPair.positions);
        }
    }

}
