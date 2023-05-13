package model;

import java.util.Calendar;

public class UserPremium extends User {

    public UserPremium(String name, String id, Calendar linkingDate) {
        super(name, id,linkingDate);
    }

    @Override
    public String addProducts() {

        String bill = generateBill();

        products.addAll(cart);
        cart.clear();

        return bill;

    }

}
