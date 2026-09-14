package com.rigocalderon.lab1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class BookingController {

    private final RegisterBookingUseCase registerBookingUseCase;

    public BookingController(RegisterBookingUseCase registerBookingUseCase) {
        this.registerBookingUseCase = registerBookingUseCase;
    }

    @PostMapping("/")
    public ResponseEntity<Void> registerNewBooking(
            @RequestBody NewBookingDto dto
    ) {
        Long id = registerBookingUseCase.ejecutar(dto);
        if(id.equals(-1L)) {
            return ResponseEntity.badRequest().build();
        }

        URI uri = UriComponentsBuilder
                .fromUriString("https://example.com/bookings/{id}")
                .build("id", id);

        return ResponseEntity.created(uri).build();
    }
}
