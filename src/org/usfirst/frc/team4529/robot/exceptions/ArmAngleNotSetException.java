package org.usfirst.frc.team4529.robot.exceptions;

/**
 * The exception for when the arm is told to move but no angle has been set yet.
 * 
 * @author frogg
 *
 */
public class ArmAngleNotSetException extends Exception
{
    /**
     * Generated UID.
     */
    private static final long serialVersionUID = 6460574004297220146L;

    private static final String DEFAULT_MESSAGE = "There is no angle to move the arm to.";

    /**
     * The constructor which passes a message on to the exception class message.
     * 
     * @param msg
     *            the message for the exception.
     */
    public ArmAngleNotSetException(String msg)
    {
	super(msg);
    }

    /**
     * The constructor that passes the default message to the exception class
     * message.
     */
    public ArmAngleNotSetException()
    {
	super(DEFAULT_MESSAGE);
    }
}
