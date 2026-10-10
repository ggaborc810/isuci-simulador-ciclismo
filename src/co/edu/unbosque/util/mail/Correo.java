/**
 * package where the classes that have to do with mail are located
 */
package co.edu.unbosque.util.mail;

/**
 * Class representing an email.
 * 
 * @see CiclistaDTO
 * @author Juan Diego Triana Mejía
 * @author Juan David Guarnizo Martínez
 * @author Gabriel Alejandro Ruiz Cruz
 */
public class Correo {
	/**
	 * Recipient's email address
	 * 
	 * @type String
	 */
	private String para;
	/**
	 * Email content
	 * 
	 * @type String.
	 */
	private String contenido = "Your profile has been created";
	/**
	 * Email subject
	 * 
	 * @type String
	 */
	private String asunto = "Successful Creation (ISUSI)";
	/**
	 * Sender's email address
	 * 
	 * @type String
	 */
	private String de = "isucisimulator@gmail.com";

	/**
	 * Sender's password
	 * 
	 * @type String
	 */
	private String contrasenia = "TU_CONTRASENA_DE_APLICACION";

	/**
	 * Constructor of the Correo class.
	 * 
	 * @param para
	 * @param contenido
	 * @param asunto
	 * @param de
	 * @param contrasenia
	 */
	public Correo(String para, String contenido, String asunto, String de, String contrasenia) {
		super();
		this.para = para;
		this.contenido = contenido;
		this.asunto = asunto;
		this.de = de;
		this.contrasenia = contrasenia;
	}

	/**
	 * Empty constructor of the Correo class.
	 */
	public Correo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the recipient's email address.
	 * 
	 * @return The recipient's email address.
	 */
	public String getPara() {
		return para;
	}

	/**
	 * Sets the recipient's email address.
	 * 
	 * @param para The recipient's email address.
	 */
	public void setPara(String para) {
		this.para = para;
	}

	/**
	 * Gets the email content.
	 * 
	 * @return The email content.
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * Sets the email content.
	 * 
	 * @param contenido The email content.
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * Gets the email subject.
	 * 
	 * @return The email subject.
	 */
	public String getAsunto() {
		return asunto;
	}

	/**
	 * Sets the email subject.
	 * 
	 * @param asunto The email subject.
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	/**
	 * Gets the sender's email address.
	 * 
	 * @return The sender's email address.
	 */
	public String getDe() {
		return de;
	}

	/**
	 * Sets the sender's email address.
	 * 
	 * @param de The sender's email address.
	 */
	public void setDe(String de) {
		this.de = de;
	}

	/**
	 * Gets the sender's password.
	 * 
	 * @return The sender's password.
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * Sets the sender's password.
	 * 
	 * @param contrasenia The sender's password.
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
