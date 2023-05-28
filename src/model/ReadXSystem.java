package model;

import java.util.ArrayList;

import java.text.SimpleDateFormat;
import java.text.ParsePosition;
import java.util.Calendar;

/**
 * This class represents a controller system.
 * It provides functionalities for manage users, managing products,
 * making purchases, generating reports, and mainly to manage the system.
 */
public class ReadXSystem {
    
    private ArrayList<User> users;
    private ArrayList<Product> products;

    public ReadXSystem() {
        users = new ArrayList<User>();
        products = new ArrayList<Product>();
    }

    //----------- REQUIERMENTS -----------------
    
    /**
     * Registers a new user with the given name, ID, and type.
     * 
     * @param name  The name of the user.
     * @param id    The ID of the user.
     * @param type  The type of the user.
     * @return A success message indicating the user registration.
     */
    public String registerUser(String name, String id, int type){

        String msg = "\nUser registered succesfully.";
        Calendar linkingDate = Calendar.getInstance();
        User user = null;

        switch (type) {
            case 1: user = new UserStandard(name, id,linkingDate);
                break;

            case 2: user = new UserPremium(name, id, linkingDate);
                break;
        }

        users.add(user);

        return msg;
    }

    //Register book
    /**
     * Registers a new book with the given details.
     * 
     * @param name The name of the book.
     * @param pagesAmount The number of pages in the book.
     * @param publishDateString The publish date of the book in string format.
     * @param url The URL of the book.
     * @param price The price of the book.
     * @param genre The genre of the book.
     * @param review The review of the book.
     * @return A success message indicating the book registration.
     */
    public String registerProduct(String name, int pagesAmount, String publishDateString, String url,  double price, int genre, String review) {

        String msg = "\nBook registered succesfully";

        Calendar publishDate = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        publishDate.setTime(format.parse(publishDateString,new  ParsePosition(0)));

        
        products.add(new Book(name, pagesAmount, publishDate, url, price, genre, review));
    
        return msg;
    }

    //register magazine
    /**
     * Registers a new magazine with the given details.
     * 
     * @param name The name of the magazine.
     * @param pagesAmount The number of pages in the magazine.
     * @param publishDateString The publish date of the magazine in string format.
     * @param url The URL of the magazine.
     * @param price The price of the magazine.
     * @param category The category of the magazine.
     * @param issueFrecuency The issue frequency of the magazine.
     * @return A success message indicating the magazine registration.
     */
    public String registerProduct(String name, int pagesAmount, String publishDateString, String url, double price, int category,int issueFrecuency) {

        String msg = "\nMagazine registered succesfully";

        Calendar publishDate = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        publishDate.setTime(format.parse(publishDateString, new  ParsePosition(0)));

        products.add(new Magazine(name, pagesAmount, publishDate, url, price, category,issueFrecuency));
    
        return msg;
    }

    /**
     * Initializes the system by registering users and products.
     */
    public void initSystem() {
        
        registerUser("UserStandard", "1", 1);
        registerUser("UserPremium", "2", 2);
        registerUser("UserPremiumTestLibrary", "3", 2);

        for(int i = 0; i < 26; i++) {
            registerProduct("Book"+i, 100, ("01/01/200"+i), "www.urlB"+i,i*10 ,((int) (Math.random() * 3) + 1), "review"+i);
            registerProduct("Magazine"+i, 100, "01/01/200"+i, "www.urlM"+i, i*10, ((int) (Math.random() * 3) + 1), ((int) (Math.random() * 4) + 1));
        }

        for(int i = 0; i < products.size(); i++) {
            addProductToCart(products.get(i).getId(), "3");
        }
        
        searchUserById("3").updateProductSoldInfo();
        purchaseCart("3");

        registerProduct("The Great Gatsby", 300, "01/01/2022", "https://www.example.com/book1", 19.99, 2, "Excellent book, highly recommended.");
        registerProduct("Cien años de soledad", 400, "15/05/2021", "https://www.example.com/book2", 15.99, 1, "A masterpiece of literature.");
        registerProduct("1984", 250, "10/03/2022", "https://www.example.com/book3", 12.99, 3, "A fascinating dystopia.");
        registerProduct("Pride and Prejudice", 350, "20/02/2022", "https://www.example.com/book4", 16.99, 3, "A classic love story.");
        registerProduct("La sombra del viento", 500, "05/11/2021", "https://www.example.com/book5", 14.99, 2, "Intrigue and mystery on the streets of Barcelona.");

        registerProduct("National Geographic", 100, "01/01/2022", "https://www.example.com/magazine1", 9.99, 1, 2);
        registerProduct("Time", 50, "01/02/2022", "https://www.example.com/magazine2", 7.99, 2, 4);
        registerProduct("Vogue", 120, "01/03/2022", "https://www.example.com/magazine3", 12.99, 3, 3);
        registerProduct("Wired", 80, "01/04/2022", "https://www.example.com/magazine4", 8.99, 1, 1);
        registerProduct("Scientific American", 70, "01/05/2022", "https://www.example.com/magazine5", 10.99, 2, 1);

    }

