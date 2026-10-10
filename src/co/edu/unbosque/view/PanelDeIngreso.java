/**
 * package in charge of storing the entire graphical user interface
*/
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Class for user input
 */
public class PanelDeIngreso extends JPanel{
	
	/**
	 * Label for displaying "Id".
	 */
	private JLabel lblId;

	/**
	 * Text field for entering "Id".
	 */
	private JTextField txtId;

	/**
	 * Label for displaying "Contraseña".
	 */
	private JLabel lblContrasenia;

	/**
	 * Text field for entering "Contraseña".
	 */
	private JTextField txtContrasenia;

	/**
	 * Button for registration.
	 */
	private JButton btnRegistrarse;

	/**
	 * Label for displaying "Registrarse".
	 */
	private JLabel lblRegistrarse;

	/**
	 * Button for continuing.
	 */
	private JButton btnContinuar;

	/**
	 * Label for displaying "Continuar".
	 */
	private JLabel lblContinuar;

	/**
	 * Label for displaying information.
	 */
	private JLabel lblInfo;

	/**
	 * Background image.
	 */
	private ImageIcon fondo;

	
	/**
	 *class constructor PanelDeIngreso
	 */
	public PanelDeIngreso() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY); 
		
	

		JLabel lblTitulo = new JLabel("INCIAR SESION");
		fondo = new ImageIcon("fotos/PanelIngreso.png");
		
		lblTitulo.setBounds(330, -20, 500, 200);
		lblTitulo.setFont(new Font("Coolvetica Rg", Font.BOLD, 45));
		lblTitulo.setForeground(Color.white);
		
		lblId = generarMensaje("Nombre De Usuario:", 170, 150, 500, 100);
		txtId = generarEscritura(590, 185, 200, 40);
		
		lblContrasenia = generarMensaje("Contraseña:",170, 250, 500, 100 );
		txtContrasenia = generarEscritura(590, 280, 200, 40);

		btnRegistrarse = generarBoton("REGISTRARSE",930, 500, 40, 40,"fotos/botonRegistro.png");
		lblRegistrarse = generarMensaje("Registrarse",780, 470, 200, 100);
		lblRegistrarse.setFont(new Font("Banschrift", Font.BOLD, 25));
		
		
		lblInfo= generarMensaje("Si no cuenta con un usuario, por favor presione el boton registrarse",180, 320, 700, 100);
		lblInfo.setFont(new Font("Banschrift", Font.BOLD, 20));

		btnContinuar = generarBoton("Iniciar sesión",530, 435, 40, 40,"fotos/botonLogin.png");
		lblContinuar = generarMensaje("Iniciar sesión",345, 405, 500, 100);
		lblContinuar.setFont(new Font("Banschrift", Font.BOLD, 25));
		
		add(lblTitulo);
		add(lblId);
		add(txtId);
		add(lblContrasenia);
		add(txtContrasenia);
		add(btnRegistrarse);
		add(lblRegistrarse);
		add(btnContinuar);
		add(lblContinuar);
		add(lblInfo);
	}
	
	/**
	 * Generates a button with the specified properties.
	 * 
	 * @param toolTip The tooltip text for the button.
	 * @param x       The x-coordinate of the button.
	 * @param y       The y-coordinate of the button.
	 * @param ancho   The width of the button.
	 * @param alto    The height of the button.
	 * @param url     The URL of the icon for the button.
	 * @return The generated JButton.
	 */
	public JButton generarBoton(String toolTip, int x, int y, int ancho, int alto, String url) {
		JButton btn = new JButton();
		btn.setBackground(Color.decode("#FFF8DC"));
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(true);
		btn.setFocusPainted(false);
		btn.setOpaque(false);
		btn.setToolTipText("BOTON " + toolTip + ".");
		ImageIcon icono = new ImageIcon(url);
		btn.setIcon(icono);
		btn.setBounds(x, y, ancho, alto);
		return btn;
	}
	/**
	 * Generates a text field with the specified properties.
	 * 
	 * @param x     The x-coordinate of the text field.
	 * @param y     The y-coordinate of the text field.
	 * @param ancho The width of the text field.
	 * @param alto  The height of the text field.
	 * @return The generated JTextField.
	 */
	public JTextField generarEscritura(int x, int y, int ancho, int alto) {
		JTextField txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Banschrift", Font.BOLD, 25));
		txt.setBounds(x, y, ancho, alto);
		return txt;
	}
	/**
	 * Generates a label with the specified properties.
	 * 
	 * @param texto  The text to display on the label.
	 * @param x      The x-coordinate of the label.
	 * @param y      The y-coordinate of the label.
	 * @param ancho  The width of the label.
	 * @param alto   The height of the label.
	 * @return The generated JLabel.
	 */
	public JLabel generarMensaje(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setForeground(Color.WHITE);
		lbl.setFont(new Font("Banschrift", Font.BOLD, 25));
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}

