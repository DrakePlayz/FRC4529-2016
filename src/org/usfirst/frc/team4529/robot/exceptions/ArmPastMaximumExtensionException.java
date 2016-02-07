package org.usfirst.frc.team4529.robot.exceptions;

/**
 * Thrown when the arm will go past the maximum extension of the linear
 * actuator.
 * 
 * @author frogg
 *
 */
public class ArmPastMaximumExtensionException extends Exception
{

    /**
     * generated UID
     */
    private static final long serialVersionUID = -8918647989603777962L;

    private static final String DEFAULT_MESSAGE = "The arm will be past maximum extension. Cannot complete the move.";

    /**
     * The constructor which passes a message on to the exception class message.
     * 
     * @param msg
     */
    public ArmPastMaximumExtensionException(String msg)
    {
	super(msg);
    }

    /**
     * The constructor that passes the default message to the exception class
     * message.
     */
    public ArmPastMaximumExtensionException()
    {
	super(DEFAULT_MESSAGE);
    }
}
