/*
 * Harris Dizdarevic
 * CISC. 3150
 * Question 2: Auxillary Calendar class to handle all input, output of building
 * a calendar
 * Using a map data structure to store key (month name) value (number of days
 * in a month) pairs as efficiently as possible.
 *
 * Further elaborating:
 *  Using a LinkedHashMap allows the functionality of mapping the number of
 *  total days each months has as well as in the constructor determining if the
 *  number of days in February would be 28 or 29. The underlying data-structure
 *  that the LinkedHashMap uses is a Linked List meaning that the insertion
 *  order is the order in which it is stored in, rather than randomly being
 *  bucketed in a regular HashMap.
 *
 *  More information regarding API can be found for reference here:
 *      https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
 *  Other API References:
 *      String class:
 *          https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#substring-int-int-
 */

package questiontwo;
import java.util.LinkedHashMap;
import java.util.Map;


public class Calendar{
    private Map<String, Integer> monthsAndDays = new LinkedHashMap<String,Integer>();
    private int year;
    private String startingDay;

    public Calendar(int year, String startingDay){
        this.year = year;
        this.startingDay = startingDay;
        //Naive inputs
        //TODO Later: streamline this information instead of having so many
        //statements filling the HashMap, but this will do for now.
        monthsAndDays.put("January",      31);
        if(this.isLeapYear(this.year))
            monthsAndDays.put("February", 29);
        else
            monthsAndDays.put("February", 28);
        monthsAndDays.put("March",        31);
        monthsAndDays.put("April",        30);
        monthsAndDays.put("May",          31);
        monthsAndDays.put("June",         30);
        monthsAndDays.put("July",         31);
        monthsAndDays.put("August",       31);
        monthsAndDays.put("September",    30);
        monthsAndDays.put("October",      31);
        monthsAndDays.put("November",     30);
        monthsAndDays.put("December",     31);
    }

    public boolean isLeapYear(int year){
        //Definition of what a leap year is: refer to QuestionTwo.java for
        //reference as to where I got the information.
        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }

    public void printCalendarForTheYear(){
        String daysOfWeek = "Su Mo Tu We Th Fr Sa";
        //Mark the position for where to start in January and store locations
        //for the other months
        int whereToStart = daysOfWeek.toLowerCase().lastIndexOf(startingDay.toLowerCase().substring(0,1));

        for(String month : this.monthsAndDays.keySet()){
            System.out.printf("    " + month + " %d\n", this.year);
            System.out.println(daysOfWeek);
            //To align the numbers to the correct day of the first week for each
            //month; internalSpace is used to pad the string to properly align
            //it under the day of the week.
            String internalSpace = "";
            if(whereToStart != 0){
                 String numberOfSpaces = "%" + whereToStart + "s";
                 internalSpace = String.format(numberOfSpaces, " ");
            }

            String daysInMonth = "";
            daysInMonth += internalSpace;

            for(int i = 1; i <= this.monthsAndDays.get(month); i++){
               daysInMonth += String.format("%02d ", i);

               if(i == this.monthsAndDays.get(month)){
                   if(daysInMonth.length() % 21 == 0)
                       whereToStart = (daysOfWeek.length() - (daysInMonth.length()-1));
                   else{
                       whereToStart = (daysOfWeek.substring(0, (daysInMonth.length()))).length();
                   }

                   System.out.printf(daysInMonth + "\n");
               }
               //length of daysOfWeek is 21 characters hence why it is compared
               //to the number 21.
               if(daysInMonth.length() % 21 == 0 && i != this.monthsAndDays.get(month)){
                   System.out.printf(daysInMonth + "\n");
                   daysInMonth = "";
               }
            }

            System.out.printf("\n");
        }
    }
}
