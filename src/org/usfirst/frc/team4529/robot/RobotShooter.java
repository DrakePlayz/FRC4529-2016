package org.usfirst.frc.team4529.robot;

public class RobotShooter extends Thread
{
    private static RobotShooter instance = null;
    private static RobotState robotState = RobotState.getInstance();

    private RobotShooter()
    {

    }

    public static RobotShooter getInstance()
    {
	if(instance == null)
	{
	    instance = new RobotShooter();
	}
	return instance;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
	/*
	 * 1. Set motor direction and power (pickup/shoot)
	 * 1a. if shooting GOTO 2 else GOTO 3
	 * 
	 * 2. Make sure robot is in correct position and orientation
	 * 2a. maybe make driver check video with overlay and click okay
	 * GOTO 4
	 * 
	 * 3. Give driver manual control over driving the robot with video
	 * 3a. maybe have overlay of possible pickup positions
	 * 
	 * 4. Spin wheels at set power until ball loaded/shot
	 * 4a. if shooting, fire piston
	 */
    }

}
