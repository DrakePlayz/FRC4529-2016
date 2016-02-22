package org.usfirst.frc.team4529.robot.framework;

/**
 * An enumeration of all the analog inputs connected to the roboRio.
 * 
 * @author frogg
 *
 */
public enum RoboRioAnalogPorts
{
    ARM_POTENTIOMETER(0), BASE_ULTRASONIC(1);

    private final int port;

    RoboRioAnalogPorts(int port)
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
