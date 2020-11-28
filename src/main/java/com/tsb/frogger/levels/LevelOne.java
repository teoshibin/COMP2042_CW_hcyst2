package com.tsb.frogger.levels;

import com.tsb.frogger.actors.*;
import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.core.LoadComponents;
import com.tsb.frogger.world.MyStage;

public class LevelOne implements LevelBase{

    @Override
    public MyStage loadLevel(MyStage gamePane) {

        // END 0
        // RIVER 1
        LoadComponents.addShortLog(0, ConstantData.LAYOUT_Y_ACTOR[0][1], 0.75);
        LoadComponents.addShortLog(198, ConstantData.LAYOUT_Y_ACTOR[0][1], 0.75);
        LoadComponents.addShortLog(396, ConstantData.LAYOUT_Y_ACTOR[0][1], 0.75);

        LoadComponents.addTurtle(100, ConstantData.LAYOUT_Y_ACTOR[0][2], -1);
        LoadComponents.addWetTurtle(250, ConstantData.LAYOUT_Y_ACTOR[0][2], -1);
        LoadComponents.addWetTurtle(450, ConstantData.LAYOUT_Y_ACTOR[0][2], -1);

        LoadComponents.addLongLog(0, ConstantData.LAYOUT_Y_ACTOR[0][3], -2);
        LoadComponents.addLongLog(360, ConstantData.LAYOUT_Y_ACTOR[0][3], -2);

        LoadComponents.addShortLog(45, ConstantData.LAYOUT_Y_ACTOR[0][4], 0.75);
        LoadComponents.addShortLog(240, ConstantData.LAYOUT_Y_ACTOR[0][4], 0.75);
        LoadComponents.addShortLog(440, ConstantData.LAYOUT_Y_ACTOR[0][4], 0.75);

        LoadComponents.addTurtle(100, ConstantData.LAYOUT_Y_ACTOR[0][5], -1);
        LoadComponents.addWetTurtle(350, ConstantData.LAYOUT_Y_ACTOR[0][5], -1);
        // RIVER 5
        // GRASS 6
        // ROAD 7
        LoadComponents.addCar(200, ConstantData.LAYOUT_Y_ACTOR[0][7], -5);
        LoadComponents.addCar(300, ConstantData.LAYOUT_Y_ACTOR[0][7], -5);

        LoadComponents.addLongTruck(0, ConstantData.LAYOUT_Y_ACTOR[0][8], 1);
        LoadComponents.addLongTruck(500, ConstantData.LAYOUT_Y_ACTOR[0][8], 1);

        LoadComponents.addCar(100, ConstantData.LAYOUT_Y_ACTOR[0][9], -1);
        LoadComponents.addCar(250, ConstantData.LAYOUT_Y_ACTOR[0][9], -1);
        LoadComponents.addCar(400, ConstantData.LAYOUT_Y_ACTOR[0][9], -1);

        LoadComponents.addShortTruck(0, ConstantData.LAYOUT_Y_ACTOR[0][10], 1);
        LoadComponents.addShortTruck(300, ConstantData.LAYOUT_Y_ACTOR[0][10], 1);
        LoadComponents.addShortTruck(500, ConstantData.LAYOUT_Y_ACTOR[0][10], 1);

        LoadComponents.addShortTruck(100, ConstantData.LAYOUT_Y_ACTOR[0][11], -1);
        LoadComponents.addShortTruck(250, ConstantData.LAYOUT_Y_ACTOR[0][11], -1);
        LoadComponents.addShortTruck(400, ConstantData.LAYOUT_Y_ACTOR[0][11], -1);
        // ROAD 11
        // START 12

        return gamePane;
    }
}
