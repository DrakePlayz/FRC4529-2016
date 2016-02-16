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
    public void drive(double x, double y, double z, double slider, boolean squaredInputs){
		
		double desiredAngle = Math.atan(y/x);
		double leftMotorPower = 0;
		double rightMotorPower = 0;
	
		// sign is -1 if joystick is back 1 if joystick is forward
	
		// if joystick is right &&
		// if joystick is left????
		if (y>0) {
			leftMotorPower = y + 1;
			rightMotorPower = y + Math.cos(2 * desiredAngle + Math.PI);
		} else {
			leftMotorPower = y - Math.cos(2 * desiredAngle + Math.PI);
			rightMotorPower = y - 1;
		}
	
		double mainStickMagnitude = joystick.getMagnitude() / Math.sqrt(2);
		slider = ((-slider + 1) / 2);
	
		// SmartDashboard.putNumber("Left Motor Power MAX", leftMotorPower);
		// SmartDashboard.putNumber("Right Motor Power MAX", rightMotorPower);
	
		leftMotorPower = leftMotorPower*slider*mainStickMagnitude/2;
		rightMotorPower = rightMotorPower*slider*mainStickMagnitude/2;
		
		if(squaredInputs) {
			leftMotorPower = leftMotorPower * leftMotorPower;
			rightMotorPower = rightMotorPower * rightMotorPower;
		}
	
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
     * Devon please java doc this correctly
     */
	public void drive(Joystick mainStick){
		double x = mainStick.getRawAxis(0);
		double y = mainStick.getRawAxis(1);
		double z = mainStick.getRawAxis(2);
		double slider = mainStick.getRawAxis(3);
		
		drive(x,y,z,slider,false);
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
