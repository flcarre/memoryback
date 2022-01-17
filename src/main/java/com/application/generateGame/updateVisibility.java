package com.application.generateGame;

import java.util.ArrayList;

public class updateVisibility {
    public updateVisibility (GenerateGame actualGame, int position, boolean value) {
        ArrayList<Card> Cards = (ArrayList<Card>) actualGame.cards;
        Card modifiedCard = Cards.get(position);
        modifiedCard.setVisible(value);
        Cards.set(position, modifiedCard);
    }
}
