/**
 * model package, is where the attributes are found for the creation of objects, whether cyclists, masseuses or other types of users within the application.
 */

package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Class that represents the masseuse.
 *
 * This class inherits from the `DTOUser` class
 *
 * @see UsuarioDTO
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */

public class MasajistaDTO extends UsuarioDTO implements Serializable {

	/**
	 * Years of experience
	 * 
	 * @type int
	 */
	private int aniosExperiencia;

	/**
	 * Constructor vacio de la clase MasajistaDTO
	 */
	public MasajistaDTO() {
	}

	/**
	 * Constructor that has as parameters the attributes of the class
	 *
	 * @param aniosExperiencia
	 */
	public MasajistaDTO(int aniosExperiencia) {
		super();
		this.aniosExperiencia = aniosExperiencia;
	}

	/**
	 * Constructor that has as parameters the attributes that it inherits from the
	 * class DTOUser
	 * 
	 * @param nombre
	 * @param cedula
	 * @param genero
	 * @param correoElectronico
	 * @param id
	 * @param contrasenia
	 * @param aniosExperiencia
	 */
	public MasajistaDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int aniosExperiencia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		this.aniosExperiencia = aniosExperiencia;
	}

	/**
	 * Constructor that has as parameters the attributes that it inherits from the
	 * class UserDTO and those of the class
	 *
	 * @param nombre
	 * @param cedula
	 * @param genero
	 * @param correoElectronico
	 * @param id
	 * @param contrasenia
	 */
	public MasajistaDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		// TODO Auto-generated constructor stub
	}

	/**
	 * toString method to return a textual representation of the attributes of the
	 * object
	 *
	 * @return retorna atributos del objeto que hereda mas los atributos propios
	 */
	@Override
	public String toString() {
		return super.toString() + "MasajistaDTO [aniosExperiencia=" + aniosExperiencia + "]";
	}

	/**
	 * * Get years of experience
	 *
	 * @return aniosExperiencia
	 */
	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	/**
	 * * Establish years of experience
	 *
	 * @param aniosExperiencia
	 */
	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

}