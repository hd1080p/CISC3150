/*
 * Harris Dizdarevic
 * CISC. 3150
 * Question 5: Write a program that reads three 2D points A, B, C
 *             Calculate the length of each side of the triangle
 *             using the distance formula sqrt((x_2-x_1)^2 + (y_2-y_1)^2)
 *             Then determine if a given triangle is a real triangle;
 *             sum of any two sides is greater than the third.
 *
 * Note: I created an auxillary class called Coordinate to store 2D points
 *       (x,y). It's located in the package 'questionfive'
 *
 */

import questionfive.Coordinate;
import java.util.Scanner;
 public class QuestionFive{

     public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        System.out.printf("Enter coordinates for the first triangle: ");

        Coordinate triangleOneA = new Coordinate(userInput.nextDouble(), userInput.nextDouble());
        Coordinate triangleOneB = new Coordinate(userInput.nextDouble(), userInput.nextDouble());
        Coordinate triangleOneC = new Coordinate(userInput.nextDouble(), userInput.nextDouble());

        System.out.printf("Enter coordinates for the second triangle: ");
        Coordinate triangleTwoA = new Coordinate(userInput.nextDouble(), userInput.nextDouble());
        Coordinate triangleTwoB = new Coordinate(userInput.nextDouble(), userInput.nextDouble());
        Coordinate triangleTwoC = new Coordinate(userInput.nextDouble(), userInput.nextDouble());

        System.out.printf("Enter coordinates for the third triangle: ");
        Coordinate triangleThreeA = new Coordinate(userInput.nextDouble(), userInput.nextDouble());
        Coordinate triangleThreeB = new Coordinate(userInput.nextDouble(), userInput.nextDouble());
        Coordinate triangleThreeC = new Coordinate(userInput.nextDouble(), userInput.nextDouble());

        double lengthOfTriangleOneA = distanceOfALine(triangleOneA, triangleOneB);
        double lengthOfTriangleOneB = distanceOfALine(triangleOneB, triangleOneC);
        double lengthOfTriangleOneC = distanceOfALine(triangleOneA, triangleOneC);

        double lengthOfTriangleTwoA = distanceOfALine(triangleTwoA, triangleTwoB);
        double lengthOfTriangleTwoB = distanceOfALine(triangleTwoB, triangleTwoC);
        double lengthOfTriangleTwoC = distanceOfALine(triangleTwoA, triangleTwoC);

        double lengthOfTriangleThreeA = distanceOfALine(triangleThreeA, triangleThreeB);
        double lengthOfTriangleThreeB = distanceOfALine(triangleThreeB, triangleThreeC);
        double lengthOfTriangleThreeC = distanceOfALine(triangleThreeA, triangleThreeC);

        System.out.printf("Triangle One is a real triangle: %b\n", isRealTriangle(lengthOfTriangleOneA, lengthOfTriangleOneB, lengthOfTriangleOneC));
        System.out.printf("Triangle Two is a real triangle: %b\n", isRealTriangle(lengthOfTriangleTwoA, lengthOfTriangleTwoB, lengthOfTriangleTwoC));
        System.out.printf("Triangle Three is a real triangle: %b\n", isRealTriangle(lengthOfTriangleThreeA, lengthOfTriangleThreeB, lengthOfTriangleThreeC));
     }

     public static double distanceOfALine(Coordinate a, Coordinate b){
         return Math.sqrt(
                 (Math.pow(b.getXCoordinate()-a.getXCoordinate(), 2))
                 + (Math.pow((b.getYCoordinate()-a.getYCoordinate()),2)));
     }

     public static boolean isRealTriangle(double lengthA, double lengthB, double lengthC){
         return (lengthA + lengthB > lengthC) &&
                (lengthB + lengthC > lengthA) &&
                (lengthA + lengthC > lengthB);
     }
 }
