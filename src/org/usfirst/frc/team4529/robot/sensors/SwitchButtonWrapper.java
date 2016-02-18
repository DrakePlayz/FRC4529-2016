package org.usfirst.frc.team4529.robot.sensors;

/**
 * A wrapper for a basic switch or button sensor.
 * 
 * @author frogg
 *
 */
public class SwitchButtonWrapper
{
    private boolean isPressed;

    /**
     * @return the isPressed
     */
    public boolean isPressed()
    {
	return this.isPressed;
    }

    /**
     * @param isPressed
     *            the isPressed to set
     */
    public void setPressed(boolean isPressed)
    {
	this.isPressed = isPressed;
    }
}
