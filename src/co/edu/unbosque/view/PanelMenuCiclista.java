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
 * class with components from the cilist menu * @autor Juan Diego Triana Mejía
 * 
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelMenuCiclista extends JPanel {

	/** ImageIcon for background image. */
	private ImageIcon fondo;

	/** Create button */
	private JButton btnCrear;

	/** Delete button. */
	private JButton btnEliminar;

	/** Update button. */
	private JButton btnActualizar;

	/** Show button. */
	private JButton btnMostrar;

	/** Tag to create */
	private JLabel lblCrear;

	/** Label to remove. */
	private JLabel lblEliminar;

	/** Label to update. */
	private JLabel lblActualizar;

	/** Display tag. */
	private JLabel lblMostrar;

	/** Alternative tag to create. */
	private JLabel lblCrear2;

	/** Alternative tag to remove. */
	private JLabel lblEliminar2;

	/** Alternate tag to update. */
	private JLabel lblActualizar2;

	/** Alternate display tag. */
	private JLabel lblMostrar2;

	/** Menu label. */
	private JLabel lblMenu;

	/** Other menu label */
	private JLabel lblMenu2;

	/** Back button. */
	private JButton btnVolver;

	/** Label to return. */
	private JLabel lblVolver;

	private JButton btnEliminarNov1;

	/**
	 * Constructor of the Cyclist PanelMenu class
	 */

	public PanelMenuCiclista() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);
		fondo = new ImageIcon("fotos/menuCiclista.png");

		btnCrear = generarBotonI("Crear", 100, 145, 32, 32, "fotos/rueda.png");
		lblCrear = generarMensaje("CREAR", 150, 10, 900, 300);

		btnEliminar = generarBotonI("Eliminar", 100, 245, 32, 32, "fotos/rueda.png");
		lblEliminar = generarMensaje("ELIMINAR", 150, 110, 900, 300);
		btnEliminarNov1 = generarBotonI("Eliminar", 100, 245, 32, 32, "fotos/botonNoValido.png");

		btnActualizar = generarBotonI("Actualizar", 100, 345, 32, 32, "fotos/rueda.png");
		lblActualizar = generarMensaje("ACTUALIZAR", 150, 210, 900, 300);

		btnMostrar = generarBotonI("Mostrar", 100, 445, 32, 32, "fotos/rueda.png");
		lblMostrar = generarMensaje("MOSTRAR", 150, 310, 900, 300);

		btnVolver = generarBotonI("volver", 30, 520, 32, 32, "fotos/rueda.png");
		lblVolver = generarMensaje("Volver", 70, 385, 900, 300);
		lblVolver.setFont(new Font("Coolvetica Rg", Font.BOLD, 28));

		add(btnActualizar);
		add(btnCrear);
		add(btnEliminar);
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
	 * Method to paint the component with the background image.
	 * 
	 * @param g Graphics used to draw
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(fondo.getImage(), 0, 0, ancho, alto, this);
	}

	/**
	 * Method to generate a button with an image.
	 * 
	 * @param toolTip text for button popup tool
	 * @param x       button
	 * @param y       button Y position
	 * @param ancho   button width
	 * @param alto    button height
	 * @param url     Image URL for button icon
	 * @return JButton generated
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
	 * Method to generate a message label.
	 * 
	 * @param texto message text
	 * @param x     label x position
	 * @param y     label Y position
	 * @param ancho label width
	 * @param alto  label height
	 * @return JLabel generated
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

	public JButton getBtnEliminarNov1() {
		return btnEliminarNov1;
	}

	public void setBtnEliminarNov1(JButton btnEliminarNov1) {
		this.btnEliminarNov1 = btnEliminarNov1;
	}

}
