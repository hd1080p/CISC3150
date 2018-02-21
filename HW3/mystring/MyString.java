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
 *   public int compareTo(MyString s);
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
 *
 * For toLowerCase() and toUpperCase() methods, since the strings we are
 * assuming are ASCII and this would only apply to characters that are actual
 * letters, since numbers have no upper/lower case. By looking at the ASCII
 * ranges of the characters I can tell whether to convert the character into a
 * lower or upper case. This is done so by casting the character to an integer
 * to get the ASCII value and modifying the character by Adding/Subtracting 32
 * (for lower/uppercase characters) then casting it back as a character to get
 * the new character value.
 *
 * The link to the table of the ASCII characters that I use for reference can
 * be found here: http://www.asciitable.com/
 * 
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
        MyString copy = this;
        return copy.arr[index];
    }

    public int length(){
        MyString copy = this;
        return copy.arr.length;
    }

    public MyString substring(int begin, int end){
        MyString copy = this;
        char[] newString = new char[(end-begin)];
        int j = 0;
        for(int i = begin; i < end; i++){
            newString[j] = copy.charAt(i);
            j++;
        }

        return new MyString(newString);
    }

    public MyString toLowerCase(){
        MyString copy = this;
        char[] lowerCase = new char[copy.length()];
        for(int i = 0; i < copy.length(); i++){
            //Redundant way to create a lowercased string
            lowerCase[i] = copy.charAt(i);
            if((int)copy.charAt(i) > 64 && (int)copy.charAt(i) < 91)
                lowerCase[i] = (char)((int)copy.charAt(i) + 32);
        }
        copy = new MyString(lowerCase);
        return copy;
    }

    public MyString toUpperCase(){
        MyString copy = this;
        char[] upperCase = new char[copy.length()];
        for(int i = 0; i < copy.length(); i++){
            upperCase[i] = copy.charAt(i);
            if((int)copy.charAt(i) > 96 && (int)copy.charAt(i) < 123)
                upperCase[i] = (char)((int)copy.charAt(i) - 32);
        }
        copy = new MyString(upperCase);
        return copy;
    }

    public String toString(){
        MyString copy = this;
        char[] newString = new char[copy.length()];
        int j = 0;
        for(int i = 0; i < copy.length(); i++){
            newString[j] = copy.charAt(i);
            j++;
        }
        return new String(newString);
    }

    private int totalMyStringValue(MyString string){
        //Sums up the total ASCII value of the string to be used as an
        //auxillary for compareTo()
        int sum = 0;
        for(int i = 0; i < string.length(); i++)
            sum += (int)string.charAt(i);
        return sum;
    }

    public int compareTo(MyString string){
        MyString copy = this;
        if(this.totalMyStringValue(copy) < this.totalMyStringValue(string))
            return -1;
        else if(this.totalMyStringValue(copy) > this.totalMyStringValue(string))
            return 1;
        return 0;
    }


    /*        MyString copy = this;
    public static String valueOf(int i){

    }
*/
}
