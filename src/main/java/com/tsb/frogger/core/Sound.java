package com.tsb.frogger.core;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * manage all sound effects and musics
 */
public class Sound {

    /**
     * media player
     */
    private static MediaPlayer mediaPlayer;

    /**
     * play audio clip
     * @param filepath audio file path
     */
    public static void playAudioClip(String filepath){
        AudioClip soundClip = new AudioClip(filepath);
        soundClip.play();
    }

    /**
     * play music
     * @param path audio path
     */
    public static void playMediaPlayer(String path){
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    /**
     * stop all music
     */
    public static void stopMediaPlayer(){
        mediaPlayer.stop();
    }
}
