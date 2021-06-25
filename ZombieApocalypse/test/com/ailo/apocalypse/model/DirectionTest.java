package com.ailo.apocalypse.model;

import org.junit.Assert;
import org.junit.Test;

public class DirectionTest {
    @Test
    public void rightIsOneStepForwardOnXAxis() {
        //Given
        Direction east = Direction.R;

        //When
        int stepSize = east.stepSizeForXAxis();

        //Then
        Assert.assertEquals(1, stepSize);
    }

    @Test
    public void rightIsStationaryOnYAxis() {
        //Given
        Direction east = Direction.R;

        //When
        int stepSize = east.stepSizeForYAxis();

        //Then
        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void leftIsOneStepBackOnXAxis() {
        //Given
        Direction west = Direction.L;

        //When
        int stepSize = west.stepSizeForXAxis();

        //Then
        Assert.assertEquals(-1, stepSize);
    }


    @Test
    public void leftIsStationaryOnYAxis() {
        //Given
        Direction west = Direction.L;

        //When
        int stepSize = west.stepSizeForYAxis();

        //Then
        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void upIsOneStepForwardOnYAxis() {
        //Given
        Direction north = Direction.U;

        //When
        int stepSize = north.stepSizeForYAxis();

        //Then
        Assert.assertEquals(-1, stepSize);
    }


    @Test
    public void upIsStationaryOnXAxis() {
        //Given
        Direction north = Direction.U;

        //When
        int stepSize = north.stepSizeForXAxis();

        //Then
        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void downIsOneStepBackOnYAxis() {
        //Given
        Direction south = Direction.D;

        //When
        int stepSize = south.stepSizeForYAxis();

        //Then
        Assert.assertEquals(1, stepSize);
    }

    @Test
    public void downIsStationaryOnXAxis() {
        //Given
        Direction south = Direction.D;

        //When
        int stepSize = south.stepSizeForXAxis();

        //Then
        Assert.assertEquals(0, stepSize);
    }
}
