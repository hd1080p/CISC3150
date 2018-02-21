/*
 * Harris Dizdarevic
 * CISC. 3150
 * Driver class for HW3: MyString class
 */

import mystring.MyString;


public class Driver{
    public static void main(String[] args){
        char[] testChar = {
            'T','e','S','t','I','n','G'
        };

        char[] testCharTwo = {
            'a','b','c','d','e','f','g'
        };

        MyString test = new MyString(testChar);
        MyString testTwo = new MyString(testCharTwo);
        MyString testThree = new MyString(testChar);

        System.out.println("Length of MyString is: " + test.length());
        System.out.println("CharAt test: " + test.charAt(4));

        System.out.println("Printing String");
        for(int i = 0; i < test.length(); i++)
            System.out.printf("%c", test.charAt(i));

        System.out.printf("\n");

        System.out.println("Printing Substring");
        for(int i = 0; i < test.substring(0,3).length(); i++)
            System.out.printf("%c", test.substring(0,3).charAt(i));
        System.out.printf("\n");

        System.out.println("Testing toString() method");
        System.out.println(test.toString());

        System.out.println("Testing toLowerCase() method");
        System.out.println(test.toLowerCase());

        System.out.println("Testing toUpperCase() method");
        System.out.println(testTwo.toUpperCase());

        System.out.println("Testing compareTo()");
        System.out.println(test.compareTo(testTwo));
        System.out.println(test.compareTo(testThree));

        System.out.println("Testing valueOf()");
        System.out.println(MyString.valueOf(5));
        System.out.println(MyString.valueOf(39999));
    }
}
