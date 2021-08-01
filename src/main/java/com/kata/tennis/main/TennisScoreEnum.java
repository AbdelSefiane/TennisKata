package com.kata.tennis.main;

import java.util.Arrays;

public enum TennisScoreEnum {


    LOVE("Love", 0),

    FIFTEEN("Fifteen", 15),

    THIRTY("Thirty", 30),

    FOUTRY("Fourty", 40),

    DEUCE("Deuce", 40),

    ADVENTAGE("Adventage", 50);

    private Integer score;
    private String label;

    TennisScoreEnum(String label, int score) {
        this.label = label;
        this.score = score;
    }

    public static TennisScoreEnum nextScore(TennisScoreEnum currentScore) {
        TennisScoreEnum[] values = TennisScoreEnum.values();
        int index = Arrays.asList(values)
                .indexOf(currentScore);
        return values[index + 1];
    }

    public String getLabel() {
        return label;
    }

}
