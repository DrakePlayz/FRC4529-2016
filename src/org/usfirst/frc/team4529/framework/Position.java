package org.usfirst.frc.team4529.framework;

/**
 * A 2D coordinate to represent a position.
 * 
 * @author frogg
 *
 */
public class Position
{
    private Length x;
    private Length y;

    /**
     * A constructor that creates a new position out of two lengths.
     * 
     * @param x
     *            the x dimension of the position.
     * @param y
     *            the y dimension of the position.
     */
    public Position(Length x, Length y)
    {
	setX(x);
	setY(y);
    }

    /**
     * @return the x
     */
    public Length getX()
    {
	return x;
    }

    /**
     * @param x
     *            the x to set
     */
    public void setX(Length x)
    {
	this.x = x;
    }

    /**
     * @return the y
     */
    public Length getY()
    {
	return y;
    }

    /**
     * @param y
     *            the y to set
     */
    public void setY(Length y)
    {
	this.y = y;
    }

    /**
     * The sum of *this* position and another position.
     * 
     * @param position
     *            the position to add to *this* position.
     * @return the some of *this* position and <b>position</b>.
     */
    public Position add(Position position)
    {
	Length newX = Length.add(this.x, position.getX());
	Length newY = Length.add(this.y, position.getY());
	return new Position(newX, newY);
    }
}
