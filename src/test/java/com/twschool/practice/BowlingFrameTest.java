package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class BowlingFrameTest {

    @Test
    public void should_parse_bowling_frame_give_frame_score_9_and_missed() {
        BowlingFrame bowlingFrame = new BowlingFrame("9-");

        Assert.assertNotNull(bowlingFrame);
        Assert.assertEquals(9, bowlingFrame.getFrameHitBottles());
    }

    @Test
    public void should_parse_bowling_frame_give_frame_score_8_and_1() {
        BowlingFrame bowlingFrame = new BowlingFrame("81");

        Assert.assertNotNull(bowlingFrame);
        Assert.assertEquals(9, bowlingFrame.getFrameHitBottles());
    }
}
