package lk.Ijse.Controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController  {
    @FXML
    private AnchorPane rootnode;

    @FXML
    void DirectCoolingTools(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/CoolingToolsForm.fxml"));
        Stage stage = (Stage) rootnode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Cooling tools");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void DirectPowersupply(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/PowersupplyForm.fxml"));
        Stage stage = (Stage) rootnode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("PowerSupply Form");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void DirectProcessor(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/ProcessorForm.fxml"));
        Stage stage = (Stage) rootnode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Processor Form");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void DirectRAM(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/RAMForm.fxml"));
        Stage stage = (Stage) rootnode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("RAM Form");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void DirectRGB(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/RGBForm.fxml"));
        Stage stage = (Stage) rootnode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("RGB Form");
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    void DirectStorage(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/StorageForm.fxml"));
        Stage stage = (Stage) rootnode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setTitle("Storage Form");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void DirectVGA(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/VGAForm.fxml"));
        Stage stage = (Stage) rootnode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("VGA Form");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void DirectWishlist(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/WishlistForm.fxml"));
        Stage stage = (Stage) rootnode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Wishlist Form");
        stage.centerOnScreen();
        stage.show();

    }



}
