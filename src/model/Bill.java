package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Bill {
    
    private ArrayList<Product> products;
    private Calendar initDate;
    private Double totalAmount;

    public Bill(ArrayList<Product> products) {
        this.products = products;
        this.initDate = Calendar.getInstance();
        this.totalAmount = 0.0;

        for(Product product : products){
            this.totalAmount += product.getPrice();
        } 
        
    }

    @Override
    public String toString() {

        String text = "\n=============================================\n"+
                        "                 READX INVOICE               \n"+
                        "=============================================\n"+
                        "DATE OF ISSUE: "+initDate.getTime()+"\n"+
                        "=============================================\n"+
                        "                   PRODUCTS                  \n"+
                        "=============================================\n";

        for(Product product : products) {
            text += product.toString()+"\n\n";
        }

        text +=         "=============================================\n"+
                        "                 TOTAL TO PAY                \n"+
                        "=============================================\n"+
                        "TOTAL: $"+totalAmount+"\n";

        return text;
    }
    
}
