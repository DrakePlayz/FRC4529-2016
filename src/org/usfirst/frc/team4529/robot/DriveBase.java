package org.usfirst.frc.team4529.robot;

import org.usfirst.frc.team4529.framework.Position;

/**
 * Defines what each implementation of a drive base will be able to do.
 * Mechanum, omniwheel, 6 wheel, 4 wheel, etc.
 * 
 * @author frogg
 *
 */
public abstract class DriveBase
{
    public abstract void moveTo(Position position);

    public abstract void moveBy(Position position);
}
