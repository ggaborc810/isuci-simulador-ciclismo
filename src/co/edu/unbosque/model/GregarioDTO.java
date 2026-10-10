/**
 * model package, is where the attributes are found for the creation of objects, whether cyclists, masseuses or other types of users within the application.
 */
package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Class that represents a type of cyclist in the system (gregarious).
 *
 * This class inherits from the `CiclistaDTO` class
 *
 * @see CiclistaDTO
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */

public class GregarioDTO extends CiclistaDTO implements Serializable {

	/**
	 * It is a supplier
	 * 
	 * @type boolean
	 */
	private boolean esAbastecedor;
	/**
	 * It's about keeping the rhythm
	 * 
	 * @type boolean
	 */
	private boolean esMantenerRitmo;
	/**
	 * It's capture leak
	 * 
	 * @type boolean
	 */
	private boolean esCapturasFuga;
	/**
	 * He is a leading positioner
	 * 
	 * @type boolean
	 */
	private boolean esPosicionarLider;
	/**
	 * Es proteger lider
	 * 
	 * @type boolean
	 */
	private boolean esProtegerLider;

	/**
	 * Constructor vacio de la clase GregarioDTO
	 */
	public GregarioDTO() {
	}

	/**
	 * Constructor that has as parameters the attributes of the class
	 * 
	 * @param esAbastecedor
	 * @param esMantenerRitmo
	 * @param esCapturasFuga
	 * @param esPosicionarLider
	 * @param esProtegerLider
	 */
	public GregarioDTO(boolean esAbastecedor, boolean esMantenerRitmo, boolean esCapturasFuga,
			boolean esPosicionarLider, boolean esProtegerLider) {
		super();
		this.esAbastecedor = esAbastecedor;
		this.esMantenerRitmo = esMantenerRitmo;
		this.esCapturasFuga = esCapturasFuga;
		this.esPosicionarLider = esPosicionarLider;
		this.esProtegerLider = esProtegerLider;
	}

	/**
	 * Constructor that has the attributes that it inherits from the DTOUser class
	 *
	 * @param identificador
	 * @param tiempoAcumulado
	 * @param contextura
	 * @param cadenciaPedaleo
	 * @param aniosExperiencia
	 */
	public GregarioDTO(int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia) {
		super(identificador, tiempoAcumulado, contextura, cadenciaPedaleo, aniosExperiencia);
		// TODO Auto-generated constructor stub
	}

	/**
	 * * Constructor that has the attributes that it inherits from the DTOUser class
	 * and CyclistDTO
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
	public GregarioDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia, identificador, tiempoAcumulado, contextura,
				cadenciaPedaleo, aniosExperiencia);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor that has the attributes that it inherits from the DTOUser class
	 *
	 * @param nombre
	 * @param cedula
	 * @param genero
	 * @param correoElectronico
	 * @param id
	 * @param contrasenia
	 */

