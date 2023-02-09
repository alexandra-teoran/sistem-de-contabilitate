package sistem_contabilitate;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.BDOperations;
import dao.CategorieDao;
import dao.IntrareDao;
import dao.SursaDao;
import model.Categorie;
import model.Intrare;
import model.Sursa;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class AdaugareIntrare extends JFrame {

	private JPanel contentPane;
	private JTextField tf_suma;
	private JTextField tf_sursa;
	private JTextField tf_categorie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdaugareIntrare frame = new AdaugareIntrare();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdaugareIntrare() {
		super("Adaugare intrare");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_tipIntrare = new JLabel("Tip intrare:");
		lb_tipIntrare.setForeground(new Color(255, 255, 255));
		lb_tipIntrare.setBounds(23, 27, 81, 13);
		contentPane.add(lb_tipIntrare);
		
	    final JComboBox<String> cb_tipIntrare = new JComboBox<String>();
		cb_tipIntrare.setBounds(111, 23, 152, 21);
		contentPane.add(cb_tipIntrare);
		
		addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
            	cb_tipIntrare.addItem("venituri");
            	cb_tipIntrare.addItem("cheltuieli");
            }
        });
		
		JLabel lb_suma = new JLabel("Suma:");
		lb_suma.setForeground(new Color(255, 255, 255));
		lb_suma.setBounds(23, 68, 45, 13);
		contentPane.add(lb_suma);
		
		tf_suma = new JTextField();
		tf_suma.setFont(new Font("Tahoma", Font.BOLD, 10));
		tf_suma.setBounds(111, 65, 152, 19);
		contentPane.add(tf_suma);
		tf_suma.setColumns(10);
		
		JLabel lb_sursa = new JLabel("Sursa:");
		lb_sursa.setForeground(new Color(255, 255, 255));
		lb_sursa.setBounds(23, 106, 45, 13);
		contentPane.add(lb_sursa);
		
		tf_sursa = new JTextField();
		tf_sursa.setFont(new Font("Tahoma", Font.BOLD, 10));
		tf_sursa.setBounds(111, 103, 152, 19);
		contentPane.add(tf_sursa);
		tf_sursa.setColumns(10);
		
		JLabel lb_categorie = new JLabel("Categorie:");
		lb_categorie.setForeground(new Color(255, 255, 255));
		lb_categorie.setBounds(23, 141, 81, 13);
		contentPane.add(lb_categorie);
		
		tf_categorie = new JTextField();
		tf_categorie.setFont(new Font("Tahoma", Font.BOLD, 10));
		tf_categorie.setBounds(111, 138, 152, 19);
		contentPane.add(tf_categorie);
		tf_categorie.setColumns(10);
		
		JButton btn_save = new JButton("Save");
		btn_save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tip_intrare=cb_tipIntrare.getSelectedItem().toString();
				int suma=Integer.parseInt(tf_suma.getText());
				SimpleDateFormat dformat=new SimpleDateFormat("dd/MM/yyyy");
		        Date date=new Date();
		        String data=dformat.format(date);
				String txtSursa=tf_sursa.getText();
				String txtCategorie=tf_categorie.getText();
				Intrare intrare=new Intrare();
				intrare.setData(data);
				intrare.setSuma(suma);
				intrare.setTip_intrare(tip_intrare);
				if(CategorieDao.idCategorie(txtCategorie)==0) {
					Categorie categorie=new Categorie();
					categorie.setNume_categorie(txtCategorie);
					CategorieDao.save(categorie);
				}
				intrare.setId_categorie(CategorieDao.idCategorie(txtCategorie));
				if(SursaDao.idSursa(txtSursa)==0) {
					Sursa sursa=new Sursa();
					sursa.setNume_sursa(txtSursa);
					SursaDao.save(sursa);
				}
				intrare.setId_sursa(SursaDao.idSursa(txtSursa));
				IntrareDao.save(intrare);
			}
		});
		btn_save.setBounds(23, 177, 85, 21);
		contentPane.add(btn_save);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		btn_back.setBounds(178, 208, 85, 21);
		contentPane.add(btn_back);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(178, 177, 85, 21);
		btnClear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new AdaugareIntrare().setVisible(true);
			}
		});
		contentPane.add(btnClear);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(153, 51, 255));
		setVisible(true);
	}
}
