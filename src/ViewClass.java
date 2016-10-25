import java.awt.EventQueue;
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


public class ViewClass {

	private JFrame frmMyMusicPlayer;

	private MP3Player mp3Player = new MP3Player();
	private PlayerMethods playerMethods = new PlayerMethods();
	JLabel lblShowMelody = new JLabel("choose file");
	
	/**
	
	btn.actionlister{
		btn.actionperformed(){
			open jfilechooser(){
				build mp3PlayerFromJFileChooser;
				
				
				playermethods.setMp3Player(mp3PlayerFromJFileChooser)
				playermethods.open();
				
				
			}
		
		
		}
		
	}
	
	*/
	
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ViewClass() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frmMyMusicPlayer = new JFrame();
		frmMyMusicPlayer.getContentPane().setEnabled(false);
		frmMyMusicPlayer.setTitle("My Music Player");
		frmMyMusicPlayer.getContentPane().setBackground(Color.YELLOW);
		frmMyMusicPlayer.setBounds(100, 100, 450, 300);
		frmMyMusicPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyMusicPlayer.getContentPane().setLayout(null);
		
		JButton btnPlay = new JButton("");
		btnPlay.setForeground(Color.WHITE);
		btnPlay.setBackground(Color.LIGHT_GRAY);
		btnPlay.setIcon(new ImageIcon("C:\\Users\\pavel\\Downloads\\icons\\playp.jpg"));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				playerMethods.setMp3Player(mp3Player);
				playerMethods.stop();
				playerMethods.play();
				System.out.println("I clicked the play button");				
			}
			
		});
		
		
		btnPlay.setBounds(130, 191, 81, 23);
		frmMyMusicPlayer.getContentPane().add(btnPlay);
		
		JButton btnPause = new JButton("");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				playerMethods.setMp3Player(mp3Player);
				playerMethods.pause();
				System.out.println("I clicked the button pause");

			}
			
		});
		
		btnPause.setIcon(new ImageIcon("C:\\Users\\pavel\\Downloads\\icons\\pausep.jpg"));
		btnPause.setBounds(228, 191, 81, 23);
		frmMyMusicPlayer.getContentPane().add(btnPause);
		
		JButton btnStop = new JButton("");
		
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				playerMethods.setMp3Player(mp3Player);
				playerMethods.stop();
				
				System.out.println("I clicked the button stop");
			//	mp3Player.stop();
			}
			
		});
		
		btnStop.setIcon(new ImageIcon("C:\\Users\\pavel\\Downloads\\icons\\stopp.jpg"));
		btnStop.setBounds(330, 191, 81, 23);
		frmMyMusicPlayer.getContentPane().add(btnStop);
		
		JButton btnOpen = new JButton("");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			System.out.println("I clicked the button open!");

	           JFileChooser fileChooser = new JFileChooser();

				int returnVal = fileChooser.showOpenDialog(btnOpen);

				if (returnVal == JFileChooser.APPROVE_OPTION) {

					File file = fileChooser.getSelectedFile(); 
                    
					mp3Player = new MP3Player(file);
					playerMethods.setMp3Player(mp3Player);
					playerMethods.stop();
					playerMethods.open();
					//mp3Player.play();

					System.out.println(file.getAbsolutePath());

					lblShowMelody.setText(file.getName().toString());		
				
			}
			}
		});
		
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
		
		frmMyMusicPlayer.setVisible(true);
		
		
	}
}
