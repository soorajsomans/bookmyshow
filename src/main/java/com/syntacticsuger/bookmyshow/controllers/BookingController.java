package com.syntacticsuger.bookmyshow.controllers;

import com.syntacticsuger.bookmyshow.dto.BookMovieRequestDTO;
import com.syntacticsuger.bookmyshow.dto.BookMovieResponseDTO;
import com.syntacticsuger.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;
    public BookMovieResponseDTO bookMovie(BookMovieRequestDTO bookMovieRequestDTO){
        return null;
    }
}
