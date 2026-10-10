/**
 * package to store classes that handle application exceptions
 *
 */
package co.edu.unbosque.util.exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class where user input exceptions can be handled.
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class ExceptionChecker {
	/**
	 * Function that verifies the text typed by the user for the email is correct.
	 * 
	 * @param email
	 * @throws CheckMail
	 */
	public static void checkEmail(String email) throws CheckMail {
		String regex = "^[\\w!#$%&amp;'*+/=?{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			throw new CheckMail();
		}

	}

	/**
	 * Function that verifies the text typed by the user for the name is invalid.
	 * 
	 * @param nombre
	 * @throws InvalidNameException
	 */
	public static void revisarNombreInvalido(String nombre) throws InvalidNameException {
		Pattern n = Pattern.compile("[^aA-zZ ñÑ 0-9]");
		Matcher m = n.matcher(nombre);
		if (m.find()) {
			throw new InvalidNameException();
		}
	}

	/**
	 * Function that verifies the text typed by the user for the name is valid.
	 * 
	 * @param nombre
	 * @throws InvalidNameExceptionS
	 */
	public static void revisarNombre(String nombre) throws InvalidNameExceptionS {
		Pattern n = Pattern.compile("[^aA-zZ ñÑ]");
		Matcher m = n.matcher(nombre);
		if (m.find()) {
			throw new InvalidNameExceptionS();
		}
	}

	/**
	 * Function that verifies the user does not type negative integers.
	 * 
	 * @param numero
	 * @throws NegativeNumberException
	 */
	public static void revisarNumeroNegativo(int numero) throws NegativeNumberException {
		if (numero < 0) {
			throw new NegativeNumberException();
		}
	}
	
	/**
	 * Function that verifies the user does not type negative integers.
	 * 
	 * @param numero
	 * @throws NegativeNumberException
	 */
	public static void revisarNumeroNegativo(long numero) throws NegativeNumberException {
		if (numero < 0) {
			throw new NegativeNumberException();
		}
	}

	/**
	 * Function that verifies the user does not type negative doubles.
	 * 
	 * @param numero
	 * @throws NegativeNumberException
	 */
	public static void revisarNumeroNegativo2(Double numero) throws NegativeNumberException {
		if (numero < 0) {
			throw new NegativeNumberException();
		}
	}
	
	/**
	 * Checks if the provided text is empty and throws an exception if it is.
	 *
	 * @param texto The text to be checked.
	 * @throws InvalidEmptyException If the text is empty.
	 */
	public static void revisarEspacioBlanco(String texto) throws InvalidEmptyException {
	    if (texto.equals("")) {
	        throw new InvalidEmptyException();
	    }
	}
	
}
