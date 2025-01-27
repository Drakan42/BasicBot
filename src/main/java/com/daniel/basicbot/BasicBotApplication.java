package com.daniel.basicbot;

import com.daniel.basicbot.controllers.BotShellController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.EnableCommand;

@SpringBootApplication
@EnableCommand(BotShellController.class)
public class BasicBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicBotApplication.class, args);
    }

}
