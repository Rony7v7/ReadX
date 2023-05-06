

package model;

import java.util.Calendar;

public class Magazine extends Product {

    private int subscriptionsActivesAmount;
    private int issueFrecuency;

    public Magazine(String name, int pagesAmount, Calendar publishDate, String url, float price, 
                    int pagesReadAmount, int subscriptionsActivesAmount, int issueFrecuency) {

        super(name, pagesAmount, publishDate, url, price, pagesReadAmount);
        
        this.subscriptionsActivesAmount = subscriptionsActivesAmount;
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
