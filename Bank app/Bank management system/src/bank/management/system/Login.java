package bank.management.system;

import javax.swing.*;

//import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	
	// declaring the JButton and JTextField in public global class instead of inside constructor to get the access
	JButton login, signup, clear;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	Login(){
		
		setTitle("ATM");
		
		setLayout(null);
		//adding the logo
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/icons/logo.jpg"));     //loading the image
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);              //setting the size of image
		ImageIcon i3 = new ImageIcon(i2);                                                 //loading the image
		JLabel label = new JLabel(i3);                                              // converting to jlabel
		label.setBounds(70, 10, 100, 100);                                       //setting the placement of image on the layout of app
		add(label);                                                 //adding the label so we can actually see it... without this we cannot see the logo
		
		//adding the title
		JLabel text = new JLabel("Welcome to ATM");                   //Creating object of Jlabel for the text
		text.setFont(new Font("Osward", Font.BOLD, 38));              //setting text format
		text.setBounds(300, 40, 400, 40);                             // placing the text in the layout
		add(text);													// adding the text
		
		//adding the card no text
		JLabel cardno = new JLabel("Card No : ");                   
		cardno.setFont(new Font("Raleway", Font.BOLD, 38));            
		cardno.setBounds(120, 150, 250, 40);                            
		add(cardno);
		
		//adding the text field infront of card no text
		cardTextField = new JTextField();             //creating Jtextfield object which is basically a box
		cardTextField.setBounds(320, 155, 250, 30);				//setting format
		cardTextField.setFont(new Font("Arial", Font.BOLD, 15));
		add(cardTextField);											
		
		//adding the pin text
		JLabel pin = new JLabel("PIN : ");                   
		pin.setFont(new Font("Raleway", Font.BOLD, 38));              
		pin.setBounds(120, 220, 400, 40);                             
		add(pin);
		
		//adding the text field infront of pin text
		pinTextField = new JPasswordField();
		pinTextField.setBounds(320, 225, 250, 30);
		pinTextField.setFont(new Font("Arial", Font.BOLD, 15));
		add(pinTextField);
		
		//adding the signin button
		login = new JButton("SIGN IN");
		login.setBounds(330, 300, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		//adding the clear button
		clear = new JButton("CLEAR");
		clear.setBounds(450, 300, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		//adding the signup button
		signup = new JButton("SIGN UP");
		signup.setBounds(330, 350, 220, 30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.WHITE);                //setting the layout as white color
		
		setSize(800, 480);											// layout size 
		setVisible(true);											// to make it visible
		setLocation(400, 200);										//placement of app on the screen
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		} else if(ae.getSource() == login) {
			Conn conn = new Conn();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query = "select * from login where cardNumber = '" + cardnumber + "' and pin = '" + pinnumber + "'";
			try {
				ResultSet rs = conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions("").setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Card number or PIN!!");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} else if(ae.getSource() == signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	}




	
	

	public static void main(String[] args) {
	
		new Login();
		
	}

}
