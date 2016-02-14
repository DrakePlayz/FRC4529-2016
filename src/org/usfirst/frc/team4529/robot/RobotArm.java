package org.usfirst.frc.team4529.robot;

import org.usfirst.frc.team4529.framework.Angle;
import org.usfirst.frc.team4529.robot.exceptions.ArmAngleNotSetException;
import org.usfirst.frc.team4529.robot.exceptions.ArmPastMaximumExtensionException;

/**
 * The arm singleton manages the arm on the robot. Can move the arm to a
 * relative angle from the chassis.
 * 
 * @author frogg
 *
 */
public class RobotArm extends Thread
{
    // TODO: Check arm max physical angle
    private static Angle ARM_LOWEST_ANGLE = Angle.ZERO;
    private static Angle ARM_HIGHEST_ANGLE = Angle.SIXTY;
    private volatile Angle armAngle;
    private boolean angleSet = false;
    private static RobotArm instance = null;
    private RobotState robotState = RobotState.getInstance();

    /**
     * Private constructor to make sure nobody cheats.
     */
    private RobotArm()
    {

    }

    /**
     * Singleton implementation. Only allows one instance.
     * 
     * @return the instance of this class.
     */
    public static RobotArm getInstance()
    {
	if(instance == null)
	{
	    instance = new RobotArm();
	}
	return instance;
    }

    /**
     * Move the arm to an angle.
     * 
     * @throws ArmPastMaximumExtensionException
     *             when the arm will go past the physical limit of the system.
     */
    private void move() throws ArmPastMaximumExtensionException
    {
	if(armAngle.greaterThan(ARM_HIGHEST_ANGLE) || armAngle.lessThan(ARM_LOWEST_ANGLE))
	{
	    throw new ArmPastMaximumExtensionException();
	}

	// TODO: Move arm to armAngle.
    }

    /**
     * Sets the angle to move the arm to.
     * 
     * @param angle
     *            the angle to move the arm to.
     */
    public void setAngle(Angle angle)
    {
	this.armAngle = angle;
	this.robotState.setRobotDesiredArmAngle(angle);
	this.angleSet = true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
	if(this.robotState.isResumeDesiredMotion())
	{
	    try
	    {
		this.setAngle(robotState.getRobotDesiredArmAngle());
	    }
	    catch(ArmAngleNotSetException e)
	    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}

	if(angleSet)
	{
	    try
	    {
		move();
		this.angleSet = false;
	    }
	    catch(ArmPastMaximumExtensionException e)
	    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	else
	{
	    try
	    {
		throw new ArmAngleNotSetException();
	    }
	    catch(ArmAngleNotSetException e)
	    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#interrupt()
     */
    @Override
    public void interrupt()
    {
	this.angleSet = false;
	super.interrupt();
    }
}
