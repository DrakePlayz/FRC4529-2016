package org.usfirst.frc.team4529.robot;

import org.usfirst.frc.team4529.field.Location;
import org.usfirst.frc.team4529.robot.exceptions.NotInShootingPositionException;

/**
 * The robot shooter thread that handles pickup and shooting.
 * 
 * @author frogg
 *
 */
public class RobotShooter extends Thread
{
    private static RobotShooter instance = null;
    private static RobotState robotState = RobotState.getInstance();
    private boolean shooting;

    /**
     * Private constructor for singleton.
     */
    private RobotShooter()
    {
	// intentionally left empty.
    }

    /**
     * Singleton implementation.
     * 
     * @return the instance of the robot shooter.
     */
    public static RobotShooter getInstance()
    {
	if(instance == null)
	{
	    instance = new RobotShooter();
	}
	return instance;
    }

    /**
     * @return the shooting
     */
    public boolean isShooting()
    {
	return shooting;
    }

    /**
     * @param shooting
     *            the shooting to set
     */
    public void setShooting(boolean shooting)
    {
	this.shooting = shooting;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
	if(shooting)
	{
	    if(robotState.checkPosition(Location.HIGH_GOAL_CENTER) || robotState.checkPosition(Location.HIGH_GOAL_LEFT))
	    {
		/*
		 * Set motors to shooting. Run power. Wait for arm angle
		 * (join?). Fire Piston.
		 */
	    }
	    else if(robotState.checkPosition(Location.LOW_GOAL_LEFT)
		    || robotState.checkPosition(Location.LOW_GOAL_RIGHT))
	    {
		/*
		 * Set motors to shooting. Check arm angle. If correct, run
		 * motors. Fire piston.
		 */
	    }
	    else
	    {
		try
		{
		    throw new NotInShootingPositionException();
		}
		catch(NotInShootingPositionException e)
		{
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	}
	else
	{
	    // pickup, so enable the manual control? (disable the automated
	    // driving)
	}
	/*
	 * 1. Set motor direction and power (pickup/shoot).
	 * 1a. if shooting GOTO 2 else GOTO 3.
	 * 
	 * 2. Make sure robot is in correct position and orientation.
	 * 2a. maybe make driver check video with overlay and click okay.
	 * GOTO 4
	 * 
	 * 3. Give driver manual control over driving the robot with video.
	 * 3a. maybe have overlay of possible pickup positions.
	 * 
	 * 4. Spin wheels at set power until ball loaded/shot.
	 * 4a. if shooting, fire piston.
	 */
    }

}
