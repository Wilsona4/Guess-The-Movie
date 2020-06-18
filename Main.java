import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GuessMovie game = new GuessMovie();
        String rules = ("Welcome to Guess the Movie!!! " +
                "\n A random movie name is selected and the system displays how many characters it's made up of." +
                "\n You have to guess the title of the movie a letter at a time." +
                "\n If the guessed letter is in the movie title, the correct position of the letter will be revealed." +
                "\n If the guessed letter is wrong a Point is lost. " + "\nYou've got 10 POINTS." +
                "\n GOOD LUCK!!!!!!\n \n");

        System.out.print(rules);
        System.out.println("The movie title has " + game.getCurrentMovie().length() + " characters (Letters and Punctuations included).");

        while (!game.isGameEnded()){
            System.out.println("You're currently guessing this movie " + game.hiddenMovieTitle());
            System.out.println("You have " + game.getPoints() + " Points.");
            System.out.println("You have guessed the following letters correctly: " + game.getRightLetters());
            System.out.println("You have guessed the following letters wrongly: " + game.getWrongLetters());
            game.guessedLetter();
        }
        if(game.isGameWon()){
            System.out.println("You win!");
            System.out.println("You have guessed " + game.getCurrentMovie() + " correctly.");
        }
        else{
            System.out.println("You lost!");
            System.out.println("The movie title was " + game.getCurrentMovie());
            System.out.println("Better luck next time.");
        }
    }
}
