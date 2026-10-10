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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCrearEscuadra extends JPanel {

	// Declaration of variables

	/**
	 * The text field for entering the squad name.
	 */
	private JTextField txtNombreEscuadra;

	/**
	 * The text field for entering the nationality.
	 */
	private JTextField txtNacionalidad;

	/**
	 * The button for going back to the previous screen.
	 */
	private JButton btnVolver;

	/**
	 * The background image for the component.
	 */
	private ImageIcon imagen;

	/**
	 * The button for registering the information.
	 */
	private JButton btnRegistrar;

	/**
	 * The combo box for selecting the country.
	 */
	private JComboBox pais;

	/**
	 * The combo box for selecting the classic hands cyclist.
	 */
	private JComboBox ciclistaClasicoManos;

	/**
	 * The combo box for selecting the time trial cyclist.
	 */
	private JComboBox ciclistaContraReloj;

	/**
	 * The combo box for selecting the sprinter cyclist.
	 */
	private JComboBox ciclistaEmbalador;

	/**
	 * The combo box for selecting the climber cyclist.
	 */
	private JComboBox ciclistaEscalador;

	/**
	 * The combo box for selecting the gregario cyclist.
	 */
	private JComboBox ciclistaGregario;

	/**
	 * The combo box for selecting the roller cyclist.
	 */
	private JComboBox ciclistaRodador;

	/**
	 * The combo box for selecting the masseur.
	 */
	private JComboBox masajista;

	/**
	 * class constructor PanelCrearEscuadra
	 */
	public PanelCrearEscuadra() {
		setSize(1000, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);

		txtNombreEscuadra = generarEscritura(235, 83, 230, 25);
		txtNacionalidad = generarEscritura(140, 202, 280, 30);

		btnVolver = generarBoton("Volver de crear director", 150, 490, 50, 50, "fotos/btnvolver.png");
		btnRegistrar = generarBoton("Enviar informacion director", 900, 505, 35, 35, "fotos/rueda.png");

		imagen = new ImageIcon("fotos/PanelCrearEscuadra.png");
		pais = generarCajaPaises(770, 80, 190, 30);
		ciclistaClasicoManos = generarCajaCiclistasClasicoManos(230, 201, 235, 27);
		ciclistaContraReloj = generarCajaCiclistasContraReloj(230, 268, 235, 27);
		ciclistaEmbalador = generarCajaCiclistasClasicoManos(230, 345, 235, 27);
		ciclistaEscalador = generarCajaCiclistasClasicoManos(230, 415, 235, 27);
		ciclistaGregario = generarCajaCiclistasClasicoManos(700, 199, 245, 27);
		ciclistaRodador = generarCajaCiclistasClasicoManos(700, 268, 245, 27);
		masajista = generarCajaMasajistas(700, 345, 245, 27);

		add(txtNombreEscuadra);
		add(btnVolver);
		add(btnRegistrar);
		add(pais);
		add(ciclistaClasicoManos);
		add(ciclistaContraReloj);
		add(ciclistaEmbalador);
		add(ciclistaEscalador);
		add(ciclistaGregario);
		add(ciclistaRodador);
		add(masajista);
//		
//		repaint();

	}

	/**
	 * Method for generating buttons
	 * 
	 * @param texto
	 * @param x
	 * @param y
	 * @param ancho
	 * @param alto
	 * @param url
	 * @return
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
	 * Method for generating text fields
	 * 
	 * @param x
	 * @param y
	 * @param ancho
	 * @param alto
	 * @return
	 */
	public JTextField generarEscritura(int x, int y, int ancho, int alto) {
		JTextField txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Banschrift", Font.BOLD, 15));
		txt.setBounds(x, y, ancho, alto);
		return txt;
	}

	/**
	 * Method for painting the background
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1000;
		int alto = 600;
		g.drawImage(imagen.getImage(), 0, -20, ancho, alto, this);
	}

	/**
	 * Method for generating combo boxes for different cyclist types
	 * 
	 * @param x
	 * @param y
	 * @param ancho
	 * @param alto
	 * @return
	 */
	public JComboBox generarCajaCiclistasClasicoManos(int x, int y, int ancho, int alto) {
		String[] ciclistaClasicoMano = { "" };
		JComboBox box = new JComboBox(ciclistaClasicoMano);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Etna", Font.BOLD, 12));
		return box;
	}

	public JComboBox generarCajaCiclistasContraReloj(int x, int y, int ancho, int alto) {
		String[] ciclistaContraReloj = { "" };
		JComboBox box = new JComboBox(ciclistaContraReloj);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Etna", Font.BOLD, 12));
		return box;
	}

	public JComboBox generarCajaCiclistasEmbalador(int x, int y, int ancho, int alto) {
		String[] ciclistaEmbalador = { "" };
		JComboBox box = new JComboBox(ciclistaEmbalador);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Etna", Font.BOLD, 12));
		return box;
	}

	public JComboBox generarCajaCiclistasEscalador(int x, int y, int ancho, int alto) {
		String[] ciclistaEscalador = { "" };
		JComboBox box = new JComboBox(ciclistaEscalador);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Etna", Font.BOLD, 12));
		return box;
	}

	public JComboBox generarCajaCiclistasGregario(int x, int y, int ancho, int alto) {
		String[] ciclistaGregario = { "" };
		JComboBox box = new JComboBox(ciclistaGregario);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Etna", Font.BOLD, 12));
		return box;
	}

	public JComboBox generarCajaCiclistasRodador(int x, int y, int ancho, int alto) {
		String[] ciclistaRodador = { "" };
		JComboBox box = new JComboBox(ciclistaRodador);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Etna", Font.BOLD, 12));
		return box;
	}

	/**
	 * Method to generate the massage therapist combo box
	 * 
	 * @param x
	 * @param y
	 * @param ancho
	 * @param alto
	 * @return
	 */
	public JComboBox generarCajaMasajistas(int x, int y, int ancho, int alto) {
		String[] masajista = { "" };
		JComboBox box = new JComboBox(masajista);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Etna", Font.BOLD, 12));
		return box;
	}

	/**
	 * Method for generating the combo box for countries
	 * 
	 * @param x
	 * @param y
	 * @param ancho
	 * @param alto
	 * @return
	 */
	public JComboBox generarCajaPaises(int x, int y, int ancho, int alto) {
		String[] bandera = { "", "ghana", "granada", "grecia", "guatemala", "guinea", "guinea_bissau",
				"guinea_ecuatorial", "guyana", "honduras", "hungria", "india", "indonesia", "inglaterra", "irak",
				"iran", "irlanda", "islandia", "islas_marshall", "islas_salomon", "israel", "italia", "jamaica",
				"japon", "jordania", "kazajistan", "kenia", "kirguistan", "kiribati", "kuwait", "laos", "lesoto",
				"letonia", "libano", "liberia", "libia", "liechtenstein", "lituania", "luxemburgo",
				"macedonia_del_norte", "madagascar", "malasia", "malaui", "maldivas", "mali", "malta", "marruecos",
				"mauricio", "mauritania", "mexico", "afganistan", "albania", "alemania", "andorra", "angola",
				"antigua_y_barbuda", "arabia_saudi", "argelia", "argentina", "armenia", "australia", "austria",
				"bahamas", "bangladesh", "barbados", "belgica", "belice", "benin", "bielorrusia", "birmania", "bolivia",
				"bosnia", "botsuana", "brasil", "brunei", "bulgaria", "burkina_faso", "burundi", "butan", "cabo_verde",
				"camboya", "camerun", "canada", "chad", "chile", "china", "chipre", "ciudad_del_vaticano", "colombia",
				"comoras", "corea_del_norte", "corea_del_sur", "costa_de_marfil", "costa_rica", "croacia", "cuba",
				"dinamarca", "ecuador", "egipto", "emiratos_arabes_unidos", "eritrea", "eslovaquia", "eslovenia",
				"españa", "estonia", "etiopia", "micronesia", "moldavia", "monaco", "mongolia", "montenegro",
				"mozambique", "namibia", "nauru", "nepal", "nicaragua", "niger", "nigeria", "noruega", "nueva_zelanda",
				"oman", "paises_bajos", "pakistan", "palaos", "panama", "papua_nueva_guinea", "paraguay", "peru",
				"polonia", "portugal", "qatar", "reino_unido", "republica_centroafricana", "republica_checa",
				"republica_del_congo", "republica_democratica_del_congo", "republica_dominicana", "ruanda", "rumania",
				"rusia", "salvador", "samoa", "san_cristobal_y_nieves", "san_marino", "san_vicente_y_las_granadinas",
				"santa_lucia", "santo_tome_y_principe", "senegal", "serbia", "seychelles", "sicilia", "sierra_leona",
				"singapur", "siria", "somalia", "srilanka", "suazilandia", "sudafrica", "sudan", "sudan_del_sur",
				"suecia", "suiza", "surinam", "tailandia", "taiwan", "tanzania", "tayikistan", "timor_oriental", "togo",
				"tonga", "trinidad_y_tobago", "tunez", "turkmenistan", "turquia", "tuvalu", "ucrania", "uganda",
				"uruguay", "usa", "uzbekistan", "vanuatu", "venezuela", "vietnam", "yemen", "yibuti", "zambia",
				"zimbabue", "filipinas", "finlandia", "fiyi", "francia", "gabon", "gales", "gambia", "georgia", };

		ImageIcon[] banderaIcono = new ImageIcon[bandera.length];

		for (int i = 0; i < banderaIcono.length; i++) {
			banderaIcono[i] = new ImageIcon("banderas/" + bandera[i] + ".png");
			banderaIcono[i].setDescription(bandera[i]);
		}

		JComboBox box = new JComboBox(banderaIcono);
		box.setBounds(x, y, ancho, alto);
		box.setFont(new Font("Pokemon GB", Font.BOLD, 15));
		return box;
	}

	/**
	 * @return the txtNombreEscuadra
	 */
	public JTextField getTxtNombreEscuadra() {
		return txtNombreEscuadra;
	}

	/**
	 * @param txtNombreEscuadra the txtNombreEscuadra to set
	 */
	public void setTxtNombreEscuadra(JTextField txtNombreEscuadra) {
		this.txtNombreEscuadra = txtNombreEscuadra;
	}

	/**
	 * @return the txtNacionalidad
	 */
	public JTextField getTxtNacionalidad() {
		return txtNacionalidad;
	}

	/**
	 * @param txtNacionalidad the txtNacionalidad to set
	 */
	public void setTxtNacionalidad(JTextField txtNacionalidad) {
		this.txtNacionalidad = txtNacionalidad;
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
	 * @return the btnRegistrar
	 */
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	/**
	 * @param btnRegistrar the btnRegistrar to set
	 */
	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	/**
	 * @return the pais
	 */
	public JComboBox getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(JComboBox pais) {
		this.pais = pais;
	}

	/**
	 * @return the ciclistaClasicoManos
	 */
	public JComboBox getCiclistaClasicoManos() {
		return ciclistaClasicoManos;
	}

	/**
	 * @param ciclistaClasicoManos the ciclistaClasicoManos to set
	 */
	public void setCiclistaClasicoManos(JComboBox ciclistaClasicoManos) {
		this.ciclistaClasicoManos = ciclistaClasicoManos;
	}

	/**
	 * @return the ciclistaContraReloj
	 */
	public JComboBox getCiclistaContraReloj() {
		return ciclistaContraReloj;
	}

	/**
	 * @param ciclistaContraReloj the ciclistaContraReloj to set
	 */
	public void setCiclistaContraReloj(JComboBox ciclistaContraReloj) {
		this.ciclistaContraReloj = ciclistaContraReloj;
	}

	/**
	 * @return the ciclistaEmbalador
	 */
	public JComboBox getCiclistaEmbalador() {
		return ciclistaEmbalador;
	}

	/**
	 * @param ciclistaEmbalador the ciclistaEmbalador to set
	 */
	public void setCiclistaEmbalador(JComboBox ciclistaEmbalador) {
		this.ciclistaEmbalador = ciclistaEmbalador;
	}

	/**
	 * @return the ciclistaEscalador
	 */
	public JComboBox getCiclistaEscalador() {
		return ciclistaEscalador;
	}

	/**
	 * @param ciclistaEscalador the ciclistaEscalador to set
	 */
	public void setCiclistaEscalador(JComboBox ciclistaEscalador) {
		this.ciclistaEscalador = ciclistaEscalador;
	}

	/**
	 * @return the ciclistaGregario
	 */
	public JComboBox getCiclistaGregario() {
		return ciclistaGregario;
	}

	/**
	 * @param ciclistaGregario the ciclistaGregario to set
	 */
	public void setCiclistaGregario(JComboBox ciclistaGregario) {
		this.ciclistaGregario = ciclistaGregario;
	}

	/**
	 * @return the ciclistaRodador
	 */
	public JComboBox getCiclistaRodador() {
		return ciclistaRodador;
	}

	/**
	 * @param ciclistaRodador the ciclistaRodador to set
	 */
	public void setCiclistaRodador(JComboBox ciclistaRodador) {
		this.ciclistaRodador = ciclistaRodador;
	}

	/**
	 * @return the masajista
	 */
	public JComboBox getMasajista() {
		return masajista;
	}

	/**
	 * @param masajista the masajista to set
	 */
	public void setMasajista(JComboBox masajista) {
		this.masajista = masajista;
	}


}