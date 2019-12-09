import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.System.*;

public class Game {

    private String movieToGuess;
    private String wrongLetters;
    private String rightLetters;
    private int points;

    public Game(String pathname) {
        MovieList movieList = null;
        try {
            movieList = new MovieList(pathname);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        movieToGuess = movieList.getRandomMovie();
        points = 0;
        rightLetters = "";
        wrongLetters = "";
    }
    public String getMovieTitle() {
        return movieToGuess;
    }
    public String getWrongLetters() {
        return wrongLetters;
    }
    public int getPoints() {
        return points;
    }
    public String getHiddenMovieTitle() {
        if(rightLetters.equals("")){
            return movieToGuess.replaceAll("[a-zA-Z]", "_");
        }
        else{
            return movieToGuess.replaceAll("[a-zA-Z&&[^" + rightLetters +"]]", "_");
        }
    }
    private String inputLetter() {
        out.println("Guess a letter:");
        Scanner scanner = new Scanner(in);
        String letter = scanner.nextLine().toLowerCase();
        if(!letter.matches("[a-zA-Z]")){
            System.out.println("That is not a letter.");
            return inputLetter();
        }
        else {
            return letter;
        }
    }
    public void guessLetter() {
        String guessedLetter = inputLetter();
        if (movieToGuess.toLowerCase().contains(guessedLetter)) {
            rightLetters += guessedLetter;
        }
        else {
            points++;
            wrongLetters += " " + guessedLetter;
        }
    }
    public boolean gameWon() {
        if ((points <= 10) && (!getHiddenMovieTitle().contains("_"))) {
            return true;
        } else {
            return false;
        }
    }
    public boolean gameLost() {
        if(points >= 10){
            return true;
        }
        else {
            return false;
        }
    }
}
