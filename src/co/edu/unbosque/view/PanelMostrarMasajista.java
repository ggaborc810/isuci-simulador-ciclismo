/**
package in charge of storing the entire graphical user interface
*/
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel for displaying massage therapist information.
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelMostrarMasajista extends JPanel {

	/**
	 * Text field for entering the user's username.
	 */
	private JTextField txtNombreUsuario;

	/**
	 * Text field for entering the name of the cyclist.
	 */
	private JTextField txtNombre;

	/**
	 * Text field for entering the ID number of the cyclist.
	 */
	private JTextField txtCedula;

	/**
	 * Combo box for selecting the gender of the cyclist.
	 */
	private JComboBox boxGenero;

	/**
	 * Text field for entering the years of experience of the cyclist.
	 */
	private JTextField aniosExperiencia;

	/**
	 * Text field for entering the email address of the cyclist.
	 */
	private JTextField correoElectronico;

	/**
	 * Text field for entering the password of the cyclist.
	 */
	private JTextField contraseña;

	/**
	 * Image to be displayed in the panel.
	 */
	private ImageIcon imagen;

	/**
	 * Button to return to the previous screen.
	 */
	private JButton btnVolver;

	/**
	 * Initializes and configures the panel for displaying massage therapist
	 * information.
	 */
	public PanelMostrarMasajista() {

		setSize(1000, 600);
		setLayout(null);
		setVisible(true);

		txtNombreUsuario = generarEscritura(300, 167, 220, 30);
		txtNombre = generarEscritura(300, 223, 220, 30);
		txtCedula = generarEscritura(300, 277, 220, 30);
		boxGenero = generarGenero(300, 334, 220, 30);
		aniosExperiencia = generarEscritura(300, 390, 230, 30);
		correoElectronico = generarEscritura(790, 223, 180, 30);
		contraseña = generarEscritura(790, 277, 180, 30);

		btnVolver = generarBoton("volver", 160, 485, 50, 50, "fotos/botonVolver.png");

		imagen = new ImageIcon("fotos/MostrarMasajista.png");

		add(txtNombreUsuario);
		add(txtNombre);
		add(txtCedula);
		add(boxGenero);
		add(aniosExperiencia);
		add(correoElectronico);
		add(contraseña);
		add(btnVolver);

	}

	/**
	 * Generates a JButton with specified attributes.
	 * 
	 * @param texto The text to be displayed on the button.
	 * @param x     The x-coordinate of the button.
	 * @param y     The y-coordinate of the button.
	 * @param ancho The width of the button.
	 * @param alto  The height of the button.
	 * @param url   The URL of the icon to be displayed on the button.
	 * @return The configured JButton.
	 */
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

	/**
	 * Generates a JTextField with specified attributes.
	 * 
	 * @param x     The x-coordinate of the text field.
	 * @param y     The y-coordinate of the text field.
	 * @param ancho The width of the text field.
	 * @param alto  The height of the text field.
	 * @return The configured JTextField.
	 */
	public JTextField generarEscritura(int x, int y, int ancho, int alto) {
		JTextField txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Banschrift", Font.BOLD, 15));
		txt.setBounds(x, y, ancho, alto);
		return txt;
	}

	/**
	 * Generates a JComboBox for selecting gender with specified attributes.
	 * 
	 * @param x     The x-coordinate of the combo box.
	 * @param y     The y-coordinate of the combo box.
	 * @param ancho The width of the combo box.
	 * @param alto  The height of the combo box.
	 * @return The configured JComboBox.
	 */
	public JComboBox generarGenero(int x, int y, int ancho, int alto) {
		String[] genero = { "Hombre", "Mujer" };

		JComboBox box = new JComboBox(genero);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Banschrift", Font.BOLD, 15));
		return box;
	}

	/**
	 * Paints the background image on the panel.
	 * 
	 * @param i The Graphics object.
	 */
	public void paintComponent(Graphics i) {
		super.paintComponent(i);
		int ancho = 1000;
		int alto = 565;
		i.drawImage(imagen.getImage(), 0, 0, ancho, alto, this);
	}

	/**
	 * @return the txtNombreUsuario
	 */
	public JTextField getTxtNombreUsuario() {
		return txtNombreUsuario;
	}

	/**
	 * @param txtNombreUsuario the txtNombreUsuario to set
	 */
	public void setTxtNombreUsuario(JTextField txtNombreUsuario) {
		this.txtNombreUsuario = txtNombreUsuario;
	}

	/**
	 * @return the txtNombre
	 */
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	/**
	 * @param txtNombre the txtNombre to set
	 */
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	/**
	 * @return the txtCedula
	 */
	public JTextField getTxtCedula() {
		return txtCedula;
	}

	/**
	 * @param txtCedula the txtCedula to set
	 */
	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
	}

	/**
	 * @return the boxGenero
	 */
	public JComboBox getBoxGenero() {
		return boxGenero;
	}

	/**
	 * @param boxGenero the boxGenero to set
	 */
	public void setBoxGenero(JComboBox boxGenero) {
		this.boxGenero = boxGenero;
	}

	/**
	 * @return the aniosExperiencia
	 */
	public JTextField getAniosExperiencia() {
		return aniosExperiencia;
	}

	/**
	 * @param aniosExperiencia the aniosExperiencia to set
	 */
	public void setAniosExperiencia(JTextField aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	/**
	 * @return the correoElectronico
	 */
	public JTextField getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * @param correoElectronico the correoElectronico to set
	 */
	public void setCorreoElectronico(JTextField correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	/**
	 * @return the contraseña
	 */
	public JTextField getContraseña() {
		return contraseña;
	}

	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(JTextField contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * @return the imagen
	 */
	public ImageIcon getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the btnVolver
	 */
	public JButton getBtnVolver() {
		return btnVolver;
	}

	/**
	 * @param btnVolver the btnVolver to set
	 */
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

}
