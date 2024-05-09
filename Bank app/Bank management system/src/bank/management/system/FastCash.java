package bank.management.system;

import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
	
	JButton hundred, fhundred, thousand, tthousand, fthousand, tenthousand, back;
	String pinnumber;
	
	public FastCash(String pinnumber) {
		
		this.pinnumber = pinnumber;
		
		setLayout(null); 
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		
		
		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(220, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		
		hundred = new JButton("Rs. 100");
		hundred.setBounds(170, 415, 150, 30);
		hundred.addActionListener(this);
		image.add(hundred);
		
		
		fhundred = new JButton("Rs .500");
		fhundred.setBounds(355, 415, 150, 30);
		fhundred.addActionListener(this);
		image.add(fhundred);
		
		
		thousand = new JButton("Rs. 1000");
		thousand.setBounds(170, 450, 150, 30);
		thousand.addActionListener(this);
		image.add(thousand);
		
		
		tthousand = new JButton("Rs. 2000");
		tthousand.setBounds(355, 450, 150, 30);
		tthousand.addActionListener(this);
		image.add(tthousand);
		
		fthousand = new JButton("Rs. 5000");
		fthousand.setBounds(355, 485, 150, 30);
		fthousand.addActionListener(this);
		image.add(fthousand);
		
		tenthousand = new JButton("Rs. 10000");
		tenthousand.setBounds(170, 485, 150, 30);
		tenthousand.addActionListener(this);
		image.add(tenthousand);
		
		
		back = new JButton("BACK");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900, 835);
		setLocation(300, 40);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		} else {
			String amount = ((JButton)ae.getSource()).getText().substring(4);
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					} else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				
				if(ae.getSource() != back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				Date date = new Date();
				String query = "insert into bank values('" + pinnumber + "', '" + date + "', ' Withdrawl', '" + amount  + "')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully!");
				
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) {
		
		new FastCash("");

	}

}
