package com.example.assignment7;

import java.time.LocalDateTime;

class Meeting {
    private String title;
    private String place;
    private String participants;
    private LocalDateTime dateTime;

    // Constructor
    public Meeting(String title, String place, String participants, LocalDateTime dateTime) {
        this.title = title;
        this.place = place;
        this.participants = participants;
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public void setDateTime(LocalDateTime date) {
        this.dateTime = date;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "title='" + title + '\'' +
                ", place='" + place + '\'' +
                ", participants='" + participants + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}