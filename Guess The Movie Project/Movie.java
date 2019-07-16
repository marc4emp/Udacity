import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Movie {

    private ArrayList<String> movies;

    public Movie() {
        movies = new ArrayList<>();
        File file = new File("ListOfMovies.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                movies.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        }
    }

    public String getRandomMovie() {
        int movieIndex = (int) (Math.random() * movies.size());
        return movies.get(movieIndex);
    }
}
