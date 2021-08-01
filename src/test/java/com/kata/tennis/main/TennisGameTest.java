package com.kata.tennis.main;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TennisGameTest {

    private TennisGame game = new TennisGame();

    @Test
    public void scoreShouldPrintLoveForBothPlayersWhenScoreIsZero() {
        String p1Score = game.showRedTeamScore();
        String p2Score = game.showBlueTeamScore();
        Assertions.assertThat(p1Score)
                .isEqualTo("Love");
        Assertions.assertThat(p2Score)
                .isEqualTo("Love");
    }

    @Test
    public void scoreShouldPrintFifteenWhenPlayerScore1Point() {
        redTeamScore(1);
        String p1Score = game.showRedTeamScore();
        Assertions.assertThat(p1Score)
                .isEqualTo("Fifteen");
    }

    @Test
    public void scoreShouldPrintThirtyWhenPlayerScore2Point() {
        redTeamScore(2);
        String p1Score = game.showRedTeamScore();
        Assertions.assertThat(p1Score)
                .isEqualTo("Thirty");
    }

    @Test
    public void scoreShouldPrintFourtyWhenPlayerScore3Point() {
        redTeamScore(3);
        String p1Score = game.showRedTeamScore();
        Assertions.assertThat(p1Score)
                .isEqualTo("Fourty");
    }

    @Test
    public void scoreShouldPrintDeuceIfBothPlayerAre40Even() {
        redTeamScore(3);
        blueTeamScore(3);
        String p1Score = game.showRedTeamScore();
        String p2Score = game.showBlueTeamScore();
        Assertions.assertThat(p1Score)
                .isEqualTo("Deuce");
        Assertions.assertThat(p2Score)
                .isEqualTo("Deuce");
    }

    @Test
    public void scoreShouldPrintAdvantageForOneTeamIfBothPlayerAre40AndOneScores() {
        redTeamScore(3);
        blueTeamScore(3);
        redTeamScore(1);
        String p1Score = game.showRedTeamScore();
        String p2Score = game.showBlueTeamScore();
        Assertions.assertThat(p1Score)
                .isEqualTo("Adventage");
        Assertions.assertThat(p2Score)
                .isEqualTo("Fourty");
    }

    @Test
    public void scoreShouldPrintDeuceForBothIfOneScoresAgainstAdventage() {
        redTeamScore(3);
        blueTeamScore(3);
        redTeamScore(1);
        blueTeamScore(1);
        String p1Score = game.showRedTeamScore();
        String p2Score = game.showBlueTeamScore();
        Assertions.assertThat(p1Score)
                .isEqualTo("Deuce");
        Assertions.assertThat(p2Score)
                .isEqualTo("Deuce");
    }

    private void blueTeamScore(int nbScore) {
        for (int i = 0; i < nbScore; i++) {
            game.score(TennisGame.BLUE_TEAM_ID);
        }
    }

    private void redTeamScore(int nbScore) {
        for (int i = 0; i < nbScore; i++) {
            game.score(TennisGame.RED_TEAM_ID);
        }
    }


}
