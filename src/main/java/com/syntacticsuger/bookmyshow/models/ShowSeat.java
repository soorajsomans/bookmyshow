package com.syntacticsuger.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    //one showSeat object contains only one show but one show can be in multiple showSeat objects
    @ManyToOne
    private Show show;
    // one showSeat object contain only one seat but one seat can be part of multiple showSeat objects
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    private Date lockedAt;
}
