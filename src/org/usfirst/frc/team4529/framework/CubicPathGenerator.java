package org.usfirst.frc.team4529.framework;

import Jama.Matrix;

public class CubicPathGenerator
{
    private Position startingPosition;
    private Angle startingAngle;
    private Position endingPosition;
    private Angle endingAngle;

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

	double[][] coefficientMatrix = { { Math.pow(startingX, 3), Math.pow(startingX, 2), startingX, 1 },
		{ Math.pow(startingX, 2) * 3, startingX * 2, 1, 0 },
		{ Math.pow(endingX, 3), Math.pow(endingX, 2), endingX, 1 },
		{ Math.pow(endingX, 2) * 3, endingX * 2, 1, 0 } };

	double[][] answerMatrix = { { startingY }, { startingGradient }, { endingY }, { endingGradient } };

	Matrix matrixA = new Matrix(coefficientMatrix);
	Matrix matrixB = new Matrix(answerMatrix);
	Matrix matrixX = matrixA.inverse().times(matrixB);

	System.out.println("y = " + matrixX.get(0, 0) + "x^3 + " + matrixX.get(1, 0) + "x^2 + " + matrixX.get(2, 0)
		+ "x + " + matrixX.get(3, 0));
    }

    // the double derivative of that solution can never be greater than our
    // comfortable turning radius.
    // the path can never go outside the bounds of the space we have (into
    // restricted areas like the defenses).
    // if no path is possible, get to the end point and go past, reverse to an
    // angle close to then pull in to final point.
}
