
package com.mycompany.gofo;


import java.util.ArrayList;
import java.util.Scanner;
/**
 * this is just a demo to create Gofo Application
 * @author Basma Adel
 * @version 1.0
 * @since June 2021
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome in GOFO Application");
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Playground> playgrounds = new ArrayList<Playground>();
        ArrayList<Owner> owners = new ArrayList<Owner>();
        Administrator BR=new Administrator();
        int adminpass = 12345, balance = 0, price1, price2;
        String user, name = "", id = "", password = "", email = "", phone = "", location = "", start, end, date, size;
        int priceHour, cancellationPeriod;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Are you (User or Administrator)");
            user=input.next();
            if (user.equalsIgnoreCase("user")) {
                System.out.println("Are you a 1- player or 2- owner ? :");
                int user1 = input.nextInt();
                System.out.println("Do you want to :");
                System.out.println("1- sign in ");
                System.out.println("2- log in ");
                int choice = input.nextInt();

                if (choice == 1) {
                    System.out.println("enter your -> name");
                    name = input.next();
                    System.out.println("enter your id ");
                    id = input.next();
                    System.out.println("enter your password");
                    password = input.next();
                    System.out.println("enter your email");
                    email = input.next();
                    System.out.println("enter your phone");
                    phone = input.next();
                    System.out.println("enter your location");
                    location = input.next();
                    System.out.println("enter your balance");
                    balance = input.nextInt();
                }
                switch (user1) {
                    case 1: {
                        Player player1 = new Player();
                        if (choice == 1) {

                            Player player = new Player(name, id, password, email, phone, location, balance);
                            player1 = player;
                            players.add(player);
                        }
                        else if (choice == 2) {
                            int flag = 0;
                            while (true) {
                                System.out.println("enter your -> email , password ");
                                email = input.next();
                                password = input.next();

                                for (int i = 0; i < players.size(); i++) {
                                    player1 = players.get(i);
                                    if (player1.login(email, password)) {
                                        flag = 1;
                                        System.out.println("Login is correct");
                                        break;
                                    }
                                }

                                if (flag == 1) {
                                    break;
                                }

                            }
                        }
                        System.out.println("what do you want ?");
                        System.out.println("1- view profile ");
                        System.out.println("2- show your Booking list");
                        System.out.println("3- Add new Booking playground ");
                        int display = input.nextInt();
                        if (display == 3) {
                            System.out.println("BY which you will search ( price or location ) ?");
                            name = input.next();
                            int flagg = 1;
                            if (name.equalsIgnoreCase("price")) {
                                System.out.println("enter the two price range");
                                System.out.println("from : ");
                                price1 = input.nextInt();
                                System.out.println("to : ");
                                price2 = input.nextInt();
                                Playground playground;
                                System.out.println(playgrounds.size());
                                for (int i = 0; i < playgrounds.size(); i++) {
                                    playground = playgrounds.get(i);
                                    if (price1 <= playground.getPriceHour() && playground.getPriceHour() <= price2 && playground.getStatus().equals(Status.Activate)) {
                                        System.out.println("name of playground : " + playground.getName());
                                        System.out.println("price per Hour : " + playground.getPriceHour());
                                        System.out.println("location : " + playground.getLocation());
                                        System.out.println("size : " + playground.getSize());
                                        System.out.println("available time Booking is  from " + playground.getAvailableH1() + "to " + playground.getAvailableH2());
                                        System.out.println("rate of this playground :" + playground.getRate());
                                        System.out.println("-----------------------------------");
                                        flagg = 0;
                                    }
                                }
                            } else {
                                System.out.println("enter the location that you want");
                                location = input.next();
                                Playground playground;
                                System.out.println(playgrounds.size());
                                for (int i = 0; i < playgrounds.size(); i++) {
                                    playground = playgrounds.get(i);
                                    if (playground.getLocation().equalsIgnoreCase(location) && playground.getStatus().equals(Status.Activate)) {
                                        System.out.println("-----------------------------------");
                                        System.out.println("name of playground : " + playground.getName());
                                        System.out.println("price per Hour : " + playground.getPriceHour());
                                        System.out.println("location : " + playground.getLocation());
                                        System.out.println("size : " + playground.getSize());
                                        System.out.println("available time Booking is  from " + playground.getAvailableH1() + "to " + playground.getAvailableH2());
                                        System.out.println("rate of this playground :" + playground.getRate());
                                        System.out.println("-----------------------------------");
                                        flagg = 0;
                                    }
                                }
                            }
                            if (flagg == 0) {
                                int flag1=0;
                                System.out.println("Enter the name of the playground that you want ");
                                name = input.next();
                                Playground p1;
                                Playground p2 = new Playground();
                                for (int i = 0; i < playgrounds.size(); i++)
                                {
                                    p1 = playgrounds.get(i);
                                    if (p1.getName().equalsIgnoreCase(name)) {
                                        flag1=1;
                                        p2 = p1;
                                        break;
                                    }
                                }
                               if(flag1==1)
                               {
                                   System.out.println("Enter the time that you want to Book in , like as ( 02 am ) to (04 pm) : ");
                                   start = input.next();
                                   end = input.next();
                                   System.out.println("Enter the date that you want to book in ");
                                   date = input.next();
                                   Booking book = new Booking(start, end, date, p2, player1);
                                   if (p2.checkBooking(book)) {
                                       p2.insertBooking(book);
                                       player1.insertBooking(book);
                                       System.out.println("your total cost : " + book.totalCost());
                                       System.out.println("Booking is done seccessully");
                                   } else {
                                       System.out.println("invalid time of booking ");
                                   }


                               }
                               else {
                                   System.out.println("there is no matching result");
                               }


                               }

                        }
                            else if (display == 1) {
                            System.out.println("------------Your Profile -----------");
                            player1.viewProfile();
                            System.out.println("your balance in eWallet is : " + player1.getBalance());

                        } else if (display == 2) {
                            System.out.println("------------Your Booking List -----------");
                            player1.displayBooking();

                        }


                        break;
                    }

                    case 2: {

                        Owner owner1 = new Owner();
                        if (choice == 1) {

                            Owner owner = new Owner(name, id, password, email, phone, location, balance);
                            System.out.println("enter your playground with details ");
                            System.out.println("enter the playground name");
                            name = input.next();
                            System.out.println("enter availableH1 ");
                            start = input.next();
                            System.out.println("enter availableH2 ");
                            end = input.next();
                            System.out.println("enter the size ");
                            size = input.next();
                            System.out.println("enter the location");
                            location = input.next();
                            System.out.println("enter price per hour");
                            priceHour = input.nextInt();
                            System.out.println("enter cancellation period");
                            cancellationPeriod = input.nextInt();
                            Playground p = new Playground(name, start, end, size, location, Status.Not_Activate, priceHour, cancellationPeriod, owner1);
                            owner.addPlayground(p);
                            playgrounds.add(p);
                            owner1 = owner;
                            owners.add(owner);
                        } else if (choice == 2) {
                            int flag = 0;
                            while (true) {
                                System.out.println("enter your -> email  ");
                                email = input.next();
                                System.out.println("enter your ->  password ");
                                password = input.next();

                                for (int i = 0; i < owners.size(); i++) {
                                    owner1 = owners.get(i);
                                    if (owner1.login(email, password)) {
                                        flag = 1;
                                        System.out.println("Login is correct");
                                        break;
                                    }
                                }

                                if (flag == 1) {
                                    break;
                                }

                            }
                        }
                        System.out.println("1- show playground");
                        System.out.println("2- update avaiable hours for booking  ");
                        int num = input.nextInt();
                        if (num == 1) {

                            owner1.displayPlayground();
                        } else if (num == 2) {
                            System.out.println("enter the new time for booking  to :....");
                            start = input.next();
                            System.out.println("enter the new time for booking to :....");
                            end = input.next();
                            owner1.updateAvailableHours(start, end);

                        }


                        break;

                    }
                }

            }
            else
            {
                while (true) {
                    System.out.println("Enter your access code");
                    price1 = input.nextInt();
                    if (price1==(adminpass)) {
                        System.out.println("access correct");
                        break;
                    }
                }
                    System.out.println("this is playground list :");
                    System.out.println("*********************************");
                    for(int i=0 ; i<playgrounds.size() ; i++)
                    {
                        System.out.println("name of playground : " + playgrounds.get(i).getName());
                        System.out.println("price per Hour : " + playgrounds.get(i).getPriceHour());
                        System.out.println("location : " + playgrounds.get(i).getLocation());
                        System.out.println("size : " + playgrounds.get(i).getSize());
                        System.out.println("available time Booking is  from : " + playgrounds.get(i).getAvailableH1() + "to : " + playgrounds.get(i).getAvailableH2());
                        System.out.println("rate of this playground :" + playgrounds.get(i).getRate());
                        System.out.println("the status of the playground"+playgrounds.get(i).getStatus());
                        System.out.println("-----------------------------------");
                    }
                    System.out.println("enter tha name of the playground that you want to check or delete it ");
                    name=input.next();
                    Playground p1;
                    int index=0 ;
                    int indexowner=0 , flag=0;
                    Playground p2 = new Playground();
                    for (int i = 0; i < playgrounds.size(); i++) {
                        p1 = playgrounds.get(i);
                        if (p1.getName().equalsIgnoreCase(name)) {
                            p2 = p1;
                            index =i ;
                            flag=1;
                        }
                        if(p2.getOwner()==owners.get(i))
                        {
                            indexowner=i;
                        }
                    }
                    if (flag==1)
                    {
                        System.out.println("1- change status");
                        System.out.println("2- delete playground");
                        price1 = input.nextInt();
                        System.out.println("name of playground : " + playgrounds.get(index).getName());
                        System.out.println("price per Hour : " + playgrounds.get(index).getPriceHour());
                        System.out.println("location : " + playgrounds.get(index).getLocation());
                        System.out.println("size : " + playgrounds.get(index).getSize());
                        System.out.println("available time Booking is  from " + playgrounds.get(index).getAvailableH1() + "to " + playgrounds.get(index).getAvailableH2());
                        System.out.println("rate of this playground :" + playgrounds.get(index).getRate());
                        System.out.println("the status of the playground"+playgrounds.get(index).getStatus());
                        System.out.println("-------------------------------------------");

                        if(price1==1)
                        {
                            System.out.println("Do you want to change the status of it ? ( yes / no )");
                            name= input.next();
                            if(name.equalsIgnoreCase("yes"))
                            {

                                System.out.println("enter the new status of it  ") ;
                                start=input.next();
                                playgrounds.set(index,BR.checkAvailability(p2,start));
                                System.out.println("status has been changed  ") ;

                            }

                        }
                        else
                        {
                            System.out.println("Do you want to delete this playground ? ( yes / no ) " );
                            name = input.next();
                            if(name.equalsIgnoreCase("yes"))
                            {
                                playgrounds.set(index,BR.deletePlayground(playgrounds.get(index)));
                                owners.get(indexowner).addPlayground(playgrounds.get(index));
                                playgrounds.remove(index);
                                System.out.println("deleted successfully ") ;


                            }

                        }

                    }
                    else
                    {
                        System.out.println("there is no matched name");
                    }
            }

        }
    }
}
