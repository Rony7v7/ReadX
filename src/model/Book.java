package model;

import java.util.Calendar;

public class Book extends Product {
    private String review;
    private int copiesSoldAmount;

    public Book(String name, int pagesAmount, Calendar publishDate, 
                String url, float price, int pagesReadAmount, String review, int copiesSoldAmount) {

        super(name, pagesAmount, publishDate, url, price, pagesReadAmount);

        this.review = review;
        this.copiesSoldAmount = copiesSoldAmount;
    
    }
    
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

}