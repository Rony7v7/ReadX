package model;

import java.util.Calendar;

/**
 * Magazine class represents a magazine product.
 * It extends the Product class and adds additional properties specific to magazines.
 */
public class Magazine extends Product {

    private int subscriptionsActivesAmount;
    private IssueFrecuency issueFrecuency;
    private Category category;

    /**
     * Constructs a Magazine object with the given parameters.
     *
     * @param name                     The name of the magazine.
     * @param pagesAmount              The number of pages in the magazine.
     * @param publishDate              The publish date of the magazine.
     * @param url                      The URL of the magazine.
     * @param price                    The price of the magazine.
     * @param category                 The category of the magazine (1 for Varieties, 2 for Design, 3 for Scientific).
     * @param issueFrecuency           The issue frequency of the magazine (1 for Diary, 2 for Weekly, 3 for Monthly, 4 for Yearly).
     */
    public Magazine(String name, int pagesAmount, Calendar publishDate, String url, double price, int category,int issueFrecuency) {

        super(name, pagesAmount, publishDate, url, price);
        
        switch(category) {
            case 1:
                this.category = Category.VARIETIES;
                break;
            case 2:
                this.category = Category.DESIGN;
                break;
            case 3:
                this.category = Category.SCIENTIFIC;
                break;
        }
        
        this.subscriptionsActivesAmount = 0;
        
        switch (issueFrecuency) {
            case 1:
                this.issueFrecuency = IssueFrecuency.DIARY;
                break;
            case 2:
                this.issueFrecuency = IssueFrecuency.WEEKLY;
                break;
            case 3: 
                this.issueFrecuency = IssueFrecuency.MONTHLY;
                break;
            case 4:
                this.issueFrecuency = IssueFrecuency.YEARLY;
                break;
        }

        super.id = generateId();
    }
    
    /**
     * Returns the number of active subscriptions of the magazine.
     * 
     * @return the subscriptionsActivesAmount
     */
    public int getSubscriptionsActivesAmount() {
        return subscriptionsActivesAmount;
    }

    /**
     * Sets the number of active subscriptions of the magazine.
     * 
     * @param subscriptionsActivesAmount the subscriptionsActivesAmount to set
     */
    public void setSubscriptionsActivesAmount(int subscriptionsActivesAmount) {
        this.subscriptionsActivesAmount = subscriptionsActivesAmount;
    }

    /**
     * Increments the number of active subscriptions of the magazine by 1.
     */
    public void updateSubscriptionsActivesAmount() {
        subscriptionsActivesAmount++;
    }

    /**
     * returns the category of the magazine.
     * 
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the category of the magazine.
     * 
     * @param category the category to set
     */
    public void setCategory(int category) {
        switch(category) {
            case 1:
                this.category = Category.VARIETIES;
                break;
            case 2:
                this.category = Category.DESIGN;
                break;
            case 3:
                this.category = Category.SCIENTIFIC;
                break;
        }
    }

    /**
     * Returns the issue frequency of the magazine. 
     * 
     * @return the issueFrecuency
     */
    public IssueFrecuency getIssueFrecuency() {
        return issueFrecuency;
    }

    /**
     * Sets the issue frequency of the magazine.
     *  
     * @param issueFrecuency the issueFrecuency to set
     */
    public void setIssueFrecuency(int issueFrecuency) {
        switch (issueFrecuency) {
            case 1:
                this.issueFrecuency = IssueFrecuency.DIARY;
                break;
            case 2:
                this.issueFrecuency = IssueFrecuency.WEEKLY;
                break;
            case 3: 
                this.issueFrecuency = IssueFrecuency.MONTHLY;
                break;
            case 4:
                this.issueFrecuency = IssueFrecuency.YEARLY;
                break;
        }
    }

    /**
     * Returns the id of the magazine.
     * 
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the magazine.
     * 
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    //-------------------------------------------------

    /**
     * Generates a unique identifier for the magazine.
     *
     * @return The generated unique identifier.
     */
    @Override
    public String generateId() {
        String alphanumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String id = "";

          for(int i = 0; i < 3;i++) {
              id += alphanumeric.charAt((int)(Math.random()*alphanumeric.length()));
  
          }
        return id;
    }

    /**
     * Returns a string representation of the magazine object.
     *
     * @return A string representation of the magazine.
     */
    @Override
    public String toString() {
        return    "· Name:               " + name +
                "\n· Amount of pages:    " + pagesAmount +
                "\n· Publish date:       " + publishDate.get(Calendar.DAY_OF_MONTH)+"/"+publishDate.get(Calendar.MONTH)+"/"+publishDate.get(Calendar.YEAR)+
                "\n· URL:                " + url+
                "\n· Subscription price: " + price+
                "\n· Category:           " + category+
                "\n· Issue frecuency:    " + issueFrecuency;
    }

}
