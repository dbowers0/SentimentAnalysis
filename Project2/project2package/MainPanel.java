//Darius B
package project2package;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

import javax.swing.*;

import sentimentanalysis.Tweet;
import sentimentanalysis.TweetCollection;
	public class MainPanel extends JPanel {
		
		private TweetCollection tc;
		private JTextField textField;
		private JComboBox comboBox;
		private JLabel TweetData;
		private JTextArea textArea_1;
		private JTextField IDNum;
		private JButton btnNewButton_2;
		private JTextPane tweetData;
		private JLabel lblNewLabel_2;
		private JButton btnNewButton_1;
		private JLabel lblNewLabel_3;
		private JLabel lblNewLabel_4;
		private JTextField textField_2;
		private JTextField textField_3;
		private JLabel lblNewLabel_6;
		private JCheckBox chckbxNewCheckBox;
		private JLabel lblNewLabel_7;
		private JLabel lblNewLabel_8;
		private JLabel lblNewLabel_9;
		private JLabel lblNewLabel_10;
		private JTextField textField_1;
		private final ButtonGroup buttonGroup = new ButtonGroup();
		private JLabel lblNewLabel_12;
		private Set<Long> ids;
		private int pol;
		private long i;
		private boolean value;
	
	
	 public MainPanel()
	 {
	 	setBackground(Color.LIGHT_GRAY);
		 tc = new TweetCollection("./project2package/trainingProcessed.txt", 1600000);
		 
		
		 setPreferredSize (new Dimension(800, 800));
		 setLayout(null);
		 
		 //adds ScrollPane
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(8, 226, 233, 313);
		 add(scrollPane);
		 
		 //Adds Data to Text Area
		 JTextArea textArea = new JTextArea();
		 scrollPane.setViewportView(textArea);
		 textArea.setEditable(false);
		 textArea.setText(tc.toString());
		 
		 JLabel lblNewLabel = new JLabel("Tweets:");
		 lblNewLabel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 18));
		 lblNewLabel.setBounds(11, 151, 230, 84);
		 add(lblNewLabel);
		 
		 JLabel lblNewLabel_1 = new JLabel("Enter Username:");
		 lblNewLabel_1.setBounds(297, 92, 114, 14);
		 add(lblNewLabel_1);
		 
		 //Adds TextField
		 textField = new JTextField();
		 textField.setBounds(409, 89, 149, 20);
		 add(textField);
		 textField.setColumns(10);
		 
		 //Gets Ids of Tweet
		 JButton btnGetTweetIds = new JButton("Get Tweet IDS");
		 btnGetTweetIds.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ids = tc.getTweetIdsByUser(textField.getText());
		 		String[] idsStr = new String[ids.size()];
		 		int index = 0;
		 		for(Long long1 : ids)
		 		{
		 			idsStr[index] = long1.toString();
		 			index++;
		 		}
		 		 comboBox.setModel(new DefaultComboBoxModel(idsStr));
		 		if (comboBox.getSelectedIndex() == -1)
		 		{
		 			JOptionPane.showMessageDialog(comboBox, "Username Not Found",
			                "Error!!!", JOptionPane.ERROR_MESSAGE);         
		 		}
		 	}
		 });
		 btnGetTweetIds.setBounds(395, 117, 187, 23);
		 add(btnGetTweetIds);
		 
		 //gets tweets by id and puts it into dropdown box
		 comboBox = new JComboBox();
		 comboBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		String id = (String)comboBox.getSelectedItem();
		 		Tweet t = tc.getTweetById(Long.parseLong(id));
		 		TweetData.setText("Tweet: "+t.toString());
		 	}
		 });
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"item 1", "item 2", "item 3"}));
		 comboBox.setBounds(395, 151, 187, 22);
		 add(comboBox);
		 
		 TweetData = new JLabel("Tweet:");
		 TweetData.setBackground(Color.DARK_GRAY);
		 TweetData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 TweetData.setBounds(217, 176, 606, 34);
		 add(TweetData);
		 
		 tweetData = new JTextPane();
		 tweetData.setBounds(125, 575, 556, 20);
		 add(tweetData);
		 
		 lblNewLabel_2 = new JLabel("Enter tweet to be predicted");
		 lblNewLabel_2.setBounds(125, 550, 174, 14);
		 add(lblNewLabel_2);
		 
		 //Predicts polarity of tweet
		 btnNewButton_1 = new JButton("Do Prediction");
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		String text = tweetData.getText();
		 		Tweet tweet = new Tweet(-1, 12, "notset", text);
		 		tweetData.getText();
		 		int prediction = tc.predict(tweet);
		 		String s = String.valueOf(prediction); 
		 		textArea_1.setText(s);
		 	}
		 });
		 btnNewButton_1.setBounds(125, 606, 114, 23);
		 add(btnNewButton_1);
		 
		 lblNewLabel_3 = new JLabel("Prediction: ");
		 lblNewLabel_3.setBounds(249, 615, 76, 14);
		 add(lblNewLabel_3);
		 
		 textArea_1 = new JTextArea();
		 textArea_1.setEditable(false);
		 textArea_1.setBounds(325, 610, 25, 22);
		 add(textArea_1);
		 
		 IDNum = new JTextField();
		 IDNum.setBounds(509, 330, 96, 20);
		 add(IDNum);
		 IDNum.setColumns(10);
		 
		 lblNewLabel_4 = new JLabel("Enter Tweet ID to Remove");
		 lblNewLabel_4.setBounds(498, 305, 158, 14);
		 add(lblNewLabel_4);
		 
		 //Removes Tweet
		 btnNewButton_2 = new JButton("Remove Tweet");
		 btnNewButton_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if (IDNum.getSelectedText() == null)
		 		{
		 			JOptionPane.showMessageDialog(comboBox, "Username Not Found",
			                "Error!!!", JOptionPane.ERROR_MESSAGE);         
		 		}
		 		String idN = IDNum.getText();
		 		i = Long.parseLong(idN);
		 		tc.removeTweet(i);
		 	}
		 });
		 btnNewButton_2.setBounds(498, 361, 141, 23);
		 add(btnNewButton_2);
		 
		 //Group of 3 Radio buttons
		 JRadioButton rdbtnNewRadioButton = new JRadioButton("0");
		 rdbtnNewRadioButton.setSelected(true);
		 buttonGroup.add(rdbtnNewRadioButton);
		 rdbtnNewRadioButton.setBounds(308, 391, 42, 23);
		 add(rdbtnNewRadioButton);
		 
		 JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2");
		 buttonGroup.add(rdbtnNewRadioButton_1);
		 rdbtnNewRadioButton_1.setBounds(352, 391, 43, 23);
		 add(rdbtnNewRadioButton_1);
		 
		 JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("4");
		 buttonGroup.add(rdbtnNewRadioButton_2);
		 rdbtnNewRadioButton_2.setBounds(397, 391, 37, 23);
		 add(rdbtnNewRadioButton_2);
		 
		 textField_2 = new JTextField();
		 textField_2.setColumns(10);
		 textField_2.setBounds(315, 330, 96, 20);
		 add(textField_2);
		 
		 textField_3 = new JTextField();
		 textField_3.setColumns(10);
		 textField_3.setBounds(315, 362, 96, 20);
		 add(textField_3);
		 
		 JLabel lblNewLabel_5 = new JLabel("New label");
		 lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\bower\\OneDrive\\Documents\\download.jpg"));
		 //lblNewLabel_5.setIcon(new ImageIcon(MainPanel.class.getResource("/project2package/download.jpg")));
		 lblNewLabel_5.setBounds(0, 0, 230, 140);
		 add(lblNewLabel_5);
		 
		 lblNewLabel_6 = new JLabel("Tweet Analysis");
		 lblNewLabel_6.setFont(new Font("Jokerman", Font.PLAIN, 28));
		 lblNewLabel_6.setBounds(359, 11, 206, 40);
		 add(lblNewLabel_6);
		 
		 chckbxNewCheckBox = new JCheckBox("Dark Mode");
		 chckbxNewCheckBox.setBounds(695, 11, 99, 23);
		 add(chckbxNewCheckBox);
		 
		 JButton btnNewButton_3 = new JButton("GO!");
		 btnNewButton_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(chckbxNewCheckBox.isSelected())
		 		{
		 			setBackground(Color.BLACK);
		 		}
		 		if(chckbxNewCheckBox.isSelected()==false)
		 			setBackground(Color.LIGHT_GRAY);
		 	}
		 });
		 btnNewButton_3.setBounds(695, 41, 89, 23);
		 add(btnNewButton_3);
		 
		 lblNewLabel_7 = new JLabel("Add Tweet");
		 lblNewLabel_7.setBounds(309, 271, 76, 14);
		 add(lblNewLabel_7);
		 
		 lblNewLabel_8 = new JLabel("Tweet");
		 lblNewLabel_8.setBounds(251, 365, 49, 14);
		 add(lblNewLabel_8);
		 
		 lblNewLabel_9 = new JLabel("Username");
		 lblNewLabel_9.setBounds(249, 333, 76, 14);
		 add(lblNewLabel_9);
		 
		 lblNewLabel_10 = new JLabel("ID");
		 lblNewLabel_10.setBounds(256, 305, 49, 14);
		 add(lblNewLabel_10);
		 
		 textField_1 = new JTextField();
		 textField_1.setColumns(10);
		 textField_1.setBounds(315, 302, 96, 20);
		 add(textField_1);
		 
		 JLabel lblNewLabel_11 = new JLabel("Polarity");
		 lblNewLabel_11.setBounds(254, 391, 49, 14);
		 add(lblNewLabel_11);
		 
		 JButton btnNewButton = new JButton("AddTweet");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		pol = 0;
		 		if(rdbtnNewRadioButton.isSelected())
		 		{
		 			pol = 0;
		 		}
		 		if(rdbtnNewRadioButton_1.isSelected())
		 		{
		 			pol = 2;
		 		}
		 		if(rdbtnNewRadioButton_2.isSelected())
		 		{
		 			pol = 4;
		 		}
		 		String s = textField_1.getText();
		 		String a = textField_2.getText();
		 		String b = textField_3.getText();
		 		int c = pol;
		 		Long l = Long.valueOf(s).longValue();
		 		Tweet t = new Tweet(pol, l, textField_2.getText(), textField_3.getText());
		 		tc.addTweet(t);
		 		if((a == null) ||  (b ==null) || (c == -1) || (l == -1))
		 		{
			 		JOptionPane.showMessageDialog(comboBox, "Fill out all areas",
		                "Error!!!", JOptionPane.ERROR_MESSAGE);
		 		}
		 			
		 	}
		 });
		 btnNewButton.setBounds(318, 429, 116, 23);
		 add(btnNewButton);
		// image = new ImageIcon (this.getClass().getResource("/sun.gif"));
	 }		
	 public void doWrite()
	 {
		 tc.rewriteFile();
	 }
}
	