/**
 * Overrides the paintComponent method to draw a background image.
 * 
 * @param g The Graphics context.
 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(fondo.getImage(), 0,0, ancho, alto, this);
	}

/**
 * @return the lblId
 */
public JLabel getLblId() {
	return lblId;
}

/**
 * @param lblId the lblId to set
 */
public void setLblId(JLabel lblId) {
	this.lblId = lblId;
}

/**
 * @return the txtId
 */
public JTextField getTxtId() {
	return txtId;
}

/**
 * @param txtId the txtId to set
 */
public void setTxtId(JTextField txtId) {
	this.txtId = txtId;
}

/**
 * @return the lblContrasenia
 */
public JLabel getLblContrasenia() {
	return lblContrasenia;
}

/**
 * @param lblContrasenia the lblContrasenia to set
 */
public void setLblContrasenia(JLabel lblContrasenia) {
	this.lblContrasenia = lblContrasenia;
}

/**
 * @return the txtContrasenia
 */
public JTextField getTxtContrasenia() {
	return txtContrasenia;
}

/**
 * @param txtContrasenia the txtContrasenia to set
 */
public void setTxtContrasenia(JTextField txtContrasenia) {
	this.txtContrasenia = txtContrasenia;
}

/**
 * @return the btnRegistrarse
 */
public JButton getBtnRegistrarse() {
	return btnRegistrarse;
}

/**
 * @param btnRegistrarse the btnRegistrarse to set
 */
public void setBtnRegistrarse(JButton btnRegistrarse) {
	this.btnRegistrarse = btnRegistrarse;
}

/**
 * @return the lblRegistrarse
 */
public JLabel getLblRegistrarse() {
	return lblRegistrarse;
}

/**
 * @param lblRegistrarse the lblRegistrarse to set
 */
public void setLblRegistrarse(JLabel lblRegistrarse) {
	this.lblRegistrarse = lblRegistrarse;
}

/**
 * @return the btnContinuar
 */
public JButton getBtnContinuar() {
	return btnContinuar;
}

/**
 * @param btnContinuar the btnContinuar to set
 */
public void setBtnContinuar(JButton btnContinuar) {
	this.btnContinuar = btnContinuar;
}

/**
 * @return the lblContinuar
 */
public JLabel getLblContinuar() {
	return lblContinuar;
}

/**
 * @param lblContinuar the lblContinuar to set
 */
public void setLblContinuar(JLabel lblContinuar) {
	this.lblContinuar = lblContinuar;
}

/**
 * @return the lblInfo
 */
public JLabel getLblInfo() {
	return lblInfo;
}

/**
 * @param lblInfo the lblInfo to set
 */
public void setLblInfo(JLabel lblInfo) {
	this.lblInfo = lblInfo;
}

/**
 * @return the fondo
 */
public ImageIcon getFondo() {
	return fondo;
}

/**
 * @param fondo the fondo to set
 */
public void setFondo(ImageIcon fondo) {
	this.fondo = fondo;
}
	

	
	
}