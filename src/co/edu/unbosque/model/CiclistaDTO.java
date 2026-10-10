/**
 * model package, is where the attributes are found for the creation of objects, whether cyclists, masseuses or other types of users within the application.
 */
package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * 
 * Class that inherits attributes from the userDTO class, this class will be in
 * charge of creating objects that are cyclists
 * 
 * @see UsuarioDTO
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class CiclistaDTO extends UsuarioDTO implements Serializable {

	/**
	 * Unique identifier for the user.
	 */
	private int identificador;

	/**
	 * Total accumulated time of the user.
	 */
	private double tiempoAcumulado;

	/**
	 * Physical build or physique of the user.
	 */
	private String contextura;

	/**
	 * Pedaling cadence of the user.
	 */
	private double cadenciaPedaleo;

	/**
	 * Years of experience of the user.
	 */
	private int aniosExperiencia;

	public CiclistaDTO() {
	}

	/**
	 * Constructs a new CiclistaDTO object with specified values for all fields.
	 * 
	 * @param identificador    Unique identifier for the cyclist.
	 * @param tiempoAcumulado  Accumulated time of the cyclist.
	 * @param contextura       Physical build or physique of the cyclist.
	 * @param cadenciaPedaleo  Pedaling cadence of the cyclist.
	 * @param aniosExperiencia Years of experience of the cyclist.
	 */
	public CiclistaDTO(int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia) {
		super();
		this.identificador = identificador;
		this.tiempoAcumulado = tiempoAcumulado;
		this.contextura = contextura;
		this.cadenciaPedaleo = cadenciaPedaleo;
		this.aniosExperiencia = aniosExperiencia;
	}

	/**
	 * Constructs a new CiclistaDTO object with specified values for certain fields.
	 * 
	 * @param nombre           The name of the cyclist.
	 * @param identificador    Unique identifier for the cyclist.
	 * @param aniosExperiencia Years of experience of the cyclist.
	 * @param tiempoAcumulado  Accumulated time of the cyclist.
	 * @param cadenciaPedaleo  Pedaling cadence of the cyclist.
	 */
	public CiclistaDTO(String nombre, int identificador, int aniosExperiencia, double tiempoAcumulado,
			double cadenciaPedaleo) {
		super(nombre, 0, "", "", "", "");
		this.identificador = identificador;
		this.aniosExperiencia = aniosExperiencia;
		this.tiempoAcumulado = tiempoAcumulado;
		this.cadenciaPedaleo = cadenciaPedaleo;
	}

	/**
	 * Constructs a new CiclistaDTO object with specified values for both user
	 * information and cyclist attributes.
	 * 
	 * @param nombre            The name of the cyclist.
	 * @param cedula            The ID number of the cyclist.
	 * @param genero            The gender of the cyclist.
	 * @param correoElectronico The email address of the cyclist.
	 * @param id                The user ID of the cyclist.
	 * @param contrasenia       The password of the cyclist.
	 * @param identificador     The unique identifier of the cyclist.
	 * @param tiempoAcumulado   The accumulated time of the cyclist.
	 * @param contextura        The physical build or body type of the cyclist.
	 * @param cadenciaPedaleo   The pedaling cadence of the cyclist.
	 * @param aniosExperiencia  The years of experience of the cyclist.
	 */
	public CiclistaDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		this.identificador = identificador;
		this.tiempoAcumulado = tiempoAcumulado;
		this.contextura = contextura;
		this.cadenciaPedaleo = cadenciaPedaleo;
		this.aniosExperiencia = aniosExperiencia;
	}

	/**
	 * Constructs a new CiclistaDTO object with the specified user information.
	 * 
	 * @param nombre            The name of the cyclist.
	 * @param cedula            The ID number of the cyclist.
	 * @param genero            The gender of the cyclist.
	 * @param correoElectronico The email address of the cyclist.
	 * @param id                The user ID of the cyclist.
	 * @param contrasenia       The password of the cyclist.
	 */
	public CiclistaDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns a string representation of the CiclistaDTO object, including user
	 * information and identifier.
	 * 
	 * @return A string representation of the object, including user information and
	 *         identifier.
	 */
	@Override
	public String toString() {
		// Call the toString() method of the superclass to get user information, then
		// append the identifier
		return super.toString() + ", Id: " + identificador;
	}

	/**
	 * @return the identificador
	 */
	public int getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	/**
	 * @return the tiempoAcumulado
	 */
	public double getTiempoAcumulado() {
		return tiempoAcumulado;
	}

	/**
	 * @param tiempoAcumulado the tiempoAcumulado to set
	 */
	public void setTiempoAcumulado(double tiempoAcumulado) {
		this.tiempoAcumulado = tiempoAcumulado;
	}

	/**
	 * @return the contextura
	 */
	public String getContextura() {
		return contextura;
	}

	/**
	 * @param contextura the contextura to set
	 */
	public void setContextura(String contextura) {
		this.contextura = contextura;
	}

	/**
	 * @return the cadenciaPedaleo
	 */
	public double getCadenciaPedaleo() {
		return cadenciaPedaleo;
	}

	/**
	 * @param cadenciaPedaleo the cadenciaPedaleo to set
	 */
	public void setCadenciaPedaleo(double cadenciaPedaleo) {
		this.cadenciaPedaleo = cadenciaPedaleo;
	}

	/**
	 * @return the aniosExperiencia
	 */
	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	/**
	 * @param aniosExperiencia the aniosExperiencia to set
	 */
	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

}