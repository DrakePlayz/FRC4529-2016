package org.usfirst.frc.team4529.robot.sensors;

/**
 * A three accelerometer wrapper.
 * 
 * @author frogg
 *
 */
public class AccelerometerWrapper
{
    private double accelX;
    private double accelY;
    private double accelZ;

    /**
     * @return the accelX
     */
    public double getAccelX()
    {
	return this.accelX;
    }

    /**
     * @param accelX
     *            the accelX to set
     */
    public void setAccelX(double accelX)
    {
	this.accelX = accelX;
    }

    /**
     * @return the accelY
     */
    public double getAccelY()
    {
	return this.accelY;
    }

    /**
     * @param accelY
     *            the accelY to set
     */
    public void setAccelY(double accelY)
    {
	this.accelY = accelY;
    }

    /**
     * @return the accelZ
     */
    public double getAccelZ()
    {
	return this.accelZ;
    }

    /**
     * @param accelZ
     *            the accelZ to set
     */
    public void setAccelZ(double accelZ)
    {
	this.accelZ = accelZ;
    }

}
