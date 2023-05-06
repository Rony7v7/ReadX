package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ReadXSystem {
    
    private ArrayList<User> users;
    private ArrayList<Product> products;

    public ReadXSystem() {
        users = new ArrayList<User>();
        products = new ArrayList<Product>();
    }
    
    public String registerUser(String name, String id, int type){

        String msg = "\nUsuario registrado exitosamente.";
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

    //Register book --- Throws exeception o un metodo de ingresar fecha
    public String registerProduct(String name, int pagesAmount, String publishDateString, String url, 
                                  float price, int pagesReadAmount, String review, int copiesSoldAmount) throws ParseException {
        String msg = "";
        Calendar publishDate = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        publishDate.setTime(format.parse(publishDateString));

        
        products.add(new Book(name, pagesAmount, publishDate, url, price, pagesReadAmount, review, copiesSoldAmount));
    
        return msg;
    }

    //register magazine
    public String registerProduct(String name, int pagesAmount, String publishDateString, String url, float price, 
                                  int pagesReadAmount, int subscriptionsActivesAmount, int issueFrecuency) throws ParseException {
        String msg = "";
        Calendar publishDate = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        publishDate.setTime(format.parse(publishDateString));

        products.add(new Magazine(name, pagesAmount, publishDate, url, price, pagesReadAmount, 
                                  subscriptionsActivesAmount, issueFrecuency));
    
        return msg;
    }


}
