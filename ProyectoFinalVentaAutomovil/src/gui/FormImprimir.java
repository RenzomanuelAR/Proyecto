package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Automovil;
import model.Cliente;
import model.Venta;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FormImprimir extends JDialog  implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnCerrar;
	private JTextArea textFactura;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormImprimir frame = new FormImprimir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FormImprimir(JFrame parent) {
		super(parent, "Formulario Modal", true); // true indica que es modal
		setTitle("Venta Nº " + MenuPrincipal.NUMVENTA);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 474);
		setLocationRelativeTo(parent);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 499, 390);
		contentPane.add(scrollPane);
		
		textFactura = new JTextArea();
		scrollPane.setViewportView(textFactura);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(420, 405, 89, 23);
		contentPane.add(btnCerrar);
		
		textFactura.setText(imprimirBoleta(MenuPrincipal.NUMVENTA));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
        setVisible(false); // Oculta el formulario modal
        dispose(); // Libera los recursos asociados al formulario
	}
	
	private String imprimirBoleta(Integer codigoVenta) {
		String mensaje="";
		Venta venta = MenuPrincipal.listVentas.busqueda(codigoVenta);
		Cliente cliente = MenuPrincipal.listClientes.busqueda(venta.getCodigoCliente());
		Automovil automovil = MenuPrincipal.listAutomoviles.busqueda(venta.getCodigoAutomovil());
		
		mensaje = "==========FACTURA==========";
		mensaje += imprimir("===========================");
		mensaje += imprimir("==========DATOS CLIENTE==========");
		mensaje += imprimir("Cód. Cliente: " + cliente.getCodigoCliente());
		mensaje += imprimir("Noembres y Apellidos: " + cliente.getNombres() + " " + cliente.getApellidos());
		mensaje += imprimir("Nº Documento: " + cliente.getDni());
		mensaje += imprimir("Teléfono: " + cliente.getTelefono());
		mensaje += imprimir("==========DATOS PRODUCTO==========");
		mensaje += imprimir("Cód. Producto: " + automovil.getCodigoAutomovil());
		mensaje += imprimir("Marca: " + automovil.getMarca());
		mensaje += imprimir("Modelo: " + automovil.getModelo());
		mensaje += imprimir("Año Fabricación: " + automovil.getAnioFabricacion());
		mensaje += imprimir("Color: " + automovil.getColor());
		mensaje += imprimir("Tipo Combustible: " + automovil.getTipoCombustible());
		String tipoVehiculo = (automovil.isEsAutomatico())? "Automatico":"Mecánico";
		mensaje += imprimir("Tipo vehículo: " + tipoVehiculo );
		mensaje += imprimir("Núm. Asientos: " + automovil.getCantidadAsientos());
		mensaje += imprimir("==========DATOS FACTURA ==========");
		mensaje += imprimir("Nº Venta (Factura): " + venta.getCodigoVenta());
		mensaje += imprimir("Fecha Venta: " + venta.getFecha());
		mensaje += imprimir("Unidades Vendidas (Cantidad): " + venta.getCantidad());
		mensaje += imprimir("Precio: " + venta.getPrecio());
		mensaje += imprimir("Importe Bruto: " + venta.getImporte());
		mensaje += imprimir("Importe Descuento: " + venta.getDescuento());
		mensaje += imprimir("Importe IGV: " + venta.getIgv());
		mensaje += imprimir("Importe Pagar: " + venta.getTotal());
		mensaje += imprimir("===========================");

		return mensaje;
	}
	
	private String imprimir(String mensaje) {
		return mensaje + "\n";
		
	}
}
