/*
 * Harris Dizdarevic
 * CISC. 3150
 * Question 6: Write a program that prompts the user to enter the center
 *             coordinates and radius of two circles.
 *             There are four cases to consider:
 *              Two circles are separate
 *                  To determine this you sum the two radii, and check if
 *                  the distance between the two center coordinates are greater
 *                  than the sum of the radii.
 *              Two circles are touching
 *                  The two circles are touching if the distance between the
 *                  two center coordinates are equal to the sum of the radii
 *              Two circles are overlapping
 *                  Two circles are overlapping if the difference of the radii
 *                  is less than the distance between the two center
 *                  coordinates AND the distance between the two center
 *                  coordinates is less than the sum of the radii
 *              Two circles are within one another
 *                  Two circles are within one another if the distance between
 *                  the two center coordinates = 0
 */

import questionsix.Coordinate;
import java.util.Scanner;

public class QuestionSix{
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        double centerCoordinateXOne, centerCoordinateYOne;
        double centerCoordinateXTwo, centerCoordinateYTwo;
        System.out.printf("Enter center coordinates for circle one: ");
        centerCoordinateXOne = userInput.nextDouble();
        centerCoordinateYOne = userInput.nextDouble();

        System.out.printf("Enter center coordinates for circle two: ");
        centerCoordinateXTwo = userInput.nextDouble();
        centerCoordinateYTwo = userInput.nextDouble();

        Coordinate centerCircleOne = new Coordinate(centerCoordinateXOne, centerCoordinateYOne);
        Coordinate centerCircleTwo = new Coordinate(centerCoordinateXTwo, centerCoordinateYTwo);

        double radiusCircleOne;
        double radiusCircleTwo;

        System.out.printf("Enter the radius for circle one: ");
        radiusCircleOne = userInput.nextDouble();

        System.out.printf("Enter the radius for circle two: ");
        radiusCircleTwo = userInput.nextDouble();

        compareTwoCircles(centerCircleOne, radiusCircleOne, centerCircleTwo, radiusCircleTwo);
    }

    public static double distanceOfALine(Coordinate a, Coordinate b){
        return Math.sqrt(
                Math.pow(b.getXCoordinate()-a.getXCoordinate(), 2) +
                Math.pow(b.getYCoordinate()-a.getYCoordinate(), 2)
                );
    }

    public static void compareTwoCircles(Coordinate centerCircleOne, double radiusCircleOne, Coordinate centerCircleTwo, double radiusCircleTwo){
        double distanceBetweenCenter = distanceOfALine(centerCircleOne, centerCircleTwo);
        double sumOfRadii = radiusCircleOne + radiusCircleTwo;

        if(distanceBetweenCenter > sumOfRadii)
            System.out.println("\nThe two circles do not intersect.");
        else if (distanceBetweenCenter == sumOfRadii)
            System.out.println("\nThe two circles are touching eachother");
        else if (distanceBetweenCenter == 0)
            System.out.println("\nThe two circles are within eachother");
        else
            System.out.println("\nThe two circles are overlapping eachother");
    }
}
