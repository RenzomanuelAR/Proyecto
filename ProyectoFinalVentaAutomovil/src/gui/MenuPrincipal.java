package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Automovil;
import model.Cliente;
import model.Ventas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuPrincipal extends JFrame {

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
	
	public List<Cliente> listClientes = new ArrayList<Cliente>();
	public List<Automovil> listAutomoviles = new ArrayList<Automovil>();
	public List<Ventas> listVentas = new ArrayList<Ventas>();

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmClientes = new JMenuItem("Clientes");
		mnMantenimiento.add(mntmClientes);
		
		mntmProductos = new JMenuItem("Productos");
		mnMantenimiento.add(mntmProductos);
		
		mnVender = new JMenu("Vender");
		menuBar.add(mnVender);
		
		mntmVentas = new JMenuItem("Ventas");
		mnVender.add(mntmVentas);
		
		mnAlmacen = new JMenu("Almacén");
		menuBar.add(mnAlmacen);
		
		mntmRegIngresoAutomiv = new JMenuItem("Ingreso Stock");
		mnAlmacen.add(mntmRegIngresoAutomiv);
		
		mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		mntmListadoVentas = new JMenuItem("Listado General Ventas");
		mnReportes.add(mntmListadoVentas);
		
		mntmListadoProductosMStock = new JMenuItem("Listado Productos Menos del Stock Min.");
		mnReportes.add(mntmListadoProductosMStock);
		
		mntmListadoAcumuladoUnidades = new JMenuItem("Listado Acumulado Productos - Unidades");
		mnReportes.add(mntmListadoAcumuladoUnidades);
		
		mntmListadoAcumuladoProductos = new JMenuItem("Listado Acumulado Productos - Importe");
		mnReportes.add(mntmListadoAcumuladoProductos);
		
		mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
