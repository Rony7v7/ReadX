package model;

/**
 * The Limited interface represents a contract for users that have limited capacity.
 * Objects that implement this interface should provide methods to verify purchasing capacity
 * and count the amount of products in different types of lists, such as user products and cart.
 */
public interface Limited {

        /**
     * Verifies the purchasing capacity.
     *
     * @return true if the purchasing capacity is valid, false otherwise.
     */
    boolean verifyPurchasingCapacity();

    /**
     * Counts the amount of products in a list specified by the list type.
     *
     * @param listType the type of list to count. 0 for user products, 1 for cart.
     * @return an array of integers that contains the amount of products in the list.
     */
    int[] countAmountOfProduct(int listType); //0 -> userProducts   1 -> Cart

}
