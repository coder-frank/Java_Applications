package Number_Guessing_Game;

import java.util.Scanner;

class Game {
    
    public static void main(String[] args) {
        int randomNumber =  (int) (Math.random() * 100) + 1;

        boolean hasWon = false;

        Scanner sc = new Scanner(System.in);

        while (hasWon == false)
        {
            System.out.println("Guess The Number: ");
            int guess = sc.nextInt();

            if (guess == randomNumber)
            {
                hasWon = true;
                System.out.println("You guessed the correct number 🥳🥳");
                break;
            }

            if (guess > randomNumber)
            {
                System.out.println("Sorry! your guess is higher. Try again");
            } else if (guess < randomNumber)
            {
                System.out.println("Sorry! your guess is lower. Try again");
            }
        }
        sc.close();
    }
}
