//Darius Bowers
//CSCI 3381
package project2package;
import java.awt.BorderLayout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Tweet Analysis");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		MainPanel panel = new MainPanel();
		
		frame.add(panel, BorderLayout.CENTER);

        frame.setSize(800, 800);
        
        frame.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent w)
        	{
        		panel.doWrite();
        	}
        	
        });
        
       
    
        frame.setVisible(true);		
    
		
}
}

