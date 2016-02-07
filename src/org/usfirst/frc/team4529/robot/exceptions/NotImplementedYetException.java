/**
 * 
 */
package org.usfirst.frc.team4529.robot.exceptions;

/**
 * Thrown when no code has been written for a method.
 * 
 * @author frogg
 *
 */
public class NotImplementedYetException extends Exception
{

    /**
     * generated UID.
     */
    private static final long serialVersionUID = -7556372886489202416L;

    private static final String DEFAULT_MESSAGE = "Code not yet typed up.";

    /**
     * The constructor which passes a message on to the exception class message.
     * 
     * @param msg
     */
    public NotImplementedYetException(String msg)
    {
	super(msg);
    }

    /**
     * The constructor which passes the default message to the exception class
     * message.
     */
    public NotImplementedYetException()
    {
	super(DEFAULT_MESSAGE);
    }
}
