package com.game.main;

import java.io.File;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;

import javax.sound.sampled.AudioSystem;

import javax.sound.sampled.Clip;

import javax.sound.sampled.FloatControl;

import javax.sound.sampled.LineUnavailableException;

import javax.sound.sampled.UnsupportedAudioFileException;



public class AudioPlayer2 {



 private static Clip play;

 

 public static void playMenuSound()

 {

  try {

   AudioInputStream menuSound = AudioSystem.getAudioInputStream(new File("res1/click_music.wav"));

   play = AudioSystem.getClip();

   play.open(menuSound);

   FloatControl volume = (FloatControl) play.getControl(FloatControl.Type.MASTER_GAIN);

   volume.setValue(-15f);

   play.loop(Clip.LOOP_CONTINUOUSLY);

  }catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){

   e.printStackTrace();

  }

 }

 

 public static void playGameSound()

 {

  try {

   AudioInputStream gameSound = AudioSystem.getAudioInputStream(new File("res1/background_music.wav"));

   play = AudioSystem.getClip();

   play.open(gameSound);

   FloatControl volume = (FloatControl) play.getControl(FloatControl.Type.MASTER_GAIN);

   volume.setValue(0.01f);

   play.loop(Clip.LOOP_CONTINUOUSLY);

  }catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){

   e.printStackTrace();

  }

 }

 

 public static void stopMusic()

 {

  play.close();

 }

}