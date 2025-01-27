package com.daniel.basicbot.controllers;

import com.daniel.basicbot.Util;
import com.daniel.basicbot.model.Board;
import com.daniel.basicbot.model.Bot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class BotController {
    private static final Logger log = LoggerFactory.getLogger(BotController.class);
    private final Util util = new Util();
    private Board board;
    private Bot bot;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return util.hello(name);
    }

    @PostMapping("/all")
    public String all(@RequestParam Board board, @RequestParam Bot bot, @RequestParam String command) {
        this.board = board;
        String boardString = board.toString();
        this.bot = bot;
        String botString = bot.toString();
        command(command);
        return "All commands executed" + boardString + botString + command;
    }

    @PostMapping("/setBoard")
    public String setBoard(@RequestBody Board board) {
        this.board = board;
        return board.toString();
    }

    @PostMapping("/setBot")
    public String setBot(@RequestBody Bot bot) {
        this.bot = bot;
        return bot.toString();
    }

    @GetMapping("/command")
    public String command(@RequestParam(value = "command", defaultValue = "") String command) {
        log.info("Incoming Rest Command: {}", command);
        return util.executeCommand(bot, board, command);
    }

}
