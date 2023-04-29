package model;

public abstract class User {
    private String id;
    private String name;
    
    public User(String name, String id){
        this.id = id;
        this.name = name;
    }

}
