package com.ailo.apocalypse.model;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

    @Test
    public void xCoordinatesAreIncrementedForPositiveValue() {
        //Given
        Coordinate coordinate = new Coordinate(2,3);

        //When
        coordinate.updateCoordinate(1, 0, 5);

        //Then
        Assert.assertEquals("3 3", coordinate.toString());
    }

    @Test
    public void xCoordinatesAreDecrementedForNegativeValue() {
        //Given
        Coordinate coordinate = new Coordinate(2,3);

        //When
        coordinate.updateCoordinate(1, 0, 5);

        //Then
        Assert.assertEquals("3 3", coordinate.toString());
    }

    @Test
    public void yCoordinatesAreIncrementedForPositiveValue() {
        //Given
        Coordinate coordinate = new Coordinate(2,3);

        //When
        coordinate.updateCoordinate(0, 1,  5);

        //Then
        Assert.assertEquals("2 4", coordinate.toString());
    }

    @Test
    public void yCoordinatesAreDecrementedForNegativeValue() {
        //Given
        Coordinate coordinate = new Coordinate(2,3);

        //When
        coordinate.updateCoordinate(0, -1,  5);

        //Then
        Assert.assertEquals("2 2", coordinate.toString());
    }

    @Test
    public void xCoordinateOfOppositeSideReturnedWhenItGoesOutOfBounds() {
        //Given
        Coordinate coordinate = new Coordinate(2,2);

        //When
        coordinate.updateCoordinate(1, 0,  3);

        //Then
        Assert.assertEquals("0 2", coordinate.toString());
    }

    @Test
    public void yCoordinateOfOppositeSideReturnedWhenItGoesOutOfBounds() {
        //Given
        Coordinate coordinate = new Coordinate(2,2);

        //When
        coordinate.updateCoordinate(0, 1,  3);

        //Then
        Assert.assertEquals("2 0", coordinate.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfxCoordinateIsLessThan0OrGreaterThanGridSize() {
        //Given
        Coordinate coordinate = new Coordinate(7,2);

        //When
        coordinate.isValid(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfyCoordinateIsLessThan0OrGreaterThanGridSize() {
        //Given
        Coordinate coordinate = new Coordinate(0,6);

        //When
        coordinate.isValid(5);
    }

}
