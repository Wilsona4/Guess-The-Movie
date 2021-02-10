public class Main {
    public static void main(String[] args) {
        GuessMovie guessMovie = new GuessMovie();

        String rules = ("Welcome to Guess the Movie!!! " +
                "\n A random movie name is selected and the system displays how many characters it's made up of." +
                "\n You have to guess the title of the movie a letter at a time." +
                "\n If the guessed letter is in the movie title, the correct position of the letter will be revealed." +
                "\n If the guessed letter is wrong a Point is lost. " + "\nYou've got 10 POINTS." +
                "\n GOOD LUCK!!!!!!\n \n");
        System.out.print(rules);

        while (!guessMovie.isGameOver()) {
            System.out.println("You're currently guessing: " + guessMovie.hidLetters());
            System.out.println("The Movie has " + guessMovie.getMovieTitleCount() + " Characters (Letters and Punctuations included).");
            System.out.println("You have guessed (" + guessMovie.getCorrectLettersCount() + ") correctly: " + guessMovie.getCorrectLetters());
            System.out.println("You have guessed (" + guessMovie.getWrongLettersCount() + ") wrongly: " + guessMovie.getWrongLetters());
            guessMovie.rightOrWrong();
            System.out.println("You have " + guessMovie.getPoints() + " points left");

        }

        if (guessMovie.isGameWon()) {
            System.out.println("You win!");
            System.out.println("You have guessed " + guessMovie.getMovieTitle() + " correctly.");
        } else {
            System.out.println("You lost!");
            System.out.println("The movie title was " + guessMovie.getMovieTitle());
            System.out.println("Better luck next time.");
        }
    }
}
