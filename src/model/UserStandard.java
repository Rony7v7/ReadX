package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * This class represents a standard user.
 */
public class UserStandard extends User implements Limited {

    /**
     * Constructs a UserStandard object with the given name, ID, and linking date.
     *
     * @param name        The name of the user.
     * @param id          The ID of the user.
     * @param linkingDate The linking date of the user.
     */
    public UserStandard(String name, String id, Calendar linkingDate) {
        super(name, id, linkingDate);
    }

    /**
     * Adds the products from the cart to the user's list of products and generates a bill.
     * Returns an unsuccessful purchase message if the maximum product capacity is reached.
     *
     * @return The generated bill or an unsuccessful purchase message.
     */
    @Override
    public String addProducts() {
        boolean canPurchase = verifyPurchasingCapacity();
        String bill = "\nUnsuccessful purchase, maximum product capacity reached.";

        if(canPurchase) {
            products.addAll(cart);
            
            bill = generateBill();
        }

        cart.clear();

        return bill;
    }

    /**
     * Verifies if the user has the purchasing capacity based on the maximum allowed quantities of books and magazines.
     *
     * @return true if the user can make the purchase, false otherwise.
     */
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

    /**
     * Counts the amount of books and magazines in either the user's list of products or the cart, depending on the list type.
     *
     * @param listType The type of list to count the products from (0 for user's products, 1 for cart).
     * @return An array containing the amount of books and magazines, respectively.
     */
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
