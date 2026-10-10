/**
 * model package, is where the attributes are found for the creation of objects, whether cyclists, masseuses or other types of users within the application.
 */

package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Class that represents a type of cyclist in the system (classicomano).
 *
 * This class inherits from the `CiclistaDTO` class
 *
 * @see CiclistaDTO
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class ClasicoManoDTO extends CiclistaDTO implements Serializable {
	/**
	 * Number of classics won
	 * 
	 * @type int
	 * 
	 */
	private int numClasicosGanados;

	/**
	 * empty constructor of class ClasicomanoDTO
	 */

	public ClasicoManoDTO() {
	}

	/**
	 * Full constructor of the Clasicomano DTO class with its own attribute
	 * parameter
	 * 
	 * @param numClasicosGanados
	 */
	public ClasicoManoDTO(int numClasicosGanados) {
		super();
		this.numClasicosGanados = numClasicosGanados;
	}

	/**
	 * Constructor of the ClasicomanoDTO class that inherits attributes from UserDTO
	 * and own attribute as parameters
	 *
	 * @param nombre
	 * @param cedula
	 * @param genero
	 * @param correoElectronico
	 * @param id
	 * @param contrasenia
	 * @param numClasicosGanados
	 */

	public ClasicoManoDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int numClasicosGanados) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		this.numClasicosGanados = numClasicosGanados;
	}

	/**
	 * Constructor that has as parameters inheritance of all the attributes of the *
	 * class UserDTO, CiclistaDTO and the own attribute *
	 * 
	 * @param nombre
	 * @param cedula
	 * @param genero
	 * @param correoElectronico
	 * @param id
	 * @param contrasenia
	 * @param identificador
	 * @param tiempoAcumulado
	 * @param contextura
	 * @param cadenciaPedaleo
	 * @param aniosExperiencia
	 * @param numClasicosGanados
	 */

	public ClasicoManoDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia, int numClasicosGanados) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia, identificador, tiempoAcumulado, contextura,
				cadenciaPedaleo, aniosExperiencia);
		this.numClasicosGanados = numClasicosGanados;
	}

	/**
	 * 
	 * Constructor that has as parameters the inheritance of attributes of class
	 * CiclistaDTO class and the own attribute
	 * 
	 * @param identificador
	 * @param tiempoAcumulado
	 * @param contextura
	 * @param cadenciaPedaleo
	 * @param aniosExperiencia
	 * @param numClasicosGanados
	 */
	public ClasicoManoDTO(int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia, int numClasicosGanados) {
		super(identificador, tiempoAcumulado, contextura, cadenciaPedaleo, aniosExperiencia);
		this.numClasicosGanados = numClasicosGanados;
	}

	/**
	 * Constructor that inherits only the attributes of CiclistaDTO
	 *
	 * @param identificador
	 * @param tiempoAcumulado
	 * @param contextura
	 * @param cadenciaPedaleo
	 * @param aniosExperiencia
	 */
	public ClasicoManoDTO(int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia) {
		super(identificador, tiempoAcumulado, contextura, cadenciaPedaleo, aniosExperiencia);

	}

	/**
	 * Constructor that has as parameters the inheritance of the attributes of the
	 * DTO User and DTO Cyclist classes
	 *
	 * @param nombre
	 * @param cedula
	 * @param genero
	 * @param correoElectronico
	 * @param id
	 * @param contrasenia
	 * @param identificador
	 * @param tiempoAcumulado
	 * @param contextura
	 * @param cadenciaPedaleo
	 * @param aniosExperiencia
	 */
	public ClasicoManoDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia, identificador, tiempoAcumulado, contextura,
				cadenciaPedaleo, aniosExperiencia);

	}

	/**
	 * Constructor that has inheritance as parameters only of the class DTOUser
	 *
	 * @param nombre
	 * @param cedula
	 * @param genero
	 * @param correoElectronico
	 * @param id
	 * @param contrasenia
	 */
	public ClasicoManoDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);

	}

	/***
	 * toString method to return a textual representation of the attributes of the
	 * object
	 *
	 * @return retorna atributos del objeto que hereda mas los atributos propios
	 */
	@Override
	public String toString() {
		return super.toString() + "ClasicomanoDTO [numClasicosGanados=" + numClasicosGanados + "]";
	}

	/**
	 * @return the numClasicosGanados
	 */
	public int getNumClasicosGanados() {
		return numClasicosGanados;
	}

	/**
	 * @param numClasicosGanados the numClasicosGanados to set
	 */
	public void setNumClasicosGanados(int numClasicosGanados) {
		this.numClasicosGanados = numClasicosGanados;
	}

}
