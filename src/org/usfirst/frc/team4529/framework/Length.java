package org.usfirst.frc.team4529.framework;

/**
 * Length in mm.
 * 
 * @author frogg
 *
 */
public class Length
{
    public static final Length ZERO = new Length(0);
    private double value;

    /**
     * Constructor to make a length with value of mm.
     * 
     * @param value
     *            the number of mm in the length.
     */
    public Length(double value)
    {
	this.setValue(value);
    }

    /**
     * 
     * @return the value of the length in mm.
     */
    public double getValue()
    {
	return value;
    }

    /**
     * sets the value of the length to <b>value</b>.
     * 
     * @param value
     *            the value to set the length to.
     */
    public void setValue(double value)
    {
	this.value = value;
    }

    /**
     * Adds two length values.
     * 
     * @param length1
     *            the first length to add.
     * @param length2
     *            the second length to add.
     * @return the sum of the two lengths.
     */
    public static Length add(Length length1, Length length2)
    {
	return new Length(length1.getValue() + length2.getValue());
    }

    /**
     * Adds a length value to *this* length value.
     * 
     * @param toAdd
     *            the length to add to *this*
     * @return the sum of *this* length value and the <b>toAdd</b>.
     */
    public Length add(Length toAdd)
    {
	return Length.add(this, toAdd);
    }
}