    /**
     * Modifies a product with the given ID and updated details. If the user dont want to modify a field, he must enter '0'.
     * 
     * @param id The ID of the product to modify.
     * @param name The updated name of the product.
     * @param pagesAmount The updated number of pages in the product.
     * @param publishDateString The updated publish date of the product in string format.
     * @param url The updated URL of the product.
     * @param price The updated price of the product.
     * @param genre The updated genre of the product (applicable for books).
     * @param review The updated review of the product (applicable for books).
     * @param category The updated category of the product (applicable for magazines).
     * @param issueFrecuency The updated issue frequency of the product (applicable for magazines).
     * @return A success message indicating the product modification.
     */
    public String modifyProduct(String id,String name, int pagesAmount, String publishDateString, String url,  float price, int genre, String review, int category,int issueFrecuency) {

        Product product = searchProductById(id);

        if(!(name.equals("0"))) {
            product.setName(name);
        }
        if(!(pagesAmount == 0)) {
            product.setPagesAmount(pagesAmount);
        }
        if(!(publishDateString.equals("0"))) {
            Calendar publishDate = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            publishDate.setTime(format.parse(publishDateString,new  ParsePosition(0)));

            product.setPublishDate(publishDate);
        }
        if(!(url.equals("0"))) {
            product.setUrl(url);
        }
        if(!(price == 0)) {
            product.setPrice(price);
        }

        //modify specific parameters
        if(product instanceof Book) {

            if(!(genre == 0)) {
                ((Book)product).setGenre(genre);
            }
            if(!(review.equals("0"))) {
                ((Book)product).setReview(review);
            }

        } else if(product instanceof Magazine) {

            if(!(category == 0)) {
                ((Magazine)product).setCategory(category);
            }
            if(!(issueFrecuency == 0)) {
                ((Magazine)product).setIssueFrecuency(issueFrecuency);
            }

        } 

        return "\nProduct modified succesfully";
    }

    /**
     * Deletes a product with the given ID.
     * 
     * @param id The ID of the product to delete.
     * @return A success message indicating the product deletion.
     */
    public String deleteProduct(String id) {
        
        Product product = searchProductById(id);

        String msg = "\nId not found";

        if(product != null) {
            products.remove(product);

            for(int i = 0; i < users.size(); i++) {
                users.get(i).deleteProduct(product);
            } 

            msg = "\nProduct deleted succesfully";

        }

        return msg;
    }

    /**
     * Adds a product with the given ID to the cart of a user with the specified ID.
     * 
     * @param productId The ID of the product to add to the cart.
     * @param userId The ID of the user.
     * @return A success message indicating the product addition to the cart.
     */
    public String addProductToCart(String productId, String userId) {
        
        String msg = "\nId not found.";

        Product product = searchProductById(productId);
        User user = searchUserById(userId);

        if(product != null) {
            msg = user.addProductToCart(product);
        }
        
        return msg;
    }

    /**
     * Purchases the products in the cart of a user with the specified ID.
     * 
     * @param userId The ID of the user.
     * @return A success message indicating the purchase of products.
     */
    public String purchaseCart(String userId) {
       
        String msg = "\nYou already own one or more of these products.";
        User user = searchUserById(userId);

        if(user.cart.isEmpty()) {

            msg = "\nThere are not products to purchase";

        }else if(!user.productsIntersectCart()) {

            msg = user.addProducts();

        }
        

        return msg;
    }

