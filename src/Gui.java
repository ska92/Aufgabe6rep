import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;


public class Gui extends JFrame implements ActionListener {
	
	private JButton check;
	private JEditorPane ep;
	private JEditorPane sp;
	private JScrollPane esp;
	private JScrollPane ssp;
	private JMenuBar menu;
	private JPanel panel1,panel2,menupanel;
	private JFrame f;
	private JMenu datei,hilfe;
	private JMenuItem oeffnen,beenden,help;
	

	public Gui(String name) {
		
		
		f = new JFrame(name);
		checkButton();
		jEditorPane();
		menu();
		fensterErzeugen();
			
	}
	
	/**
	 * Verarbeitet die Button Actions der Gui
	 */
	
	
	public void actionPerformed(ActionEvent ae){
		
		// Gibt die Eingabe aus dem ep an den Lexer weiter
		if(ae.getSource() == check){
			StringReader sr = new StringReader(ep.getText());
			BufferedReader br = new BufferedReader(sr);
			// br ist der BufferedReader der in den Lexer gegeben werden muss
			sp.setText(ep.getText()); //Hier muss anstatt ep.getText() die Ausgabe des Lexers rein
		}
		
		// Öffnet eine Datei und liest sie in den ep ein
		
		if(ae.getSource() == oeffnen){
			try {
				ep.setText(dateioeffnen().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// Beendet das Programm
		if(ae.getSource() == beenden){
			System.exit(EXIT_ON_CLOSE);
		}
	}
	
	/**
	 * Erzeugt die EditorPanes zur Eingabe und Ausgabe des Textes
	 */
	public void jEditorPane(){
		
		ep = new JEditorPane();
		esp = new JScrollPane(ep);
		sp = new JEditorPane();
		ssp = new JScrollPane(sp);
		
		sp.setText("LOOOOOOOOL");
		sp.setForeground(Color.black);
		sp.setBackground(Color.white);
		ep.setSize(400, 600);
		sp.setSize(400, 600);
		
		esp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		esp.setPreferredSize(new Dimension(250, 145));
		esp.setMinimumSize(new Dimension(10, 10));
		ssp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		ssp.setPreferredSize(new Dimension(250, 145));
		ssp.setMinimumSize(new Dimension(10, 10));
		
	}
	
	/**
	 * Erzeugt die komplette Gui
	 */
	
	public void fensterErzeugen(){
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		panel1.setLayout(new GridLayout(1,1));
		panel1.add(esp);
		panel1.add(ssp);
		panel1.setSize(400, 600);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel2.add(check);
		
		f.setLayout(new GridLayout(3,1));
		f.setJMenuBar(menu);
		
		f.add(panel1);
		f.add(panel2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setSize(1000, 600);
		f.setVisible(true);
	}
	
	/**
	 * Erstellt den Checkbutton
	 */
	
	public void checkButton(){
		
		check = new JButton("Check");
		check.setSize(50, 50);
		check.addActionListener(this);
		
	}
	
	/**
	 * Erstellt das Menü & alle Untermenüpunkte
	 */
	
	public void menu(){
		
		// Menüleiste erzeugen
		menu = new JMenuBar();
		menu.setSize(getWidth(), 10);
		menu.setAlignmentX(LEFT_ALIGNMENT);
		
		// Menüpunkte erzeugen
		
		datei = new JMenu("Datei");
		hilfe = new JMenu("Help");
		
		// Untermenüelemente erzeugen
        oeffnen = new JMenuItem("öffnen");
        oeffnen.addActionListener(this);
        beenden = new JMenuItem("beenden");
        beenden.addActionListener(this);
        help = new JMenuItem("hilfe");
        help.addActionListener(this);
        
     // Menüelemente hinzufügen
        menu.add(datei);
        menu.add(hilfe);
        
     // Untermenüelemente hinzufügen
        datei.add(oeffnen);
        datei.add(beenden);
     
	}
	
	/**
	 * Methode zum erzeugen des OpenDataDialogs und einlesen der Datei
	 * @throws IOException
	 * @return StringBuffer sb
	 */
	
	public StringBuffer dateioeffnen() throws IOException{
		StringBuffer sb = new StringBuffer();
		int ch;
		 final JFileChooser chooser = new JFileChooser("Verzeichnis wählen");
	        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
	        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	        final File file = new File("/home");

	        chooser.setCurrentDirectory(file);

	    

	        chooser.setVisible(true);
	        final int result = chooser.showOpenDialog(null);

	        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	        	   FileInputStream inp = new FileInputStream(chooser.getSelectedFile().getAbsolutePath());
	        	   while( (ch = inp.read()) != -1)
	        	        sb.append((char)ch);
	        }
	        
	        
	       
	        chooser.setVisible(false);
	        return sb;
	       
	    } 
	
	
		
	

	public static void main(String[] args) {
		Gui g = new Gui("Lexer");
		
	}
}
