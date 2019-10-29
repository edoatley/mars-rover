package com.example.marsrover.model;

import java.util.Objects;

public class RoverLocation {
    int x;
    int y;
    CompassDirection dir;

    public RoverLocation(int x, int y, CompassDirection dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CompassDirection getDir() {
        return dir;
    }

    public void setDir(CompassDirection dir) {
        this.dir = dir;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, dir);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoverLocation that = (RoverLocation) o;
        return x == that.x &&
                y == that.y &&
                dir == that.dir;
    }

    @Override
    public String toString() {
        return "RoverLocation{" +
                "x=" + x +
                ", y=" + y +
                ", dir=" + dir +
                '}';
    }
}

