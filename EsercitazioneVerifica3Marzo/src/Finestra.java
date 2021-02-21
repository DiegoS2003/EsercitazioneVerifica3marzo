import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Finestra extends JFrame implements ActionListener, MouseListener{
	
	
	private JTable tab;
	private DefaultTableModel dft;
	private JScrollPane pane;
	private JPanel panelIm, panelBox;
	private JLabel label;
	private JComboBox box;
	private JButton add;
	private ImageIcon icon;
	private Elenco elenco;
	
	public void initComponents() {
		this.setLayout(new GridLayout(2,3));
		
		panelIm=new JPanel();
		panelBox=new JPanel();
		
		Object[][] data = {};
		String[] nomeColonne={"Nome", "Cognome", "Classe"};
		dft = new DefaultTableModel(data, nomeColonne);
		tab = new JTable(dft);
		pane = new JScrollPane(tab);
		
		
		String classe[]= {"Classi","4A","4B","4C","4E","4F","4G" };
		box=new JComboBox(classe);
		panelBox.add(box);
		panelBox.setSize(50, 50);
		box.addActionListener(this); //se non funziona provare con box.AddActionListener(panelBox)
		
		add=new JButton("Aggiungi");
		add.addActionListener(this);
		
		label=new JLabel();
		panelIm.add(label);
		
		
		this.add(pane);
		this.add(panelBox);
		this.add(panelIm);
		this.add(add);
		
	}
	
	/*public void insImmagine(JFrame finestra, ImageIcon im) {
		JFileChooser fileChooser = new JFileChooser(); 
		int n = fileChooser.showOpenDialog(finestra);
		if (n == JFileChooser.APPROVE_OPTION) {
			File f = fileChooser.getSelectedFile();
			im = new ImageIcon (f.getAbsolutePath());
		}
	}*/
	
	private void updateTab() {
		dft.setRowCount(0);
		for (int i = 0; i < elenco.size(); i++) {
			Object[] row = { elenco.get(i).getNome(), elenco.get(i).getCognome(), elenco.get(i).getClasse() };
			dft.addRow(row);
		}
	}
	
	public Finestra() {
		initComponents();
		elenco = new Elenco();
	}
	
	public static void main(String args[]) {
		Finestra finestra=new Finestra();
		finestra.setSize(600,800);
		finestra.setTitle("Studenti Cocito");
		finestra.setVisible(true);
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(add)) {
			AddDialog id =null;
			id = new AddDialog(this, true, elenco);
			id.setTitle("Inserimento");
			id.setSize(800, 600);
			id.setVisible(true);
		}
		
	}

}
