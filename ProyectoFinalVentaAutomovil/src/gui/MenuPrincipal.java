package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Almacenes;
import model.Automoviles;

import model.Clientes;
import model.Usuarios;
import model.Ventas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MenuPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnVender;
	private JMenu mnAlmacen;
	private JMenu mnReportes;
	private JMenu mnSalir;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProductos;
	private JMenuItem mntmVentas;
	private JMenuItem mntmRegIngresoAutomiv;
	private JMenuItem mntmListadoVentas;
	private JMenuItem mntmListadoProductosMStock;
	private JMenuItem mntmListadoAcumuladoUnidades;
	private JMenuItem mntmListadoAcumuladoProductos;

    private JLabel statusLabel;
    
	public static Clientes listClientes = new Clientes();
	public static Automoviles listAutomoviles = new Automoviles();
	public static Ventas listVentas = new Ventas();
	public static Almacenes listAlmacenes = new Almacenes();
	public static Usuarios listUsuarios = new Usuarios();


	public static final int INICODIGOCLIENTE = 1001;
	public static final int INICODIGOAUTOMOVIL = 2001;
	public static final int INICODIGOVENTA = 3001;
	public static final int INICODIGOALMACEN = 4001;
	public static final double IMPUESTO = 0.18;
	public static String USUARIOLOGIN = "";
	public static int NUMVENTA = 0;
	private JMenuItem mntmSalir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setResizable(false);
		setTitle("Sistema de Ventas - AutoCenter" );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnSalir = new JMenu("Archivo");
		menuBar.add(mnSalir);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnSalir.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mnMantenimiento.add(mntmClientes);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mnMantenimiento.add(mntmProductos);
		
		mnVender = new JMenu("Vender");
		menuBar.add(mnVender);
		
		mntmVentas = new JMenuItem("Ventas");
		mntmVentas.addActionListener(this);
		mnVender.add(mntmVentas);
		
		mnAlmacen = new JMenu("Almacén");
		menuBar.add(mnAlmacen);
		
		mntmRegIngresoAutomiv = new JMenuItem("Ingreso Stock");
		mntmRegIngresoAutomiv.addActionListener(this);
		mnAlmacen.add(mntmRegIngresoAutomiv);
		
		mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		mntmListadoVentas = new JMenuItem("Listado General Ventas");
		mntmListadoVentas.addActionListener(this);
		mnReportes.add(mntmListadoVentas);
		
		mntmListadoProductosMStock = new JMenuItem("Listado Productos Menos del Stock Min.");
		mntmListadoProductosMStock.addActionListener(this);
		mnReportes.add(mntmListadoProductosMStock);
		
		mntmListadoAcumuladoUnidades = new JMenuItem("Listado Acumulado Productos - Unidades");
		mntmListadoAcumuladoUnidades.addActionListener(this);
		mnReportes.add(mntmListadoAcumuladoUnidades);
		
		mntmListadoAcumuladoProductos = new JMenuItem("Listado Acumulado Productos - Importe");
		mntmListadoAcumuladoProductos.addActionListener(this);
		mnReportes.add(mntmListadoAcumuladoProductos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//setContentPane(contentPane);
		
		// Barra de estado (JLabel en la parte inferior)
        statusLabel = new JLabel("¡Bienvenido! " + USUARIOLOGIN);
        statusLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        statusLabel.setBorder(BorderFactory.createEtchedBorder()); // Borde decorativo

        getContentPane().add(contentPane, BorderLayout.CENTER);
        getContentPane().add(statusLabel, BorderLayout.SOUTH);


	}
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmClientes) {
			FormCliente frame = new FormCliente();
			frame.setVisible(true);
		}
		if (e.getSource() == mntmProductos) {
			FormAutomovil frame = new FormAutomovil();
			frame.setVisible(true);
		}
		if (e.getSource() == mntmVentas) {
			FormVenta frame = new FormVenta();
			frame.setVisible(true);
		}
		if (e.getSource() == mntmRegIngresoAutomiv) {
			FormAlmacen frame = new FormAlmacen();
			frame.setVisible(true);
		}
		if (e.getSource() == mntmListadoVentas) {
			FormReporteVentas frame = new FormReporteVentas();
			frame.setVisible(true);
		}		
		if (e.getSource() == mntmListadoProductosMStock) {
			FormReporteProductoStock frame = new FormReporteProductoStock();
			frame.setVisible(true);
		}			
		if (e.getSource() == mntmListadoAcumuladoUnidades) {
			FormReporteProductoCntAcum frame = new FormReporteProductoCntAcum();
			frame.setVisible(true);
		}		
		if (e.getSource() == mntmListadoAcumuladoProductos) {
			FormReporteProductoImpAcum frame = new FormReporteProductoImpAcum();
			frame.setVisible(true);
		}			
		if (e.getSource() == mntmSalir) {
			System.exit(0);
		}
	}
	
	

	
	public static boolean isNumero(String numero) {
		try {
			int nmero = Integer.parseInt(numero);
			return true;
		} catch (Exception e2) {
			return false;
		}
	}
	
	public static boolean isDecimal(String numero) {
		try {
			double nmero = Double.parseDouble(numero);
			return true;
		} catch (Exception e2) {
			return false;
		}
	}
	
	   public static boolean validarFecha(String fecha) {
	        // Patrón para validar una fecha en formato dd/mm/yyyy
	        String patron = "^\\d{2}/\\d{2}/\\d{4}$";
	        
	        // Compilar la expresión regular en un patrón
	        Pattern pattern = Pattern.compile(patron);
	        
	        // Crear un matcher para hacer coincidir el patrón con la fecha proporcionada
	        Matcher matcher = pattern.matcher(fecha);
	        
	        // Devolver true si la fecha coincide con el patrón, false en caso contrario
	        return matcher.matches();
	    }
	   
	    public static boolean validarFecha2(String fechaTexto) {
	    	try {
		    	// Define el formato de entrada de la fecha (dd/mm/yyyy)
		        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		        // Parsea la cadena de texto a un objeto Date
		        Date fecha = formatoFecha.parse(fechaTexto);	
		        return true;
			} catch (Exception e2) {
				return false;
			}
	    }
    
	    
}
