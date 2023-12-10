package com.syntacticsuger.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel{
    private String seatNumber;
    private SeatType seatType;
    private int rowValue;
    private int colValue;
}
