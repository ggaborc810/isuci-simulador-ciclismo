package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelRegistro extends JPanel {
	private JLabel lblNombre;
	private JLabel lblCedula;
	private JLabel lblGenero;
	private JLabel lblCorreoElectronico;
	private JLabel lblId;
	private JLabel lblContrasenia;
	private JLabel lblEnviar;
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtGenero;
	private JTextField txtCorreoElectronico;
	private JTextField txtId;
	private JTextField txtContrasenia;
	private JButton btnEnviar;
	private ImageIcon fondo;
	private JComboBox boxGenero;
	private JButton btnVolver;
	private JLabel lblVolver;
	private JRadioButton rbtnCiclista;
	private JRadioButton rbtnMasajista;
	private JRadioButton rbtnAdministrativo;
	private JRadioButton rbtnDirector;

	public PanelRegistro() {

		setSize(1000, 600);
		setLayout(null);
		setBackground(Color.white);
		
		fondo = new ImageIcon("fotos/PanelRegistro.png");
		
		btnEnviar = generarBoton("enviar", 270, 430, 40, 40, "fotos/botonRueda.png");
		lblEnviar = generarLabel("Registrarse", 70, 0, 899, 899);
		
		
		lblCedula = generarLabel("Cedula :", 70, -350, 899, 899);
		txtCedula = generarEscritura(220, 88, 200, 30);
		
	
		lblGenero = generarLabel("Genero :", 70, -290, 899, 899);
		boxGenero = generarGenero(220, 145, 200, 30);
		
		lblCorreoElectronico = generarLabel("Correo electronico:", 70, -230, 899, 899);
		txtCorreoElectronico = generarEscritura(405, 207, 200, 30);
		
		lblId = generarLabel("Nombre de usuario:", 70, -170, 899, 899);
		txtId = generarEscritura(405, 268, 200, 30);
		
		lblContrasenia = generarLabel("Contraseña :", 70, -110, 899, 899);
		txtContrasenia = generarEscritura(300, 325, 200, 30);
		
		btnVolver = generarBoton("Volver", 30, 490, 50, 50,"fotos/botonVolver.png");
		lblVolver = generarLabel("Volver",90,500,100,30);
		lblVolver.setFont(new Font("Coolvetica Rg", Font.BOLD, 30));
		
		ButtonGroup grupoBotones = new ButtonGroup();
		
		rbtnCiclista = generarRadioBoton("Ciclista",70, 370, 200,30);
		rbtnMasajista = generarRadioBoton("Masajista",270,370, 200,30);
		rbtnAdministrativo = generarRadioBoton("Administrativo", 470, 370, 200, 30);
		rbtnDirector = generarRadioBoton("Director", 670, 370, 150,30);

		
		add(rbtnCiclista).setVisible(true);
		add(rbtnMasajista).setVisible(true);
		add(rbtnAdministrativo).setVisible(true);
		add(rbtnDirector).setVisible(true);	
		
		add(lblCedula);
		add(lblGenero);
		add(lblCorreoElectronico);
		add(lblId);
		add(lblContrasenia);
		add(lblEnviar);
		add(txtCedula);
		add(txtCorreoElectronico);
		add(txtId);
		add(txtContrasenia);
		add(btnEnviar);
		add(boxGenero);
		add(btnVolver);
		add(lblVolver);
		
		grupoBotones.add(rbtnCiclista);
        grupoBotones.add(rbtnMasajista);
        grupoBotones.add(rbtnAdministrativo);
        grupoBotones.add(rbtnDirector);

        
		repaint();
		
	}
	

	
	public JComboBox generarGenero(int x, int y, int ancho, int alto) {
		String[] genero = {"Hombre", "Mujer" };

		JComboBox box = new JComboBox(genero);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Banschrift", Font.BOLD, 15));
		return box;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(fondo.getImage(), 0,0, ancho, alto, this);
	}
	

	public JLabel generarLabel(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Coolvetica Rg", Font.BOLD, 35));
		lbl.setBackground(Color.WHITE);
		lbl.setForeground(Color.white);
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}
	
	public JTextField generarEscritura(int x, int y, int ancho, int alto) {
		JTextField txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Coolvetica Rg", Font.BOLD, 13));
		txt.setBounds(x, y, ancho, alto);
		return txt;
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

	public JRadioButton generarRadioBoton(String texto, int x, int y, int ancho, int alto) {
		JRadioButton rbtn = new JRadioButton(texto);
		rbtn.setBounds(x, y, ancho, alto);
		rbtn.setBackground(Color.white);
		rbtn.setForeground(Color.white);
		rbtn.setBorderPainted(false);
		rbtn.setContentAreaFilled(true);
		rbtn.setFocusPainted(false);
		rbtn.setOpaque(false);
		rbtn.setFont(new Font("Banschrift", Font.BOLD, 16));
		return rbtn;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblCedula() {
		return lblCedula;
	}

	public void setLblCedula(JLabel lblCedula) {
		this.lblCedula = lblCedula;
	}

	public JLabel getLblGenero() {
		return lblGenero;
	}

	public void setLblGenero(JLabel lblGenero) {
		this.lblGenero = lblGenero;
	}

	public JLabel getLblCorreoElectronico() {
		return lblCorreoElectronico;
	}

	public void setLblCorreoElectronico(JLabel lblCorreoElectronico) {
		this.lblCorreoElectronico = lblCorreoElectronico;
	}

	public JLabel getLblId() {
		return lblId;
	}

	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}

	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	public JLabel getLblEnviar() {
		return lblEnviar;
	}

	public void setLblEnviar(JLabel lblEnviar) {
		this.lblEnviar = lblEnviar;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtCedula() {
		return txtCedula;
	}

	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
	}

	public JTextField getTxtGenero() {
		return txtGenero;
	}

	public void setTxtGenero(JTextField txtGenero) {
		this.txtGenero = txtGenero;
	}

	public JTextField getTxtCorreoElectronico() {
		return txtCorreoElectronico;
	}

	public void setTxtCorreoElectronico(JTextField txtCorreoElectronico) {
		this.txtCorreoElectronico = txtCorreoElectronico;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtContrasenia() {
		return txtContrasenia;
	}

	public void setTxtContrasenia(JTextField txtContrasenia) {
		this.txtContrasenia = txtContrasenia;
	}

	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public void setBtnEnviar(JButton btnEnviar) {
		this.btnEnviar = btnEnviar;
	}

	public ImageIcon getFondo() {
		return fondo;
	}

	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	public JComboBox getBoxGenero() {
		return boxGenero;
	}

	public void setBoxGenero(JComboBox boxGenero) {
		this.boxGenero = boxGenero;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JLabel getLblVolver() {
		return lblVolver;
	}

	public void setLblVolver(JLabel lblVolver) {
		this.lblVolver = lblVolver;
	}



	public JRadioButton getRbtnCiclista() {
		return rbtnCiclista;
	}



	public void setRbtnCiclista(JRadioButton rbtnCiclista) {
		this.rbtnCiclista = rbtnCiclista;
	}



	public JRadioButton getRbtnMasajista() {
		return rbtnMasajista;
	}



	public void setRbtnMasajista(JRadioButton rbtnMasajista) {
		this.rbtnMasajista = rbtnMasajista;
	}



	public JRadioButton getRbtnAdministrativo() {
		return rbtnAdministrativo;
	}



	public void setRbtnAdministrativo(JRadioButton rbtnAdministrativo) {
		this.rbtnAdministrativo = rbtnAdministrativo;
	}



	public JRadioButton getRbtnDirector() {
		return rbtnDirector;
	}



	public void setRbtnDirector(JRadioButton rbtnDirector) {
		this.rbtnDirector = rbtnDirector;
	}
	
	
	
}
