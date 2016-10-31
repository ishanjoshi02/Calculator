
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener{
	JFrame f;
	JTextField tf;
	JPanel pl;
	Icon i;
	Integer Answer;
	JButton[] B = new JButton[16];
	public Calculator() {
		// TODO Auto-generated constructor stub
		int i;
		String str;
		f = new JFrame("Calculator");
		f.setLayout(new BorderLayout());
		tf = new JTextField("Calculator is ready at your Service");
		tf.setSize(398, 100);
		pl = new JPanel(new GridLayout(4, 4));
		for(i=0;i<16;i++) {
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
				str = "-";
			else if(i==13) 
				str = "%";
			else if(i==14)
				str = "=";
			else 
				str = "0";
			B[i] = new JButton(str);
			B[i].addActionListener(this);
			pl.add(B[i]);
		}
		tf.addActionListener(this);
		f.add(tf);
		f.add(pl);
		f.setSize(400, 600);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.equals(tf)==true||e.equals(B[3]))
			tf.setText(null);
	}
	
}
