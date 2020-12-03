package com.tsb.frogger.utils.sound;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * manage all sound effects and musics
 */
public class Sound {
    /**
     * music volume
     */
    private static double musicVolume = 0.7;
    /**
     * control volume
     */
    private static double controlVolume = 0.7;
    /**
     * master volume
     */
    private static double masterVolume = 1;

    /**
     * media player
     */
    private static MediaPlayer mediaPlayer;

    /**
     * play audio clip
     *
     * @param filepath audio file path
     */
    public static void playAudioClip(String filepath) {
        AudioClip soundClip = new AudioClip(filepath);
        soundClip.setVolume(controlVolume * masterVolume);
        soundClip.play();
    }

    /**
     * play music
     *
     * @param path audio path
     */
    public static void playMediaPlayer(String path) {
            System.out.println("Here1");
        if(mediaPlayer == null || (!mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING))){
            System.out.println("Here2");
            Media media = new Media(new File(path).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setVolume(masterVolume * musicVolume);
            mediaPlayer.play();
        }
    }

    /**
     * stop all music
     */
    public static void stopMediaPlayer() {
        mediaPlayer.stop();
        mediaPlayer.dispose();
    }

    /**
     * set music volume
     *
     * @param volume volume
     */
    public static void setMusicVolume(double volume) {
        mediaPlayer.setVolume(volume * masterVolume);
        musicVolume = volume;
    }

    /**
     * set control volume
     *
     * @param volume volume
     */
    public static void setControlVolume(double volume) {
        controlVolume = volume;
    }

    /**
     * set master volume
     *
     * @param volume volume
     */
    public static void setMasterVolume(double volume) {
        mediaPlayer.setVolume(volume * musicVolume);
        masterVolume = volume;
    }

    /**
     * get music volume
     *
     * @return music volume
     */
    public static double getMusicVolume() {
        return musicVolume;
    }

    /**
     * get control volume
     *
     * @return control volume
     */
    public static double getControlVolume() {
        return controlVolume;
    }

    /**
     * get master volume
     *
     * @return master volume
     */
    public static double getMasterVolume() {
        return masterVolume;
    }

}
