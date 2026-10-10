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
 * 
 * Class with components to delete a user
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelEliminarUsuario extends JPanel {
	/**
	 * A JTextField for inputting the username to be deleted.
	 */
	private JTextField txtEliminarUsuario;

	/**
	 * A JButton to navigate back to the previous screen.
	 */
	private JButton btnVolver;

	/**
	 * A JButton to execute the user deletion action.
	 */
	private JButton btnEliminar;

	/**
	 * An ImageIcon to hold the image used in the GUI.
	 */
	private ImageIcon imagen;

	/**
	 * Delete User Dashboard Builder
	 */
	public PanelEliminarUsuario() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.gray);
		
		txtEliminarUsuario = generarEscritura(370, 173, 280, 30);
		btnVolver = generarBoton("Volver", 160, 505, 50, 50, "fotos/botonVolver.png");
		btnEliminar = generarBoton("Eliminar", 880, 515, 35, 35, "fotos/rueda.png");
		imagen = new ImageIcon("fotos/PanelEliminarUsuario.png");
		
		
		add(txtEliminarUsuario);
		add(btnVolver);
		add(btnEliminar);
	}
	
	/**
	 * Overrides the paintComponent method to draw a background image.
	 * @param g the Graphics object to protect.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(imagen.getImage(), 0, -20, ancho, alto, this);
	}
	

/**
 * Generates a JButton with specific properties.
 * @param texto the text to display on the button.
 * @param x the x-coordinate of the button's top-left corner.
 * @param y the y-coordinate of the button's top-left corner.
 * @param ancho the width of the button.
 * @param alto the height of the button.
 * @param url the URL of the image icon to set on the button.
 * @return the generated JButton.
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
 * Generates a JTextField with specific properties.
 * @param x the x-coordinate of the text field's top-left corner.
 * @param y the y-coordinate of the text field's top-left corner.
 * @param ancho the width of the text field.
 * @param alto the height of the text field.
 * @return the generated JTextField.
 */
	public JTextField generarEscritura(int x, int y, int ancho, int alto) {
		JTextField txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Banschrift", Font.BOLD, 15));
		txt.setBounds(x, y, ancho, alto);
		return txt;
	}

/**
 * @return the txtEliminarUsuario
 */
public JTextField getTxtEliminarUsuario() {
	return txtEliminarUsuario;
}

/**
 * @param txtEliminarUsuario the txtEliminarUsuario to set
 */
public void setTxtEliminarUsuario(JTextField txtEliminarUsuario) {
	this.txtEliminarUsuario = txtEliminarUsuario;
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


	
}


