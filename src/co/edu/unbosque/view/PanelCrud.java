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
 * Class containing components to CRUD
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */

public class PanelCrud extends JPanel {

	/**
	 * Background image for the panel.
	 */
	private ImageIcon fondo;

	/**
	 * Button to create an item.
	 */
	private JButton btnCrear;

	/**
	 * Button to delete an item.
	 */
	private JButton btnEliminar;

	/**
	 * Button to update an item.
	 */
	private JButton btnActualizar;

	/**
	 * Button to show items.
	 */
	private JButton btnMostrar;

	/**
	 * Label indicating creation action.
	 */
	private JLabel lblCrear;

	/**
	 * Label indicating deletion action.
	 */
	private JLabel lblEliminar;

	/**
	 * Label indicating update action.
	 */
	private JLabel lblActualizar;

	/**
	 * Label indicating show action.
	 */
	private JLabel lblMostrar;

	/**
	 * Additional label related to creation action.
	 */
	private JLabel lblCrear2;

	/**
	 * Additional label related to deletion action.
	 */
	private JLabel lblEliminar2;

	/**
	 * Additional label related to update action.
	 */
	private JLabel lblActualizar2;

	/**
	 * Additional label related to show action.
	 */
	private JLabel lblMostrar2;

	/**
	 * Menu label.
	 */
	private JLabel lblMenu;

	/**
	 * Additional menu label.
	 */
	private JLabel lblMenu2;

	/**
	 * class constructor PanelCrud
	 */
	public PanelCrud() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);
		fondo = new ImageIcon("fotos/fondo8.jpg");

		JLabel lblMenu = new JLabel("MENU ESCUADRA");
		lblMenu.setBounds(100, -20, 500, 200);
		lblMenu.setFont(new Font("Coolvetica Rg", Font.BOLD, 72));
		lblMenu.setForeground(Color.ORANGE);
		JLabel lblMenu2 = new JLabel("MENU ESCUADRA");
		lblMenu2.setBounds(105, -20, 500, 200);
		lblMenu2.setFont(new Font("Coolvetica Rg", Font.BOLD, 72));
		lblMenu2.setForeground(Color.BLACK);

		btnCrear = generarBotonI("Crear", 100, 145, 32, 32, "fotos/rueda.png");
		lblCrear = generarMensaje("Crear", 150, 10, 900, 300);
		lblCrear2 = generarMensaje2("Crear", 155, 10, 900, 300);

		btnEliminar = generarBotonI("Eliminar", 100, 245, 32, 32, "fotos/rueda.png");
		lblEliminar = generarMensaje("Eliminar", 150, 110, 900, 300);
		lblEliminar2 = generarMensaje2("Eliminar", 155, 110, 900, 300);

		btnActualizar = generarBotonI("Actualizar", 100, 345, 32, 32, "fotos/rueda.png");
		lblActualizar = generarMensaje("Actualizar", 150, 210, 900, 300);
		lblActualizar2 = generarMensaje2("Actualizar", 155, 210, 900, 300);

		btnMostrar = generarBotonI("Mostrar", 100, 445, 32, 32, "fotos/rueda.png");
		lblMostrar = generarMensaje("Mostrar", 150, 310, 900, 300);
		lblMostrar2 = generarMensaje2("Mostrar", 155, 310, 900, 300);

		add(lblMenu);
		add(lblMenu2);
		add(btnActualizar);
		add(btnCrear);
		add(btnEliminar);
		add(btnMostrar);
		add(lblCrear);
		add(lblActualizar);
		add(lblEliminar);
		add(lblMostrar);
		add(lblCrear2);
		add(lblActualizar2);
		add(lblEliminar2);
		add(lblMostrar2);
	}

	/**
	 * Method to paint the background image on the panel.
	 * 
	 * @param g Graphics object used for painting.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(fondo.getImage(), 0, 0, ancho, alto, this);
	}

	/**
	 * Method to generate a custom button with an image icon.
	 * 
	 * @param toolTip Tooltip text for the button.
	 * @param x       X-coordinate of the button.
	 * @param y       Y-coordinate of the button.
	 * @param ancho   Width of the button.
	 * @param alto    Height of the button.
	 * @param url     URL of the image icon.
	 * @return JButton object with the specified properties.
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
	 * Method to generate a custom label for displaying text.
	 * 
	 * @param texto Text to be displayed on the label.
	 * @param x     X-coordinate of the label.
	 * @param y     Y-coordinate of the label.
	 * @param ancho Width of the label.
	 * @param alto  Height of the label.
	 * @return JLabel object with the specified properties.
	 */
	public JLabel generarMensaje(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Coolvetica Rg", Font.BOLD, 52));
		lbl.setForeground(Color.black);
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}

	/**
	 * Method to generate a custom label for displaying text with a different color.
	 * 
	 * @param texto Text to be displayed on the label.
	 * @param x     X-coordinate of the label.
	 * @param y     Y-coordinate of the label.
	 * @param ancho Width of the label.
	 * @param alto  Height of the label.
	 * @return JLabel object with the specified properties.
	 */
	public JLabel generarMensaje2(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Coolvetica Rg", Font.BOLD, 52));
		lbl.setForeground(Color.orange);
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

}
