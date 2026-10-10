
/**
package in charge of storing the entire graphical user interface
*/
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.JTable;

/**
 * class in charge of showing the squad
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 * 
 */
public class PanelMostrarEscuadra extends JPanel {

	/** Image icon for graphical representation. */
	private ImageIcon imagen;

	/** Text field to display or enter information. */
	private JTextField txtMostrarEscuadra;

	/** Button to navigate back or perform a specific action. */
	private JButton btnVolver;

	/** Label for indicating the action of the "Volver" button. */
	private JLabel lblVolver;

	/** Table model for organizing and manipulating tabular data. */
	private TableModel model;

	/** Button to initiate a search action. */
	private JButton btnBuscar;

	/** Label for indicating the action of the "Buscar" button. */
	private JLabel lblBuscar;

	/** Combo box for selecting items from a list. */
	private JComboBox<String> boxCiclista;

	/** Table for displaying tabular data. */
	private JTable tablaCiclistas;

	/** Label for displaying informational messages. */
	private JLabel lblInfo;

	public PanelMostrarEscuadra() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.gray);

		txtMostrarEscuadra = generarEscritura(545, 93, 240, 30);
		btnBuscar = generarBoton("Buscar Escuadra", 920, 515, 35, 35, "fotos/rueda.png");
		lblBuscar = generarMensaje("Buscar Escuadra", 750, 505, 300, 50);
		lblInfo = generarMensaje("Escriba el nombre de la escuadra:", 205, 90, 500, 35);
		lblBuscar.setFont(new Font("Banschrift", Font.BOLD, 20));
		imagen = new ImageIcon("fotos/MostrarEscuadra.png");
		btnVolver = generarBoton("Volver", 40, 505, 50, 50, "fotos/botonVolver.png");
		lblVolver = generarMensaje("Volver", 90, 505, 100, 50);
		boxCiclista = generarCajaMasajistas(230, 345, 235, 27);

		String[] columnNames = { "id", "Nombre Ciclista", "Tipo" };

		String[][] data = { columnNames, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }

		};
		// Column Names

		// Initializing the JTable
		tablaCiclistas = new JTable(data, columnNames);
		tablaCiclistas.setBounds(420, 180, 200, 300);
		tablaCiclistas.setVisible(false);

		add(txtMostrarEscuadra);
		add(btnBuscar);
		add(lblBuscar);
//		add(boxCiclista);
		add(lblInfo);

		add(tablaCiclistas);

		add(btnVolver);
		add(lblVolver);

	}

	/**
	 * Paints the component with the specified graphics context.
	 *
	 * @param g The graphics context to use for painting.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(imagen.getImage(), 0, -20, ancho, alto, this);
	}

	/**
	 * Generates a combo box for selecting masajistas.
	 *
	 * @param x     The x-coordinate of the combo box.
	 * @param y     The y-coordinate of the combo box.
	 * @param ancho The width of the combo box.
	 * @param alto  The height of the combo box.
	 * @return A JComboBox component for selecting masajistas.
	 */
	public JComboBox generarCajaMasajistas(int x, int y, int ancho, int alto) {
		String[] masajista = { "" };
		JComboBox box = new JComboBox(masajista);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Etna", Font.BOLD, 12));
		return box;
	}

	/**
	 * Generates a label with the specified text, position, width, and height.
	 *
	 * @param texto The text to display on the label.
	 * @param x     The x-coordinate of the label.
	 * @param y     The y-coordinate of the label.
	 * @param ancho The width of the label.
	 * @param alto  The height of the label.
	 * @return A JLabel component with the specified properties.
	 */
	public JLabel generarMensaje(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Banschrift", Font.BOLD, 21));
		lbl.setForeground(Color.WHITE);
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}

	/**
	 * Generates a button with the specified text, position, size, and image URL.
	 *
	 * @param texto The text to display on the button.
	 * @param x     The x-coordinate of the button.
	 * @param y     The y-coordinate of the button.
	 * @param ancho The width of the button.
	 * @param alto  The height of the button.
	 * @param url   The URL of the image to use as the button icon.
	 * @return A JButton component with the specified properties.
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
	 * Generates a text field with the specified position, size, and font.
	 *
	 * @param x     The x-coordinate of the text field.
	 * @param y     The y-coordinate of the text field.
	 * @param ancho The width of the text field.
	 * @param alto  The height of the text field.
	 * @return A JTextField component with the specified properties.
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

	/**
	 * @return the txtMostrarEscuadra
	 */
	public JTextField getTxtMostrarEscuadra() {
		return txtMostrarEscuadra;
	}

	/**
	 * @param txtMostrarEscuadra the txtMostrarEscuadra to set
	 */
	public void setTxtMostrarEscuadra(JTextField txtMostrarEscuadra) {
		this.txtMostrarEscuadra = txtMostrarEscuadra;
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

	/**
	 * @return the model
	 */
	public TableModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(TableModel model) {
		this.model = model;
	}

	/**
	 * @return the btnBuscar
	 */
	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	/**
	 * @param btnBuscar the btnBuscar to set
	 */
	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	/**
	 * @return the lblBuscar
	 */
	public JLabel getLblBuscar() {
		return lblBuscar;
	}

	/**
	 * @param lblBuscar the lblBuscar to set
	 */
	public void setLblBuscar(JLabel lblBuscar) {
		this.lblBuscar = lblBuscar;
	}

	/**
	 * @return the boxCiclista
	 */
	public JComboBox<String> getBoxCiclista() {
		return boxCiclista;
	}

	/**
	 * @param boxCiclista the boxCiclista to set
	 */
	public void setBoxCiclista(JComboBox<String> boxCiclista) {
		this.boxCiclista = boxCiclista;
	}

	/**
	 * @return the tablaCiclistas
	 */
	public JTable getTablaCiclistas() {
		return tablaCiclistas;
	}

	/**
	 * @param tablaCiclistas the tablaCiclistas to set
	 */
	public void setTablaCiclistas(JTable tablaCiclistas) {
		this.tablaCiclistas = tablaCiclistas;
	}

	/**
	 * @return the lblInfo
	 */
	public JLabel getLblInfo() {
		return lblInfo;
	}

	/**
	 * @param lblInfo the lblInfo to set
	 */
	public void setLblInfo(JLabel lblInfo) {
		this.lblInfo = lblInfo;
	}

}
