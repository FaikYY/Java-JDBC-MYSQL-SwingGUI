package LoginSQL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame{

	private JFrame welcomeFrame;

	
	
	// we change main class to newWindow class to be able to run it in different classes
	public static void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage(String username) {
		welcomeFrame = new JFrame();
		welcomeFrame.setVisible(true);
		welcomeFrame.setTitle("Welcome");
		welcomeFrame.setResizable(false);
		welcomeFrame.setBounds(100, 100, 855, 459);
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeFrame.getContentPane().setLayout(null);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// CODING STARTS HERE FOR "LOGOUT BUTTON" LET'S GOO!!
				
				// create a JOptionPane message to exit
				 int a = JOptionPane.showConfirmDialog(logoutButton, "Are you sure?");
				 
				 // if yes button clicked then close the page
				 if (a == JOptionPane.YES_OPTION) {
	                    welcomeFrame.dispose();
                }
				 }
                
			
		});
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		logoutButton.setBounds(270, 87, 312, 85);
		welcomeFrame.getContentPane().add(logoutButton);
		
		JButton changepasswordButton = new JButton("Change-password");
		changepasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//    CODING JOURNEY STARTS HERE FOR "CHANGE PASSWORD" LET'S GOOO!!
				
				// open passwordPage
				new PasswordPage(username);
				
				
			}
		});
		changepasswordButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		changepasswordButton.setBounds(270, 232, 312, 85);
		welcomeFrame.getContentPane().add(changepasswordButton);
	}
}


	
