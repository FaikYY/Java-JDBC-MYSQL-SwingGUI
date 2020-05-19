package LoginSQL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PasswordPage extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField newPasswordText;

	// we change the main method with newWindow to able to create the Frame in different classes
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

	
	
	// name to get the username from the beginning
	public PasswordPage(String name) {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setBounds(100, 100, 561, 339);
		// close just this window not whole program.
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Enter your new password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(38, 120, 176, 14);
		frame.getContentPane().add(lblNewLabel);
		
		newPasswordText = new JTextField();
		newPasswordText.setBounds(224, 118, 186, 20);
		frame.getContentPane().add(newPasswordText);
		newPasswordText.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// JOURNEY STARTS HERE LET'S GOOO!!
				
				String newpasswd = newPasswordText.getText();
				
				try {
					// connect to the database
					String sqlUser = "root";
		            String sqlPassword = "root";
		            String url = "jdbc:mysql://localhost:3306/students?autoReconnect=true&useSSL=false";
					
		            
		            Connection con= DriverManager.getConnection(url, sqlUser, sqlPassword);
		            
		            // create the sql query 
		            PreparedStatement st = (PreparedStatement) con.prepareStatement("Update students.info set password=? where username=?");
					// enter values into sql query 
		            st.setString(1, newpasswd);
                    st.setString(2, name);
                    st.executeUpdate();
                    
                    
                    JOptionPane.showMessageDialog(btnNewButton, "Password has been successfully changed");
                    
                    // close the frame
                    frame.dispose();

				}
				catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
				
				
				
			}
		
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(164, 188, 168, 41);
		frame.getContentPane().add(btnNewButton);
	}
}
	