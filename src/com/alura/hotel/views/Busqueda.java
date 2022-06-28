package com.alura.hotel.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.alura.hotel.controller.HuespedController;
import com.alura.hotel.controller.ReservaController;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;

public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;

	private DefaultTableModel modelo;
	private DefaultTableModel modelo2;

	ReservaController reservaController = new ReservaController();
	HuespedController huespedController = new HuespedController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(647, 85, 158, 31);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoBuscado = txtBuscar.getText();

				borrarTablaHuesped();
				borrarTablaReserva();

				huespedController.listarBusqueda(textoBuscado);

				System.out.println(huespedController.listarBusqueda(textoBuscado));

				filtrarTablaReserva(textoBuscado);
				filtrarTablaHuesped(textoBuscado);

			}
		});
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/lupa2.png")));
		btnBuscar.setBounds(815, 75, 54, 41);
		contentPane.add(btnBuscar);

		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/editar-texto.png")));
		btnEditar.setBackground(SystemColor.menu);
		btnEditar.setBounds(587, 416, 54, 41);
		contentPane.add(btnEditar);

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (selecciono()) {
					JOptionPane.showMessageDialog(null, "Por favor, elije un item");
					return;
				}

				Optional.ofNullable(modelo.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
						.ifPresentOrElse(fila -> {

							Integer id = Integer.valueOf(modelo.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
							String nombre = (String) modelo.getValueAt(tbHuespedes.getSelectedRow(), 1);
							String apellido = (String) modelo.getValueAt(tbHuespedes.getSelectedRow(), 2);

							String nacionalidad = (String) modelo.getValueAt(tbHuespedes.getSelectedRow(), 4);
							String telefono = (String) modelo.getValueAt(tbHuespedes.getSelectedRow(), 5);
							String idReserva = (String) modelo.getValueAt(tbHuespedes.getSelectedRow(), 6);


							var filasModificadas = huespedController.modificarHuespedes(id, nombre, apellido,
									nacionalidad, telefono, idReserva);

							JOptionPane.showMessageDialog(null,
									String.format("%d item modificado con éxito!", filasModificadas));
						}, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));
			}

		});

		JLabel lblNewLabel_4 = new JLabel("Sistema de Búsqueda");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_4.setBounds(155, 42, 258, 42);
		contentPane.add(lblNewLabel_4);

		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/cerrar-sesion 32-px.png")));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(815, 416, 54, 41);
		contentPane.add(btnSalir);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBounds(10, 127, 874, 265);
		contentPane.add(panel);

		tbHuespedes = new JTable();
		tbHuespedes.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/persona.png")), tbHuespedes,
				null);

		modelo = (DefaultTableModel) tbHuespedes.getModel();
		modelo.addColumn("Nro de Huesped");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Fecha de Nacimiento");
		modelo.addColumn("Nacionalidad");
		modelo.addColumn("Nro de Teléfono");
		modelo.addColumn("Nro de Reserva");

		Object[] listita = { "huesped", "nobre", "apellido", "nacimiento", "nacionalidad", "telefono", "Nro de Reserva" };

		modelo.addRow(listita);

		cargarTablaHuesped();

		JTable tbReservas = new JTable();
		tbReservas.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/calendario.png")), tbReservas,
				null);

		modelo2 = (DefaultTableModel) tbReservas.getModel();
		modelo2.addColumn("Codigo de Reservas");
		modelo2.addColumn("Fecha de Entrada");
		modelo2.addColumn("Fecha de Salida");
		modelo2.addColumn("Valor total");
		modelo2.addColumn("Forma de Pago");
	//	modelo2.addColumn("Cliente");

		Object[] listita2 = { "codigo", "entrada", "salida", "valor", "pago"};//, "cliente" };

		modelo2.addRow(listita2);

		cargarTablaReserva();

		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/deletar.png")));
		btnEliminar.setBackground(SystemColor.menu);
		btnEliminar.setBounds(651, 416, 54, 41);
		contentPane.add(btnEliminar);

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (selecciono()) {
					JOptionPane.showMessageDialog(null, "Por favor, elije un item");
					return;
				}

				Optional.ofNullable(modelo.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
						.ifPresentOrElse(fila -> {
							Integer id = Integer.valueOf(modelo.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
							var filasModificadas = huespedController.borrarHuespedes(id);
							borrarTablaHuesped();
							cargarTablaHuesped();
							JOptionPane.showMessageDialog(null,
									String.format("%d item eliminado con éxito!", filasModificadas));
						}, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));

				Optional.ofNullable(modelo2.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
						.ifPresentOrElse(fila -> {
							String id = String.valueOf(modelo2.getValueAt(tbReservas.getSelectedRow(), 0));
							var filasModificadas = reservaController.borrarReservas(id);
							borrarTablaHuesped();
							cargarTablaHuesped();
							JOptionPane.showMessageDialog(null,
									String.format("%d item eliminado con éxito!", filasModificadas));
						}, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));

			}

		});

		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/cancelar.png")));
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setBounds(713, 416, 54, 41);
		contentPane.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarTablaReserva();
				borrarTablaHuesped();
				cargarTablaReserva();
				cargarTablaHuesped();
			}
		});

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(25, 10, 104, 107);
		contentPane.add(lblNewLabel_2);
		setResizable(false);
	}

	private void cargarTablaHuesped() {
		var huespedes = this.huespedController.listar();

		huespedes.forEach(
				huesped -> modelo.addRow(new Object[] { huesped.getId(), huesped.getNombre(), huesped.getApellido(),
						huesped.getFechaNacimiento(), huesped.getNacionalidad(), huesped.getTelefono(), huesped.getIdReserva() }));
	}

	private void cargarTablaReserva() {
		var reservas = this.reservaController.listar();

		reservas.forEach(reserva -> modelo2.addRow(new Object[] { reserva.getId(), reserva.getFechaEntrada(),
				reserva.getFechaSalida(), reserva.getValor(), reserva.getFomaPago() }));
	}

	private void filtrarTablaHuesped(String textoBuscado) {
		var huespedes = this.huespedController.listarBusqueda(textoBuscado);

		huespedes.forEach(
				huesped -> modelo.addRow(new Object[] { huesped.getId(), huesped.getNombre(), huesped.getApellido(),
						huesped.getFechaNacimiento(), huesped.getNacionalidad(), huesped.getTelefono(), huesped.getIdReserva() }));
	}

	private void filtrarTablaReserva(String textoBuscado) {
		var reservas = this.reservaController.listarBusqueda(textoBuscado);

		reservas.forEach(reserva -> modelo2.addRow(new Object[] { reserva.getId(), reserva.getFechaEntrada(),
				reserva.getFechaSalida(), reserva.getValor(), reserva.getFomaPago() }));
	}

	private void borrarTablaHuesped() {
		modelo.setRowCount(1);
	}

	private void borrarTablaReserva() {
		modelo2.setRowCount(1);

	}

	private boolean selecciono() {
		return (tbHuespedes.getSelectedRowCount() == 0 || tbHuespedes.getSelectedColumnCount() == 0);

	}

}
