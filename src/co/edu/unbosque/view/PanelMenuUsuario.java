
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
/**
 * Represents a panel to manage user-related operations
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelMenuUsuario extends JPanel {

	/** Image icon for background image. */
    private ImageIcon fondo;

    /** Button for selecting ciclista. */
    private JButton btnCiclista;

    /** Button for selecting masajista. */
    private JButton btnMasajista;

    /** Button for selecting director. */
    private JButton btnDirector;

    /** Label for displaying "Ciclista" text. */
    private JLabel lblCiclista;

    /** Label for displaying "Masajista" text. */
    private JLabel lblMasajista;

    /** Label for displaying "Director" text. */
    private JLabel lblDirector;

    /** Button for navigation to previous screen. */
    private JButton btnVolver;

    /** Label for displaying "Volver" text. */
    private JLabel lblVolver;


	/**
	 * constructor of the MenuUsuario class
	 */
	public PanelMenuUsuario() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY); 
		fondo = new ImageIcon("fotos/menuUsuarios.png");

		
		
		btnCiclista = generarBotonI("Menu ciclistas", 100, 145, 32, 32, "fotos/rueda.png");
		lblCiclista = generarMensaje("Menu ciclistas",150, 10, 900, 300);

		
		btnMasajista = generarBotonI("Menu masajista", 100, 245, 32, 32, "fotos/rueda.png");
		lblMasajista= generarMensaje("Menu masajista",150, 110, 900, 300);

		
		btnDirector = generarBotonI("Menu director", 100, 345, 32, 32, "fotos/rueda.png");
		lblDirector = generarMensaje("Menu director",150, 210, 900, 300);
		
		btnVolver = generarBotonI("Volver a opciones", 30, 485, 32, 32, "fotos/rueda.png");
		lblVolver = generarMensaje("Volver",70, 350, 900, 300);		
		lblVolver.setFont(new Font("Etna Sans Serif", Font.BOLD, 26));

		add(btnCiclista);
		add(btnMasajista);
		add(btnDirector);
		add(lblCiclista);
		add(lblMasajista);
		add(lblDirector);
		add(lblVolver);
		add(btnVolver);




	
	}
	
	 /**
     * Overrides the paintComponent method to draw a background image.
     * 
     * @param g The graphics context.
     */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(fondo.getImage(), 0,0, ancho, alto, this);
	}

    /**
     * Generates a JButton with specified properties.
     * 
     * @param toolTip The tooltip text for the button.
     * @param x       The x-coordinate of the button.
     * @param y       The y-coordinate of the button.
     * @param ancho   The width of the button.
     * @param alto    The height of the button.
     * @param url     The file path or URL of the button icon.
     * @return The generated JButton.
     */

	public JButton generarBotonI(String toolTip, int x, int y, int ancho, int alto, String url) {
		JButton btn = new JButton();
		btn.setBackground(Color.decode("#FFF8DC"));
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(true);
		btn.setFocusPainted(false);
		btn.setOpaque(false);
		btn.setToolTipText("BOTON " + toolTip + ".");
		ImageIcon icono = new ImageIcon(url);
		btn.setIcon(icono);
		btn.setBounds(x, y, ancho, alto);
		return btn;
	}
	
	 /**
     * Generates a JLabel with specified properties.
     * 
     * @param texto The text to be displayed on the label.
     * @param x     The x-coordinate of the label.
     * @param y     The y-coordinate of the label.
     * @param ancho The width of the label.
     * @param alto  The height of the label.
     * @return The generated JLabel.
     */
	public JLabel generarMensaje(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Etna Sans Serif", Font.BOLD, 42));
		lbl.setForeground(Color.white);
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}

	/**
	 * @return the fondo
	 */
	public ImageIcon getFondo() {
		return fondo;
	}

	/**
	 * @param fondo the fondo to set
	 */
	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	/**
	 * @return the btnCiclista
	 */
	public JButton getBtnCiclista() {
		return btnCiclista;
	}

	/**
	 * @param btnCiclista the btnCiclista to set
	 */
	public void setBtnCiclista(JButton btnCiclista) {
		this.btnCiclista = btnCiclista;
	}

	/**
	 * @return the btnMasajista
	 */
	public JButton getBtnMasajista() {
		return btnMasajista;
	}

	/**
	 * @param btnMasajista the btnMasajista to set
	 */
	public void setBtnMasajista(JButton btnMasajista) {
		this.btnMasajista = btnMasajista;
	}

	/**
	 * @return the btnDirector
	 */
	public JButton getBtnDirector() {
		return btnDirector;
	}

	/**
	 * @param btnDirector the btnDirector to set
	 */
	public void setBtnDirector(JButton btnDirector) {
		this.btnDirector = btnDirector;
	}

	/**
	 * @return the lblCiclista
	 */
	public JLabel getLblCiclista() {
		return lblCiclista;
	}

	/**
	 * @param lblCiclista the lblCiclista to set
	 */
	public void setLblCiclista(JLabel lblCiclista) {
		this.lblCiclista = lblCiclista;
	}

	/**
	 * @return the lblMasajista
	 */
	public JLabel getLblMasajista() {
		return lblMasajista;
	}

	/**
	 * @param lblMasajista the lblMasajista to set
	 */
	public void setLblMasajista(JLabel lblMasajista) {
		this.lblMasajista = lblMasajista;
	}

	/**
	 * @return the lblDirector
	 */
	public JLabel getLblDirector() {
		return lblDirector;
	}

	/**
	 * @param lblDirector the lblDirector to set
	 */
	public void setLblDirector(JLabel lblDirector) {
		this.lblDirector = lblDirector;
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


	
	
	

}
