package com.syntacticsuger.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;
/**
 * This class is used to calculate price for each show and seat type
 */

@Getter
@Setter
public class ShowSeatType extends BaseModel{
    private Show show;
    private SeatType seatType;
    private int price;
}
