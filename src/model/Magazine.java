

package model;

import java.util.Calendar;

public class Magazine extends Product {

    private int subscriptionsActivesAmount;
    private int issueFrecuency;
    private int category;
    private String id;

    public Magazine(String name, int pagesAmount, Calendar publishDate, String url, float price, int category,int issueFrecuency) {

        super(name, pagesAmount, publishDate, url, price);
        
        this.category = category;
        this.subscriptionsActivesAmount = 0;
        this.issueFrecuency = issueFrecuency;
    }
    
    /**
     * @return the subscriptionsActivesAmount
     */
    public int getSubscriptionsActivesAmount() {
        return subscriptionsActivesAmount;
    }

    /**
     * @param subscriptionsActivesAmount the subscriptionsActivesAmount to set
     */
    public void setSubscriptionsActivesAmount(int subscriptionsActivesAmount) {
        this.subscriptionsActivesAmount = subscriptionsActivesAmount;
    }

    /**
     * @return the category
     */
    public int getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(int category) {
        this.category = category;
    }

    /**
     * @return the issueFrecuency
     */
    public int getIssueFrecuency() {
        return issueFrecuency;
    }

    /**
     * @param issueFrecuency the issueFrecuency to set
     */
    public void setIssueFrecuency(int issueFrecuency) {
        this.issueFrecuency = issueFrecuency;
    }

}
