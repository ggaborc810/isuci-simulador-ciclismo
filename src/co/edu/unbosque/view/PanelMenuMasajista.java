package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Represents a panel for managing operations related to a specific entity type.
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelMenuMasajista extends JPanel {

	/** Background image for the panel. */
	private ImageIcon fondo;

	/** Button for creating new entities. */
	private JButton btnCrear;

	/** Button for deleting existing entities. */
	private JButton btnEliminar;

	/** Button for updating existing entities. */
	private JButton btnActualizar;

	/** Button for displaying existing entities. */
	private JButton btnMostrar;

	/** Button for navigating back. */
	private JButton btnVolver;

	/** Label for the "Create" button. */
	private JLabel lblCrear;

	/** Label for the "Delete" button. */
	private JLabel lblEliminar;

	/** Label for the "Update" button. */
	private JLabel lblActualizar;

	/** Label for the "Display" button. */
	private JLabel lblMostrar;

	/** Additional label for the "Create" operation. */
	private JLabel lblCrear2;

	/** Additional label for the "Delete" operation. */
	private JLabel lblEliminar2;

	/** Additional label for the "Update" operation. */
	private JLabel lblActualizar2;

	/** Additional label for the "Display" operation. */
	private JLabel lblMostrar2;

	/** Label for the menu. */
	private JLabel lblMenu;

	/** Additional label for the menu. */
	private JLabel lblMenu2;

	/** Label for the "Back" button. */
	private JLabel lblVolver;

	/** Additional label for the "Delete" operation. */
	private JButton btnEliminarNov1;

	
	public PanelMenuMasajista() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY); 
		fondo = new ImageIcon("fotos/menuMasajista.png");

		
		
		btnCrear = generarBotonI("Crear", 100, 145, 32, 32, "fotos/rueda.png");
		lblCrear = generarMensaje("CREAR",150, 10, 900, 300);

		
		btnEliminar = generarBotonI("Eliminar", 100, 245, 32, 32, "fotos/rueda.png");
		lblEliminar = generarMensaje("ELIMINAR",150, 110, 900, 300);

		
		btnActualizar = generarBotonI("Actualizar", 100, 345, 32, 32, "fotos/rueda.png");
		lblActualizar = generarMensaje("ACTUALIZAR",150, 210, 900, 300);

		
		btnMostrar = generarBotonI("Mostrar", 100, 445, 32, 32, "fotos/rueda.png");
		lblMostrar = generarMensaje("MOSTRAR",150, 310, 900, 300);
		
		btnVolver = generarBotonI("Volver a usuarios", 30, 510, 32, 32, "fotos/rueda.png");
		lblVolver= generarMensaje("Volver",65, 375, 900, 300);
		lblVolver.setFont(new Font("Etna Sans Serif", Font.BOLD, 30));
		
		btnEliminarNov1 = generarBotonI("Eliminar", 100, 245, 32, 32, "fotos/botonNoValido.png");

		add(btnActualizar);
		add(btnCrear);
		add(btnMostrar);
		add(lblCrear);
		add(lblActualizar);
		add(lblEliminar);
		add(lblMostrar);
		add(btnVolver);
		add(lblVolver);
		add(btnEliminarNov1);
	}
	
	
	/**
	 * Overrides the paintComponent method to draw the background image of the
	 * panel.
	 * 
	 * @param g The Graphics context used for painting.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(fondo.getImage(), 0, 0, ancho, alto, this);
	}

	/**
	 * Generates a custom JButton with a specified tooltip, position, size, and
	 * image icon.
	 * 
	 * @param toolTip The tooltip text for the button.
	 * @param x       The x-coordinate of the button's top-left corner.
	 * @param y       The y-coordinate of the button's top-left corner.
	 * @param ancho   The width of the button.
	 * @param alto    The height of the button.
	 * @param url     The file path to the image icon.
	 * @return A custom JButton with the specified properties.
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
	 * Generates a custom JLabel with a specified text, position, size, and font.
	 * 
	 * @param texto The text to display on the label.
	 * @param x     The x-coordinate of the label's top-left corner.
	 * @param y     The y-coordinate of the label's top-left corner.
	 * @param ancho The width of the label.
	 * @param alto  The height of the label.
	 * @return A custom JLabel with the specified properties.
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
	 * @return the btnCrear
	 */
	public JButton getBtnCrear() {
		return btnCrear;
	}

	/**
	 * @param btnCrear the btnCrear to set
	 */
	public void setBtnCrear(JButton btnCrear) {
		this.btnCrear = btnCrear;
	}

	/**
	 * @return the btnEliminar
	 */
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	/**
	 * @param btnEliminar the btnEliminar to set
	 */
	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	/**
	 * @return the btnActualizar
	 */
	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	/**
	 * @param btnActualizar the btnActualizar to set
	 */
	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	/**
	 * @return the btnMostrar
	 */
	public JButton getBtnMostrar() {
		return btnMostrar;
	}

	/**
	 * @param btnMostrar the btnMostrar to set
	 */
	public void setBtnMostrar(JButton btnMostrar) {
		this.btnMostrar = btnMostrar;
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
	 * @return the lblCrear
	 */
	public JLabel getLblCrear() {
		return lblCrear;
	}

	/**
	 * @param lblCrear the lblCrear to set
	 */
	public void setLblCrear(JLabel lblCrear) {
		this.lblCrear = lblCrear;
	}

	/**
	 * @return the lblEliminar
	 */
	public JLabel getLblEliminar() {
		return lblEliminar;
	}

	/**
	 * @param lblEliminar the lblEliminar to set
	 */
	public void setLblEliminar(JLabel lblEliminar) {
		this.lblEliminar = lblEliminar;
	}

	/**
	 * @return the lblActualizar
	 */
	public JLabel getLblActualizar() {
		return lblActualizar;
	}

	/**
	 * @param lblActualizar the lblActualizar to set
	 */
	public void setLblActualizar(JLabel lblActualizar) {
		this.lblActualizar = lblActualizar;
	}

	/**
	 * @return the lblMostrar
	 */
	public JLabel getLblMostrar() {
		return lblMostrar;
	}

	/**
	 * @param lblMostrar the lblMostrar to set
	 */
	public void setLblMostrar(JLabel lblMostrar) {
		this.lblMostrar = lblMostrar;
	}

	/**
	 * @return the lblCrear2
	 */
	public JLabel getLblCrear2() {
		return lblCrear2;
	}

	/**
	 * @param lblCrear2 the lblCrear2 to set
	 */
	public void setLblCrear2(JLabel lblCrear2) {
		this.lblCrear2 = lblCrear2;
	}

	/**
	 * @return the lblEliminar2
	 */
	public JLabel getLblEliminar2() {
		return lblEliminar2;
	}

	/**
	 * @param lblEliminar2 the lblEliminar2 to set
	 */
	public void setLblEliminar2(JLabel lblEliminar2) {
		this.lblEliminar2 = lblEliminar2;
	}

	/**
	 * @return the lblActualizar2
	 */
	public JLabel getLblActualizar2() {
		return lblActualizar2;
	}

	/**
	 * @param lblActualizar2 the lblActualizar2 to set
	 */
	public void setLblActualizar2(JLabel lblActualizar2) {
		this.lblActualizar2 = lblActualizar2;
	}

	/**
	 * @return the lblMostrar2
	 */
	public JLabel getLblMostrar2() {
		return lblMostrar2;
	}

	/**
	 * @param lblMostrar2 the lblMostrar2 to set
	 */
	public void setLblMostrar2(JLabel lblMostrar2) {
		this.lblMostrar2 = lblMostrar2;
	}

	/**
	 * @return the lblMenu
	 */
	public JLabel getLblMenu() {
		return lblMenu;
	}

	/**
	 * @param lblMenu the lblMenu to set
	 */
	public void setLblMenu(JLabel lblMenu) {
		this.lblMenu = lblMenu;
	}

	/**
	 * @return the lblMenu2
	 */
	public JLabel getLblMenu2() {
		return lblMenu2;
	}

	/**
	 * @param lblMenu2 the lblMenu2 to set
	 */
	public void setLblMenu2(JLabel lblMenu2) {
		this.lblMenu2 = lblMenu2;
	}

	/**
	 * @return the lblVolver
	 */
	public JLabel getLblVolver() {
		return lblVolver;
	}

	/**
	 * Returns the button that initiates the deletion of an item (novelty 1).
	 *
	 * @return The JButton that initiates the deletion of an item (novelty 1).
	 */
	public JButton getBtnEliminarNov1() {
	    return btnEliminarNov1;
	}

	/**
	 * Sets the button that initiates the deletion of an item (novelty 1).
	 *
	 * @param btnEliminarNov1 The JButton to set for initiating the deletion of an item (novelty 1).
	 */
	public void setBtnEliminarNov1(JButton btnEliminarNov1) {
	    this.btnEliminarNov1 = btnEliminarNov1;
	}


	/**
	 * @param lblVolver the lblVolver to set
	 */
	public void setLblVolver(JLabel lblVolver) {
		this.lblVolver = lblVolver;
	}

}

