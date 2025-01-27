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
    @Order(5)
    void all() {
        Board board = new Board("8,8");
        Bot bot = new Bot("S",8,8);
        String c = "FLFRFLFRFLFRF";
        assert bc.all(board,bot,c).equals(bot.toString());
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
        bc.command("RFLFRFLFRFLFRFLF").equals("Bot{" +
                "Direction='N' "+
                ", lng=5"+
                ", lat=5"+
                '}');
    }
}