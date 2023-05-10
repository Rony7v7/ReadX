package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Bill {
    
    private User owner;
    private ArrayList<Product> products;
    private Calendar initDate;
    private Double totalAmount;

    public Bill(User owner, ArrayList<Product> products) {
        this.owner = owner;
        this.products = products;
        this.initDate = Calendar.getInstance();

        for(int i = 0; i< products.size(); i++){
            this.totalAmount += products.get(i).getPrice();
        } 
        
    }

    @Override
    public String toString() {
        return  "ReadX Bill"+"\n"+
                "Owner: " + owner.getName() + "\n\n"+
                "Products\n " + products.toString() + "\n";
    }
    
}
