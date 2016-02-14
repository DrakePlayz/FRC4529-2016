package org.usfirst.frc.team4529.robot.drivebase;

import org.usfirst.frc.team4529.framework.Angle;
import org.usfirst.frc.team4529.framework.Position;
import org.usfirst.frc.team4529.robot.RobotState;
import org.usfirst.frc.team4529.robot.exceptions.DriveBaseAlreadyExistsException;
import edu.wpi.first.wpilibj.Joystick;

/**
 * A four contact wheeled drive base.
 * 
 * @author frogg
 *
 */
public class FourWheel extends DriveBase
{
    private RobotState robotState = RobotState.getInstance();

    /**
     * 
     * @throws DriveBaseAlreadyExistsException
     */
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
     * org.usfirst.frc.team4529.robot.drivebase.DriveBase#moveTo(org.usfirst.frc
     * .team4529.framework.Position, org.usfirst.frc.team4529.framework.Angle)
     */
    @Override
    public void moveTo(Position position, Angle orientation)
    {
	this.robotState.setRobotDesiredPosition(position);
	// TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.usfirst.frc.team4529.robot.drivebase.DriveBase#moveBy(org.usfirst.frc
     * .team4529.framework.Position, org.usfirst.frc.team4529.framework.Angle)
     */
    @Override
    public void moveBy(Position position, Angle orientation)
    {
	this.robotState.setRobotDesiredPosition(robotState.getRobotPosition().add(position));
	// TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.usfirst.frc.team4529.robot.drivebase.DriveBase#joystickMove(edu.wpi.
     * first.wpilibj.Joystick)
     */
    @Override
    public void joystickMove(Joystick joystick)
    {
	robotDrive.arcadeDrive(joystick);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    @Override
    public void run()
    {
	if(this.robotState.isResumeDesiredMotion())
	{
	    this.moveTo(this.robotState.getRobotDesiredPosition(), this.robotState.getRobotDesiredOrientation());
	}
    }
}
