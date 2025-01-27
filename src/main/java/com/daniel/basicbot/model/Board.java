package com.daniel.basicbot.model;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Setter
@Getter
public class Board {

    private static final Logger log = LoggerFactory.getLogger(Board.class);
    private int lat;
    private int lng;

    public Board() {
        this.lat = 5;
        this.lng = 5;
    }

    public Board(int lat, int lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Board(String latLng) {
        String[] latlng = latLng.split(",");
        this.lat = Integer.parseInt(latlng[0]);
        this.lng = Integer.parseInt(latlng[1]);
    }


    @Override
    public String toString() {
        return "longatude:" + lng + " latatude:" + lat;
    }

    public Boolean validatePos(int botLat, int botLng) {
        log.debug("validatePos: lat=" + lat + ", lng=" + lng +" is in: lat=" + this.lat + ", lng="+this.lng);
        Boolean result = false;
        if (botLat > 0 && botLng > 0) {
            result = botLat <= this.lat && botLng <= this.lng;
        }
        return result;
    }
}
