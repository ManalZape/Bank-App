package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class SignupTwo extends JFrame implements ActionListener{

	JTextField panTextField, aadharTextField;
	JButton next;
	JRadioButton seniorRadioY, seniorRadioN, existingRadioY, existingRadioN;
	JComboBox religionn, categoryn, Incomen, educationn, occupationn;
	String formno;
	
	SignupTwo(String formno){
		this.formno = formno;
		setLayout(null);
		
		setTitle("New Account Application Form - Page 2");
		
		
		
		//adding Page 2 jlabel
		JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);
		
		
		//adding religion
		JLabel religion = new JLabel("Religion :");
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);
		
		String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
		religionn = new JComboBox(valReligion);
		religionn.setBounds(300, 140, 400, 30);
		religionn.setBackground(Color.WHITE);
		add(religionn);
		
		
		
		//adding Category
		JLabel category = new JLabel("Category :");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100, 190, 100, 30);
		add(category);
		
		String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
		categoryn = new JComboBox(valCategory);
		categoryn.setBounds(300, 190, 400, 30);
		categoryn.setBackground(Color.WHITE);
		add(categoryn);
		
		
		
		
		//adding Income
		JLabel income = new JLabel("Income :");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100, 240, 100, 30);
		add(income);
		
		String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
		Incomen = new JComboBox(valIncome);
		Incomen.setBounds(300, 240, 400, 30);
		Incomen.setBackground(Color.WHITE);
		add(Incomen);
		
		
		
		
		//adding educational
		JLabel education = new JLabel("Education :");
		education.setFont(new Font("Raleway", Font.BOLD, 20));
		education.setBounds(100, 290, 315, 30);
		add(education);
		
		String valEducation[] = {"10th Pass", "12th Pass", "Graduation", "Post-Graduation", "Doctrate", "Others"};
		educationn = new JComboBox(valEducation);
		educationn.setBounds(300, 290, 400, 30);
		educationn.setBackground(Color.WHITE);
		add(educationn);
		
		
		
		
		//adding occupation
		JLabel occupation = new JLabel("Occupation :");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(100, 340, 150, 30);
		add(occupation);
		
		String valOccupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
		occupationn = new JComboBox(valOccupation);
		occupationn.setBounds(300, 340, 400, 30);
		occupationn.setBackground(Color.WHITE);
		add(occupationn);
		
		
		
		//adding pan
		JLabel pan = new JLabel("Pan Number :");
		pan.setFont(new Font("Raleway", Font.BOLD, 20));
		pan.setBounds(100, 390, 150, 30);
		add(pan);
		
		panTextField = new JTextField();
		panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		panTextField.setBounds(300, 390, 400, 30);
		add(panTextField);
		
		
		
		
		
		//adding aadhar
		JLabel aadhar = new JLabel("Aadhar Number :");
		aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
		aadhar.setBounds(100, 440, 200, 30);
		add(aadhar);
		
		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		aadharTextField.setBounds(300, 440, 400, 30);
		add(aadharTextField);
		
		
		
		
		//adding senior citizen
		JLabel seniorCitizen = new JLabel("Senior Citizen :");
		seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
		seniorCitizen.setBounds(100, 490, 200, 30);
		add(seniorCitizen);
		
		seniorRadioY = new JRadioButton("Yes");
		seniorRadioY.setFont(new Font("Raleway", Font.BOLD, 14));
		seniorRadioY.setBounds(300, 490, 100, 30);
		add(seniorRadioY);
		
		seniorRadioN = new JRadioButton("No");
		seniorRadioN.setFont(new Font("Raleway", Font.BOLD, 14));
		seniorRadioN.setBounds(450, 490, 100, 30);
		add(seniorRadioN);
		
		
		
		
		
		//adding existingAcc
		JLabel existingAcc = new JLabel("Existing Account :");
		existingAcc.setFont(new Font("Raleway", Font.BOLD, 20));
		existingAcc.setBounds(100, 540, 200, 30);
		add(existingAcc);
		
		existingRadioY = new JRadioButton("Yes");
		existingRadioY.setFont(new Font("Raleway", Font.BOLD, 14));
		existingRadioY.setBounds(300, 540, 100, 30);
		add(existingRadioY);
		
		existingRadioN = new JRadioButton("No");
		existingRadioN.setFont(new Font("Raleway", Font.BOLD, 14));
		existingRadioN.setBounds(450, 540, 100, 30);
		add(existingRadioN);
		
		
		
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);
		
		
		
		
		//setting the layout
		getContentPane().setBackground(Color.WHITE);
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		 
		String sreligion = (String)religionn.getSelectedItem();       //fetching value from JComboBox
		String scategory = (String)categoryn.getSelectedItem();
		String sincome = (String)Incomen.getSelectedItem();
		String seducation = (String)educationn.getSelectedItem();
		String soocupation = (String)occupationn.getSelectedItem();
		
		String seniorCitizenString = null;
		if(seniorRadioY.isSelected()) {
			seniorCitizenString = "Yes";
		} else if(seniorRadioN.isSelected()) {
			seniorCitizenString = "No";
		}
		
		String existingAccString = null;
		if(existingRadioY.isSelected()) {
			existingAccString = "Yes";
		} else if(existingRadioN.isSelected()) {
			existingAccString = "No";
		}
		
		String span = panTextField.getText();
		String saadhar = aadharTextField.getText();
		
		
		try {
				Conn c = new Conn();
				String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" 
                        + seducation + "','" + soocupation + "','" + seniorCitizenString + "','" 
                        + existingAccString + "','" + span + "','" + saadhar + "')"; 

				
				
				c.s.executeUpdate(query); 
				
				setVisible(false);
				new SignupThree(formno).setVisible(true);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		new SignupTwo("");
	}

}
