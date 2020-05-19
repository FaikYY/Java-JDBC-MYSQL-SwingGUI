package LoginSQL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

// I putted an ''extends JFrame'' to be able to see class features when its called in a another class 
public class LoginGUI extends JFrame{

	private JFrame loginFrame;
	private JTextField usernameBox;
	private JPasswordField passwordBox;
	private JLabel lblNewLabel;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginFrame = new JFrame();
		loginFrame.setResizable(false);
		loginFrame.setBounds(100, 100, 450, 300);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		
		JLabel usernameText = new JLabel("        Username");
		usernameText.setBounds(64, 62, 88, 14);
		loginFrame.getContentPane().add(usernameText);
		
		JLabel passwordText = new JLabel("        Password");
		passwordText.setBounds(64, 128, 88, 14);
		loginFrame.getContentPane().add(passwordText);
		
		usernameBox = new JTextField();
		usernameBox.setBounds(175, 59, 148, 20);
		loginFrame.getContentPane().add(usernameBox);
		usernameBox.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//            JOURNEY STARTS HERE LET'S GOOO!!!
				// when button clicked do the following (since we are in the actionPerformed class)
				
				// take the values in the box and assign them to string username and password
				 String userName = usernameBox.getText();
	             @SuppressWarnings("deprecation")
				 String password = passwordBox.getText();
	            
	            // initialize the Mysql values
	             String sqlUser = "root";
	             String sqlPassword = "root";
	             String url = "jdbc:mysql://localhost:3306/students?autoReconnect=true&useSSL=false";
	             
	            // connect to the database (define try catch exception )
	             try {
					
	            	Connection con= DriverManager.getConnection(url, sqlUser, sqlPassword);
					
	            	// Prepare the sql query(code) to execute
	            	PreparedStatement st = (PreparedStatement) con.prepareStatement("Select username, "
	            						+ "password from students.info where username=? and password=?");
	            	
	            	// set values from the text boxes and execute the sql query 
	                st.setString(1, userName);
	                st.setString(2, password);
	                ResultSet rs = st.executeQuery();
	                
	                // if exists in the database
	                if (rs.next()) {
                        
	                    // Show pop message to the user 
	                	System.out.println("Info matched...");
                        JOptionPane.showMessageDialog(null, "You have successfully logged in");
                        
                     // to close login screen we need this
	                	loginFrame.dispose();
	                	
	                // open the welcome page, and enter userName into the class
                        new HomePage(userName);
                        
                        
                        
                        
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Username & Password");
                    }
	                
	                
					
				} 
	             catch (SQLException e1) 
	             {
					e1.printStackTrace();
				}  
	             
	            //  
			
			}
		});
		loginButton.setBounds(151, 182, 89, 23);
		loginFrame.getContentPane().add(loginButton);
		
		passwordBox = new JPasswordField();
		passwordBox.setBounds(175, 125, 148, 20);
		loginFrame.getContentPane().add(passwordBox);
		
		lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(175, 11, 109, 14);
		loginFrame.getContentPane().add(lblNewLabel);
	}
}
