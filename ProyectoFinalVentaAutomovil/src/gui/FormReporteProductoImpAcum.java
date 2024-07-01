package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Automovil;
import model.Venta;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormReporteProductoImpAcum extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	DefaultTableModel model = new DefaultTableModel();
	
	private JPanel panel;
	private JLabel lblListadoDeProductos_1;
	private JScrollPane scrollPane;
	private JButton btnCerrar;
	private JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormReporteProductoImpAcum frame = new FormReporteProductoImpAcum();
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
	public FormReporteProductoImpAcum() {
		setTitle("Listado de productos por importe total acumulado");
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
		
		lblListadoDeProductos_1 = new JLabel("Listado de productos por importe total acumulado");
		lblListadoDeProductos_1.setToolTipText("");
		lblListadoDeProductos_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeProductos_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblListadoDeProductos_1.setBounds(10, 5, 785, 29);
		panel.add(lblListadoDeProductos_1);
		
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
		model.addColumn("Importe Acumulado");
		table.setModel(model);

		// formato de celdas clase Render()
		table.setDefaultRenderer(Object.class, new RptProductoAcmImpRender());
		
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

		double importeTotal = 0;
		double importeGeneral = 0;
		for (Automovil automovil : MenuPrincipal.listAutomoviles.getListAutomoviles()) {
			importeTotal = 0;
			for (Venta venta : MenuPrincipal.listVentas.getListVentas()) {
				if(automovil.getCodigoAutomovil() == venta.getCodigoAutomovil() && venta.isAnulado()==false) {
					importeTotal += venta.getTotal();
				}
				
			}
			if(importeTotal>0) {
				Object[] fila = new Object[3];
				fila[0] = automovil.getCodigoAutomovil();
				fila[1] = automovil.getMarca() + " - " + automovil.getModelo() + " " + automovil.getAnioFabricacion() + " - " + automovil.getColor();
				fila[2] = Math.round(importeTotal * 100.0) / 100.0;
				model.addRow(fila);
				importeGeneral += importeTotal;				
			}
		}

		Object[] fila = new Object[3];

		fila[0] = "";
		fila[1] = "TOTAL IMPORTE ACUMULADO: ";
		fila[2] = Math.round(importeGeneral* 100.0) / 100.0;
		model.addRow(fila);

	}
}
