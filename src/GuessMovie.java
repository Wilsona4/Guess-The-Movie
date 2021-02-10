import java.util.Scanner;

public class GuessMovie {

    private String movieTitle;
    private String correctLetters;
    private String wrongLetters;

    private int points;
    private int movieTitleCount;
    private int correctLettersCount;
    private int wrongLettersCount;

    private boolean isGameWon;
    private boolean isGameOver;

    public GuessMovie() {
        MovieFile movieFile = new MovieFile();
        this.movieTitle = movieFile.randomMovie().toUpperCase().trim();
        this.correctLetters = "";
        this.wrongLetters = "";

        this.points = 10;
        this.movieTitleCount = this.movieTitle.length();
        this.correctLettersCount = 0;
        this.wrongLettersCount = 0;

        this.isGameOver = false;
        this.isGameWon = false;

    }

    public String userInput() {

        System.out.println("Guess a letter: ");
        Scanner scanner = new Scanner(System.in);
        String guessedLetter = scanner.nextLine().toUpperCase().trim();

        if (!guessedLetter.matches("[a-zA-Z]")) {
            System.out.println("That is not a letter, try again");
            return userInput();

        } else if (correctLetters.contains(guessedLetter) || wrongLetters.contains(guessedLetter)) {
            System.out.println("You have guessed that letter already");
            return userInput();
        } else {
            return guessedLetter;
        }
    }

    public void rightOrWrong() {
        String letter = userInput();

        if (movieTitle.contains(letter)) {
            correctLetters +="" + letter;
            correctLettersCount++;
        } else {
            wrongLetters +="" + letter;
            wrongLettersCount++;
            points--;
        }
    }

    public String hidLetters() {
        if (correctLetters.equals("")) {
            return movieTitle.replaceAll("[a-zA-Z0-9[^\\s\\W]]", "_");
        } else
            return movieTitle.replaceAll("[^\\s[" + correctLetters + "]]", "_");
    }

    public boolean isGameWon() {
        if (!hidLetters().contains("_") && points > 0) {
            isGameWon = true;
        } else {
            isGameWon = false;
        }
        return isGameWon;
    }

    public boolean isGameOver() {
        if (points <= 0 || isGameWon()) {
            isGameOver = true;
        } else {
            isGameOver = false;
        }
        return isGameOver;
    }

    public String getCorrectLetters() {
        return correctLetters;
    }

    public String getWrongLetters() {
        return wrongLetters;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public int getPoints() {
        return points;
    }

    public int getMovieTitleCount() {
        return movieTitleCount;
    }

    public int getCorrectLettersCount() {
        return correctLettersCount;
    }

    public int getWrongLettersCount() {
        return wrongLettersCount;
    }
}
