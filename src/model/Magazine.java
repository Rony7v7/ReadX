package model;

import java.util.Calendar;

public class Magazine extends Product {

    private int subscriptionsActivesAmount;
    private int issueFrecuency;
    private int category;

    public Magazine(String name, int pagesAmount, Calendar publishDate, String url, float price, int category,int issueFrecuency) {

        super(name, pagesAmount, publishDate, url, price);
        
        this.category = category;
        this.subscriptionsActivesAmount = 0;
        this.issueFrecuency = issueFrecuency;
        super.id = generateId();
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
     * sum 1 to subscriptionsActivesAmount
     */
    public void updateSubscriptionsActivesAmount() {
        subscriptionsActivesAmount++;
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

    //-------------------------------------------------

    @Override
    public String generateId() {
        String alphanumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String id = "";

          for(int i = 0; i < 3;i++) {
              id += alphanumeric.charAt((int)(Math.random()*alphanumeric.length()));
  
          }
        return id;
    }

    @Override
    public String toString() {
        return    "· Name:               " + name +
                "\n· Amount of pages:    " + pagesAmount +
                "\n· Publish date:       " + publishDate.get(Calendar.YEAR)+"/"+publishDate.get(Calendar.MONTH)+"/"+publishDate.get(Calendar.DAY_OF_MONTH)+
                "\n· URL:                " + url+
                "\n· Subscription price: " + price+
                "\n· Category:           " + category+
                "\n· Issue frecuency:    " + issueFrecuency;
    }

}
