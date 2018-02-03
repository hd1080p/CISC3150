/* 
 * Harris Dizdarevic
 * CISC. 3150
 * Question 2: Read radiuses from a user and calculate area of a circle,
 *             PI*r^2. Keep reading until EOF.
 */

import java.util.Scanner;

public class QuestionTwo{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double radius;

        while(input.hasNextDouble()){
            radius = input.nextDouble();
            System.out.printf("Area of this circle with radius %.3f has area %.3f\n", radius, areaOfCircle(radius));
        }
    }

    public static double areaOfCircle(double radius){
        return Math.pow(Math.PI*radius, 2);
    }
}
