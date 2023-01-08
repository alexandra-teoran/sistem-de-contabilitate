package sistem_contabilitate;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdaugareIntrare extends JFrame {

	private JPanel contentPane;
	private JTextField tf_suma;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdaugareIntrare frame = new AdaugareIntrare();
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
	public AdaugareIntrare() {
		super("Adaugare intrare");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_tipIntrare = new JLabel("Tip intrare:");
		lb_tipIntrare.setBounds(23, 27, 81, 13);
		contentPane.add(lb_tipIntrare);
		
		JComboBox cb_tipIntrare = new JComboBox();
		cb_tipIntrare.setBounds(111, 23, 152, 21);
		contentPane.add(cb_tipIntrare);
		
		JLabel lb_suma = new JLabel("Suma:");
		lb_suma.setBounds(23, 68, 45, 13);
		contentPane.add(lb_suma);
		
		tf_suma = new JTextField();
		tf_suma.setBounds(111, 65, 152, 19);
		contentPane.add(tf_suma);
		tf_suma.setColumns(10);
		
		JLabel lb_data = new JLabel("Data:");
		lb_data.setBounds(23, 111, 45, 13);
		contentPane.add(lb_data);
		
		textField = new JTextField();
		textField.setBounds(111, 108, 152, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lb_sursa = new JLabel("Sursa:");
		lb_sursa.setBounds(23, 148, 45, 13);
		contentPane.add(lb_sursa);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 145, 152, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lb_categorie = new JLabel("Categorie:");
		lb_categorie.setBounds(23, 183, 81, 13);
		contentPane.add(lb_categorie);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 180, 152, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btn_save = new JButton("Save");
		btn_save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		btn_save.setBounds(23, 232, 85, 21);
		contentPane.add(btn_save);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		btn_back.setBounds(178, 232, 85, 21);
		contentPane.add(btn_back);
	}
}
