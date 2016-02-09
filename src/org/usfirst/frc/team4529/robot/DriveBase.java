package org.usfirst.frc.team4529.robot;

import org.usfirst.frc.team4529.framework.Position;
import org.usfirst.frc.team4529.robot.exceptions.DriveBaseNotInstantiatedException;

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

    /**
     * Move the robot with joystick input.
     * 
     * @param xAxis
     *            the x axis input (left right).
     * @param yAxis
     *            the y axis input (up down).
     */
    public abstract void joystickMove(double xAxis, double yAxis);

    /**
     * Move the robot to an absolute position.
     * 
     * @param position
     *            the absolute position to move the robot to.
     */
    public abstract void moveTo(Position position);

    /**
     * Move the robot by a certain amount (adjustment)
     * 
     * @param position
     *            the amount to move the robot by.
     */
    public abstract void moveBy(Position position);

    /**
     * 
     * @return the instance of the drive base.
     * @throws DriveBaseNotInstantiatedException
     *             if no drive base has been instantiated.
     */
    public final DriveBase getDriveBase() throws DriveBaseNotInstantiatedException
    {
	if(driveBase == null)
	{
	    throw new DriveBaseNotInstantiatedException();
	}
	return driveBase;
    }
}
