package com.syntacticsuger.bookmyshow.controllers;

import com.syntacticsuger.bookmyshow.dto.BookMovieRequestDTO;
import com.syntacticsuger.bookmyshow.dto.BookMovieResponseDTO;
import com.syntacticsuger.bookmyshow.dto.ResponseStatus;
import com.syntacticsuger.bookmyshow.models.Booking;
import com.syntacticsuger.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;
    public BookMovieResponseDTO bookMovie(BookMovieRequestDTO bookMovieRequestDTO){
        BookMovieResponseDTO response = new BookMovieResponseDTO();
        try {
            Booking booking = bookingService.bookMovie(
                    bookMovieRequestDTO.getUserId(),
                    bookMovieRequestDTO.getShowSeatIds(),
                    bookMovieRequestDTO.getShowId()
            );
            response.setBookingId(booking.getId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setAmount(booking.getAmount());

        }catch (Exception e){
            response.setResponseStatus(ResponseStatus.FAILURE);

        }
        return response;
    }
}
