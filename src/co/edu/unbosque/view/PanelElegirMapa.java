/**
 * package in charge of storing the entire graphical user interface
*/
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class to choose a type of map
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class PanelElegirMapa extends JPanel {
	/**
	 * JComboBox for selecting a map.
	 */
	private JComboBox mapa;

	/**
	 * JLabel for displaying the title.
	 */
	private JLabel lblTitulo;

	/**
	 * JButton for navigating back.
	 */
	private JButton btnVolver;

	/**
	 * JButton for selecting a map.
	 */
	private JButton btnSeleccionarMapa;

	/**
	 * JLabel for displaying a logo image.
	 */
	private JLabel lblImagenLogo2;
/**
 * PanelChooseMap constructor
 */
	public PanelElegirMapa() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.gray);

		lblImagenLogo2 = new JLabel();
		lblImagenLogo2.setBounds(0, 0, 1000, 600);
		Image imge = new ImageIcon("fotos/PanelElegirMapa.png").getImage();
		ImageIcon img2 = new ImageIcon(imge.getScaledInstance(1000, 600, Image.SCALE_SMOOTH));
		lblImagenLogo2.setIcon(img2);

		btnVolver = generarBoton("Volver", 150, 490, 50, 50, "fotos/botonVolver.png");
		btnSeleccionarMapa = generarBoton("Enviar informacion director", 900, 505, 35, 35, "fotos/rueda.png");

		mapa = generarCajaMapas(190, 138, 360, 260);
		add(btnSeleccionarMapa);
		add(btnVolver);
//		add(lblTitulo);
		add(mapa);
		add(lblImagenLogo2);
		repaint();
	}

	/**
	 * Generates a JComboBox for selecting maps.
	 * 
	 * @param x     The x-coordinate of the JComboBox.
	 * @param y     The y-coordinate of the JComboBox.
	 * @param ancho The width of the JComboBox.
	 * @param alto  The height of the JComboBox.
	 * @return The generated JComboBox for selecting maps.
	 */
	public JComboBox generarCajaMapas(int x, int y, int ancho, int alto) {
		String[] mapa = { "montaña", "semillano", "plano", "llano" };

		ImageIcon[] banderaMapa = new ImageIcon[mapa.length];

		for (int i = 0; i < banderaMapa.length; i++) {
			banderaMapa[i] = new ImageIcon("mapas/" + mapa[i] + ".png");
			banderaMapa[i].setDescription(mapa[i]);
		}
		JComboBox box = new JComboBox(banderaMapa);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Etna", Font.BOLD, 15));
		return box;

	}

/**
 * Generates a JButton with specified properties.
 * 
 * @param texto The text displayed on the button.
 * @param x     The x-coordinate of the button.
 * @param y     The y-coordinate of the button.
 * @param ancho The width of the button.
 * @param alto  The height of the button.
 * @param url   The URL of the image icon for the button.
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
 * @return the mapa
 */
public JComboBox getMapa() {
	return mapa;
}

/**
 * @param mapa the mapa to set
 */
public void setMapa(JComboBox mapa) {
	this.mapa = mapa;
}

/**
 * @return the lblTitulo
 */
public JLabel getLblTitulo() {
	return lblTitulo;
}

/**
 * @param lblTitulo the lblTitulo to set
 */
public void setLblTitulo(JLabel lblTitulo) {
	this.lblTitulo = lblTitulo;
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
 * @return the btnSeleccionarMapa
 */
public JButton getBtnSeleccionarMapa() {
	return btnSeleccionarMapa;
}

/**
 * @param btnSeleccionarMapa the btnSeleccionarMapa to set
 */
public void setBtnSeleccionarMapa(JButton btnSeleccionarMapa) {
	this.btnSeleccionarMapa = btnSeleccionarMapa;
}

/**
 * @return the lblImagenLogo2
 */
public JLabel getLblImagenLogo2() {
	return lblImagenLogo2;
}

/**
 * @param lblImagenLogo2 the lblImagenLogo2 to set
 */
public void setLblImagenLogo2(JLabel lblImagenLogo2) {
	this.lblImagenLogo2 = lblImagenLogo2;
}


}