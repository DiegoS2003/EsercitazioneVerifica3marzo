import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class AddDialog extends JDialog implements ActionListener{
	private JLabel nome, cognome, classe, foto;
	private JTextField addNome, addCognome, addClasse;
	private JButton aggiungi, importImm;
	private JMenuBar bar;
	private JMenu menu;
	private JMenuItem importa, esporta;
	private Elenco el;
	
	public void initComponents() {
		this.setLayout(new GridLayout(5,2));
		
		nome=new JLabel("Nome");
		cognome=new JLabel("Cognome");
		classe=new JLabel("Classe");
		foto=new JLabel("Immagine");
		
		addNome=new JTextField(15);
		addCognome=new JTextField(15);
		addClasse=new JTextField(15);
		
		aggiungi=new JButton("Aggiungi");
		aggiungi.addActionListener(this);
		
		importImm=new JButton("Importa immagine");
		importImm.addActionListener(this);
		
		bar=new JMenuBar();
		menu=new JMenu("File");
		importa=new JMenuItem("Importa");
		esporta=new JMenuItem("Esporta");
		menu.add(importa);
		menu.add(esporta);
		bar.add(menu);
		
		this.add(nome);
		this.add(addNome);
		this.add(cognome);
		this.add(addCognome);
		this.add(classe);
		this.add(addClasse);
		this.add(foto);
		this.add(importImm);
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
			Studente s=new Studente (addNome.getText(),addCognome.getText(), addClasse.getText(), insImmagine(this));
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
				el.creaFile(this);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		/*if(e.getSource().equals(importImm)) {
			insImmagine(this);
		}*/ //se vediamo che non serve cancellare i pezzi in più

	}
	
	
}
