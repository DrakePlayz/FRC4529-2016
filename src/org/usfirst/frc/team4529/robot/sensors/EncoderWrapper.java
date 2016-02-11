package org.usfirst.frc.team4529.robot.sensors;

import edu.wpi.first.wpilibj.Encoder;

/**
 * Wraps the encoder class to deal with initialization.
 * 
 * @author frogg
 *
 */
public class EncoderWrapper
{
    private Encoder encoder;

    /**
     * The encoder wrapper constructor. Handles all encoder initialization.
     * 
     * @param aChannel
     *            The a channel digital input channel.
     * @param bChannel
     *            The b channel digital input channel.
     */
    public EncoderWrapper(int aChannel, int bChannel)
    {
	this.encoder = new Encoder(aChannel, bChannel, false, Encoder.EncodingType.k4X);
	this.encoder.setMaxPeriod(0.1);
	this.encoder.setMinRate(10);
	this.encoder.setDistancePerPulse(5);
	this.encoder.setReverseDirection(true);
	this.encoder.setSamplesToAverage(7);
	this.encoder.reset();
    }

    /**
     * 
     * @return the scaled count of the encoder.
     */
    public int getCount()
    {
	return this.encoder.get();
    }

    /**
     * 
     * @return the raw count of the encoder.
     */
    public double getRawDistance()
    {
	return this.encoder.getRaw();
    }

    /**
     * 
     * @return the distance from distancePerPulse*scaledCount.
     */
    public double getDistance()
    {
	return this.encoder.getDistance();
    }

    /**
     * 
     * @return the distance per second scaled and with distance set.
     */
    public double getRate()
    {
	return this.encoder.getRate();
    }

    /**
     * 
     * @return the direction the wheel is spinning.
     */
    public boolean getDirection()
    {
	return this.encoder.getDirection();
    }
}
