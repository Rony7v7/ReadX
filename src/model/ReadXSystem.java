package model;

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


}
