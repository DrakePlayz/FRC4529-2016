package org.usfirst.frc.team4529.robot.drivebase;

import org.usfirst.frc.team4529.framework.Position;
import org.usfirst.frc.team4529.robot.RobotState;
import org.usfirst.frc.team4529.robot.exceptions.DriveBaseAlreadyExistsException;

/**
 * @author frogg
 *
 */
public class FourWheel extends DriveBase
{

    public FourWheel() throws DriveBaseAlreadyExistsException
    {
	if(driveBase == null)
	{
	    driveBase = this;
	    return;
	}

	throw new DriveBaseAlreadyExistsException();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.usfirst.frc.team4529.robot.DriveBase#moveTo(org.usfirst.frc.team4529.
     * framework.Position)
     */
    @Override
    public void moveTo(Position position)
    {
	// TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.usfirst.frc.team4529.robot.DriveBase#moveBy(org.usfirst.frc.team4529.
     * framework.Position)
     */
    @Override
    public void moveBy(Position position)
    {
	// TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.usfirst.frc.team4529.robot.DriveBase#joystickMove(double,
     * double)
     */
    @Override
    public void joystickMove(double xAxis, double yAxis)
    {
	// TODO Auto-generated method stub

    }

}
