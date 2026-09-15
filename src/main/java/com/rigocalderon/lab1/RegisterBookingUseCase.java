package com.rigocalderon.lab1;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class RegisterBookingUseCase {

    private final EventRepository eventRepository;
    private final BookingRepository bookingRepository;

    public RegisterBookingUseCase(EventRepository eventRepository, BookingRepository bookingRepository) {
        this.eventRepository = eventRepository;
        this.bookingRepository = bookingRepository;
    }


    public Long ejecutar(NewBookingDto dto) {
        final Long[] bookingId = {-1L};

        Optional<Event> optionalEvent = eventRepository.findByIdWithPessimisticLock(dto.eventId());
        if(optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            if(event.getAvailableStock() <= 0) return bookingId[0];

            event.setAvailableStock(event.getAvailableStock() - 1);

            Booking booking = Booking.newBooking(dto.eventId(), dto.userId());
            bookingRepository.save(booking);
            bookingId[0] = booking.getId();
        }

       return bookingId[0];
    }
}
