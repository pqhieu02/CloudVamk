package com.example.assignment7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

class Meeting {
    private String id;
    private String title;
    private String place;
    private String participants;
    private LocalDateTime dateTime;

    // Constructor
    public Meeting(String title, String place, String participants, LocalDateTime dateTime) {
        this.id = generateRandomId();
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

    public String getId() {
        return id;
    }

    private String generateRandomId() {
        Random random = new Random();
        int randomInt = random.nextInt(10000);
        return String.format("%04d", randomInt);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        return "Meeting " + id +
                ", title=" + title +
                ", place=" + place +
                ", participants=" + participants +
                ", time=" + formattedDateTime;
    }
}