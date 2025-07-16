import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int score = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("--------------------------------------------------");

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int attempts = 5;
            boolean isCorrect = false;

            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + attempts + " attempts. Try to guess it!");

            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts--;

                if (guess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed it right!");
                    score++;
                    isCorrect = true;
                    break;
                } else if (guess > numberToGuess) {
                    System.out.println("❌ Too high! Attempts left: " + attempts);
                } else {
                    System.out.println("❌ Too low! Attempts left: " + attempts);
                }
            }

            if (!isCorrect) {
                System.out.println("😢 Sorry! The correct number was: " + numberToGuess);
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing! Your final score is: " + score);
        sc.close();
    }
}