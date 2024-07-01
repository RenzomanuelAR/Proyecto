package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Almacen;
import model.Automovil;
import model.Cliente;
import model.Almacen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class FormAlmacen extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textCodigoAlmacen;
	private JLabel lblNewLabel_1;
	private JTextField textfechaRegistro;
	private JCheckBox chkAnulado;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textCodigoAutomovil;
	private JTextField textAnioFabricacion;
	private JLabel lblNewLabel_6;
	private JLabel lblColor;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JCheckBox chkEsAutomatico;
	private JCheckBox chkEstado;
	private JLabel lblPrecio;
	private JLabel lblNewLabel_9;
	private JTextField textPrecio;
	private JTextField textStockActual;
	private JButton btnBuscarAut;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textPaisFabricacion;
	private JTextField textColor;
	private JTextField textCantidadAsientos;
	private JTextField textTipoCombustible;
	private JLabel lblStockMn;
	private JLabel lblNewLabel_10;
	private JTextField textStockMaximo;
	private JTextField textStockMinimo;
	private JPanel panel_2;
	private JLabel lblNewLabel_11;
	private JTextField textCantidadIngreso;
	private JTextField textNombreUsuario;
	private JLabel lblNewLabel_14;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnAnular;
	private JScrollPane scrollPane;

	DefaultTableModel model = new DefaultTableModel();
	boolean isNuevo = true;
	boolean isProcesado = false;
	int cantidadAnterior = 0;
	int codigoAutomovilAnterior = 0;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAlmacen frame = new FormAlmacen();
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
	public FormAlmacen() {
		setTitle("Registro de ingreso de Atomóviles");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 792, 591);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 759, 42);
		contentPane.add(panel);
		
		lblNewLabel = new JLabel("Nº Ingreso:");
		lblNewLabel.setBounds(10, 14, 101, 14);
		panel.add(lblNewLabel);
		
		textCodigoAlmacen = new JTextField();
		textCodigoAlmacen.setEnabled(false);
		textCodigoAlmacen.setColumns(10);
		textCodigoAlmacen.setBounds(83, 11, 86, 20);
		panel.add(textCodigoAlmacen);
		
		lblNewLabel_1 = new JLabel("Fecha Ingreso:");
		lblNewLabel_1.setBounds(192, 14, 101, 14);
		panel.add(lblNewLabel_1);
		
		textfechaRegistro = new JTextField();
		textfechaRegistro.setEnabled(false);
		textfechaRegistro.setColumns(10);
		textfechaRegistro.setBounds(278, 11, 86, 20);
		panel.add(textfechaRegistro);
		
		chkAnulado = new JCheckBox("Anulado");
		chkAnulado.setEnabled(false);
		chkAnulado.setBounds(396, 10, 97, 23);
		panel.add(chkAnulado);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(
						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
						"Datos Automovil:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 61, 759, 193);
		contentPane.add(panel_1);
		
		lblNewLabel_2 = new JLabel("Código Automivil:");
		lblNewLabel_2.setBounds(10, 28, 128, 14);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Marca:");
		lblNewLabel_3.setBounds(10, 57, 128, 14);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Modelo:");
		lblNewLabel_4.setBounds(10, 90, 128, 14);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Año Fabricación:");
		lblNewLabel_5.setBounds(10, 122, 128, 14);
		panel_1.add(lblNewLabel_5);
		
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
		
		lblNewLabel_6 = new JLabel("País Fabricación:");
		lblNewLabel_6.setBounds(10, 154, 128, 14);
		panel_1.add(lblNewLabel_6);
		
		lblColor = new JLabel("Color:");
		lblColor.setBounds(311, 28, 128, 14);
		panel_1.add(lblColor);
		
		lblNewLabel_7 = new JLabel("Cantidad Asientos:");
		lblNewLabel_7.setBounds(311, 57, 128, 14);
		panel_1.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Tipo Cumbustible:");
		lblNewLabel_8.setBounds(311, 90, 128, 14);
		panel_1.add(lblNewLabel_8);
		
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
		
		lblNewLabel_9 = new JLabel("Stock Actual:");
		lblNewLabel_9.setBounds(311, 157, 128, 14);
		panel_1.add(lblNewLabel_9);
		
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
		btnBuscarAut.addActionListener(this);
		btnBuscarAut.setEnabled(false);
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
		
		lblStockMn = new JLabel("Stock Mín.:");
		lblStockMn.setBounds(559, 122, 86, 14);
		panel_1.add(lblStockMn);
		
		lblNewLabel_10 = new JLabel("Stock Máx.:");
		lblNewLabel_10.setBounds(559, 157, 92, 14);
		panel_1.add(lblNewLabel_10);
		
		textStockMaximo = new JTextField();
		textStockMaximo.setEnabled(false);
		textStockMaximo.setColumns(10);
		textStockMaximo.setBounds(628, 154, 121, 20);
		panel_1.add(textStockMaximo);
		
		textStockMinimo = new JTextField();
		textStockMinimo.setEnabled(false);
		textStockMinimo.setColumns(10);
		textStockMinimo.setBounds(628, 119, 121, 20);
		panel_1.add(textStockMinimo);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Detalle Ingreso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 265, 462, 87);
		contentPane.add(panel_2);
		
		lblNewLabel_11 = new JLabel("Cant. Ingreso:");
		lblNewLabel_11.setBounds(10, 26, 101, 14);
		panel_2.add(lblNewLabel_11);
		
		textCantidadIngreso = new JTextField();
		textCantidadIngreso.setEnabled(false);
		textCantidadIngreso.setColumns(10);
		textCantidadIngreso.setBounds(121, 23, 86, 20);
		panel_2.add(textCantidadIngreso);
		
		textNombreUsuario = new JTextField();
		textNombreUsuario.setEnabled(false);
		textNombreUsuario.setColumns(10);
		textNombreUsuario.setBounds(121, 54, 198, 20);
		panel_2.add(textNombreUsuario);
		
		lblNewLabel_14 = new JLabel("Usuario Registro:");
		lblNewLabel_14.setBounds(10, 57, 101, 14);
		panel_2.add(lblNewLabel_14);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(482, 271, 88, 35);
		contentPane.add(btnNuevo);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(580, 271, 88, 35);
		contentPane.add(btnEditar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(482, 317, 186, 35);
		contentPane.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(678, 270, 88, 36);
		contentPane.add(btnCancelar);
		
		btnAnular = new JButton("Anular");
		btnAnular.addActionListener(this);
		btnAnular.setBounds(678, 316, 88, 36);
		contentPane.add(btnAnular);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 363, 759, 177);
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
		model.addColumn("Automovil");
		model.addColumn("Fecha");
		model.addColumn("Cantidad");
		model.addColumn("Usuario Reg.");
		model.addColumn("Anulado");
		table.setModel(model);
		cargarDatos();
		
		textNombreUsuario.setText(MenuPrincipal.USUARIOLOGIN);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarAut) {
			actionPerformedBtnBuscarAut(e);
		}
		if (e.getSource() == btnAnular) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
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

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		int codigoAlmacen = 0;
		habilitarControles(true);
		habilitarBotonos(true);
		limpiar();
		isNuevo = true;
		isProcesado = false;
		codigoAutomovilAnterior = 0;
		cantidadAnterior = 0;
		
		// generar codigo temporal
		if (MenuPrincipal.listAlmacenes.tamanio() == 0) {
			codigoAlmacen = MenuPrincipal.INICODIGOALMACEN;
		} else {
			// se suma 1 al ultimo codigo generado
			codigoAlmacen = MenuPrincipal.listAlmacenes.ultimo() + 1;
		}
		textCodigoAlmacen.setText(codigoAlmacen + "");
	}

	protected void actionPerformedBtnEditar(ActionEvent e) {
		if (textCodigoAlmacen.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "No hay ningun registro seleccionado.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		habilitarControles(true);
		habilitarBotonos(true);
		isNuevo = false;
		isProcesado = false;
		codigoAutomovilAnterior = Integer.parseInt(textCodigoAutomovil.getText());
		cantidadAnterior = Integer.parseInt(textCantidadIngreso.getText());
	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {
		// validaciones de fecha
		if (textfechaRegistro.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "La fecha es un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textfechaRegistro.grabFocus();
			return;
		}

		String fecha = textfechaRegistro.getText().trim();
		if (fecha.length() != 10) {
			JOptionPane.showMessageDialog(null, "Ingrese una fecha válida.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textfechaRegistro.grabFocus();
			return;
		}
		
		if (!MenuPrincipal.validarFecha2(fecha)) {
			JOptionPane.showMessageDialog(null, "Ingrese una fecha válida.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textfechaRegistro.grabFocus();
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
			JOptionPane.showMessageDialog(null, "El automovil seleccionado esta inhabilitado para la almacen.",
					"Mensaje de validación", JOptionPane.ERROR_MESSAGE);
			textCodigoAutomovil.grabFocus();
			return;
		}

		if (automovil.getStockActual() == 0) {
			JOptionPane.showMessageDialog(null, "No hay unidades disponibles para la almacen", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCodigoAutomovil.grabFocus();
			return;
		}

		// validaciones cantidad
		if (textCantidadIngreso.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "La cantidad es un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCantidadIngreso.grabFocus();
			return;
		}

		if (!MenuPrincipal.isNumero(textCantidadIngreso.getText().trim())) {
			JOptionPane.showMessageDialog(null, "La cantidad ingresada debe ser un dato númerico",
					"Mensaje de validación", JOptionPane.ERROR_MESSAGE);
			textCantidadIngreso.grabFocus();
			return;
		}

		int cantidad = Integer.parseInt(textCantidadIngreso.getText().trim()) + Integer.parseInt(textStockActual.getText().trim());
		int stockMaximo = Integer.parseInt(textStockMaximo.getText().trim());

		if (cantidad > stockMaximo) {
			JOptionPane.showMessageDialog(null,
					"¡Accion cancelada! Con este ingreso se esta superando el Stock Máximo.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCantidadIngreso.grabFocus();
			return;
		}
		
		// validaciones usuario
		if (textNombreUsuario.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario es un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textNombreUsuario.grabFocus();
			return;
		}

		habilitarControles(false);
		habilitarBotonos(false);

		Almacen almacen = new Almacen();
		cantidad = Integer.parseInt(textCantidadIngreso.getText().trim());
		int codAlmacen = Integer.parseInt(textCodigoAlmacen.getText());
		int codAutomovil = Integer.parseInt(textCodigoAutomovil.getText());

		almacen.setCodigoAlmacen(codAlmacen);
		almacen.setCodigoAutomovil(codAutomovil);
		almacen.setCantidadIngreso(cantidad);
		almacen.setAnulado(chkAnulado.isSelected());
		almacen.setNombreUsuario(textNombreUsuario.getText().trim());
		almacen.setFechaRegistro(fecha);

		if (isNuevo) {
			// Guardar nuevo
			MenuPrincipal.listAlmacenes.agregar(almacen);
		} else {
			// guardar edicion de registro
			//actualizar stock actual (resta)
			MenuPrincipal.listAutomoviles.actualizarStockActual(codigoAutomovilAnterior, cantidadAnterior, true);
			MenuPrincipal.listAlmacenes.actualizar(almacen);
		}
		//actualizar stock actual (suma)
		MenuPrincipal.listAutomoviles.actualizarStockActual(codAutomovil, cantidad, false);
		
		cargarDatos();
		
		codigoAutomovilAnterior = 0;
		cantidadAnterior = 0;
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		habilitarControles(false);
		habilitarBotonos(false);
		if (isNuevo)
			textCodigoAlmacen.setText("");
			limpiar();
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		if (textCodigoAlmacen.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "No hay ningún registro seleccionado.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//anular almacen
		int codigoAlmacen = Integer.parseInt(textCodigoAlmacen.getText());
		MenuPrincipal.listAlmacenes.anular(MenuPrincipal.listAlmacenes.busqueda(codigoAlmacen));
		

		//actualizar stock actual (restar)
		int codAutomovil = Integer.parseInt(textCodigoAutomovil.getText());
		int cantidad = Integer.parseInt(textCantidadIngreso.getText().trim());
		MenuPrincipal.listAutomoviles.actualizarStockActual(codAutomovil, cantidad, true);
		chkAnulado.setSelected(true);
		cargarDatos();
	}

	private void habilitarControles(boolean estado) {
		textCodigoAutomovil.setEnabled(estado);
		textfechaRegistro.setEnabled(estado);
		textCantidadIngreso.setEnabled(estado);
	}

	private void habilitarBotonos(boolean estado) {
		btnBuscarAut.setEnabled(estado);
		btnNuevo.setEnabled(!estado);
		btnEditar.setEnabled(!estado);
		btnGuardar.setEnabled(estado);
		btnCancelar.setEnabled(estado);
		btnAnular.setEnabled(!estado);
	}

	private void limpiar() {
		textCantidadIngreso.setText("");
		textfechaRegistro.setText("");
		textNombreUsuario.setText("");
		chkAnulado.setSelected(false);
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
		textStockMinimo.setText("");
		textStockMaximo.setText("");
		chkEstado.setSelected(true);
	}


	// metodos privados
	private void cargarDatos() {
		model.setRowCount(0);

		for (Almacen almacen : MenuPrincipal.listAlmacenes.getListAlmacenes()) {
			Object[] fila = new Object[6];
			Automovil automovil = MenuPrincipal.listAutomoviles.busqueda(almacen.getCodigoAutomovil());
			fila[0] = almacen.getCodigoAlmacen();
			fila[1] = automovil.getMarca() + " - " + automovil.getModelo();
			fila[2] = almacen.getFechaRegistro();
			fila[3] = almacen.getCantidadIngreso();
			fila[4] = almacen.getNombreUsuario();
			fila[5] = almacen.isAnulado();
			model.addRow(fila);
		}

	}

	private void mostrarValores() {
		int filaSeleccionada = table.getSelectedRow();
		if (filaSeleccionada != -1) { // Si hay una fila seleccionada
			String codigoString = String.valueOf(table.getValueAt(filaSeleccionada, 0));
			int codigo = Integer.parseInt(codigoString);
			llenarFormulario(MenuPrincipal.listAlmacenes.busqueda(codigo));
		}
	}

	private void llenarFormulario(Almacen almacen) {
		Automovil automovil = MenuPrincipal.listAutomoviles.busqueda(almacen.getCodigoAutomovil());
		llenarFormularioAutomovil(automovil);

		textCodigoAlmacen.setText(almacen.getCodigoAlmacen() + "");
		textCodigoAutomovil.setText(almacen.getCodigoAutomovil() + "");
		textCantidadIngreso.setText(almacen.getCantidadIngreso() + "");
		textNombreUsuario.setText(almacen.getNombreUsuario());
		chkAnulado.setSelected(almacen.isAnulado());
		textfechaRegistro.setText(almacen.getFechaRegistro());


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
		textStockMinimo.setText(automovil.getStockMinimo()+"");
		textStockMaximo.setText(automovil.getStockMaximo()+"");
		chkEstado.setSelected(automovil.isEstado());
	}
}
