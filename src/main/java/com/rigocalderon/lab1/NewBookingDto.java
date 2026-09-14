package com.rigocalderon.lab1;

import java.util.UUID;

public record NewBookingDto(
        Long eventId,
        UUID userId
) {
    public NewBookingDto {
        if(userId == null) {
            userId = UUID.randomUUID();
        }
    }
}
