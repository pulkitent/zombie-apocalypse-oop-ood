package com.ailo.apocalypse;

import com.ailo.apocalypse.error.ErrorMessage;
import com.ailo.apocalypse.model.Coordinate;
import com.ailo.apocalypse.model.Creature;
import com.ailo.apocalypse.model.Direction;
import com.ailo.apocalypse.model.Zombie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//TODO: Seems like a God class majority of application logic resides here. try to fix it by removing getters from other models and introducing the behavious in them
public class World {
    //TODO: Use interfaces rather than concrete implementation for more flexibility (Upcasting can be used here)
    ArrayList<Zombie> zombies = new ArrayList<>();

    //TODO: Use interfaces rather than concrete implementation for more flexibility (Upcasting can be used here)
    HashSet<Creature> creatures = new HashSet<>();

    //TODO: Does it make sense to call a 2D array of type creature as grid?
    //TODO: Why 2D array? Why not more object oriented way having a list?
    Creature[][] grid;
    List<Direction> directions;

    //TODO: What's the use of this unused default constructor?
    private World() {
    }

    public World(int gridSize, List<Coordinate> zombieCoordinates, List<Coordinate> creatureCoordinates,
                 List<Direction> directions) {
        initiate(gridSize, zombieCoordinates, creatureCoordinates, directions);
    }

    private void initiate(int gridSize, List<Coordinate> zombieCoordinates, List<Coordinate> creatureCoordinates,
            List<Direction> directions) {
        if (gridSize <= 0) throw new IllegalArgumentException(ErrorMessage.INVALID_GRID_SIZE);
        grid = new Creature[gridSize][gridSize];

        for (Coordinate coordinate : zombieCoordinates) {
            if (coordinate.isValid(gridSize)) zombies.add(new Zombie(coordinate));
        }

        for (Coordinate coordinate : creatureCoordinates) {
            if (coordinate.isValid(gridSize)) {
                Creature creature = new Creature(coordinate);
                grid[coordinate.getxCoordinate()][coordinate.getyCoordinate()] = creature;
                creatures.add(creature);
            }
        }

        this.directions = directions;
    }

    //TODO: Use only one level on indentation in this method, use extract method to extract out inner for loop
    public void spreadVirus() {
        for (int zombieIndex = 0; zombieIndex < zombies.size(); zombieIndex++) {
            Zombie zombie = zombies.get(zombieIndex);
            for (Direction direction : directions) {
                zombie.move(direction, grid.length, zombieIndex);
                if (isCreaturePresentAtCurrentPosition(zombie.getCoordinate())) {
                    Creature creature = getCreatureAt(zombie.getCoordinate());
                    creatures.remove(creature);
                    Zombie newZombie = zombie.convertCreatureAtCurrentIndex(grid, zombieIndex);
                    zombies.add(newZombie);
                }
            }
        }
        printFinalState();
    }

    //TODO: Why world has the responsibility of printing the state? Why not a separate class to do IO
    private void printFinalState() {
        System.out.println("zombies’ positions:");
        for (Zombie zombie : zombies) {
            System.out.println(zombie.getCoordinate());
        }
        System.out.println("creatures’ positions:");
        for (Creature creature : creatures) {
            System.out.println(creature.getCoordinate());
        }
    }

    //TODO: Just for the sake of unit testing do we add getters?
    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    //TODO: Just for the sake of unit testing do we add getters?
    public HashSet<Creature> getCreatures() {
        return creatures;
    }

    private Creature getCreatureAt(Coordinate coordinate) {
        return grid[coordinate.getxCoordinate()][coordinate.getyCoordinate()];
    }

    private boolean isCreaturePresentAtCurrentPosition(Coordinate coordinate) {
        Creature creature = grid[coordinate.getxCoordinate()][coordinate.getyCoordinate()];
        return creature != null;
    }
}