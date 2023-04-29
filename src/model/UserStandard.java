package model;

import java.util.ArrayList;

public class UserStandard extends User {
    private ArrayList products;

    public UserStandard(String name, String id) {
        super(name, id);

        this.products = new ArrayList<Product>();
    }


}
