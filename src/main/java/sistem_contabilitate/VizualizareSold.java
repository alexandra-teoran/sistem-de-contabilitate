package sistem_contabilitate;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.IntrareDao;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class VizualizareSold extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VizualizareSold frame = new VizualizareSold();
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
	public VizualizareSold() {
		super("Vizualizare sold curent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 272);
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
		btn_back.setBounds(321, 166, 85, 21);
		contentPane.add(btn_back);
		
		JLabel lblNewLabel = new JLabel("Soldul curent este:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(22, 68, 146, 13);
		contentPane.add(lblNewLabel);
		
		JLabel txt_sold = new JLabel("00");
		txt_sold.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_sold.setBounds(210, 68, 45, 13);
		contentPane.add(txt_sold);
		txt_sold.setText(String.valueOf(IntrareDao.getSold()));
	}
}
