/**
 * package in charge of storing the entire graphical user interface
*/
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

/**
 * Class containing elements of the masseuse update form
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */

public class PanelActualizarMasajista extends JPanel {

	/**
	 * Text field for the new username.
	 */
	private JTextField nuevoNombreUsuario;

	/**
	 * Text field for the new name.
	 */
	private JTextField nuevoNombre;

	/**
	 * Text field for the new ID number.
	 */
	private JTextField nuevaCedula;

	/**
	 * Dropdown box for selecting gender.
	 */
	private JComboBox boxGenero;

	/**
	 * Text field for the years of experience.
	 */
	private JTextField AniosDeExperiencia;

	/**
	 * Text field for the email address.
	 */
	private JTextField correoElectronico;

	/**
	 * Text field for the password.
	 */
	private JTextField contrasenia;

	/**
	 * Button to navigate back.
	 */
	private JButton btnvolver;

	/**
	 * Button to update the information.
	 */
	private JButton btnActualizar;

	/**
	 * Image associated with the form.
	 */
	private ImageIcon imagen;

	/**
	 * Constructor for the PanelActualizarMasajista class.
	 */
	public PanelActualizarMasajista() {

		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);

		JLabel lblTitulo = new JLabel("ActualizarMasajista");
		imagen = new ImageIcon("fotos/ActualizarMasajista.png");

		nuevoNombreUsuario = generarEscritura(375, 148, 250, 30);
		nuevoNombre = generarEscritura(375, 198, 250, 30);
		nuevaCedula = generarEscritura(375, 252, 250, 30);
		boxGenero = generarGenero(375, 302, 250, 30);
		AniosDeExperiencia = generarEscritura(375, 352, 250, 30);
		correoElectronico = generarEscritura(375, 404, 250, 30);
		contrasenia = generarEscritura(375, 455, 250, 30);

		btnActualizar = generarBoton("Registrar", 880, 500, 50, 50, "fotos/rueda.png");
		btnvolver = generarBoton("volver", 156, 505, 50, 50, "fotos/botonVolver.png");
		add(btnActualizar);
		add(nuevoNombreUsuario);
		add(nuevoNombre);
		add(nuevaCedula);
		add(boxGenero);
		add(AniosDeExperiencia);
		add(contrasenia);
		add(correoElectronico);
		add(btnvolver);

	}

	/**
	 * Clears the information in the update panel for a masseur.
	 */

	public void lipiarInfoActualizarM() {
		nuevoNombre.setText("");
		AniosDeExperiencia.setText("");
	}

	/**
	 * Generates a button with the specified text, position, size, and image.
	 * 
	 * @param texto The text to be displayed on the button.
	 * @param x     The x-coordinate of the button.
	 * @param y     The y-coordinate of the button.
	 * @param ancho The width of the button.
	 * @param alto  The height of the button.
	 * @param url   The file path or URL to the image for the button.
	 * @return A JButton with the specified properties.
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
	 * Generates a text field with the specified position, size, and font.
	 * 
	 * @param x     The x-coordinate of the text field.
	 * @param y     The y-coordinate of the text field.
	 * @param ancho The width of the text field.
	 * @param alto  The height of the text field.
	 * @return A JTextField with the specified properties.
	 */
	public JTextField generarEscritura(int x, int y, int ancho, int alto) {
		JTextField txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Banschrift", Font.BOLD, 15));
		txt.setBounds(x, y, ancho, alto);
		return txt;
	}

	/**
	 * Generates a JComboBox with predefined gender options at the specified
	 * position, size, and font.
	 * 
	 * @param x     The x-coordinate of the combo box.
	 * @param y     The y-coordinate of the combo box.
	 * @param ancho The width of the combo box.
	 * @param alto  The height of the combo box.
	 * @return A JComboBox for selecting gender with the specified properties.
	 */
	public JComboBox generarGenero(int x, int y, int ancho, int alto) {
		String[] genero = { "Hombre", "Mujer" };

		JComboBox box = new JComboBox(genero);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Banschrift", Font.BOLD, 15));
		return box;
	}

	/**
	 * Overrides the paintComponent method to paint the background image.
	 * 
	 * @param i The Graphics context in which to paint.
	 */
	@Override
	public void paintComponent(Graphics i) {
		super.paintComponent(i);
		int ancho = 1000;
		int alto = 565;
		i.drawImage(imagen.getImage(), 0, 0, ancho, alto, this);
	}

	/**
	 * @return the nuevoNombreUsuario
	 */
	public JTextField getNuevoNombreUsuario() {
		return nuevoNombreUsuario;
	}

	/**
	 * @param nuevoNombreUsuario the nuevoNombreUsuario to set
	 */
	public void setNuevoNombreUsuario(JTextField nuevoNombreUsuario) {
		this.nuevoNombreUsuario = nuevoNombreUsuario;
	}

	/**
	 * @return the nuevoNombre
	 */
	public JTextField getNuevoNombre() {
		return nuevoNombre;
	}

	/**
	 * @param nuevoNombre the nuevoNombre to set
	 */
	public void setNuevoNombre(JTextField nuevoNombre) {
		this.nuevoNombre = nuevoNombre;
	}

	/**
	 * @return the nuevaCedula
	 */
	public JTextField getNuevaCedula() {
		return nuevaCedula;
	}

	/**
	 * @param nuevaCedula the nuevaCedula to set
	 */
	public void setNuevaCedula(JTextField nuevaCedula) {
		this.nuevaCedula = nuevaCedula;
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
	 * @return the aniosDeExperiencia
	 */
	public JTextField getAniosDeExperiencia() {
		return AniosDeExperiencia;
	}

	/**
	 * @param aniosDeExperiencia the aniosDeExperiencia to set
	 */
	public void setAniosDeExperiencia(JTextField aniosDeExperiencia) {
		AniosDeExperiencia = aniosDeExperiencia;
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
	 * @return the contrasenia
	 */
	public JTextField getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia the contrasenia to set
	 */
	public void setContrasenia(JTextField contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * @return the btnvolver
	 */
	public JButton getBtnvolver() {
		return btnvolver;
	}

	/**
	 * @param btnvolver the btnvolver to set
	 */
	public void setBtnvolver(JButton btnvolver) {
		this.btnvolver = btnvolver;
	}

	/**
	 * @return the btnActualizar
	 */
	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	/**
	 * @param btnActualizar the btnActualizar to set
	 */
	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
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

}
