package com.tsb.frogger.utils.game;

import com.tsb.frogger.core.ConstantData;
import com.tsb.frogger.utils.data.datamanager.PropertiesDao;
import com.tsb.frogger.utils.data.datamanager.PropertiesDaoImpl;
import com.tsb.frogger.utils.exceptions.LevelNotFoundException;
import com.tsb.frogger.graphics.actors.*;
import com.tsb.frogger.graphics.world.MyStage;

/**
 * class contains static methods for loading gamePane components
 */
public class ActorLoader {

    /**
     * temp MyStage for loading levels
     */
    private MyStage gamePane;
    private int level;

    public ActorLoader(MyStage gamePane, int level) {
        this.gamePane = gamePane;
        this.level = level;
    }

    public MyStage loadActors() throws LevelNotFoundException {
        return LevelSelector.selectLevel(this, level).gamePane;
    }

    /**
     * add ending actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     */
    public void addEnd(int layoutX, int layoutY){
        gamePane.add(new End(layoutX, layoutY));
    }
    /**
     * add short log actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public void addShortLog(int layoutX, int layoutY, double speed){
        PropertiesDao pd = new PropertiesDaoImpl();
        gamePane.add(new Log(pd.getExternal("image.actor.log.short"), ConstantData.SIZE_SHORT_LOG, layoutX, layoutY, speed));
    }
    /**
     * add medium log actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public void addMediumLog(int layoutX, int layoutY, double speed){
        PropertiesDao pd = new PropertiesDaoImpl();
        gamePane.add(new Log(pd.getExternal("image.actor.log.medium"), ConstantData.SIZE_MEDIUM_LOG, layoutX, layoutY, speed));
    }
    /**
     * add long log actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public void addLongLog(int layoutX, int layoutY, double speed){
        PropertiesDao pd = new PropertiesDaoImpl();
        gamePane.add(new Log(pd.getExternal("image.actor.log.long"), ConstantData.SIZE_LONG_LOG, layoutX, layoutY, speed));
    }
    /**
     * add turtle actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public void addTurtle(int layoutX, int layoutY, double speed){
        gamePane.add(new Turtle(layoutX, layoutY, speed, ConstantData.SIZE_TURTLE, ConstantData.SIZE_TURTLE));
    }
    /**
     * add wet turtle actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public void addWetTurtle(int layoutX, int layoutY, double speed){
        gamePane.add(new WetTurtle(layoutX, layoutY, speed, ConstantData.SIZE_TURTLE, ConstantData.SIZE_TURTLE));
    }
    /**
     * add short truck actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public void addShortTruck(int layoutX, int layoutY, double speed){
        PropertiesDao pd = new PropertiesDaoImpl();
        if (speed > 0){
            gamePane.add(new Obstacle(pd.getExternal("image.actor.truck.right.short"), layoutX, layoutY, speed, ConstantData.SIZE_SHORT_TRUCK, ConstantData.SIZE_SHORT_TRUCK));
        } else {
            gamePane.add(new Obstacle(pd.getExternal("image.actor.truck.left.short"), layoutX, layoutY, speed, ConstantData.SIZE_SHORT_TRUCK, ConstantData.SIZE_SHORT_TRUCK));
        }
    }
    /**
     * add long truck actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public void addLongTruck(int layoutX, int layoutY, double speed){
        PropertiesDao pd = new PropertiesDaoImpl();
        if (speed > 0){
            gamePane.add(new Obstacle(pd.getExternal("image.actor.truck.right.long"), layoutX, layoutY, speed, ConstantData.SIZE_LONG_TRUCK, ConstantData.SIZE_LONG_TRUCK));
        } else {
            gamePane.add(new Obstacle(pd.getExternal("image.actor.truck.left.long"), layoutX, layoutY, speed, ConstantData.SIZE_LONG_TRUCK, ConstantData.SIZE_LONG_TRUCK));
        }
    }
    /**
     * add car actor
     * @param layoutX layout position X
     * @param layoutY layout position Y
     * @param speed speed
     */
    public void addCar(int layoutX, int layoutY, double speed){
        PropertiesDao pd = new PropertiesDaoImpl();
        if (speed > 0){
            gamePane.add(new Obstacle(pd.getExternal("image.actor.car.right"), layoutX, layoutY, speed, ConstantData.SIZE_CAR, ConstantData.SIZE_CAR));
        } else {
            gamePane.add(new Obstacle(pd.getExternal("image.actor.car.left"), layoutX, layoutY, speed, ConstantData.SIZE_CAR, ConstantData.SIZE_CAR));
        }
    }

}
