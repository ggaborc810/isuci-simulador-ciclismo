/**
 * model package, is where the attributes are found for the creation of objects, whether cyclists, masseuses or other types of users within the application.
 */
package co.edu.unbosque.model;

import java.io.Serializable;

public class ContraRelojDTO extends CiclistaDTO implements Serializable {
	/**
	 * Maximum speed
	 *
	 * @type double
	 */
	private double velocidadMaxima;
	/**
	 * task performed by the time trialist
	 *
	 * @type boolean
	 */
	private boolean tareaContrareloj;

	/**
	 * 
	 */
	private boolean tareaContrareloj2;
	/**
	 * 
	 */
	private boolean tareaContrareloj3;

	/**
	 * Empty constructor of ContraRelojDTO class
	 */
	public ContraRelojDTO() {
	}

	/**
	 * Constructor with parameters the attributes of its class
	 * 
	 * @param velocidadMaxima
	 * @param tareaContrareloj
	 * @param tareaContrareloj2
	 * @param tareaContrareloj3
	 */
	public ContraRelojDTO(double velocidadMaxima, boolean tareaContrareloj, boolean tareaContrareloj2,
			boolean tareaContrareloj3) {
		super();
		this.velocidadMaxima = velocidadMaxima;
		this.tareaContrareloj = tareaContrareloj;
		this.tareaContrareloj2 = tareaContrareloj2;
		this.tareaContrareloj3 = tareaContrareloj3;
	}

	/**
	 * Constructor that has the attributes of class inheritance as parameters
	 * CyclistDTO and own attributes
	 * 
	 * @param identificador
	 * @param tiempoAcumulado
	 * @param contextura
	 * @param cadenciaPedaleo
	 * @param aniosExperiencia
	 * @param velocidadMaxima
	 * @param tareaContrareloj
	 * @param tareaContrareloj2
	 * @param tareaContrareloj3
	 */
	public ContraRelojDTO(int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia, double velocidadMaxima, boolean tareaContrareloj, boolean tareaContrareloj2,
			boolean tareaContrareloj3) {
		super(identificador, tiempoAcumulado, contextura, cadenciaPedaleo, aniosExperiencia);
		this.velocidadMaxima = velocidadMaxima;
		this.tareaContrareloj = tareaContrareloj;
		this.tareaContrareloj2 = tareaContrareloj2;
		this.tareaContrareloj3 = tareaContrareloj3;
	}

	/**
	 * Constructor that has as parameters the attributes of the DTOUser class, *
	 * DTOCyclist and its own attributes *
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
	 * @param velocidadMaxima
	 * @param tareaContrareloj
	 * @param tareaContrareloj2
	 * @param tareaContrareloj3
	 */
	public ContraRelojDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia, double velocidadMaxima, boolean tareaContrareloj, boolean tareaContrareloj2,
			boolean tareaContrareloj3) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia, identificador, tiempoAcumulado, contextura,
				cadenciaPedaleo, aniosExperiencia);
		this.velocidadMaxima = velocidadMaxima;
		this.tareaContrareloj = tareaContrareloj;
		this.tareaContrareloj2 = tareaContrareloj2;
		this.tareaContrareloj3 = tareaContrareloj3;
	}

	/**
	 * * Constructor that has as parameters the attributes of the DTOUser class and
	 * own attributes
	 * 
	 * @param nombre
	 * @param cedula
	 * @param genero
	 * @param correoElectronico
	 * @param id
	 * @param contrasenia
	 * @param velocidadMaxima
	 * @param tareaContrareloj
	 * @param tareaContrareloj2
	 * @param tareaContrareloj3
	 */
	public ContraRelojDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, double velocidadMaxima, boolean tareaContrareloj, boolean tareaContrareloj2,
			boolean tareaContrareloj3) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		this.velocidadMaxima = velocidadMaxima;
		this.tareaContrareloj = tareaContrareloj;
		this.tareaContrareloj2 = tareaContrareloj2;
		this.tareaContrareloj3 = tareaContrareloj3;
	}

	/**
	 * Constructor that has as parameters the inheritance of the CiclistaDTO class *
	 * 
	 * @param identificador
	 * @param tiempoAcumulado
	 * @param contextura
	 * @param cadenciaPedaleo
	 * @param aniosExperiencia
	 */
	public ContraRelojDTO(int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia) {
		super(identificador, tiempoAcumulado, contextura, cadenciaPedaleo, aniosExperiencia);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor that has as parameters the attributes inherited from the class
	 * CyclistDTO and UserDTO
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

	public ContraRelojDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia, identificador, tiempoAcumulado, contextura,
				cadenciaPedaleo, aniosExperiencia);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor that has as parameters the inheritance of only the DTOUser class
	 * 
	 * @param nombre
	 * @param cedula
	 * @param genero
	 * @param correoElectronico
	 * @param id
	 * @param contrasenia
	 */
	public ContraRelojDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
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
		return "ContraRelojDTO [velocidadMaxima=" + velocidadMaxima + ", tareaContrareloj=" + tareaContrareloj
				+ ", tareaContrareloj2=" + tareaContrareloj2 + ", tareaContrareloj3=" + tareaContrareloj3 + "]";
	}

	/**
	 * @return the velocidadMaxima
	 */
	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	/**
	 * @param velocidadMaxima the velocidadMaxima to set
	 */
	public void setVelocidadMaxima(double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	/**
	 * @return the tareaContrareloj
	 */
	public boolean isTareaContrareloj() {
		return tareaContrareloj;
	}

	/**
	 * @param tareaContrareloj the tareaContrareloj to set
	 */
	public void setTareaContrareloj(boolean tareaContrareloj) {
		this.tareaContrareloj = tareaContrareloj;
	}

	/**
	 * @return the tareaContrareloj2
	 */
	public boolean isTareaContrareloj2() {
		return tareaContrareloj2;
	}

	/**
	 * @param tareaContrareloj2 the tareaContrareloj2 to set
	 */
	public void setTareaContrareloj2(boolean tareaContrareloj2) {
		this.tareaContrareloj2 = tareaContrareloj2;
	}

	/**
	 * @return the tareaContrareloj3
	 */
	public boolean isTareaContrareloj3() {
		return tareaContrareloj3;
	}

	/**
	 * @param tareaContrareloj3 the tareaContrareloj3 to set
	 */
	public void setTareaContrareloj3(boolean tareaContrareloj3) {
		this.tareaContrareloj3 = tareaContrareloj3;
	}

}
