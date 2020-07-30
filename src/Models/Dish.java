package Models;

public class Dish {
    private String dishname;
    private String dishcode;
    private boolean type;
    private int price;

    public Dish(String dishname, String dishcode, boolean type, int price) {
        this.dishname = dishname;
        this.dishcode = dishcode;
        this.type = type;
        this.price = price;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getDishcode() {
        return dishcode;
    }

    public void setDishcode(String dishcode) {
        this.dishcode = dishcode;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
