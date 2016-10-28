package com.assignment.otherclasses;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import jaco.mp3.player.MP3Player;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * 
 * @author Pavel
 * @version 1.0
 */
public class ViewClass implements ActionListener{

	private JFrame frmMyMusicPlayer;

	JButton btnOpen = new JButton("");
	JButton btnPlay = new JButton("");
	JButton btnPause = new JButton("");
	JButton btnStop = new JButton("");

	private MP3Player mp3Player = new MP3Player();
	private PlayerMethods playerMethods = new PlayerMethods();
	JLabel lblShowMelody = new JLabel("choose file");
	
	/**
	 * Create the application.
	 */
	public ViewClass() {
		initialize();
		addActionListener();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param none
	 * @return none
	 * 
	 */
	private void initialize() {
		frmMyMusicPlayer = new JFrame();
		frmMyMusicPlayer.getContentPane().setEnabled(false);
		frmMyMusicPlayer.setTitle("My Music Player");
		frmMyMusicPlayer.getContentPane().setBackground(Color.YELLOW);
		frmMyMusicPlayer.setBounds(100, 100, 450, 300);
		frmMyMusicPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyMusicPlayer.getContentPane().setLayout(null);
		
		/**
		 * Create the PLAY button and call for open()
		 */		
//		JButton btnPlay = new JButton("");
		btnPlay.setForeground(Color.WHITE);
		btnPlay.setBackground(Color.LIGHT_GRAY);
		btnPlay.setIcon(new ImageIcon("C:\\Users\\pavel\\Downloads\\icons\\playp.jpg"));
		
		/**
		 * Create the PAUSE button and call for pause
		 */
		btnPlay.setBounds(130, 191, 81, 23);
		frmMyMusicPlayer.getContentPane().add(btnPlay);
		
		/**
		 * Create the STOP button and call for open()
		 */
		btnPause.setIcon(new ImageIcon("C:\\Users\\pavel\\Downloads\\icons\\pausep.jpg"));
		btnPause.setBounds(228, 191, 81, 23);
		frmMyMusicPlayer.getContentPane().add(btnPause);
		
		btnStop.setIcon(new ImageIcon("C:\\Users\\pavel\\Downloads\\icons\\stopp.jpg"));
		btnStop.setBounds(330, 191, 81, 23);
		frmMyMusicPlayer.getContentPane().add(btnStop);
		
		/**
		 * Create the OPEN button and call for open
		 */
	
		btnOpen.setBackground(Color.LIGHT_GRAY);
		btnOpen.setIcon(new ImageIcon("C:\\Users\\pavel\\Downloads\\icons\\openp.jpg"));
		btnOpen.setBounds(29, 191, 81, 23);
		frmMyMusicPlayer.getContentPane().add(btnOpen);
		
		lblShowMelody.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowMelody.setForeground(new Color(255, 0, 0));
		lblShowMelody.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblShowMelody.setBackground(Color.LIGHT_GRAY);
		lblShowMelody.setBounds(29, 31, 382, 28);
		frmMyMusicPlayer.getContentPane().add(lblShowMelody);
		
		frmMyMusicPlayer.setVisible(true);	// Makes frame visible
	}
	public void addActionListener(){
		btnOpen.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		btnStop.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOpen) {
			System.out.println("I clicked the button open!");
			playerMethods.stop();
			
	           JFileChooser fileChooser = new JFileChooser();
				int returnVal = fileChooser.showOpenDialog(btnOpen); //Opens files dialog
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					File file = fileChooser.getSelectedFile(); 
					mp3Player = new MP3Player(file);
					playerMethods.setMp3Player(mp3Player);
					playerMethods.open();
					System.out.println(file.getAbsolutePath());
					lblShowMelody.setText(file.getName().toString());		//Shows name of the playing song in a textfield.
			    }
			}
			if (e.getSource() == btnStop) {
				playerMethods.setMp3Player(mp3Player);
				playerMethods.stop();
				System.out.println("I clicked the button stop");
			}
			
			if(e.getSource()==btnPause){
				playerMethods.setMp3Player(mp3Player);
				System.out.println("I clicked the button pause");
				playerMethods.pause();
			}
			
			if (e.getSource()==btnPlay){
				playerMethods.setMp3Player(mp3Player);
				playerMethods.play();
				System.out.println("I clicked the play button");
				
			}
		
		}
}

