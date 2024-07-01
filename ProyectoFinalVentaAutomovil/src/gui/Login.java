package gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DropMode;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblFondo;
	private JLabel lblNewLabel;
	private JTextField textUsuario;
	private JButton btnIniciar;
	private JPanel panel;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Inicio de Sesión");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 537, 355);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblFondo = new JLabel("");
		
		lblFondo.setBounds(0, 0, 521, 316);
		
		ImageIcon rutaImgen = new ImageIcon(Login.class.getResource("/img/fondo.jpg"));
		ImageIcon img = new ImageIcon(rutaImgen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH));
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(this);
		btnIniciar.setBackground(new Color(255, 0, 0));
		btnIniciar.setForeground(new Color(255, 255, 255));
		btnIniciar.setBounds(262, 197, 213, 23);
		contentPane.add(btnIniciar);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(262, 99, 213, 30);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		lblNewLabel = new JLabel("Inicio de Sesión");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Teko SemiBold", Font.BOLD, 24));
		lblNewLabel.setBounds(240, 52, 256, 36);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBorder(null);
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(225, 11, 286, 294);
		contentPane.add(panel);
		panel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(37, 132, 213, 30);
		panel.add(passwordField);
		lblFondo.setIcon(img);
		contentPane.add(lblFondo);
		
		Usuario usuario1 = new Usuario(1,"Renzo","123");
		Usuario usuario2 = new Usuario(2,"Luis","123");
		Usuario usuario3 = new Usuario(3,"Diego","123");
		
		MenuPrincipal.listUsuarios.agregar(usuario1);
		MenuPrincipal.listUsuarios.agregar(usuario2);
		MenuPrincipal.listUsuarios.agregar(usuario3);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIniciar) {
			actionPerformedBtnIniciar(e);
		}
	}
	protected void actionPerformedBtnIniciar(ActionEvent e) {
		if (textUsuario.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario es requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textUsuario.grabFocus();
			return;
		}
		
		char[] passwordChars = passwordField.getPassword();
		String password = new String(passwordChars);
		
		if (password.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El password es requerido.", "Mensaje de validación",
					JOptionPane.ERROR_MESSAGE);
			textUsuario.grabFocus();
			return;
		}
		

		
		Usuario usuario = new Usuario();
		usuario.setCodigoUsuario(1000);
		usuario.setNomUsuario(textUsuario.getText().trim());
		usuario.setPassword(password);
		
		if(MenuPrincipal.listUsuarios.validarInicioSesion(usuario)) {
			//Se guarda el nombre de usuario que inició sesion
			MenuPrincipal.USUARIOLOGIN = textUsuario.getText().trim();
			dispose();
			
            MenuPrincipal mainForm = new MenuPrincipal();
            mainForm.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "¡Acceso Denegado! Credenciales incorrectas. Inténtelo de nuevo.", "Error de inicio de sesión",
					JOptionPane.ERROR_MESSAGE);
			textUsuario.grabFocus();
		}
	}
}
