import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import models.Movie;
import models.Store;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n********************JAVA VIDEO STORE********************\n");



        // Movies
        Store store = new Store();
        Movie firstMovie = new Movie("Star Wars I.", "Blue-Ray", 8.8, true );
        Movie secondMovie = new Movie("Game of Thrones", "Blue-Ray", 9.8, true );
        Movie thirdMovie = new Movie("Predator", "DVD", 8.8, true );

        // Add movies
        store.addMovie(firstMovie);
        store.addMovie(secondMovie);
        store.addMovie(thirdMovie);

        chooseOption(scan, store);


    }

    private static void chooseOption(Scanner scan, Store store) {
        System.out.println("What would you like to do?\n\na) Buy Movie\nb) Rent Movie\nc) Return Movie");
        String userChoice = scan.nextLine();
        switch (userChoice) {
            case "a":
                // Buy
                System.out.println("Type a movie title!");
                String typedMovieTitle = scan.nextLine();
                Movie foundMovie = store.getMovie(typedMovieTitle);
                System.out.println("\nThe movie: " + foundMovie.getName() + " is in stock!\n");

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
            case "b":
                // Rent
                System.out.println("Type a movie title!");
                String typedMovieTitleRent = scan.nextLine();
                Movie foundMovieRent = store.getMovie(typedMovieTitleRent);
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






























    /**
     * Name: manageMovies
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) purchase b) rent c) return d) exit.
     *   •        case a: ask for the name and sell.
     *   •        case b: ask for the name and rent.
     *   •        case c: ask for the name and return.
     *   • 3. call close() from the Scanner object.
     */


    /**
     * Name: loadMovies
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads movies from <fileName>.txt.
     *   • 2. adds all movies to the store object's movie field.
     *        Hint: You will need to 'split' a String into three Strings.
     */

}
