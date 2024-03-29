package com.example.marsrover;

import com.example.marsrover.model.CompassDirection;
import com.example.marsrover.model.Grid;
import com.example.marsrover.model.Rover;
import com.example.marsrover.model.RoverLocation;
import com.example.marsrover.service.RoverMover;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
The Mars Rover Kata

A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular,
must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to
send back to Earth.

A rover’s position and location is represented by a combination of x and y co-ordinates and a letter representing
 one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation.
 An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.

In order to control a rover, NASA sends a simple string of letters.
The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin 90 degrees left or right respectively,
without moving from its current spot. ‘M’ means move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

INPUT:

The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input.
The first line gives the rover’s position, and the second line is a series of instructions telling the rover how to
explore the plateau. The position is made up of two integers and a letter separated by spaces, corresponding to the x
and y co-ordinates and the rover’s orientation.


Each rover will be finished sequentially, which means that the second rover won’t start to move until the first one has
finished moving.

OUTPUT:

The output for each rover should be its final co-ordinates and heading.

EXAMPLE:
Test Input:

5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM

Expected Output:

1 3 N
5 1 E

* * * * *
* E * * *
* S * * *
* * * * *
* * * * *

 */
public class SimpleUseCasesMarsRoverTest {

    RoverMover roverMover = new RoverMover();;

    @Test
    public void testMoveTwoUp() {
        // given
        Grid grid = new Grid(5,5);
        Rover rover = new Rover(new RoverLocation(0,0, CompassDirection.NORTH), "MM");

        // when
        roverMover.move(toArray(rover), grid);

        // then
        assertThat(rover.getEndPosition()).isEqualTo(new RoverLocation(0,2, CompassDirection.NORTH));
    }

    @Test
    public void testMoveOneUpAndOneAcross() {
        // given
        Grid grid = new Grid(5,5);
        Rover rover = new Rover(new RoverLocation(0,0, CompassDirection.NORTH), "MRM");

        // when
        roverMover.move(toArray(rover), grid);

        // then
        assertThat(rover.getEndPosition()).isEqualTo(new RoverLocation(1,1, CompassDirection.EAST));
    }

    @Test
    public void testMovingInCircles() {
        // given
        Grid grid = new Grid(5,5);
        Rover rover = new Rover(new RoverLocation(1,2, CompassDirection.NORTH), "LMLMLMLMM");

        // when
        roverMover.move(toArray(rover), grid);

        // then
        assertThat(rover.getEndPosition()).isEqualTo(new RoverLocation(1,3, CompassDirection.NORTH));
    }

    @Test
    public void testMovingABit() {
        // given
        Grid grid = new Grid(5,5);
        Rover rover = new Rover(new RoverLocation(3,3, CompassDirection.EAST), "MMRMMRMRRM");

        // when
        roverMover.move(toArray(rover), grid);

        // then
        assertThat(rover.getEndPosition()).isEqualTo(new RoverLocation(5,1, CompassDirection.EAST));
    }

    private Rover[] toArray(Rover rover) {
        return new Rover[] {rover};
    }


}
