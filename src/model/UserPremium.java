package model;

import java.util.Calendar;

public class UserPremium extends User {

    public UserPremium(String name, String id, Calendar linkingDate) {
        super(name, id,linkingDate);
    }

    @Override
    public void addProducts() {

        products.addAll(cart);
        //Generate bill

        cart.clear();

    }

}
