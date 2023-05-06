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
    public String registerProduct(String name, int pagesAmount, String publishDateString, String url,  float price, int pagesReadAmount, int genre, String review) {

        String msg = "\nBook registered succesfully";

        Calendar publishDate = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        publishDate.setTime(format.parse(publishDateString,new  ParsePosition(0)));

        
        products.add(new Book(name, pagesAmount, publishDate, url, price, pagesReadAmount, genre, review, 0));
    
        return msg;
    }

    //register magazine
    public String registerProduct(String name, int pagesAmount, String publishDateString, String url, float price,int pagesReadAmount, int category,int issueFrecuency) {

        String msg = "\nMagazine registered succesfully";

        Calendar publishDate = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        publishDate.setTime(format.parse(publishDateString, new  ParsePosition(0)));

        products.add(new Magazine(name, pagesAmount, publishDate, url, price, pagesReadAmount, 0, category,issueFrecuency));
    
        return msg;
    }


}
