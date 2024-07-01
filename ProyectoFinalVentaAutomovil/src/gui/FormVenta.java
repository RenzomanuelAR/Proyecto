package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Automovil;
import model.Cliente;
import model.Venta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.awt.event.ActionEvent;

public class FormVenta extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblCodigo;
	private JTextField textCodigoCliente;
	private JButton btnBuscar;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JTextField textNombre;
	private JLabel lblNewLabel;
	private JTextField textApellido;
	private JTextField textDni;
	private JLabel lblDireccion;
	private JTextField textDireccion;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textTelefono;
	private JTextField textEmail;
	private JCheckBox chkHabilitado;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textCodigoAutomovil;
	private JTextField textAnioFabricacion;
	private JLabel lblNewLabel_7;
	private JLabel lblColor;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JCheckBox chkEsAutomatico;
	private JCheckBox chkEstado;
	private JLabel lblPrecio;
	private JLabel lblNewLabel_10;
	private JTextField textPrecio;
	private JTextField textStockActual;
	private JButton btnBuscarAut;
	private JPanel panel_2;
	private JLabel lblNewLabel_11;
	private JTextField textCantidad;
	private JTextField textDescuento;
	private JTextField textImporte;
	private JTextField textImporteDescuento;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JTextField textIgv;
	private JLabel lblNewLabel_16;
	private JTextField textTotal;
	private JButton btnProcesar;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnAnular;
	private JPanel panel_3;
	private JLabel lblNewLabel_17;
	private JTextField textCodigoVenta;
	private JLabel lblNewLabel_18;
	private JTextField textFecha;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textPaisFabricacion;
	private JTextField textColor;
	private JTextField textCantidadAsientos;
	private JTextField textTipoCombustible;
	private JCheckBox chkAnulado;

	Map<String, List<String>> marcaModeloMap;
	DefaultTableModel model = new DefaultTableModel();
	boolean isNuevo = true;
	boolean isProcesado = false;
	int cantidadAnterior = 0;
	int codigoAutomovilAnterior = 0;
	private JButton btnImprimir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormVenta frame = new FormVenta();
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
	public FormVenta() {
		setTitle("Registro de Ventas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 795, 720);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Datos Cliente:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 64, 759, 116);
		contentPane.add(panel);

		lblCodigo = new JLabel("Código Cliente:");
		lblCodigo.setBounds(10, 24, 89, 14);
		panel.add(lblCodigo);

		textCodigoCliente = new JTextField();
		textCodigoCliente.setEnabled(false);
		textCodigoCliente.setColumns(10);
		textCodigoCliente.setBounds(121, 21, 86, 20);
		panel.add(textCodigoCliente);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(217, 20, 79, 23);
		panel.add(btnBuscar);

		lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 52, 81, 14);
		panel.add(lblNombres);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 80, 81, 14);
		panel.add(lblApellidos);

		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setColumns(10);
		textNombre.setBounds(121, 49, 172, 20);
		panel.add(textNombre);

		lblNewLabel = new JLabel("DNI:");
		lblNewLabel.setBounds(311, 52, 66, 14);
		panel.add(lblNewLabel);

		textApellido = new JTextField();
		textApellido.setEnabled(false);
		textApellido.setColumns(10);
		textApellido.setBounds(121, 77, 172, 20);
		panel.add(textApellido);

		textDni = new JTextField();
		textDni.setEnabled(false);
		textDni.setColumns(10);
		textDni.setBounds(422, 49, 121, 20);
		panel.add(textDni);

		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(311, 24, 86, 14);
		panel.add(lblDireccion);

		textDireccion = new JTextField();
		textDireccion.setEnabled(false);
		textDireccion.setColumns(10);
		textDireccion.setBounds(422, 21, 172, 20);
		panel.add(textDireccion);

		lblNewLabel_1 = new JLabel("Teléfono:");
		lblNewLabel_1.setBounds(311, 80, 66, 14);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("E-Mail:");
		lblNewLabel_2.setBounds(573, 80, 57, 14);
		panel.add(lblNewLabel_2);

		textTelefono = new JTextField();
		textTelefono.setEnabled(false);
		textTelefono.setColumns(10);
		textTelefono.setBounds(422, 77, 121, 20);
		panel.add(textTelefono);

		textEmail = new JTextField();
		textEmail.setEnabled(false);
		textEmail.setColumns(10);
		textEmail.setBounds(628, 74, 121, 20);
		panel.add(textEmail);

		chkHabilitado = new JCheckBox("Habilitado");
		chkHabilitado.setEnabled(false);
		chkHabilitado.setBounds(628, 20, 97, 23);
		panel.add(chkHabilitado);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Datos Automovil:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 191, 759, 193);
		contentPane.add(panel_1);

		lblNewLabel_3 = new JLabel("Código Automivil:");
		lblNewLabel_3.setBounds(10, 28, 128, 14);
		panel_1.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Marca:");
		lblNewLabel_4.setBounds(10, 57, 128, 14);
		panel_1.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Modelo:");
		lblNewLabel_5.setBounds(10, 90, 128, 14);
		panel_1.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Año Fabricación:");
		lblNewLabel_6.setBounds(10, 122, 128, 14);
		panel_1.add(lblNewLabel_6);

		textCodigoAutomovil = new JTextField();
		textCodigoAutomovil.setEnabled(false);
		textCodigoAutomovil.setColumns(10);
		textCodigoAutomovil.setBounds(121, 28, 86, 20);
		panel_1.add(textCodigoAutomovil);

		textAnioFabricacion = new JTextField();
		textAnioFabricacion.setEnabled(false);
		textAnioFabricacion.setColumns(10);
		textAnioFabricacion.setBounds(121, 122, 86, 20);
		panel_1.add(textAnioFabricacion);

		lblNewLabel_7 = new JLabel("País Fabricación:");
		lblNewLabel_7.setBounds(10, 154, 128, 14);
		panel_1.add(lblNewLabel_7);

		lblColor = new JLabel("Color:");
		lblColor.setBounds(311, 28, 128, 14);
		panel_1.add(lblColor);

		lblNewLabel_8 = new JLabel("Cantidad Asientos:");
		lblNewLabel_8.setBounds(311, 57, 128, 14);
		panel_1.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("Tipo Cumbustible:");
		lblNewLabel_9.setBounds(311, 90, 128, 14);
		panel_1.add(lblNewLabel_9);

		chkEsAutomatico = new JCheckBox("Automático");
		chkEsAutomatico.setEnabled(false);
		chkEsAutomatico.setBounds(634, 24, 97, 23);
		panel_1.add(chkEsAutomatico);

		chkEstado = new JCheckBox("Habilitado");
		chkEstado.setEnabled(false);
		chkEstado.setBounds(634, 53, 97, 23);
		panel_1.add(chkEstado);

		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(311, 122, 128, 14);
		panel_1.add(lblPrecio);

		lblNewLabel_10 = new JLabel("Unid. Disponibles:");
		lblNewLabel_10.setBounds(311, 157, 128, 14);
		panel_1.add(lblNewLabel_10);

		textPrecio = new JTextField();
		textPrecio.setEnabled(false);
		textPrecio.setColumns(10);
		textPrecio.setBounds(422, 119, 121, 20);
		panel_1.add(textPrecio);

		textStockActual = new JTextField();
		textStockActual.setEnabled(false);
		textStockActual.setColumns(10);
		textStockActual.setBounds(422, 154, 121, 20);
		panel_1.add(textStockActual);

		btnBuscarAut = new JButton("Buscar");
		btnBuscarAut.setEnabled(false);
		btnBuscarAut.addActionListener(this);
		btnBuscarAut.setBounds(217, 27, 79, 23);
		panel_1.add(btnBuscarAut);

		textMarca = new JTextField();
		textMarca.setEnabled(false);
		textMarca.setColumns(10);
		textMarca.setBounds(120, 57, 172, 20);
		panel_1.add(textMarca);

		textModelo = new JTextField();
		textModelo.setEnabled(false);
		textModelo.setColumns(10);
		textModelo.setBounds(121, 90, 172, 20);
		panel_1.add(textModelo);

		textPaisFabricacion = new JTextField();
		textPaisFabricacion.setEnabled(false);
		textPaisFabricacion.setColumns(10);
		textPaisFabricacion.setBounds(121, 154, 172, 20);
		panel_1.add(textPaisFabricacion);

		textColor = new JTextField();
		textColor.setEnabled(false);
		textColor.setColumns(10);
		textColor.setBounds(421, 25, 172, 20);
		panel_1.add(textColor);

		textCantidadAsientos = new JTextField();
		textCantidadAsientos.setEnabled(false);
		textCantidadAsientos.setColumns(10);
		textCantidadAsientos.setBounds(422, 57, 172, 20);
		panel_1.add(textCantidadAsientos);

		textTipoCombustible = new JTextField();
		textTipoCombustible.setEnabled(false);
		textTipoCombustible.setColumns(10);
		textTipoCombustible.setBounds(422, 90, 172, 20);
		panel_1.add(textTipoCombustible);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Detalle Venta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 395, 552, 121);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel_11 = new JLabel("Cantidad:");
		lblNewLabel_11.setBounds(10, 26, 101, 14);
		panel_2.add(lblNewLabel_11);

		textCantidad = new JTextField();
		textCantidad.setEnabled(false);
		textCantidad.setColumns(10);
		textCantidad.setBounds(121, 23, 86, 20);
		panel_2.add(textCantidad);

		textDescuento = new JTextField();
		textDescuento.setEnabled(false);
		textDescuento.setColumns(10);
		textDescuento.setBounds(121, 84, 86, 20);
		panel_2.add(textDescuento);

		textImporte = new JTextField();
		textImporte.setEnabled(false);
		textImporte.setColumns(10);
		textImporte.setBounds(121, 53, 86, 20);
		panel_2.add(textImporte);

		textImporteDescuento = new JTextField();
		textImporteDescuento.setEnabled(false);
		textImporteDescuento.setColumns(10);
		textImporteDescuento.setBounds(344, 23, 86, 20);
		panel_2.add(textImporteDescuento);

		lblNewLabel_12 = new JLabel("Importe Bruto:");
		lblNewLabel_12.setBounds(10, 53, 101, 14);
		panel_2.add(lblNewLabel_12);

		lblNewLabel_13 = new JLabel("Imp. Descuento:");
		lblNewLabel_13.setBounds(10, 87, 101, 14);
		panel_2.add(lblNewLabel_13);

		lblNewLabel_14 = new JLabel("Imp. Bruto - Desc.:");
		lblNewLabel_14.setBounds(232, 26, 101, 14);
		panel_2.add(lblNewLabel_14);

		lblNewLabel_15 = new JLabel("IGV:");
		lblNewLabel_15.setBounds(232, 54, 101, 14);
		panel_2.add(lblNewLabel_15);

		textIgv = new JTextField();
		textIgv.setEnabled(false);
		textIgv.setColumns(10);
		textIgv.setBounds(344, 51, 86, 20);
		panel_2.add(textIgv);

		lblNewLabel_16 = new JLabel("Total General:");
		lblNewLabel_16.setBounds(232, 87, 101, 14);
		panel_2.add(lblNewLabel_16);

		textTotal = new JTextField();
		textTotal.setEnabled(false);
		textTotal.setColumns(10);
		textTotal.setBounds(344, 84, 86, 20);
		panel_2.add(textTotal);

		btnProcesar = new JButton("Calcular");
		btnProcesar.addActionListener(this);
		btnProcesar.setEnabled(false);
		btnProcesar.setBounds(440, 23, 91, 81);
		panel_2.add(btnProcesar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(572, 402, 92, 35);
		contentPane.add(btnNuevo);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(662, 402, 92, 35);
		contentPane.add(btnEditar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(572, 438, 92, 36);
		contentPane.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(662, 438, 92, 36);
		contentPane.add(btnCancelar);

		btnAnular = new JButton("Anular");
		btnAnular.addActionListener(this);
		btnAnular.setBounds(572, 473, 92, 36);
		contentPane.add(btnAnular);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 11, 759, 42);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		lblNewLabel_17 = new JLabel("Nº Venta:");
		lblNewLabel_17.setBounds(10, 14, 101, 14);
		panel_3.add(lblNewLabel_17);

		textCodigoVenta = new JTextField();
		textCodigoVenta.setEnabled(false);
		textCodigoVenta.setColumns(10);
		textCodigoVenta.setBounds(83, 11, 86, 20);
		panel_3.add(textCodigoVenta);

		lblNewLabel_18 = new JLabel("Fecha Venta:");
		lblNewLabel_18.setBounds(192, 14, 101, 14);
		panel_3.add(lblNewLabel_18);

		textFecha = new JTextField();
		textFecha.setEnabled(false);
		textFecha.setColumns(10);
		textFecha.setBounds(278, 11, 86, 20);
		panel_3.add(textFecha);

		chkAnulado = new JCheckBox("Anulado");
		chkAnulado.setEnabled(false);
		chkAnulado.setBounds(396, 10, 97, 23);
		panel_3.add(chkAnulado);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 527, 759, 143);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		// Agregar ListSelectionListener para detectar selección de filas
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) { // Para evitar que se procese dos veces el evento
					mostrarValores();
				}
			}
		});

		model.addColumn("Código");
		model.addColumn("Cliente");
		model.addColumn("Automovil");
		model.addColumn("Fecha");
		model.addColumn("Precio");
		model.addColumn("Cantidad");
		model.addColumn("Subtotal");
		model.addColumn("Descuento");
		model.addColumn("IGV");
		model.addColumn("Total");
		model.addColumn("Anulado");
		table.setModel(model);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(this);
		btnImprimir.setBounds(662, 473, 92, 36);
		contentPane.add(btnImprimir);
		
		//formato de celdas clase VentasRenderer()
		table.setDefaultRenderer(Object.class, new VentasRenderer());
		cargarDatos();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnImprimir) {
			actionPerformedBtnImprimir(e);
		}
		if (e.getSource() == btnAnular) {
			actionPerformedBtnAnular(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
		if (e.getSource() == btnBuscarAut) {
			actionPerformedBtnBuscarAut(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		if (textCodigoCliente.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Ingrese un Código de Cliente.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			textCodigoCliente.grabFocus();
			return;
		}

		if (!MenuPrincipal.isNumero(textCodigoCliente.getText().trim())) {
			JOptionPane.showMessageDialog(null, "Código de Cliente inválido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCodigoCliente.grabFocus();
			return;
		}

		int codigo = Integer.parseInt(textCodigoCliente.getText());

		if (Objects.isNull(MenuPrincipal.listClientes.busqueda(codigo))) {
			JOptionPane.showMessageDialog(null, "No existe el Código de Cliente.", "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
			textCodigoCliente.grabFocus();
			return;
		}

		// buscar cliente
		llenarFormularioCliente(MenuPrincipal.listClientes.busqueda(codigo));
	}

	protected void actionPerformedBtnBuscarAut(ActionEvent e) {
		if (textCodigoAutomovil.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Ingrese un Código de Automovil.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			textCodigoAutomovil.grabFocus();
			return;
		}

		if (!MenuPrincipal.isNumero(textCodigoAutomovil.getText().trim())) {
			JOptionPane.showMessageDialog(null, "Código de Automovil inválido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCodigoAutomovil.grabFocus();
			return;
		}

		int codigo = Integer.parseInt(textCodigoAutomovil.getText());

		if (Objects.isNull(MenuPrincipal.listAutomoviles.busqueda(codigo))) {
			JOptionPane.showMessageDialog(null, "No existe el Código de Automovil.", "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
			textCodigoAutomovil.grabFocus();
			return;
		}

		// buscar Automovil
		llenarFormularioAutomovil(MenuPrincipal.listAutomoviles.busqueda(codigo));
	}

	protected void actionPerformedBtnProcesar(ActionEvent e) {
		if (textPrecio.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe ingresar los datos del automovil", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			textCodigoAutomovil.grabFocus();
			return;
		}

		if (textCantidad.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad válida.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			textCantidad.grabFocus();
			return;
		}

		if (!MenuPrincipal.isNumero(textCantidad.getText().trim())) {
			JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad válida.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCantidad.grabFocus();
			return;
		}

		int cantidad = Integer.parseInt(textCantidad.getText());
		if (cantidad <= 0) {
			JOptionPane.showMessageDialog(null, "Venta mínima es 01 unidad.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCantidad.grabFocus();
			return;
		}

		Venta ventaTemp = new Venta();
		;
		int codVenta = Integer.parseInt(textCodigoVenta.getText());
		int codCliente = Integer.parseInt(textCodigoCliente.getText());
		int codAutomovil = Integer.parseInt(textCodigoAutomovil.getText());
		double precio = Double.parseDouble(textPrecio.getText());

		ventaTemp.setCodigoVenta(codVenta);
		ventaTemp.setCodigoCliente(codCliente);
		ventaTemp.setCodigoAutomovil(codAutomovil);
		ventaTemp.setCantidad(cantidad);
		ventaTemp.setPrecio(precio);
		ventaTemp.setAnulado(chkAnulado.isSelected());

		textImporte.setText((Math.round(ventaTemp.getImporte() * 100.0) / 100.0) + "");
		textDescuento.setText((Math.round(ventaTemp.getDescuento()  * 100.0) / 100.0) + "");
		textImporteDescuento.setText((Math.round(ventaTemp.getImporteMenosDescuento() * 100.0) / 100.0)  + "");
		textIgv.setText((Math.round(ventaTemp.getIgv() * 100.0) / 100.0)  + "");
		textTotal.setText((Math.round(ventaTemp.getTotal() * 100.0) / 100.0)  + "");

		isProcesado = true;
	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		int codigoVenta = 0;
		habilitarControles(true);
		habilitarBotonos(true);
		limpiar();
		isNuevo = true;
		isProcesado = false;
		codigoAutomovilAnterior = 0;
		cantidadAnterior = 0;
		// generar codigo temporal
		if (MenuPrincipal.listVentas.tamanio() == 0) {
			codigoVenta = MenuPrincipal.INICODIGOVENTA;
		} else {
			// se suma 1 al ultimo codigo generado
			codigoVenta = MenuPrincipal.listVentas.ultimo() + 1;
		}
		textCodigoVenta.setText(codigoVenta + "");
	}

	protected void actionPerformedBtnEditar(ActionEvent e) {
		if (textCodigoVenta.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "No hay ningun registro seleccionado.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		habilitarControles(true);
		habilitarBotonos(true);
		isNuevo = false;
		isProcesado = false;
		codigoAutomovilAnterior = Integer.parseInt(textCodigoAutomovil.getText());
		cantidadAnterior = Integer.parseInt(textCantidad.getText());
	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {
		// validaciones de fecha
		if (textFecha.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "La fecha es un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textFecha.grabFocus();
			return;
		}

		String fecha = textFecha.getText().trim();
		if (fecha.length() != 10) {
			JOptionPane.showMessageDialog(null, "Ingrese una fecha válida.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textFecha.grabFocus();
			return;
		}
		
		if (!MenuPrincipal.validarFecha2(fecha)) {
			JOptionPane.showMessageDialog(null, "Ingrese una fecha válida.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textFecha.grabFocus();
			return;
		}		

		// validaciones datos del cliente
		if (textCodigoCliente.getText().trim().equals("") || textApellido.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Los datos del cliente son requeridos.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCodigoCliente.grabFocus();
			return;
		}

		int codigoCliente = Integer.parseInt(textCodigoCliente.getText().trim());
		Cliente cliente = MenuPrincipal.listClientes.busqueda(codigoCliente);
		if (Objects.isNull(cliente)) {
			JOptionPane.showMessageDialog(null, "Datos del cliente es inválido", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCodigoCliente.grabFocus();
			return;
		}

		if (!cliente.isEstado()) {
			JOptionPane.showMessageDialog(null, "El cliente seleccionado esta inhabilitado.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCodigoCliente.grabFocus();
			return;
		}

		// validaciones datos del automovil
		if (textCodigoAutomovil.getText().trim().equals("") || textMarca.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Los datos del automovil son requeridos.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCodigoAutomovil.grabFocus();
			return;
		}

		int codigoAutomovil = Integer.parseInt(textCodigoAutomovil.getText().trim());
		Automovil automovil = MenuPrincipal.listAutomoviles.busqueda(codigoAutomovil);
		if (Objects.isNull(automovil)) {
			JOptionPane.showMessageDialog(null, "Datos del automovil es inválido", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCodigoAutomovil.grabFocus();
			return;
		}

		if (!automovil.isEstado()) {
			JOptionPane.showMessageDialog(null, "El automovil seleccionado esta inhabilitado para la venta.",
					"Mensaje de validación", JOptionPane.ERROR_MESSAGE);
			textCodigoAutomovil.grabFocus();
			return;
		}

		if (automovil.getStockActual() == 0) {
			JOptionPane.showMessageDialog(null, "No hay unidades disponibles para la venta", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCodigoAutomovil.grabFocus();
			return;
		}

		// validaciones cantidad

		if (textCantidad.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "La cantidad es un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCantidad.grabFocus();
			return;
		}

		if (!MenuPrincipal.isNumero(textCantidad.getText().trim())) {
			JOptionPane.showMessageDialog(null, "La cantidad ingresada debe ser un dato númerico",
					"Mensaje de validación", JOptionPane.ERROR_MESSAGE);
			textCantidad.grabFocus();
			return;
		}

		int cantidad = Integer.parseInt(textCantidad.getText().trim());
		int stockActual = Integer.parseInt(textStockActual.getText().trim());

		if (cantidad > stockActual) {
			JOptionPane.showMessageDialog(null,
					"La cantidad ingresada debe ser igual menor a las unidades disponibles.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCantidad.grabFocus();
			return;
		}

		habilitarControles(false);
		habilitarBotonos(false);

		Venta venta = new Venta();

		int codVenta = Integer.parseInt(textCodigoVenta.getText());
		int codCliente = Integer.parseInt(textCodigoCliente.getText());
		int codAutomovil = Integer.parseInt(textCodigoAutomovil.getText());
		double precio = Double.parseDouble(textPrecio.getText());

		venta.setCodigoVenta(codVenta);
		venta.setCodigoCliente(codCliente);
		venta.setCodigoAutomovil(codAutomovil);
		venta.setCantidad(cantidad);
		venta.setPrecio(precio);
		venta.setAnulado(chkAnulado.isSelected());
		venta.setFecha(fecha);

		if (isNuevo) {
			// Guardar nuevo
			MenuPrincipal.listVentas.agregar(venta);
		} else {
			// guardar edicion de registro
			//actualizar stock actual (sumar)
			MenuPrincipal.listAutomoviles.actualizarStockActual(codigoAutomovilAnterior, cantidadAnterior, false);
			MenuPrincipal.listVentas.actualizar(venta);
		}
		//actualizar stock actual (restar)
		MenuPrincipal.listAutomoviles.actualizarStockActual(codAutomovil, cantidad, true);
		
		cargarDatos();
		
		codigoAutomovilAnterior = 0;
		cantidadAnterior = 0;
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		habilitarControles(false);
		habilitarBotonos(false);
		if (isNuevo)
			textCodigoVenta.setText("");
	}

	protected void actionPerformedBtnAnular(ActionEvent e) {
		if (textCodigoVenta.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "No hay ningun registro seleccionado.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//anular venta
		int codigoVenta = Integer.parseInt(textCodigoVenta.getText());
		MenuPrincipal.listVentas.anular(MenuPrincipal.listVentas.busqueda(codigoVenta));
		

		//actualizar stock actual (sumar)
		int codAutomovil = Integer.parseInt(textCodigoAutomovil.getText());
		int cantidad = Integer.parseInt(textCantidad.getText().trim());
		MenuPrincipal.listAutomoviles.actualizarStockActual(codAutomovil, cantidad, false);
		chkAnulado.setSelected(true);
		cargarDatos();
	}

	private void habilitarControles(boolean estado) {
		textCodigoCliente.setEnabled(estado);
		textCodigoAutomovil.setEnabled(estado);
		textCantidad.setEnabled(estado);
		textFecha.setEnabled(estado);
	}

	private void habilitarBotonos(boolean estado) {
		btnBuscar.setEnabled(estado);
		btnBuscarAut.setEnabled(estado);
		btnProcesar.setEnabled(estado);
		btnNuevo.setEnabled(!estado);
		btnEditar.setEnabled(!estado);
		btnGuardar.setEnabled(estado);
		btnCancelar.setEnabled(estado);
		btnAnular.setEnabled(!estado);
	}

	private void limpiar() {
		textCantidad.setText("");
		textFecha.setText("");
		textCantidad.setText("");
		chkAnulado.setSelected(false);
		textImporte.setText("");
		textDescuento.setText("");
		textImporteDescuento.setText("");
		textIgv.setText("");
		textTotal.setText("");
		limpiarCliente();
		limpiarAutomovil();
	}

	private void limpiarAutomovil() {
		// carga por defecto
		textCodigoAutomovil.setText("");
		textMarca.setText("");
		textModelo.setText("");
		textAnioFabricacion.setText("");
		textPaisFabricacion.setText("");
		textColor.setText("");
		chkEsAutomatico.setSelected(false);
		textPrecio.setText("");
		textCantidadAsientos.setText("");
		textTipoCombustible.setText("");
		textStockActual.setText("");
		chkEstado.setSelected(true);
	}

	private void limpiarCliente() {
		textApellido.setText("");
		textNombre.setText("");
		textCodigoCliente.setText("");
		textDni.setText("");
		textEmail.setText("");
		textTelefono.setText("");
		textDireccion.setText("");
		chkHabilitado.setSelected(true);
	}

	// metodos privados
	private void cargarDatos() {
		model.setRowCount(0);

		for (Venta venta : MenuPrincipal.listVentas.getListVentas()) {
			Object[] fila = new Object[11];
			Cliente cliente = MenuPrincipal.listClientes.busqueda(venta.getCodigoCliente());
			Automovil automovil = MenuPrincipal.listAutomoviles.busqueda(venta.getCodigoAutomovil());
			fila[0] = venta.getCodigoVenta();
			fila[1] = cliente.getNombres() + " " + cliente.getApellidos();
			fila[2] = automovil.getMarca() + " - " + automovil.getModelo();
			fila[3] = venta.getFecha();
			fila[4] = Math.round(venta.getPrecio() * 100.0) / 100.0;
			fila[5] = venta.getCantidad();
			fila[6] = Math.round(venta.getImporte() * 100.0) / 100.0;
			fila[7] = Math.round(venta.getDescuento() * 100.0) / 100.0;
			fila[8] = Math.round(venta.getIgv() * 100.0) / 100.0;
			fila[9] = Math.round(venta.getTotal() * 100.0) / 100.0;
			fila[10] = venta.isAnulado();
			model.addRow(fila);
			

		}


	}

	private void mostrarValores() {
		int filaSeleccionada = table.getSelectedRow();
		if (filaSeleccionada != -1) { // Si hay una fila seleccionada
			String codigoString = String.valueOf(table.getValueAt(filaSeleccionada, 0));
			int codigo = Integer.parseInt(codigoString);
			llenarFormulario(MenuPrincipal.listVentas.busqueda(codigo));
		}
	}

	private void llenarFormulario(Venta venta) {
		Cliente cliente = MenuPrincipal.listClientes.busqueda(venta.getCodigoCliente());
		Automovil automovil = MenuPrincipal.listAutomoviles.busqueda(venta.getCodigoAutomovil());
		llenarFormularioCliente(cliente);
		llenarFormularioAutomovil(automovil);

		textCodigoVenta.setText(venta.getCodigoVenta() + "");
		textCodigoCliente.setText(venta.getCodigoCliente() + "");
		textCodigoAutomovil.setText(venta.getCodigoAutomovil() + "");
		textCantidad.setText(venta.getCantidad() + "");
		textPrecio.setText(venta.getPrecio() + "");
		chkAnulado.setSelected(venta.isAnulado());
		textFecha.setText(venta.getFecha());
		textImporte.setText(venta.getImporte() + "");
		textDescuento.setText(venta.getDescuento() + "");
		textImporteDescuento.setText(venta.getImporteMenosDescuento() + "");
		textIgv.setText(venta.getIgv() + "");
		textTotal.setText(venta.getTotal() + "");

	}

	private void llenarFormularioAutomovil(Automovil automovil) {
		textCodigoAutomovil.setText(automovil.getCodigoAutomovil() + "");
		textMarca.setText(automovil.getMarca());
		textModelo.setText(automovil.getModelo());
		textAnioFabricacion.setText(automovil.getAnioFabricacion());
		textPaisFabricacion.setText(automovil.getPais());
		textColor.setText(automovil.getColor());
		chkEsAutomatico.setSelected(automovil.isEsAutomatico());
		textPrecio.setText(automovil.getPrecio() + "");
		textCantidadAsientos.setText(automovil.getCantidadAsientos());
		textTipoCombustible.setText(automovil.getTipoCombustible());
		textStockActual.setText(automovil.getStockActual() + "");
		chkEstado.setSelected(automovil.isEstado());
	}

	private void llenarFormularioCliente(Cliente cliente) {
		textApellido.setText(cliente.getApellidos());
		textNombre.setText(cliente.getNombres());
		textCodigoCliente.setText(cliente.getCodigoCliente() + "");
		textDni.setText(cliente.getDni());
		textEmail.setText(cliente.getEmail());
		textTelefono.setText(cliente.getTelefono());
		textDireccion.setText(cliente.getDireccion());
		chkHabilitado.setSelected(cliente.isEstado());
	}

	protected void actionPerformedBtnImprimir(ActionEvent e) {
		if (textCodigoVenta.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "No hay ningún registro seleccionado.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		MenuPrincipal.NUMVENTA = Integer.parseInt(textCodigoVenta.getText());
        // Crear instancia del formulario modal y mostrarlo
		FormImprimir dialogForm = new FormImprimir(this);
        dialogForm.setVisible(true);

	}
}
