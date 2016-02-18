package org.usfirst.frc.team4529.robot.sensors;

/**
 * A wrapper for the ultrasonic sensor.
 * 
 * @author frogg
 *
 */
public class UltrasonicWrapper
{
    private double distance;

    /**
     * @return the distance
     */
    public double getDistance()
    {
	return this.distance;
    }

    /**
     * @param distance
     *            the distance to set
     */
    public void setDistance(double distance)
    {
	this.distance = distance;
    }
}
