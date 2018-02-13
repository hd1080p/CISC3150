/*
 * Harris Dizdarevic
 * CISC. 3150
 * Question 5: Change Scanner's delimiter, and tokenize comma separated values
 * entered by the keyboard.
 *
 * Scanner API for reference:
 *      https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
 *
 * CSV's delimiter is a comma (hence comma separated value)
 */

import java.util.Scanner;

public class QuestionFive{
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        userInput.useDelimiter(",");

        System.out.println("Enter an example to test CSV delimiter");
        while(userInput.hasNext()){
            System.out.println(userInput.next());
        }

    }
}
