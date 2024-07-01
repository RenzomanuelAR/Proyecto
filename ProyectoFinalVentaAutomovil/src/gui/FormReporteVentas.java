package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import model.Automovil;
import model.Cliente;
import model.Venta;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormReporteVentas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTable table;
	private JButton btnCerrar;

	DefaultTableModel model = new DefaultTableModel();
	private JButton btnTodo;
	private JButton btnAnuladas;
	private JButton btnRealizadas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormReporteVentas frame = new FormReporteVentas();
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
	public FormReporteVentas() {
		setResizable(false);
		setTitle("Listado general de ventas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 841, 632);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 805, 492);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 436, 40);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("Listado general de Ventas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 5, 416, 29);
		panel.add(lblNewLabel);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(726, 565, 89, 23);
		contentPane.add(btnCerrar);

		model.addColumn("Cód. Venta");
		model.addColumn("Fecha");
		model.addColumn("Cod. Cliente");
		model.addColumn("Nom. Cliente");
		model.addColumn("Cod. Autom.");
		model.addColumn("Des. Autom.");
		model.addColumn("Cantidad");
		model.addColumn("Precio");
		model.addColumn("Importe");
		model.addColumn("Descuento");
		model.addColumn("IGV");
		model.addColumn("Total");
		model.addColumn("Anulado");
		table.setModel(model);
		
		//formato de celdas clase Render()
		table.setDefaultRenderer(Object.class, new RptVentasRender());

		btnTodo = new JButton("Todo");
		btnTodo.addActionListener(this);
		btnTodo.setBounds(456, 11, 113, 40);
		contentPane.add(btnTodo);

		btnAnuladas = new JButton("Anuladas");
		btnAnuladas.addActionListener(this);
		btnAnuladas.setBounds(702, 11, 113, 40);
		contentPane.add(btnAnuladas);

		btnRealizadas = new JButton("Realizadas");
		btnRealizadas.addActionListener(this);
		btnRealizadas.setBounds(579, 11, 113, 40);
		contentPane.add(btnRealizadas);
		cargarDatos();

	}

	// metodos privados
	private void cargarDatos() {
		model.setRowCount(0);

		double importeTotal = 0;
		double descuentoTotal = 0;
		double igvTotal = 0;
		double totalTotal = 0;
		for (Venta venta : MenuPrincipal.listVentas.getListVentas()) {
			Object[] fila = new Object[13];
			Cliente cliente = MenuPrincipal.listClientes.busqueda(venta.getCodigoCliente());
			Automovil automovil = MenuPrincipal.listAutomoviles.busqueda(venta.getCodigoAutomovil());
			fila[0] = venta.getCodigoVenta();
			fila[1] = venta.getFecha();
			fila[2] = venta.getCodigoCliente();
			fila[3] = cliente.getNombres() + " " + cliente.getApellidos();
			fila[4] = venta.getCodigoAutomovil();
			fila[5] = automovil.getMarca() + " - " + automovil.getModelo();
			fila[6] = venta.getCantidad();
			fila[7] = Math.round(venta.getPrecio() * 100.0) / 100.0;
			fila[8] = Math.round(venta.getImporte() * 100.0) / 100.0;
			fila[9] = Math.round(venta.getDescuento() * 100.0) / 100.0;
			fila[10] = Math.round(venta.getIgv() * 100.0) / 100.0;
			fila[11] = Math.round(venta.getTotal() * 100.0) / 100.0;
			fila[12] = venta.isAnulado();
			model.addRow(fila);

			importeTotal += Double.valueOf(venta.getImporte());
			descuentoTotal += Double.valueOf(venta.getDescuento());
			igvTotal += Double.valueOf(venta.getIgv());
			totalTotal += Double.valueOf(venta.getTotal());
		}

		Object[] fila = new Object[13];

		fila[0] = "";
		fila[1] = "";
		fila[2] = "";
		fila[3] = "";
		fila[4] = "";
		fila[5] = "";
		fila[6] = "";
		fila[7] = "TOTA GENERAL: ";
		fila[8] = Math.round(importeTotal * 100.0) / 100.0;
		fila[9] = Math.round(descuentoTotal * 100.0) / 100.0;
		fila[10] = Math.round(igvTotal * 100.0) / 100.0;
		fila[11] = Math.round(totalTotal * 100.0) / 100.0;
		fila[12] = "";
		model.addRow(fila);

	}

	private void cargarDatosAnulados() {
		model.setRowCount(0);

		double importeTotal = 0;
		double descuentoTotal = 0;
		double igvTotal = 0;
		double totalTotal = 0;
		for (Venta venta : MenuPrincipal.listVentas.getListVentas()) {
			if (venta.isAnulado()) {
				Object[] fila = new Object[13];
				Cliente cliente = MenuPrincipal.listClientes.busqueda(venta.getCodigoCliente());
				Automovil automovil = MenuPrincipal.listAutomoviles.busqueda(venta.getCodigoAutomovil());
				fila[0] = venta.getCodigoVenta();
				fila[1] = venta.getFecha();
				fila[2] = venta.getCodigoCliente();
				fila[3] = cliente.getNombres() + " " + cliente.getApellidos();
				fila[4] = venta.getCodigoAutomovil();
				fila[5] = automovil.getMarca() + " - " + automovil.getModelo();
				fila[6] = venta.getCantidad();
				fila[7] = Math.round(venta.getPrecio() * 100.0) / 100.0;
				fila[8] = Math.round(venta.getImporte() * 100.0) / 100.0;
				fila[9] = Math.round(venta.getDescuento() * 100.0) / 100.0;
				fila[10] = Math.round(venta.getIgv() * 100.0) / 100.0;
				fila[11] = Math.round(venta.getTotal() * 100.0) / 100.0;
				fila[12] = venta.isAnulado();
				model.addRow(fila);

				importeTotal += Double.valueOf(venta.getImporte());
				descuentoTotal += Double.valueOf(venta.getDescuento());
				igvTotal += Double.valueOf(venta.getIgv());
				totalTotal += Double.valueOf(venta.getTotal());
			}

		}

		Object[] fila = new Object[13];

		fila[0] = "";
		fila[1] = "";
		fila[2] = "";
		fila[3] = "";
		fila[4] = "";
		fila[5] = "";
		fila[6] = "";
		fila[7] = "TOTA GENERAL: ";
		fila[8] = Math.round(importeTotal * 100.0) / 100.0;
		fila[9] = Math.round(descuentoTotal * 100.0) / 100.0;
		fila[10] = Math.round(igvTotal * 100.0) / 100.0;
		fila[11] = Math.round(totalTotal * 100.0) / 100.0;
		fila[12] = "";
		model.addRow(fila);

	}

	private void cargarDatosRealizadas() {
		model.setRowCount(0);

		double importeTotal = 0;
		double descuentoTotal = 0;
		double igvTotal = 0;
		double totalTotal = 0;
		for (Venta venta : MenuPrincipal.listVentas.getListVentas()) {
			if (!venta.isAnulado()) {
				Object[] fila = new Object[13];
				Cliente cliente = MenuPrincipal.listClientes.busqueda(venta.getCodigoCliente());
				Automovil automovil = MenuPrincipal.listAutomoviles.busqueda(venta.getCodigoAutomovil());
				fila[0] = venta.getCodigoVenta();
				fila[1] = venta.getFecha();
				fila[2] = venta.getCodigoCliente();
				fila[3] = cliente.getNombres() + " " + cliente.getApellidos();
				fila[4] = venta.getCodigoAutomovil();
				fila[5] = automovil.getMarca() + " - " + automovil.getModelo();
				fila[6] = venta.getCantidad();
				fila[7] = Math.round(venta.getPrecio() * 100.0) / 100.0;
				fila[8] = Math.round(venta.getImporte() * 100.0) / 100.0;
				fila[9] = Math.round(venta.getDescuento() * 100.0) / 100.0;
				fila[10] = Math.round(venta.getIgv() * 100.0) / 100.0;
				fila[11] = Math.round(venta.getTotal() * 100.0) / 100.0;
				fila[12] = venta.isAnulado();
				model.addRow(fila);

				importeTotal += Double.valueOf(venta.getImporte());
				descuentoTotal += Double.valueOf(venta.getDescuento());
				igvTotal += Double.valueOf(venta.getIgv());
				totalTotal += Double.valueOf(venta.getTotal());
			}

		}

		Object[] fila = new Object[13];

		fila[0] = "";
		fila[1] = "";
		fila[2] = "";
		fila[3] = "";
		fila[4] = "";
		fila[5] = "";
		fila[6] = "";
		fila[7] = "TOTA GENERAL: ";
		fila[8] = Math.round(importeTotal * 100.0) / 100.0;
		fila[9] = Math.round(descuentoTotal * 100.0) / 100.0;
		fila[10] = Math.round(igvTotal * 100.0) / 100.0;
		fila[11] = Math.round(totalTotal * 100.0) / 100.0;
		fila[12] = "";
		model.addRow(fila);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAnuladas) {
			actionPerformedBtnAnuladas(e);
		}
		if (e.getSource() == btnRealizadas) {
			actionPerformedBtnRealizadas(e);
		}
		if (e.getSource() == btnTodo) {
			actionPerformedBtnTodo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnTodo(ActionEvent e) {
		cargarDatos();
	}

	protected void actionPerformedBtnRealizadas(ActionEvent e) {
		cargarDatosRealizadas();
	}

	protected void actionPerformedBtnAnuladas(ActionEvent e) {
		cargarDatosAnulados();
	}
}
