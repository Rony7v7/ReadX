package model;

import java.util.Calendar;

public class UserStandard extends User {

    public UserStandard(String name, String id, Calendar linkingDate) {
        super(name, id, linkingDate);

        // this.products = super.products;
        // this.cart = super.cart;
    }

    @Override
    public String addProducts() {
        String msg = "\nInserta factura ";

        int booksAmount = 0;
        int magazinesAmount = 0;


        //count books amount (max 5) & count magazines amount (max 2)
        for(Product product : products) {

            if(product instanceof Book) {
                booksAmount ++;
            } else if(product instanceof Magazine) {
                magazinesAmount ++;
            }
        }

        //fill products with cart

        for(Product product : cart) {

            if(product instanceof Book && booksAmount < 5) {
                products.add(product);
                booksAmount ++;
            } else if(product instanceof Magazine && magazinesAmount < 3) {
                products.add(product);
                magazinesAmount ++;
            }
        }

        cart.clear();

        return msg;
    }

}
