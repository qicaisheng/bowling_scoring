package com.twschool.practice;

public class BowlingScoring {

    BowlingFrames allBowlingFrames;

    public BowlingScoring(String scoreString) {
        allBowlingFrames = FramesParser.parseFrames(scoreString);
    }
    
    public int getSumScores() {
        return allBowlingFrames.getSumScores();
    }

}
