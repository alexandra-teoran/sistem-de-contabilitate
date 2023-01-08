package sistem_contabilitate;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
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
		
		JComboBox cb_categorieCautare = new JComboBox();
		cb_categorieCautare.setBounds(251, 35, 159, 21);
		contentPane.add(cb_categorieCautare);
		
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
		
		table = new JTable();
		table.setBounds(328, 191, -169, -44);
		contentPane.add(table);
	}

}
