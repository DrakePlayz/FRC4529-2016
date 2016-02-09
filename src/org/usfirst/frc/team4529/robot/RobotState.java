package org.usfirst.frc.team4529.robot;

import org.usfirst.frc.team4529.framework.Angle;
import org.usfirst.frc.team4529.framework.Position;
import org.usfirst.frc.team4529.framework.ShootingWheelState;

/**
 * Holds the state of the robot and updates all the states in other classes.
 * 
 * @author frogg
 *
 */
public class RobotState extends Thread
{
    private Position robotPosition;
    private Angle orientation;
    private Angle armAngle;
    private boolean ballCollected;
    private ShootingWheelState shootingWheelState;
    private static RobotState instance = null;

    /**
     * Private constructor to prevent rogue objects.
     */
    private RobotState()
    {

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
	return this.robotPosition;
    }

    /**
     * @param robotPosition
     *            the robotPosition to set
     */
    private void setRobotPosition(Position robotPosition)
    {
	this.robotPosition = robotPosition;
    }

    /**
     * @return the orientation
     */
    public Angle getOrientation()
    {
	return this.orientation;
    }

    /**
     * @param orientation
     *            the orientation to set
     */
    private void setOrientation(Angle orientation)
    {
	this.orientation = orientation;
    }

    /**
     * @return the armAngle
     */
    public Angle getArmAngle()
    {
	return this.armAngle;
    }

    /**
     * @param armAngle
     *            the armAngle to set
     */
    private void setArmAngle(Angle armAngle)
    {
	this.armAngle = armAngle;
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
    private void setBallCollected(boolean ballCollected)
    {
	this.ballCollected = ballCollected;
    }

    /**
     * @return the shootingWheelState
     */
    public ShootingWheelState getShootingWheelState()
    {
	return this.shootingWheelState;
    }

    /**
     * @param shootingWheelState
     *            the shootingWheelState to set
     */
    private void setShootingWheelState(ShootingWheelState shootingWheelState)
    {
	this.shootingWheelState = shootingWheelState;
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
	}
    }
}
