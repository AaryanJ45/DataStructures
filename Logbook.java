//--------------------------------------------------------------------
//
//  Laboratory 1                                        Logbook.jshl
//
//  Definitions for the Logbook ADT
//
//  The student is to complete all missing or incomplete method
//     implementations for this class
//
//--------------------------------------------------------------------

import com.sun.source.tree.EmptyStatementTree;

import java.io.*;       // For reading (keyboard) & writing (screen)
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.*;                 // For GregorianCalendar class

class Logbook
{
    // Data members
    private int logMonth,                   // Logbook month
            logYear;                    // Logbook year
    private int[]
            entry = new int[31];        // Array of Logbook entries
    private GregorianCalendar logCalendar = new GregorianCalendar(Locale.ENGLISH);  // Java's built-in Calendar

    // Constructor
    public Logbook ( int month, int year )
    // Creates an empty logbook for the specified month and year.
    {
        LocalDate tDate = LocalDate.now();

        if(month >= 1 && month <= 12) {
            logMonth = month;
            logYear = year;
        } else {
            logYear = tDate.getYear();
            logMonth = tDate.getMonth().getValue();
        }
    }

    // Methods
    public void putEntry ( int day, int value )
    // Stores entry for the specified day.
    {
        entry[day - 1] = value;
    }

    public int getEntry ( int day )
    // Returns entry for the specified day.
    {
        return entry[day - 1];
    }

    public int month ( )
    // Returns the logbook month.
    {
        return logMonth;
    }

    public int year ( )
    // Returns the logbook year.
    {
        return logYear;
    }

    public int daysInMonth ( )
    // Returns the number of days in the logbook month.
    {
        switch(logMonth){
            case 1: return 31;
            case 2:
                if(logCalendar.isLeapYear(logYear)) {
                    return 29;
                } else {
                    return 28;
                }

            case 3: return 31;
            case 4: return 30;
            case 5: return 31;
            case 6: return 30;
            case 7: return 31;
            case 8: return 31;
            case 9: return 30;
            case 10: return 31;
            case 11: return 30;
            case 12: return 31;
        }
        return -1;
    }

    // Facilitator (helper) method
    private boolean leapYear ( )
    // If the logbook month occurs during a leap year, then returns true.
    // Otherwise, returns false.
    {
        if (logCalendar.isLeapYear(logYear)) {
            return true;
        } else {
            return false;
        }
    }

    //--------------------------------------------------------------------
    //
    //                        In-lab operations
    //
    //--------------------------------------------------------------------

    private int dayOfWeek ( int day )
    // Returns the day of the week corresponding to the specified day.
    {
        logCalendar.set(logYear, logMonth - 1, day);
        int dayOfWeek = (logCalendar.get(Calendar.DAY_OF_WEEK) - 1);
        return dayOfWeek;

        //LocalDate theDay = LocalDate.of(logYear, logMonth, day);
        //return theDay.getDayOfWeek().getValue();
    }


    public void displayCalendar ()
    // Displays a logbook using the traditional calendar format.
    {
        System.out.println("sun\t"+ "\tmon\t"+"\ttue\t"+"\twed\t"+"\tthu\t"+"\tfri\t"+"\tsat\t");
        //System.out.println(dayOfWeek(1));
        int day = 0;
        switch (dayOfWeek(1)) {
            case 0: System.out.print("1 " + this.getEntry(1)+"\t"); day = 1; break; //Sunday
            case 1: System.out.print("\t\t  " + "1 " + this.getEntry(1)); day = 2; break; //Monday
            case 2: System.out.print("\t\t\t\t " + "1 " + this.getEntry(1)); day = 3; break; //Tuesday
            case 3: System.out.print("\t\t\t\t\t\t " + "1 " + this.getEntry(1)); day = 4; break; //Wednesday
            case 4: System.out.print("\t\t\t\t\t\t\t\t " + "1 " + this.getEntry(1)); day = 5; break; //Thursday
            case 5: System.out.print("\t\t\t\t\t\t\t\t\t\t " + "1 " + this.getEntry(1)); day = 6; break; //Friday
            case 6: System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t " + "1 " + this.getEntry(1)); day = 7; break; //Saturday
        }
        int i = 2;
        boolean x = false;
        for(int noClue = 0; i <= this.daysInMonth(); day++) {
            if(day >= 7) {
                day = 0;
                System.out.print("\n");
            }
            if(day == 0) {
                System.out.print(i + " " + this.getEntry(i) + " ");
                i++;
            } else {
                System.out.print("\t " + i + " " + this.getEntry(i));
                i++;
            }

        }
    }

    public void putEntry ( int value )
    // Store entry for today.
    {

        entry[Calendar.DAY_OF_MONTH] = value;
    }

    public Logbook ( )
    // Default constructor. Creates a logbook for the current month/year.
    {
        LocalDate date = LocalDate.now();

        logYear = date.getYear();
        logMonth = date.getMonth().getValue();
    }

    public void plus ( Logbook rightLogbook )
    // Combine logbooks.
    {
        int day = 1;
        for(int i =0; i <= this.daysInMonth(); i++) {
             entry[i] = this.getEntry(day) + rightLogbook.getEntry(day);
             day++;
        }
    }

} // class Logbook

