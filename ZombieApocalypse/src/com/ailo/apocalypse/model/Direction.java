package com.ailo.apocalypse.model;

//TODO: Have more readable names like up, down, right, left
public enum Direction {

    U(0,-1),

    D(0,1),

    R(1,0),

    L(-1,0);

    private final int stepSizeOnXAxis;
    private final int stepSizeOnYAxis;

    Direction(final int stepSizeOnXAxis, final int stepSizeOnYAxis) {
        this.stepSizeOnXAxis = stepSizeOnXAxis;
        this.stepSizeOnYAxis = stepSizeOnYAxis;
    }

    public int stepSizeForXAxis() {
        return this.stepSizeOnXAxis;
    }

    public int stepSizeForYAxis() {
        return this.stepSizeOnYAxis;
    }

}
