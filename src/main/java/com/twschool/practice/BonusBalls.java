package com.twschool.practice;

import java.util.List;

public class BonusBalls {
    private List<Ball> balls;

    public BonusBalls(String bonusScoreString) {
        balls = BallsFactory.buildBalls(bonusScoreString);
    }

    public List<Ball> getBalls() {
        return balls;
    }

}
