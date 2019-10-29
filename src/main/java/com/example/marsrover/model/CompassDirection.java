package com.example.marsrover.model;

import com.example.marsrover.exception.InvalidCompassDirectionException;

public enum CompassDirection {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private final String abbreviation;

    CompassDirection(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    public static CompassDirection findByAbbr(String abbr){
        for(CompassDirection cd : values()){
            if( cd.abbreviation.equals(abbr)){
                return cd;
            }
        }
        throw new InvalidCompassDirectionException(abbr);
    }


}
