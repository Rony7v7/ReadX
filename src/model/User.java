package model;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class User {

    private String id;
    private String name;
    private Calendar linkingDate;

    protected ArrayList<Product> products;
    protected ArrayList<Product> cart;

    private ArrayList<Bill> bills;

    private ArrayList<ReadingSession> readingSessions;

    protected Library library;
    
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
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the linkingDate
     */
    public Calendar getLinkingDate() {
        return linkingDate;
    }

    /**
     * @param linkingDate the linkingDate to set
     */
    public void setLinkingDate(Calendar linkingDate) {
        this.linkingDate = linkingDate;
    }
    
    /**
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

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
    public String libraryToString(){
        if(!products.isEmpty()) {
            library.updateProducts();
        }
        
        return library.toString();
    }
    
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

    public abstract String addProducts();

    public void deleteProduct(Product product){
        products.remove(product);
        library.updateProducts();
    }

    @Override
    public String toString() {
        return "· "+name+ " | "+id;
    }

    public String addProductToCart(Product product) {
        String msg = "\nProduct pending purchase";

        if(!(cart.contains(product))) {
            cart.add(product);
            msg = "\nProduct added to cart";
        }

        return msg;
    }

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

    public String generateBill() {
        Bill bill = new Bill(cart);
        bills.add(bill);
        
        return bill.toString();
    }

    public void updateProductSoldInfo() {
        for(Product product : cart) {
            if(product instanceof Book) {
                ((Book)product).updateCopiesSoldAmount();
            } else if( product instanceof Magazine){
                ((Magazine)product).updateSubscriptionsActivesAmount();
            }
        }
    }

    public String cancelMagazineSubscription(String id) {
        String msg = "\nId not found.";
        Product magazine = searchMagazineById(id);

        if(magazine != null) {
            products.remove(magazine);
            msg = "\nSubscription canceled :(.";
        }
        
        return msg;
    }

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

    public boolean hasProduct(Product product){
        return products.contains(product);
    }

    public Product searchMagazineById(String id) {
        Product magazine = null;

        for(Product product : products) {
            if(product instanceof Magazine && product.getId().equals(id)) {
                magazine = product;
            }
        }

        return magazine;
    }

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
