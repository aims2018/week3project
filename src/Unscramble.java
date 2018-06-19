import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Unscramble extends JFrame implements ActionListener {
	private String word;
	private JButton[] buttons;

	private char[] scramble(char[] input) {
		for (int counter = 0; counter < 100; counter++) {
			int position1 = (int) (input.length * Math.random());

			int position2 = position1;

			while (position2 == position1)
				position2 = (int) (input.length * Math.random());

			char temp = input[position1];
			input[position1] = input[position2];
			input[position2] = temp;
		}

		return (input);
	}

	public Unscramble(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		word = Words.getWord();
		
		char[] c = word.toCharArray();
		
		c = scramble(c);
		
		buttons = new JButton[c.length];
		
		for (int counter=0;counter<buttons.length;counter++) {
			buttons[counter] = new JButton("" + c[counter]);
			buttons[counter].addActionListener(this);
			add(buttons[counter]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Unscramble unscramble = new Unscramble("Unscramble");

		unscramble.setSize(500, 500);
		unscramble.setLocationRelativeTo(null);
		unscramble.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		unscramble.setVisible(true);
	}

}
