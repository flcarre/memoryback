package com.application.generateGame;

import java.util.List;

public class CardPair {

    public String icon;
    public int[] positions = new int[2];

    Utils utils = new Utils();


    public void generateCardPair(int size, List<Integer> registeredPositions) {
        this.icon = "https://picsum.photos/id/" + utils.generateRandomNumber(1084) + "/300/200";
        int firstCardPosition = getValidPosition(registeredPositions, size);
        int secondCardPosition = getValidPosition(registeredPositions, size);
        this.positions[0] = firstCardPosition;
        this.positions[1] = secondCardPosition;
    }

    private int getValidPosition( List<Integer> registeredPositions, int size) {
        Integer actualPosition = utils.generateRandomNumber(size * 2);
        boolean isActualPositionValid = !utils.contains(registeredPositions, actualPosition);
        while (!isActualPositionValid) {
            actualPosition = utils.generateRandomNumber(size * 2);
            isActualPositionValid = !utils.contains(registeredPositions, actualPosition);
        }
        registeredPositions.add(actualPosition);
        return actualPosition;
    }
}
