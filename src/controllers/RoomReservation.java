package controllers;

import Models.Room;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import util.Databasehandler;

import javax.xml.crypto.Data;
import java.net.URL;
import java.util.ResourceBundle;

public class RoomReservation implements Initializable {

    ObservableList<Room> list = FXCollections.observableArrayList();

    @FXML
    private TableView<Room> roomtableview;

    @FXML
    private TableColumn<Room, String> roomnumbercol;

    @FXML
    private TableColumn<Room, Boolean> typecol;

    @FXML
    private TableColumn<Room, Integer> capacitycol;

    @FXML
    private TableColumn<Room, Boolean> statuscol;

    @FXML
    private MenuItem addroomcontext;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Databasehandler dbhandler = Databasehandler.getInstance();
        addroomcontext.setOnAction(e -> {
            Room room = new Room(103, true, 2, false);
            dbhandler.addRoom(room);
        });
        initColumn();
        loadData();
    }

    private void initColumn() {
        roomnumbercol.setCellValueFactory(new PropertyValueFactory<>("roomnumber"));
        typecol.setCellValueFactory(new PropertyValueFactory<>("Hasac"));
        capacitycol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        statuscol.setCellValueFactory(new PropertyValueFactory<>("Status"));
    }


    private void loadData() {
        Databasehandler dbhandler = Databasehandler.getInstance();
        //list.addAll(dbhandler.getAllRooms());
        roomtableview.getItems().addAll(dbhandler.getAllRooms());
    }
}
