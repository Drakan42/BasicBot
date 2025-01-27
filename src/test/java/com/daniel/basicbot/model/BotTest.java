package com.daniel.basicbot.model;

import org.junit.jupiter.api.Test;

class BotTest {

    @Test
    void left() {
        Bot bot = new Bot();
        bot.left();
        assert bot.getDirection().equals("W");
    }

    @Test
    void right() {
        Bot bot = new Bot();
        bot.right();
        assert bot.getDirection().equals("E");
    }

    @Test
    void forward() {
        Bot bot = new Bot();
        bot.forward();
        assert bot.getLat() == 2;
    }

    @Test
    void testToString() {
        Bot bot = new Bot();
        assert bot.toString().equals("Bot{direction=N, lat=1, lon=1}");
    }

    @Test
    void getDirection() {
        Bot bot = new Bot();
        bot.right();
        bot.right();
        assert bot.getDirection().equals("S");
    }
}