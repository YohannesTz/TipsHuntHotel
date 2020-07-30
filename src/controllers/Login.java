package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.ibex.nestedvm.util.Platform;
import util.Util;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton signin;
    @FXML
    private JFXButton signup;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Util util = new Util();
        signin.setOnAction(e -> {
            util.loadnewwindow("/fxml/mainpage.fxml", "Home", false, false, true);
            Util.closeWindow(signin);
        });
    }
}
