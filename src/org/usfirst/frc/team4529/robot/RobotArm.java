package org.usfirst.frc.team4529.robot;

import org.usfirst.frc.team4529.framework.Angle;
import org.usfirst.frc.team4529.robot.exceptions.ArmAngleNotSetException;
import org.usfirst.frc.team4529.robot.exceptions.ArmPastMaximumExtensionException;
import org.usfirst.frc.team4529.robot.framework.RoboRioPWMPorts;
import edu.wpi.first.wpilibj.Jaguar;

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
    public static final Angle ARM_LOWEST_ANGLE = Angle.ZERO;
    public static final Angle ARM_HIGHEST_ANGLE = new Angle(75);
    public static final Angle ARM_ANGLE_RANGE = ARM_HIGHEST_ANGLE.subtract(ARM_LOWEST_ANGLE);
    public static final double ARM_LOWEST_POT_SAFE_VALUE = 270;
    public static final double ARM_HIGHEST_POT_SAFE_VALUE = 1500;
    public static final double ARM_POT_RANGE = ARM_HIGHEST_POT_SAFE_VALUE - ARM_LOWEST_POT_SAFE_VALUE;

    public static final Jaguar ARM_MOTOR = new Jaguar(RoboRioPWMPorts.ARM_MOTOR.getPort());

    // PID tuning constants [0-1]
    // TODO: Tune constants
    private static final double DERIVATIVE_CONSTANT = 1;
    private static final double INTEGRAL_CONSTANT = .2;
    private static final double PROPORTIONAL_CONSTANT = .5;

    private volatile Angle armAngle;
    private boolean angleSet = false;
    private static RobotArm instance = null;
    private RobotState robotState = RobotState.getInstance();

    /**
     * Private constructor to make sure nobody cheats.
     */
    private RobotArm()
    {
	// intentionally left empty
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

	pidMove(this.armAngle);
    }

    /**
     * Moves the arm to a desired angle using really basic PID tuning.
     * 
     * @param desiredArmAngle
     *            the angle to move the arm to.
     */
    private void pidMove(Angle desiredArmAngle)
    {
	long dt = System.currentTimeMillis();
	double previousError = 0;
	double integral = 0;
	double derivative;
	double error;
	while(this.armAngle != this.robotState.getRobotCurrentArmAngle())
	{
	    dt = (System.currentTimeMillis() - dt) / 1000;
	    error = desiredArmAngle.subtract(this.robotState.getRobotCurrentArmAngle()).getValue()
		    / ARM_ANGLE_RANGE.getValue();
	    integral = integral + (error * dt);
	    derivative = (error - previousError) / dt;
	    ARM_MOTOR.set(
		    (PROPORTIONAL_CONSTANT * error + INTEGRAL_CONSTANT * integral + DERIVATIVE_CONSTANT * derivative));
	    // would be nice to get this between -1 and 1 before setting but I
	    // can't think of a way to do that. Currently this will just set max
	    // power and hopefully reduce power as the desired position
	    // approaches.
	    previousError = error;
	}
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
