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
 *  Version 2
 *
 *  Equation of a circle = x^2 + y^2 = r^2
 *
 *  Came across a class called ThreadLocalRandom where it is a RNG tied to a
 *  local thread. It is also mentioned in the doc below however, the benefit of
 *  this is that there is less contention and overhead in generating a random
 *  number via the Math class.
 *
 *  First time around 4 minutes
 *  Second time around 35-36 seconds.
 *  Reference:
 *    https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ThreadLocalRandom.html
 */

import java.util.concurrent.ThreadLocalRandom;

public class QuestionOneVersion2{
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        double dotsThatFallInCircle = 0;
        long numOfDots = 4000000000L;
        for(long counter = 1; ++counter < numOfDots;) {
            double Sx = (ThreadLocalRandom.current().nextDouble());
            double Sy = (ThreadLocalRandom.current().nextDouble());
            //Are the points in the first quadrant?
            double SxSquared = Sx * Sx;
            double SySquared = Sy * Sy;
            if(SxSquared + SySquared <= 1) {
                ++dotsThatFallInCircle;
            }
           //System.out.println(dotsThatFallInCircle/counter);
        }
        System.out.println(4.00 * (dotsThatFallInCircle/numOfDots));

        System.out.println(System.currentTimeMillis()-before);
    }
}
