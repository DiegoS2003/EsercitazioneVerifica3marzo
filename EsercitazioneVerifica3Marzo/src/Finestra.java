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
	private String boxContent;
	
	public void initComponents() {
		this.setLayout(new GridLayout(2,3));
		
		panelIm=new JPanel();
		panelBox=new JPanel();
		
		Object[][] data = {};
		String[] nomeColonne={"Nome", "Cognome", "Classe"};
		dft = new DefaultTableModel(data, nomeColonne);
		tab = new JTable(dft);
		pane = new JScrollPane(tab);
		
		box=new JComboBox();
		box.addItem("1A");
		box.addItem("1B");
		box.addItem("1C");
		box.addItem("1D");
		box.addItem("1E");
		box.addItem("1F");
		box.addItem("1G");
		box.addItem("2A");
		box.addItem("2B");
		box.addItem("2C");
		box.addItem("2D");
		box.addItem("2E");
		box.addItem("2F");
		box.addItem("2G");
		box.addItem("3A");
		box.addItem("3B");
		box.addItem("3C");
		box.addItem("3D");
		box.addItem("3E");
		box.addItem("3F");
		box.addItem("3G");
		box.addItem("4A");
		box.addItem("4B");
		box.addItem("4C");
		box.addItem("4D");
		box.addItem("4E");
		box.addItem("4F");
		box.addItem("4G");
		box.addItem("5A");
		box.addItem("5B");
		box.addItem("5C");
		box.addItem("5D");
		box.addItem("5E");
		box.addItem("5F");
		box.addItem("5G");
		box.setSelectedItem(null);
		
		panelBox.add(box);
		panelBox.setSize(50, 50);
		box.addActionListener(this); //se non funziona provare con box.AddActionListener(panelBox)
		
		add=new JButton("Aggiungi");
		add.addActionListener(this);
		
		label=new JLabel();
		panelIm.add(label);
		
		tab.addMouseListener(this);
		
		this.add(pane);
		this.add(panelBox);
		this.add(panelIm);
		this.add(add);
		
		
	}
	
	private void updateTab(String s) {
		dft.setRowCount(0);
		for (int i = 0; i < elenco.size(); i++) {
			if(elenco.get(i).getClasse().contentEquals(s)) {
				Object[] row = { elenco.get(i).getNome(), elenco.get(i).getCognome(), elenco.get(i).getClasse() };
				dft.addRow(row);
			}
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
		
		if(e.getSource().equals(tab)) {
			if(tab.getSelectedRow() != -1) {
				int i = tab.getSelectedRow();
				if(elenco.get(i) != null) {
					Studente studente = elenco.get(i);
					System.out.println(studente.getPath());
					icon = new ImageIcon (studente.getPath());
					label.setIcon(icon);

				}
			}
		}	
		//icon = new ImageIcon ();
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
			AddDialog id = new AddDialog(this, true, elenco);
			id.setTitle("Inserimento");
			id.setSize(800, 600);
			id.setVisible(true);
		}
		if(e.getSource().equals(box)) {
			String value=(String)box.getSelectedItem();
			updateTab(value);
		}
		
	}

}
