package launchers;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import util.Options;

public class StartingMenu extends JFrame implements ActionListener{
	JButton start;
	Options options;
	
	public StartingMenu(){
		setLookAndFeel();
		options = new Options();
	}

	private JPanel getCenterPanel(){
		JPanel center = new JPanel(new GridLayout(5,5,10,10));
		ButtonGroup bg = new ButtonGroup();
		JRadioButton easy = new JRadioButton("Easy");
		JRadioButton normal = new JRadioButton("Normal");
		JRadioButton hard = new JRadioButton("Hard");
		bg.add(easy);
		bg.add(normal);
		bg.add(hard);
		
		easy.setActionCommand("EASY");
		easy.addActionListener(this);
		normal.setActionCommand("NORMAL");
		normal.addActionListener(this);		
		hard.setActionCommand("HARD");
		hard.addActionListener(this);
		
		center.add(easy);
		center.add(normal);
		center.add(hard);
		
		normal.setSelected(true);
		
		return center;
	}
	
	private JPanel getSouthPanel(){
		JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
		
		start = new JButton("Start!");
		start.addActionListener(this);
		start.setActionCommand("START");
		
		south.add(start);
		return south;
	}
	
	private void setLookAndFeel() {
		JPanel main = new JPanel(new BorderLayout());
		JPanel south = getSouthPanel();
		JPanel center = getCenterPanel();
		
		main.add(south,BorderLayout.SOUTH);
		main.add(center,BorderLayout.CENTER);
		
		add(main);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		switch(s){
		case "START":
			System.out.println("starting application");
			break;
		case "EASY":
			options.setDifficulty("EASY");			
			break;
		case "NORMAL":
			options.setDifficulty("NORMAL");
			break;
		case "HARD":
			options.setDifficulty("HARD");
			break;
		}
			
	}
	
}
