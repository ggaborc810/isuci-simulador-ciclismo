/**
 * model package, is where the attributes are found for the creation of objects, whether cyclists, masseuses or other types of users within the application.
 */
package co.edu.unbosque.model;

import java.io.Serializable;
/**
 * User Parent Class
 *
 * @author Juan Diego Triana Mejía
 * @author Juan David Guarnizo Martínez
 * @author Gabriel Alejandro Ruiz Cruz
 */
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	 /**
     * The name of the cyclist.
     */
    private String nombre;

    /**
     * The ID number of the cyclist.
     */
    private long cedula;

    /**
     * The gender of the cyclist.
     */
    private String genero;

    /**
     * The email address of the cyclist.
     */
    private String correoElectronico;

    /**
     * The ID of the cyclist.
     */
    private String id;

    /**
     * The password of the cyclist.
     */
    private String contrasenia;

    /**
     * The team or squad the cyclist belongs to.
     */
    private String escuadra = "";

    
    /**
     * Constructs a new UsuarioDTO object with an empty team.
     */
    	public UsuarioDTO() {
    		escuadra = "";
    	}


    /**
     * Constructs a new UsuarioDTO object with the specified attributes.
     * 
     * @param nombre            The name of the user.
     * @param cedula            The ID number of the user.
     * @param genero            The gender of the user.
     * @param correoElectronico The email address of the user.
     * @param id                The ID of the user.
     * @param contrasenia       The password of the user.
     */

	public UsuarioDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.genero = genero;
		this.correoElectronico = correoElectronico;
		this.id = id;
		this.contrasenia = contrasenia;
		this.escuadra = "";
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre;
	}
	/**
	 * Gets the name of the user.
	 * 
	 * @return The name of the user.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Sets the name of the user.
	 * 
	 * @param nombre The name of the user.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

/**
 * Gets the ID number of the user.
 * 
 * @return The ID number of the user.
 */
	public long getCedula() {
		return cedula;
	}
	/**
	 * Sets the ID number of the user.
	 * 
	 * @param cedula The ID number of the user.
	 */
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	/**
	 * Gets the gender of the user.
	 * 
	 * @return The gender of the user.
	 */
	public String getGenero() {
		return genero;
	}

/**
 * Sets the gender of the user.
 * 
 * @param genero The gender of the user.
 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/**
	 * Gets the email address of the user.
	 * 
	 * @return The email address of the user.
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

/**
 * Sets the email address of the user.
 * 
 * @param correoElectronico The email address of the user.
 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	/**
	 * Gets the ID of the user.
	 * 
	 * @return The ID of the user.
	 */
	public String getId() {
		return id;
	}
	/**
	 * Sets the ID of the user.
	 * 
	 * @param id The ID of the user.
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Gets the password of the user.
	 * 
	 * @return The password of the user.
	 */
	public String getContrasenia() {
		return contrasenia;
	}
	/**
	 * Sets the password of the user.
	 * 
	 * @param contrasenia The password of the user.
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

/**
 * Gets the version UID of the class.
 * 
 * @return The version UID of the class.
 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * Gets the team of the user.
	 * 
	 * @return The team of the user.
	 */
	public String getEscuadra() {
		return escuadra;
	}

/**
 * Sets the team of the user.
 * 
 * @param escuadra The team of the user.
 */
	public void setEscuadra(String escuadra) {
		this.escuadra = escuadra;
	}


}