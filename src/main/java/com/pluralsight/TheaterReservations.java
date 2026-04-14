package com.pluralsight;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class TheaterReservations
{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        promptUser();
    }
    public static void promptUser()
    {
        String userName = " ";
        LocalDate formattedDate;
        int ticketAmount = 0;

        System.out.println("""
                Hello! Welcome to the theater reservations application.
                
                Please enter your name to continue: \n""");

        userName = receiveInputString();

        System.out.printf("\nAlright, %s. \n", userName);
        System.out.println("What date are you coming to the theater? (MM/DD/YYYY) \n");
        //enteredDate = receiveInputString();

        formattedDate = formatDateFromString();


        System.out.printf("\nSo you'll be coming %s, great!\n", formattedDate);
        System.out.println("Lastly, how many tickets would you like? \n");
        ticketAmount = recieveInputInteger();



        System.out.printf("\nThank you for your purchase! \n%d tickets reserved for %s on %s.",
                ticketAmount, userName, formattedDate);

    }

    public static String receiveInputString()
    {
        String ticketString = input.nextLine()
                .strip();
        return ticketString;
    }

    public static LocalDate formatDateFromString()
    {
        while (true)
        {
            try
            {
                String enteredDate = input.nextLine();

                DateTimeFormatter formatEntry = DateTimeFormatter.ofPattern("M/d/yyyy");
                //DateTimeFormatter formatForOutput = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy");
                LocalDate formattedDate = LocalDate.parse(enteredDate, formatEntry);



                return formattedDate;
            }
            catch (Exception e)
            {
                System.out.println("Please enter a valid date (MM/DD/YYYY):\n");
            }
        }



    }
    public static int recieveInputInteger()
    {
        while (true)
        {
            try
            {
                int ticketInteger = input.nextInt();
                return ticketInteger;
            }
            catch (Exception e)
            {
                System.out.println("Please enter a valid number of tickets (numbers only):\n");
                input.nextLine();
            }
        }
    }
}