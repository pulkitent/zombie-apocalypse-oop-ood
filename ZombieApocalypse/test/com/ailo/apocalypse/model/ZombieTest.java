package com.ailo.apocalypse.model;

import org.junit.Assert;
import org.junit.Test;

public class ZombieTest {

    @Test
    public void zombieShouldMoveToRightDirectionWhenRCommandIsGiven() {
        //Given
        int gridSize = 5;
        Coordinate coordinate = new Coordinate(2, 3);
        Zombie zombie = new Zombie(coordinate);

        //When
        zombie.move(Direction.R, gridSize, 1);

        //Then
        Assert.assertEquals("3 3", zombie.getCoordinate().toString());
    }

    @Test
    public void zombieShouldMoveToLeftDirectionWhenLCommandIsGiven() {
        //Given
        int gridSize = 5;
        Coordinate coordinate = new Coordinate(2, 3);
        Zombie zombie = new Zombie(coordinate);

        //When
        zombie.move(Direction.L, gridSize, 1);

        //Then
        Assert.assertEquals("1 3", zombie.getCoordinate().toString());
    }

    @Test
    public void zombieShouldMoveToUpwardDirectionWhenUCommandIsGiven() {
        //Given
        int gridSize = 5;
        Coordinate coordinate = new Coordinate(2, 3);
        Zombie zombie = new Zombie(coordinate);

        //When
        zombie.move(Direction.U, gridSize, 1);

        //Then
        Assert.assertEquals("2 2", zombie.getCoordinate().toString());
    }

    @Test
    public void zombieShouldMoveToDownwardDirectionWhenDCommandIsGiven() {
        //Given
        int gridSize = 5;
        Coordinate coordinate = new Coordinate(2, 3);
        Zombie zombie = new Zombie(coordinate);

        //When
        zombie.move(Direction.D, gridSize, 1);

        //Then
        Assert.assertEquals("2 4", zombie.getCoordinate().toString());
    }

    @Test
    public void zombieShouldMoveThroughEdgeAlongYAxisWhenItGoesOutOfBoundsOfGrid() {
        //Given
        int gridSize = 5;
        Coordinate coordinate = new Coordinate(4, 4);
        Zombie zombie = new Zombie(coordinate);

        //When
        zombie.move(Direction.D, gridSize, 1);

        //Then
        Assert.assertEquals("4 0", zombie.getCoordinate().toString());
    }

    @Test
    public void zombieShouldMoveThroughEdgeAlongXAxisWhenItGoesOutOfBoundsOfGrid() {
        //Given
        int gridSize = 5;
        Coordinate coordinate = new Coordinate(4, 4);
        Zombie zombie = new Zombie(coordinate);

        //When
        zombie.move(Direction.R, gridSize, 1);

        //Then
        Assert.assertEquals("0 4", zombie.getCoordinate().toString());
    }
}