package com.example.marsrover.model;

import com.example.marsrover.model.RoverLocation;

public class Rover {
    private RoverLocation startPosition;

    private String instructions;

    private RoverLocation endPosition;

    private boolean hasMoved;

    public Rover(RoverLocation startPosition, String instructions) {
        this.startPosition = startPosition;
        this.instructions = instructions;
        this.endPosition = null;
        hasMoved = false;
    }

    public RoverLocation getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(RoverLocation startPosition) {
        this.startPosition = startPosition;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public RoverLocation getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(RoverLocation endPosition) {
        this.endPosition = endPosition;
    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}
