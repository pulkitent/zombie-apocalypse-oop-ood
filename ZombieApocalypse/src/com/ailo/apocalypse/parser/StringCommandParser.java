package com.ailo.apocalypse.parser;

import com.ailo.apocalypse.error.ErrorMessage;
import com.ailo.apocalypse.model.Coordinate;
import com.ailo.apocalypse.model.Direction;

import java.util.*;

public class StringCommandParser {

    //TODO: Why public? Are being used outside?
    //TODO: Do we really need constant at class level for this? As they are just being used only once? Can we make them local?
    public static final String BY_EACH_CHARACTER = "";
    public static final String SPACE_DELIMITER = " ";
    public static final String COMMA_DELIMITER = ",";
    public static final int START_INDEX = 0;

    //TODO: Diamond operator can be empty, applicable to whole class
    //TODO: Not a recommended way of doing initialization
    private static Map<String, Direction> stringToCommandMap = new HashMap<String, Direction>() {{
        put("L", Direction.L);
        put("R", Direction.R);
        put("U", Direction.U);
        put("D", Direction.D);
    }};

    private final String inputString;

    public StringCommandParser(final String inputString) {
        this.inputString = inputString;
    }

    public List<Direction> toCommands() {
        if (isNullOrEmpty(inputString)) return new ArrayList<Direction>();
        return buildCommandsList(inputString);
    }

    public List<Coordinate> toCoordinates() {
        if (isNullOrEmpty(inputString)) return new ArrayList<Coordinate>();
        return buildCoordinateList(inputString);
    }

    private List<Coordinate> buildCoordinateList(String inputString) {
        List<Coordinate> coordinates = new ArrayList<Coordinate>();

        for (String coordinate : splitInputString(inputString, SPACE_DELIMITER)) {
            if (coordinate == null) break;
            coordinates.add(getCoordinate(coordinate));
        }
        return coordinates;
    }

    private Coordinate getCoordinate(final String inputString) {
        String[] coordinates = splitInputString(inputString, COMMA_DELIMITER);
        int xCoordinate = Integer.parseInt(coordinates[0]);
        int yCoordinate = Integer.parseInt(coordinates[1]);
        return new Coordinate(xCoordinate, yCoordinate);
    }

    private List<Direction> buildCommandsList(final String inputString) {
        List<Direction> commands = new ArrayList<Direction>();

        for (String commandCharacter : splitInputString(inputString, BY_EACH_CHARACTER)) {
            if (commandCharacter == null) break;
            Direction mappedCommand = lookupEquivalentCommand(commandCharacter.toUpperCase());
            commands.add(mappedCommand);
        }

        return commands;
    }

    private boolean isNullOrEmpty(final String inputString) {
        return (null == inputString || inputString.trim().length() == 0);
    }

    private String[] splitInputString(final String inputString, final String delimiter) {
        return Arrays.copyOfRange(inputString.split(delimiter), START_INDEX, inputString.length() + 1);
    }

    private Direction lookupEquivalentCommand(final String inputString) {
        Direction direction = stringToCommandMap.get(inputString);
        if(direction == null){
            throw new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION);
        }
        return direction;
    }

}
