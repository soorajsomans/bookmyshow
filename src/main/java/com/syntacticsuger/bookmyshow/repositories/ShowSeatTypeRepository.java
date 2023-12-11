package com.syntacticsuger.bookmyshow.repositories;

import com.syntacticsuger.bookmyshow.models.Show;
import com.syntacticsuger.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    List<ShowSeatType> findAllByShow(Show show);
}
