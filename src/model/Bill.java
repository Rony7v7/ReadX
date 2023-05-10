package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Bill {
    
    private User owner;
    private ArrayList<Product> products;
    private Calendar initDate;
    private Double totalAmount;

    public Bill(User owner, ArrayList<Product> products, Calendar initDate, Double totalAmount) {
        this.owner = owner;
        this.products = products;
        this.initDate = initDate;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return  "ReadX Bill"+"\n"+
                "Owner: " + owner.getName() + "\n\n"+
                "Products\n " + products.toString() + "\n";
    }
    
}
