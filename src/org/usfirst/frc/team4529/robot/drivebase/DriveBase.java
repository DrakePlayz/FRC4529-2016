package org.usfirst.frc.team4529.robot.drivebase;

import org.usfirst.frc.team4529.framework.Angle;
import org.usfirst.frc.team4529.framework.Position;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Defines what each implementation of a drive base will be able to do.
 * Mechanum, omniwheel, 6 wheel, 4 wheel, etc.
 * 
 * @author frogg
 *
 */
public abstract class DriveBase extends Thread
{
    protected double x;
    protected double y;
    protected double z;
    protected double percentPower;
    protected double mainStickMagnitude;
    protected double joystickAngle;

    /**
     * Move the robot with joystick input.
     * 
     * @param joystick
     *            the joystick used for driving.
     */
    public abstract void joystickMove(Joystick joystick);

    /**
     * Sets all the various values based on joystick input.
     * 
     * @param joystick
     *            the joystick used.
     */
    protected void setJoystickValue(Joystick joystick)
    {
	joystickAngle = (Math.PI / 2) - joystick.getDirectionRadians();
	x = joystick.getRawAxis(0);
	y = -joystick.getRawAxis(1);
	z = joystick.getRawAxis(2);
	percentPower = (-joystick.getRawAxis(3) + 1) / 2;
	mainStickMagnitude = joystick.getMagnitude() / Math.sqrt(2);
    }

    /**
     * Move the robot to an absolute position.
     * 
     * @param position
     *            the absolute position to move the robot to.
     * @param orientation
     *            the final orientation of the robot.
     */
    public abstract void moveTo(Position position, Angle orientation);

    /**
     * Move the robot by a certain amount (adjustment)
     * 
     * @param position
     *            the amount to move the robot by.
     * @param orientation
     *            the change in orientation of the robot. <i>Positive is
     *            clockwise</i>.
     */
    public abstract void moveBy(Position position, Angle orientation);
}
