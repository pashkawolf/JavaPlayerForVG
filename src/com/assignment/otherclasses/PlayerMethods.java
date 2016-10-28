package com.assignment.otherclasses;
import com.assignment05.interfaces.PlayerInterface;

import jaco.mp3.player.MP3Player;

/**
 * Implementing of PlayerInterface class
 * 
 */
public class PlayerMethods implements PlayerInterface {
	private MP3Player mp3Player = new MP3Player();
	
	/**
	 * Defining getters and setters for mp3Player
	 * @return mp3Player
	 */
	public MP3Player getMp3Player() {
		return mp3Player;
	}

	public void setMp3Player(MP3Player mp3Player) {
		this.mp3Player = mp3Player;
	}
	
	/**
	 * Defining methods for player.
	 * 
	 */
	@Override
	public void open() {
		/**
		 * Starts playing music directly after opening the file chooser and finding new music file.
		 * 
		 */
		mp3Player.stop();
	    mp3Player.play();   
	}

	@Override
	public void play() {
		/**
		 * Starts playing music.
		 * 
		 */
		mp3Player.play();	
	}

	@Override
	public void pause() {
		/**
		 * Pauses playing music.
		 * 
		 */
		mp3Player.pause();	
	}

	@Override
	public void stop() {
		/**
		 * Stops playing music.
		 * 
		 */
		mp3Player.stop();	
	}
}
