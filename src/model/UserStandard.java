package model;

import java.util.ArrayList;
import java.util.Calendar;

public class UserStandard extends User implements Limited {

    public UserStandard(String name, String id, Calendar linkingDate) {
        super(name, id, linkingDate);
    }

    @Override
    public String addProducts() {
        boolean canPurchase = verifyPurchasingCapacity();
        String bill = "\nUnsuccessful purchase, maximum product capacity reached.";

        if(canPurchase) {
            products.addAll(cart);
            
            library.updateProducts();

            bill = generateBill();
        }

        cart.clear();

        return bill;
    }


    @Override
    public boolean verifyPurchasingCapacity() {
        boolean canPurchase = true;

        int[] userProductsAmount = countAmountOfProduct(0);
        int[] cartProductsAmount = countAmountOfProduct(1);

        int booksAmountUser = userProductsAmount[0];
        int booksAmountCart = cartProductsAmount[0];

        int magazinesAmountUser = userProductsAmount[1];
        int magazinesAmountCart = cartProductsAmount[1];

        if((booksAmountUser + booksAmountCart > 5) || (magazinesAmountUser + magazinesAmountCart > 2)) {
            canPurchase = false;
        }

        return canPurchase;
    }

    @Override
    public int[] countAmountOfProduct(int listType) {
        ArrayList<Product> productsToCount = (listType == 0) ? products : cart ;
        
        int booksAmount = 0;
        int magazinesAmount = 0;

        int[] productsAmount = new int[2];

        for (Product product : productsToCount) {
            if(product instanceof Book) {
                booksAmount ++;
            }else if(product instanceof Magazine) {
                magazinesAmount++;
            }
        }

        productsAmount[0] = booksAmount;
        productsAmount[1] = magazinesAmount;


        return productsAmount;
    }

}
