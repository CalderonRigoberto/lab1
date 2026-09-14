package com.rigocalderon.lab1;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bookings", catalog = "railway", schema = "public")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id")
    private Long eventId;

    @Column(name="user_id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID userId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public static Booking newBooking(Long eventId, UUID userId) {
        Booking booking = new Booking();
        booking.setEventId(eventId);
        booking.setUserId(userId);

        return booking;
    }

    @PrePersist
    public void registerNewBooking() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
