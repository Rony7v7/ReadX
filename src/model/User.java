package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * An abstract class representing a User.
 * It contains information about the user's ID, name, and linking date.
 * It also maintains lists of products, cart, bills, and reading sessions associated with the user.
 * Additionally, it holds a reference to the user's library.
 */
public abstract class User {

    private String id;
    private String name;
    private Calendar linkingDate;

    protected ArrayList<Product> products;
    protected ArrayList<Product> cart;

    private ArrayList<Bill> bills;

    private ArrayList<ReadingSession> readingSessions;

    protected Library library;
    
    /**
     * Constructs a User object with the given name, ID, and linking date.
     *
     * @param name        The name of the user.
     * @param id          The ID of the user.
     * @param linkingDate The linking date of the user.
     */
    public User(String name, String id, Calendar linkingDate){
        this.id = id;
        this.name = name;
        this.linkingDate = Calendar.getInstance();

        products = new ArrayList<Product>();
        cart = new ArrayList<Product>();

        bills = new ArrayList<Bill>();

        readingSessions = new ArrayList<ReadingSession>();

        library = new Library(name, products);

    }

    /**
     * Returns the user's ID.
     * 
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * sets the user's ID.
     * 
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the user's name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the user's linking date.
     * 
     * @return the linkingDate
     */
    public Calendar getLinkingDate() {
        return linkingDate;
    }

    /**
     * Sets the user's linking date.
     * 
     * @param linkingDate the linkingDate to set
     */
    public void setLinkingDate(Calendar linkingDate) {
        this.linkingDate = linkingDate;
    }
    
    /**
     * Returns the user's products
     * 
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Retrieves a string representation of magazines in the user's product list.
     *
     * @return A string containing information about the magazines in the user's product list.
     */
    public String getMagazinesToString(){
        String magazinesInfo = " \n";
        for(Product product : products) {
            if(product instanceof Magazine) {
                magazinesInfo += "> "+product.getName()+" | "+product.getId()+"\n";
            }
        }

        return magazinesInfo;
    }
    
    //-------------------------------------------------

    /**
     * Retruns a string representation of the user's library.
     *
     * @return A string representation of the user's library.
     */
    public String libraryToString(){
        if(!products.isEmpty()) {
            library.updateProducts();
        }
        
        return library.toString();
    }
    
    /**
     * Navigates through the user's library based on the given option.
     *
     * @param option The navigation option ('A' for previous page, 'D' for next page, 'S' for returning to the main menu).
     * @return A message indicating the result of the navigation.
     */
    public String navigateLibrary(char option){

        String msg = "\nInvalid option.";

        switch(option) {
            case 'A':
                library.previousPage();
                msg = "\nPrevious page.";
                break;
            case 'D':
                library.nextPage();
                msg = "\nNext page.";
                break;
            case 'S':
                msg = "\nReturning to main menu.";
                break;
        }

        return msg;
    }

    /**
     * Adds products to the user's collection.
     *
     * @return A string representation of the added products.
     */
    public abstract String addProducts();

    /**
     * Deletes the specified product from the user's collection, and updates the library.
     *
     * @param product The product to delete.
     */
    public void deleteProduct(Product product){
        products.remove(product);
        library.updateProducts();
    }

    /**
     * Returns a string representation of the user.
     *
     * @return A string representation of the user.
     */
    @Override
    public String toString() {
        return "· "+name+ " | "+id;
    }

    /**
     * Adds the specified product to the user's cart for purchase.
     *
     * @param product The product to add to the cart.
     * @return A message indicating the result of adding the product to the cart.
     */
    public String addProductToCart(Product product) {
        String msg = "\nProduct pending purchase";

        if(!(cart.contains(product))) {
            cart.add(product);
            msg = "\nProduct added to cart";
        }

        return msg;
    }

    /**
     * Checks if there are any products common between the user's product list and the cart.
     *
     * @return true if there are intersecting products, false otherwise.
     */
    public boolean productsIntersectCart() {
        boolean intersect = false;
        Product product;

        for(int i = 0; i < cart.size() && !intersect ; i++) {
            product = cart.get(i);

            if(products.contains(product)) {
                intersect = true;
                cart.clear();
            }
        }

        return intersect;
    }

    /**
     * Generates a bill for the products in the user's cart.
     *
     * @return A string representation of the generated bill.
     */
    public String generateBill() {
        Bill bill = new Bill(cart);
        bills.add(bill);
        
        return bill.toString();
    }

