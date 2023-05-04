package model;

import java.util.ArrayList;
import java.util.Calendar;

public class UserPremium extends User {
    
    private ArrayList<Product> products;

    public UserPremium(String name, String id, Calendar linkingDate) {
        super(name, id,linkingDate);

        this.products = new ArrayList<Product>();

    }
}
