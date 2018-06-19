import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener,ItemListener,Runnable {
	private JButton button;
	private JComboBox fonts;
	private String message;
	private MessagePanel messagePanel;
	private JComboBox size;
	
	public GUI(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		add(button = new JButton("Click"));
		
		button.addActionListener(this);
		
		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
        add(fonts = new JComboBox(fontNames));
        
        fonts.addItemListener(this);
        
        Integer[] choices = new Integer[73];
        
        for (int counter=1;counter<choices.length;counter++)
        	choices[counter] = counter;
        
        add(new JLabel("Size"));
        
        add(size = new JComboBox(choices));
        
        size.addItemListener(this);
        
        message = "Hello";	
        
        add(messagePanel = new MessagePanel());
	}
	
	public class MessagePanel extends JPanel {
		
		public MessagePanel() {
			setPreferredSize(new Dimension(480,200));
			
			setBackground(Color.black);
		}
	
 	   public void paintComponent(Graphics g) {
		   super.paintComponent(g);
		
	   	   String name = fonts.getSelectedItem().toString();
	   	   
	   	   int size = 20;
	   	   
	   	   try {
	   	      size = Integer.parseInt(GUI.this.size.getSelectedItem().toString());
	   	   } catch (Exception e) {
	   		   
	   	   }
	   	   
		   Font font = new Font(name,Font.BOLD,size);
		
		   g.setFont(font);
		   
		   g.setColor(Color.white);
		
		   g.drawString(message, 20, 100);
	   }
 	   
	}
	
	private void pause(double seconds) {
		try {
			Thread.sleep((int)(seconds*1000));
		} catch (InterruptedException ie) {
			
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
		messagePanel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUI gui = new GUI("GUI");
		
		gui.setSize(500,500);
		gui.setLocationRelativeTo(null);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}

}
