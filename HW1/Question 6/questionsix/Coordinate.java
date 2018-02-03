/*
 * Harris Dizdarevic
 * CISC. 3150
 *
 * Auxillary Class for Question 6:
 *  The purpose of this class is to hold the 2D center coordinates for a circle.
 */

package questionsix;
import java.util.Scanner;

public class Coordinate{
    private double x;
    private double y;

    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getXCoordinate(){
        return this.x;
    }

    public double getYCoordinate(){
        return this.y;
    }
}

