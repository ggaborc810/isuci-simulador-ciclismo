package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.unbosque.model.persistence.FileHandler;

public class PanelPortada extends JPanel {

	private Properties propertiesInfoV;
	private JLabel lblTitulo;
	private JLabel lblTitulo2;
	private JLabel imagen;
	private JButton btnEntrar;
	private JLabel lblEntrar;
	private JLabel lblEntrar2;
	private ImageIcon fondo;

	public PanelPortada() {
//		propertiesInfoV = FileHandler.cargarPropiedades("datos/ventana.properties");
//		String titulo = propertiesInfoV.getProperty("ventana.title");
//		int posX = Integer.parseInt(propertiesInfoV.getProperty("ventana.size.horizontal"));
//		int posY = Integer.parseInt(propertiesInfoV.getProperty("ventana.size.vertical"));

		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.white);

		fondo = new ImageIcon("fotos/PanelPortada.png");
		lblTitulo = generarLabel("ISUCI", 120, -380, 899, 899);
		lblTitulo.setFont(new Font("impact", 80, 80));
		lblEntrar2 = generarLabel("Union Cycliste Internationale", 55, 35, 460, 250);

		lblTitulo.setFont(new Font("ISUCI", 80, 80));

		lblTitulo.setForeground(Color.decode("#FCFF70"));

		lblTitulo.setFont(new Font("Britannic Bold", 75, 75));

		btnEntrar = generarBoton("INICIAR", 90, 210, 300, 300, "fotos/botonPortada.png");
		lblEntrar = generarLabel("ISUCI", 85, -160, 500, 500);
		lblEntrar2 = generarLabel("Union Cycliste Internationale", 55, 35, 460, 250);
		lblEntrar.setFont(new Font("Britannic Bold", 140, 140));
		lblEntrar2.setFont(new Font("Etna", 29, 29));
		lblEntrar.setForeground(Color.decode("#19374F"));
		lblEntrar2.setForeground(Color.decode("#19374F"));

		imagen = new JLabel();
		imagen.setBounds(-20, -50, 1300, 800);
		Image img = new ImageIcon("fotos/logo.png").getImage();
		ImageIcon imgT = new ImageIcon(img.getScaledInstance(600, 550, Image.SCALE_SMOOTH));
		imagen.setIcon(imgT);

//		add(lblTitulo);
		add(btnEntrar);
		add(lblEntrar);
		add(lblEntrar2);

//		add(imagen);
		repaint();
	}

	public JLabel generarImagen(String url, int x, int y) {
		JLabel image = new JLabel();
		image.setBounds(x, y, 1300, 800);
		Image img = new ImageIcon(url).getImage();
		ImageIcon imgT = new ImageIcon(img.getScaledInstance(32, 32, Image.SCALE_SMOOTH));
		image.setIcon(imgT);
		return image;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(fondo.getImage(), 0, 0, ancho, alto, this);
	}

	public JLabel generarLabel(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Etna", Font.BOLD, 22));
		lbl.setForeground(Color.BLACK);
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}

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

	public Properties getPropertiesInfoV() {
		return propertiesInfoV;
	}

	public void setPropertiesInfoV(Properties propertiesInfoV) {
		this.propertiesInfoV = propertiesInfoV;
	}

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public void setBtnEntrar(JButton btnEntrar) {
		this.btnEntrar = btnEntrar;
	}

}
