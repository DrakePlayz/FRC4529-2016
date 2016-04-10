package org.usfirst.frc.team4529.robot.drivebase;

import org.usfirst.frc.team4529.framework.Angle;
import org.usfirst.frc.team4529.framework.Position;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

/**
 * An implementation of a 6 wheeled drive base. Right and left sides are 2
 * wheels from the same controller. Front and rear wheels are running left/right
 * for lateral motion.
 * 
 * @author frogg
 *
 */
public class OmniWheel extends DriveBase
{
    private Talon leftMotor;
    private Talon rightMotor;
    private Talon frontCenterMotor;
    private Talon rearCenterMotor;

    public OmniWheel()
    {
	leftMotor = new Talon(2);
	rightMotor = new Talon(3);
	frontCenterMotor = new Talon(0);
	rearCenterMotor = new Talon(1);
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

	double leftMotorPower = y;
	double rightMotorPower = y;
	double frontMotorPower = x;
	double rearMotorPower = x;

	if(z > 0)
	{
	    leftMotorPower += Math.pow(z, 2);
	    rightMotorPower -= Math.pow(z, 2);
	    frontMotorPower += Math.pow(z, 2);
	    rearMotorPower -= Math.pow(z, 2);
	}
	else
	{
	    leftMotorPower -= Math.pow(z, 2);
	    rightMotorPower += Math.pow(z, 2);
	    frontMotorPower -= Math.pow(z, 2);
	    rearMotorPower += Math.pow(z, 2);
	}

	if(mainStickMagnitude > 0.05 || Math.abs(z) > 0.05)
	{
	    driveMotors(leftMotorPower, rightMotorPower, frontMotorPower, rearMotorPower, percentPower);
	}
	else
	{
	    driveMotors(0, 0, 0, 0, 0);
	}
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
	// TODO Auto-generated method stub

    }

    /**
     * Drive the motors associated with the drive base.
     * 
     * @param leftMotorPower
     *            the power for the left motor.
     * @param rightMotorPower
     *            the power for the left motor.
     * @param frontMotorPower
     *            the power for the front motor (lateral motion).
     * @param rearMotorPower
     *            the power for the rear motor (lateral motion).
     * @param percentPower
     *            the power scaling percentage for both motors.
     */
    private void driveMotors(double leftMotorPower, double rightMotorPower, double frontMotorPower,
	    double rearMotorPower, double percentPower)
    {
	double leftMotorSpeed = leftMotorPower * percentPower;
	double rightMotorSpeed = rightMotorPower * percentPower;
	double frontMotorSpeed = frontMotorPower * percentPower;
	double rearMotorSpeed = rearMotorPower * percentPower;
	leftMotor.set(leftMotorSpeed);
	rightMotor.set(-rightMotorSpeed);
	frontCenterMotor.set(frontMotorSpeed);
	rearCenterMotor.set(-rearMotorSpeed);
    }

}
