package com.ailo.apocalypse.model;

public class Zombie {
    private Coordinate coordinate;

    public static Zombie from(Creature creature) {
        return new Zombie(creature.getCoordinate());
    }

    //TODO: remove this getter as you are breaking the encapsulation
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Zombie(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void move(Direction direction, int gridSize, int zombieIndex) {
        this.coordinate.updateCoordinate(
                direction.stepSizeForXAxis(),
                direction.stepSizeForYAxis(),
                gridSize
        );

        System.out.println("Zombie " + zombieIndex + " moved to " + coordinate);
    }

    public Zombie convertCreatureAtCurrentIndex(Creature[][] grid, int zombieIndex) {
        Creature creature = grid[coordinate.getxCoordinate()][coordinate.getyCoordinate()];

        //TODO: is putting null safe? why not a constant creature to represent empty location
        grid[coordinate.getxCoordinate()][coordinate.getyCoordinate()] = null;

        System.out.println("Zombie " + zombieIndex + " infected creature at " + coordinate);

        return Zombie.from(creature);
    }
}