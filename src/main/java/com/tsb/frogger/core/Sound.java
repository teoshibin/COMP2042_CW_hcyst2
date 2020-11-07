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
    private static final String ErrorSoundSource = "file:src/main/resources/com/tsb/frogger/sounds/menu/error.mp3";
    private static final String SuccessSoundSource = "file:src/main/resources/com/tsb/frogger/sounds/menu/success.mp3";
    private static final String PageFlipSoundSource = "file:src/main/resources/com/tsb/frogger/sounds/menu/page-flip.mp3";
    private static final String MenuMusicSource = "src/main/resources/com/tsb/frogger/sounds/MenuBGM.mp3";


    private static MediaPlayer mediaPlayer;
    private static AudioClip soundClip;

    /**
     * play mouse on enter button sound
     */
    public static void playBtnSound(){
        soundClip = new AudioClip(btnSoundSource);
        soundClip.play();
    }

    /**
     * play error sound
     */
    public static void playErrorSound(){
        soundClip = new AudioClip(ErrorSoundSource);
        soundClip.play();
    }

    /**
     * play success sound
     */
    public static void playSuccessSound(){
        soundClip = new AudioClip(SuccessSoundSource);
        soundClip.play();
    }

    /**
     * play page flip
     */
    public static void playPageFlipSound(){
        soundClip = new AudioClip(PageFlipSoundSource);
        soundClip.play();
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

    /**
     * play menu background music
     */
    public static void playMenuMusic() {
        Media media = new Media(new File(MenuMusicSource).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    /**
     * stop menu background music
     */
    public static void stopMenuMusic() {
        mediaPlayer.stop();
    }

}
