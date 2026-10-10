/**
 * package in charge of storing the entire graphical user interface
*/


package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * class to eliminate squad
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */

public class PanelEliminarEscuadra extends JPanel {
	public JTextField getTxtEliminarEscuadra() {
		return txtEliminarEscuadra;
	}


	public void setTxtEliminarEscuadra(JTextField txtEliminarEscuadra) {
		this.txtEliminarEscuadra = txtEliminarEscuadra;
	}


	public JButton getBtnVolver() {
		return btnVolver;
	}


	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}


	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	/**
	 * A text field for entering the identifier of the squad to be deleted.
	 */
	private JTextField txtEliminarEscuadra;

	/**
	 * A button that allows the user to return to the previous screen.
	 */
	private JButton btnVolver;

	/**
	 * A button that initiates the deletion of the squad.
	 */
	private JButton btnEliminar;
	
	/**
	 * The background image to be displayed on the component.
	 */

	private ImageIcon imagen;

	/**
	 * Constructor of the PanelDeleteSquare class
	 */

	public PanelEliminarEscuadra() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.gray);
		
		txtEliminarEscuadra = generarEscritura(370, 173, 280, 30);
		btnVolver = generarBoton("Volver", 160, 505, 50, 50, "fotos/botonVolver.png");
		btnEliminar = generarBoton("Eliminar", 880, 515, 35, 35, "fotos/rueda.png");
		imagen = new ImageIcon("fotos/PanelEliminarEscuadra.png");
		
		
		add(txtEliminarEscuadra);
		add(btnVolver);
		add(btnEliminar);
	}
	
	
	/**
	 * Overrides the paintComponent method to draw the image on the panel.
	 * 
	 * @param g The Graphics context.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(imagen.getImage(), 0, -20, ancho, alto, this);
	}

	/**
	 * Generates a JButton with specified properties.
	 * 
	 * @param texto The text to be displayed on the button.
	 * @param x     The x-coordinate of the button.
	 * @param y     The y-coordinate of the button.
	 * @param ancho The width of the button.
	 * @param alto  The height of the button.
	 * @param url   The URL of the icon to be displayed on the button.
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
	 * Generates a JTextField with specified properties.
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
