package com.syntacticsuger.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseModel {
    private String name;
    //one region can have multiple theatres but one theatre belong to one region
    @OneToMany
    private List<Theatre> theatres;
}
