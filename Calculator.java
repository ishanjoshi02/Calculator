
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener,KeyListener{
	JFrame f;
	JTextField tf;
	JPanel pl;
	String Operation;
	Float Answer;
	JButton[] B = new JButton[16];
	public Calculator() {
		// TODO Auto-generated constructor stub
		int i;
		String str;
		f = new JFrame("Calculator");
		f.setFont(new Font("Noto",13,26));
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(400, 100));
		pl = new JPanel(new GridLayout(4, 4));
		for(i=0;i<16;i++) {
			//Need to do this using queue
			if(i==0)
				str = "7";
			else if(i==1) 
				str = "8";
			else if(i==2)
				str = "9";
			else if(i==3)
				str = "C";
			else if(i==4)
				str = "4";
			else if(i==5) 
				str = "5";
			else if(i==6)
				str = "6";
			else if(i==7)
				str = "x";
			else if(i==8) 
				str = "1";
			else if(i==9)
				str = "2";
			else if(i==10)
				str = "3";
			else if(i==11)
				str = "+";
			else if(i==12)
				str = "0";
			else if(i==13) 
				str = "-";
			else if(i==14)
				str = "/";
			else 
				str = "=";
			B[i] = new JButton(str);
			B[i].setFont(new Font("Roboto", 12, 12));
			B[i].setBackground(new Color(0,188,212));
			B[i].addActionListener(this);
			pl.add(B[i]);
		}
		tf.addKeyListener(this);
		tf.setForeground(new Color(0,150,136));
		tf.setFont(new Font("Roboto",13,18));
		f.add(tf,BorderLayout.NORTH);
		f.add(pl);
		f.setSize(400,400);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==B[0])
			tf.setText(tf.getText()+"7");
		else if(e.getSource()==B[1])
			tf.setText(tf.getText()+"8");
		else if(e.getSource()==B[2])
			tf.setText(tf.getText()+"9");
		else if(e.getSource()==B[3])
			tf.setText(null);
		else if(e.getSource()==B[4])
			tf.setText(tf.getText()+"4");
		else if(e.getSource()==B[5])
			tf.setText(tf.getText()+"5");
		else if(e.getSource()==B[6])
			tf.setText(tf.getText()+"6");
		else if(e.getSource()==B[7]) {
			Answer = Float.parseFloat(tf.getText());
			Operation = "x";
			tf.setText(null);
		}
		else if(e.getSource()==B[8])
			tf.setText(tf.getText()+"1");
		else if(e.getSource()==B[9])
			tf.setText(tf.getText()+"2");
		else if(e.getSource()==B[10])
			tf.setText(tf.getText()+"3");
		else if(e.getSource()==B[11]) {
			Answer = Float.parseFloat(tf.getText());
			Operation = "+";
			tf.setText(null);
		}
		else if(e.getSource()==B[12]) 
			tf.setText(tf.getText()+"0");
		else if(e.getSource()==B[13]) {
			Answer = Float.parseFloat(tf.getText());
			Operation = "-";
			tf.setText(null);
		}
		else if(e.getSource()==B[14]) {
			Answer = Float.parseFloat(tf.getText());
			Operation = "%";
			tf.setText(null);
		}
		else {
			switch (Operation) {
			case "+" :
				tf.setText(String.valueOf(Answer+Float.parseFloat(tf.getText())));		
				break;
			case "-" :
				tf.setText(String.valueOf(Answer-Float.parseFloat(tf.getText())));		
				break;
			case "x" :
				tf.setText(String.valueOf(Answer*Float.parseFloat(tf.getText())));
				break;
			case "/" :
				tf.setText(String.valueOf(Answer/Float.parseFloat(tf.getText())));
				break;
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
	/*	// TODO Auto-generated method stub
		if(e.getKeyChar()=='+'||e.getKeyChar()=='-'||e.getKeyChar()=='x'||e.getKeyChar()=='/')
			if(e.getKeyChar()=='1'||
					e.getKeyChar()=='2'||
					e.getKeyChar()=='3'||
					e.getKeyChar()=='4'||
					e.getKeyChar()=='5'||
					e.getKeyChar()=='6'||
					e.getKeyChar()=='7'||
					e.getKeyChar()=='8'||
					e.getKeyChar()=='9'||
					e.getKeyChar()=='0'||
					e.getKeyChar()=='.')
			tf.setText(null);*/
	}
	@Override
	public void keyTyped(KeyEvent k) {
		// TODO Auto-generated method stub
	/*	if(k.getKeyChar()=='+') {
			Answer = Float.parseFloat(tf.getText());
			Operation = "+";
			tf.setText(null);
		}
		else if(k.getKeyChar()=='-') {
			Answer = Float.parseFloat(tf.getText());
			Operation = "-";
			tf.setText(null);
		}
		else if(k.getKeyChar()=='/') {
			Answer = Float.parseFloat(tf.getText());
			Operation = "/";
			tf.setText(null);
		}
		else if(k.getKeyChar()=='x'||k.getKeyChar()=='*') {
			Answer = Float.parseFloat(tf.getText());
			Operation = "x";
			tf.setText(null);
		}
		else if(k.getKeyChar()=='\n'||k.getKeyChar()=='= ') {
			switch (Operation) {
			case "+" :
				tf.setText(String.valueOf(Answer+Float.parseFloat(tf.getText())));
				break;
			case "-" :
				tf.setText(String.valueOf(Answer-Float.parseFloat(tf.getText())));
				break;
			case "x" :
				tf.setText(String.valueOf(Answer*Float.parseFloat(tf.getText())));
				break;
			case "/" :
				tf.setText(String.valueOf(Answer/Float.parseFloat(tf.getText())));
				break;
			default:
				break;
			}
		}
		else if(k.getKeyChar()=='\b') {
			tf.setText(String.valueOf((Integer.parseInt(tf.getText())/10)));
		}*/
	}
	
}
