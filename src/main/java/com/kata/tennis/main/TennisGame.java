package com.kata.tennis.main;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    public static final int RED_TEAM_ID = 0;
    public static final int BLUE_TEAM_ID = 1;
    private Map<Integer, TennisScoreEnum> scoreByTeam = new HashMap<>();

    public TennisGame() {
        scoreByTeam.put(RED_TEAM_ID, TennisScoreEnum.LOVE);
        scoreByTeam.put(BLUE_TEAM_ID, TennisScoreEnum.LOVE);
    }

    public void score(int teamId) {
        TennisScoreEnum currentScore = this.scoreByTeam.get(teamId);
        if (isDeuce(teamId)) {
            this.scoreByTeam.put(this.getOtherTeamId(teamId), TennisScoreEnum.FOUTRY);
            this.scoreByTeam.put(teamId, TennisScoreEnum.ADVENTAGE);
        } else if (isBreakPoint(teamId, currentScore)) {
            this.scoreByTeam.put(this.getOtherTeamId(teamId), TennisScoreEnum.DEUCE);
            this.scoreByTeam.put(teamId, TennisScoreEnum.DEUCE);
        } else {
            this.scoreByTeam.put(teamId, TennisScoreEnum.nextScore(currentScore));
        }
    }

    private boolean isBreakPoint(int teamId, TennisScoreEnum currentScore) {
        return currentScore.equals(TennisScoreEnum.THIRTY) && this.getOtherTeamScore(teamId)
                .equals(TennisScoreEnum.FOUTRY) || currentScore.equals(TennisScoreEnum.FOUTRY) && this.getOtherTeamScore(
                teamId)
                .equals(TennisScoreEnum.ADVENTAGE);
    }

    private boolean isDeuce(int teamId) {
        TennisScoreEnum currentScore = this.scoreByTeam.get(teamId);
        return currentScore.equals(TennisScoreEnum.DEUCE) && this.getOtherTeamScore(teamId)
                .equals(TennisScoreEnum.DEUCE);
    }

    private int getOtherTeamId(int teamId) {
        if (teamId == RED_TEAM_ID) {
            return BLUE_TEAM_ID;
        } else {
            return RED_TEAM_ID;
        }
    }

    private TennisScoreEnum getOtherTeamScore(int teamId) {
        if (teamId == RED_TEAM_ID) {
            return this.scoreByTeam.get(BLUE_TEAM_ID);
        } else {
            return this.scoreByTeam.get(RED_TEAM_ID);
        }
    }

    private String getScoreLabel(int teamId) {
        return this.scoreByTeam.get(teamId)
                .getLabel();
    }

    public String showBlueTeamScore() {
        return this.getScoreLabel(BLUE_TEAM_ID);
    }

    public String showRedTeamScore() {
        return this.getScoreLabel(RED_TEAM_ID);
    }

}
