package com.twschool.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingScoring {
    
    private List<BowlingFrame> bowlingFrames;
    private BowlingFrame bonusFrame;

    public BowlingScoring(String scoreString) {
        String[] bowlingScoresArray = scoreString.split("\\|\\|");
        List<String> frameScores = Arrays.asList(bowlingScoresArray[0].split("\\|"));
        boolean withExtraTry = bowlingScoresArray.length == 2;
        if (withExtraTry) {
            bonusFrame = new BowlingFrame(bowlingScoresArray[1]);
        }
        bowlingFrames = frameScores.stream().map(BowlingFrame::new).collect(Collectors.toList());
    }

    public int getSumScores() {
        int score = 0;
        List<Ball> allBalls = getAllBalls();
        for (int ballIndex = 0; ballIndex < getTenFrameBalls().size(); ballIndex++) {
            Ball currentBall = allBalls.get(ballIndex);
            score += currentBall.getHitBattles();
            Ball nextBall = allBalls.get(ballIndex + 1);
            if (currentBall instanceof StrikeBall) {
                Ball secondNextBall = allBalls.get(ballIndex + 2);
                score += nextBall.getHitBattles() + secondNextBall.getHitBattles();
            }
            if (currentBall instanceof SpareBall) {
                score += nextBall.getHitBattles();
            }
        }
        return score;
    }

    private List<Ball> getAllBalls() {
        List<Ball> allBalls = new ArrayList<>(getTenFrameBalls());
        if (bonusFrame != null) {
            allBalls.addAll(bonusFrame.getBalls());
        }
        return allBalls;
    }

    private List<Ball> getTenFrameBalls() {
        return bowlingFrames.stream().map(BowlingFrame::getBalls).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List<BowlingFrame> getBowlingFrames() {
        return bowlingFrames;
    }
    
    public BowlingFrame getBonusFrame() {
        return bonusFrame;
    }

}
