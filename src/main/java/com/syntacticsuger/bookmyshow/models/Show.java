package com.syntacticsuger.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name="shows")
public class Show extends BaseModel{
    // one show have only one movie and one move part of multiple shows
    @ManyToOne
    private Movie movie;
    private Date starTime;
    private Date endTime;
    // one show belongs to one screen and same screen can have multiple shows
    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
