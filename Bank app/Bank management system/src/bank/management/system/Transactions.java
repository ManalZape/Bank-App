package bank.management.system;

import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit, withdrawl, fastcash, ministatment, pinchange, balanceenquery, exit;
	String pinnumber;
	
	public Transactions(String pinnumber) {
		
		this.pinnumber = pinnumber;
		
		setLayout(null); 
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		
		
		JLabel text = new JLabel("Please select your Transaction");
		text.setBounds(220, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		
		withdrawl = new JButton("Cash Withdrawl");
		withdrawl.setBounds(355, 415, 150, 30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		
		ministatment = new JButton("Mini Statment");
		ministatment.setBounds(355, 450, 150, 30);
		ministatment.addActionListener(this);
		image.add(ministatment);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(355, 485, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquery = new JButton("Balance Enquery");
		balanceenquery.setBounds(170, 485, 150, 30);
		balanceenquery.addActionListener(this);
		image.add(balanceenquery);
		
		
		exit = new JButton("EXIT");
		exit.setBounds(355, 520, 150, 30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		setSize(900, 835);
		setLocation(300, 40);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == exit) {
			System.exit(0);
		} else if(ae.getSource() == deposit) {
			new Deposit(pinnumber).setVisible(true);
		} else if(ae.getSource() == withdrawl) {
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		} else if(ae.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		} else if(ae.getSource() == pinchange) {
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		} else if(ae.getSource() == balanceenquery) {
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		} else if(ae.getSource() == ministatment) {
			new MiniStatement(pinnumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		
		new Transactions("");

	}

}
