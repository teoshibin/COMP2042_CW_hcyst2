package com.tsb.frogger.utils.data.datastructure;

import java.io.Serializable;

/**
 * data structure
 */
class Settings implements Serializable {
    /**
     * volume
     */
    private double masterVolume;
    /**
     * volume
     */
    private double controlVolume;
    /**
     * volume
     */
    private double musicVolume;

    /**
     * default constructor
     */
    Settings() {
        masterVolume = 0.7;
        controlVolume = 0.5;
        musicVolume = 0.5;
    }

    /**
     * getter
     *
     * @return volume
     */
    public double getMasterVolume() {
        return masterVolume;
    }

    /**
     * setter
     *
     * @param masterVolume volume
     */
    public void setMasterVolume(double masterVolume) {
        this.masterVolume = masterVolume;
    }

    /**
     * getter
     *
     * @return volume
     */
    public double getControlVolume() {
        return controlVolume;
    }

    /**
     * setter
     *
     * @param controlVolume volume
     */
    public void setControlVolume(double controlVolume) {
        this.controlVolume = controlVolume;
    }

    /**
     * getter
     *
     * @return volume
     */
    public double getMusicVolume() {
        return musicVolume;
    }

    /**
     * setter
     *
     * @param musicVolume volume
     */
    public void setMusicVolume(double musicVolume) {
        this.musicVolume = musicVolume;
    }

    /**
     * visualize data
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Settings{" +
                "masterVolume=" + masterVolume +
                ", controlVolume=" + controlVolume +
                ", musicVolume=" + musicVolume +
                '}';
    }
}
