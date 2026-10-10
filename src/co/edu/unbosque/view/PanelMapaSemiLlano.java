/**
 * package in charge of storing the entire graphical user interface
*/
package co.edu.unbosque.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * class containing seed map components
 *  * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelMapaSemiLlano extends JPanel {

	/** ImageIcon para la imagen. */
	private ImageIcon imagen;

	/** JButton para iniciar. */
	private JButton btnIniciar;

	/** JButton para continuar. */
	private JButton btnContinuar;

	/** JButton para volver. */
	private JButton btnVolver;

	/** JLabel para iniciar. */
	private JLabel lblIniciar;

	/** JLabel para volver. */
	private JLabel lblVolver;

	/** JLabel para continuar. */
	private JLabel lblContinuar;

	/**
	 * Constructor of the PanelMapaSemiLlano class
	 */
	public PanelMapaSemiLlano() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);

		btnVolver = generarBoton("Volver", 40, 510, 50, 50, "fotos/botonVolver.png");
		btnIniciar = generarBoton("Iniciar Simulador", 330, 460, 30, 30, "fotos/rueda.png");
		btnContinuar = generarBoton("Continuar", 940, 515, 30, 30, "fotos/rueda.png");

		lblVolver = generarLabel("Volver", 95, 520, 100, 30);
		lblIniciar = generarLabel("Iniciar", 360, 460, 100, 30);
		lblContinuar = generarLabel("Continuar", 800, 515, 150, 30);

		imagen = new ImageIcon("fotos/SemiLlano.png");

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
	 * @param text   Button text.
	 * @param x      X position of the button.
	 * @param y      Y position of the button.
	 * @param width  Width of the button.
	 * @param height Height of the button.
	 * @param url    URL of the button icon.
	 * @return Generated JButton.
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
	 * @param text   Label text.
	 * @param x      X position of the label.
	 * @param y      Y position of the label.
	 * @param width  Width of the label.
	 * @param height Height of the label.
	 * @return Generated JLabel.
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
	 * Generates a custom JTextField.
	 * 
	 * @param x     Posición X del JTextField.
	 * @param y     Posición Y del JTextField.
	 * @param ancho Ancho del JTextField.
	 * @param alto  Alto del JTextField.
	 * @return JTextField generado.
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
	 * @param g Graphics object.
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
