import java.util.Scanner;

public class Game {

    private boolean hasWon;
    private int pointsLost;
    private String movieToGuess;
    private String rightLetters;
    private String wrongLetters;

    public Game() {
        Movie pickMovie = new Movie();

        movieToGuess = pickMovie.getRandomMovie().trim();

        hasWon = false;
        pointsLost = 0;
        rightLetters = "";
        wrongLetters = "";
    }

    public boolean gameEnded() {
        if (pointsLost >= 10) {
            return true;
        }

        if (!getHiddenMovieTitle().contains("-")) {
            hasWon = true;
            return true;
        }

        return false;
    }

    public String getHiddenMovieTitle() {
        if (rightLetters.equals("")) {
            return movieToGuess.replaceAll("[a-zA-Z]", "-");
        } else {
            return movieToGuess.replaceAll("[a-zA-Z&&[^" + rightLetters + "]]", "-");
        }
    }

    public void guessLetter() {

        String guessedLetter = inputLetter();

        if (movieToGuess.toLowerCase().contains(guessedLetter)) {
            rightLetters += guessedLetter + guessedLetter.toUpperCase();
        } else {
            pointsLost++;
            wrongLetters += " " + guessedLetter;
        }
    }

    private String inputLetter() {

        System.out.println("Guess a letter: ");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toLowerCase();

        if (!letter.matches("[a-z]")) {
            System.out.println("That is not a letter.");
            return inputLetter();
        } else if (wrongLetters.contains(letter) || rightLetters.contains(letter)) {
            System.out.println("You already guessed that letter.");
            return inputLetter();
        } else {
            return letter;
        }
    }

    public String getWrongLetters() {
        return wrongLetters;
    }

    public boolean getHasWon() {
        return hasWon;
    }

    public String getMovieTitle() {
        return movieToGuess;
    }
}
