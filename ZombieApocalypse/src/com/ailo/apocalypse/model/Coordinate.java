package com.ailo.apocalypse.model;

import com.ailo.apocalypse.error.ErrorMessage;

public class Coordinate {

    //TODO: state can be final (try to create a value object)
    private int xCoordinate;
    private int yCoordinate;

    //TODO: Why do we need final parameters for primitive type here?
    public Coordinate(final int xCoordinate, final int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    //TODO: remove this getter as you are breaking the encapsulation
    public int getxCoordinate() {
        return xCoordinate;
    }

    //TODO: remove this getter as you are breaking the encapsulation
    public int getyCoordinate() {
        return yCoordinate;
    }

    public boolean isValid(int gridSize) {
        if (xCoordinate < 0 || xCoordinate >= gridSize || yCoordinate < 0 || yCoordinate >= gridSize) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COORDINATE);
        }
        return true;
    }

    //TODO: Why do we need final parameters for primitive type here?
    public void updateCoordinate(final int xCoordinateStepValue, final int yCoordinateStepValue, int gridSize) {
        this.xCoordinate = (this.xCoordinate + xCoordinateStepValue + gridSize) % gridSize;
        this.yCoordinate = (this.yCoordinate + yCoordinateStepValue + gridSize) % gridSize;
    }

    @Override
    public String toString() {
        StringBuilder coordinateOutput = new StringBuilder();

        //TODO: Chaining can be used here
        coordinateOutput.append(xCoordinate);
        coordinateOutput.append(" ");
        coordinateOutput.append(yCoordinate);

        return coordinateOutput.toString();
    }
}
