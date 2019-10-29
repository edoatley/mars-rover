package com.example.marsrover;

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
                    y++;
            }
        }

        rover.setEndPosition(new RoverLocation(x, y, cd));
        rover.setHasMoved(true);
    }
}
