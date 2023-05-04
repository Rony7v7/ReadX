package model;

import java.util.Calendar;

public abstract class User {

    private String id;
    private String name;
    private Calendar linkingDate;
    
    
    public User(String name, String id, Calendar linkingDate){
        this.id = id;
        this.name = name;
        this.linkingDate = Calendar.getInstance();
    }

}
