/**
 * model package, is where the attributes are found for the creation of objects, whether cyclists, masseuses or other types of users within the application.
 */

package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Class that represents a type of cyclist in the system (wheeler).
 *
 * This class inherits from the `CiclistaDTO` class
 *
 * @see CiclistaDTO
 * @author Juan Diego Triana Mejía
 * @author Juan David Guarnizo Martínez
 * @author Gabriel Alejandro Ruiz Cruz
 */

public class RodadorDTO extends CiclistaDTO implements Serializable {
	/**
	 * average pedaling speed
	 *
	 * @type double
	 */
	private double velocidadPromedioPedaleo;

	/**
	 * Empty constructor of the RodadorDTO class
	 */
	public RodadorDTO() {
	}

	/**
	 * Constructor that has the class's own attributes as parameters
	 *
	 * @param AveragePedalSpeed
	 */
	public RodadorDTO(double velocidadPromedioPedaleo) {
		super();
		this.velocidadPromedioPedaleo = velocidadPromedioPedaleo;
	}

	/**
	 * Constructor that has as parameters the attributes inherited from the class
	 * CyclistDTO
	 * 
	 * @param identificador
	 * @param tiempoAcumulado
	 * @param contextura
	 * @param cadenciaPedaleo
	 * @param aniosExperiencia
	 */
	public RodadorDTO(int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia) {
		super(identificador, tiempoAcumulado, contextura, cadenciaPedaleo, aniosExperiencia);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Constructor that has as parameters the attributes inherited from the class
	 * DTO Cyclist and DTO User
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
	public RodadorDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia, identificador, tiempoAcumulado, contextura,
				cadenciaPedaleo, aniosExperiencia);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor that has as parameters the attributes inherited from the class
	 * DTOUser
	 *
	 * @param nombre
	 * @param cedula
	 * @param genero
	 * @param correoElectronico
	 * @param id
	 * @param contrasenia
	 */
	public RodadorDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor that has as parameters the attributes inherited from the class
	 * UserDTO and those of the class
	 *
	 * @param nombre
	 * @param cedula
	 * @param genero
	 * @param correoElectronico
	 * @param id
	 * @param contrasenia
	 * @param velocidadPromedioPedaleo
	 */
	public RodadorDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, double velocidadPromedioPedaleo) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		this.velocidadPromedioPedaleo = velocidadPromedioPedaleo;
	}

	/**
	 * Constructor that has as parameters the attributes inherited from the class
	 * UserDTO, CyclistDTO and those of the class
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
	 * @param velocidadPromedioPedaleo
	 */
	public RodadorDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia, double velocidadPromedioPedaleo) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia, identificador, tiempoAcumulado, contextura,
				cadenciaPedaleo, aniosExperiencia);
		this.velocidadPromedioPedaleo = velocidadPromedioPedaleo;
	}

	/**
	 * Constructor that has as parameters the attributes inherited from the class
	 * CyclistDTO
	 * 
	 * @param identificador
	 * @param tiempoAcumulado
	 * @param contextura
	 * @param cadenciaPedaleo
	 * @param aniosExperiencia
	 * @param velocidadPromedioPedaleo
	 */
	public RodadorDTO(int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia, double velocidadPromedioPedaleo) {
		super(identificador, tiempoAcumulado, contextura, cadenciaPedaleo, aniosExperiencia);
		this.velocidadPromedioPedaleo = velocidadPromedioPedaleo;
	}

	/**
	 * toString method to return a textual representation of the attributes of the
	 * object
	 * 
	 * @return retorna atributos del objeto que hereda mas los atributos propios
	 */
	@Override
	public String toString() {
		return super.toString() + "RodadorDTO [velocidadPromedioPedaleo=" + velocidadPromedioPedaleo + "]";
	}

	/**
	 * @return the velocidadPromedioPedaleo
	 */
	public double getVelocidadPromedioPedaleo() {
		return velocidadPromedioPedaleo;
	}

	/**
	 * @param velocidadPromedioPedaleo the velocidadPromedioPedaleo to set
	 */
	public void setVelocidadPromedioPedaleo(double velocidadPromedioPedaleo) {
		this.velocidadPromedioPedaleo = velocidadPromedioPedaleo;
	}


}
