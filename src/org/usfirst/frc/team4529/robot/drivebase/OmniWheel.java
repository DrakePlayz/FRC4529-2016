package org.usfirst.frc.team4529.robot.drivebase;

import org.usfirst.frc.team4529.framework.Angle;
import org.usfirst.frc.team4529.framework.Position;
import org.usfirst.frc.team4529.robot.exceptions.DriveBaseAlreadyExistsException;
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
    private static Talon leftMotor = new Talon(2);
    private static Talon rightMotor = new Talon(3);
    private static Talon frontCenterMotor = new Talon(0);
    private static Talon rearCenterMotor = new Talon(1);

    /**
     * Constructor that follows a weird implementation of a singleton.
     * 
     * @throws DriveBaseAlreadyExistsException
     */
    public OmniWheel()
    {

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
	double z = joystick.getRawAxis(2); // joystick twist, anti-clockwise
					   // positive
	double percentPower = (-joystick.getRawAxis(3) + 1) / 2; // rawAxis(3)
								 // goes from 1
								 // at bottom to
								 // -1 at top
	double joystickAngle = joystick.getDirectionRadians();
	double mainStickMagnitude = joystick.getMagnitude() / Math.sqrt(2);
	double leftMotorPower = 0;
	double rightMotorPower = 0;
	double frontMotorPower = 0;
	double rearMotorPower = 0;

	if(Math.abs(z) > 0.15)
	{
	    leftMotorPower = Math.pow(z, 2);
	    rightMotorPower = Math.pow(z, 2);
	    frontMotorPower = Math.pow(z, 2);
	    rearMotorPower = Math.pow(z, 2);

	    if(z < 0)
	    {// clockwise is negative
		rightMotorPower = -rightMotorPower;
	    }
	    else
	    {
		leftMotorPower = -leftMotorPower;
		frontMotorPower = -frontMotorPower;
		rearMotorPower = -rearMotorPower;
	    }
	}

	leftMotorPower += Math.sin(joystickAngle) * mainStickMagnitude;
	rightMotorPower += Math.sin(joystickAngle) * mainStickMagnitude;
	frontMotorPower += Math.cos(joystickAngle) * mainStickMagnitude;
	rearMotorPower += -Math.cos(joystickAngle) * mainStickMagnitude;

	driveMotors(leftMotorPower, rightMotorPower, frontMotorPower, rearMotorPower, percentPower);
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
	rearCenterMotor.set(rearMotorSpeed);
    }

}
