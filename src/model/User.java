package model;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class User {

    private String id;
    private String name;
    private Calendar linkingDate;

    protected ArrayList<Product> products;
    protected ArrayList<Product> cart;

    private ArrayList<Bill> bills;
    
    public User(String name, String id, Calendar linkingDate){
        this.id = id;
        this.name = name;
        this.linkingDate = Calendar.getInstance();

        products = new ArrayList<Product>();
        cart = new ArrayList<Product>();

        bills = new ArrayList<Bill>();

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

    public abstract String addProducts();

    public void deleteProduct(Product product){
        products.remove(product);
    }

    @Override
    public String toString() {
        return "· "+name+ " | "+id;
    }

    public String addProductToCart(Product product) {
        String msg = "\nProduct pending purchase";

        if(!(cart.contains(product))) {
            cart.add(product);
            msg = "\nProduct added to cart";
        }

        return msg;
    }

    public boolean productsIntersectCart() {
        boolean intersect = false;
        Product product;

        for(int i = 0; i < cart.size() && !intersect ; i++) {
            product = cart.get(i);

            if(products.contains(product)) {
                intersect = true;
            }
        }

        return intersect;
    }

    public String generateBill() {
        Bill bill = new Bill(cart);
        bills.add(bill);
        
        return bill.toString();
    }

    public void updateProductSoldInfo() {
        for(Product product : cart) {
            if(product instanceof Book) {
                ((Book)product).updateCopiesSoldAmount();
            } else if( product instanceof Magazine){
            ((Magazine)product).updateSubscriptionsActivesAmount();
            }
        }
    }

}
