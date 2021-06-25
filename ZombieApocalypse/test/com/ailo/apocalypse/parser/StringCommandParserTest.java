package com.ailo.apocalypse.parser;

import com.ailo.apocalypse.model.Coordinate;
import com.ailo.apocalypse.model.Direction;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StringCommandParserTest {

    @Test
    public void stringLMapsToMoveLeftCommand() {
        //Given
        StringCommandParser parser = new StringCommandParser("L");

        //When
        List<Direction> commands = parser.toCommands();

        //Then
        Assert.assertEquals(commands.get(0), Direction.L);
        Assert.assertEquals(1, commands.size());
    }

    @Test
    public void stringRMapsToMoveRightCommand() {
        //Given
        StringCommandParser parser = new StringCommandParser("R");

        //When
        List<Direction> commands = parser.toCommands();

        //Then
        Assert.assertEquals(commands.get(0), Direction.R);
        Assert.assertEquals(1, commands.size());
    }

    @Test
    public void stringDMapsToMoveDownCommand() {
        //Given
        StringCommandParser parser = new StringCommandParser("D");

        //When
        List<Direction> commands = parser.toCommands();

        //Then
        Assert.assertEquals(commands.get(0), Direction.D);
        Assert.assertEquals(1, commands.size());
    }

    @Test
    public void emptyStringResultsInEmptyCommandList() {
        //Given
        StringCommandParser parser = new StringCommandParser("");

        //When
        List<Direction> commands = parser.toCommands();

        //Then
        Assert.assertEquals(0, commands.size());
    }

    @Test
    public void nullStringResultsInEmptyCommandList() {
        //Given
        StringCommandParser parser = new StringCommandParser(null);

        //When
        List<Direction> commands = parser.toCommands();

        //Then
        Assert.assertEquals(0, commands.size());
    }

    @Test
    public void stringToCommandMappingIsCaseInsensitive() {
        //Given
        StringCommandParser parser = new StringCommandParser("Rr");

        //When
        List<Direction> commands = parser.toCommands();

        //Then
        Assert.assertEquals(commands.get(0), Direction.R);
        Assert.assertEquals(commands.get(1), Direction.R);
        Assert.assertEquals(2, commands.size());
    }

    @Test
    public void multiCommandStringIsMappedToCommandsInSameOrder() {
        //Given
        StringCommandParser parser = new StringCommandParser("RDU");

        //When
        List<Direction> commands = parser.toCommands();

        //Then
        Assert.assertEquals(commands.get(0), Direction.R);
        Assert.assertEquals(commands.get(1), Direction.D);
        Assert.assertEquals(commands.get(2), Direction.U);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInvalidCommandCharacterIsSent() {
        //Given
        StringCommandParser parser = new StringCommandParser("RDUx");

        //When
        parser.toCommands();
    }

    @Test
    public void inputStringMapsToListOfCoordinates() {
        //Given
        StringCommandParser parser = new StringCommandParser("1,2 3,4 5,6");

        //When
        List<Coordinate> coordinates = parser.toCoordinates();

        //Then
        Assert.assertEquals(3, coordinates.size());
        Assert.assertEquals(1, coordinates.get(0).getxCoordinate());
        Assert.assertEquals(2, coordinates.get(0).getyCoordinate());
    }
}
