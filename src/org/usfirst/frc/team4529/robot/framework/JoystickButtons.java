package org.usfirst.frc.team4529.robot.framework;

/**
 * Class to define all the joystick buttons.
 * 
 * @author frogg
 *
 */
public enum JoystickButtons
{
    /**
     * Fully stop and kill any autonomous actions in driving and shooting.
     */
    STOP_AUTO(1),

    /**
     * Save the desired state of any autonomous driving or shooting actions and
     * then kill the threads with the intent of resuming motions to those saved
     * states.
     */
    PAUSE_RESUME_AUTO(2),

    /**
     * Raise the arm, extend the arm, lower the arm, spin collection wheels.
     */
    START_COLLECTION(3),

    /**
     * Stop the arm wheels from spinning.
     */
    STOP_SHOOTER_WHEELS(4),

    /**
     * Raise the arm, retract the arm, lower the arm.
     */
    STORE_ARM(5),

    /**
     * Raise the arm, extend the arm, spin shooting wheels.
     */
    SHOOTING_CONFIG(6),

    /**
     * Fire the shooting piston.
     */
    SHOOT_PISTON(7),

    /**
     * Extend the arm.
     */
    EXTEND_ARM(8),

    /**
     * Retract the arm.
     */
    RETRAC_ARM(9),

    /**
     * Spin collection wheels.
     */
    COLLECTION_WHEELS(10),

    /**
     * Spin shooting wheels.
     */
    SHOOTING_WHEELS(11);

    private int buttonNum;

    private JoystickButtons(int buttonNum)
    {
	setButtonNum(buttonNum);
    }

    /**
     * @return the buttonNum
     */
    public int getButtonNum()
    {
	return buttonNum;
    }

    /**
     * @param buttonNum
     *            the buttonNum to set
     */
    public void setButtonNum(int buttonNum)
    {
	this.buttonNum = buttonNum;
    }
}
