package net.core.tutorial.medium._07_EntryToCollectionStream.example2;

import java.time.LocalDateTime;
import java.util.UUID;

public class Event {

    private UUID uuid;
    private LocalDateTime dateTime;
    private String description;

    public Event(UUID uuid, LocalDateTime dateTime, String description) {
        this.uuid = uuid;
        this.dateTime = dateTime;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "uuid=" + uuid +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }
}
