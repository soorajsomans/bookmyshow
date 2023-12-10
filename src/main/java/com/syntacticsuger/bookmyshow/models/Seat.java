package com.syntacticsuger.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    // one seat have only one type and many seats can have same type
    @ManyToOne
    private SeatType seatType;
    private int rowValue;
    private int colValue;
}
