import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieList {
    private ArrayList <String> movies;

<<<<<<< HEAD
    public MovieList (String pathname) throws FileNotFoundException {
        movies = new ArrayList();
=======
    public MovieList (String pathname) throws Exception{
        movies = new ArrayList<>();
>>>>>>> origin/ser
        File file = new File(pathname);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                    movies.add(scanner.nextLine());
                }
        }
    }
    public String getRandomMovie(){
        int movieIndex = (int) (Math.random() * movies.size());
        return movies.get(movieIndex);
    }
}
