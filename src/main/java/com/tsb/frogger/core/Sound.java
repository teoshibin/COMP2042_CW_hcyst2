package com.tsb.frogger.core;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * manage all sound effects and musics
 */
public class Sound {

    private static final String btnSoundSource = "file:src/main/resources/com/tsb/frogger/sounds/menu/btn-pop.mp3";
    private static final String musicSource = "src/main/resources/com/tsb/frogger/sounds/MainBGM.mp3";

    private static MediaPlayer mediaPlayer;

    /**
     * play mouse on enter button sound
     */
    public static void playBtnSound(){
        AudioClip btnSoundClip = new AudioClip(btnSoundSource);
        btnSoundClip.play();
    }

    /**
     * play background music
     */
    public static void playMusic() {
        Media media = new Media(new File(musicSource).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    /**
     * stop background music
     */
    public static void stopMusic() {
        mediaPlayer.stop();
    }
}