    /**
     * Updates the sales information for the products in the user's cart.
     */
    public void updateProductSoldInfo() {
        for(Product product : cart) {
            if(product instanceof Book) {
                ((Book)product).updateCopiesSoldAmount();
            } else if( product instanceof Magazine){
                ((Magazine)product).updateSubscriptionsActivesAmount();
            }
        }
    }

    /**
     * Cancels a magazine subscription based on the given ID.
     *
     * @param id The ID of the magazine subscription to cancel.
     * @return A message indicating the result of canceling the subscription.
     */
    public String cancelMagazineSubscription(String id) {
        String msg = "\nId not found.";
        Product magazine = searchMagazineById(id);

        if(magazine != null) {
            products.remove(magazine);
            msg = "\nSubscription canceled :(.";
        }
        
        return msg;
    }

    /**
     * Initializes a reading session for the specified product.
     *
     * @param product   The product for the reading session.
     * @param option    The reading session option ('A' for previous page, 'D' for next page, other for current page).
     * @param showAds   A flag indicating if ads should be shown during the reading session.
     * @return A message containing the reading session information.
     */
    public String initReadingSession(Product product, char option, boolean showAds) {

        ReadingSession readingSession = searchReadingSessionByProduct(product);
        
        String msg = null;

        
        if(readingSession == null && hasProduct(product)) {
            readingSession = new ReadingSession(product);
            readingSessions.add(readingSession);
            
        }
        
        switch (option) {
            case 'D':
                readingSession.nextPage();
                msg = readingSession.toString();
                break;
                
                case 'A':
                readingSession.previousPage();
                msg = readingSession.toString();
                break;
                
                default:
                msg = readingSession.toString();
                break;
            }
            
            if(showAds) {
                String[] ads =  {"Subscribe to Combo Plus and get Disney+ and Star+ at an incredible price!",
                            "Now your pets have a favorite app: Laika. The best products for your furry friend.",
                            "It's our anniversary! Visit your nearest Éxito and be surprised with the best offers."};
    
                int currentPage = readingSession.getCurrentPage();
    
                if(currentPage == 1 || (currentPage%5==0 && readingSession.getProduct() instanceof Magazine) || (currentPage%20==0 && readingSession.getProduct() instanceof Book)) {
                    msg = "\n"+ads[(int) (Math.random() * 3)] + msg;       
                }
    
            }
            
        return msg;
    }

    /**
     * Searches for a reading session associated with the specified product.
     *
     * @param product The product to search the reading session for.
     * @return The reading session associated with the product, or null if not found.
     */
    public ReadingSession searchReadingSessionByProduct(Product product) {
        boolean isFound = false;
        ReadingSession readingSession = null;

        for (int  i = 0; i < readingSessions.size() && !isFound; i++) {
            if(readingSessions.get(i).getProduct() == product) {
                readingSession = readingSessions.get(i);
                isFound = true;
            }
        }
        
        return readingSession;

    }

    /**
     * Searches for a product with the specified ID in the user's product list.
     *
     * @param id The ID of the product to search for.
     * @return The product with the specified ID, or null if not found.
     */
    public Product searchProductById(String id) {
        Product product = null;
        boolean isFound = false;

        for(int i = 0; i < products.size() && !isFound; i++) {
            if(products.get(i).getId().equals(id)) {
                product = products.get(i);
                isFound = true;
            }
        }

        return product;
    }

    /**
     * Checks if the user has the specified product in their product list.
     *
     * @param product The product to check for.
     * @return true if the user has the product, false otherwise.
     */
    public boolean hasProduct(Product product){
        return products.contains(product);
    }

    /**
     * Searches for a magazine with the specified ID in the user's product list.
     *
     * @param id The ID of the magazine to search for.
     * @return The magazine with the specified ID, or null if not found.
     */
    public Product searchMagazineById(String id) {
        Product magazine = null;

        for(Product product : products) {
            if(product instanceof Magazine && product.getId().equals(id)) {
                magazine = product;
            }
        }

        return magazine;
    }

    /**
     * Searches for a product in the user's library based on the given coordinate.
     *
     * @param productCoord The coordinate of the product to search for.
     * @return The product found at the specified coordinate, or null if not found.
     */
    public Product searchProductByCoord(String productCoord) {
        Product product = null;
        int row;
        int column;

        if(productCoord.charAt(1) == ',') {
            row = Integer.parseInt(productCoord.split(",")[0]);
            column = Integer.parseInt(productCoord.split(",")[1]);

            if(row >= 0 && row < 5 && column >= 0 && column < 5) {
                product = searchProductById(library.getProductIdByCoord(row, column));
            }

        }

        return product;
    }

}
