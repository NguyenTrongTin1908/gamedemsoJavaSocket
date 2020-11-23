package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JPasswordField;

public class LoginJF extends JFrame {

	private JPanel contentPane;
	private JTextField jTextFieldUsername;
	private JButton btnButtonLogin;
	private JPasswordField passwordField;
	 Image img;	
	

	public LoginJF() {
//		img = Toolkit.getDefaultToolkit().createImage("./image/main.png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("         LOGIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(158, 24, 145, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please enter your username and password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(0, 65, 259, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(0, 106, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(0, 143, 63, 14);
		contentPane.add(lblNewLabel_3);
		
		jTextFieldUsername = new JTextField();
		jTextFieldUsername.setBounds(126, 104, 133, 20);
		contentPane.add(jTextFieldUsername);
		jTextFieldUsername.setColumns(10);
		
		 btnButtonLogin = new JButton("Login");
		 btnButtonLogin.setBounds(170, 214, 89, 23);
		contentPane.add(btnButtonLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 141, 133, 20);
		contentPane.add(passwordField);
		
		 // The Image to store the background image in.
	   
		actionListener();
	}
	
	
	
	  

//	    public void paint(Graphics g)
//	    {
//	        // Draws the img to the BackgroundPanel.
//	        g.drawImage(img, 0, 0, null);
//	    }
//	
	
	
	
	
	
	
	
	
	
	
	
	public void actionListener() {

        ActionListener ButtonLogin = new  ButtonLogin();
        btnButtonLogin.addActionListener( ButtonLogin);
        
        
        

    }
	
	
 class ButtonLogin implements ActionListener {

	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	        	String username = jTextFieldUsername.getText();
	            String password = String.valueOf(passwordField.getPassword());
	            if(username.equals("")||password.equals("")) {
	            	JOptionPane.showConfirmDialog(rootPane, "Some Fields Are is Empty", "Error", 1);
	        }
	            else
	            {
	            	if(Login(username,password)==true) {
	            	dispose(); 
	            		System.out.println("login success");
	            	 new GUI();
	            	
	            	
	            	}
	            	
	            }
	            
	            

	        }
	    }
 
 public Boolean Login(String user, String pass)
 {
	
	 try {
		Cl_Connect cl = new Cl_Connect();
		cl.Create_Socket("localhost", 7);
		if(cl.Login(user,pass)==true)
		{
			
			return true;
		}
		
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	 
 }
	 
	 public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						LoginJF frame = new LoginJF();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}
