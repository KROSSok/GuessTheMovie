import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieList {
    private ArrayList <String> movies;

    public MovieList (String pathname) throws Exception{
        movies = new ArrayList<>();
        File file = new File(pathname);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
                movies.add(scanner.nextLine());
            }
    }
    public String getRandomMovie(){
        int movieIndex = (int) (Math.random() * movies.size());
        return movies.get(movieIndex);
    }
}
