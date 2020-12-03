package com.tsb.frogger.world.levels;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.world.LoadComponents;
import com.tsb.frogger.world.MyStage;

public class LevelOne implements LevelBase{

    @Override
    public void loadLevel(MyStage gamePane) {
        // bound -270 810
        // END 0
        // RIVER 1
        LoadComponents.addLongLog(0, ConstantData.LAYOUT_Y_ACTOR[0][1], 0.75);
        LoadComponents.addLongLog(300, ConstantData.LAYOUT_Y_ACTOR[0][1], 0.75);
        LoadComponents.addMediumLog(700, ConstantData.LAYOUT_Y_ACTOR[0][1], 0.75);

        LoadComponents.addMediumLog(-50, ConstantData.LAYOUT_Y_ACTOR[0][2], -1);
        LoadComponents.addTurtle(250, ConstantData.LAYOUT_Y_ACTOR[0][2], -1);
        LoadComponents.addTurtle(450, ConstantData.LAYOUT_Y_ACTOR[0][2], -1);
        LoadComponents.addTurtle(650, ConstantData.LAYOUT_Y_ACTOR[0][2], -1);

        LoadComponents.addTurtle(150, ConstantData.LAYOUT_Y_ACTOR[0][3], -2);
        LoadComponents.addLongLog(300, ConstantData.LAYOUT_Y_ACTOR[0][3], -2);
        LoadComponents.addLongLog(800, ConstantData.LAYOUT_Y_ACTOR[0][3], -2);

        LoadComponents.addTurtle(-100, ConstantData.LAYOUT_Y_ACTOR[0][4], 0.75);
        LoadComponents.addMediumLog(350, ConstantData.LAYOUT_Y_ACTOR[0][4], 0.75);
        LoadComponents.addMediumLog(650, ConstantData.LAYOUT_Y_ACTOR[0][4], 0.75);

        LoadComponents.addTurtle(-200, ConstantData.LAYOUT_Y_ACTOR[0][5], -1);
        LoadComponents.addTurtle(0, ConstantData.LAYOUT_Y_ACTOR[0][5], -1);
        LoadComponents.addMediumLog(300, ConstantData.LAYOUT_Y_ACTOR[0][5], -1);
        LoadComponents.addTurtle(600, ConstantData.LAYOUT_Y_ACTOR[0][5], -1);
        // RIVER 5
        // GRASS 6
        // ROAD 7
        LoadComponents.addCar(-150, ConstantData.LAYOUT_Y_ACTOR[0][7], 0.75);
        LoadComponents.addShortTruck(180, ConstantData.LAYOUT_Y_ACTOR[0][7], 0.75);
        LoadComponents.addCar(380, ConstantData.LAYOUT_Y_ACTOR[0][7], 0.75);
        LoadComponents.addShortTruck(480, ConstantData.LAYOUT_Y_ACTOR[0][7], 0.75);
        LoadComponents.addCar(680, ConstantData.LAYOUT_Y_ACTOR[0][7], 0.75);
        LoadComponents.addShortTruck(780, ConstantData.LAYOUT_Y_ACTOR[0][7], 0.75);

        LoadComponents.addCar( -250, ConstantData.LAYOUT_Y_ACTOR[0][8], -1);
        LoadComponents.addCar(-160, ConstantData.LAYOUT_Y_ACTOR[0][8], -1);
        LoadComponents.addCar(340, ConstantData.LAYOUT_Y_ACTOR[0][8], -1);
        LoadComponents.addCar(560, ConstantData.LAYOUT_Y_ACTOR[0][8], -1);
        LoadComponents.addCar( 770, ConstantData.LAYOUT_Y_ACTOR[0][8], -1);

        LoadComponents.addShortTruck(-150, ConstantData.LAYOUT_Y_ACTOR[0][9], -0.75);
        LoadComponents.addCar(0, ConstantData.LAYOUT_Y_ACTOR[0][9], -0.75);
        LoadComponents.addShortTruck(200, ConstantData.LAYOUT_Y_ACTOR[0][9], -0.75);
        LoadComponents.addCar(350, ConstantData.LAYOUT_Y_ACTOR[0][9], -0.75);
        LoadComponents.addShortTruck(500, ConstantData.LAYOUT_Y_ACTOR[0][9], -0.75);
        LoadComponents.addCar(770, ConstantData.LAYOUT_Y_ACTOR[0][9], -0.75);

        LoadComponents.addCar(-200, ConstantData.LAYOUT_Y_ACTOR[0][10], 0.75);
        LoadComponents.addCar(0, ConstantData.LAYOUT_Y_ACTOR[0][10], 0.75);
        LoadComponents.addCar(300, ConstantData.LAYOUT_Y_ACTOR[0][10], 0.75);
        LoadComponents.addCar(500, ConstantData.LAYOUT_Y_ACTOR[0][10], 0.75);
        LoadComponents.addCar(700, ConstantData.LAYOUT_Y_ACTOR[0][10], 0.75);
        LoadComponents.addCar(800, ConstantData.LAYOUT_Y_ACTOR[0][10], 0.75);

        LoadComponents.addShortTruck(-100, ConstantData.LAYOUT_Y_ACTOR[0][11], -1);
        LoadComponents.addCar(300, ConstantData.LAYOUT_Y_ACTOR[0][11], -1);
        LoadComponents.addShortTruck(650, ConstantData.LAYOUT_Y_ACTOR[0][11], -1);
        LoadComponents.addCar(800, ConstantData.LAYOUT_Y_ACTOR[0][11], -1);
        // ROAD 11
        // START 12

    }
}
