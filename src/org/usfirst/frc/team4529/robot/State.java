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
public class State implements Runnable
{
    private Position robotPosition;

    private Angle orientation;

    private Angle armAngle;

    private boolean ballCollected;

    private ShootingWheelState shootingWheelState;

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
    public void setRobotPosition(Position robotPosition)
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
    public void setOrientation(Angle orientation)
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
    public void setArmAngle(Angle armAngle)
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
    public void setBallCollected(boolean ballCollected)
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
    public void setShootingWheelState(ShootingWheelState shootingWheelState)
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
	// TODO: get values from all the sensors and update the information.
    }
}
