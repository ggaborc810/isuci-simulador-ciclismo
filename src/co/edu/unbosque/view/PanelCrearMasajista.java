/**
 * package in charge of storing the entire graphical user interface
*/
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Class containing components to create a massage therapist
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelCrearMasajista extends JPanel {

	/**
	 * Text field for entering the username.
	 */
	private JTextField nombreUsuario;

	/**
	 * Text field for entering the name.
	 */
	private JTextField nombre;

	/**
	 * Text field for entering the ID number.
	 */
	private JTextField cedula;

	/**
	 * Combo box for selecting gender.
	 */
	private JComboBox genero;

	/**
	 * Text field for entering years of experience.
	 */
	private JTextField AniosDeExperiencia;

	/**
	 * Text field for entering email.
	 */
	private JTextField correoElectronico;

	/**
	 * Text field for entering password.
	 */
	private JTextField contrasenia;

	/**
	 * Button for returning to the previous screen.
	 */
	private JButton btnvolver;

	/**
	 * Button for registering.
	 */
	private JButton btnRegistrarse;

	/**
	 * Image icon.
	 */
	private ImageIcon imagen;
/**
 *Class constructor PanelCrearMasajista
 */
	public PanelCrearMasajista() {

		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);

		JLabel lblTitulo = new JLabel("CrearMasajista");
		imagen = new ImageIcon("fotos/CrearMasajista.png");

		nombreUsuario = generarEscritura(350, 105, 250, 30);
		nombre = generarEscritura(350, 162, 250, 30);
		cedula = generarEscritura(350, 217, 250, 30);
		genero = generarGenero(350, 274, 250, 30);
		AniosDeExperiencia = generarEscritura(350, 332, 250, 30);
		correoElectronico = generarEscritura(350, 385, 250, 30);
		contrasenia = generarEscritura(350, 442, 250, 30);
		btnRegistrarse = generarBoton("Registrar",850,485,50,50, "fotos/rueda.png");
        btnvolver = generarBoton("volver",145, 488, 50, 50,"fotos/botonVolver.png");
		add(btnRegistrarse);
		add(nombreUsuario);
		add(nombre);
		add(cedula);
		add(genero);
		add(AniosDeExperiencia);
		add(contrasenia);
		add(correoElectronico);
		add(btnvolver);

	}
	
	/**
	 * Clears the information in the create screen.
	 */
	public void lipiarInfoCrearM() {
		nombre.setText("");
		AniosDeExperiencia.setText("");
	}


/**
 * Generates a button with the specified text, position, size, and image URL.
 * 
 * @param texto the text to display on the button
 * @param x     the x-coordinate of the button
 * @param y     the y-coordinate of the button
 * @param ancho the width of the button
 * @param alto  the height of the button
 * @param url   the URL of the image to set as the button icon
 * @return the generated JButton
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
	 * Generates a text field with the specified position and size.
	 * 
	 * @param x     the x-coordinate of the text field
	 * @param y     the y-coordinate of the text field
	 * @param ancho the width of the text field
	 * @param alto  the height of the text field
	 * @return the generated JTextField
	 */
	public JTextField generarEscritura(int x, int y, int ancho, int alto) {
		JTextField txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Banschrift", Font.BOLD, 15));
		txt.setBounds(x, y, ancho, alto);
		return txt;
	}

	/**
	 * Generates a combo box for selecting gender with the specified position and size.
	 * 
	 * @param x     the x-coordinate of the combo box
	 * @param y     the y-coordinate of the combo box
	 * @param ancho the width of the combo box
	 * @param alto  the height of the combo box
	 * @return the generated JComboBox
	 */
	public JComboBox generarGenero(int x, int y, int ancho, int alto) {
		String[] genero = { "Hombre", "Mujer" };

		JComboBox box = new JComboBox(genero);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Banschrift", Font.BOLD, 15));
		return box;
	}

	/**
	 * Paints the component with the specified graphics context.
	 * 
	 * @param i the Graphics object to paint on
	 */
	public void paintComponent(Graphics i) {
		super.paintComponent(i);
		int ancho = 1000;
		int alto = 565;
		i.drawImage(imagen.getImage(), 0, 0, ancho, alto, this);
	}

	/**
	 * @return the nombreUsuario
	 */
	public JTextField getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(JTextField nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the nombre
	 */
	public JTextField getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the cedula
	 */
	public JTextField getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(JTextField cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the genero
	 */
	public JComboBox getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(JComboBox genero) {
		this.genero = genero;
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
