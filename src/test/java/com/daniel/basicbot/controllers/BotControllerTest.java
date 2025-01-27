package com.daniel.basicbot.controllers;

import com.daniel.basicbot.model.Board;
import com.daniel.basicbot.model.Bot;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class BotControllerTest {

    private static BotController bc;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        bc = new BotController();
    }

    @Test
    @Order(1)
    void hello() {
        assert bc.hello("Daniel").equals("Hello Daniel!");
    }


    @Test
    @Order(2)
    void setBoard() {
        Board board = new Board();
        assert bc.setBoard(board).equals(board.toString());
    }

    @Test
    @Order(3)
    void setBot() {
        Bot bot = new Bot();
        assert bc.setBot(bot).equals(bot.toString());
    }

    @Test
    @Order(4)
    void command() {
        bc.setBoard(new Board());
        bc.setBot(new Bot());
        assert bc.command("RFLFRFLFRFLFRFLF").equals("Bot{Direction='N', lng=5, lat=5}");
    }

    @Test
    @Order(5)
    void commandFail() {
        bc.setBoard(new Board("8,8"));
        bc.setBot(new Bot("N", 8, 8));
        assert bc.command("F").equals("Position 9,8 out of bounds longatude:8 latatude:8");
    }

    @Test
    @Order(6)
    void all() {
        Board board = new Board("8,8");
        Bot bot = new Bot("S", 8, 8);
        String c = "FRFLFRFLFRFLLL";
        String all = bc.all(board, bot, c);
        assert all.equals("All commands executed \n" +
                "longatude:8 latatude:8\n" +
                "Bot{Direction='S', lng=8, lat=8}\n" +
                "FRFLFRFLFRFLLL\n" +
                "Bot{Direction='N', lng=5, lat=5}");
    }

}