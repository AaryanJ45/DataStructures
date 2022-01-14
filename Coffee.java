//--------------------------------------------------------------------
//
//  Laboratory 1                                        Coffee.java
//
//  Implementation of the sample Coffee ADT for testing the Logbook ADT
//
//--------------------------------------------------------------------

import java.io.*;       // For reading (keyboard) & writing (screen)

class   Coffee
{
  // Records coffee intake for January 2002.
  public static void main ( String args[] ) throws IOException 
  {
      int day;                  // Day loop counter

      // Coffee intake for January 2002    
      Logbook coffee = new Logbook(1, 2002);   
      
      // Record entries for the 1st and 15th of January 2002
      coffee.putEntry(1, 5);
      coffee.putEntry(15, 2);
    
      // Output the logbook entries.
      System.out.println("Month/Year : " + coffee.month() + "/"
                         + coffee.year());

      for ( day = 1 ; day <= coffee.daysInMonth() ; day++ )
          System.out.println(day + " : " + coffee.getEntry(day));
  } // main( ) 
  
} // class Coffee