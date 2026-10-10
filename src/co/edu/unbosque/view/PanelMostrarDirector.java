
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
 * Panel for displaying director information.
 * 
 * @autor Juan Diego Triana Mejía
 * 
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelMostrarDirector extends JPanel {

	/**
	 * Text field for entering the username.
	 */
	private JTextField txtNombreUsuario;

	/**
	 * Text field for entering the full name.
	 */
	private JTextField txtNombreCompleto;

	/**
	 * Text field for entering the ID number.
	 */
	private JTextField txtNumeroCedula;

	/**
	 * Combo box for selecting gender.
	 */
	private JComboBox boxGenero;

	/**
	 * Text field for entering the email address.
	 */
	private JTextField txtCorreoElectronico;

	/**
	 * Text field for entering the nationality.
	 */
	private JTextField txtNacionalidad;

	/**
	 * Text field for entering the password.
	 */
	private JTextField txtContrasenia;

	/**
	 * Button for navigating back.
	 */
	private JButton btnVolver;

	/**
	 * Image for the panel.
	 */
	private ImageIcon imagen;

	/**
	 * Constructs a PanelMostrarDirector with the necessary components.
	 */
	public PanelMostrarDirector() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);

		txtNombreUsuario = generarEscritura(240, 178, 240, 30);
		txtNombreCompleto = generarEscritura(240, 236, 240, 30);
		txtNumeroCedula = generarEscritura(240, 296, 240, 30);
		boxGenero = generarGenero(240, 356, 240, 30);
		txtNacionalidad = generarEscritura(240, 415, 240, 30);
		txtCorreoElectronico = generarEscritura(745, 241, 185, 30);
		txtContrasenia = generarEscritura(745, 305, 185, 30);

		btnVolver = generarBoton("Volver de crear director", 150, 510, 50, 50, "fotos/botonVolver.png");

		imagen = new ImageIcon("fotos/mostrarDirector.png");

		add(txtNombreUsuario);
		add(txtNombreCompleto);
		add(txtNumeroCedula);
		add(boxGenero);
		add(txtCorreoElectronico);
		add(txtNacionalidad);
		add(txtContrasenia);
		add(btnVolver);
		repaint();

	}

	/**
	 * Generates a JButton with the specified properties.
	 *
	 * @param texto Button text.
	 * @param x     X coordinate.
	 * @param y     Y coordinate.
	 * @param ancho Button width.
	 * @param alto  Button height.
	 * @param url   URL of the button icon.
	 * @return JButton object with the specified properties.
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
	 * Generates a JTextField with the specified properties.
	 *
	 * @param x     X coordinate.
	 * @param y     Y coordinate.
	 * @param ancho TextField width.
	 * @param alto  TextField height.
	 * @return JTextField object with the specified properties.
	 */
	public JTextField generarEscritura(int x, int y, int ancho, int alto) {
		JTextField txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Banschrift", Font.BOLD, 15));
		txt.setBounds(x, y, ancho, alto);
		return txt;
	}

	/**
	 * Generates a JComboBox for selecting gender with the specified properties.
	 *
	 * @param x     X coordinate.
	 * @param y     Y coordinate.
	 * @param ancho ComboBox width.
	 * @param alto  ComboBox height.
	 * @return JComboBox object with the specified properties.
	 */
	public JComboBox generarGenero(int x, int y, int ancho, int alto) {
		String[] genero = { "Hombre", "Mujer" };

		JComboBox box = new JComboBox(genero);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Banschrift", Font.BOLD, 15));
		return box;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(imagen.getImage(), 0, 0, ancho, alto, this);
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

} 