package com.epam.reactiveprogramingrdignite.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MatchHighlight {
    @Id
    private String id;
    private Integer minute;
    private String eventType;
    private String player;

    public MatchHighlight() {
    }

    public MatchHighlight(String id, Integer minute, String eventType, String player) {
        this.id = id;
        this.minute = minute;
        this.eventType = eventType;
        this.player = player;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "MatchHighlight{" +
                "id='" + id + '\'' +
                ", minute=" + minute +
                ", eventType='" + eventType + '\'' +
                ", player='" + player + '\'' +
                '}';
    }
}
