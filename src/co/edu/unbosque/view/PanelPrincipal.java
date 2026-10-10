package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import co.edu.unbosque.model.persistence.FileHandler;

public class PanelPrincipal extends JFrame{

	private Properties propertiesInfoV;
	private JLabel lblTitulo;
	private JLabel lblTitulo2;
	private JLabel imagen;
	private JButton btnEntrar;
	private JLabel lblEntrar;

	public PanelPrincipal() {
		propertiesInfoV = FileHandler.cargarPropiedades("datos/ventana.properties");
		String titulo = propertiesInfoV.getProperty("ventana.title");
		int posX = Integer.parseInt(propertiesInfoV.getProperty("ventana.size.horizontal"));
		int posY = Integer.parseInt(propertiesInfoV.getProperty("ventana.size.vertical"));

		setBackground(Color.decode("#D31E1E"));
		setTitle(titulo);
		setSize(posX, posY);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		

		lblTitulo = generarLabel("SIMULADOR INTERNACIONAL", 170,60,900,900);
		lblTitulo2 = generarLabel("Ciclismo", 480,380,300,400);
		lblTitulo.setForeground(Color.decode("#BB4E26"));
		lblTitulo.setBackground(Color.decode("#FFF8DC"));
		lblTitulo.setFont(new Font("WC Mano Negra Bta", 10, 80));
		lblTitulo2.setFont(new Font("WC Mano Negra Bta", 10, 80));
		
		btnEntrar = generarBoton("INICIAR", 500, 650, 45, 45, "fotos/imagen1 (1).png");
		lblEntrar = generarLabel("Iniciar", 560, 645, 150, 50);
		lblEntrar.setFont(new Font("WC Mano Negra Bta", 10, 50));
		
		imagen = new JLabel();
		imagen.setBounds(230, -140, 1300, 900);
		Image img = new ImageIcon("fotos/logo.png").getImage();
		ImageIcon imgT = new ImageIcon(img.getScaledInstance(700, 550, Image.SCALE_SMOOTH));
		imagen.setIcon(imgT);
		
		add(imagen);
		add(lblTitulo);
		add(lblTitulo2);
		add(btnEntrar);
		add(lblEntrar);
	}
	
	public JLabel generarLabel(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel("");
		lbl.setBounds(x, y, ancho, alto);
		lbl.setText(texto);
		lbl.setVisible(true);

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

}
