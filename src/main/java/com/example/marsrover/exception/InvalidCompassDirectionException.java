package com.example.marsrover.exception;

public class InvalidCompassDirectionException extends RuntimeException {
    public InvalidCompassDirectionException(String abbr) {
        super(abbr);
    }
}
