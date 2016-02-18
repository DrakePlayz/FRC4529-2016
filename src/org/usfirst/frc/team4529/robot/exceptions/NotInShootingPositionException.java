package org.usfirst.frc.team4529.robot.exceptions;

/**
 * The exception for when the robot is not in the right shooting position.
 * 
 * @author frogg
 *
 */
public class NotInShootingPositionException extends Exception
{
    /**
     * Generated UID.
     */
    private static final long serialVersionUID = 7701137188686987773L;

    private static final String DEFAULT_MESSAGE = "Robot not close enough to shooting position.";

    /**
     * The constructor which passes a message on to the exception class message.
     * 
     * @param msg
     *            the message for the exception.
     */
    public NotInShootingPositionException(String msg)
    {
	super(msg);
    }

    /**
     * The constructor which passes the default message to the exception class
     * message.
     */
    public NotInShootingPositionException()
    {
	super(DEFAULT_MESSAGE);
    }
}
