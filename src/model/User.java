package model;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class User {

    private String id;
    private String name;
    private Calendar linkingDate;
    protected ArrayList<Product> products;
    
    public User(String name, String id, Calendar linkingDate){
        this.id = id;
        this.name = name;
        this.linkingDate = Calendar.getInstance();
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
     * @return the linkingDate
     */
    public Calendar getLinkingDate() {
        return linkingDate;
    }

    /**
     * @param linkingDate the linkingDate to set
     */
    public void setLinkingDate(Calendar linkingDate) {
        this.linkingDate = linkingDate;
    }
    
    //-------------------------------------------------
    
    public abstract void addProduct(Product product);

    public void deleteProduct(Product product){
        products.remove(product);
    }


    @Override
    public String toString() {
        return "∙ "+name+ " | "+id;
    }

}
