package Models;

public class Room {
    private int roomnumber;
    private boolean hasac;
    private int capacity;
    private boolean status;

    public Room(int roomnumber, boolean hasac, int capacity, boolean status) {
        this.roomnumber = roomnumber;
        this.hasac = hasac;
        this.capacity = capacity;
        this.status = status;
    }

    public int getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }

    public boolean isHasac() {
        return hasac;
    }

    public void setHasac(boolean hasac) {
        this.hasac = hasac;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomnumber=" + roomnumber +
                ", hasac=" + hasac +
                ", capacity=" + capacity +
                ", status=" + status +
                '}';
    }
}
