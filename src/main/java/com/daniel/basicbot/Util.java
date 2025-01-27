package com.daniel.basicbot;

import com.daniel.basicbot.model.Board;
import com.daniel.basicbot.model.Bot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Util {

    public String hello(String name) {
        return String.format("Hello %s!", name);
    }

    private static final Logger log = LoggerFactory.getLogger(Util.class);

    public String executeCommand(Bot bot, Board board, String command) {
        String UComString = command.toUpperCase();
        if (!UComString.isEmpty() && validateC(UComString)) {
            char[] charArray = UComString.toCharArray();
            for (char c : charArray) {
                switch (c) {
                    case 'L':
                        bot.left();
                        log.debug(bot.toString());
                        break;
                    case 'R':
                        bot.right();
                        log.debug(bot.toString());
                        break;
                    case 'F':
                        bot.forward();
                        log.debug(bot.toString());
                        if (!board.validatePos(bot.getLat(), bot.getLng())) {
                            String s = "Position " + bot.getLat() + "," + bot.getLng() + " out of bounds " + board;
                            log.error(s);
                            return s;
                        }
                        break;
                }
            }
        } else {
            log.error("Invalid command");
            return """
                    Invalid command
                    Command Must be \
                    • L Turn left
                    • R Turn right
                    • F Walk forward""";
        }
        return bot.toString();
    }

    private boolean validateC(String command) {
        return command.matches("^[LRF]*$");
    }

}
