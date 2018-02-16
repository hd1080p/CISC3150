/*
 * Harris Dizdarevic
 * CISC. 3150
 * HW3: Create your own version of the String class. Call it MyString. This class
 * should be immutable. Make sure to encapsulate your data properly. Provide
 * an implementation for the following methods:
 *
 *   public MyString(char[] chars);
 *   public char charAt(int index);
 *   public int length();
 *   public MyString substring(int begin, int end);
 *   public MyString toLowerCase();
 *   public MyString toUpperCase();
 *   public boolean equals(MyString s);
 *   public MyString getMyString();
 *   public String toString();
 *   public static MyString valueOf(int i);
 *
 *
 * Do not use any function from the String class. The only time you're
 * allowed to use the String class is in the toString() method. Even then,
 * you may only use the String's constructor, but not the methods.
 *
 * Make sure to provide a driver class, too, and show the output.
 */

package mystring;

public class MyString{
    private char[] arr;
    private int length;

    public MyString(char[] chars){
        this.arr = chars;
        this.length = chars.length;
    }

    public char charAt(int index){
        if(index < 0 || index > this.length)
            throw new ArrayIndexOutOfBoundsException();
        return this.arr[index];
    }

    public int length(){
        return this.arr.length;
    }

/*    public MyString substring(int begin, int end){

    }

    public MyString toLowerCase(){

    }

    public MyString toUpperCase(){

    }

    public boolean equals(MyString string){

    }

    public String toString(){

    }

    public static String valueOf(int i){

    }
*/
}

