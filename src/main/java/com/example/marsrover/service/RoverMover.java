package com.example.marsrover.service;

import com.example.marsrover.exception.InvalidCompassDirectionException;
import com.example.marsrover.model.CompassDirection;
import com.example.marsrover.model.Grid;
import com.example.marsrover.model.Rover;
import com.example.marsrover.model.RoverLocation;

public class RoverMover {

    public void move(Rover rover, Grid grid) {
        int x = rover.getStartPosition().getX();
        int y = rover.getStartPosition().getY();
        CompassDirection cd = rover.getStartPosition().getDir();
        String instructions = rover.getInstructions();

        for (char instruction: instructions.toCharArray()) {
            switch (instruction) {
                case 'M':
                    x = moveAdjustX(cd, x);
                    y = moveAdjustY(cd, y);
                    break;

                case 'R':
                    cd = turnRight(cd);
                    break;

            }
        }

        rover.setEndPosition(new RoverLocation(x, y, cd));
        rover.setHasMoved(true);
    }

    private int moveAdjustX(CompassDirection cd, int prevX) {
        if (cd.equals(CompassDirection.EAST)) {
            return ++prevX;

        }
        else if(cd.equals(CompassDirection.WEST)) {
            return --prevX;
        }
        return prevX;
    }
    private int moveAdjustY(CompassDirection cd, int prevY) {
        if (cd.equals(CompassDirection.NORTH)) {
            return ++prevY;

        }
        else if(cd.equals(CompassDirection.SOUTH)) {
            return --prevY;
        }
        return prevY;
    }

    private CompassDirection turnRight(CompassDirection cd) {
        if(cd.equals(CompassDirection.NORTH)) return CompassDirection.EAST;
        if(cd.equals(CompassDirection.EAST)) return CompassDirection.SOUTH;
        if(cd.equals(CompassDirection.SOUTH)) return CompassDirection.WEST;
        if(cd.equals(CompassDirection.WEST)) return CompassDirection.NORTH;
        throw new InvalidCompassDirectionException("turnRight");
    }

    private CompassDirection turnLeft(CompassDirection cd) {
        if(cd.equals(CompassDirection.NORTH)) return CompassDirection.WEST;
        if(cd.equals(CompassDirection.EAST)) return CompassDirection.NORTH;
        if(cd.equals(CompassDirection.SOUTH)) return CompassDirection.EAST;
        if(cd.equals(CompassDirection.WEST)) return CompassDirection.SOUTH;
        throw new InvalidCompassDirectionException("turnLeft");
    }
}
