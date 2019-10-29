package com.example.marsrover;

import com.example.marsrover.model.CompassDirection;
import com.example.marsrover.model.Grid;
import com.example.marsrover.model.Rover;
import com.example.marsrover.model.RoverLocation;
import com.example.marsrover.service.RoverMover;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiRoversTest {

    RoverMover roverMover = new RoverMover();;

    @Test
    public void testMoveTwoUp() {
        // given
        Grid grid = new Grid(5,5);
        Rover rover1 = new Rover(new RoverLocation(1,2, CompassDirection.NORTH), "LMLMLMLMM");
        Rover rover2 = new Rover(new RoverLocation(3,3, CompassDirection.EAST), "MMRMMRMRRM");

        // when
        roverMover.move(new Rover[]{rover1, rover2}, grid);

        // then
        assertThat(rover1.getEndPosition()).isEqualTo(new RoverLocation(1,3, CompassDirection.NORTH));
        assertThat(rover2.getEndPosition()).isEqualTo(new RoverLocation(5,1, CompassDirection.EAST));
    }
}
