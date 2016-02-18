package org.usfirst.frc.team4529.field.exceptions;

/**
 * The exception thrown when there are no othre exceptions in the same category
 * (LOWBAR).
 * 
 * @author frogg
 *
 */
public class NoOtherDefenseInCategoryException extends Exception
{

    /**
     * generated UID.
     */
    private static final long serialVersionUID = 4169828088129193565L;

    private static final String DEFAULT_MESSAGE = "There are no other defenses in the same category.";

    /**
     * The constructor which passes a message on to the exception class message.
     * 
     * @param msg
     */
    public NoOtherDefenseInCategoryException(String msg)
    {
	super(msg);
    }

    /**
     * The constructor that passes the default message to the exception class
     * message.
     */
    public NoOtherDefenseInCategoryException()
    {
	super(DEFAULT_MESSAGE);
    }
}
