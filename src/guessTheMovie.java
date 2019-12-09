import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.System.*;


public class guessTheMovie {
    public static void main(String[] args) {
        Game game = new Game("movies.txt");
        out.println("I have randomly chosen a movie. Try to guess it.");
        out.println(game.getMovieTitle());
        out.println(game.getHiddenMovieTitle());
        out.println(game.gameWon()+" "+game.gameLost());
        while(!game.gameWon() || !game.gameLost()) {
            out.println("guess the movie: ");
            game.guessLetter();
            out.println(game.getHiddenMovieTitle());
            out.println(game.getWrongLetters());
            out.println(game.getPoints());
        }
        if(game.gameWon()){
            System.out.println("You win!");
        }
        else if(game.gameLost()){
            System.out.println("You lost!");
        }
        out.println("Game over");
    }
}
