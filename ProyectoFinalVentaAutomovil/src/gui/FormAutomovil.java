package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Automovil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;

public class FormAutomovil extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textCodigoAutomovil;
	private JComboBox cboModelo;
	private JComboBox cboMarca;
	private JTextField textAnioFabricacion;
	private JComboBox cboPais;
	private JLabel lblNewLabel_4;
	private JLabel lblColor;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JComboBox cboCantidadAsientos;
	private JComboBox cboTipoCombustible;
	private JComboBox cboColor;
	private JCheckBox chkEsAutomatico;
	private JCheckBox chkEstado;
	private JLabel lblPrecio;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JTextField textStockMaximo;
	private JTextField textPrecio;
	private JTextField textStockActual;
	private JTextField textStockMinimo;
	private JSeparator separator;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JLabel lblIngresarCdigoAutomovil;
	private JTextField textCodBusqueda;
	private JButton btnBuscar;
	private JSeparator separator_1;
	
	Map<String, List<String>> marcaModeloMap;
	DefaultTableModel model = new DefaultTableModel();
	boolean isNuevo = true;
	int intPosicion = 0;

	// Crear un arreglo con las marcas
    String[] marcas = {"[ Selecciona ]","Toyota", "Honda", "Ford", "Chevrolet", "Nissan", "Hyundai"};
    
    String[] paises = {"[ Selecciona ]", "Alemania", "Estados Unidos", "Japón", "Corea del Sur", 
    	    "China", "Francia", "Italia", "Reino Unido", "España" };
    
    String[] colores = {"[ Selecciona ]","Rojo", "Azul", "Verde", "Amarillo", 
    	    "Blanco", "Negro", "Gris", "Morado" };
    
    String[] asientos = {"[ Selecciona ]","02", "04", "06", "08", "10"};
    
    String[] combustibles = {"[ Selecciona ]","Gasolina", "Diésel", "Eléctrico", "Gas Licuado de Petróleo (GLP)"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAutomovil frame = new FormAutomovil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    private void inicializarDatos() {
        marcaModeloMap = new HashMap<>();
        
        // Agregar modelos por marca
        marcaModeloMap.put("Toyota", Arrays.asList("[ Selecciona ]","Corolla", "Camry", "Rav4"));
        marcaModeloMap.put("Honda", Arrays.asList("[ Selecciona ]","Civic", "Accord", "CR-V"));
        marcaModeloMap.put("Ford", Arrays.asList("[ Selecciona ]","Mustang", "Fusion", "Escape"));
        marcaModeloMap.put("Chevrolet", Arrays.asList("[ Selecciona ]","Aveo", "Camaro", "Captiva"));
        marcaModeloMap.put("Nissan", Arrays.asList("[ Selecciona ]","Sentra", "Kicks", "March"));
        marcaModeloMap.put("Hyundai", Arrays.asList("[ Selecciona ]","The all-new ACCENT", "ELANTRA", "The new Grand i10 Sedan"));
        marcaModeloMap.put("[ Selecciona ]", Arrays.asList("[ Selecciona ]"));
        // Puedes agregar más marcas y modelos según sea necesario
    }
    
    private void cargarModelos(List<String> modelos) {
        cboModelo.removeAllItems(); // Limpiar los modelos actuales
        
        // Agregar los nuevos modelos al JComboBox cboModelo
        for (String modelo : modelos) {
            cboModelo.addItem(modelo);
        }
    }
	/**
	 * Create the frame.
	 */
	public FormAutomovil() {
		setResizable(false);
		setTitle("Mantenimiento Automovil");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 870, 570);
		setLocationRelativeTo(null);
		
		//carga de informacion de modelos por marca
		inicializarDatos();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 835, 244);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Código Automivil:");
		lblNewLabel.setBounds(10, 28, 128, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setBounds(10, 57, 128, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Modelo:");
		lblNewLabel_2.setBounds(10, 90, 128, 14);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Año Fabricación:");
		lblNewLabel_3.setBounds(10, 122, 128, 14);
		panel.add(lblNewLabel_3);
		
		textCodigoAutomovil = new JTextField();
		textCodigoAutomovil.setEnabled(false);
		textCodigoAutomovil.setBounds(121, 28, 86, 20);
		panel.add(textCodigoAutomovil);
		textCodigoAutomovil.setColumns(10);
		
		cboMarca = new JComboBox();
		cboMarca.setEnabled(false);
		cboMarca.setModel(new DefaultComboBoxModel(marcas));
		cboMarca.setBounds(121, 56, 171, 22);
		panel.add(cboMarca);	
		
		cboMarca.addActionListener(e -> {
			String marcaSeleccionada = (String) cboMarca.getSelectedItem();
	        List<String> modelos = marcaModeloMap.get(marcaSeleccionada);
	        cargarModelos(modelos);
		});
		

		cboModelo = new JComboBox();
		cboModelo.setEnabled(false);
		cboModelo.setBounds(121, 89, 171, 22);
		panel.add(cboModelo);
		
		//carga por defecto
		List<String> modelos = marcaModeloMap.get("[ Selecciona ]");
        cargarModelos(modelos);
		
		textAnioFabricacion = new JTextField();
		textAnioFabricacion.setEnabled(false);
		textAnioFabricacion.setColumns(10);
		textAnioFabricacion.setBounds(121, 122, 86, 20);
		panel.add(textAnioFabricacion);
		
		cboPais = new JComboBox();
		cboPais.setEnabled(false);
		cboPais.setModel(new DefaultComboBoxModel(paises));
		cboPais.setBounds(121, 153, 171, 22);
		panel.add(cboPais);
		
		lblNewLabel_4 = new JLabel("País Fabricación:");
		lblNewLabel_4.setBounds(10, 154, 128, 14);
		panel.add(lblNewLabel_4);
		
		lblColor = new JLabel("Color:");
		lblColor.setBounds(311, 28, 128, 14);
		panel.add(lblColor);
		
		lblNewLabel_6 = new JLabel("Cantidad Asientos:");
		lblNewLabel_6.setBounds(311, 57, 128, 14);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Tipo Cumbustible:");
		lblNewLabel_7.setBounds(311, 90, 128, 14);
		panel.add(lblNewLabel_7);
		
		cboCantidadAsientos = new JComboBox();
		cboCantidadAsientos.setEnabled(false);
		cboCantidadAsientos.setModel(new DefaultComboBoxModel(asientos));
		cboCantidadAsientos.setBounds(422, 56, 171, 22);
		panel.add(cboCantidadAsientos);
		
		cboTipoCombustible = new JComboBox();
		cboTipoCombustible.setEnabled(false);
		cboTipoCombustible.setModel(new DefaultComboBoxModel(combustibles));
		cboTipoCombustible.setBounds(422, 89, 171, 22);
		panel.add(cboTipoCombustible);
		
		cboColor = new JComboBox();
		cboColor.setEnabled(false);
		cboColor.setModel(new DefaultComboBoxModel(colores));
		cboColor.setBounds(422, 24, 171, 22);
		panel.add(cboColor);
		
		chkEsAutomatico = new JCheckBox("Automático");
		chkEsAutomatico.setEnabled(false);
		chkEsAutomatico.setBounds(422, 118, 97, 23);
		panel.add(chkEsAutomatico);
		
		chkEstado = new JCheckBox("Habilitado");
		chkEstado.setEnabled(false);
		chkEstado.setBounds(422, 150, 97, 23);
		panel.add(chkEstado);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(619, 24, 128, 14);
		panel.add(lblPrecio);
		
		lblNewLabel_8 = new JLabel("Stock Actual:");
		lblNewLabel_8.setBounds(619, 53, 128, 14);
		panel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Stock Mínimo:");
		lblNewLabel_9.setBounds(619, 86, 128, 14);
		panel.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Stock Máximo:");
		lblNewLabel_10.setBounds(619, 118, 128, 14);
		panel.add(lblNewLabel_10);
		
		textStockMaximo = new JTextField();
		textStockMaximo.setEnabled(false);
		textStockMaximo.setColumns(10);
		textStockMaximo.setBounds(730, 118, 86, 20);
		panel.add(textStockMaximo);
		
		textPrecio = new JTextField();
		textPrecio.setEnabled(false);
		textPrecio.setColumns(10);
		textPrecio.setBounds(730, 24, 86, 20);
		panel.add(textPrecio);
		
		textStockActual = new JTextField();
		textStockActual.setEnabled(false);
		textStockActual.setColumns(10);
		textStockActual.setBounds(730, 54, 86, 20);
		panel.add(textStockActual);
		
		textStockMinimo = new JTextField();
		textStockMinimo.setEnabled(false);
		textStockMinimo.setColumns(10);
		textStockMinimo.setBounds(730, 87, 86, 20);
		panel.add(textStockMinimo);
		
		separator = new JSeparator();
		separator.setBounds(10, 186, 806, 2);
		panel.add(separator);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(346, 199, 86, 23);
		panel.add(btnNuevo);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(442, 199, 86, 23);
		panel.add(btnEditar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(538, 199, 86, 23);
		panel.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(634, 199, 86, 23);
		panel.add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(730, 199, 86, 23);
		panel.add(btnEliminar);
		
		lblIngresarCdigoAutomovil = new JLabel("Ingresar código Automovil:");
		lblIngresarCdigoAutomovil.setBounds(10, 203, 157, 14);
		panel.add(lblIngresarCdigoAutomovil);
		
		textCodBusqueda = new JTextField();
		textCodBusqueda.setColumns(10);
		textCodBusqueda.setBounds(164, 200, 79, 20);
		panel.add(textCodBusqueda);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(253, 199, 79, 23);
		panel.add(btnBuscar);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 232, 806, 2);
		panel.add(separator_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 266, 834, 258);
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
		model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("Año Fab.");
		model.addColumn("Pais Fab.");
		model.addColumn("Color");
		model.addColumn("Automa.");
		model.addColumn("Precio");
		model.addColumn("Asiento");
		model.addColumn("Combustible");
		model.addColumn("Stk. Actual");
		model.addColumn("Stk. Mín.");
		model.addColumn("Stk. Máx.");
		model.addColumn("Estado");
		table.setModel(model);
		
		cargarDatos();
	}
	


	protected void actionPerformedBtnNuevo(ActionEvent e) {
		int codigoAutomovil = 0;
		habilitarControles(true);
		habilitarBotonos(true);
		limpiar();
		isNuevo = true;

		// generar codigo temporal
		if (MenuPrincipal.listAutomoviles.tamanio() == 0) {
			codigoAutomovil = MenuPrincipal.INICODIGOAUTOMOVIL;
		} else {
			// se suma 1 al ultimo codigo generado
			codigoAutomovil = MenuPrincipal.listAutomoviles.ultimo() + 1;
		}
		textCodigoAutomovil.setText(codigoAutomovil + "");

	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {
		
		if (cboMarca.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(null, "La Marca es un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			cboMarca.grabFocus();
			return;
		}
		
		if (cboModelo.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(null, "El Modelo es un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			cboModelo.grabFocus();
			return;
		}
		
		if (textAnioFabricacion.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El año de fabricación es un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textAnioFabricacion.grabFocus();
			return;
		}
		
		if (cboPais.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(null, "El País Fabricación es un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			cboPais.grabFocus();
			return;
		}
		
		if (cboColor.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(null, "El Color un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			cboColor.grabFocus();
			return;
		}
		
		if (cboCantidadAsientos.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(null, "La Cantidad Asiento es un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			cboCantidadAsientos.grabFocus();
			return;
		}
		
		if (cboTipoCombustible.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(null, "El TipoCombustible es un dato requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			cboTipoCombustible.grabFocus();
			return;
		}
	
		
		if (textPrecio.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El Preci es un dato requerido", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textPrecio.grabFocus();
			return;
		}
		
		if(!MenuPrincipal.isNumero(textPrecio.getText().trim())) {
			JOptionPane.showMessageDialog(null, "El Precio es un dato númerico", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textPrecio.grabFocus();
			return;
		}
		
		if (textStockActual.getText().trim().equals("")) {
			textStockActual.setText("0");
		}
		
		if(!MenuPrincipal.isNumero(textStockActual.getText().trim())) {
			JOptionPane.showMessageDialog(null, "El Stock Actual es un dato númerico", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textStockActual.grabFocus();
			return;
		}
		
		if (textStockMinimo.getText().trim().equals("")) {
			textStockMinimo.setText("0");
		}
		
		if(!MenuPrincipal.isNumero(textStockMinimo.getText().trim())) {
			JOptionPane.showMessageDialog(null, "El Stock Mínimo es un dato númerico", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textStockMinimo.grabFocus();
			return;
		}
		
		if (textStockMaximo.getText().trim().equals("")) {
			textStockMaximo.setText("0");
		}
		
		if(!MenuPrincipal.isNumero(textStockMaximo.getText().trim())) {
			JOptionPane.showMessageDialog(null, "El Stock Máximo es un dato númerico", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textStockMaximo.grabFocus();
			return;
		}
		
		String marca = (String) cboMarca.getSelectedItem();
		String modelo = (String) cboModelo.getSelectedItem();
		String color = (String) cboColor.getSelectedItem();
		if(isNuevo && MenuPrincipal.listAutomoviles.validarExistencia(marca, modelo, textAnioFabricacion.getText(),color)) {
			JOptionPane.showMessageDialog(null, "¡Acción Denegada! Ya exite un registro con la marca, modelo, año y color.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			cboMarca.grabFocus();
			return;
		}

		habilitarControles(false);
		habilitarBotonos(false);

		int codigo = Integer.parseInt(textCodigoAutomovil.getText());

		Automovil automovil = new Automovil();
		automovil.setCodigoAutomovil(codigo);

		automovil.setMarca(cboMarca.getSelectedItem().toString());
		automovil.setModelo(cboModelo.getSelectedItem().toString());
		automovil.setAnioFabricacion(textAnioFabricacion.getText().toString());
		automovil.setPais(cboPais.getSelectedItem().toString());
		automovil.setColor(cboColor.getSelectedItem().toString());
		automovil.setEsAutomatico(chkEsAutomatico.isSelected());
		automovil.setPrecio(Double.parseDouble(textPrecio.getText()));
		automovil.setCantidadAsientos(cboCantidadAsientos.getSelectedItem().toString());
		automovil.setTipoCombustible(cboTipoCombustible.getSelectedItem().toString());
		automovil.setStockActual(Integer.parseInt(textStockActual.getText()));
		automovil.setStockMinimo(Integer.parseInt(textStockMinimo.getText()));
		automovil.setStockMaximo(Integer.parseInt(textStockMaximo.getText()));
		automovil.setEstado(chkEstado.isSelected());

		if (isNuevo) {
			// Guardar nuevo
			MenuPrincipal.listAutomoviles.agregar(automovil);
		} else {
			// guardar edicion de registro
			MenuPrincipal.listAutomoviles.actualizar(automovil);
		}
		cargarDatos();

	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		habilitarControles(false);
		habilitarBotonos(false);
		if(isNuevo)
			textCodigoAutomovil.setText("");
	}

	protected void actionPerformedBtnEditar(ActionEvent e) {
		if (textCodigoAutomovil.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "No hay ningun registro seleccionado.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		habilitarControles(true);
		habilitarBotonos(true);
		isNuevo = false;
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		if (textCodigoAutomovil.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "No hay ningun registro seleccionado.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		int codigoAutomovil = Integer.parseInt(textCodigoAutomovil.getText());
		
		if(MenuPrincipal.listVentas.tieneVentasAutomovil(codigoAutomovil)) {
			JOptionPane.showMessageDialog(null, "¡Acción Denegada! Existen ventas registradas con este código de automovil.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		MenuPrincipal.listAutomoviles.eliminar(MenuPrincipal.listAutomoviles.busqueda(codigoAutomovil));
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
        
        if(Objects.isNull(MenuPrincipal.listAutomoviles.busqueda(codigo))) {
			JOptionPane.showMessageDialog(null, "No existe el código ingresado", "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
			textCodBusqueda.grabFocus();
			return;
        }
        llenarFormulario(MenuPrincipal.listAutomoviles.busqueda(codigo));
	}
	
	private void habilitarControles(boolean estado) {
		cboMarca.setEnabled(estado);
		cboModelo.setEnabled(estado);
		textAnioFabricacion.setEnabled(estado);
		cboPais.setEnabled(estado);
		cboColor.setEnabled(estado);
		chkEsAutomatico.setEnabled(estado);
		textPrecio.setEnabled(estado);
		cboCantidadAsientos.setEnabled(estado);
		cboTipoCombustible.setEnabled(estado);
		textStockActual.setEnabled(estado);
		textStockMinimo.setEnabled(estado);
		textStockMaximo.setEnabled(estado);
		chkEstado.setEnabled(estado);
		if (estado) {
			cboMarca.grabFocus();
		} else {
			textCodigoAutomovil.grabFocus();
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
		//carga por defecto
		cboMarca.setSelectedIndex(0);
		List<String> modelos = marcaModeloMap.get("[ Selecciona ]");
        cargarModelos(modelos);
        
        textCodigoAutomovil.setText("");
        cboMarca.setSelectedIndex(0);
        cboModelo.setSelectedIndex(0);
        textAnioFabricacion.setText("");
        cboPais.setSelectedIndex(0);
        cboColor.setSelectedIndex(0);
        chkEsAutomatico.setSelected(true);
        textPrecio.setText("");
        cboCantidadAsientos.setSelectedIndex(0);
        cboTipoCombustible.setSelectedIndex(0);
        textStockActual.setText("");
        textStockMinimo.setText("");
        textStockMaximo.setText("");
        chkEstado.setSelected(true);
	}

	private void llenarFormulario(Automovil automovil) {
		textCodigoAutomovil.setText(automovil.getCodigoAutomovil()+"");
		cboMarca.setSelectedItem(automovil.getMarca());
		cboModelo.setSelectedItem(automovil.getModelo());
		textAnioFabricacion.setText(automovil.getAnioFabricacion());
		cboPais.setSelectedItem(automovil.getPais());
		cboColor.setSelectedItem(automovil.getColor());
		chkEsAutomatico.setSelected(automovil.isEsAutomatico());
		textPrecio.setText(automovil.getPrecio()+"");
		cboCantidadAsientos.setSelectedItem(automovil.getCantidadAsientos());
		cboTipoCombustible.setSelectedItem(automovil.getTipoCombustible());
		textStockActual.setText(automovil.getStockActual()+"");
		textStockMinimo.setText(automovil.getStockMinimo()+"");
		textStockMaximo.setText(automovil.getStockMaximo()+"");
		chkEstado.setSelected(automovil.isEstado());	
	}

	//private void buscarAutomovilPorPosicion() {
		//Automovil automovil = MenuPrincipal.listAutomoviles.navegarAutomovils(intPosicion);
		//llenarFormulario(automovil);
	//}

	private void cargarDatos() {
		model.setRowCount(0);

		for (Automovil automovil : MenuPrincipal.listAutomoviles.getListAutomoviles()) {
			Object[] fila = new Object[14];
			fila[0]=automovil.getCodigoAutomovil();
			fila[1]=automovil.getMarca();
			fila[2]=automovil.getModelo();
			fila[3]=automovil.getAnioFabricacion();
			fila[4]=automovil.getPais();
			fila[5]=automovil.getColor();
			fila[6]=automovil.isEsAutomatico();
			fila[7]=automovil.getPrecio();
			fila[8]=automovil.getCantidadAsientos();
			fila[9]=automovil.getTipoCombustible();
			fila[10]=automovil.getStockActual();
			fila[11]=automovil.getStockMinimo();
			fila[12]=automovil.getStockMaximo();
			fila[13]=automovil.isEstado();
			model.addRow(fila);
		}

	}
	
    private void mostrarValores() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) { // Si hay una fila seleccionada
            String codigoString = String.valueOf(table.getValueAt(filaSeleccionada, 0));
            int codigo = Integer.parseInt(codigoString);
            llenarFormulario(MenuPrincipal.listAutomoviles.busqueda(codigo));
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
    
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
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
	}

}
