/**
 * model package, is where the attributes are found for the creation of objects, whether cyclists, masseuses or other types of users within the application.
 */
package co.edu.unbosque.model;

import java.io.Serializable;

public class EmbaladorDTO extends CiclistaDTO implements Serializable {
	private double potenciaPromedio;
	private double velocidadPromedioEmbalador;
	private boolean tareaEmbalador;
	private boolean tareaEmbalador2;

	public EmbaladorDTO() {
	}

	public EmbaladorDTO(double potenciaPromedio, double velocidadPromedioEmbalador, boolean tareaEmbalador,
			boolean tareaEmbalador2) {
		super();
		this.potenciaPromedio = potenciaPromedio;
		this.velocidadPromedioEmbalador = velocidadPromedioEmbalador;
		this.tareaEmbalador = tareaEmbalador;
		this.tareaEmbalador2 = tareaEmbalador2;
	}

	public EmbaladorDTO(int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia, double potenciaPromedio, double velocidadPromedioEmbalador, boolean tareaEmbalador,
			boolean tareaEmbalador2) {
		super(identificador, tiempoAcumulado, contextura, cadenciaPedaleo, aniosExperiencia);
		this.potenciaPromedio = potenciaPromedio;
		this.velocidadPromedioEmbalador = velocidadPromedioEmbalador;
		this.tareaEmbalador = tareaEmbalador;
		this.tareaEmbalador2 = tareaEmbalador2;
	}

	public EmbaladorDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia, double potenciaPromedio, double velocidadPromedioEmbalador, boolean tareaEmbalador,
			boolean tareaEmbalador2) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia, identificador, tiempoAcumulado, contextura,
				cadenciaPedaleo, aniosExperiencia);
		this.potenciaPromedio = potenciaPromedio;
		this.velocidadPromedioEmbalador = velocidadPromedioEmbalador;
		this.tareaEmbalador = tareaEmbalador;
		this.tareaEmbalador2 = tareaEmbalador2;
	}

	public EmbaladorDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, double potenciaPromedio, double velocidadPromedioEmbalador, boolean tareaEmbalador,
			boolean tareaEmbalador2) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		this.potenciaPromedio = potenciaPromedio;
		this.velocidadPromedioEmbalador = velocidadPromedioEmbalador;
		this.tareaEmbalador = tareaEmbalador;
		this.tareaEmbalador2 = tareaEmbalador2;
	}

	public EmbaladorDTO(int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia) {
		super(identificador, tiempoAcumulado, contextura, cadenciaPedaleo, aniosExperiencia);
		// TODO Auto-generated constructor stub
	}

	public EmbaladorDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia, int identificador, double tiempoAcumulado, String contextura, double cadenciaPedaleo,
			int aniosExperiencia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia, identificador, tiempoAcumulado, contextura,
				cadenciaPedaleo, aniosExperiencia);
		// TODO Auto-generated constructor stub
	}

	public EmbaladorDTO(String nombre, long cedula, String genero, String correoElectronico, String id,
			String contrasenia) {
		super(nombre, cedula, genero, correoElectronico, id, contrasenia);
		// TODO Auto-generated constructor stub
	}

	public double getPotenciaPromedio() {
		return potenciaPromedio;
	}

	public void setPotenciaPromedio(double potenciaPromedio) {
		this.potenciaPromedio = potenciaPromedio;
	}

	public double getVelocidadPromedioEmbalador() {
		return velocidadPromedioEmbalador;
	}

	public void setVelocidadPromedioEmbalador(double velocidadPromedioEmbalador) {
		this.velocidadPromedioEmbalador = velocidadPromedioEmbalador;
	}

	public boolean isTareaEmbalador() {
		return tareaEmbalador;
	}

	public void setTareaEmbalador(boolean tareaEmbalador) {
		this.tareaEmbalador = tareaEmbalador;
	}

	public boolean isTareaEmbalador2() {
		return tareaEmbalador2;
	}

	public void setTareaEmbalador2(boolean tareaEmbalador2) {
		this.tareaEmbalador2 = tareaEmbalador2;
	}

	@Override
	public String toString() {
		return super.toString() + "EmbaladorDTO [potenciaPromedio=" + potenciaPromedio + ", velocidadPromedioEmbalador="
				+ velocidadPromedioEmbalador + ", tareaEmbalador=" + tareaEmbalador + ", tareaEmbalador2="
				+ tareaEmbalador2 + "]";
	}

}
