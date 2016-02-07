package org.usfirst.frc.team4529.robot;

import org.usfirst.frc.team4529.framework.Angle;
import org.usfirst.frc.team4529.framework.Length;
import org.usfirst.frc.team4529.robot.exceptions.ArmPastMaximumExtensionException;
import org.usfirst.frc.team4529.robot.exceptions.NotImplementedYetException;

/**
 * The arm class manages the arm on the robot. Can move the arm to a relative
 * angle from the chassis.
 * 
 * @author frogg
 *
 */
public class Arm
{
    // TODO: Check arm max physical angle
    private static Angle ARM_LOWEST_ANGLE = Angle.ZERO;
    private static Angle ARM_HIGHEST_ANGLE = Angle.NINTY;
    private Angle armAngle;
    private Length height;

    /**
     * Move the arm to an angle.
     * 
     * @param moveToAngle
     *            The angle to change the position to or by depending on whether
     *            or not <b>absolute</b> is <i>true</i>.
     * @param absolute
     *            Whether the move is to an absolute position or a relative
     *            position.
     * @throws ArmPastMaximumExtensionException
     *             when the arm will go past the physical limit of the system.
     */
    public void Move(Angle moveToAngle, boolean absolute) throws ArmPastMaximumExtensionException
    {
	if(absolute)
	{
	    if(moveToAngle.greaterThan(ARM_HIGHEST_ANGLE) || moveToAngle.greaterThan(ARM_LOWEST_ANGLE))
	    {
		throw new ArmPastMaximumExtensionException();
	    }
	    // TODO: Move arm to angle with linear motor and update current
	    // height and angle.
	}
	else
	{
	    if(Angle.add(this.armAngle, moveToAngle).greaterThan(ARM_HIGHEST_ANGLE))
	    {
		throw new ArmPastMaximumExtensionException();
	    }

	    // TODO: Move arm by moveToAngle with linear motor and update
	    // current height and angle.
	}
    }

    /**
     * Move the arm to a certain height.
     * 
     * @param moveToHeight
     *            The height to be moved either to or by for the arm depending
     *            on whether <b>absolute</b> is true.
     * @param absolute
     *            Whether the arm height is absolute or relative to current
     *            position.
     * @throws NotImplementedYetException
     *             code not completed.
     */
    public void Move(Length moveToHeight, boolean absolute) throws NotImplementedYetException
    {
	// TODO: Move arm to position with linear motor.
	throw new NotImplementedYetException();
    }
}
