/*
 * Harris Dizdarevic
 * CISC. 3150
 * Question 2: Auxillary Calendar class to handle all input, output of building
 * a character
 * Using a map data structure to store key (month name) value (number of days
 * in a month) pairs as efficiently as possible.
 */

package questiontwo;
import java.util.LinkedHashMap;
import java.util.Map;

public class Calendar{
    private Map<String, Integer> monthsAndDays = new LinkedHashMap<String,Integer>();
    private int year;

    public Calendar(int year){
        this.year = year;
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
        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }

    public Map<String, Integer> getMonthsAndDays(){
        return this.monthsAndDays;
    }

    public void printFormat(){
        String daysOfWeek = "Su Mo Tu We Th Fr Sa";

        for(String month : this.monthsAndDays.keySet()){
            System.out.printf("    " + month + " %d\n", this.year);
            System.out.println(daysOfWeek);
        }
    }
}
