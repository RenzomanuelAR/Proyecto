package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import model.Automovil;
import model.Venta;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class FormReporteProductoStock extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblListadoDeProductos;
	private JScrollPane scrollPane;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormReporteProductoStock frame = new FormReporteProductoStock();
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
	public FormReporteProductoStock() {
		setTitle("Listado de productos cuyo stock se encuentra por debajo del stock mínimo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 841, 634);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 805, 40);
		contentPane.add(panel);
		
		lblListadoDeProductos = new JLabel("Listado de productos cuyo stock se encuentra por debajo del stock mínimo");
		lblListadoDeProductos.setToolTipText("");
		lblListadoDeProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeProductos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblListadoDeProductos.setBounds(10, 5, 785, 29);
		panel.add(lblListadoDeProductos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 805, 492);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(726, 565, 89, 23);
		contentPane.add(btnCerrar);
		
		model.addColumn("Código Automóvil");
		model.addColumn("Descripción Automóvil");
		model.addColumn("Stock Actual");
		model.addColumn("Stock Mínimo");
		table.setModel(model);

		// formato de celdas clase Render()
		table.setDefaultRenderer(Object.class, new RptProductoStockRender());
		
		cargarDatos();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	private void cargarDatos() {
		model.setRowCount(0);

		for (Automovil automovil : MenuPrincipal.listAutomoviles.getListAutomoviles()) {
			if(automovil.getStockActual()<automovil.getStockMinimo()) {
				Object[] fila = new Object[4];
				fila[0] = automovil.getCodigoAutomovil();
				fila[1] = automovil.getMarca() + " - " + automovil.getModelo() + " " + automovil.getAnioFabricacion() + " - " + automovil.getColor();
				fila[2] = automovil.getStockActual();
				fila[3] = automovil.getStockMinimo();
				model.addRow(fila);				
			}
		}


	}
}
