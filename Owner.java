
package com.mycompany.gofo;
/**
 * this is Owner class
 * @author Rahma Ahmed
 * @version 1.0
 * @since June 2021
 */
public class Owner extends User{
    Playground playground;

    /**
     * this is a parameter constructor
     * @param n The value to set the name field to
     * @param i The value to set the id field to
     * @param pass The value to set the password field to
     * @param eml The value to set the email field to
     * @param phn The value to set the phone field to
     * @param loc The value to set the location field to
     * @param bal The value to set the balance field to
     */
    public Owner(String n, String i, String pass, String eml, String phn, String loc , int bal) {
        super(n, i, pass, eml, phn, loc , bal);
    }


    public Owner() {
        super();
    }

    /**
     * this function to display playground with details
     */
    public void displayPlayground(){
        System.out.println("Name: "+playground.getName());
        System.out.println("The status of the playground is: "+ playground.getStatus());
        System.out.println("The available hous of the playground is from: " + playground.getAvailableH1() +" to " + playground.getAvailableH2());
        System.out.println("The size of the playground is: "+ playground.getSize());
        System.out.println("The location of the playground is: "+ playground.getLocation());
        System.out.println("The price of the playground per hour is: "+ playground.getPriceHour());
        playground.displayBooking();

    }

    /**
     * this function returns playground
     * @return playground
     */
    public Playground getPlayground(){
        return playground;
    }

    /**
     * this function to update the available hours for booking
     * @param availableh1 The value to set the avalaible h1 field to
     * @param availableh2 The value to set the available h2 field to
     */
    public void updateAvailableHours(String availableh1 , String availableh2){
         playground.setAvailableH1(availableh1 );
         playground.setAvailableH2(availableh2 );

    }

    /**
     * this function to add new playground
     * @param p The value to set the playground field to
     */
    public void addPlayground (Playground p){

        playground = p;
    }

}
