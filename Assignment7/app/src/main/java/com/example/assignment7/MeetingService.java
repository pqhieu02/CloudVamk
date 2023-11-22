package com.example.assignment7;

import android.util.Log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MeetingService {
    private static List<Meeting> meetings = new ArrayList<>();

    public static List<Meeting> getAll() {
        return meetings;
    }

    public static List<Meeting> search(String title, LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM--yyyy HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        return meetings.stream()
                .filter(meeting -> meeting.getTitle().equals(title) || meeting.getDateTime().equals(dateTime))
                .collect(Collectors.toList());
    }

    public static boolean updateById(String id, String newTitle, String newPlace, String newParticipants, LocalDateTime newDateTime) {
        Optional<Meeting> optionalMeeting = meetings.stream()
                .filter(meeting -> meeting.getId().equals(id))
                .findFirst();

        if (optionalMeeting.isPresent()) {
            Meeting meeting = optionalMeeting.get();
            meeting.setTitle(newTitle);
            meeting.setPlace(newPlace);
            meeting.setParticipants(newParticipants);
            meeting.setDateTime(newDateTime);
            return true;
        }

        return false;
    }

    public static void addMeeting(String title, String place, String participants, LocalDateTime dateTime) {
        Meeting newMeeting = new Meeting(title, place, participants, dateTime);
        meetings.add(newMeeting);
    }
}
