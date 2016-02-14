package org.usfirst.frc.team4529.framework;

public class CubicPathGenerator
{
    private Position startingPosition;
    private Angle startingAngle;
    private Position endingPosition;
    private Angle endingAngle;

    // y = Ax^3 + Bx^2 + Cx + D
    private double A, B, C, D;

    public CubicPathGenerator(Position startingPosition, Angle startingAngle, Position endingPosition,
	    Angle endingAngle)
    {
	this.startingPosition = startingPosition;
	this.startingAngle = startingAngle;
	this.endingPosition = endingPosition;
	this.endingAngle = endingAngle;
    }

    private void generateCubic()
    {
	double startingX = startingPosition.getX().getValue();
	double startingY = startingPosition.getY().getValue();
	double startingGradient = startingAngle.getValue();
	double endingX = endingPosition.getX().getValue();
	double endingY = endingPosition.getY().getValue();
	double endingGradient = endingAngle.getValue();

	double[][] matrix = { { Math.pow(startingX, 3), Math.pow(startingX, 2), startingX, 1 },
		{ Math.pow(startingX, 2) * 3, startingX * 2, 1, 0 },
		{ Math.pow(endingX, 3), Math.pow(endingX, 2), endingX, 1 },
		{ Math.pow(endingX, 2) * 3, endingX * 2, 1, 0 } };

	double det = matrix[0][0] * matrix[1][1] * matrix[2][2] * matrix[3][3]
		+ matrix[0][1] * matrix[1][2] * matrix[2][3] * matrix[3][0]
		+ matrix[0][2] * matrix[1][3] * matrix[2][0] * matrix[3][1]
		+ matrix[0][3] * matrix[1][0] * matrix[2][1] * matrix[3][2]
		- matrix[0][3] * matrix[1][2] * matrix[2][1] * matrix[3][0]
		- matrix[0][2] * matrix[1][1] * matrix[2][0] * matrix[3][3]
		- matrix[0][1] * matrix[1][0] * matrix[2][3] * matrix[3][2]
		- matrix[0][0] * matrix[1][3] * matrix[2][2] * matrix[3][1];
    }
}
