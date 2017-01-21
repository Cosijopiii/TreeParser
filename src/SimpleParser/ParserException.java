/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SimpleParser;

/**
 * This class extends a normal excpetion to our specific parserexception.
 * @author Sunshine2k
 */
public class ParserException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParserException(String s)
    {
        super(s);
    }
}
