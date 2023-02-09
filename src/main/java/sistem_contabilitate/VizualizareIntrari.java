package sistem_contabilitate;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.BDOperations;
import dao.IntrareDao;
import model.Intrare;

import javax.swing.JTable;
import javax.swing.JButton;

public class VizualizareIntrari extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VizualizareIntrari frame = new VizualizareIntrari();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VizualizareIntrari() {
		super("Vizualizare intrari");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<String[]> list=IntrareDao.getAllRecords();
		DefaultTableModel dtm=new DefaultTableModel(new String[] {"Id intrare", "Tip intrare", "Suma", "Nume sursa", "Nume categorie", "Data"}, 0);
		for(int i=0; i<list.size(); i++)
			dtm.addRow(list.get(i));
		table = new JTable(dtm);
		table.setBounds(30, 50, 550, 150);
		table.setFont(new java.awt.Font("Segoe UI", 1, 14));
		table.setForeground(Color.BLACK);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.setVisible(true);
		table.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int index=table.getSelectedRow();
				int a=JOptionPane.showConfirmDialog(null, "Vrei sa stergi aceasta intrare?", "Select", JOptionPane.YES_NO_OPTION);
		        if(a==0){
		        	 IntrareDao.delete(table.getValueAt(index, 1).toString());
		             setVisible(false);
		             new VizualizareIntrari().setVisible(true);
		        }
			}
		});
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setBounds(30, 50, 550, 150);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		btn_back.setBounds(495, 231, 85, 21);
		contentPane.add(btn_back);
	}
}
