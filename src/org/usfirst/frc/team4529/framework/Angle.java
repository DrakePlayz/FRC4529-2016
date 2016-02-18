package org.usfirst.frc.team4529.framework;

/**
 * This class defines the basic angle measurement for a degree.
 * 
 * @author frogg
 *
 */
public class Angle
{
    public static final Angle ZERO = new Angle(0);
    public static final Angle NINTY = new Angle(90);
    public static final Angle SIXTY = new Angle(60);
    private double value;

    /**
     * The constructor for the angle class. Creates an degree angle with a
     * value.
     * 
     * @param value
     *            The initialized value of the angle in degrees.
     */
    public Angle(double value)
    {
	this.value = value;
    }

    /**
     * @return The value in degrees of the current angle.
     */
    public double getValue()
    {
	return this.value;
    }

    /**
     * @param value
     *            The value in degrees to set the angle to.
     */
    public void setValue(double value)
    {
	this.value = value;
    }

    /**
     * The addition for angles.
     * 
     * @param angle1
     *            The first value to add.
     * @param angle2
     *            The second value to add.
     * @return The sum of the two angles.
     */
    public static Angle add(Angle angle1, Angle angle2)
    {
	return new Angle(angle1.getValue() + angle2.getValue());
    }

    /**
     * Nonstatic add. Adds an angle to *this* angle.
     * 
     * @param angleToAdd
     *            the angle to add to *this* angle.
     * @return the sum of *this* angle and <i>angleToAdd</i>.
     */
    public Angle add(Angle angleToAdd)
    {
	return new Angle(this.getValue() + angleToAdd.getValue());
    }

    /**
     * This calculates the basic angle of an angle. (An angle between 0
     * and 90)
     * 
     * @return The basic angle.
     */
    public Angle getBasicAngle()
    {
	double basicAngle = this.value % 180;

	if(basicAngle == 0)
	{
	    return Angle.ZERO;
	}
	else if(basicAngle >= 90)
	{
	    basicAngle = 180 - basicAngle;
	    return new Angle(basicAngle);
	}
	else // basicAngle <= -90
	{
	    basicAngle = 180 + basicAngle;
	    return new Angle(basicAngle).negative();
	}

    }

    /**
     * Checks whether this angle is greater than the angle to compare.
     * 
     * @param angleToCompare
     *            the angle to compare.
     * @return <i>True</i> if this angle is larger than the angle to compare.
     */
    public boolean greaterThan(Angle angleToCompare)
    {
	return this.getValue() > angleToCompare.getValue() ? true : false;
    }

    /**
     * Checks whether this angle is smaller than the angle to compare.
     * 
     * @param angleToCompare
     *            the angle to compare.
     * @return <i>True</i> if this angle is smaller than the angle to compare.
     */
    public boolean lessThan(Angle angleToCompare)
    {
	return this.getValue() < angleToCompare.getValue() ? true : false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object angleToCompare)
    {
	if(angleToCompare.getClass() == this.getClass())
	{
	    return this.getValue() == ((Angle) angleToCompare).getValue() ? true : false;
	}

	throw new ClassCastException(angleToCompare.getClass() + " is not an Angle.");
    }

    /**
     * The subtraction for the Angle class.
     * 
     * @param angle1
     *            The angle to take <b>angle2</b> away from.
     * @param angle2
     *            The angle to subtract from <b>angle1</b>.
     * @return The difference between <b>angle1</b> and <b>angle2</b>.
     */
    public static Angle subtract(Angle angle1, Angle angle2)
    {
	return new Angle(angle1.getValue() - angle2.getValue());
    }

    /**
     * The negative of the angle.
     * 
     * @return The negative angle.
     */
    public Angle negative()
    {
	return new Angle(-getValue());
    }

    /**
     * Gets the true angle (angle relative to North).
     * 
     * @return the true angle.
     */
    public Angle getTrueAngle()
    {
	double trueAngle = (this.value - 90) % 360;

	if(trueAngle == 0)
	{
	    return Angle.ZERO;
	}
	else if(trueAngle < 0)
	{
	    return new Angle(360 + trueAngle);
	}
	else // trueAngle > 0
	{
	    return new Angle(360 - trueAngle);
	}
    }
}
