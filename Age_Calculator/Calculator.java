package Age_Calculator;

import java.time.Year;
import java.util.Scanner;

public class Calculator {
    
    public static void main(String [] args)
    {
        System.out.println("Welcome, please enter your birth year:");

        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        sc.close();

        int currentYear = Year.now().getValue();

        System.out.println("You are " + (currentYear - year) + " year old");
    } 

}
