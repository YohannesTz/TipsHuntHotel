package controllers;

import Models.Dish;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import util.Databasehandler;
import util.Util;

import java.net.URL;
import java.util.ResourceBundle;

public class AddDish implements Initializable {

    @FXML
    private JFXTextField dishname;

    @FXML
    private JFXRadioButton fastfood;

    @FXML
    private ToggleGroup dishtype;

    @FXML
    private JFXRadioButton contiental;

    @FXML
    private JFXTextField dishcode;

    @FXML
    private JFXTextField price;

    @FXML
    private JFXButton add_dish;

    @FXML
    private JFXButton cancle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cancle.setOnAction(e -> {
            Util.closeWindow(cancle);
        });
        add_dish.setOnAction(e -> addDishtoDB());
    }

    private void addDishtoDB() {
        Databasehandler databasehandler = Databasehandler.getInstance();
        String dishnameText = dishname.getText();
        String dishCodeText = dishcode.getText();
        int priceText = Integer.parseInt(price.getText());

        Dish newDish = new Dish(dishnameText, dishCodeText, getDishType(), priceText);
        databasehandler.addDish(newDish);
        Util.closeWindow(cancle);
    }

    private boolean getDishType() {
        return contiental.isSelected();
    }
}
