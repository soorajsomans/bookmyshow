package com.syntacticsuger.bookmyshow.services;

import com.syntacticsuger.bookmyshow.models.*;
import com.syntacticsuger.bookmyshow.repositories.BookingRepository;
import com.syntacticsuger.bookmyshow.repositories.ShowRepository;
import com.syntacticsuger.bookmyshow.repositories.ShowSeatRepository;
import com.syntacticsuger.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PriceCalculator priceCalculator;
    @Transactional(isolation = Isolation.SERIALIZABLE) // starting transaction in method level and setting isolation level
    public Booking bookMovie(Long userId, List<Long> showSeatIds, Long showId){
        // 1. Get the user by userId
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("No user found");
        }
        User bookedBy = userOptional.get();
        // 2. Get the show with showId
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new RuntimeException("No show found");
        }
        Show bookedShow = showOptional.get();
        // --- Take a lock ---- start transaction
        // 3. Get showSeat using seatIds
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        // 4. Check if all the seats are available
        for(ShowSeat showSeat: showSeats){
            if(!(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE) ||
                    (showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED) &&
                            Duration.between(showSeat.getLockedAt().toInstant(), new Date().toInstant()).toMinutes() >15))
            ){
                // 5. If no throw error
                throw new RuntimeException("Selected seats are not available!");
            }
        }
       List<ShowSeat> savedShowSeat = new ArrayList<>();
        // 6. If yes mark all the selected seats are BLOCKED
        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setLockedAt(new Date());
            // 7. Save it in DB.
            savedShowSeat.add(showSeatRepository.save(showSeat));
        }

        // ---- Release the lock --- end transaction
        // 8. Create booking object
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeats(savedShowSeat);
        booking.setUser(bookedBy);
        booking.setBookedAt(new Date());
        booking.setShow(bookedShow);
        booking.setAmount(priceCalculator.calculatePrice(savedShowSeat,bookedShow));
        booking.setPayments(new ArrayList<>());
        // 9. Save the booking details in the db
        booking = bookingRepository.save(booking);
        // 10. Return the booking
        return booking;
    }
}
