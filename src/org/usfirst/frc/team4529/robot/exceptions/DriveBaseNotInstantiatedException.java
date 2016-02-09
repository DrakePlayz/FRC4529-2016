package org.usfirst.frc.team4529.robot.exceptions;

/**
 * @author frogg
 *
 */
public class DriveBaseNotInstantiatedException extends Exception
{
    /**
     * generated UID.
     */
    private static final long serialVersionUID = -4693637626059188808L;

    private static final String DEFAULT_MESSAGE = "The drive base has not been instatiated with the system.";

    /**
     * The constructor which passes a message on to the exception class message.
     * 
     * @param msg
     */
    public DriveBaseNotInstantiatedException(String msg)
    {
	super(msg);
    }

    /**
     * The constructor which passes the default message to the exception class
     * message.
     */
    public DriveBaseNotInstantiatedException()
    {
	super(DEFAULT_MESSAGE);
    }
}
