package lk.Ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StorageformController {
    @FXML
    private AnchorPane rootNode;
    @FXML
    void backToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle(".......DASHBOARD.......");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
