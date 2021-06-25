package com.ailo.apocalypse;

import com.ailo.apocalypse.model.Coordinate;
import com.ailo.apocalypse.model.Direction;
import com.ailo.apocalypse.parser.StringCommandParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("src/test-input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        int gridSize = Integer.parseInt(br.readLine());
        List<Coordinate> zombieCoordinates = new StringCommandParser(br.readLine()).toCoordinates();
        List<Coordinate> creatureCoordinates = new StringCommandParser(br.readLine()).toCoordinates();
        List<Direction> directions = new StringCommandParser(br.readLine()).toCommands();
        World world = new World(gridSize, zombieCoordinates, creatureCoordinates, directions);

        world.spreadVirus();
    }
}