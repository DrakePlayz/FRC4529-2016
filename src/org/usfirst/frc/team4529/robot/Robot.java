package org.usfirst.frc.team4529.robot;

import java.util.ArrayDeque;
import java.util.EnumSet;
import org.usfirst.frc.team4529.robot.drivebase.OmniWheel;
import org.usfirst.frc.team4529.robot.framework.LogitechJoystickButtons;
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
    private static final EnumSet<LogitechJoystickButtons> JB = EnumSet.allOf(LogitechJoystickButtons.class);
    private RobotArm robotArm;
    private RobotState robotState;
    private RobotShooter robotShooter;
    private Joystick joystick;
    private OmniWheel driveBase;
    private ArrayDeque<Thread> pausableThreads = new ArrayDeque<Thread>();
    private boolean startThreads = false;

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

	// driveBase = new FourWheel();
	driveBase = new OmniWheel();

	pausableThreads.add(robotShooter);
	pausableThreads.add(robotArm);
	// pausableThreads.add(driveBase);
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
	EnumSet<LogitechJoystickButtons> buttonPressed = EnumSet.noneOf(LogitechJoystickButtons.class);
	for(LogitechJoystickButtons jb : JB)
	{
	    if(joystick.getRawButton(jb.getButtonNum()))
	    {
		buttonPressed.add(jb);
		if(LogitechJoystickButtons.getCancelArmButtons().contains(jb))
		{
		    if(robotArm.isAlive())
		    {
			robotArm.interrupt();
		    }
		}

		if(LogitechJoystickButtons.getCancelDriveButtons().contains(jb) || joystick.getMagnitude() > 0.05
			|| joystick.getRawAxis(2) > 0.05)
		{
		    if(driveBase.isAlive())
		    {
			driveBase.interrupt();
		    }
		}
	    }
	}

	if(!driveBase.isAlive())
	{
	    driveBase.joystickMove(joystick);
	}
	else if(buttonPressed.contains(LogitechJoystickButtons.STOP_AUTO))
	{
	    robotState.setResumeDesiredMotion(false);
	    startThreads = false;
	}

	if(startThreads)
	{
	    for(Thread t : pausableThreads)
	    {
		switch(t.getState())
		{
		    case TERMINATED:
		    {
			t.start();
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
