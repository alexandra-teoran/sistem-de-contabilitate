package sistem_contabilitate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder; 


public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setLocationRelativeTo(null);
					frame.getContentPane().setBackground(Color.yellow);
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
	public Home() {
		super("Sistem de contabilitate");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_adaugare = new JButton("Adaugare intrare");
		btn_adaugare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdaugareIntrare().setVisible(true);
			}
		});
		btn_adaugare.setBounds(63, 37, 140, 21);
		contentPane.add(btn_adaugare);
		
		JButton btn_vizualizare = new JButton("Vizualizare intrari");
		btn_vizualizare.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new VizualizareIntrari().setVisible(true);
			}
		});
		btn_vizualizare.setBounds(248, 37, 151, 21);
		contentPane.add(btn_vizualizare);
		
		JButton btn_grafic = new JButton("Vizualizare grafic");
		btn_grafic.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new VizualizareGrafic().setVisible(true);
			}
		});
		btn_grafic.setBounds(452, 37, 151, 21);
		contentPane.add(btn_grafic);
		
		JButton btn_cautare = new JButton("Cautare intrari");
		btn_cautare.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Cautare().setVisible(true);
			}
		});
		btn_cautare.setBounds(115, 130, 140, 21);
		contentPane.add(btn_cautare);
		
		JButton btn_sold = new JButton("Vizualizare sold curent");
		btn_sold.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new VizualizareSold().setVisible(true);
			}
		});
		btn_sold.setBounds(325, 130, 190, 21);
		contentPane.add(btn_sold);
	}
}
