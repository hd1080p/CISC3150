/*
 * Harris Dizdarevic
 * CISC. 3150
 * Homework 5
 * Question 1
 *  The area of a circle is pi*r^2, given that we are only dealing with the top
 *  right quadrant it would be (pi*r^2)/4. What is the ratio of the top right
 *  quadrant of the circle to the area of the square?
 *
 *  Answer:
 *      A_square = r^2
 *      A_circle_1st_quadrant = (pi*r^2)/4
 *
 *      ((pi*r^2)/4)/r^2 => (pi*r^2)/4r^2 => pi/4
 *
 *      Ratio of the two areas is pi/4
 *
 * Part 2:
 *  Generate 4 billion dots that fall within the square, figure out how many
 *  fall inside the circle, and how many fall outside of it (if it falls on the
 *  perimeter then it is considered inside).
 *
 *  To get roughly the same ratio as in Part 1; divide the number of dots that
 *  falls within the circle by the total number of dots generated
 *
 *  pi/4 ~= #_dots_in_circle/total_#_of_dots
 *
 *  to get the value of pi after you calculate the above ratio you just
 *  multiply it by 4.
 *      pi ~= 4(#_dots_in_circle/total_#_of_dots)
 *  Version 1
 */

import java.util.Random;

public class QuestionOne{
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        double radius = 3;
        double min = 0;
        double max = radius;
        double dotsThatFallInCircle = 0;
        for(long counter = 1; counter < 4000000000L; counter++) {
            double Sx = Math.random() * max;
            double Sy = Math.random() * max;
            //System.out.println("X " + Sx + " Y " + Sy );
            //Are the points in the first quadrant?
            if(((Sx*Sx) + (Sy*Sy)) <= (radius*radius)) {
                dotsThatFallInCircle += 1;
            }
           System.out.println(dotsThatFallInCircle/counter);
       }

        System.out.println(System.currentTimeMillis()-before);
    }
}
