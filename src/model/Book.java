package model;

import java.util.Calendar;

public class Book extends Product {
    
    private int genre;
    private String review;
    private int copiesSoldAmount;

    public Book(String name, int pagesAmount, Calendar publishDate, String url, float price,int genre, String review) {

        super(name, pagesAmount, publishDate, url, price);

        this.genre = genre;
        this.review = review;
        this.copiesSoldAmount = 0;
        super.id = generateId();
    
    }
    
    /**
     * @return the genre
     */
    public int getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(int genre) {
        this.genre = genre;
    }

    /**
     * 
     * @return the review
     */
    public String getReview() {
        return review;
    }

    /**
     * @param review the review to set
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * @return the copiesSoldAmount
     */
    public int getCopiesSoldAmount() {
        return copiesSoldAmount;
    }

    /**
     * @param copiesSoldAmount the copiesSoldAmount to set
     */
    public void setCopiesSoldAmount(int copiesSoldAmount) {
        this.copiesSoldAmount = copiesSoldAmount;
    }

    /**
     * Sum 1 to copies
     */
    public void updateCopiesSoldAmount(){
        copiesSoldAmount++;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    //------------------------------------------------

    @Override
    public String generateId() {
        String hexadecimal = "0123456789ABCDEF";
        String id = "";

          for(int i = 0; i < 3;i++) {
              id += hexadecimal.charAt((int)(Math.random()*hexadecimal.length()));
  
          }
        return id;
    }

    @Override
    public String toString() {
        return    "· Name:               " + name +
                "\n· Amount of pages:    " + pagesAmount +
                "\n· Publish date:       " + publishDate.get(Calendar.DAY_OF_MONTH)+"/"+publishDate.get(Calendar.MONTH)+"/"+publishDate.get(Calendar.YEAR)+
                "\n· URL:                " + url+
                "\n· Selling price:      " + price+
                "\n· Genre:              " + genre+
                "\n· Review:             " + review;
    }

}