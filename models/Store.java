package models;

import java.util.ArrayList;

public class Store {
    ArrayList<Movie> movies = new ArrayList<>();





    public void addMovie(Movie movie) {
        movies.add(movie);
        System.out.println("Movie added...");
    }

    public void getMovieToSetAvailability(String movieName, boolean isAvailableNow){
        movieName = movieName.toLowerCase();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equalsIgnoreCase(movieName)) {
                movies.get(i).setAvailability(isAvailableNow);
            }
        }
    }

    public Movie getMovie(String movieName) throws NullPointerException{
        Movie basicMovie = new Movie("emptyMovie", "basic", 1.1, false);

        // Check if input is empty
        if(movieName.isBlank() || movieName.isEmpty() || movieName == null){
            basicMovie.setName("Empty title was given...");
            return basicMovie;
        }
        // Make user input lowercase
        movieName = movieName.toLowerCase();

        if (movies.size() > 0){
            // Movie currentMovie = movies.get(0);
            for (int i = 0; i < movies.size(); i++) {
                // Lower case searched movie title(s)
                String lowerCasedTitle = movies.get(i).getName().toLowerCase();
                if (lowerCasedTitle.contains(movieName)) {
                    if (movies.get(i).isAvailable()) {
                        // System.out.println("\nThe movie: " + movies.get(i).getName() + " is in stock!\n");
                        return movies.get(i);
                    }
                    else{
                        basicMovie.setName("\n" + movies.get(i).getName() + " is rented.\n");
                        return basicMovie;
                    }
                }
            }
            basicMovie.setName("There is no movie with this title");
            return basicMovie;
        }
        else{
            System.out.println("There is no any movie...");
        }
        return basicMovie;
        
    }

    // Sell Movie
    public void sellMovie(String movieName){
        Movie currentMovie = getMovie(movieName);
        System.out.println("\nYou purchased: " + currentMovie.getName() + " for " + currentMovie.getSellingPrice() + " in " + currentMovie.getFormat() + " format.");
    }
    // Rent Movie
    public void rentMovie(String movieName){
        Movie currentMovie = getMovie(movieName);
        if (currentMovie.isAvailable()){
            currentMovie.setAvailability(false);
            System.out.println("\nYou rented: " + currentMovie.getName() + " for " + currentMovie.getRentalPrice() + " in " + currentMovie.getFormat() + " format.");
        }
        else{
            System.out.println(movieName);
            return;
        }
    }
    // Return movie
    public void returnMovie(String movieName){
        // Lower case useer input movie title
        movieName = movieName.toLowerCase();

        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().toLowerCase().contains(movieName)){
                Movie currentMovie = movies.get(i);
                if (!currentMovie.isAvailable()) {
                    currentMovie.setAvailability(true);
                    System.out.println("\nYou returned: " + currentMovie.getName());
                }
                else{
                    System.out.println("The movie: " + currentMovie.getName() + " is already returned.");
                }
            }
        }
    }
}
