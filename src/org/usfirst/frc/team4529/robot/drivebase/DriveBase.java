package org.usfirst.frc.team4529.robot.drivebase;

import org.usfirst.frc.team4529.framework.Angle;
import org.usfirst.frc.team4529.framework.Position;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * Defines what each implementation of a drive base will be able to do.
 * Mechanum, omniwheel, 6 wheel, 4 wheel, etc.
 * 
 * @author frogg
 *
 */
public abstract class DriveBase extends Thread
{
    protected static DriveBase driveBase = null;
    protected RobotDrive robotDrive;

    /**
     * Move the robot with joystick input.
     * 
     * @param joystick
     *            the joystick used for driving.
     */
    public abstract void joystickMove(Joystick joystick);

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

    /**
     * @return the robotDrive
     */
    public RobotDrive getRobotDrive()
    {
	return robotDrive;
    }

    /**
     * @param robotDrive
     *            the robotDrive to set
     */
    public void setRobotDrive(RobotDrive robotDrive)
    {
	this.robotDrive = robotDrive;
    }
}
