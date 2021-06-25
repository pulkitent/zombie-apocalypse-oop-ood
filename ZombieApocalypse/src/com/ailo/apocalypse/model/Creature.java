package com.ailo.apocalypse.model;

//TODO: Do we really need this class as it doesn't have any behaviour?
public class Creature {
    private final Coordinate coordinate;

    //TODO: remove this getter as you are breaking the encapsulation
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Creature(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}