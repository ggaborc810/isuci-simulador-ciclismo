package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPerfilMasajista extends JPanel {

	
	private JTextField nombreUsuario;
	private JTextField nombre;
	private JTextField cedula;
	private JTextField genero;
	private JTextField aniosExperiencia;
	private JTextField correoElectronico;
	private JTextField contraseña;
	private ImageIcon imagen ;
	private JButton btnVolver;

	public PanelPerfilMasajista() {

		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		imagen = new ImageIcon("fotos/Informacion del Masajista.png");
		
		
		nombreUsuario = generarEscritura(300, 217, 220, 30);
		nombre = generarEscritura(300, 273, 220, 30);
		cedula = generarEscritura(300, 329, 220, 30);
		genero = generarEscritura(300, 385, 220,30);
		aniosExperiencia = generarEscritura(320, 441, 220,30);
		correoElectronico = generarEscritura(790, 273, 180, 30);
		contraseña = generarEscritura(790, 329,180, 30);
		
		btnVolver = generarBoton("volver", 910, 440, 50, 30, "fotos/FlechaVolver.png");
		add(nombreUsuario);
		add(nombre);
		add(cedula);
		add(genero);
		add(aniosExperiencia);
		add(correoElectronico);
		add(contraseña);
		add(btnVolver);

	}

	public JButton generarBoton(String texto, int x, int y, int ancho, int alto, String url) {
		JButton btn = new JButton();
		btn.setBackground(Color.decode("#FFF8DC"));
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(true);
		btn.setFocusPainted(false);
		btn.setOpaque(false);
		btn.setToolTipText("BOTON " + texto + ".");
		ImageIcon icono = new ImageIcon(url);
		btn.setIcon(icono);
		btn.setBounds(x, y, ancho, alto);
		return btn;
	}

	public JTextField generarEscritura(int x, int y, int ancho, int alto) {
		JTextField txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Banschrift", Font.BOLD, 15));
		txt.setBounds(x, y, ancho, alto);
		return txt;
	}

	public JComboBox generarGenero(int x, int y, int ancho, int alto) {
		String[] genero = { "Hombre", "Mujer" };

		JComboBox box = new JComboBox(genero);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Banschrift", Font.BOLD, 15));
		return box;
	}

	public void paintComponent(Graphics i) {
		super.paintComponent(i);
		int ancho = 1000;
		int alto = 565;
		i.drawImage(imagen.getImage(), 0, 0, ancho, alto, this);
	}
}
