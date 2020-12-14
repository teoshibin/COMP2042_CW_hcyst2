package com.tsb.frogger.graphics.levels;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.utils.game.ActorLoader;

public class Level_003 implements LevelBase{
    @Override
    public ActorLoader loadLevel(ActorLoader al) {
        // bound -270 810
        // END 0
        // RIVER 1
        al.addMediumLog(0, ConstantData.LAYOUT_Y_ACTOR[0][1], 1.5);
        al.addShortLog(300, ConstantData.LAYOUT_Y_ACTOR[0][1], 1.5);
        al.addMediumLog(700, ConstantData.LAYOUT_Y_ACTOR[0][1], 1.5);

        al.addMediumLog(-50, ConstantData.LAYOUT_Y_ACTOR[0][2], -1.25);
        al.addTurtle(250, ConstantData.LAYOUT_Y_ACTOR[0][2], -1.25);
        al.addWetTurtle(450, ConstantData.LAYOUT_Y_ACTOR[0][2], -1.25);
        al.addWetTurtle(650, ConstantData.LAYOUT_Y_ACTOR[0][2], -1.25);

        al.addTurtle(150, ConstantData.LAYOUT_Y_ACTOR[0][3], -2.25);
        al.addLongLog(300, ConstantData.LAYOUT_Y_ACTOR[0][3], -2.25);
        al.addMediumLog(800, ConstantData.LAYOUT_Y_ACTOR[0][3], -2.25);

        al.addTurtle(-100, ConstantData.LAYOUT_Y_ACTOR[0][4], 1.25);
        al.addMediumLog(350, ConstantData.LAYOUT_Y_ACTOR[0][4], 1.25);
        al.addMediumLog(650, ConstantData.LAYOUT_Y_ACTOR[0][4], 1.25);

        al.addTurtle(-200, ConstantData.LAYOUT_Y_ACTOR[0][5], -1.5);
        al.addWetTurtle(0, ConstantData.LAYOUT_Y_ACTOR[0][5], -1.5);
        al.addMediumLog(300, ConstantData.LAYOUT_Y_ACTOR[0][5], -1.5);
        al.addWetTurtle(600, ConstantData.LAYOUT_Y_ACTOR[0][5], -1.5);
        // RIVER 5
        // GRASS 6
        // ROAD 7
        al.addCar(-150, ConstantData.LAYOUT_Y_ACTOR[0][7], 1.5);
        al.addShortTruck(50, ConstantData.LAYOUT_Y_ACTOR[0][7], 1.5);
        al.addCar(200, ConstantData.LAYOUT_Y_ACTOR[0][7], 1.5);
        al.addCar(580, ConstantData.LAYOUT_Y_ACTOR[0][7], 1.5);
        al.addShortTruck(780, ConstantData.LAYOUT_Y_ACTOR[0][7], 1.5);

        al.addCar( -250, ConstantData.LAYOUT_Y_ACTOR[0][8], -1.5);
        al.addLongTruck(-160, ConstantData.LAYOUT_Y_ACTOR[0][8], -1.5);
        al.addCar(320, ConstantData.LAYOUT_Y_ACTOR[0][8], -1.5);
        al.addShortTruck( 660, ConstantData.LAYOUT_Y_ACTOR[0][8], -1.5);

        al.addLongTruck(-150, ConstantData.LAYOUT_Y_ACTOR[0][9], -1.25);
        al.addCar(150, ConstantData.LAYOUT_Y_ACTOR[0][9], -1.25);
        al.addShortTruck(200, ConstantData.LAYOUT_Y_ACTOR[0][9], -1.25);
        al.addCar(350, ConstantData.LAYOUT_Y_ACTOR[0][9], -1.25);
        al.addCar(770, ConstantData.LAYOUT_Y_ACTOR[0][9], -1.25);

        al.addCar(-200, ConstantData.LAYOUT_Y_ACTOR[0][10], 1.25);
        al.addCar(160, ConstantData.LAYOUT_Y_ACTOR[0][10], 1.25);
        al.addCar(450, ConstantData.LAYOUT_Y_ACTOR[0][10], 1.25);
        al.addCar(780, ConstantData.LAYOUT_Y_ACTOR[0][10], 1.25);

        al.addShortTruck(-100, ConstantData.LAYOUT_Y_ACTOR[0][11], -1.25);
        al.addCar(300, ConstantData.LAYOUT_Y_ACTOR[0][11], -1.25);
        al.addShortTruck(650, ConstantData.LAYOUT_Y_ACTOR[0][11], -1.25);
        al.addCar(800, ConstantData.LAYOUT_Y_ACTOR[0][11], -1.25);
        // ROAD 11
        // START 12
        return al;
    }
}
