package com.syntacticsuger.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Show extends BaseModel{
    private Movie movie;
    private Date starTime;
    private Date endTime;
    private Screen screen;
    private List<Feature> features;
}
