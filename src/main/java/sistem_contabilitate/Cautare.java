package sistem_contabilitate;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.IntrareDao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;

public class Cautare extends JFrame {

	private JPanel contentPane;
	private JTextField tf_cuvant;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cautare frame = new Cautare();
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
	public Cautare() {
		super("Cautare intrari");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		btn_back.setBounds(480, 339, 85, 21);
		contentPane.add(btn_back);
		
		JLabel lb_categorieCautare = new JLabel("Coloana dupa care se face cautarea:");
		lb_categorieCautare.setBounds(30, 39, 211, 13);
		contentPane.add(lb_categorieCautare);
		
		final JComboBox cb_categorieCautare = new JComboBox();
		cb_categorieCautare.setBounds(251, 35, 159, 21);
		contentPane.add(cb_categorieCautare);
		
		addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
            	cb_categorieCautare.addItem("tip_intrare");
            	cb_categorieCautare.addItem("nume_sursa");
            	cb_categorieCautare.addItem("data");
            	cb_categorieCautare.addItem("nume_categorie");
            	cb_categorieCautare.addItem("suma");
            }
        });
		
		JLabel lb_cuvant = new JLabel("Cuvant cheie:");
		lb_cuvant.setBounds(30, 68, 93, 13);
		contentPane.add(lb_cuvant);
		
		tf_cuvant = new JTextField();
		tf_cuvant.setBounds(251, 65, 159, 19);
		contentPane.add(tf_cuvant);
		tf_cuvant.setColumns(10);
		
		JButton btn_search = new JButton("Search");
		btn_search.setBounds(480, 64, 85, 21);
		contentPane.add(btn_search);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(480, 95, 85, 21);
		btnClear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Cautare().setVisible(true);
			}
		});
		contentPane.add(btnClear);
		
		btn_search.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cuvant=tf_cuvant.getText();
				String categorie=cb_categorieCautare.getSelectedItem().toString();
				ArrayList<String[]> list=new ArrayList<String[]>();
				if(!categorie.equals("nume_categorie") && !categorie.equals("nume_sursa"))
					list=IntrareDao.getIntrariByIntrare(categorie, cuvant);
				if(categorie.equals("nume_categorie"))
					list=IntrareDao.getIntrariByCategorie(cuvant);
				if(categorie.equals("nume_sursa"))
					list=IntrareDao.getIntrariBySursa(cuvant);
				
				DefaultTableModel dtm=new DefaultTableModel(new String[] {"Id intrare", "Tip intrare", "Suma", "Nume sursa", "Nume categorie", "Data"}, 0);
				for(String[] s : list)
					dtm.addRow(s);
				table = new JTable(dtm);
				table.setBounds(30, 50, 550, 150);
				table.setFont(new java.awt.Font("Segoe UI", 1, 14));
				table.getColumnModel().getColumn(4).setPreferredWidth(100);
				table.setVisible(true);
				JScrollPane scrollPane=new JScrollPane(table);
				scrollPane.setBounds(30, 150, 550, 150);
				contentPane.add(scrollPane, BorderLayout.CENTER);
			}
		});
	}
}
