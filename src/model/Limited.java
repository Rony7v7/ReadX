package model;

public interface Limited {

    boolean verifyPurchasingCapacity();

    int[] countAmountOfProduct(int listType); //0 -> userProducts   1 -> Cart

}
