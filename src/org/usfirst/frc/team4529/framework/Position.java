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
}
