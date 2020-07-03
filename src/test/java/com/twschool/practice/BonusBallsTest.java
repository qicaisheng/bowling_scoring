package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class BonusBallsTest {

    @Test
    public void should_parse_bonus_balls_given_one_bonus_ball_with_5_hit_bottles() {
        BonusBalls bonusBalls = new BonusBalls("5");

        Assert.assertNotNull(bonusBalls);
        Assert.assertEquals(5, bonusBalls.getFirstHitBottles());
    }
}
