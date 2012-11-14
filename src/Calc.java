/**
 *  This code is written by Umar Qasim Qureshi 
 *  $$$$$$$$$$$$$$ All Rights Reserved $$$$$$$$$$$$
 *  Email: engr.umar.qureshi@gmail.com 
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
class Calc extends JFrame implements ActionListener
{
	
	
	private static final int WIDTH = 300;
	private static final int HEIGHT = 210;
	
	private JLabel topLabel;
	private JButton digit0, digit1, digit2, digit3, digit4, digit5, digit6, digit7, digit8, digit9, operationPlus, operationMultiply, operationMinus, operationDivide, operationEqual, operationClear;
	
	boolean clearfiled=true;
	Calculations helper;
	
	
	public Calc()
	{
		
		helper = new Calculations();
		
		topLabel = new JLabel("Enter Input Here", SwingConstants.LEFT);
		topLabel.setForeground(Color.blue);
		topLabel.setBackground(Color.white);
		topLabel.setOpaque(true);
		topLabel.setBorder(BorderFactory.createLineBorder(Color.blue,2));

		
		digit0 = new JButton("0");
		digit1 = new JButton("1");
		digit2 = new JButton("2");
		digit3 = new JButton("3");
		digit4 = new JButton("4");
		digit5 = new JButton("5");
		digit6 = new JButton("6");
		digit7 = new JButton("7");
		digit8 = new JButton("8");
		digit9 = new JButton("9");
		operationPlus = new JButton("+");
		operationMinus = new JButton("-");
		operationMultiply = new JButton("x");
		operationDivide = new JButton("/");
		operationEqual = new JButton("=");
		operationClear = new JButton("C");
		
		applyClickListeners();
		
	
		setTitle("Java Calculator: A Basic Calculator in Java");
		Container pane = getContentPane();
		pane.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
	    
		
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=1;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 5, 0, 0);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(digit0, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=1;
		c.gridy=1;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 0, 0, 0);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(digit1, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=2;
		c.gridy=1;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 0, 0, 0);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(digit2, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=3;
		c.gridy=1;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 0, 0, 5);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(operationPlus, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=2;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 5, 0, 0);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(digit3, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=1;
		c.gridy=2;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 0, 0, 0);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(digit4, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=2;
		c.gridy=2;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 0, 0, 0);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(digit5, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=3;
		c.gridy=2;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 0, 0, 5);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(operationMinus, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=3;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 5, 0, 0);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(digit6, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=1;
		c.gridy=3;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 0, 0, 0);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(digit7, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=2;
		c.gridy=3;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 0, 0, 0);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(digit8, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=3;
		c.gridy=3;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 0, 0, 5);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(operationMultiply, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=4;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 5, 0, 0);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(digit9, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=1;
		c.gridy=4;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 0, 0, 0);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(operationClear, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=2;
		c.gridy=4;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 0, 0, 0);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(operationEqual, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=3;
		c.gridy=4;
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0, 0, 0, 5);
		c.weightx=0.25;
		c.weighty=0.20;
		
		pane.add(operationDivide, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=4;
		c.insets=new Insets(5, 5, 5, 5);
		c.ipadx=5;
		c.ipady=8;
		c.weightx=1;
		c.weighty=0.20;
		
		pane.add(topLabel, c);
		
		//Add things to the pane in the order you want them to appear (left to right, top to bottom)
		
		setMinimumSize(new Dimension(250, 150));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);
        setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void applyClickListeners()
	{
		digit0.addActionListener(this);
		digit1.addActionListener(this);
		digit2.addActionListener(this);
		digit3.addActionListener(this);
		digit4.addActionListener(this);
		digit5.addActionListener(this);
		digit6.addActionListener(this);
		digit7.addActionListener(this);
		digit8.addActionListener(this);
		digit9.addActionListener(this);
		operationPlus.addActionListener(this);
		operationMinus.addActionListener(this);
		operationMultiply.addActionListener(this);
		operationDivide.addActionListener(this);
		operationEqual.addActionListener(this);
		operationClear.addActionListener(this);
	}
	
	
	public static void main(String args[])
	{
		Calc obj = new Calc();
	       
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(clearfiled)
		{
			topLabel.setText("");
			clearfiled=false;
		}
		
		if(e.getSource().equals(digit0))
		{
			topLabel.setText(topLabel.getText()+"0");
		}
		else
		if(e.getSource().equals(digit1))
		{
			topLabel.setText(topLabel.getText()+"1");
		}
		else
		if(e.getSource().equals(digit2))
		{
			topLabel.setText(topLabel.getText()+"2");
		}
		else
		if(e.getSource().equals(digit3))
		{
			topLabel.setText(topLabel.getText()+"3");
		}
		else
		if(e.getSource().equals(digit4))
		{
			topLabel.setText(topLabel.getText()+"4");
		}
		else
		if(e.getSource().equals(digit5))
		{
			topLabel.setText(topLabel.getText()+"5");
		}
		else
		if(e.getSource().equals(digit6))
		{
			topLabel.setText(topLabel.getText()+"6");
		}
		else
		if(e.getSource().equals(digit7))
		{
			topLabel.setText(topLabel.getText()+"7");
		}
		else
		if(e.getSource().equals(digit8))
		{
			topLabel.setText(topLabel.getText()+"8");
		}
		else
		if(e.getSource().equals(digit9))
		{
			topLabel.setText(topLabel.getText()+"9");
		}
		else
		if(e.getSource().equals(operationPlus))
		{
			topLabel.setText(topLabel.getText()+"+");
		}
		else
		if(e.getSource().equals(operationMinus))
		{
			topLabel.setText(topLabel.getText()+"-");
		}
		else
		if(e.getSource().equals(operationMultiply))
		{
			topLabel.setText(topLabel.getText()+"x");
		}
		else
		if(e.getSource().equals(operationDivide))
		{
			topLabel.setText(topLabel.getText()+"/");
		}
		else
		if(e.getSource().equals(operationClear))
		{
			topLabel.setText("Enter Input Here");
			clearfiled=true;
		}
		else
		if(e.getSource().equals(operationEqual))
		{
			topLabel.setText(helper.Calc(topLabel.getText()));
			clearfiled=true;
		}
		
	}
	
}

