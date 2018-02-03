/*
 * Harris Dizdarevic
 * CISC. 3150
 * Question 3: Write a program that randomly generates an integer between 1 &
 *             12 and displays the English name of that month.
 *
 * I will be using the Random class to generate a random number
 *
 * API information for the Random class has been found here:
 * https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
 *
 */

import java.util.Random;

public class QuestionThree{
    public static void main(String[] args){
        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        Random randomInteger = new Random();

        for(int i = 0; i < 12; i++){
            //The API states that the method nextInt(n) returns a random
            //integer within the domain [0,n). For the sake of the homework,
            //to be able to return an integer from 1-12 I would add one to the
            //result; since the maximum of nextInt(12) is 11, adding 1 would
            //increase the range to 1-12.
            int randomMonth = randomInteger.nextInt(12) + 1;
            System.out.printf("The number generated is: %d, and the month is: %s\n", randomMonth, months[randomMonth-1]);
        }
    }
}
