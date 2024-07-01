package gui;

import java.awt.EventQueue;
import gui.MenuPrincipal.*;
import model.Cliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FormCliente extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblCodigo;
	private JTextField textCodigo;
	private JButton btnBuscar;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JTextField textNombre;
	private JLabel lblNewLabel_3;
	private JTextField textApellido;
	private JTextField textDni;
	private JLabel lblDireccion;
	private JTextField textDireccion;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textTelefono;
	private JTextField textEmail;
	private JCheckBox chkHabilitado;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JSeparator separator;
	private JButton btnEditar;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textCodBusqueda;
	private JLabel lblIngresarCdigoCliente;
	private JSeparator separator_1;
	private JButton btnCancelar;
	
	DefaultTableModel model = new DefaultTableModel();
	boolean isNuevo = true;
	int intPosicion = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCliente frame = new FormCliente();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); //centrar formulario
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormCliente() {
		setResizable(false);
		setTitle("Mantenimiento Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 572, 541);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 538, 231);
		contentPane.add(panel);
		panel.setLayout(null);

		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 24, 81, 14);
		panel.add(lblCodigo);

		textCodigo = new JTextField();
		textCodigo.setEnabled(false);
		textCodigo.setBounds(101, 21, 86, 20);
		panel.add(textCodigo);
		textCodigo.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(270, 197, 89, 23);
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
		textNombre.setBounds(101, 49, 185, 20);
		panel.add(textNombre);

		lblNewLabel_3 = new JLabel("DNI:");
		lblNewLabel_3.setBounds(326, 52, 66, 14);
		panel.add(lblNewLabel_3);

		textApellido = new JTextField();
		textApellido.setEnabled(false);
		textApellido.setColumns(10);
		textApellido.setBounds(101, 77, 185, 20);
		panel.add(textApellido);

		textDni = new JTextField();
		textDni.setEnabled(false);
		textDni.setColumns(10);
		textDni.setBounds(402, 49, 121, 20);
		panel.add(textDni);

		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(10, 108, 86, 14);
		panel.add(lblDireccion);

		textDireccion = new JTextField();
		textDireccion.setEnabled(false);
		textDireccion.setColumns(10);
		textDireccion.setBounds(101, 105, 185, 20);
		panel.add(textDireccion);

		lblNewLabel_5 = new JLabel("Teléfono:");
		lblNewLabel_5.setBounds(326, 80, 66, 14);
		panel.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("E-Mail:");
		lblNewLabel_6.setBounds(326, 108, 66, 14);
		panel.add(lblNewLabel_6);

		textTelefono = new JTextField();
		textTelefono.setEnabled(false);
		textTelefono.setColumns(10);
		textTelefono.setBounds(402, 77, 121, 20);
		panel.add(textTelefono);

		textEmail = new JTextField();
		textEmail.setEnabled(false);
		textEmail.setColumns(10);
		textEmail.setBounds(402, 105, 121, 20);
		panel.add(textEmail);

		chkHabilitado = new JCheckBox("Habilitado");
		chkHabilitado.setEnabled(false);
		chkHabilitado.setBounds(402, 20, 97, 23);
		panel.add(chkHabilitado);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 148, 96, 23);
		panel.add(btnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(218, 148, 96, 23);
		panel.add(btnGuardar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(426, 148, 96, 23);
		panel.add(btnEliminar);

		separator = new JSeparator();
		separator.setBounds(10, 136, 513, 2);
		panel.add(separator);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(114, 148, 96, 23);
		panel.add(btnEditar);
		
		textCodBusqueda = new JTextField();
		textCodBusqueda.setColumns(10);
		textCodBusqueda.setBounds(164, 198, 96, 20);
		panel.add(textCodBusqueda);
		
		lblIngresarCdigoCliente = new JLabel("Ingresar código cliente:");
		lblIngresarCdigoCliente.setBounds(10, 201, 144, 14);
		panel.add(lblIngresarCdigoCliente);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 182, 513, 2);
		panel.add(separator_1);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(322, 148, 96, 23);
		panel.add(btnCancelar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 253, 536, 238);
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
		model.addColumn("Apellidos");
		model.addColumn("Nombres");
		model.addColumn("DNI");
		model.addColumn("Dirección");
		model.addColumn("E-Mail");
		model.addColumn("Estado");
		table.setModel(model);
		
		cargarDatos();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		int codigoCliente = 0;
		habilitarControles(true);
		habilitarBotonos(true);
		limpiar();
		isNuevo = true;

		// generar codigo temporal
		if (MenuPrincipal.listClientes.tamanio() == 0) {
			codigoCliente = MenuPrincipal.INICODIGOCLIENTE;
		} else {
			// se suma 1 al ultimo codigo generado
			codigoCliente = MenuPrincipal.listClientes.ultimo() + 1;
		}
		textCodigo.setText(codigoCliente + "");

	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {
		
		if (textNombre.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El Nombre es un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textNombre.grabFocus();
			return;
		}
		
		if (textApellido.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Los Apellidos son datos requeridos.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textApellido.grabFocus();
			return;
		}
		
		if (textDireccion.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "La dirección es un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textDireccion.grabFocus();
			return;
		}
		
		if (textDni.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El DNI es un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textDni.grabFocus();
			return;
		}
		
		String dni = textDni.getText().trim();
		
		if (dni.length() != 8) {
			JOptionPane.showMessageDialog(null, "El DNI debe tener 8 digitos.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textDni.grabFocus();
			return;
		}
		
		if(!MenuPrincipal.isNumero(dni)) {
			JOptionPane.showMessageDialog(null, "El DNI debe ser solo de caracteres númericos.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textDni.grabFocus();
			return;
		}
		
		String telefono = textTelefono.getText().trim();
		
		if (textTelefono.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El Teléfono es un dato requerido", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textTelefono.grabFocus();
			return;
		}
		
		if(!MenuPrincipal.isNumero(telefono)) {
			JOptionPane.showMessageDialog(null, "El Teléfono debe ser solo de caracteres númericos", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textTelefono.grabFocus();
			return;
		}
		
		if (textEmail.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El correo electrónico es un dato requerido", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textEmail.grabFocus();
			return;
		}
		
		if (!validarEmail(textEmail.getText().trim())) {
			JOptionPane.showMessageDialog(null, "No es correo electrónico válido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textEmail.grabFocus();
			return;
		}		

		if(isNuevo && MenuPrincipal.listClientes.validarExistencia(textNombre.getText().trim(), textApellido.getText().trim(), dni)) {
			JOptionPane.showMessageDialog(null, "¡Acción Denegada! Ya exite un registro con el Nombre, Apellido o DNI.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textEmail.grabFocus();
			return;
		}
		
		habilitarControles(false);
		habilitarBotonos(false);

		int codigo = Integer.parseInt(textCodigo.getText());

		Cliente cliente = new Cliente();
		cliente.setCodigoCliente(codigo);
		cliente.setNombres(textNombre.getText());
		cliente.setApellidos(textApellido.getText());
		cliente.setDireccion(textDireccion.getText());
		cliente.setDni(textDni.getText());
		cliente.setTelefono(textTelefono.getText());
		cliente.setEmail(textEmail.getText());
		cliente.setEstado(chkHabilitado.isSelected());

		if (isNuevo) {
			// Guardar nuevo
			MenuPrincipal.listClientes.agregar(cliente);
		} else {
			// guardar edicion de registro
			MenuPrincipal.listClientes.actualizar(cliente);
		}
		cargarDatos();

	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		habilitarControles(false);
		habilitarBotonos(false);
		if(isNuevo)
			textCodigo.setText("");
	}

	protected void actionPerformedBtnEditar(ActionEvent e) {
		if (textCodigo.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "No hay ningun registro seleccionado.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		habilitarControles(true);
		habilitarBotonos(true);
		isNuevo = false;
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		if (textCodigo.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "No hay ningun registro seleccionado.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		int codigoCliente = Integer.parseInt(textCodigo.getText());
		
		if(MenuPrincipal.listVentas.tieneVentasCliente(codigoCliente)) {
			JOptionPane.showMessageDialog(null, "¡Acción Denegada! Existen ventas registradas con este código de cliente.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		MenuPrincipal.listClientes.eliminar(MenuPrincipal.listClientes.busqueda(codigoCliente));
		limpiar();

		cargarDatos();
	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		if (textCodBusqueda.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Ingrese un código.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			textCodBusqueda.grabFocus();
			return;
		}
		
		if(!MenuPrincipal.isNumero(textCodBusqueda.getText().trim())) {
			JOptionPane.showMessageDialog(null, "El código inválido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textCodBusqueda.grabFocus();
			return;
		}
		
        int codigo = Integer.parseInt(textCodBusqueda.getText());
        
        if(Objects.isNull(MenuPrincipal.listClientes.busqueda(codigo))) {
			JOptionPane.showMessageDialog(null, "No existe el código ingresado", "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
			textCodBusqueda.grabFocus();
			return;
        }
        llenarFormulario(MenuPrincipal.listClientes.busqueda(codigo));
	}
	
	private void habilitarControles(boolean estado) {
		textApellido.setEnabled(estado);
		textNombre.setEnabled(estado);
		textDireccion.setEnabled(estado);
		textDni.setEnabled(estado);
		textEmail.setEnabled(estado);
		textTelefono.setEnabled(estado);
		chkHabilitado.setEnabled(estado);
		if (estado) {
			textNombre.grabFocus();
		} else {
			textCodigo.grabFocus();
		}
	}

	private void habilitarBotonos(boolean estado) {
		btnBuscar.setEnabled(!estado);
		btnNuevo.setEnabled(!estado);
		btnEditar.setEnabled(!estado);
		btnGuardar.setEnabled(estado);
		btnCancelar.setEnabled(estado);
		btnEliminar.setEnabled(!estado);
	}

	private void limpiar() {
		textApellido.setText("");
		textNombre.setText("");
		textCodigo.setText("");
		textDni.setText("");
		textEmail.setText("");
		textTelefono.setText("");
		textDireccion.setText("");
		chkHabilitado.setSelected(true);
	}

	private void llenarFormulario(Cliente cliente) {
		textApellido.setText(cliente.getApellidos());
		textNombre.setText(cliente.getNombres());
		textCodigo.setText(cliente.getCodigoCliente() + "");
		textDni.setText(cliente.getDni());
		textEmail.setText(cliente.getEmail());
		textTelefono.setText(cliente.getTelefono());
		textDireccion.setText(cliente.getDireccion());
		chkHabilitado.setSelected(cliente.isEstado());
	}

	//private void buscarClientePorPosicion() {
		//Cliente cliente = MenuPrincipal.listClientes.navegarClientes(intPosicion);
		//llenarFormulario(cliente);
	//}

	private void cargarDatos() {
		model.setRowCount(0);

		for (Cliente cliente : MenuPrincipal.listClientes.getListClientes()) {
			Object[] fila = new Object[7];
			fila[0] = cliente.getCodigoCliente();
			fila[1] = cliente.getApellidos();
			fila[2] = cliente.getNombres();
			fila[3] = cliente.getDni();
			fila[4] = cliente.getDireccion();
			fila[5] = cliente.getEmail();
			fila[6] = cliente.isEstado();
			model.addRow(fila);
		}

	}
	
    private void mostrarValores() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) { // Si hay una fila seleccionada
            String codigoString = String.valueOf(table.getValueAt(filaSeleccionada, 0));
            int codigo = Integer.parseInt(codigoString);
            llenarFormulario(MenuPrincipal.listClientes.busqueda(codigo));
        }
    }
    
    private boolean validarEmail(String email) {
        // Expresión regular para validar dirección de correo electrónico
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // Compilar la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);

        // Crear un objeto Matcher para comparar el patrón con la cadena de entrada
        Matcher matcher = pattern.matcher(email);

        // Devolver true si la cadena coincide con la expresión regular, false en caso contrario
        return matcher.matches();
    }

}
