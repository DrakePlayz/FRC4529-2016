package org.usfirst.frc.team4529.robot.sensors;

/**
 * The potentiometer wrapper. It makes more sense to return a percentage of
 * maximum making the max and min values potentiometer specific.
 * 
 * @author frogg
 *
 */
public class PotentiometerWrapper
{
    private double percentageUse;

    /**
     * @return the percentageUse
     */
    public double getPercentageUse()
    {
	return this.percentageUse;
    }

    /**
     * @param percentageUse
     *            the percentageUse to set
     */
    public void setPercentageUse(double percentageUse)
    {
	this.percentageUse = percentageUse;
    }
}
