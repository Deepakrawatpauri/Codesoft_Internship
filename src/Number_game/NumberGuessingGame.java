package Number_game;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playAgain = true;
        int roundsWon = 0;
        int roundsPlayed = 0;

        while (playAgain) {
            roundsPlayed++;
            boolean hasWon = playGame();
            if (hasWon) {
                roundsWon++;
            }
            playAgain = askToPlayAgain();
        }

        System.out.println("Game Over!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + roundsWon);
    }

    private static boolean playGame() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean hasWon = false;
        System.out.println("select a number :");
        while (attempts < MAX_ATTEMPTS && !hasWon) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                hasWon = true;
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Too low! Try again.");
            }
        }

        if (!hasWon) {
            System.out.println("Sorry, you've used all " + MAX_ATTEMPTS + " attempts. The number was: " + randomNumber);
        }

        return hasWon;
    }

    private static boolean askToPlayAgain() {
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.next();
        return response.equalsIgnoreCase("yes");
    }
}

