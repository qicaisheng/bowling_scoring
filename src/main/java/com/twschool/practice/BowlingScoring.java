package com.twschool.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingScoring {

    BowlingFrames allBowlingFrames;

    public BowlingScoring(String scoreString) {
        allBowlingFrames = parseFrames(scoreString);
    }

    private BowlingFrames parseFrames(String scoreString) {
        String[] bowlingScoresArray = scoreString.split("\\|\\|");
        List<String> frameScores = Arrays.asList(bowlingScoresArray[0].split("\\|"));
        List<BowlingFrame> bowlingFrames = frameScores.stream().map(FrameBallsParser::parse).collect(Collectors.toList());
        boolean withExtraTry = bowlingScoresArray.length == 2;
        if (withExtraTry) {
            BowlingFrame bonusFrame = FrameBallsParser.parse(bowlingScoresArray[1]);
            bowlingFrames.add(bonusFrame);
        }
        return new BowlingFrames(bowlingFrames);
    }

    public int getSumScores() {
        return allBowlingFrames.getSumScores();
    }

}
