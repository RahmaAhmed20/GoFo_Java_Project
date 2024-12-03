package com.mycompany.gofo;

import java.util.ArrayList;

/**
 * this is playground class
 * @author Basma Adel
 * @version 1.0
 * @since June 2021
 */
public class Playground {

    private String name, availableH1, availableH2, location, size;
    private Status status;
    private Owner owner;
    private ArrayList<Booking> booking = new ArrayList<Booking>();
    private int priceHour, cancellationPeriod ;
    private double rate=0, sumRating=0;
    public static  int ratingCounter =0 ;

    /**
     * this is a parameter constructor
     * @param name The value to set the name data field to
     * @param availableH1 The value to set the available h1 field to
     * @param availableH2 The value to set the available h2 field to
     * @param size The value to set the size field to
     * @param location The value to set the location field to
     * @param status The value to set the status field to
     * @param priceHour The value to set the price per hour field to
     * @param cancellationPeriod The value to set the cancellaction period field to
     * @param owner1 The value to set the owner field to
     */
    //////////////////////////constructor/////////////////////////////////////////

    public Playground(String name, String availableH1, String availableH2, String size, String location, Status status, int priceHour, int cancellationPeriod, Owner owner1) {
        this.name = name;
        this.availableH1 = availableH1;
        this.availableH2 = availableH2;
        this.cancellationPeriod = cancellationPeriod;
        this.location = location;
        this.owner = owner1;
        this.size = size;
        this.priceHour = priceHour;
        this.status = Status.Not_Activate;
    }

    /**
     * this is default constructor
     */

    public Playground() {

    }

    /**
     * this function returns the rate
     * @return rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * this function returns price per hour
     * @return priceHour
     */
    public int getPriceHour() {
        return priceHour;
    }

    /**
     * this function returns the cancellation period
     * @return cancellationPeriod
     */
    public int getCancellationPeriod() {
        return cancellationPeriod;
    }

    /**
     * this function returns the owner
     * @return owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * this function returns the status
     * @return status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * this function returns the available H1
     * @return availableH1
     */
    public String getAvailableH1() {
        return availableH1;
    }

    //////////////////////////////setters and getters//////////////////////////////////////////
    /**
     * The setName method assigns a given value to availableh1
     * @param H1 The value to set the availableh1 field to
     */
    public void setAvailableH1(String H1)
    {
        availableH1 = H1 ;
    }
    /**
     * The setName method assigns a given value to availableh2
     * @param H2 The value to set the availableh2 field to
     */
    public void setAvailableH2(String H2)
    {
        availableH2 = H2 ;
    }

    /**
     * this function returns the availableH2
     * @return availableH2
     */
    public String getAvailableH2() {
        return availableH2;
    }

    /**
     * this function returns the location
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * this function returns the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * this function returns the size
     * @return size
     */
    public String getSize() {
        return size;
    }

    /**
     * this function updates the rating
     * @param rate
     */
    public void updateRating(double rate)
    {
        ratingCounter ++;
        sumRating+= rate ;
        this.rate = sumRating / ratingCounter ;
    }

    /**
     * this function to add new booking
     * @param booking
     */
    public void insertBooking (Booking booking)
    {
        this.booking.add(booking) ;
    }

    /**
     * this function to update status
     * @param status
     */
    public void updateStatus (Status status)
    {
        this.status = status ;
    }

    /**
     * this function to display booking
     */
    public void displayBooking ()
    {
      for (int i=0 ; i<this.booking.size() ; i++)
      {
        System.out.println("Booking #"+ (i+1));
        booking.get(i).showBookingDetails();
      }
    }

    /**
     * this function to cancell booking
     * @param booking
     */
    public void cancellingBooking (Booking booking)
    {
        for(int i=0 ; i<this.booking.size() ; i++)
        {
            if (this.booking.get(i)==booking)
            {
                this.booking.remove(i) ;
            }
        }
    }

    /**
     * this function to check booking
     * @param booking
     * @return false or true
     */
    public boolean checkBooking(Booking booking)
    {

        for(int i=0 ; i<this.booking.size() ; i++)
        {
            if (this.booking.get(i)==booking ) {
                return false;
            }
        }

        int end , start , difference =0 , hour1 , hour2 ;
        char[] chars = booking.startHour.toCharArray();
        char[] chars2 = booking.endHour.toCharArray();
        char[] chars3 = availableH1.toCharArray();
        char[] chars4 = availableH2.toCharArray();
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
        if ( chars3[0]== '1')
        {
            hour1 = (chars3[1]-48);
            hour1+=10;
        }
        else
        {
            hour1  = (chars3[1]-48);
        }
        if (  chars4[0]== '1')
        {
            hour2 = (chars4[1]-48);
            hour2+=10;
        }
        else
        {
            hour2  = (chars4[1]-48);
        }
        if (booking.startHour.contains("pm") ) //12am to 10 pm       index 0 = 1   index 1 +1
        {
            start +=12;


        }
        if ( booking.endHour.contains("pm"))
        {
            end+=12;

        }
        if (availableH1.contains("pm"))
        {
            hour1+=12;
        }
        if (availableH2.contains("pm"))
        {
            hour2+=12;
        }
        System.out.println(start);
        System.out.println(end);
        System.out.println(hour1);
        System.out.println(hour2);
        for(int i=start ;i<end ;i++)
        {
            if( hour1<= i && i< hour2)
            {
                if(i==24)
                {
                    i=1 ;
                }
            }
            else
            {
                return false ;
            }
        }
        return  true ;
    }


}
