package model;

import java.util.Calendar;

public class UserPremium extends User {

    public UserPremium(String name, String id, Calendar linkingDate) {
        super(name, id,linkingDate);
    }

    @Override
    public String addProducts() {
        String msg = "\n*Inserta factura*";

        products.addAll(cart);
        //Generate bill

        cart.clear();

        return msg;
    }

}
