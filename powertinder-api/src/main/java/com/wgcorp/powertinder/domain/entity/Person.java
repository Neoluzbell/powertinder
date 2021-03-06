package com.wgcorp.powertinder.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.wgcorp.powertinder.Constant.DEFAULT_DATE_FORMAT;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    @JsonProperty("_id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("distance_mi")
    private int distanceMi;

    @JsonProperty("ping_time")
    private String pingTime;

    @JsonProperty("birth_date")
    private String birthDate;

    @JsonProperty("bio")
    private String bio;

    @JsonProperty("photos")
    private List<Photo> photos;

    public String getId() {
        return id;
    }

    public int getAge() {
        return Period.between(LocalDate.parse(birthDate, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)), LocalDate.now()).getYears();
    }

    public String getName() {
        return name;
    }

    public int getDistanceMi() {
        return distanceMi;
    }

    @JsonProperty("distance_km")
    public double getDistanceKm() {
        BigDecimal bd = new BigDecimal(Double.toString(distanceMi * 1.60934));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
