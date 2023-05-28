package model;

import java.util.Calendar;

/**
 * This class epresents a premium user.
 */
public class UserPremium extends User {

    /**
     * Constructs a UserPremium object with the specified name, ID, and linking date.
     *
     * @param name        The name of the user.
     * @param id          The ID of the user.
     * @param linkingDate The linking date of the user.
     */
    public UserPremium(String name, String id, Calendar linkingDate) {
        super(name, id,linkingDate);
    }

    /**
     * Adds the products in the cart to the user's products list.
     * 
     * @return the bill
     */
    @Override
    public String addProducts() {

        String bill = generateBill();

        products.addAll(cart);
        
        cart.clear();

        return bill;

    }

}
