package util;

import Models.Dish;
import Models.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Databasehandler {
    private static Databasehandler databasehandler;
    private String url = System.getenv("APPDATA") + "/tipshunthotel";
    private static final String DB_URL = "jdbc:sqlite:database.db";
    private static Connection connection = null;
    private static Statement statement = null;

    private Databasehandler() {
        createConnection();
        setupRoomsTable();
        setupRestaurantTable();
    }

    public static Databasehandler getInstance() {
        if (databasehandler == null) {
            databasehandler = new Databasehandler();
        }
        return databasehandler;
    }

    private void createConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupRestaurantTable() {
        String createrestaurnattable = "CREATE TABLE RESTAURANT " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT  NOT NULL," +
                "CODE CHAR(50) NOT NULL," +
                "TYPE TEXT," +
                "PRICE INT NOT NULL)";
        try {
            statement = connection.createStatement();

            DatabaseMetaData dbdata = connection.getMetaData();
            ResultSet tables = dbdata.getTables(null, null, "RESTAURANT", null);
            if (tables.next()) {
                System.out.println("Table restaurant exists.");
            } else {
                statement.execute(createrestaurnattable);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //0 is equal to false and 1 is equal to true
    private void setupRoomsTable() {
        String createRoomstable = "CREATE TABLE `ROOMS` (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ROOMNUMBER INT NOT NULL," +
                "HASAC INT DEFAULT 1, " +
                "CAPACITY INT NOT NULL," +
                "ISBOOKED INT DEFAULT 0);";
        System.out.println(createRoomstable);

        try {
            statement = connection.createStatement();

            DatabaseMetaData dbdata = connection.getMetaData();
            ResultSet tables = dbdata.getTables(null, null, "ROOMS", null);
            if (tables.next()) {
                System.out.println("Table rooms exists.");
            } else {
                statement.execute(createRoomstable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addRoom(Room room) {
        String insertRoom = "INSERT INTO ROOMS (ROOMNUMBER, HASAC, CAPACITY, ISBOOKED)" +
                "VALUES (" +
                "'" + room.getRoomnumber() + "'," +
                "'" + room.isHasac() + "'," +
                "'" + room.getCapacity() + "'," +
                "'" + room.isStatus() + "'" +
                ");";

        System.out.println(insertRoom);
        try {
            statement = connection.createStatement();
            statement.executeUpdate(insertRoom);
            System.out.println("Operation done successfully! ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addDish(Dish dish) {
        String insertDish = "INSERT INTO `RESTAURANT` (NAME, CODE, TYPE, PRICE)" +
                "VALUES (" +
                "'" + dish.getDishname() + "'," +
                "'" + dish.getDishcode() + "'," +
                "'" + getValueasInt(dish.getType()) + "'," +
                "'" + dish.getPrice() + "'" +
                ");";
        System.out.println(insertDish);
        try {
            statement = connection.createStatement();
            statement.executeUpdate(insertDish);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeRoom(int roomnumber) {
        String removeroom = "DELETE FROM `ROOMS` WHERE `ROOMNUMBER` = " + roomnumber + ";";
        System.out.println(removeroom);
        try {
            statement = connection.createStatement();
            statement.execute(removeroom);
            //    return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // return false;
    }

    public List<Room> getAllRooms() {
        List<Room> resultrooms = new ArrayList<>();
        String getAllrooms = "SELECT * FROM ROOMS;";
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(getAllrooms);
            while (rs.next()) {
                System.out.println(rs.toString());
                int roomnumber = rs.getInt("ROOMNUMBER");
                boolean hasac = rs.getBoolean("HASAC");
                int capacity = rs.getInt("CAPACITY");
                boolean status = rs.getBoolean("ISBOOKED");
                System.out.println("--->" + roomnumber + " - " + hasac + " - " + capacity + " - " + status + " - ");
                Room room = new Room(roomnumber, hasac, capacity, status);
                System.out.println(room.toString());
                resultrooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(resultrooms.size());
        return resultrooms;
    }

    public List<Dish> getAllDishes() {
        List<Dish> resultDishes = new ArrayList<>();
        String getAllDishes = "SELECT * FROM `RESTAURANT`;";
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(getAllDishes);
            while (rs.next()) {
                System.out.println(rs.toString());
                String dishname = rs.getString("NAME");
                String dishcode = rs.getString("CODE");
                boolean type = rs.getBoolean("TYPE");
                int price = rs.getInt("PRICE");

                Dish newDish = new Dish(dishname, dishcode, type, price);
                resultDishes.add(newDish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultDishes;
    }

    //0 is equal to false and 1 is equal to true
    public int getValueasInt(boolean input) {
        return input ? 1 : 0;
    }
}
