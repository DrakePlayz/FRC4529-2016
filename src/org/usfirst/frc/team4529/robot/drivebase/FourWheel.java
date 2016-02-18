package org.usfirst.frc.team4529.robot.drivebase;

import org.usfirst.frc.team4529.framework.Angle;
import org.usfirst.frc.team4529.framework.Position;
import org.usfirst.frc.team4529.robot.RobotState;
import org.usfirst.frc.team4529.robot.exceptions.DriveBaseAlreadyExistsException;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

/**
 * A four contact wheeled drive base.
 * 
 * @author frogg
 *
 */
public class FourWheel extends DriveBase
{
    private RobotState robotState = RobotState.getInstance();
    private Talon leftMotor;
    private Talon rightMotor;

    /**
     * Constructor that follows a weird implementation of a singleton.
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
	this.robotState.setRobotDesiredOrientation(orientation);
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
	this.robotState.setRobotDesiredOrientation(robotState.getOrientation().add(orientation));
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
	double x = joystick.getRawAxis(0);
	double z = joystick.getRawAxis(2);
	double slider = joystick.getRawAxis(3);
	double desiredAngle = joystick.getDirectionRadians();
	double leftMotorPower = 0;
	double rightMotorPower = 0;

	// sign is -1 if joystick is back 1 if joystick is forward

	// if joystick is right &&
	// if joystick is left????
	if(x < 0)
	{
	    leftMotorPower = 1;
	    rightMotorPower = Math.cos(2 * desiredAngle + Math.PI);
	}
	else
	{
	    leftMotorPower = Math.cos(2 * desiredAngle + Math.PI);
	    rightMotorPower = 1;
	}

	double mainStickMagnitude = joystick.getMagnitude() / Math.sqrt(2);
	slider = ((-slider + 1) / 2);

	// SmartDashboard.putNumber("Left Motor Power MAX", leftMotorPower);
	// SmartDashboard.putNumber("Right Motor Power MAX", rightMotorPower);

	leftMotorPower = leftMotorPower * slider * mainStickMagnitude;
	rightMotorPower = rightMotorPower * slider * mainStickMagnitude;

	// SmartDashboard.putNumber("Magnitude", mainStickMagnitude);
	// SmartDashboard.putNumber("Slider", slider);
	// SmartDashboard.putNumber("Left Motor Power Mapped", leftMotorPower);
	// SmartDashboard.putNumber("Right Motor Power Mapped",
	// rightMotorPower);
	// SmartDashboard.putNumber("Desired Angle", desiredAngle);

	if(mainStickMagnitude > 0.1 | Math.abs(z) > 0.15)
	{
	    leftMotor.set(leftMotorPower);
	    rightMotor.set(-rightMotorPower);
	}
	else
	{
	    leftMotor.set(0);
	    rightMotor.set(0);
	}
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
