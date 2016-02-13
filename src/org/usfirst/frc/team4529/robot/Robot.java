package org.usfirst.frc.team4529.robot;

import java.util.ArrayDeque;
import org.usfirst.frc.team4529.robot.drivebase.DriveBase;
import org.usfirst.frc.team4529.robot.drivebase.FourWheel;
import org.usfirst.frc.team4529.robot.exceptions.DriveBaseAlreadyExistsException;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
    private static final int JOYSTICK_PORT = 0;
    private static final int JOYSTICK_STOP_BUTTON = 1;
    private RobotArm robotArm;
    private RobotState robotState;
    private RobotShooter robotShooter;
    private Joystick joystick;
    private DriveBase driveBase;
    private ArrayDeque<Thread> pausableThreads = new ArrayDeque<Thread>();

    /**
     * This function is run once each time the robot enters autonomous mode
     */
    @Override
    public void autonomousInit()
    {

    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic()
    {

    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit()
    {
	robotState = RobotState.getInstance();
	robotState.start();
	robotArm = RobotArm.getInstance();
	robotShooter = RobotShooter.getInstance();
	joystick = new Joystick(JOYSTICK_PORT);
	try
	{
	    driveBase = new FourWheel();
	    driveBase.setPriority(8);
	}
	catch(DriveBaseAlreadyExistsException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	pausableThreads.add(robotShooter);
	pausableThreads.add(robotArm);
	pausableThreads.add(driveBase);
    }

    /**
     * This function is called once each time the robot enters tele-operated
     * mode
     */
    @Override
    public void teleopInit()
    {

    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic()
    {
	if(joystick.getMagnitude() > 0.05)
	{
	    driveBase.joystickMove(joystick.getX(), joystick.getY());
	    try
	    {
		for(Thread t : pausableThreads)
		{
		    t.wait();
		}
	    }
	    catch(InterruptedException e)
	    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	else if(joystick.getRawButton(JOYSTICK_STOP_BUTTON))
	{
	    robotArm.interrupt();
	    robotShooter.interrupt();
	}
	else
	{
	    for(Thread t : pausableThreads)
	    {
		switch(t.getState())
		{
		    case WAITING:
		    {
			t.notify();
			break;
		    }
		    default:
		    {

		    }
		}
	    }
	}
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic()
    {
	LiveWindow.run();
    }

}
