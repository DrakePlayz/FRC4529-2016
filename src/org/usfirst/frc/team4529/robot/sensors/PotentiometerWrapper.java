package org.usfirst.frc.team4529.robot.sensors;

public class PotentiometerWrapper
{
    private double turns;
    private static double MAX_VALUE = 1;
    private static double MIN_VALUE = 0;

    /**
     * @return the turns
     */
    public double getTurns()
    {
	return this.turns;
    }

    /**
     * @param turns
     *            the turns to set
     */
    public void setTurns(double turns)
    {
	this.turns = turns;
    }
}
