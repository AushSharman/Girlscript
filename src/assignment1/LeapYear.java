package assignment1;

import java.util.TreeMap;

public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year%4 == 0){
            if (year%100==0){
                if (year%400==0){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isLeapYear(2100));
    }
}
