package co.edu.unbosque.view;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class PanelSeleccionCiclista extends JScrollPane {
	private ImageIcon imagen;
	private JTextField txtEscuadra;
	private JTextField txtEscuadra1;
	private JTextField txtEscuadra2;
	private JTextField txtEscuadra3;
	private JTextField txtEscuadra4;
	private JTextField txtEscuadra5;
	private JButton btnVolver;
	private JButton btnAgregar;
	private JLabel lblVolver;
	private TableModel model;
	private JButton btnBuscar;
	private JButton btnBuscar1;
	private JButton btnBuscar2;
	private JButton btnBuscar3;
	private JButton btnBuscar4;
	private JButton btnBuscar5;
	private JLabel lblBuscar;
	private JComboBox boxCiclista;
	private JTable tablaCiclistas;
	private JTable tablaCiclistas1;
	private JTable tablaCiclistas2;
	private JTable tablaCiclistas3;
	private JTable tablaCiclistas4;
	private JTable tablaCiclistas5;

	public PanelSeleccionCiclista() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.gray);

		txtEscuadra = generarEscritura(50, 120, 100, 30);
		txtEscuadra1 = generarEscritura(210, 120, 100, 30);
		txtEscuadra2 = generarEscritura(370, 120, 100, 30);
		txtEscuadra3 = generarEscritura(530, 120, 100, 30);
		txtEscuadra4 = generarEscritura(680, 120, 100, 30);
		txtEscuadra5 = generarEscritura(850, 120, 100, 30);
		btnBuscar = generarBoton("Buscar Escuadra", 10, 120, 35, 35, "fotos/rueda.png");
		btnBuscar1 = generarBoton("Buscar Escuadra", 170, 120, 35, 35, "fotos/rueda.png");
		btnBuscar2 = generarBoton("Buscar Escuadra", 330, 120, 35, 35, "fotos/rueda.png");
		btnBuscar3 = generarBoton("Buscar Escuadra", 490, 120, 35, 35, "fotos/rueda.png");
		btnBuscar4 = generarBoton("Buscar Escuadra", 640, 120, 35, 35, "fotos/rueda.png");
		btnBuscar5 = generarBoton("Buscar Escuadra", 810, 120, 35, 35, "fotos/rueda.png");
		btnAgregar = generarBoton("Empezar simulacion", 350, 515, 35, 35, "fotos/rueda.png");
		lblBuscar = generarMensaje("Empezar simulacion", 400, 505, 300, 50);
		lblBuscar.setFont(new Font("Banschrift", Font.BOLD, 20));
		imagen = new ImageIcon("fotos/PanelSeleccionarCiclista.png");
		btnVolver = generarBoton("Volver", 40, 505, 50, 50, "fotos/botonVolver.png");
		lblVolver = generarMensaje("Volver", 90, 505, 100, 50);
		boxCiclista = generarCajaMasajistas(230, 345, 235, 27);

		String[] columnNames = { "id", "Nombre Ciclista", "Tipo" };

		String[][] data = { columnNames, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }

		};

		String[][] data1 = { columnNames, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }

		};

		String[][] data2 = { columnNames, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }

		};

		String[][] data3 = { columnNames, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }

		};

		String[][] data4 = { columnNames, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }

		};

		String[][] data5 = { columnNames, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" },
				{ "", "", "" }, { "", "", "" }

		};

		// Initializing the JTable
		tablaCiclistas = new JTable(data, columnNames);
		tablaCiclistas.setBounds(20, 180, 200, 120);
		tablaCiclistas.setVisible(false);

		tablaCiclistas1 = new JTable(data1, columnNames);
		tablaCiclistas1.setBounds(20, 350, 200, 120);
		tablaCiclistas1.setVisible(false);

		tablaCiclistas2 = new JTable(data2, columnNames);
		tablaCiclistas2.setBounds(270, 180, 200, 120);
		tablaCiclistas2.setVisible(false);

		tablaCiclistas3 = new JTable(data3, columnNames);
		tablaCiclistas3.setBounds(270, 350, 200, 120);
		tablaCiclistas3.setVisible(false);

		tablaCiclistas4 = new JTable(data4, columnNames);
		tablaCiclistas4.setBounds(600, 180, 200, 120);
		tablaCiclistas4.setVisible(false);

		tablaCiclistas5 = new JTable(data5, columnNames);
		tablaCiclistas5.setBounds(600, 350, 200, 120);
		tablaCiclistas5.setVisible(false);

		add(txtEscuadra);
		add(btnBuscar);
		add(btnBuscar1);
		add(btnBuscar2);
		add(btnBuscar3);
		add(btnBuscar4);
		add(btnBuscar5);
		add(lblBuscar);
		add(txtEscuadra1);
		add(txtEscuadra2);
		add(txtEscuadra3);
		add(txtEscuadra4);
		add(txtEscuadra5);
	

		add(tablaCiclistas);
		add(tablaCiclistas1);
		add(tablaCiclistas2);
		add(tablaCiclistas3);
		add(tablaCiclistas4);
		add(tablaCiclistas5);

		add(btnVolver);
		add(lblVolver);
		add(btnAgregar);

	}

	public JButton getBtnBuscar1() {
		return btnBuscar1;
	}

	public void setBtnBuscar1(JButton btnBuscar1) {
		this.btnBuscar1 = btnBuscar1;
	}

	public JButton getBtnBuscar2() {
		return btnBuscar2;
	}

	public void setBtnBuscar2(JButton btnBuscar2) {
		this.btnBuscar2 = btnBuscar2;
	}

	public JButton getBtnBuscar3() {
		return btnBuscar3;
	}

	public void setBtnBuscar3(JButton btnBuscar3) {
		this.btnBuscar3 = btnBuscar3;
	}

	public JButton getBtnBuscar4() {
		return btnBuscar4;
	}

	public void setBtnBuscar4(JButton btnBuscar4) {
		this.btnBuscar4 = btnBuscar4;
	}

	public JButton getBtnBuscar5() {
		return btnBuscar5;
	}

	public void setBtnBuscar5(JButton btnBuscar5) {
		this.btnBuscar5 = btnBuscar5;
	}

	public void limpiarTabla() {
		tablaCiclistas.clearSelection();
		tablaCiclistas1.clearSelection();
		tablaCiclistas2.remove(tablaCiclistas2);
		tablaCiclistas3.remove(tablaCiclistas3);
		tablaCiclistas4.remove(tablaCiclistas4);
		tablaCiclistas5.remove(tablaCiclistas5);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(imagen.getImage(), 0, -20, ancho, alto, this);
	}

	public JComboBox generarCajaMasajistas(int x, int y, int ancho, int alto) {
		String[] masajista = { "" };
		JComboBox box = new JComboBox(masajista);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Etna", Font.BOLD, 12));
		return box;
	}

	public JLabel generarMensaje(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Banschrift", Font.BOLD, 21));
		lbl.setForeground(Color.WHITE);
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

	public JTextField generarEscritura(int x, int y, int ancho, int alto) {
		JTextField txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Banschrift", Font.BOLD, 15));
		txt.setBounds(x, y, ancho, alto);
		return txt;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JLabel getLblVolver() {
		return lblVolver;
	}

	public void setLblVolver(JLabel lblVolver) {
		this.lblVolver = lblVolver;
	}

	public TableModel getModel() {
		return model;
	}

	public void setModel(TableModel model) {
		this.model = model;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JLabel getLblBuscar() {
		return lblBuscar;
	}

	public void setLblBuscar(JLabel lblBuscar) {
		this.lblBuscar = lblBuscar;
	}

	public JComboBox getBoxCiclista() {
		return boxCiclista;
	}

	public void setBoxCiclista(JComboBox boxCiclista) {
		this.boxCiclista = boxCiclista;
	}

	public JTable getTablaCiclistas() {
		return tablaCiclistas;
	}

	public void setTablaCiclistas(JTable tablaCiclistas) {
		this.tablaCiclistas = tablaCiclistas;
	}



	public JTextField getTxtEscuadra() {
		return txtEscuadra;
	}

	public void setTxtEscuadra(JTextField txtEscuadra) {
		this.txtEscuadra = txtEscuadra;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}



	public JTextField getTxtEscuadra1() {
		return txtEscuadra1;
	}

	public void setTxtEscuadra1(JTextField txtEscuadra1) {
		this.txtEscuadra1 = txtEscuadra1;
	}

	public JTextField getTxtEscuadra2() {
		return txtEscuadra2;
	}

	public void setTxtEscuadra2(JTextField txtEscuadra2) {
		this.txtEscuadra2 = txtEscuadra2;
	}

	public JTextField getTxtEscuadra3() {
		return txtEscuadra3;
	}

	public void setTxtEscuadra3(JTextField txtEscuadra3) {
		this.txtEscuadra3 = txtEscuadra3;
	}

	public JTextField getTxtEscuadra4() {
		return txtEscuadra4;
	}

	public void setTxtEscuadra4(JTextField txtEscuadra4) {
		this.txtEscuadra4 = txtEscuadra4;
	}

	public JTextField getTxtEscuadra5() {
		return txtEscuadra5;
	}

	public void setTxtEscuadra5(JTextField txtEscuadra5) {
		this.txtEscuadra5 = txtEscuadra5;
	}

	public JTable getTablaCiclistas1() {
		return tablaCiclistas1;
	}

	public void setTablaCiclistas1(JTable tablaCiclistas1) {
		this.tablaCiclistas1 = tablaCiclistas1;
	}

	public JTable getTablaCiclistas2() {
		return tablaCiclistas2;
	}

	public void setTablaCiclistas2(JTable tablaCiclistas2) {
		this.tablaCiclistas2 = tablaCiclistas2;
	}

	public JTable getTablaCiclistas3() {
		return tablaCiclistas3;
	}

	public void setTablaCiclistas3(JTable tablaCiclistas3) {
		this.tablaCiclistas3 = tablaCiclistas3;
	}

	public JTable getTablaCiclistas4() {
		return tablaCiclistas4;
	}

	public void setTablaCiclistas4(JTable tablaCiclistas4) {
		this.tablaCiclistas4 = tablaCiclistas4;
	}

	public JTable getTablaCiclistas5() {
		return tablaCiclistas5;
	}

	public void setTablaCiclistas5(JTable tablaCiclistas5) {
		this.tablaCiclistas5 = tablaCiclistas5;
	}

}