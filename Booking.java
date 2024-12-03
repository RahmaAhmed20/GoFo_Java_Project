
package com.mycompany.gofo;

/**
 * this is Booking class
 * @author Basma Adel
 * @version 1.0
 * @since June 2021
 */
public class Booking {
    public String startHour , date, endHour;
    private Playground playground ;
    private Player player ;
    private int totalPrice ;

    /**
     * this is parameter constructor
     * @param startHour The value to set the start hour field to
     * @param endHour The value to set the end hour field to
     * @param date The value to set the date field to
     * @param playground The value to set playground data field to
     * @param player The value to set the player field to
     */
    public Booking (String startHour , String endHour , String date , Playground playground , Player player)
    {
        this.startHour = startHour ;
        this.endHour = endHour ;
        this.date =date ;
        this.playground= playground ;
        this.player =player ;
    }

    /**
     * this function to display booking's details
     */
    public void showBookingDetails() {
        System.out.println("Booking details: ");
        System.out.println("Date: " + date);
        System.out.println("Start time: " + startHour + ", End Time: " + endHour);
        System.out.println("price per hour: " + playground.getPriceHour() + ", total price: " + totalPrice);
    }

    /**
     * this function returns the total cost
     * return totalcost
     */
    public int totalCost ()
    {
        int end , start , difference =0 ;
        char[] chars = startHour.toCharArray();
        char[] chars2 = endHour.toCharArray();
        char a = chars[0];
        char b = chars2[0] ;

        if ( a == '1')
        {
            start = (chars[1]-48);
            start+=10;
        }
        else
        {
            start  = (chars[1]-48);
        }
        if ( b == '1')
        {
            end = (chars2[1]-48);
            end+=10;
        }
        else
        {
            end  = (chars2[1]-48);
        }
        if (startHour.contains("am") && endHour.contains("pm")) //12am to 10 pm       index 0 = 1   index 1 +1
        {

           end +=12;
           difference = end - start ;
           totalPrice = difference * playground.getPriceHour() ;
        }
        else if (startHour.contains("pm") && endHour.contains("am"))
        {
          start+=12;
          difference = 24-start;
          difference += end;
          totalPrice = difference * playground.getPriceHour() ;
        }
        else if ((startHour.contains("pm") && endHour.contains("pm")) || ((startHour.contains("am") && endHour.contains("am"))))
        {
           difference = end - start;
            totalPrice = difference * playground.getPriceHour() ;

        }
        return  totalPrice ;
    }

}
