package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class BowlingFrameTest {

    @Test
    public void should_parse_bowling_frame_give_frame_score_9_and_missed() {
        BowlingFrame bowlingFrame = new BowlingFrame("9-");

        Assert.assertNotNull(bowlingFrame);

        Assert.assertEquals(2, bowlingFrame.getBalls().size());
        Assert.assertEquals(9, bowlingFrame.getBalls().get(0).getHitBattles());
        Assert.assertEquals(0, bowlingFrame.getBalls().get(1).getHitBattles());
    }

    @Test
    public void should_parse_bowling_frame_give_frame_score_8_and_1() {
        BowlingFrame bowlingFrame = new BowlingFrame("81");

        Assert.assertNotNull(bowlingFrame);

        Assert.assertEquals(2, bowlingFrame.getBalls().size());
        Assert.assertEquals(8, bowlingFrame.getBalls().get(0).getHitBattles());
        Assert.assertEquals(1, bowlingFrame.getBalls().get(1).getHitBattles());

    }

    @Test
    public void should_parse_bowling_frame_give_frame_score_5_and_spare() {
        BowlingFrame bowlingFrame = new BowlingFrame("5/");

        Assert.assertNotNull(bowlingFrame);

        Assert.assertEquals(2, bowlingFrame.getBalls().size());
        Assert.assertEquals(5, bowlingFrame.getBalls().get(0).getHitBattles());
        Assert.assertEquals(5, bowlingFrame.getBalls().get(1).getHitBattles());
    }

    @Test
    public void should_parse_bowling_frame_give_frame_score_strike() {
        BowlingFrame bowlingFrame = new BowlingFrame("X");

        Assert.assertNotNull(bowlingFrame);

        Assert.assertEquals(1, bowlingFrame.getBalls().size());
        Assert.assertEquals(10, bowlingFrame.getBalls().get(0).getHitBattles());
    }
    
}
