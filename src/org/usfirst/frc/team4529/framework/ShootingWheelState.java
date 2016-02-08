package org.usfirst.frc.team4529.framework;

/**
 * Defines what state the shooting wheels can be in.
 * 
 * @author frogg
 *
 */
public enum ShootingWheelState
{
    COLLECTING(-1), STOPPED(0), SHOOTING(1);

    private int state;

    /**
     * The constructor for the enum, sets the integer value associated with the
     * state of the shooting wheels.
     * 
     * @param state
     */
    private ShootingWheelState(int state)
    {
	this.state = state;
    }

    /**
     * 
     * @return the state of the shooting wheels.
     */
    public int getState()
    {
	return this.state;
    }
}
