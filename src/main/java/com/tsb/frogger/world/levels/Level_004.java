package com.tsb.frogger.world.levels;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.world.LoadComponents;

public class Level_004 implements LevelBase {
    @Override
    public void loadLevel() {
        // bound -270 810
        // END 0
        // RIVER 1
        LoadComponents.addWetTurtle(0, ConstantData.LAYOUT_Y_ACTOR[0][1], 1.5);
        LoadComponents.addShortLog(300, ConstantData.LAYOUT_Y_ACTOR[0][1], 1.5);
        LoadComponents.addWetTurtle(700, ConstantData.LAYOUT_Y_ACTOR[0][1], 1.5);

        LoadComponents.addMediumLog(-50, ConstantData.LAYOUT_Y_ACTOR[0][2], -1.25);
        LoadComponents.addTurtle(250, ConstantData.LAYOUT_Y_ACTOR[0][2], -1.25);
        LoadComponents.addWetTurtle(450, ConstantData.LAYOUT_Y_ACTOR[0][2], -1.25);
        LoadComponents.addWetTurtle(650, ConstantData.LAYOUT_Y_ACTOR[0][2], -1.25);

        LoadComponents.addTurtle(150, ConstantData.LAYOUT_Y_ACTOR[0][3], -2.25);
        LoadComponents.addMediumLog(300, ConstantData.LAYOUT_Y_ACTOR[0][3], -2.25);
        LoadComponents.addWetTurtle(800, ConstantData.LAYOUT_Y_ACTOR[0][3], -2.25);

        LoadComponents.addTurtle(-100, ConstantData.LAYOUT_Y_ACTOR[0][4], 1.25);
        LoadComponents.addShortLog(350, ConstantData.LAYOUT_Y_ACTOR[0][4], 1.25);
        LoadComponents.addShortLog(650, ConstantData.LAYOUT_Y_ACTOR[0][4], 1.25);

        LoadComponents.addWetTurtle(-200, ConstantData.LAYOUT_Y_ACTOR[0][5], -1.5);
        LoadComponents.addWetTurtle(0, ConstantData.LAYOUT_Y_ACTOR[0][5], -1.5);
        LoadComponents.addShortLog(300, ConstantData.LAYOUT_Y_ACTOR[0][5], -1.5);
        LoadComponents.addWetTurtle(600, ConstantData.LAYOUT_Y_ACTOR[0][5], -1.5);
        // RIVER 5
        // GRASS 6
        // ROAD 7
        LoadComponents.addCar(-150, ConstantData.LAYOUT_Y_ACTOR[0][7], 1.75);
        LoadComponents.addShortTruck(50, ConstantData.LAYOUT_Y_ACTOR[0][7], 1.75);
        LoadComponents.addShortTruck(200, ConstantData.LAYOUT_Y_ACTOR[0][7], 1.75);
        LoadComponents.addCar(580, ConstantData.LAYOUT_Y_ACTOR[0][7], 1.75);
        LoadComponents.addLongTruck(780, ConstantData.LAYOUT_Y_ACTOR[0][7], 1.75);

        LoadComponents.addCar( -250, ConstantData.LAYOUT_Y_ACTOR[0][8], -1.75);
        LoadComponents.addLongTruck(-160, ConstantData.LAYOUT_Y_ACTOR[0][8], -1.75);
        LoadComponents.addCar(320, ConstantData.LAYOUT_Y_ACTOR[0][8], -1.75);
        LoadComponents.addShortTruck( 660, ConstantData.LAYOUT_Y_ACTOR[0][8], -1.75);

        LoadComponents.addLongTruck(-150, ConstantData.LAYOUT_Y_ACTOR[0][9], -1.5);
        LoadComponents.addCar(100, ConstantData.LAYOUT_Y_ACTOR[0][9], -1.5);
        LoadComponents.addShortTruck(200, ConstantData.LAYOUT_Y_ACTOR[0][9], -1.5);
        LoadComponents.addCar(350, ConstantData.LAYOUT_Y_ACTOR[0][9], -1.5);
        LoadComponents.addCar(770, ConstantData.LAYOUT_Y_ACTOR[0][9], -1.5);

        LoadComponents.addCar(-200, ConstantData.LAYOUT_Y_ACTOR[0][10], 1.5);
        LoadComponents.addCar(160, ConstantData.LAYOUT_Y_ACTOR[0][10], 1.5);
        LoadComponents.addShortTruck(450, ConstantData.LAYOUT_Y_ACTOR[0][10], 1.5);
        LoadComponents.addCar(780, ConstantData.LAYOUT_Y_ACTOR[0][10], 1.5);

        LoadComponents.addShortTruck(-100, ConstantData.LAYOUT_Y_ACTOR[0][11], -1.75);
        LoadComponents.addCar(300, ConstantData.LAYOUT_Y_ACTOR[0][11], -1.75);
        LoadComponents.addCar(400, ConstantData.LAYOUT_Y_ACTOR[0][11], -1.75);
        LoadComponents.addCar(500, ConstantData.LAYOUT_Y_ACTOR[0][11], -1.75);
        LoadComponents.addLongTruck(650, ConstantData.LAYOUT_Y_ACTOR[0][11], -1.75);
        // ROAD 11
        // START 12
    }
}
