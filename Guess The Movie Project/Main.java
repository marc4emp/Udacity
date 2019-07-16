public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        System.out.println("\n" + "The rules are simple, the computer randomly picks a movie title, and shows you how many letters it's made up of.\n"
                + "Your goal is to try to figure out the movie by guessing one letter at a time.\n"
                + "If a letter is indeed in the title the computer will reveal its correct position in the word, if not, you lose a point.\n"
                + "If you lose 10 points, game over! ");

        while (!game.gameEnded()) {
            System.out.println("\n" + "You are guessing: " + game.getHiddenMovieTitle());
            System.out.println("You have guessed (" + game.getWrongLetters().length() / 2 + ") wrong letters: " + game.getWrongLetters());
            game.guessLetter();
        }
        if (game.getHasWon()) {
            System.out.println("\n" + "You win!");
            System.out.println("You have guessed '" + game.getMovieTitle() + "' correctly");
        } else {
            System.out.println("\n" + "You have guessed (" + game.getWrongLetters().length() / 2 + ") wrong letters:" + game.getWrongLetters());
            System.out.println("You lost!");
            System.out.println("The movie title was " + game.getMovieTitle());
        }
    }
}