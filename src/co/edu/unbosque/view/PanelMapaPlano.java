
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
 * class with components for the flat map * @autor Juan Diego Triana Mejía
 * 
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelMapaPlano extends JPanel {

	/** ImageIcon for the background image. */
	private ImageIcon imagen;

	/** JButton for initiating an action. */
	private JButton btnIniciar;

	/** JButton for continuing an action. */
	private JButton btnContinuar;

	/** JButton for going back to the previous screen. */
	private JButton btnVolver;

	/** JLabel for the "Iniciar" button text. */
	private JLabel lblIniciar;

	/** JLabel for the "Volver" button text. */
	private JLabel lblVolver;

	/** JLabel for the "Continuar" button text. */
	private JLabel lblContinuar;

	/**
	 * flat map panel builder
	 */
	public PanelMapaPlano() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);

		btnVolver = generarBoton("Volver", 40, 510, 50, 50, "fotos/botonVolver.png");
		btnIniciar = generarBoton("Iniciar", 475, 480, 30, 30, "fotos/rueda.png");
		btnContinuar = generarBoton("Continuar", 940, 515, 30, 30, "fotos/rueda.png");

		lblVolver = generarLabel("Volver", 95, 520, 100, 30);
		lblIniciar = generarLabel("Iniciar", 510, 480, 100, 30);
		lblContinuar = generarLabel("Continuar", 800, 515, 150, 30);

		imagen = new ImageIcon("fotos/20.png");

		add(btnVolver);
		add(btnIniciar);
		add(btnContinuar);
		add(lblVolver);
		add(lblIniciar);
		add(lblContinuar);
		repaint();

	}

	/**
	 * Generates a customized JButton.
	 * 
	 * @param texto The text to be displayed on the button.
	 * @param x     The x-coordinate of the button's position.
	 * @param y     The y-coordinate of the button's position.
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
	 * Generates a customized JLabel.
	 * 
	 * @param texto The text to be displayed on the label.
	 * @param x     The x-coordinate of the label's position.
	 * @param y     The y-coordinate of the label's position.
	 * @param ancho The width of the label.
	 * @param alto  The height of the label.
	 * @return The generated JLabel.
	 */
	public JLabel generarLabel(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Coolvetica Rg", Font.BOLD, 28));
		lbl.setBackground(Color.WHITE);
		lbl.setForeground(Color.white);
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}

	/**
	 * Generates a customized JTextField.
	 * 
	 * @param x     The x-coordinate of the text field's position.
	 * @param y     The y-coordinate of the text field's position.
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
	 * Overrides the paintComponent method to draw the background image.
	 * 
	 * @param g Graphics object used for drawing.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(imagen.getImage(), 0, -20, ancho, alto, this);
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
	 * @return the btnIniciar
	 */
	public JButton getBtnIniciar() {
		return btnIniciar;
	}

	/**
	 * @param btnIniciar the btnIniciar to set
	 */
	public void setBtnIniciar(JButton btnIniciar) {
		this.btnIniciar = btnIniciar;
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
	 * @return the lblIniciar
	 */
	public JLabel getLblIniciar() {
		return lblIniciar;
	}

	/**
	 * @param lblIniciar the lblIniciar to set
	 */
	public void setLblIniciar(JLabel lblIniciar) {
		this.lblIniciar = lblIniciar;
	}

	/**
	 * @return the lblVolver
	 */
	public JLabel getLblVolver() {
		return lblVolver;
	}

	/**
	 * @param lblVolver the lblVolver to set
	 */
	public void setLblVolver(JLabel lblVolver) {
		this.lblVolver = lblVolver;
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

}
