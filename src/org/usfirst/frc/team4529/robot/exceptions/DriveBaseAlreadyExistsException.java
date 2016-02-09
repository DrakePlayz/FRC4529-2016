package org.usfirst.frc.team4529.robot.exceptions;

/**
 * 
 * @author frogg
 *
 */
public class DriveBaseAlreadyExistsException extends Exception
{
    /**
     * generated UID.
     */
    private static final long serialVersionUID = 554576801628211806L;

    private static final String DEFAULT_MESSAGE = "The drive base is already instatiated with the system.";

    /**
     * The constructor which passes a message on to the exception class message.
     * 
     * @param msg
     */
    public DriveBaseAlreadyExistsException(String msg)
    {
	super(msg);
    }

    /**
     * The constructor which passes the default message to the exception class
     * message.
     */
    public DriveBaseAlreadyExistsException()
    {
	super(DEFAULT_MESSAGE);
    }
}
