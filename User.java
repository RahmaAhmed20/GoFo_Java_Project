
package com.mycompany.gofo;

/**
 * this is user class
 * @author Rahma Ahmed
 * @version 1.0
 * @since June 2021
 */
public class User{

    private String  name, id, password, email, phone, location;
    private  int balance ;

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
    public User(String n, String i, String pass, String eml, String phn, String loc , int bal){
        name=n;
        id=i;
        password=pass;
        email=eml;
        phone=phn;
        location=loc;
        balance = bal ;
    }

    public User() {

    }

    /**
     * this function to login for the user
     * @param eml The value to set email field to
     * @param pass The value to set password field to
     * @return true or false
     */
    public boolean login(String eml, String pass){
        if(this.email.equals(eml) && this.password.equals(pass))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * this function to veiw profile
     */
    public void viewProfile(){

        System.out.println("name: "+name);
        System.out.println("id: "+id);
        System.out.println("email: "+email);
        System.out.println("password"+password);
        System.out.println("phone: "+phone);
        System.out.println("location"+location);

    }

    /**
     * this function returns the balace
     * @return balance
     */
    public int getBalance(){
        return balance ;
    }

}