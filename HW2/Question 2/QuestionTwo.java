/*
 * Harris Dizdarevic
 * CISC. 3150
 * Question 2: Write a program that prints a calendar on the screen
 *
 * User Input:
 *  Year
 *  What day the 1st of January it fell on
 * Output:
 *  Displays every month from January to December
 *
 * Be wary of leap years:
 *  Leap year definition
 *      Reference: https://en.wikipedia.org/wiki/Leap_year
 *      If a year is divisible by 4 but not 100, or it is divisible by 400
 *          It is a leap year
 *      else
 *          Not a leap year
 *
 *  Month affected by leap year:
 *      February (29 days if leap year, otherwise 28 days)
 *
 * I created an Auxillary class called Calendar in the package 'questiontwo' to
 * handle all the logic and printing the calendar. More information on what
 * encapsulated is in Calendar.java
 */

import java.util.Scanner;
import questiontwo.Calendar;

public class QuestionTwo{
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        System.out.printf("Enter a year in which you would like to see the calendar of: ");
        int inputYear = userInput.nextInt();

        System.out.printf("Enter the day in which the first of January fell on: ");
        String inputDay = userInput.next();

        Calendar testCalendar = new Calendar(inputYear, inputDay);

        System.out.printf("Is the year %d a leap year? %b\n\n", inputYear, testCalendar.isLeapYear(inputYear));

        testCalendar.printCalendarForTheYear();

    }
}
