package lk.Ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lk.Ijse.Dto.CusDto;
import lk.Ijse.Model.Usermodel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class  CreateAccountcontroller {

    public BorderPane rootNode;


    @FXML
    private TextField Rg_emailfield;

    @FXML
    private TextField RgtextfieldPass;
    @FXML
    private TextField Rg_telephonenum;

    @FXML
    private TextField RgtextfieldUsername;
    @FXML
    private TextField Rg_Id;

    Usermodel usermodel = new Usermodel();
    private javafx.event.ActionEvent ActionEvent;


    public void Backtologin(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/LoginForm.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void Build(ActionEvent event) throws IOException {
        boolean Isvalid = Validation();
        if (Isvalid) {
            if (Rg_Id.getText().isEmpty() || Rg_telephonenum.getText().isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "empty").show();
                return;
            }
            int id = Integer.parseInt(Rg_Id.getText());
            String username = RgtextfieldUsername.getText();
            String email = Rg_emailfield.getText();
            String password = RgtextfieldPass.getText();
            int number = Integer.parseInt(Rg_telephonenum.getText());


            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "empty").show();
                return;
            }

            try {
                boolean Issaved = usermodel.saveUser(new CusDto(id, username, email, password, number));
                if (Issaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "create account sucessfully").show();
                    Backtologin(ActionEvent);
                } else {
                    new Alert(Alert.AlertType.ERROR, "Recheck your entered information").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Duplicate Data entered").show();
            }
        }
    }

    public boolean Validation() {
        String email = Rg_emailfield.getText();
        boolean emailCheck = Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", email);

        if (!emailCheck) {
            new Alert(Alert.AlertType.ERROR, "Email does not match").show();
            return false;
        }

        String tel = Rg_telephonenum.getText();
        boolean phoneNumberCheck = Pattern.matches("[0-9]{10}", tel);

        if (!phoneNumberCheck) {
            new Alert(Alert.AlertType.ERROR, "Phone number should be a 10-digit numeric value").show();
            return false;
        }

        return true;
    }
}
