package org.usfirst.frc.team4529.robot.sensors;

public class SwitchButtonWrapper
{
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

    private boolean isPressed;

}