    /**
     * Cancels a magazine subscription for a user with the specified ID.
     * 
     * @param userId The ID of the user.
     * @return A success message indicating the cancellation of the magazine subscription.
     */
    public String cancelMagazineSubscription(String userId, String magazineId) {
        String msg = "\nId not found.";
        User user = searchUserById(userId);

        if(user != null) {
            msg = user.cancelMagazineSubscription(magazineId);
        }

        return msg;
    }

    /**
     * This method initializes a reading session with a specific option (A,D) or the product's id or 
     * the product's coordinates
     * @param userId the user's id
     * @param productLink the product's id or coordinates
     * @param option the option to initialize the reading session
     * @return a message indicating the reading session
     */
    public String initReadingSession(String userId, String productLink, char option) {
        String msg = " ";
        Product product = searchProductById(productLink);

        User user = searchUserById(userId);

        if(productLink.contains(",") && !user.hasProduct(product)) {
            product = user.searchProductByCoord(productLink);
        }

        if(product != null) {
            boolean showAds = user instanceof UserStandard;
            msg = user.initReadingSession(product, option, showAds);
        }

        return msg;
    } 

    /**
     * This method returns the user's library in a specifc page
     * @param userId the user's id
     * @param page the page to show
     * @return Library to String
     */
    public String getLibrary(String userId, int page) {
        String msg = "\nId not found.";

        User user = searchUserById(userId);

        if(user != null) {
            msg = user.libraryToString();
        }

        return msg;
    }

    /**
     * This method navigates and validates the user's library inputs
     * @param option the option to navigate (A,D)
     * @param userId the user's id
     * @return Library to String with the option executed
     */
    public String navigateLibrary(String option, String userId) {
        String msg = "\nId not found.";
        User user = searchUserById(userId);

        if(user != null) {
            msg = user.navigateLibrary(option.charAt(0));
        }

        return msg;

    }

    /**
     * This method generates a report depends on the report type
     * @param reportType the report type (1,2,3,4,5)
     * @return the report
     */
    public String generateReports(int reportType){
        String msg = "\nInvalid option";

        switch(reportType) {
            case 1:
                msg = getReportOfTotalPagesReadAmount();
                break;
            case 2:
                msg = getReportOfTheMostGenreAndCategoryRead();
                break;
                
            case 3:
                msg = getTop5BooksAndTop5MagazinesMostRead();
                break;
            
            case 4:
                msg = getReportOfBooksSoldAmountPerGenre();
                break;
            
            case 5:
                msg = getReportOfSubscriptionsActivesAmountInMagazines();
                break;
        }

        return msg;
    }

    /**
     * This method generates a report of the total accumulated number of pages read by product type.
     * @return The report of the total accumulated number of pages read by product type.
     */
    public String getReportOfTotalPagesReadAmount(){
        String report = null;
        
        int totalPagesReadAmountInBook = 0;
        int totalPagesReadAmountInMagazine = 0;


        for(Product product : products){
            if(product instanceof Book) {
                totalPagesReadAmountInBook += product.getPagesReadAmount();
            } else if(product instanceof Magazine) {
                totalPagesReadAmountInMagazine += product.getPagesReadAmount();
            }
        }

        report =    "\n-Total accumulated number of pages read by product type\n"+
                    "\nTotal pages read amount in books: "+totalPagesReadAmountInBook+
                    "\nTotal pages read amount in magazines: "+totalPagesReadAmountInMagazine;

        return report;
    }

