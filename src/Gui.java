import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.StringReader;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class Gui extends JFrame implements ActionListener {
	
	private JButton check;
	private JEditorPane ep;
	private JLabel sp;

	public Gui() {
		
		Dimension dim = new Dimension(200,200);

		JEditorPane ep = new JEditorPane();
		JScrollPane esp = new JScrollPane(ep);
		JLabel sp = new JLabel();
		JButton check = new JButton("Check");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		sp.setText("LOOOOOOOOL");
		sp.setForeground(Color.white);
		sp.setBackground(Color.white);
		ep.setMaximumSize(dim);
		sp.setSize(200, 200);
		check.setSize(50, 50);
		esp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		esp.setPreferredSize(new Dimension(250, 145));
		esp.setMinimumSize(new Dimension(10, 10));
		
		
		panel1.setLayout(new GridLayout(1,1));
		panel1.add(ep);
		panel1.add(sp);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel2.add(check);
		
		

		JFrame f = new JFrame("Lexer");
		f.setLayout(new GridLayout(2,1));
		f.add(panel1);
		f.add(panel2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000,1000);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getSource() == this.check){
			StringReader sr = new StringReader(ep.getText());
			BufferedReader br = new BufferedReader(sr);
			sp.setText("Test");
		}
	}
	
	
		
	

	public static void main(String[] args) {
		Gui g = new Gui();
	}
}
