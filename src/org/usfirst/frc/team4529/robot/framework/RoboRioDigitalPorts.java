package org.usfirst.frc.team4529.robot.framework;

/**
 * An enumeration of all the digital IO connected to the roboRio.
 * 
 * @author frogg
 *
 */
public enum RoboRioDigitalPorts
{
    ARM_DOWN_SWITCH(0), ARM_UP_SWITCH(1), ARM_IN_SWITCH(2), ARM_OUT_SWITCH(3), BALL_COLLECTED_SWITCH(4);

    private final int port;

    private RoboRioDigitalPorts(int port)
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
