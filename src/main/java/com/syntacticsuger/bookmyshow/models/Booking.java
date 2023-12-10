package com.syntacticsuger.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Date;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @Enumerated(EnumType.ORDINAL) //annotation for enums, giving ordered enum
    private BookingStatus bookingStatus;

    // one booking can have multiple seats and
    // multiple booking can be possible for a show seat (eg. canceled bookings)
    @ManyToMany
    private List<ShowSeat> showSeats;

    // one user can have many bookings and one booking only belongs to one user
    @ManyToOne
    private User user;

    private Date bookedAt;

    // one booking have only one show and one show can present in multiple bookings
    @ManyToOne
    private Show show;

    private int amount;
    // one booking can have multiple payments and one payment belongs to one booking
    @OneToMany
    private List<Payment> payments;

}
