package com.pluralsight;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class TheaterReservations
{
    static Scanner input = new Scanner(System.in); //remember to use static, belongs to class

    public static void main(String[] args)
    {
        promptUser();
    }
    public static void promptUser()
    {
        String userName = " ";
        String formattedDate; //must be a string because formateDateFromString() will return a string, + formatting for strings
        int ticketAmount = 0;

        System.out.println("""
                \\|/          (__)   \s
                     `\\------(oo)
                       ||    (__)
                       ||w--||     \\|/
                   \\|/
                Hello! Welcome to the theater reservations application.
                
                Please enter your name to continue: \n""");
        userName = receiveInputString();

        System.out.printf("\nAlright, %s. \n", userName);
        System.out.println("What date are you coming to the theater? (MM/DD/YYYY) \n");
        formattedDate = formatDateFromString();

        System.out.printf("\nSo you'll be coming %s, great!\n", formattedDate);
        System.out.println("Lastly, how many tickets would you like? \n");
        ticketAmount = recieveInputInteger();

        System.out.printf("\nThank you for your purchase! \n%d tickets reserved for %s on %s.",
                ticketAmount, userName, formattedDate);

    }

    public static String receiveInputString() //used to get input for name
    {
        String ticketString = input.nextLine()
                .strip();
        return ticketString;
    }

    public static String formatDateFromString() //actually takes input too, didn't want to rename
                                                //or deal with passing value from receiveInputString()
                                                //highly annotated with comments because I learned a lot/need to remember
    {
        while (true)
        {
            try
            {
                //takes input
                String enteredDate = input.nextLine();
                //declaring/assigning date patterns
                DateTimeFormatter formatEntry = DateTimeFormatter.ofPattern("M/d/yyyy");
                DateTimeFormatter formatForOutput = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy");
                //formattedDate stores parsed LocalDate type from input using our format, this is the line that would throw an exception
                LocalDate formattedDate = LocalDate.parse(enteredDate, formatEntry);
                //making a string so we can use .format() which returns a string
                String stringDate;
                //.format() argument can be a DTF pattern when called from a LocalDate object
                stringDate = formattedDate.format(formatForOutput);
                //returning as a string to save brain power, I know how to deal with strings
                return stringDate;
            }
            catch (Exception e)
            {
                System.out.println("Please enter a valid date (MM/DD/YYYY):\n");
                //doesn't need nextLine(), buffer is cleared from try block, vs nextInt() doesn't clear \n
            }
        }

    }
    public static int recieveInputInteger() //takes input for # of tickets, also loops for invalid input
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