/*
 * Harris Dizdarevic
 * CISC. 3150
 * Question 1: Write a program that asks the user how tall of a pyramid do they
 * want to display on the screen, and then displays the pyramid that counts up
 * on the left and counts down on the right.
 *
 * Creating a properly formatted pyramid, looking at the example given in the
 * problem the number of spaces per row goes as follows:
 *      for userInput = 4
 *      Row 0: 8 spaces
 *      Row 1: 6 spaces
 *      Row 2: 4 spaces
 *      Row 3: 2 spaces
 * After testing user inputs 5,6 the generalized formula for determining the
 * number of spaces per row to create a properly formatted pyramid is:
 *      denote:
 *          s = # of spaces
 *          row = Row #
 *          userNumber = userInput
 *      formula:
 *          s = 2(userNumber-row)
 */

import java.util.Scanner;

public class QuestionOne{
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        System.out.printf("Enter how tall of a pyramid you would like to see: ");
        int userNumber = userInput.nextInt();

        for(int row = 0; row < userNumber; row++){
            String printSpaces = "%" + (2*(userNumber-row)) + "s";
            System.out.printf(printSpaces, " ");

            for(int incNumber = 1; incNumber <= (row + 1); incNumber++)
                System.out.printf("%d ", incNumber);

            for(int decNumber = row; decNumber >= 1; decNumber--)
                System.out.printf("%d ", decNumber);

            System.out.printf("\n");
        }
    }
}
