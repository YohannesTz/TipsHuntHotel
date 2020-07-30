package controllers;

import Models.Dish;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import util.Databasehandler;

import java.net.URL;
import java.util.ResourceBundle;

public class Restaurant implements Initializable {

    @FXML
    private TableView<Dish> table_view;

    @FXML
    private TableColumn<Dish, String> namecol;

    @FXML
    private TableColumn<Dish, String> codecol;

    @FXML
    private TableColumn<Dish, Boolean> typecol;

    @FXML
    private TableColumn<Dish, Integer> pricecol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initCol();
        loadData();
    }

    private void initCol() {
        namecol.setCellValueFactory(new PropertyValueFactory<>("dishname"));
        codecol.setCellValueFactory(new PropertyValueFactory<>("dishcode"));
        typecol.setCellValueFactory(new PropertyValueFactory<>("type"));
        pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    private void loadData() {
        Databasehandler dbhandler = Databasehandler.getInstance();
        table_view.getItems().addAll(dbhandler.getAllDishes());
    }
}
