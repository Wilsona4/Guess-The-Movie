import java.util.Scanner;

public class GuessMovie {
    private String currentMovie;
    private String wrongLetters;
    private String rightLetters;
    private int points;
    private boolean gameEnded;
    private boolean gameWon;

    public GuessMovie(){
        MovieList movieList = new MovieList();
        currentMovie = movieList.randomMovie().toUpperCase().trim();
        rightLetters = "";
        wrongLetters = "";
        points = 10;
        gameEnded = false;
        gameWon = false;
    }

    public String hiddenMovieTitle(){
     if (rightLetters.equals("")){
         return currentMovie.replaceAll("[a-zA-Z0-9[^\\s]]","_");
     }else {
         return currentMovie.replaceAll("[^\\s[" + rightLetters + "]]","_");
     }
    }

    public String inputLetter() {

        System.out.println("Guess a letter:");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toUpperCase();

        if (!letter.matches("[A-Z]")) {
            System.out.println("That is not a letter. Please input a Letter.");
            return inputLetter();
        } else if (wrongLetters.contains(letter) || rightLetters.contains(letter)) {
            System.out.println("You already guessed that letter.");
            return inputLetter();
        } else {
            return letter;
        }
    }

    public void guessedLetter(){
        String guessedLetter = inputLetter().toUpperCase();
        if (currentMovie.contains(guessedLetter)){
            rightLetters += "" + guessedLetter;
        } else {
            wrongLetters += "" + guessedLetter;
            points --;
        }
    }

    public String getCurrentMovie() {
        return currentMovie;
    }

    public String getRightLetters() {
        return rightLetters;
    }

    public String getWrongLetters() {
        return wrongLetters;
    }

    public int getPoints() {
        return points;
    }

    public boolean isGameEnded(){
        if (points <= 0){
            return true;
        }
        if (!hiddenMovieTitle().contains("_")){
            gameWon = true;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isGameWon(){
        return gameWon;
    }

}
