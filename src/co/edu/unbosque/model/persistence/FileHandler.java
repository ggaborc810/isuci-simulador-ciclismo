/**
 * persistence package, this is where we can cure the DTO classes
 */
package co.edu.unbosque.model.persistence;

import java.awt.Font;

import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import java.util.Properties;
import java.util.Scanner;
import co.edu.unbosque.view.MensajeEmergente;

/**
 * Class where the functionalities of text files and
 * serializable files are established
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class FileHandler {

	/**
	 * @type FileInputStream
	 */
	private static FileInputStream fis;
	/**
	 * @type ObjectInputStream
	 */
	private static ObjectInputStream ois;
	/**
	 * @type FileOutputStream
	 */
	private static FileOutputStream fos;
	/**
	 * @type ObjectOutputStream
	 */
	private static ObjectOutputStream ous;
	/**
	 * @type File
	 */
	private static File archivo;
	/**
	 * @type Scanner
	 */
	private static Scanner lectorDeArchivo;
	/**
	 * @type PrintWriter
	 */
	private static PrintWriter escritorDeArchivo;

	/**
	 * Function to check if there is data in a file
	 */
	public static void verificarFolderDeDatos() {
		archivo = new File("data");

		if (archivo.mkdir()) {
			MensajeEmergente.mostrarMensaje("Carpeta creada por primera vez en " + archivo.toURI());
		}
	}

	/**
	 * Function to open and write to a file
	 * 
	 * @param url
	 * @param contenido
	 */
	public static void abrirYEscribirEnSerializable(String url, Object contenido) {

		archivo = new File(url);

		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			ous = new ObjectOutputStream(fos);
			ous.writeObject(contenido);
			fos.close();
			ous.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			MensajeEmergente.mostrarMensaje("No fue posible crear un archivo de escuadras. ");
		}
	}

	/**
	 * Function to Open and read a serialized file
	 * 
	 * @param url
	 * @return String
	 */
	public static String abrirYLeerArchivo(String url) {
		String contenido = "";
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			lectorDeArchivo = new Scanner(archivo);

			while (lectorDeArchivo.hasNext()) {
				contenido += lectorDeArchivo.nextLine() + "\n";

			}
		} catch (IOException e2) {
			e2.printStackTrace();
			MensajeEmergente.mostrarMensaje("No fue posible crear un archivo de escuadras. ");
		}
		lectorDeArchivo.close();
		return contenido;
	}

	/**
	 * Function to open and read serialized
	 * 
	 * @param url
	 * @return Object
	 */
	public static Object abrirLeerSerializado(String url) {
		Object contenido = null;
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);

			contenido = ois.readObject();
			fis.close();
			ois.close();
		} catch (IOException e3) {
			e3.printStackTrace();
			MensajeEmergente.mostrarMensaje("No fue posible crear un archivo de escuadras. ");
		} catch (ClassNotFoundException e4) {
			e4.printStackTrace();
		}

		return contenido;
	}

	/**
	 * Function to open and write to a file
	 * 
	 * @param url
	 * @param contenido
	 */
	public static void abrirYEscribirArchivo(String url, String contenido) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			escritorDeArchivo = new PrintWriter(archivo);
			escritorDeArchivo.print(contenido);
		} catch (FileNotFoundException e5) {
			e5.printStackTrace();
			MensajeEmergente.mostrarMensaje("Archivo de escuadras no ha sido encontrado. ");
		} catch (IOException e6) {
			e6.printStackTrace();
			MensajeEmergente.mostrarMensaje("No fue posible crear un archivo de escuadras. ");
		}
		escritorDeArchivo.close();
	}

	/**
	 * Function to load the text font type
	 */

	public static void cargarFuente() {
		Font fuente = null;
		String ruta = "fuente/arial.ttf";
		try {
			fuente = Font.createFont(Font.TRUETYPE_FONT, new File(ruta));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(fuente);
		} catch (IOException | FontFormatException e) {
			MensajeEmergente.mostrarMensaje("Problema al cargar el archivo de fuente. ");
		}

	}

	/**
	 *Function to load properties
	 * 
	 * @param url
	 * @return Properties
	 */
	public static Properties cargarPropiedades(String url) {
		Properties propiedades = null;
		try {
			propiedades = new Properties();
			propiedades.load(new FileInputStream(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propiedades;
	}
}