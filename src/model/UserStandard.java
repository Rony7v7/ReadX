package model;

import java.util.ArrayList;
import java.util.Calendar;

public class UserStandard extends User {
    
    private ArrayList<Product> products;

    public UserStandard(String name, String id, Calendar linkingDate) {
        super(name, id, linkingDate);

        this.products = new ArrayList<Product>();
    }


}
