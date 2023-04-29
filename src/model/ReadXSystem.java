package model;

import java.util.ArrayList;

public class ReadXSystem {
    
    private ArrayList<User> users;
    private ArrayList<Product> products;

    public ReadXSystem() {
        users = new ArrayList<User>();
        products = new ArrayList<Product>();
    }
    
    public String registerUser(String name, String id, int type){
        String msg = "\nUsuario registrado exitosamente.";
        User user = null;

        switch (type) {
            case 1: user = new UserStandard(name, id);
                break;

            case 2: user = new UserPremium(name, id);
                break;
        }

        users.add(user);

        return msg;
    }


}
