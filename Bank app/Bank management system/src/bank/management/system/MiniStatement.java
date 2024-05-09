package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class MiniStatement extends JFrame implements ActionListener{

	String pinnumber;
	JButton b1;
	
	public MiniStatement(String pinnumber) {
		

		this.pinnumber = pinnumber;

		setTitle("Mini Statement");
		getContentPane().setBackground(Color.WHITE); 
		setSize(400, 600);
		setLocation(20, 20);
		setVisible(true);
		
		
		
		
		JLabel mini = new JLabel();
		mini.setBounds(20, 140, 400, 200);
		add(mini);
		
		JLabel bank = new JLabel("LAXMI CHIT FUND");
		bank.setBounds(130, 20, 200, 20);
		add(bank);

		
		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20, 400, 300, 20);
		add(balance);
		
		
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
			while(rs.next()) {
				card.setText("Card Number : " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		try {
			Conn conn = new Conn();
			int bal = 0;
			ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
			while(rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + (rs.getString("type") 
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>"));
				if(rs.getString("type").equals("Deposit")) {
					bal += Integer.parseInt(rs.getString("amount"));
				} else {
					bal -= Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("Your account balance is Rs. " + bal);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
        setLayout(null);
        b1 = new JButton("Exit");
        b1.addActionListener(this);
        b1.setBounds(20, 500, 100, 25);
        add(b1);


		
		
		

		
	}
	
	
	
	
	
	
	public void actionPerformed(ActionEvent ae) {
		this.setVisible(false);
	}
	
	public static void main(String[] args) {
	
		new MiniStatement("");

	}

}
