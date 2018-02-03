/*
 * Harris Dizdarevic
 * CISC. 3150
 * Question 4: Feed a file that contains numbers into your program using
 * command line redirection have your program read and print the file on the
 * screen.
 */
import java.util.Scanner;

public class QuestionFour{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNext())
            System.out.printf("%d\n", input.nextInt());
    }
}


