import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MovieList {
    private ArrayList<String> movies = new ArrayList<String >();

    File file = new File("C:\\Users\\Sophia\\Documents\\Movies.txt");
    Scanner movieText;

    {
        try {
            movieText = new Scanner(file);
            while (movieText.hasNextLine()){
                movies.add(movieText.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
    }

    // Random movie name generator

    public String randomMovie(){
        Random index = new Random();
        int moviesIndex = index.nextInt(movies.size());
//        int moviesIndex = (int) (Math.random() * movies.size());
        return movies.get(moviesIndex);
    }
}
