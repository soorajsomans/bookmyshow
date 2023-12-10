package com.syntacticsuger.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Date;

@Getter
@Setter
public class Booking extends BaseModel{
    private BookingStatus bookingStatus;
    private List<ShowSeat> showSeats;

    private User user;
    private Date bookedAt;
    private Show show;
    private int amount;
    private List<Payment> payments;

}
