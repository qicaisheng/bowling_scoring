package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class BonusBallsTest {

    @Test
    public void should_parse_bonus_balls_given_one_bonus_ball_with_5_hit_bottles() {
        BonusBalls bonusBalls = new BonusBalls("5");

        Assert.assertNotNull(bonusBalls);
        Assert.assertEquals(5, bonusBalls.getFirstHitBottles());
        
        Assert.assertEquals(1, bonusBalls.getBalls().size());
        Assert.assertEquals(5, bonusBalls.getBalls().get(0).getHitBattles());
    }

    @Test
    public void should_parse_bonus_balls_given_two_bonus_ball_with_5_and_1_hit_bottles() {
        BonusBalls bonusBalls = new BonusBalls("51");

        Assert.assertNotNull(bonusBalls);
        Assert.assertEquals(5, bonusBalls.getFirstHitBottles());
        Assert.assertEquals(1, bonusBalls.getSecondHitBottles());

        Assert.assertEquals(2, bonusBalls.getBalls().size());
        Assert.assertEquals(5, bonusBalls.getBalls().get(0).getHitBattles());
        Assert.assertEquals(1, bonusBalls.getBalls().get(1).getHitBattles());
    }

    @Test
    public void should_parse_bonus_balls_given_two_bonus_ball_with_10_and_10_hit_bottles() {
        BonusBalls bonusBalls = new BonusBalls("XX");

        Assert.assertNotNull(bonusBalls);
        Assert.assertEquals(10, bonusBalls.getFirstHitBottles());
        Assert.assertEquals(10, bonusBalls.getSecondHitBottles());

        Assert.assertEquals(2, bonusBalls.getBalls().size());
        Assert.assertEquals(10, bonusBalls.getBalls().get(0).getHitBattles());
        Assert.assertEquals(10, bonusBalls.getBalls().get(1).getHitBattles());
    }

    @Test
    public void should_parse_bonus_balls_given_two_bonus_ball_with_missed_and_10_hit_bottles() {
        BonusBalls bonusBalls = new BonusBalls("-X");

        Assert.assertNotNull(bonusBalls);
        Assert.assertEquals(0, bonusBalls.getFirstHitBottles());
        Assert.assertEquals(10, bonusBalls.getSecondHitBottles());

        Assert.assertEquals(2, bonusBalls.getBalls().size());
        Assert.assertEquals(0, bonusBalls.getBalls().get(0).getHitBattles());
        Assert.assertEquals(10, bonusBalls.getBalls().get(1).getHitBattles());
    }

    @Test
    public void should_parse_bonus_balls_given_two_bonus_ball_with_8_and_spare() {
        BonusBalls bonusBalls = new BonusBalls("8/");

        Assert.assertNotNull(bonusBalls);
        Assert.assertEquals(8, bonusBalls.getFirstHitBottles());
        Assert.assertEquals(2, bonusBalls.getSecondHitBottles());

        Assert.assertEquals(2, bonusBalls.getBalls().size());
        Assert.assertEquals(8, bonusBalls.getBalls().get(0).getHitBattles());
        Assert.assertEquals(2, bonusBalls.getBalls().get(1).getHitBattles());

    }
}
