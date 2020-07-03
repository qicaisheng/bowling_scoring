package com.twschool.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingScoring {
    
    private List<BowlingFrame> bowlingFrames;
    private BonusBalls bonusBalls;

    public BowlingScoring(String scoreString) {
        String[] bowlingScoresArray = scoreString.split("\\|\\|");
        List<String> frameScores = Arrays.asList(bowlingScoresArray[0].split("\\|"));
        boolean withExtraTry = bowlingScoresArray.length == 2;
        if (withExtraTry) {
            bonusBalls = new BonusBalls(bowlingScoresArray[1]);
        }
        bowlingFrames = frameScores.stream().map(BowlingFrame::new).collect(Collectors.toList());
    }

    public int getSumScores() {
        int score = 0;
        List<Ball> allBalls = getAllBalls();
        for (int ballIndex = 0; ballIndex < getTenFrameBalls().size(); ballIndex++) {
            score += allBalls.get(ballIndex).getHitBattles();
            if (allBalls.get(ballIndex) instanceof StrikeBall) {
                score += allBalls.get(ballIndex + 1).getHitBattles() + allBalls.get(ballIndex + 2).getHitBattles();
            }
            if (allBalls.get(ballIndex) instanceof SpareBall) {
                score += allBalls.get(ballIndex + 1).getHitBattles();
            }
        }
        return score;
    }

    private List<Ball> getAllBalls() {
        List<Ball> allBalls = new ArrayList<>(getTenFrameBalls());
        if (bonusBalls != null) {
            allBalls.addAll(bonusBalls.getBalls());
        }
        return allBalls;
    }

    private List<Ball> getTenFrameBalls() {
        return bowlingFrames.stream().map(BowlingFrame::getBalls).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List<BowlingFrame> getBowlingFrames() {
        return bowlingFrames;
    }
    
    public BonusBalls getBonusBalls() {
        return bonusBalls;
    }

}
