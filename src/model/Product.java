package model;

import java.util.Calendar;

public abstract class Product {

    private String name;
    private int pagesAmount;
    private Calendar publishDate;
    private String url;
    private float price;
    int pagesReadAmount;

    public Product(String name, int pagesAmount, Calendar publishDate, String url, float price, int pagesReadAmount) {
        this.name = name;
        this.pagesAmount = pagesAmount;
        this.publishDate = publishDate;
        this.url = url;
        this.price = price;
        this.pagesReadAmount = pagesReadAmount;
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the pagesAmount
     */
    public int getPagesAmount() {
        return pagesAmount;
    }

    /**
     * @param pagesAmount the pagesAmount to set
     */
    public void setPagesAmount(int pagesAmount) {
        this.pagesAmount = pagesAmount;
    }

    /**
     * @return the pagesReadAmount
     */
    public int getPagesReadAmount() {
        return pagesReadAmount;
    }

    /**
     * @param pagesReadAmount the pagesReadAmount to set
     */
    public void setPagesReadAmount(int pagesReadAmount) {
        this.pagesReadAmount = pagesReadAmount;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the publishDate
     */
    public Calendar getPublishDate() {
        return publishDate;
    }

    /**
     * @param publishDate the publishDate to set
     */
    public void setPublishDate(Calendar publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }


}
