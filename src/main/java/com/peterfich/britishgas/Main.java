package com.peterfich.britishgas;

import java.util.Optional;

public class Main {
    public Optional<Integer> indexOf(int[] mainArray, int[] subArray) {
        if (mainArray == null || subArray == null) {
            throw new IllegalArgumentException();
        }

        if (mainArray.length == 0 || subArray.length == 0) {
            return Optional.empty();
        }

        for (int mainIndex = 0; mainIndex < (mainArray.length - subArray.length + 1); mainIndex++) {
            if (mainArray[mainIndex] == subArray[0]) {
                for (int subIndex = 0; subIndex < subArray.length; subIndex++) {
                    if (mainArray[mainIndex + subIndex] != subArray[subIndex]) {
                        break;
                    }
                }
                return Optional.of(mainIndex);
            }
        }
        return Optional.empty();
    }
}
