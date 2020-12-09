package com.tsb.frogger.utils.data.datastructure;

import java.io.Serializable;

class Settings implements Serializable {
    private double masterVolume;
    private double controlVolume;
    private double musicVolume;

    Settings() {
        masterVolume = 0.7;
        controlVolume = 0.5;
        musicVolume = 0.5;
    }

    public double getMasterVolume() {
        return masterVolume;
    }

    public void setMasterVolume(double masterVolume) {
        this.masterVolume = masterVolume;
    }

    public double getControlVolume() {
        return controlVolume;
    }

    public void setControlVolume(double controlVolume) {
        this.controlVolume = controlVolume;
    }

    public double getMusicVolume() {
        return musicVolume;
    }

    public void setMusicVolume(double musicVolume) {
        this.musicVolume = musicVolume;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "masterVolume=" + masterVolume +
                ", controlVolume=" + controlVolume +
                ", musicVolume=" + musicVolume +
                '}';
    }
}
