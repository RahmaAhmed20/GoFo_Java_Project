
package com.mycompany.gofo;


import java.util.ArrayList;
/**
 * this is player class
 * @author Rahma Ahmed
 * @version 1.0
 * @since June 2021
 */
public class Player extends User {

    private ArrayList<Booking> book = new ArrayList<Booking>();
    public  Team team ;

    /**
     * this is a parameter constructor
     * @param name The value to set the name field to
     * @param id The value to set the id field to
     * @param password The value to set the password field to
     * @param email The value to set the email field to
     * @param phone The value to set the phone field to
     * @param location The value to set the location field to
     * @param balance The value to set the balance field to
     */
    public Player(String name, String id, String password, String email, String phone, String location, int balance) {
        super(name, id, password, email, phone, location, balance);


    }


    public Player() {

    }

    /**
     * this function to display Booking
     */
    public void displayBooking() {

        for (int i = 0; i < this.book.size(); i++) {
            System.out.println("Booking #" + (i+1));
            System.out.println("The start hour is: " + book.get(i).startHour + " The end hour " + book.get(i).endHour);
            System.out.println("The date of booking is: " + book.get(i).date);
        }


    }

    /**
     * this function to add new booking
     * @param b
     */
    public void insertBooking(Booking b) {
        book.add(b);
    }

    /**
     * this function to cancell booking
     * @param b
     */
    public void cancelBooking(Booking b) {
        for(int i=0 ; i<this.book.size() ; i++)
        {
            if (this.book.get(i)==b)
            {
                this.book.remove(i) ;
            }
        }
        }

    /**
     * this function to create team
     * @param t
     */
    public void creatTeam (Team t){
          team.addPlayer(this);


        }


    }

