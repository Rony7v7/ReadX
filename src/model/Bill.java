package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Constructs a Bill object with the given list of products.
 * Calculates the total amount based on the prices of the products.
 *
 * @param products The list of products included in the bill.
 */
public class Bill {
    
    private ArrayList<Product> products;
    private Calendar initDate;
    private Double totalAmount;

    /**
     * Constructs a Bill object with the given list of products.
     * Calculates the total amount based on the prices of the products.
     *
     * @param products The list of products included in the bill.
     */
    public Bill(ArrayList<Product> products) {
        this.products = products;
        this.initDate = Calendar.getInstance();
        this.totalAmount = 0.0;

        for(Product product : products){
            this.totalAmount += product.getPrice();
        } 
        
    }

    /**
     * Returns a string representation of the Bill object.
     * The string includes the date of issue, the list of products, and the total amount to pay.
     *
     * @return A string representation of the Bill object.
     */
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