    /**
     * This method generates a report of the most read genre and category.
     * @return The report of the most read genre and category.
     */
    public String getReportOfTheMostGenreAndCategoryRead(){
        String report = null;

        int genreSienceFiction = 0;
        int genreFantasy = 0;
        int genreHistoricalNovel = 0;
        
        int categoryVarieties = 0;
        int categoryDesign = 0;
        int categoryScientific = 0;

        int genreMax = 0;
        int categoryMax = 0;

        String genreMaxName;
        String categoryMaxName;

        for(Product product : products) {

            if(product instanceof Book) {

                switch(((Book) product).getGenre()) {
                    case SCIENCE_FICTION: genreSienceFiction += product.getPagesReadAmount();
                        break;
                    case FANTASY: genreFantasy += product.getPagesReadAmount();
                        break;
                    case HISTORICAL_NOVEL: genreHistoricalNovel += product.getPagesReadAmount();
                        break;
                }

            } else if(product instanceof Magazine) {

                switch(((Magazine)product).getCategory()) {
                    case VARIETIES: categoryVarieties += product.getPagesReadAmount();
                        break;
                    case DESIGN: categoryDesign += product.getPagesReadAmount();
                        break;
                    case SCIENTIFIC: categoryScientific += product.getPagesReadAmount();
                        break;
                }

            }

        }

        genreMax = Math.max(genreSienceFiction, Math.max(genreFantasy, genreHistoricalNovel));
        categoryMax = Math.max(categoryVarieties, Math.max(categoryDesign, categoryScientific));
        
        //Find the max genre
        if(genreMax == genreSienceFiction) {
            genreMaxName = "Science Fiction";
        } else if(genreMax == genreFantasy) {
            genreMaxName = "Fantasy";
        } else {
            genreMaxName = "Historical Novel";
        }

        //Find the max category
        if(categoryMax == categoryVarieties) {
            categoryMaxName = "Varieties";
        } else if(categoryMax == categoryDesign) {
            categoryMaxName = "Design";
        } else {
            categoryMaxName = "Scientific";
        }

        report = "\n-Report of the most genre and category read\n"+
                 "\nGenre "+genreMaxName+" with "+ genreMax+" pages read."+
                 "\nCategory "+categoryMaxName+" with "+ categoryMax+" pages read.";

        return report;
    }

    /**
     * This method generates a report of the top 5 most read books and magazines.
     * @return The report of the top 5 most read books and magazines.
     */
    public String getTop5BooksAndTop5MagazinesMostRead() {
        String report1 = "";
        String report2 = "";

        int booksIndex = 0;
        int magazinesIndex = 0;

        sortProductsByPagesReadAmount();

        for(Product product : products) {
            if(product instanceof Book && booksIndex < 5) {
                booksIndex++;
                report1 += "\n"+booksIndex+". "+product.getName()+" | "+product.getPagesReadAmount();

            } else if(product instanceof Magazine && magazinesIndex < 5) {
                magazinesIndex++;
                report2 += "\n"+magazinesIndex+". "+product.getName()+" | "+product.getPagesReadAmount();
            }
        }

        String report = "\n-Top 5 Books and Magazines most read\n"+
                        "\nTop 5 Books most read" + 
                        report1 + "\n" +  
                        "\nTop 5 Magazines most read" + 
                        report2;
    
        return report;
    }

    /**
     * This method generates a report of the number of books sold per genre.
     * @return The report of the number of books sold per genre.
     */
    public String getReportOfBooksSoldAmountPerGenre() {
        String report = null;

        int genreSienceFiction = 0;
        int genreFantasy = 0;
        int genreHistoricalNovel = 0;

        for(Product product : products) {

            if(product instanceof Book) {

                switch (( ( Book )( product ) ).getGenre()) {
                    case SCIENCE_FICTION: genreSienceFiction += ((Book)(product)).getCopiesSoldAmount();
                        break;
                
                    case FANTASY: genreFantasy += ((Book)(product)).getCopiesSoldAmount();
                        break;

                    case HISTORICAL_NOVEL: genreHistoricalNovel += ((Book)(product)).getCopiesSoldAmount();
                        break;
                }
            }
        }

        report = "\n-Copies sold of books per genre\n"+
                 "\nScience Fiction: "+genreSienceFiction+
                 "\nFantasy: "+genreFantasy+
                 "\nHistorical Novel: "+genreHistoricalNovel;

        return report;
    }

