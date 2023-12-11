package com.syntacticsuger.bookmyshow.services;

import com.syntacticsuger.bookmyshow.models.Show;
import com.syntacticsuger.bookmyshow.models.ShowSeat;
import com.syntacticsuger.bookmyshow.models.ShowSeatType;
import com.syntacticsuger.bookmyshow.repositories.ShowSeatRepository;
import com.syntacticsuger.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculator {

    @Autowired
    private ShowSeatTypeRepository showSeatTypeRepository;
    public int calculatePrice(List<ShowSeat> showSeats, Show show){
        // 1. Find out the types of seats in the given show
        // 2. Get seatType for all selected seats
        // 3. calculate the amount
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        int amount=0;
        //n2 approach can be reduced to n by using hashmap
        for(ShowSeat showSeat: showSeats){
            for(ShowSeatType showSeatType: showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount+=showSeatType.getPrice();
                }
            }
        }
        return amount;
    }
}
