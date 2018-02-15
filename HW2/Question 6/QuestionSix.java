/*
 * Harris Dizdarevic
 * CISC. 3150
 * Question 6: In our class, we talked about how the Scanner class doesn't have a method
 * for tokenizing individual characters. But you're hell bent on forcing the
 * Scanner class to tokenize the individual characters. What should you set
 * your delimiter to?
 */

import java.util.Scanner;

public class QuestionSix{
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        userInput.useDelimiter("");
        System.out.println("Enter a sample word/phrase to test character delimiter");
        while(userInput.hasNext())
            System.out.println(userInput.next());
    }
}
