package org.usfirst.frc.team4529.robot.framework;

/**
 * An enumeration of all the motor PWM cables connected to ports of the roboRio.
 * 
 * @author frogg
 *
 */
public enum RoboRioPWMPorts
{
    LEFT_MOTOR(0), RIGHT_MOTOR(1), ARM_MOTOR(2), SHOOTING_WHEEL_MOTOR(3);

    private final int port;

    RoboRioPWMPorts(int port)
    {
	this.port = port;
    }

    /**
     * @return the port
     */
    public int getPort()
    {
	return port;
    }
}
