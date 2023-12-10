package com.syntacticsuger.bookmyshow.services;

import com.syntacticsuger.bookmyshow.models.Booking;
import com.syntacticsuger.bookmyshow.models.User;
import com.syntacticsuger.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private UserRepository userRepository;
    @Transactional(isolation = Isolation.SERIALIZABLE) // starting transaction in method level and setting isolation level
    public Booking bookMovie(Long userId, List<Long> seatIds, Long showId){
        // 1. Get the user by userId
        Optional<User> userOptional = userRepository.findById(userId);
        // 2. Get the show with showId
        // --- Take a lock ---- start transaction
        // 3. Get showSeat using seatIds
        // 4. Check if all the seats are available
        // 5. If no throw error
        // 6. If yes mark all the selected seats are BLOCKED
        // 7. Save it in DB.
        // ---- Release the lock --- end transaction
        // 8. Create booking object
        // 9. Save the booking details in the db
        // 10. Return the booking
        return null;
    }
}
