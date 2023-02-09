package sistem_contabilitate;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import dao.IntrareDao;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Panel;

public class VizualizareGrafic extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VizualizareGrafic frame = new VizualizareGrafic();
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
	public VizualizareGrafic() {
		super("Vizualizare grafic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 485);
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
		btn_back.setBounds(525, 391, 85, 21);
		contentPane.add(btn_back);
		
		Panel chartPanel = new Panel();
		chartPanel.setBounds(22, 48, 588, 317);
		contentPane.add(chartPanel);
		
		DefaultCategoryDataset barChartData=new DefaultCategoryDataset();
		ArrayList<Integer> list=IntrareDao.getChartData();
		barChartData.setValue(list.get(0), "Suma", "Venituri");
		barChartData.setValue(list.get(1), "Suma", "Cheltuieli");
		JFreeChart barChart=ChartFactory.createBarChart("", "Tip intrare", "Suma", barChartData, PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot barchrt=barChart.getCategoryPlot();
		barchrt.setRangeGridlinePaint(Color.blue);
		ChartPanel barPanel=new ChartPanel(barChart);
		chartPanel.removeAll();
		chartPanel.setLayout(new BorderLayout(0, 0));
		chartPanel.add(barPanel, BorderLayout.CENTER);
		chartPanel.validate();
	}
}
