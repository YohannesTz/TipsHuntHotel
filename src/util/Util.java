package util;

import com.sun.tools.javac.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Util {
    public void loadnewwindow(String location, String title, boolean resizable, boolean modal, boolean iswindowed) {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource(location));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle(title);
        stage.setResizable(resizable);
        if (modal) {
            stage.initModality(Modality.APPLICATION_MODAL);
        }
        if (!iswindowed) {
            stage.initStyle(StageStyle.UNDECORATED);
        }
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }

    public static void closeWindow(Node node) {
        ((Stage) node.getScene().getWindow()).close();
    }
}
