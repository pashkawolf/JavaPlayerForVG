import jaco.mp3.player.MP3Player;

/**
 * Implementing of PlayerInterface class
 * 
 */
public class PlayerMethods implements PlayerInterface {
	private MP3Player mp3Player = new MP3Player();
	
	/**
	 * Defining getters and setters for mp3Player
	 * 
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
		mp3Player.stop();
	    mp3Player.play();   
	}

	@Override
	public void play() {
		mp3Player.play();	
	}

	@Override
	public void pause() {
		mp3Player.pause();	
	}

	@Override
	public void stop() {
		mp3Player.stop();	
	}
}