    /**
     * This method generates a report of the active subscriptions amount in magazines per category.
     * @return The report of the active subscriptions amount in magazines per category.
     */
    public String getReportOfSubscriptionsActivesAmountInMagazines() {
        String report = null;

        int categoryVarieties = 0;
        int categoryDesign = 0;
        int categoryScientific = 0;

        for(Product product : products) {

            if(product instanceof Magazine) {

                switch (( ( Magazine )( product ) ).getCategory()) {
                    case VARIETIES: categoryVarieties += ((Magazine)(product)).getSubscriptionsActivesAmount();
                        break;
                
                    case DESIGN: categoryDesign += ((Magazine)(product)).getSubscriptionsActivesAmount();
                        break;

                    case SCIENTIFIC: categoryScientific += ((Magazine)(product)).getSubscriptionsActivesAmount();
                        break;
                }
            }
        }

        report = "\n-Subscriptions acitves amount of magazines per category\n"+
                 "\nVarieties: "+ categoryVarieties+
                 "\nDesign: "+ categoryDesign+
                 "\nScientific: "+ categoryScientific;

        return report;
    }

    //------------------- OTHERS -------------------

    /**
     * This method searches for a product by its ID.
     * @param id The ID of the product to search for.
     * @return The product found, or null if not found.
     */
    public Product searchProductById(String id) {
        Product product = null;
        boolean isFound =  false;

        for(int i = 0; i < products.size() && !isFound; i++) {
            if(products.get(i).getId().equals(id)){
                product = products.get(i);
                isFound = true;
            }
                
        }

        return product;
    }

    /**
     * This method generates a string containing information about all products.
     * @return The string containing information about all products.
     */
    public String getProductsInfo() {
        String productsInfo = "";

        for(Product product : products) {
            productsInfo += "> "+product.getName()+" | "+product.getId()+"\n";
        }

        return productsInfo;
    }

    /**
     * This method retrieves the full information of a product by its ID.
     * @param id The ID of the product.
     * @return The full information of the product.
     */
    public String getFullProductInfo(String id) {
        Product product = searchProductById(id);

        return product.toString();
    }
    
    /**
     * This method determines the type of a product based on its ID.
     * @param id The ID of the product.
     * @return The type of the product: 0 for unknown, 1 for Book, 2 for Magazine.
     */
    public int getProductType(String id) {
        int type = 0;
        Product product = searchProductById(id);

        if(product instanceof Book) {
            type = 1;
        } else if(product instanceof Magazine) {
            type = 2;
        }

        return type;
    }

    /**
     * This method searches for a user by their ID.
     * @param id The ID of the user to search for.
     * @return The user found, or null if not found.
     */
    public User searchUserById(String id) {
        User user = null;
        Boolean isFound = false;

        for(int i = 0; i < users.size() && !isFound; i++) {
            if(users.get(i).getId().equals(id)){
                user = users.get(i);
            }
        }

        return user;
    }

    /**
     * This method generates a string containing information about all users.
     * @return The string containing information about all users.
     */
    public String getUsersInfo() {
        String usersInfo = ""; 

        for(int i = 0; i < users.size(); i++) {
            usersInfo += users.get(i).toString()+"\n";
        }

        return usersInfo;
    }

    /**
     * This method checks if a user has a specific product.
     * @param userId The ID of the user.
     * @param productId The ID of the product.
     * @return True if the user has the product, false otherwise.
     */
    public Boolean userHasProduct(String userId, String productId) {
        Boolean hasProduct = false;
        User user = searchUserById(userId);

        if(user != null) {
            hasProduct = user.hasProduct(searchProductById(productId));
        }

        return hasProduct;

    }

    /**
     * This method retrieves a string representation of the magazines owned by a user.
     * @param userId The ID of the user.
     * @return The string representation of the user's magazines.
     */
    public String getUserMagazines(String userId) {
        String magazines = "";
        User user = searchUserById(userId);

        if(user != null) {
            magazines = user.getMagazinesToString();
        }

        return magazines;
    }

    /**
     * This method sorts the products by the number of pages read in descending order.
     */
    public void sortProductsByPagesReadAmount() {
        products.sort((product1, product2) -> Integer.compare(product2.getPagesReadAmount(), product1.getPagesReadAmount()));
    }

}
