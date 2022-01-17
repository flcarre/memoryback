package com.application.generateGame;

import java.util.List;
import java.util.Random;

public class Utils {

    public int generateRandomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public boolean contains(List<Integer> testedArray, int value) {
        if(testedArray.size() == 0) return false;
        for (Integer integer : testedArray) if (integer == value) return true;
        return false;
    }
}
