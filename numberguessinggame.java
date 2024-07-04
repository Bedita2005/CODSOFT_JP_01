import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int start = 1;
        int end = 100;
        int maxAttempts = 10;
        int totalScore = 0;
        int roundsPlayed = 0;
        boolean playAgain = true;

        while (playAgain) {
            roundsPlayed++;
            int actualNumber = random.nextInt(end - start + 1) + start;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round " + roundsPlayed + ":");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < actualNumber) {
                    System.out.println("Too low!");
                } else if (guess > actualNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct!");
                    guessedCorrectly = true;
                }
            }

            if (guessedCorrectly) {
                totalScore += maxAttempts - attempts + 1;
            } else {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + actualNumber + ".");
            }

            System.out.print("Do you want to play again? (y/n): ");
            char response = scanner.next().charAt(0);
            playAgain = (response == 'y' || response == 'Y');
        }

        System.out.println("Game over! You played " + roundsPlayed + " rounds with a total score of " + totalScore + ".");
        scanner.close();
    }
}
