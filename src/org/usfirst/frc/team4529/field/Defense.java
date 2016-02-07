package org.usfirst.frc.team4529.field;

import org.usfirst.frc.team4529.field.exceptions.NoOtherDefenseInCategoryException;

/**
 * The list of possible defenses with human readable names as well as category.
 * 
 * @author frogg
 *
 */
public enum Defense
{
    MOAT("Moat", "B"), PORTCULLIS("Portcullis", "A"), CHEVALDEFRISE("Cheval de Frise", "A"),
    SALLYPORT("Sally Port", "C"), DRAWBRIDGE("Drawbridge", "C"), RAMPARTS("Ramparts", "B"), ROCKWALL("Rock Wall", "D"),
    ROUGHTERRAIN("Rough Terrain", "D"), LOWBAR("Low Bar", "0");

    private String name;
    private String category;

    /**
     * Constructor for the Defense object that sets a human readable name.
     * 
     * @param name
     *            the human readable name of the defense.
     */
    private Defense(String name, String category)
    {
	this.name = name;
	this.category = category;
    }

    /**
     * @return the name.
     */
    public String getName()
    {
	return name;
    }

    /**
     * @return the category.
     */
    public String getCategory()
    {
	return this.category;
    }

    /**
     * Gets the other defense from the same category as this one.
     * 
     * @param defense
     *            the defense to get the category of.
     * @return the defense that is in the same category as this defense.
     * @throws NoOtherDefenseInCategoryException
     *             if the lowbar is the defense.
     */
    public static Defense getOtherFromCategory(Defense defense) throws NoOtherDefenseInCategoryException
    {
	if(defense == Defense.LOWBAR)
	{
	    throw new NoOtherDefenseInCategoryException();
	}

	for(Defense def : Defense.values())
	{
	    if(def != defense && def.getCategory() == defense.getCategory())
	    {
		return def;
	    }
	}

	// unreachable due to the arrangement of the code but Java requires it.
	throw new NoOtherDefenseInCategoryException();
    }

    /**
     * Gets the other defense from the same category as this one.
     * 
     * @return the other defense from the same category.
     * @throws NoOtherDefenseInCategoryException
     *             if the lowbar is the defense.
     */
    public Defense getOtherFromCategory() throws NoOtherDefenseInCategoryException
    {
	if(this == Defense.LOWBAR)
	{
	    throw new NoOtherDefenseInCategoryException();
	}

	for(Defense defense : Defense.values())
	{
	    if(defense != this && defense.getCategory() == this.getCategory())
	    {
		return defense;
	    }
	}

	// unreachable due to the arrangement of code but Java requires it.
	throw new NoOtherDefenseInCategoryException();
    }

    /**
     * Override the toString method and return the human readable name.
     * 
     * @return the human readable name.
     */
    public String toString()
    {
	return this.getName();
    }
}
