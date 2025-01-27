package com.daniel.basicbot.model;

import ch.qos.logback.classic.Logger;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.LoggerFactory;

@Setter
@Getter
public class Bot {
    private static Logger log = (Logger) LoggerFactory.getLogger(Bot.class);
    private String direction;
    private int lng;
    private int lat;

    public Bot(String direction, int lng, int lat) {
        this.direction = direction;
        this.lng = lng; //EW
        this.lat = lat; // NS
    }

    public Bot() {
        this.direction = "N";
        this.lng = 1; //EW
        this.lat = 1; // NS
    }

    public Bot(String sBot) {
        String[] split = sBot.split(",");
        if (split.length == 3) {
            if (split[0].matches("^[NESW]$")) {
                if (split[1].matches("^[0-9]$")) {
                    if (split[2].matches("^[0-9]$")) {
                        this.direction = split[0];
                        this.lng = Integer.parseInt(split[1]);
                        this.lat = Integer.parseInt(split[2]);
                    } else
                        log.error("Bot Latitude %s not a number".formatted(split[2]));
                } else
                    log.error("Bot longitude %s not a number".formatted(split[1]));
            } else
                log.error("Bot Direction %s Should be either N, E, S, W".formatted(split[0]));
        }else
            log.error("Bot Input incorrect length: %s != 3 EXAMPLES N,1,1 :: S,8,8".formatted(split.length));
    }

    public void left(){
        switch(direction){
            case "N": direction = "W"; break;
            case "E": direction = "N"; break;
            case "S": direction = "E"; break;
            case "W": direction = "S"; break;
        }
        log.debug(this.toString());
    }
    public void right(){
        switch(direction){
            case "N": direction = "E"; break;
            case "E": direction = "S"; break;
            case "S": direction = "W"; break;
            case "W": direction = "N"; break;
        }
        log.debug(this.toString());
    }
    public void forward(){
        switch(direction){
            case "N": lat = lat+1; break;
            case "S": lat = lat-1; break;
            case "E": lng = lng+1; break;
            case "W": lng = lng-1; break;
        }
        log.debug(this.toString());
    }
    public void backward(){
        switch(direction){
            case "N": lat = lat-1; break;
            case "S": lat = lat+1; break;
            case "E": lng = lng-1; break;
            case "W": lng = lng+1; break;
        }
        log.debug(this.toString());
    }

    @Override
    public String toString() {
        return "Bot{" +
                "Direction='" + direction + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
