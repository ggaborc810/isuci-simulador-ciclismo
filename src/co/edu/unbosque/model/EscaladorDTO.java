/**
 * model package, is where the attributes are found for the creation of objects, whether cyclists, masseuses or other types of users within the application.
 */
package co.edu.unbosque.model;

import java.io.Serializable;

public class EscaladorDTO extends CiclistaDTO implements Serializable {
	private double aceleracionPromedio;
	private double gradoRampaSoportada;
	private boolean tareaEscalador;
	private boolean tareaEscalador2;

	public EscaladorDTO() {
	}

	public EscaladorDTO(double aceleracionPromedio, double gradoRampaSoportada, boolean tareaEscalador,
			boolean tareaEscalador2) {
		super();
		this.aceleracionPromedio = aceleracionPromedio;
		this.gradoRampaSoportada = gradoRampaSoportada;
		this.tareaEscalador = tareaEscalador;
		this.tareaEscalador2 = tareaEscalador2;
	}

	public EscaladorDTO(int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia, double aceleracionPromedio, double gradoRampaSoportada, boolean tareaEscalador,
			boolean tareaEscalador2) {
		super(identificador, tiempoAcumulado, contextura, cadenciaPedaleo, aniosExperiencia);
		this.aceleracionPromedio = aceleracionPromedio;
		this.gradoRampaSoportada = gradoRampaSoportada;
		this.tareaEscalador = tareaEscalador;
		this.tareaEscalador2 = tareaEscalador2;
	}

	public EscaladorDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia, double aceleracionPromedio, double gradoRampaSoportada, boolean tareaEscalador,
			boolean tareaEscalador2) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia, identificador, tiempoAcumulado, contextura,
				cadenciaPedaleo, aniosExperiencia);
		this.aceleracionPromedio = aceleracionPromedio;
		this.gradoRampaSoportada = gradoRampaSoportada;
		this.tareaEscalador = tareaEscalador;
		this.tareaEscalador2 = tareaEscalador2;
	}

	public EscaladorDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, double aceleracionPromedio, double gradoRampaSoportada, boolean tareaEscalador,
			boolean tareaEscalador2) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		this.aceleracionPromedio = aceleracionPromedio;
		this.gradoRampaSoportada = gradoRampaSoportada;
		this.tareaEscalador = tareaEscalador;
		this.tareaEscalador2 = tareaEscalador2;
	}

	public EscaladorDTO(int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia) {
		super(identificador, tiempoAcumulado, contextura, cadenciaPedaleo, aniosExperiencia);
		// TODO Auto-generated constructor stub
	}

	public EscaladorDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia, identificador, tiempoAcumulado, contextura,
				cadenciaPedaleo, aniosExperiencia);
		// TODO Auto-generated constructor stub
	}

	public EscaladorDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		// TODO Auto-generated constructor stub
	}

	public double getAceleracionPromedio() {
		return aceleracionPromedio;
	}

	public void setAceleracionPromedio(double aceleracionPromedio) {
		this.aceleracionPromedio = aceleracionPromedio;
	}

	public double getGradoRampaSoportada() {
		return gradoRampaSoportada;
	}

	public void setGradoRampaSoportada(double gradoRampaSoportada) {
		this.gradoRampaSoportada = gradoRampaSoportada;
	}

	public boolean isTareaEscalador() {
		return tareaEscalador;
	}

	public void setTareaEscalador(boolean tareaEscalador) {
		this.tareaEscalador = tareaEscalador;
	}

	public boolean isTareaEscalador2() {
		return tareaEscalador2;
	}

	public void setTareaEscalador2(boolean tareaEscalador2) {
		this.tareaEscalador2 = tareaEscalador2;
	}

	@Override
	public String toString() {
		return super.toString() + "EscaladorDTO [aceleracionPromedio=" + aceleracionPromedio + ", gradoRampaSoportada="
				+ gradoRampaSoportada + ", tareaEscalador=" + tareaEscalador + ", tareaEscalador2=" + tareaEscalador2
				+ "]";
	}

}
