package org.usfirst.frc.team4529.robot.drivebase;

import org.usfirst.frc.team4529.framework.Angle;
import org.usfirst.frc.team4529.framework.CubicPathGenerator;
import org.usfirst.frc.team4529.framework.Position;
import org.usfirst.frc.team4529.robot.RobotState;
import org.usfirst.frc.team4529.robot.exceptions.DriveBaseAlreadyExistsException;
import org.usfirst.frc.team4529.robot.framework.RoboRioPWMPorts;
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
    private Talon leftMotor = new Talon(RoboRioPWMPorts.LEFT_MOTOR.getPort());
    private Talon rightMotor = new Talon(RoboRioPWMPorts.RIGHT_MOTOR.getPort());

    /**
     * Constructor that follows a weird implementation of a singleton.
     * 
     * @throws DriveBaseAlreadyExistsException
     */
    public FourWheel() throws DriveBaseAlreadyExistsException
    {

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

	CubicPathGenerator path = new CubicPathGenerator(this.robotState.getRobotCurrentPosition(),
		this.robotState.getRobotCurrentOrientation(), position, orientation);

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
	Position finalPosition = this.robotState.getRobotCurrentPosition().add(position);
	Angle finalOrientation = this.robotState.getRobotCurrentOrientation().add(orientation);

	this.robotState.setRobotDesiredPosition(finalPosition);
	this.robotState.setRobotDesiredOrientation(finalOrientation);

	CubicPathGenerator path = new CubicPathGenerator(this.robotState.getRobotCurrentPosition(),
		this.robotState.getRobotCurrentOrientation(), finalPosition, finalOrientation);
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
	double leftMotorPower = 0;
	double rightMotorPower = 0;

	if(Math.abs(z) > 0.15)
	{// clockwise is negative
	    leftMotorPower = Math.pow(z, 2);
	    rightMotorPower = Math.pow(z, 2);
	    if(z > 0)
	    {
		rightMotorPower = -rightMotorPower;
	    }
	    else
	    {
		leftMotorPower = -leftMotorPower;
	    }
	}
	else if(x < 0)
	{// joystick left
	    leftMotorPower = Math.sin(joystickAngle);
	    if(y > 0)
	    {// forward
		rightMotorPower = mainStickMagnitude;
	    }
	    else
	    {// backward
		rightMotorPower = -mainStickMagnitude;
	    }
	}
	else
	{// joystick right
	    rightMotorPower = Math.sin(joystickAngle);
	    if(y > 0)
	    {// forward
		leftMotorPower = mainStickMagnitude;
	    }
	    else
	    {// backward
		leftMotorPower = -mainStickMagnitude;
	    }
	}

	if(mainStickMagnitude > 0.05 || z > 0.05)
	{
	    driveMotors(leftMotorPower, rightMotorPower, percentPower);
	}
	else
	{
	    driveMotors(0, 0, 0);
	}
    }

    /**
     * Drive the motors associated with the drive base.
     * 
     * @param leftMotorPower
     *            the power for the left motor.
     * @param rightMotorPower
     *            the power for the left motor.
     * @param percentPower
     *            the power scaling percentage for both motors.
     */
    private void driveMotors(double leftMotorPower, double rightMotorPower, double percentPower)
    {
	double leftMotorSpeed = leftMotorPower * percentPower;
	double rightMotorSpeed = rightMotorPower * percentPower;
	leftMotor.set(leftMotorSpeed);
	rightMotor.set(-rightMotorSpeed);
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
