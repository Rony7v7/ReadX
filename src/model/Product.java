package model;

import java.util.Calendar;

/**
 * The abstract class representing a product.
 * A product has a name, pages amount, publish date, URL, price, pages read amount, and ID.
 * It provides methods to retrieve and modify these attributes.
 * This class serves as a base class for specific product types, such books and magazines.
 */
public abstract class Product {

    protected String name;
    protected int pagesAmount;
    protected Calendar publishDate;
    protected String url;
    protected double price;
    protected int pagesReadAmount;
    protected String id;

    /**
     * Constructs a Product object with the given name, pages amount, publish date, URL, and price.
     *
     * @param name         The name of the product.
     * @param pagesAmount  The amount of pages in the product.
     * @param publishDate  The publish date of the product.
     * @param url          The URL of the product.
     * @param price        The price of the product.
     */
    public Product(String name, int pagesAmount, Calendar publishDate, String url, double price) {
        this.name = name;
        this.pagesAmount = pagesAmount;
        this.publishDate = publishDate;
        this.url = url;
        this.price = price;
        this.pagesReadAmount = 0;
    }

    /**
     * Returns the product's name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product's name.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the product's pages amount.
     * 
     * @return the pagesAmount
     */
    public int getPagesAmount() {
        return pagesAmount;
    }

    /**
     * Sets the product's pages amount.
     * 
     * @param pagesAmount the pagesAmount to set
     */
    public void setPagesAmount(int pagesAmount) {
        this.pagesAmount = pagesAmount;
    }

    /**
     * Returns the product's pages read amount.
     * 
     * @return the pagesReadAmount
     */
    public int getPagesReadAmount() {
        return pagesReadAmount;
    }

    /**
     * Sets the product's pages read amount.
     * 
     * @param pagesReadAmount the pagesReadAmount to set
     */
    public void updatePagesReadAmount(int newPages) {
        this.pagesReadAmount += newPages;
    }

    /**
     * Returns the product's price.
     * 
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the product's price.
     * 
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Returns the product's publish date.
     * 
     * @return the publishDate
     */
    public Calendar getPublishDate() {
        return publishDate;
    }

    /**
     * Sets the product's publish date.
     * 
     * @param publishDate the publishDate to set
     */
    public void setPublishDate(Calendar publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * Returns the product's URL.
     * 
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the product's URL.
     * 
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Returns the product's ID.
     * 
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the product's ID.
     * 
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    //---------------------------------

    /**
     * Generates an ID for the product.
     *
     * @return The generated ID.
     */
    public abstract String generateId();

}
