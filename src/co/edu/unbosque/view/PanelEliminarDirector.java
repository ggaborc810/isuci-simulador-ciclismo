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
 * Panel used for deleting a director.
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelEliminarDirector extends JPanel {

	/**
	 * Text field for entering the director's username.
	 */
	private JTextField txtNombreUsuario;

	/**
	 * Button for navigating back.
	 */
	private JButton btnVolver;

	/**
	 * Image displayed on the panel.
	 */
	private ImageIcon imagen;

	/**
	 * Button for sending the delete request.
	 */
	private JButton btnEnviar;

	/**
	 * Constructor to initialize the panel.
	 */
	public PanelEliminarDirector() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);

		txtNombreUsuario = generarEscritura(340, 292, 280, 30);

		btnVolver = generarBoton("Volver de crear director", 170, 510, 50, 50, "fotos/botonVolver.png");
		btnEnviar = generarBoton("Enviar informacion director", 850, 515, 100, 35, "fotos/rueda.png");

		imagen = new ImageIcon("fotos/EliminarDirector.png");

		add(txtNombreUsuario);
		add(btnVolver);
		add(btnEnviar);
		repaint();

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
	 * Method to paint the image on the panel.
	 * 
	 * @param g The graphics context.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(imagen.getImage(), 0, -20, ancho, alto, this);
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
	 * @return the btnEnviar
	 */
	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	/**
	 * @param btnEnviar the btnEnviar to set
	 */
	public void setBtnEnviar(JButton btnEnviar) {
		this.btnEnviar = btnEnviar;
	}

}