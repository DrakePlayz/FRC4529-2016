package org.usfirst.frc.team4529.robot;

import org.usfirst.frc.team4529.field.Location;
import org.usfirst.frc.team4529.framework.Angle;
import org.usfirst.frc.team4529.framework.Position;
import org.usfirst.frc.team4529.robot.exceptions.ArmAngleNotSetException;

/**
 * Holds the state of the robot and updates all the states in other classes.
 * 
 * @author frogg
 *
 */
public class RobotState extends Thread
{
    private Position robotCurrentPosition;
    private Position robotDesiredPosition;
    private Angle robotCurrentOrientation;
    private Angle robotDesiredOrientation;
    private Angle robotCurrentArmAngle;
    private Angle robotDesiredArmAngle;
    private boolean resumeDesiredMotion;
    private boolean robotArmExtended;
    private boolean ballCollected;

    private static RobotState instance = null;

    /**
     * Private constructor to prevent rogue objects.
     */
    private RobotState()
    {
	// intentionally left empty.
    }

    /**
     * Singleton implementation to only allow one instance.
     * 
     * @return the instance of this object.
     */
    public static RobotState getInstance()
    {
	if(instance == null)
	{
	    instance = new RobotState();
	}
	return instance;
    }

    /**
     * @return the robotPosition
     */
    public Position getRobotPosition()
    {
	return this.robotCurrentPosition;
    }

    /**
     * @param robotPosition
     *            the robotPosition to set
     */
    private void setRobotPosition(Position robotPosition)
    {
	this.robotCurrentPosition = robotPosition;
    }

    /**
     * @return the orientation
     */
    public Angle getOrientation()
    {
	return this.robotCurrentOrientation;
    }

    /**
     * @param orientation
     *            the orientation to set
     */
    private void setRobotOrientation(Angle orientation)
    {
	this.robotCurrentOrientation = orientation;
    }

    /**
     * @return the armAngle
     */
    public Angle getArmAngle()
    {
	return this.robotCurrentArmAngle;
    }

    /**
     * @param armAngle
     *            the armAngle to set
     */
    private void setRobotArmAngle(Angle armAngle)
    {
	this.robotCurrentArmAngle = armAngle;
    }

    /**
     * @return the ballCollected
     */
    public boolean isBallCollected()
    {
	return this.ballCollected;
    }

    /**
     * @param ballCollected
     *            the ballCollected to set
     */
    public void setBallCollected(boolean ballCollected)
    {
	this.ballCollected = ballCollected;
    }

    /**
     * @return the robotDesiredPosition
     */
    public Position getRobotDesiredPosition()
    {
	return this.robotDesiredPosition;
    }

    /**
     * @param robotDesiredPosition
     *            the robotDesiredPosition to set
     */
    public void setRobotDesiredPosition(Position robotDesiredPosition)
    {
	this.robotDesiredPosition = robotDesiredPosition;
    }

    /**
     * @return the robotDesiredOrientation
     */
    public Angle getRobotDesiredOrientation()
    {
	return this.robotDesiredOrientation;
    }

    /**
     * @param robotDesiredOrientation
     *            the robotDesiredOrientation to set
     */
    public void setRobotDesiredOrientation(Angle robotDesiredOrientation)
    {
	this.robotDesiredOrientation = robotDesiredOrientation;
    }

    /**
     * @return the robotDesiredArmAngle
     * @throws ArmAngleNotSetException
     *             if the arm angle has not been set yet.
     */
    public Angle getRobotDesiredArmAngle() throws ArmAngleNotSetException
    {
	if(this.robotDesiredArmAngle == null)
	{
	    throw new ArmAngleNotSetException();
	}

	return this.robotDesiredArmAngle;
    }

    /**
     * @param robotDesiredArmAngle
     *            the robotDesiredArmAngle to set
     */
    public void setRobotDesiredArmAngle(Angle robotDesiredArmAngle)
    {
	this.robotDesiredArmAngle = robotDesiredArmAngle;
    }

    /**
     * @return the resumeDesiredMotion
     */
    public boolean isResumeDesiredMotion()
    {
	return resumeDesiredMotion;
    }

    /**
     * @param resumeDesiredMotion
     *            the resumeDesiredMotion to set
     */
    public void setResumeDesiredMotion(boolean resumeDesiredMotion)
    {
	this.resumeDesiredMotion = resumeDesiredMotion;
    }

    /**
     * @return the robotArmExtended
     */
    public boolean isRobotArmExtended()
    {
	return robotArmExtended;
    }

    /**
     * @param robotArmExtended
     *            the robotArmExtended to set
     */
    public void setRobotArmExtended(boolean robotArmExtended)
    {
	this.robotArmExtended = robotArmExtended;
    }

    /**
     * 
     * @param desiredLocation
     * @return
     */
    public boolean checkPosition(Location desiredLocation)
    {
	// TODO Auto-generated method stub
	// if the current location is within a range of the desired location
	// return true.
	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
	while(true)
	{
	    // TODO: get values from all the sensors and update the information.
	    setRobotPosition(Position.ORIGIN);
	    setRobotOrientation(Angle.ZERO);
	    setRobotArmAngle(Angle.ZERO);
	}
    }
}
