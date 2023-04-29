package model;

import java.util.ArrayList;

public class UserPremium extends User {
    
    private ArrayList<Product> products;

    public UserPremium(String name, String id) {
        super(name, id);

        this.products = new ArrayList<Product>();

    }
}
