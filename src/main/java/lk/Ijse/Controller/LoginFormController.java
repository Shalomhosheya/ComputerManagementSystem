package lk.Ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.Ijse.Dto.CusDto;
import lk.Ijse.Model.Usermodel;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFormController {


    public TextField LgtextFieldUsername;
    public TextField LgtextfieldPass;

    public Button LgCreateBtn;
    public Button LgLoginBtn;
    @FXML
    private BorderPane rootbode;
    public TextField txtUserNAme;

    Usermodel usermodel = new Usermodel();

    public void CreateAxxount(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/CreateAccount.fxml"));
        Stage stage = (Stage) rootbode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void ProceedToDashboard(ActionEvent event) throws IOException {

        if (LgtextfieldPass.getText().isEmpty() || txtUserNAme.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Error in Entered Data").show();
        } else {
            try {
                CusDto cusDto = usermodel.CheckData(txtUserNAme.getText());

                boolean checkData = false;
                if(txtUserNAme.getText().equals(cusDto.getUsername()) && cusDto.getPassword().equals( LgtextfieldPass.getText())){
                    checkData=true;
                }
                if (checkData) {
                    Parent root = FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"));
                    Stage stage = (Stage) rootbode.getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setTitle(".......DASHBOARD.......");
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    stage.show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Invalid Username or Password").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Invalid Username or Password").show();
            }
        }
    }

    }

