package com.alura.hotel.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alura.hotel.controller.LoginController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	
	LoginController loginController = new LoginController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagenes/perfil-del-usuario.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/hotel.png")));
		lblNewLabel.setBounds(-53, 0, 422, 499);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(409, 181, 234, 33);
		contentPane.add(txtUsuario);
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Usuario");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(409, 156, 57, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(409, 261, 234, 33);
		contentPane.add(txtContrasena);
		
		
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(409, 236, 133, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/imagenes/perfil-del-usuario.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
	//ADMIN			System.out.println("login controller"+loginController.listar(usuario, clave));
				
				String usuario = txtUsuario.getText();
				String clave = new String(txtContrasena.getPassword());
				
				boolean controlado = loginController.listar(usuario, clave);
				
				
				if (controlado) {
					MenuUsuario user = new MenuUsuario();
					user.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Verifique su USUARIO y CONTRASEÑA y vuelva a intentarlo", "Error de Login", 0, null);				
					dispose();
					MenuPrincipal.main(null);

				}
				
				
				
				
//				
//				revisarLogin(usuario);
//				System.out.println("el usuario ingresado es= "+ usuario);
//				System.out.println("la contraseña ingresada es= "+ clave);
//				
//				if(revisarUsuario(usuario) && revisarPass(clave)){
//					System.out.println("correcto");
//					
//				}
//				
				
//				String user = txtUsuario.getText();		
//				String contrasena = new String(txtContrasena.getPassword());
//
//				LoginController loginController = new LoginController();
//					
//				loginController.getLogin();
//				
//				
//				System.out.println("el usuario (en LOGIN.JAVA) es " +  user);
//				System.out.println("la contraseña (en LOGIN.JAVA) es " + contrasena);		
//				
//			if (loginController.usrPassOk(user, contrasena)) {		
//				MenuUsuario user = new MenuUsuario();
//				user.setVisible(true);
//				dispose();
				
//			} else {
				
//				JOptionPane.showMessageDialog(null, "Verifique su USUARIO y CONTRASEÑA y vuelva a intentarlo", "Error de Login", 0, null);				
//				dispose();
//				MenuPrincipal.main(null);
//				System.out.println("no entro al if");
//			}
//			
			}
		});
		btnLogin.setBounds(409, 322, 103, 33);
		contentPane.add(btnLogin);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(Login.class.getResource("/imagenes/cerrar-24px.png")));
	
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				dispose();
				MenuPrincipal.main(null);
			
			}
		});
		
		btnCancelar.setBounds(540, 322, 103, 33);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Genesys\\Documents\\imagenesAluraHotel\\Ha-100px.png"));
		lblNewLabel_1.setBounds(470, 30, 103, 94);
		contentPane.add(lblNewLabel_1);
	}

//	public boolean revisarUsuario(String usuario) {
//		
//		return LoginController.revisarUsuario(usuario);
//	}
//	
	
//	public boolean revisarLogin(String Usuario){
//		
//		
//		
//		var empleados = this.loginController.listar();
//
//		empleados.forEach(
//				huesped -> modelo.addRow(new Object[] { huesped.getId(), huesped.getNombre(), huesped.getApellido(),
//						huesped.getFechaNacimiento(), huesped.getNacionalidad(), huesped.getTelefono(), huesped.getIdReserva() }));
//		
//		
//		return true;
//	}
}
