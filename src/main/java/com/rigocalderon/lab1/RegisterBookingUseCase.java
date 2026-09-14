package com.rigocalderon.lab1;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

        int rowsUpdated = eventRepository.actualizarEspaciosDisponibles(dto.eventId());
        if(rowsUpdated == 0) {
            return -1L;
        }

        Booking booking = Booking.newBooking(dto.eventId(), dto.userId());
        bookingRepository.save(booking);
        bookingId[0] = booking.getId();


       return bookingId[0];
    }
}
