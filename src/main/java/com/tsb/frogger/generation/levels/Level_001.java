package com.tsb.frogger.generation.levels;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.utils.game.ActorLoader;

public class Level_001 implements LevelBase{

    @Override
    public ActorLoader loadLevel(ActorLoader al) {
        // bound -270 810
        // END 0
        // RIVER 1
        al.addLongLog(0, ConstantData.LAYOUT_Y_ACTOR[0][1], 0.75);
        al.addLongLog(300, ConstantData.LAYOUT_Y_ACTOR[0][1], 0.75);
        al.addMediumLog(700, ConstantData.LAYOUT_Y_ACTOR[0][1], 0.75);

        al.addMediumLog(-50, ConstantData.LAYOUT_Y_ACTOR[0][2], -1);
        al.addTurtle(250, ConstantData.LAYOUT_Y_ACTOR[0][2], -1);
        al.addTurtle(450, ConstantData.LAYOUT_Y_ACTOR[0][2], -1);
        al.addTurtle(650, ConstantData.LAYOUT_Y_ACTOR[0][2], -1);

        al.addTurtle(150, ConstantData.LAYOUT_Y_ACTOR[0][3], -2);
        al.addLongLog(300, ConstantData.LAYOUT_Y_ACTOR[0][3], -2);
        al.addLongLog(800, ConstantData.LAYOUT_Y_ACTOR[0][3], -2);

        al.addTurtle(-100, ConstantData.LAYOUT_Y_ACTOR[0][4], 0.75);
        al.addMediumLog(350, ConstantData.LAYOUT_Y_ACTOR[0][4], 0.75);
        al.addMediumLog(650, ConstantData.LAYOUT_Y_ACTOR[0][4], 0.75);

        al.addTurtle(-200, ConstantData.LAYOUT_Y_ACTOR[0][5], -1);
        al.addTurtle(0, ConstantData.LAYOUT_Y_ACTOR[0][5], -1);
        al.addMediumLog(300, ConstantData.LAYOUT_Y_ACTOR[0][5], -1);
        al.addTurtle(600, ConstantData.LAYOUT_Y_ACTOR[0][5], -1);
        // RIVER 5
        // GRASS 6
        // ROAD 7
        al.addCar(-150, ConstantData.LAYOUT_Y_ACTOR[0][7], 1);
        al.addShortTruck(50, ConstantData.LAYOUT_Y_ACTOR[0][7], 1);
        al.addCar(200, ConstantData.LAYOUT_Y_ACTOR[0][7], 1);
        al.addCar(580, ConstantData.LAYOUT_Y_ACTOR[0][7], 1);
        al.addShortTruck(780, ConstantData.LAYOUT_Y_ACTOR[0][7], 1);

        al.addCar( -250, ConstantData.LAYOUT_Y_ACTOR[0][8], -1);
        al.addCar(-160, ConstantData.LAYOUT_Y_ACTOR[0][8], -1);
        al.addCar(320, ConstantData.LAYOUT_Y_ACTOR[0][8], -1);
        al.addCar( 660, ConstantData.LAYOUT_Y_ACTOR[0][8], -1);

        al.addShortTruck(-150, ConstantData.LAYOUT_Y_ACTOR[0][9], -0.75);
        al.addCar(0, ConstantData.LAYOUT_Y_ACTOR[0][9], -0.75);
        al.addShortTruck(200, ConstantData.LAYOUT_Y_ACTOR[0][9], -0.75);
        al.addCar(350, ConstantData.LAYOUT_Y_ACTOR[0][9], -0.75);
        al.addCar(770, ConstantData.LAYOUT_Y_ACTOR[0][9], -0.75);

        al.addCar(-200, ConstantData.LAYOUT_Y_ACTOR[0][10], 0.75);
        al.addCar(160, ConstantData.LAYOUT_Y_ACTOR[0][10], 0.75);
        al.addCar(450, ConstantData.LAYOUT_Y_ACTOR[0][10], 0.75);
        al.addCar(780, ConstantData.LAYOUT_Y_ACTOR[0][10], 0.75);

        al.addShortTruck(-100, ConstantData.LAYOUT_Y_ACTOR[0][11], -1);
        al.addCar(300, ConstantData.LAYOUT_Y_ACTOR[0][11], -1);
        al.addShortTruck(650, ConstantData.LAYOUT_Y_ACTOR[0][11], -1);
        al.addCar(800, ConstantData.LAYOUT_Y_ACTOR[0][11], -1);
        // ROAD 11
        // START 12

        return al;
    }
}
