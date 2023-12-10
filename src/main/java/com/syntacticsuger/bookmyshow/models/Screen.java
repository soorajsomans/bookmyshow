package com.syntacticsuger.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;

    //one screen can have multiple seats but one seat belongs to one screen
    @OneToMany
    private List<Seat> seats;

    //since its a list of enum we need a mapping table (m to m relationship)
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // Mapping table for enum
    private List<Feature> features;
}
