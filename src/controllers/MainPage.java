package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import util.Util;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPage implements Initializable {

    @FXML
    private JFXButton room_reservation;
    @FXML
    private JFXButton restaurant;
    @FXML
    private JFXButton settings;
    @FXML
    private JFXButton about;
    @FXML
    private JFXButton addRoom;
    @FXML
    private JFXButton addDish;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Util util = new Util();
        room_reservation.setOnAction(e -> {
            util.loadnewwindow("/fxml/room_reservation.fxml", "Room reservation", true, true, true);
        });
        restaurant.setOnAction(e -> {
            util.loadnewwindow("/fxml/restaurant.fxml", "Restaurant", true, false, true);
        });
        about.setOnAction(e -> {
            util.loadnewwindow("/fxml/about.fxml", "About", false, true, true);
        });
        addDish.setOnAction(e -> {
            util.loadnewwindow("/fxml/add_dish.fxml", "Add Dish", false, true, true);
        });
        addRoom.setOnAction(e -> {
            util.loadnewwindow("/fxml/add_room.fxml", "Add Room", false, true, true);
        });
    }
}
