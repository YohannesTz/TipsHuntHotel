package Models;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Room {
/*    private int roomnumber;
    private boolean hasac;
    private int capacity;
    private boolean status;*/

    private SimpleIntegerProperty roomnumber;
    private SimpleBooleanProperty hasac;
    private SimpleIntegerProperty capacity;
    private SimpleBooleanProperty status;

/*
    public Room(int roomnumber, boolean hasac, int capacity, boolean status) {
        this.roomnumber = roomnumber;
        this.hasac = hasac;
        this.capacity = capacity;
        this.status = status;
    }
*/

    public Room(int roomnumber, boolean hasac, int capacity, boolean status) {
        this.roomnumber = new SimpleIntegerProperty(roomnumber);
        this.hasac = new SimpleBooleanProperty(hasac);
        this.capacity = new SimpleIntegerProperty(capacity);
        this.status = new SimpleBooleanProperty(status);
    }

    public int getRoomnumber() {
        return roomnumber.get();
    }

    public SimpleIntegerProperty roomnumberProperty() {
        return roomnumber;
    }

    public void setRoomnumber(int roomnumber) {
        this.roomnumber.set(roomnumber);
    }

    public boolean isHasac() {
        return hasac.get();
    }

    public SimpleBooleanProperty hasacProperty() {
        return hasac;
    }

    public void setHasac(boolean hasac) {
        this.hasac.set(hasac);
    }

    public int getCapacity() {
        return capacity.get();
    }

    public SimpleIntegerProperty capacityProperty() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity.set(capacity);
    }

    public boolean isStatus() {
        return status.get();
    }

    public SimpleBooleanProperty statusProperty() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status.set(status);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomnumber=" + roomnumber.get() +
                ", hasac=" + hasac.get() +
                ", capacity=" + capacity.get() +
                ", status=" + status.get() +
                '}';
    }
}
