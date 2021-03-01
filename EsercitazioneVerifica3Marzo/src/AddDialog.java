import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class AddDialog extends JDialog implements ActionListener{
	private JLabel nome, cognome, classe;
	private JTextField addNome, addCognome;
	private JButton aggiungi;
	private JMenuBar bar;
	private JMenu menu;
	private JMenuItem importa, esporta;
	private Elenco el;
	private JComboBox boxClasse;
	
	public void initComponents() {
		this.setLayout(new GridLayout(2,3));
		
		nome=new JLabel("Nome");
		cognome=new JLabel("Cognome");
		classe=new JLabel("Classe");
		
		addNome=new JTextField(15);
		addCognome=new JTextField(15);
		
		aggiungi=new JButton("Aggiungi");
		aggiungi.addActionListener(this);
		
		bar=new JMenuBar();
		menu=new JMenu("File");
		importa=new JMenuItem("Importa");
		esporta=new JMenuItem("Esporta");
		menu.add(importa);
		menu.add(esporta);
		bar.add(menu);
		importa.addActionListener(this);
		esporta.addActionListener(this);
		
		boxClasse=new JComboBox();
		boxClasse.addItem("1A");
		boxClasse.addItem("1B");
		boxClasse.addItem("1C");
		boxClasse.addItem("1D");
		boxClasse.addItem("1E");
		boxClasse.addItem("1F");
		boxClasse.addItem("1G");
		boxClasse.addItem("2A");
		boxClasse.addItem("2B");
		boxClasse.addItem("2C");
		boxClasse.addItem("2D");
		boxClasse.addItem("2E");
		boxClasse.addItem("2F");
		boxClasse.addItem("2G");
		boxClasse.addItem("3A");
		boxClasse.addItem("3B");
		boxClasse.addItem("3C");
		boxClasse.addItem("3D");
		boxClasse.addItem("3E");
		boxClasse.addItem("3F");
		boxClasse.addItem("3G");
		boxClasse.addItem("4A");
		boxClasse.addItem("4B");
		boxClasse.addItem("4C");
		boxClasse.addItem("4D");
		boxClasse.addItem("4E");
		boxClasse.addItem("4F");
		boxClasse.addItem("4G");
		boxClasse.addItem("5A");
		boxClasse.addItem("5B");
		boxClasse.addItem("5C");
		boxClasse.addItem("5D");
		boxClasse.addItem("5E");
		boxClasse.addItem("5F");
		boxClasse.addItem("5G");
		
		this.add(nome);
		this.add(addNome);
		this.add(cognome);
		this.add(addCognome);
		this.add(classe);
		this.add(boxClasse);
		this.add(aggiungi);
		this.add(bar);
		
	}
	
	public AddDialog(JFrame f, boolean modal, Elenco el) {
		super(f,modal);
		this.el=el;
		initComponents();
	}
	
	public String insImmagine(AddDialog dialog) {
		JFileChooser fileChooser = new JFileChooser(); 
		int n = fileChooser.showOpenDialog(dialog);
		if (n == JFileChooser.APPROVE_OPTION) {
			File f = fileChooser.getSelectedFile();
			return f.getAbsolutePath();
		}
		return null;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(aggiungi)){
			String path=insImmagine(this);
			Studente s=new Studente (addNome.getText(),addCognome.getText(), (String)boxClasse.getSelectedItem(), path);
			
			el.add(s);
		}
		
		if(e.getSource().equals(importa)) {
			try {
				
				el.leggiFile(this);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource().equals(esporta)) {
			try {
				el.createCsv();
				el.creaFile(this);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	
}