	public GregarioDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor that has the attributes that it inherits from the DTOUser class
	 * and class attributes
	 *
	 * @param nombre
	 * @param cedula
	 * @param genero
	 * @param correoElectronico
	 * @param id
	 * @param contrasenia
	 * @param esAbastecedor
	 * @param esMantenerRitmo
	 * @param esCapturasFuga
	 * @param esPosicionarLider
	 * @param esProtegerLider
	 */
	public GregarioDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, boolean esAbastecedor, boolean esMantenerRitmo, boolean esCapturasFuga,
			boolean esPosicionarLider, boolean esProtegerLider) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		this.esAbastecedor = esAbastecedor;
		this.esMantenerRitmo = esMantenerRitmo;
		this.esCapturasFuga = esCapturasFuga;
		this.esPosicionarLider = esPosicionarLider;
		this.esProtegerLider = esProtegerLider;
	}

	/**
	 * Constructor that has the attributes that it inherits from the DTOUser class,
	 * CiclistaDTO class attributes
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
	 * @param esAbastecedor
	 * @param esMantenerRitmo
	 * @param esCapturasFuga
	 * @param esPosicionarLider
	 * @param esProtegerLider
	 */
	public GregarioDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia, boolean esAbastecedor, boolean esMantenerRitmo, boolean esCapturasFuga,
			boolean esPosicionarLider, boolean esProtegerLider) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia, identificador, tiempoAcumulado, contextura,
				cadenciaPedaleo, aniosExperiencia);
		this.esAbastecedor = esAbastecedor;
		this.esMantenerRitmo = esMantenerRitmo;
		this.esCapturasFuga = esCapturasFuga;
		this.esPosicionarLider = esPosicionarLider;
		this.esProtegerLider = esProtegerLider;
	}

	/**
	 * Constructor that has the attributes that it inherits from the CiclistaDTO
	 * class class attributes
	 *
	 * @param identificador
	 * @param tiempoAcumulado
	 * @param contextura
	 * @param cadenciaPedaleo
	 * @param aniosExperiencia
	 * @param esAbastecedor
	 * @param esMantenerRitmo
	 * @param esCapturasFuga
	 * @param esPosicionarLider
	 * @param esProtegerLider
	 */
	public GregarioDTO(int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia, boolean esAbastecedor, boolean esMantenerRitmo, boolean esCapturasFuga,
			boolean esPosicionarLider, boolean esProtegerLider) {
		super(identificador, tiempoAcumulado, contextura, cadenciaPedaleo, aniosExperiencia);
		this.esAbastecedor = esAbastecedor;
		this.esMantenerRitmo = esMantenerRitmo;
		this.esCapturasFuga = esCapturasFuga;
		this.esPosicionarLider = esPosicionarLider;
		this.esProtegerLider = esProtegerLider;
	}

	/**
	 ** toString method to return a textual representation of the attributes of the
	 * object
	 * 
	 * @return retorna atributos del objeto
	 */
	@Override
	public String toString() {
		return super.toString() + "GregarioDTO [esAbastecedor=" + esAbastecedor + ", esMantenerRitmo=" + esMantenerRitmo
				+ ", esCapturasFuga=" + esCapturasFuga + ", esPosicionarLider=" + esPosicionarLider
				+ ", esProtegerLider=" + esProtegerLider + "]";
	}

	/**
	 * @return the esAbastecedor
	 */
	public boolean isEsAbastecedor() {
		return esAbastecedor;
	}

	/**
	 * @param esAbastecedor the esAbastecedor to set
	 */
	public void setEsAbastecedor(boolean esAbastecedor) {
		this.esAbastecedor = esAbastecedor;
	}

	/**
	 * @return the esMantenerRitmo
	 */
	public boolean isEsMantenerRitmo() {
		return esMantenerRitmo;
	}

	/**
	 * @param esMantenerRitmo the esMantenerRitmo to set
	 */
	public void setEsMantenerRitmo(boolean esMantenerRitmo) {
		this.esMantenerRitmo = esMantenerRitmo;
	}

	/**
	 * @return the esCapturasFuga
	 */
	public boolean isEsCapturasFuga() {
		return esCapturasFuga;
	}

	/**
	 * @param esCapturasFuga the esCapturasFuga to set
	 */
	public void setEsCapturasFuga(boolean esCapturasFuga) {
		this.esCapturasFuga = esCapturasFuga;
	}

	/**
	 * @return the esPosicionarLider
	 */
	public boolean isEsPosicionarLider() {
		return esPosicionarLider;
	}

	/**
	 * @param esPosicionarLider the esPosicionarLider to set
	 */
	public void setEsPosicionarLider(boolean esPosicionarLider) {
		this.esPosicionarLider = esPosicionarLider;
	}

	/**
	 * @return the esProtegerLider
	 */
	public boolean isEsProtegerLider() {
		return esProtegerLider;
	}

	/**
	 * @param esProtegerLider the esProtegerLider to set
	 */
	public void setEsProtegerLider(boolean esProtegerLider) {
		this.esProtegerLider = esProtegerLider;
	}

}
