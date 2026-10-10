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
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *Class containing elements of the athletic director form
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelActualizarDirector extends JPanel {

	/**
	 * Text field for username.
	 */
	private JTextField txtNombreUsuario;

	/**
	 * Text field for full name.
	 */
	private JTextField txtNombreCompleto;

	/**
	 * Text field for the ID number.
	 */
	private JTextField txtNumeroCedula;

	/**
	 * Drop down box to select gender.
	 */
	private JComboBox boxGenero;

	/**
	 * Text field for email
	 */
	private JTextField txtCorreoElectronico;

	/**
	 * Text field for nationality.
	 */
	private JTextField txtNacionalidad;

	/**
	 * Text field for password.
	 */
	private JTextField txtContraseña;

	/**
	 * Back button.
	 */
	private JButton btnVolver;

	/**
	 * Image associated with the form.
	 */
	private ImageIcon imagen;

	/**
	 * Button to register information.
	 */
	private JButton btnRegistrar;

	/**
	 * Constructor for the PanelActualizarDirector class. Sets the size, layout,
	 * visibility, and background color of the panel. Initializes and sets the
	 * position of various GUI components such as text fields, combo boxes, and
	 * buttons.
	 */
	public PanelActualizarDirector() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);

		txtNombreUsuario = generarEscritura(375, 125, 230, 30);
		txtNombreCompleto = generarEscritura(375, 183, 230, 30);
		txtNumeroCedula = generarEscritura(375, 238, 230, 30);
		boxGenero = generarGenero(375, 294, 230, 30);
		txtCorreoElectronico = generarEscritura(375, 351, 230, 30);
		txtNacionalidad = generarEscritura(375, 407, 230, 30);
		txtContraseña = generarEscritura(375, 462, 230, 30);

		btnVolver = generarBoton("Volver de crear director", 125, 508, 50, 50, "fotos/botonVolver.png");
		btnRegistrar = generarBoton("Enviar informacion director", 915, 515, 35, 35, "fotos/rueda.png");

		imagen = new ImageIcon("fotos/ActualizarDirector.png");

		add(txtNombreUsuario);
		add(txtNombreCompleto);
		add(txtNumeroCedula);
		add(boxGenero);
		add(txtCorreoElectronico);
		add(txtNacionalidad);
		add(txtContraseña);
		add(btnVolver);
		add(btnRegistrar);
		repaint();

	}

	/**
	 * Clears the information in the text fields for updating director details.
	 */

	public void lipiarInfoActualizaD() {
		txtNombreCompleto.setText("");
		txtNacionalidad.setText("");
	}

	/**
	 * Generates a JButton with the specified parameters.
	 * 
	 * @param texto The text to be displayed on the button.
	 * @param x     The x-coordinate position of the button.
	 * @param y     The y-coordinate position of the button.
	 * @param ancho The width of the button.
	 * @param alto  The height of the button.
	 * @param url   The URL of the image for the button icon.
	 * @return JButton generated with the specified parameters.
	 */
	public JButton generarBoton(String texto, int x, int y, int ancho, int alto, String url) {
		JButton btn = new JButton();
		btn.setBackground(Color.decode("#FFF8DC"));
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(true);
		btn.setFocusPainted(false);
		btn.setOpaque(false);
		btn.setToolTipText("Boton " + texto + ".");
		ImageIcon icono = new ImageIcon(url);
		btn.setIcon(icono);
		btn.setBounds(x, y, ancho, alto);
		return btn;
	}

	/**
	 * Generates a JTextField with the specified parameters.
	 * 
	 * @param x     The x-coordinate position of the text field.
	 * @param y     The y-coordinate position of the text field.
	 * @param ancho The width of the text field.
	 * @param alto  The height of the text field.
	 * @return JTextField generated with the specified parameters.
	 */
	public JTextField generarEscritura(int x, int y, int ancho, int alto) {
		JTextField txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Banschrift", Font.BOLD, 15));
		txt.setBounds(x, y, ancho, alto);
		return txt;
	}

	/**
	 * Generates a JComboBox for selecting gender with the specified parameters.
	 * 
	 * @param x     The x-coordinate position of the combo box.
	 * @param y     The y-coordinate position of the combo box.
	 * @param ancho The width of the combo box.
	 * @param alto  The height of the combo box.
	 * @return JComboBox generated with the specified parameters.
	 */
	public JComboBox generarGenero(int x, int y, int ancho, int alto) {
		String[] genero = { "Hombre", "Mujer" };

		JComboBox box = new JComboBox(genero);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Banschrift", Font.BOLD, 15));
		return box;
	}

	/**
	 * Overrides the paintComponent method to paint the component with the specified
	 * graphics.
	 * 
	 * @param g The Graphics context in which to paint.
	 */

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(imagen.getImage(), 0, -5, ancho, alto, this);
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
	 * @return the txtNombreCompleto
	 */
	public JTextField getTxtNombreCompleto() {
		return txtNombreCompleto;
	}

	/**
	 * @param txtNombreCompleto the txtNombreCompleto to set
	 */
	public void setTxtNombreCompleto(JTextField txtNombreCompleto) {
		this.txtNombreCompleto = txtNombreCompleto;
	}

	/**
	 * @return the txtNumeroCedula
	 */
	public JTextField getTxtNumeroCedula() {
		return txtNumeroCedula;
	}

	/**
	 * @param txtNumeroCedula the txtNumeroCedula to set
	 */
	public void setTxtNumeroCedula(JTextField txtNumeroCedula) {
		this.txtNumeroCedula = txtNumeroCedula;
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
	 * @return the txtCorreoElectronico
	 */
	public JTextField getTxtCorreoElectronico() {
		return txtCorreoElectronico;
	}

	/**
	 * @param txtCorreoElectronico the txtCorreoElectronico to set
	 */
	public void setTxtCorreoElectronico(JTextField txtCorreoElectronico) {
		this.txtCorreoElectronico = txtCorreoElectronico;
	}

	/**
	 * @return the txtNacionalidad
	 */
	public JTextField getTxtNacionalidad() {
		return txtNacionalidad;
	}

	/**
	 * @param txtNacionalidad the txtNacionalidad to set
	 */
	public void setTxtNacionalidad(JTextField txtNacionalidad) {
		this.txtNacionalidad = txtNacionalidad;
	}

	/**
	 * @return the txtContraseña
	 */
	public JTextField getTxtContraseña() {
		return txtContraseña;
	}

	/**
	 * @param txtContraseña the txtContraseña to set
	 */
	public void setTxtContraseña(JTextField txtContraseña) {
		this.txtContraseña = txtContraseña;
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
	 * @return the btnRegistrar
	 */
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	/**
	 * @param btnRegistrar the btnRegistrar to set
	 */
	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

}