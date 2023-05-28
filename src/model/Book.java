package model;

import java.util.Calendar;

/**
 * The `Book` class represents a book product.
 * It extends the `Product` class and adds specific properties and methods related to books.
 * 
 * The properties of a book include its genre, review, and the number of copies sold.
 * Books can be identified by their unique ID generated upon creation.
 * 
 * This class provides methods to get and set the book's genre, review, copies sold amount, and ID.
 * It also includes a method to update the copies sold amount by incrementing it by 1.
 * 
 * The `Book` class overrides the `generateId()` and `toString()` methods from the `Product` class.
 * 
 * Genre values:
 * - 1: Science Fiction
 * - 2: Fantasy
 * - 3: Historical Novel
 */
public class Book extends Product {
    
    private Genre genre;
    private String review;
    private int copiesSoldAmount;

    /**
     * Constructs a Book object with the given parameters.
     * 
     * @param name The name of the book.
     * @param pagesAmount The number of pages in the book.
     * @param publishDate The publish date of the book.
     * @param url The URL of the book.
     * @param price The selling price of the book.
     * @param genre The genre of the book.
     * @param review The review of the book.
     */
    public Book(String name, int pagesAmount, Calendar publishDate, String url, double price,int genre, String review) {

        super(name, pagesAmount, publishDate, url, price);

        switch(genre) {
            case 1:
                this.genre = Genre.SCIENCE_FICTION;
                break;
            case 2:
                this.genre = Genre.FANTASY;
                break;
            case 3: 
                this.genre = Genre.HISTORICAL_NOVEL;
                break;
        }
        
        this.review = review;
        this.copiesSoldAmount = 0;
        super.id = generateId();
    
    }
    
    /**
     * Returns the genre of the book.
     * 
     * @return genre
     */
    public Genre getGenre() {
        return this.genre;
    }

    /**
     * Sets the genre of the book.
     * 
     * @param genre the genre to set
     */
    public void setGenre(int genre) {
        switch(genre) {
            case 1:
                this.genre = Genre.SCIENCE_FICTION;
                break;
            case 2:
                this.genre = Genre.FANTASY;
                break;
            case 3: 
                this.genre = Genre.HISTORICAL_NOVEL;
                break;
        }
    }

    /**
     * Returns the review of the book.
     * 
     * @return the review of the book.
     */
    public String getReview() {
        return review;
    }

    /**
     * Sets the review of the book.
     * 
     * @param review the review to set
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * Returns the number of copies sold of the book.
     * 
     * @return the copiesSoldAmount of the book.
     */
    public int getCopiesSoldAmount() {
        return copiesSoldAmount;
    }

    /**
     * Sets the number of copies sold of the book.
     * 
     * @param copiesSoldAmount the copiesSoldAmount to set.
     */
    public void setCopiesSoldAmount(int copiesSoldAmount) {
        this.copiesSoldAmount = copiesSoldAmount;
    }

    /**
     * Increments the number of copies sold of the book by 1.
     */
    public void updateCopiesSoldAmount(){
        copiesSoldAmount++;
    }

    /**
     * Returns the ID of the book.
     * 
     * @return the id of the book.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the book.
     * @param id the id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    //------------------------------------------------

    /**
     * Generates a unique ID for the book.
     * 
     * @return The generated unique ID for the book.
     */
    @Override
    public String generateId() {
        String hexadecimal = "0123456789ABCDEF";
        String id = "";

          for(int i = 0; i < 3;i++) {
              id += hexadecimal.charAt((int)(Math.random()*hexadecimal.length()));
  
          }
        return id;
    }

    /**
     * Returns a string representation of the Book object.
     * 
     * @return A string containing the details of the book.
     */
    @Override
    public String toString() {
        return    "· Name:               " + super.getName() +
                "\n· Amount of pages:    " + pagesAmount +
                "\n· Publish date:       " + publishDate.get(Calendar.DAY_OF_MONTH)+"/"+publishDate.get(Calendar.MONTH)+"/"+publishDate.get(Calendar.YEAR)+
                "\n· URL:                " + url+
                "\n· Selling price:      " + price+
                "\n· Genre:              " + genre+
                "\n· Review:             " + review;
    }

}