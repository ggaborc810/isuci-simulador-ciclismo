/**
 * package to store classes that handle application exceptions
 */
package co.edu.unbosque.util.exceptions;
/**
 * Class where the exception of negative number typing can be handled.
 * 
 * @author Juan Diego Triana Mejía
 * @author Juan David Guarnizo Martínez
 * @author Gabriel Alejandro Ruiz Cruz
 */
public class NegativeNumberException extends Exception{

	/**
	 * Function that will return a text message for negative number typing.
	 */
	public NegativeNumberException() {
		super("The entered number cannot be negative." + "\nPlease rewrite it: ");
	}
}
