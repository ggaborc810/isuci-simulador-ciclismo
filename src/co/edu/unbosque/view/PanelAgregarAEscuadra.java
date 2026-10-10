/**
 * package in charge of storing the entire graphical user interface
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
/*
 * class with elements to add to squad
 *  @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelAgregarAEscuadra extends JPanel{
	// Instance variables

	/** The background image icon. */
	private ImageIcon imagen;

	/** The text field for the team name. */
	private JTextField txtEscuadra;

	/** The button to go back. */
	private JButton btnVolver;

	/** The label for the back button. */
	private JLabel lblVolver;

	/** The button to search. */
	private JButton btnBuscar;

	/** The label for the search button. */
	private JLabel lblBuscar;

	/** The combo box for selecting a cyclist. */
	private JComboBox boxCiclista;

	/** The table displaying cyclists. */
	private JTable tablaCiclistas;

	/** The label for displaying information. */
	private JLabel lblInfo;

	/** The label for the add button. */
	private JLabel lblAgregar;

	/** The button to add a new entry. */
	private JButton btnAgregar;
	
/**
 * Class constructor PanelAgregarAEscuadra
 */
	public PanelAgregarAEscuadra() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.gray);

		txtEscuadra = generarEscritura(305, 82, 180, 30);
		btnBuscar = generarBoton("Buscar Escuadra", 920, 515, 35, 35, "fotos/rueda.png");
		lblBuscar = generarMensaje("Buscar Escuadra", 750, 505, 300, 50);
		lblInfo = generarMensaje("Escriba el nombre de la escuadra:", 25, 75, 500, 35);
		lblInfo.setFont(new Font("Banschrift", Font.BOLD, 17));
		imagen = new ImageIcon("fotos/agregarUEscuadras.png");
		btnVolver = generarBoton("Volver", 40, 505, 50, 50, "fotos/botonVolver.png");
		lblVolver = generarMensaje("Volver", 90, 505, 100, 50);
		boxCiclista = generarCajaMasajistas(680, 82, 260, 30);
		lblAgregar = generarMensaje("Agregar Usuario",340, 510, 260, 30);
		btnAgregar = generarBoton("Agergar Usuario",400, 510, 260, 30,"fotos/rueda.png");
		
		// Column Names
				String[] columnNames = { "id", "Nombre", "Tipo" };

		String[][] data = {columnNames, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }

		};
		

		// Initializing the JTable
		tablaCiclistas = new JTable(data, columnNames);
		tablaCiclistas.setBounds(420, 180, 200, 300);
		tablaCiclistas.setVisible(false);

		add(txtEscuadra);
		add(btnBuscar);
		add(lblBuscar);
		add(boxCiclista);
		add(lblInfo);
		add(lblAgregar);
		add(btnAgregar);

		add(tablaCiclistas);

		add(btnVolver);
		add(lblVolver);

	}
	/**
	 * Paints the background image on the panel.
	 * @param g The Graphics object to protect.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(imagen.getImage(), 0, -20, ancho, alto, this);
	}

/**
 * Generates a combo box for selecting a masseuse with specified properties.
 * @param x The x-coordinate of the combo box.
 * @param y The y-coordinate of the combo box.
 * @param ancho The width of the combo box.
 * @param alto The height of the combo box.
 * @return The generated combo box.
 */
	public JComboBox generarCajaMasajistas(int x, int y, int ancho, int alto) {
		String[] masajista = { "" };
		JComboBox box = new JComboBox(masajista);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Etna", Font.BOLD, 12));
		return box;
	}
	/**
	 * Generates a message label with specified properties.
	 * @param texto The text for the label.
	 * @param x The x-coordinate of the label.
	 * @param y The y-coordinate of the label.
	 * @param ancho The width of the label.
	 * @param alto The height of the label.
	 * @return The generated label.
	 */
	public JLabel generarMensaje(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Banschrift", Font.BOLD, 21));
		lbl.setForeground(Color.WHITE);
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}
	/**
	 * Generates a button with specified properties.
	 * @param texto The text to be displayed on the button.
	 * @param x The x-coordinate of the button.
	 * @param y The y-coordinate of the button.
	 * @param ancho The width of the button.
	 * @param alto The height of the button.
	 * @param url The URL of the image for the button.
	 * @return The generated button.
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
 * Generates a text field with specified properties.
 * @param x The x-coordinate of the text field.
 * @param y The y-coordinate of the text field.
 * @param ancho The width of the text field.
 * @param alto The height of the text field.
 * @return The generated text field.
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
 * @return the txtEscuadra
 */
public JTextField getTxtEscuadra() {
	return txtEscuadra;
}
/**
 * @param txtEscuadra the txtEscuadra to set
 */
public void setTxtEscuadra(JTextField txtEscuadra) {
	this.txtEscuadra = txtEscuadra;
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
public JComboBox getBoxCiclista() {
	return boxCiclista;
}
/**
 * @param boxCiclista the boxCiclista to set
 */
public void setBoxCiclista(JComboBox boxCiclista) {
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
/**
 * @return the lblAgregar
 */
public JLabel getLblAgregar() {
	return lblAgregar;
}
/**
 * @param lblAgregar the lblAgregar to set
 */
public void setLblAgregar(JLabel lblAgregar) {
	this.lblAgregar = lblAgregar;
}
/**
 * @return the btnAgregar
 */
public JButton getBtnAgregar() {
	return btnAgregar;
}
/**
 * @param btnAgregar the btnAgregar to set
 */
public void setBtnAgregar(JButton btnAgregar) {
	this.btnAgregar = btnAgregar;
}

}
