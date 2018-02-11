/*
 * Harris Dizdarevic
 * CISC. 3150
 * Question 1: Write a program that asks the user how tall of a pyramid do they
 * want to display on the screen, and then displays the pyramid that counts up
 * on the left and counts down on the right.
 *
 * Creating a properly formatted pyramid, looking at the example given in the
 * problem the number of spaces per row goes as follows:
 *      Row 0: 8 spaces
 *      Row 1: 6 spaces
 *      Row 2: 4 spaces
 *      Row 3: 2 spaces
 * After testing user inputs 5,6 the generalized formula for determining the
 * number of spaces per row to create a properly formatted pyramid is:
 *      denote:
 *          s = # of spaces
 *          r = Row #
 *          n = userInput
 *      formula:
 *          s = 2(n-r)
 */

import java.util.Scanner;

public class QuestionOne{
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        System.out.printf("Enter how tall of a pyramid you would like to see: ");
        int userNumber = userInput.nextInt();

        for(int row = 0; row < userNumber; row++){
            String format = "%" + (2*(userNumber-row)) + "s" + " %d\n";
            for(int listOfNumbers = row; listOfNumbers < (row + 1); listOfNumbers++){
                System.out.printf(format, " ", (listOfNumbers + 1));
            }
        }


    }
}
