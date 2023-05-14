package model;

import java.util.ArrayList;

import java.text.SimpleDateFormat;
import java.text.ParsePosition;
import java.util.Calendar;


public class ReadXSystem {
    
    private ArrayList<User> users;
    private ArrayList<Product> products;

    public ReadXSystem() {
        users = new ArrayList<User>();
        products = new ArrayList<Product>();
    }
    
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
    public String registerProduct(String name, int pagesAmount, String publishDateString, String url,  float price, int genre, String review) {

        String msg = "\nBook registered succesfully";

        Calendar publishDate = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        publishDate.setTime(format.parse(publishDateString,new  ParsePosition(0)));

        
        products.add(new Book(name, pagesAmount, publishDate, url, price, genre, review));
    
        return msg;
    }

    //register magazine
    public String registerProduct(String name, int pagesAmount, String publishDateString, String url, float price, int category,int issueFrecuency) {

        String msg = "\nMagazine registered succesfully";

        Calendar publishDate = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        publishDate.setTime(format.parse(publishDateString, new  ParsePosition(0)));

        products.add(new Magazine(name, pagesAmount, publishDate, url, price, category,issueFrecuency));
    
        return msg;
    }

    public void initSystem() {

        for(int i = 0; i < 10; i++) {
            registerUser("User"+i, "id"+i, (i%2 == 0)? 2 : 1);
            
            registerProduct("Book"+i, (i*10), "01/01/2000", "www.urlB"+i, (i*10), (i > 3)? (Integer)(i/3):i, "review"+i);
            registerProduct("Magazine"+i, (i*10), "01/01/2000", "www.urlM"+i, (i*10), (i > 3)? (Integer)(i/3):i, (i > 4)? (Integer)(i/4):i);
        }

        registerUser("UserStandard", "1", 1);
        registerUser("UserPremium", "2", 2);

    }

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

    public String addProductToCart(String productId, String userId) {
        
        String msg = "\nId not found.";

        Product product = searchProductById(productId);
        User user = searchUserById(userId);

        if(product != null) {
            msg = user.addProductToCart(product);
        }
        
        return msg;
    }

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

    public String initReadingSession(String userId, String productId, char option) {
        String msg = "\nId not found.";

        Product product = searchProductById(productId);
        User user = searchUserById(userId);

        if(product != null) {
            msg = user.initReadingSession(product, option);
        }

        return msg;
    } 

    

    //---------------------------------------------------

    public Product searchProductById(String id) {
        Product product = null;
        boolean isFound =  false;

        for(int i = 0; i < products.size() && !isFound; i++) {
            if(products.get(i).getId().equals(id)){
                product = products.get(i);
            }
                
        }

        return product;
    }

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

    public String getProductsInfo() {
        String productsInfo = "";

        for(int i = 0; i < products.size(); i++) {
            productsInfo += "> "+products.get(i).getName()+" | "+products.get(i).getId()+"\n";
        }

        return productsInfo;
    }

    public String getFullProductInfo(String id) {
        Product product = searchProductById(id);

        return product.toString();
    }

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

    public String getUsersInfo() {
        String usersInfo = ""; 

        for(int i = 0; i < users.size(); i++) {
            usersInfo += users.get(i).toString()+"\n";
        }

        return usersInfo;
    }

}
