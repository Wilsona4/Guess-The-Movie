import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MovieFile {
    ArrayList<String> movieList = new ArrayList<>();

    File file = new File("C:\\Users\\Sophia\\Documents\\Movies.txt");
    Scanner scanner;

    {
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                movieList.add(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    //    Get Random Movie Title
    public String randomMovie() {
        Random random = new Random();
        int randomTitle = random.nextInt(movieList.size());

//        int randomTitle = (int) (Math.random()*(movieList.size()));
        return movieList.get(randomTitle);
    }

}
