package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    // Constr.
    public Movie(String name, String format, double rating, boolean isAvailable) {
        this.name = name;
        this.format = format;
        this.rating = rating;
        // this.sellingPrice = sellingPrice;
        // this.rentalPrice = rentalPrice;
        this.isAvailable = isAvailable;
    }

    // Copy Constr.
    public Movie(Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.isAvailable = source.isAvailable;

        setPrice();
    }

    // Get
    public String getName() {
        return this.name;
    }

    public String getFormat() {
        return this.format;
    }

    public double getRating() {
        return this.rating;
    }

    public double getSellingPrice() {
        setPrice();
        return sellingPrice;
    }

    public double getRentalPrice() {
        setPrice();
        return this.rentalPrice;
    }

    public boolean getAvailability() {
        return this.isAvailable;
    }

    // Set
    public void setName(String name) {
        this.name = name;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setRentalPrice(Double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setAvailability(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable(){
        return this.isAvailable;
    }

    // Methods
    public void setPrice() {
        if (this.format.equalsIgnoreCase("DVD")) {
            this.sellingPrice = 2.25;
            this.rentalPrice = 0.99;
        }
        else if(this.format.equalsIgnoreCase("Blue-Ray")){
            this.sellingPrice = 4.25;
            this.rentalPrice = 1.99;
        }
    }

}
