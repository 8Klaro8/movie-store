import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import models.Movie;
import models.Store;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n********************JAVA VIDEO STORE********************\n");

        // Movies
        Store store = new Store();

        // Load movies from txt. file
        loadMovies(store);

        // Main program
        chooseOption(scan, store);

    }

    private static void chooseOption(Scanner scan, Store store) {
        while (true) {

            System.out.println("What would you like to do?\n\na) Buy Movie\nb) Rent Movie\nc) Return Movie");
            String userChoice = scan.nextLine();
            switch (userChoice) {
                case "a":
                    // Buy
                    System.out.println("Type a movie title!");
                    String typedMovieTitle = scan.nextLine();
                    Movie foundMovie = store.getMovie(typedMovieTitle);
                    System.out.println("\nThe movie: " + foundMovie.getName() + "\n");

                    if (foundMovie.isAvailable()) {
                        System.out.println("BUY:\na.) Blue-Ray\nb.) DVD\n");
                        String buyingFormat = scan.nextLine();

                        switch (buyingFormat) {
                            case "a":
                                foundMovie.setFormat("Blue-Ray");
                                store.sellMovie(foundMovie.getName());
                                break;
                            case "b":
                                foundMovie.setFormat("DVD");
                                store.sellMovie(foundMovie.getName());
                                break;

                            default:
                                break;
                        }
                        break;
                    } else {
                        continue;
                    }

                case "b":
                    // Rent
                    System.out.println("Type a movie title!");
                    String typedMovieTitleRent = scan.nextLine();
                    Movie foundMovieRent = store.getMovie(typedMovieTitleRent);

                    if (foundMovieRent.isAvailable()) {
                        System.out.println("\nThe movie: " + foundMovieRent.getName() + " is in stock!\n");
                        System.out.println("RENT:\na.) Blue-Ray\nb.) DVD\n");
                        String rentalFormat = scan.nextLine();

                        switch (rentalFormat) {
                            case "a":
                                foundMovieRent.setFormat("Blue-Ray");
                                store.rentMovie(foundMovieRent.getName());
                                break;
                            case "b":
                                foundMovieRent.setFormat("DVD");
                                store.rentMovie(foundMovieRent.getName());
                                break;
                            default:
                                break;
                        }
                        break;
                    } else {
                        System.out.println(foundMovieRent.getName());
                        break;
                    }

                case "c":
                    // Return
                    System.out.println("Type the movie title you would like to return");
                    String movieToReturn = scan.nextLine();
                    store.returnMovie(movieToReturn);
                    break;

                default:
                    System.out.println("\nType one of the given options.\n");
                    chooseOption(scan, store);
                    break;
            }
        }
    }

    public static void loadMovies(Store store) throws FileNotFoundException {

        FileInputStream movieTXT = new FileInputStream("movies.txt");
        Scanner movieScanner = new Scanner(movieTXT);
        while (movieScanner.hasNextLine()) {
            String line = movieScanner.nextLine();
            String[] splittedLine = line.split("--");
            System.out.println(Arrays.toString(splittedLine));
            System.out.println(splittedLine[0]);

            double rating = Double.parseDouble(splittedLine[2]);
            Movie currentMovie = new Movie(splittedLine[0], splittedLine[1], rating, true);
            store.addMovie(currentMovie);
        }
    }

    /**
     * Name: manageMovies
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. In an infinite loop, the user can choose to a) purchase b) rent c)
     * return d) exit.
     * • case a: ask for the name and sell.
     * • case b: ask for the name and rent.
     * • case c: ask for the name and return.
     * • 3. call close() from the Scanner object.
     */

    /**
     * Name: loadMovies
     * 
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     *                               Inside the function:
     *                               • 1. loads movies from <fileName>.txt.
     *                               • 2. adds all movies to the store object's
     *                               movie field.
     *                               Hint: You will need to 'split' a String into
     *                               three Strings.
     */

}
