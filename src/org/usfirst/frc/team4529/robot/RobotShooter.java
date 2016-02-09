package org.usfirst.frc.team4529.robot;

public class RobotShooter extends Thread
{
    private static RobotShooter instance = null;

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
	// TODO Auto-generated method stub

    }

}
