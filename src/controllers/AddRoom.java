package controllers;

import Models.Room;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import org.ibex.nestedvm.util.Platform;
import util.Databasehandler;

import java.net.URL;
import java.util.ResourceBundle;

public class AddRoom implements Initializable {

    @FXML
    private JFXTextField roomnumber;

    @FXML
    private JFXRadioButton withac;

    @FXML
    private ToggleGroup roomtype;

    @FXML
    private JFXRadioButton withoutac;
    @FXML
    private JFXTextField roomcpacity;
    @FXML
    private JFXButton addroom;
    @FXML
    private JFXButton cancle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cancle.setOnAction(e -> {
            ((Stage) cancle.getScene().getWindow()).close();
        });
        addroom.setOnAction(e -> addroomtoDb());
    }

    private void addroomtoDb() {
        Databasehandler dbhandler = Databasehandler.getInstance();
        int roomno = Integer.parseInt(roomnumber.getText());
        int roomcap = Integer.parseInt(roomcpacity.getText());

        Room newRoom = new Room(roomno, getRoomType(), roomcap, true);
        System.out.println("the news room " + newRoom.toString());
        dbhandler.addRoom(newRoom);
        ((Stage) cancle.getScene().getWindow()).close();
    }

    private boolean getRoomType() {
        System.out.println(withac.isSelected());
        return withac.isSelected();
    }
}
