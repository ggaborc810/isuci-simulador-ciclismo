/**
 * model package, is where the attributes are found for the creation of objects, whether cyclists, masseuses or other types of users within the application.
 */
package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Class that represents the sports director. * This class inherits from the
 * `DTOUser` class *
 * 
 * @see UsuarioDTO
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class DirectorDeportivoDTO extends UsuarioDTO implements Serializable {
	/**
	 * * Nationality of the sports director
	 *
	 * @type String
	 */
	private String nacionalidad;

	/**
	 * Empty constructor of the SportsDirectorDTO class
	 */
	public DirectorDeportivoDTO() {
	}

	/**
	 * Constructor that has its own attributes as parameters
	 *
	 * @param nacionalidad
	 */
	public DirectorDeportivoDTO(String nacionalidad) {
		super();
		this.nacionalidad = nacionalidad;
	}

	/**
	 ** Constructor that has as parameters the attributes of the DTOUser class and
	 * own
	 * 
	 * @param nombre
	 * @param cedula
	 * @param genero
	 * @param correoElectronico
	 * @param id
	 * @param contrasenia
	 * @param nacionalidad
	 */
	public DirectorDeportivoDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, String nacionalidad) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		this.nacionalidad = nacionalidad;
	}

	/**
	 * Constructor that has as parameters the attributes that it inherits from the
	 * class * UserDTO
	 * 
	 * @param nombre
	 * @param cedula
	 * @param genero
	 * @param correoElectronico
	 * @param id
	 * @param contrasenia
	 */
	public DirectorDeportivoDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
	}

	/**
	 * toString method to return a textual representation of the attributes of the
	 * object
	 * 
	 * @return retorna atributos del objeto que hereda mas los atributos propios
	 */
	@Override
	public String toString() {
		return super.toString() + "DirectorDeportivoDTO [nacionalidad=" + nacionalidad + "]";
	}

	/**
	 * @return the nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

}
