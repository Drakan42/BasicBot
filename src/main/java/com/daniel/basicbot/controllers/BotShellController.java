package com.daniel.basicbot.controllers;

import com.daniel.basicbot.Util;
import com.daniel.basicbot.model.Board;
import com.daniel.basicbot.model.Bot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;


@Command
public class BotShellController {
    private static final Logger log = LoggerFactory.getLogger(BotShellController.class);
    private static Util util = new Util();
    private Board board = new Board();
    private Bot bot = new Bot();

    @Command(command = "hello")
    public String hello(@Option(defaultValue = "World") String name) {
        return util.hello(name);
    }

    @Command(command = "setBoard")
    public String setBoard(@Option(longNames = "size", shortNames = 's', defaultValue = "5,5") String latLng) {
        board = new Board(latLng);
        return board.toString();
    }

    @Command(command = "setBot")
    public String start(@Option(longNames = "position", shortNames = 'p', defaultValue = "N,1,1") String sBot) {
        this.bot = new Bot(sBot);
        return bot.toString();
    }

    @Command(command = "command")
    public String command(@Option(longNames = "command", shortNames = 'c', defaultValue = "LRF") String comString) {
        log.info("incoming shell Command: {}", comString);
        return util.executeCommand(bot, board, comString);
    }
}
