package com.twschool.practice;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingFrames {
    public static final int BOWLING_NORMAL_FRAME_SIZE = 10;
    private final List<BowlingFrame> bowlingFrames;

    public BowlingFrames(List<BowlingFrame> bowlingFrames) {
        this.bowlingFrames = bowlingFrames;
    }

    public List<BowlingFrame> getBowlingFrames() {
        return bowlingFrames;
    }

    public List<Ball> getAllBalls() {
        return getBallsOf(getBowlingFrames());
    }

    public List<Ball> getTenFrameBalls() {
        return getBallsOf(getTenBowlingFrames());
    }

    public List<BowlingFrame> getTenBowlingFrames() {
        return getBowlingFrames().stream().limit(BOWLING_NORMAL_FRAME_SIZE).collect(Collectors.toList());
    }

    public BowlingFrame getBonusFrame() {
        return getBowlingFrames().get(BOWLING_NORMAL_FRAME_SIZE);
    }

    public int getSumScores() {
        int score = 0;
        List<Ball> allBalls = this.getAllBalls();
        for (int ballIndex = 0; ballIndex < this.getTenFrameBalls().size(); ballIndex++) {
            Ball currentBall = allBalls.get(ballIndex);
            score += currentBall.getHitBattles();
            if (currentBall instanceof StrikeBall) {
                score += allBalls.get(ballIndex + 1).getHitBattles() + allBalls.get(ballIndex + 2).getHitBattles();
            }
            if (currentBall instanceof SpareBall) {
                score += allBalls.get(ballIndex + 1).getHitBattles();
            }
        }
        return score;
    }

    private List<Ball> getBallsOf(List<BowlingFrame> frames) {
        return frames.stream().map(BowlingFrame::getBalls).flatMap(Collection::stream).collect(Collectors.toList());
    }
}