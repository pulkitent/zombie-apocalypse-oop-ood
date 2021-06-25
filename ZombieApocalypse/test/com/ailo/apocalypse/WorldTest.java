package com.ailo.apocalypse;

import com.ailo.apocalypse.model.Coordinate;
import com.ailo.apocalypse.model.Direction;
import com.ailo.apocalypse.parser.StringCommandParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WorldTest {

    int gridSize;
    List<Coordinate> zombieCoordinates;
    List<Coordinate> creatureCoordinates;
    List<Direction> commandString;

    @Before
    public void setUp() {
        gridSize = 5;
        zombieCoordinates = populateZombieCoordinates();
        creatureCoordinates = populateCreatureCoordinates();
        commandString = new StringCommandParser("LRDU").toCommands();
    }

    @Test
    public void initialCountOfZombiesAndCreaturesIsUnchanged() {
        //Given
        World world = new World(gridSize, zombieCoordinates, creatureCoordinates, commandString);

        //Then
        Assert.assertEquals(1, world.getZombies().size());
        Assert.assertEquals(3, world.getCreatures().size());
    }

    @Test
    public void zombieInfectsCreatureAtItsLeftInA5x5Grid() {
        //Given
        World world = new World(gridSize, zombieCoordinates, creatureCoordinates, commandString);

        //When
        world.spreadVirus();

        //Then
        Assert.assertEquals(2, world.getZombies().size());
        Assert.assertEquals(2, world.getCreatures().size());
    }

    private ArrayList<Coordinate> populateCreatureCoordinates() {
        Coordinate firstCreatureCoordinate = new Coordinate(1, 3);
        Coordinate secondCreatureCoordinate = new Coordinate(3, 2);
        Coordinate thirdCreatureCoordinate = new Coordinate(2, 2);
        ArrayList<Coordinate> creatureCoordinate = new ArrayList<>();
        creatureCoordinate.add(firstCreatureCoordinate);
        creatureCoordinate.add(secondCreatureCoordinate);
        creatureCoordinate.add(thirdCreatureCoordinate);
        return creatureCoordinate;
    }

    private ArrayList<Coordinate> populateZombieCoordinates() {
        Coordinate coordinate = new Coordinate(2, 3);
        ArrayList<Coordinate> zombieCoordinate = new ArrayList<>();
        zombieCoordinate.add(coordinate);
        return zombieCoordinate;
    }
}