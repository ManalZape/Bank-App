package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    
    public PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        
        setLayout(null); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);
        
        
        
        JLabel pintext = new JLabel("NEW PIN : ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);
        
        
        
        JLabel repintext = new JLabel(" RE-ENTER NEW PIN : ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(160, 360, 180, 25);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);
        
        
        
        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        
        
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
        if(ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                
                if(!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                    return;
                }
                
                if(npin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "UPDATE bank SET pin = '" + npin + "' WHERE pin = '" + pinnumber + "'";
                String query2 = "UPDATE login SET pin = '" + npin + "' WHERE pin = '" + pinnumber + "'";
                String query3 = "UPDATE signupthree SET pin = '" + npin + "' WHERE pin = '" + pinnumber + "'";
                
                int rowsUpdated1 = conn.s.executeUpdate(query1);
                int rowsUpdated2 = conn.s.executeUpdate(query2);
                int rowsUpdated3 = conn.s.executeUpdate(query3);
                
                if (rowsUpdated1 > 0 || rowsUpdated2 > 0 || rowsUpdated3 > 0) {
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    setVisible(false);
                    new Transactions(rpin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to change PIN");
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

}
