/**
 * package to store classes that handle application exceptions
 */
package co.edu.unbosque.util.exceptions;

/**
 * Class where email exceptions can be handled.
 * 
 * @autor Juan Diego Triana Mejía
 * @autor Juan David Guarnizo Martínez
 * @autor Gabriel Alejandro Ruiz Cruz
 */
public class CheckMail extends Exception {
	/**
	 * Function that will return a text message for email exceptions.
	 */
	public CheckMail() {
		super("The email is incorrect, please rewrite it");
	}
}
