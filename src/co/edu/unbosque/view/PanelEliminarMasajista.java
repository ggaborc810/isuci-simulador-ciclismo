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
 * Panel used for deleting a masseur.
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelEliminarMasajista extends JPanel {
	/**
	 * Text field for entering the masseur's username to delete.
	 */
	private JTextField nombreUsuarioEliminar;

	/**
	 * Button for initiating the deletion process.
	 */
	private JButton btneliminar;

	/**
	 * Button for navigating back.
	 */
	private JButton btnVolver;

	/**
	 * Image displayed on the panel.
	 */
	private ImageIcon imagen;

	/**
	 * Constructor to initialize the panel.
	 */

	public PanelEliminarMasajista() {

		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);

		imagen = new ImageIcon("fotos/EliminarMasajista.png");

		nombreUsuarioEliminar = generarEscritura(190, 300, 300, 30);
		btneliminar = generarBoton("Eliminar", 850, 490, 50, 50, "fotos/rueda.png");
		btnVolver = generarBoton("volver", 160, 365, 50, 300, "fotos/botonVolver.png");

		add(nombreUsuarioEliminar);
		add(btneliminar);
		add(btnVolver);

	}

	/**
	 * Method to generate a JButton with specified properties.
	 * 
	 * @param texto The text displayed on the button.
	 * @param x     The x-coordinate of the button.
	 * @param y     The y-coordinate of the button.
	 * @param ancho The width of the button.
	 * @param alto  The height of the button.
	 * @param url   The URL of the icon for the button.
	 * @return The generated JButton.
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
	 * Method to generate a JTextField with specified properties.
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
		txt.setFont(new Font("Banschrift", Font.BOLD, 15));
		txt.setBounds(x, y, ancho, alto);
		return txt;
	}

	/**
	 * Generates a JComboBox for selecting gender.
	 * 
	 * @param x     The x-coordinate of the JComboBox.
	 * @param y     The y-coordinate of the JComboBox.
	 * @param ancho The width of the JComboBox.
	 * @param alto  The height of the JComboBox.
	 * @return A JComboBox for selecting gender.
	 */
	public JComboBox generarGenero(int x, int y, int ancho, int alto) {
		String[] genero = { "Hombre", "Mujer" };

		JComboBox box = new JComboBox(genero);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Banschrift", Font.BOLD, 15));
		return box;
	}

	/**
	 * Method to paint the image on the panel.
	 * 
	 * @param g The graphics context.
	 */
	public void paintComponent(Graphics i) {
		super.paintComponent(i);
		int ancho = 1000;
		int alto = 565;
		i.drawImage(imagen.getImage(), 0, 0, ancho, alto, this);
	}

	/**
	 * @return the nombreUsuarioEliminar
	 */
	public JTextField getNombreUsuarioEliminar() {
		return nombreUsuarioEliminar;
	}

	/**
	 * @param nombreUsuarioEliminar the nombreUsuarioEliminar to set
	 */
	public void setNombreUsuarioEliminar(JTextField nombreUsuarioEliminar) {
		this.nombreUsuarioEliminar = nombreUsuarioEliminar;
	}

	/**
	 * @return the btneliminar
	 */
	public JButton getBtneliminar() {
		return btneliminar;
	}

	/**
	 * @param btneliminar the btneliminar to set
	 */
	public void setBtneliminar(JButton btneliminar) {
		this.btneliminar = btneliminar;
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
