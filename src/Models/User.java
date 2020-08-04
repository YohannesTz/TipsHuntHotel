package Models;

public class User {
    private int id;
    private String name;
    private String sirname;
    private int phonenumber;
    private String hashedpassword;

    public User(int id, String name, String sirname, int phonenumber, String hashedpassword) {
        this.id = id;
        this.name = name;
        this.sirname = sirname;
        this.phonenumber = phonenumber;
        this.hashedpassword = hashedpassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSirname() {
        return sirname;
    }

    public void setSirname(String sirname) {
        this.sirname = sirname;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getHashedpassword() {
        return hashedpassword;
    }

    public void setHashedpassword(String hashedpassword) {
        this.hashedpassword = hashedpassword;
    }
}
