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
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * class with components for the mountain map
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelMapaMontania extends JPanel {


    /** ImageIcon for the background or other graphical elements. */
    private ImageIcon imagen;

    /** JButton to start an action or process. */
    private JButton btnIniciar;

    /** JButton to continue a paused or saved action or process. */
    private JButton btnContinuar;

    /** JButton to go back to the previous screen or exit the current process. */
    private JButton btnVolver;

    /** JLabel to display the text "Iniciar" (Start). */
    private JLabel lblIniciar;

    /** JLabel to display the text "Volver" (Return). */
    private JLabel lblVolver;

    /** JLabel to display the text "Continuar" (Continue). */
    private JLabel lblContinuar;

/**
 * constructor de la clase MapaMontania
 */
	public PanelMapaMontania() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);

		btnVolver = generarBoton("Volver", 40, 510, 50, 50, "fotos/botonVolver.png");
		btnIniciar = generarBoton("Iniciar Simulador", 475, 460, 30, 30, "fotos/rueda.png");
		btnContinuar = generarBoton("Continuar", 940, 515, 30, 30, "fotos/rueda.png");

		lblVolver = generarLabel("Volver", 95, 520, 100, 30);
		lblIniciar = generarLabel("Iniciar", 510, 460, 100, 30);
		lblContinuar = generarLabel("Continuar", 800, 515, 150, 30);

		imagen = new ImageIcon("fotos/19.png");

		add(btnVolver);
		add(btnIniciar);
		add(btnContinuar);
		add(lblVolver);
		add(lblIniciar);
		add(lblContinuar);
		repaint();

	}
	/**
     * Generates a JButton with specified properties.
     *
     * @param texto The text to display on the button.
     * @param x The x-coordinate of the button.
     * @param y The y-coordinate of the button.
     * @param ancho The width of the button.
     * @param alto The height of the button.
     * @param url The URL of the icon image to display on the button.
     * @return A configured JButton instance.
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
     * Generates a JLabel with specified properties.
     *
     * @param texto The text to display on the label.
     * @param x The x-coordinate of the label.
     * @param y The y-coordinate of the label.
     * @param ancho The width of the label.
     * @param alto The height of the label.
     * @return A configured JLabel instance.
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
     * Generates a JTextField with specified properties.
     *
     * @param x The x-coordinate of the text field.
     * @param y The y-coordinate of the text field.
     * @param ancho The width of the text field.
     * @param alto The height of the text field.
     * @return A configured JTextField instance.
     */
   
	public JTextField generarEscritura(int x, int y, int ancho, int alto) {
		JTextField txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Banschrift", Font.BOLD, 15));
		txt.setBounds(x, y, ancho, alto);
		return txt;
	}

    /**
     * Custom painting method for the component's background.
     *
     * @param g The Graphics object used for painting.
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
