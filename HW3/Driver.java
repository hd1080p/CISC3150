/*
 * Harris Dizdarevic
 * CISC. 3150
 * Driver class for HW3: MyString class
 */

import mystring.MyString;

public class Driver{
    public static void main(String[] args){
        char[] testChar = {
            't','e','s','t','i','n','g'
        };

        MyString test = new MyString(testChar);
        System.out.println("Length of MyString is: " + test.length());
        System.out.println("CharAt test: " + test.charAt(4));
        System.out.println("Printing string: " + test.toString());
    }
}
