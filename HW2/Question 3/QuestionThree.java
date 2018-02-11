/*
 * Harris Dizdarevic
 * CISC. 3150
 * Question 3: Write a program to check whether a string is a palindrome
 *             (a string that is the same forward and backwards, for eg,
 *             madamimadam)
 *
 * Personal thoughts:
 *      There are a few solutions that can be thought of when checking if a
 *      String is a palindrome:
 *          First solution is: Reverse the string and compare if the
 *                             inputString is equal to the reversed string.
 *
 *          Second solution is: to further ensure that the inputString is a
 *                              palindrome is by using hashCode() to compare
 *                              the two String objects if they are the same
 *                              (still have to reverse the string).
 *
 *          Third solution is: have two counters that point to the first and
 *                             last index of the string, increment and decrement
 *                             accordingly and check if each character is the same.
 *
 *      Auxillary method created: reverseString
 *          Method: Recursion
 *          The concept of reversing a String recursively is by
 *          stripping away the relative first character and reversing the rest
 *          of the substring
 */

import java.util.Scanner;

public class QuestionThree{
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        System.out.printf("Enter a String to check if it's a palindrome: ");
        String inputString = userInput.next();

        System.out.printf("The reversed String is: %s\n", reverseString(inputString));

        switch(isPalindrome(inputString)){
            case 0:
                System.out.printf("The inputString: %s is a Palindrome\n\n", inputString);
                break;
            default:
                System.out.printf("The inputString: %s is not a Palindrome\n\n", inputString);
                break;
        }
    }

    public static String reverseString(String inputString){
        if(inputString.length() <= 1)
            return inputString;
        return reverseString(inputString.substring(1, inputString.length())) + inputString.charAt(0);
    }

    public static int isPalindrome(String inputString){
        //Might be redundant/not-necessary for ignoring case?
        return inputString.compareToIgnoreCase(reverseString(inputString));
    }
}
