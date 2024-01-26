package lk.Ijse.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lk.Ijse.Dto.Data;
import lk.Ijse.Dto.StorageDto;
import lk.Ijse.Model.StorageModel;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StorageformController {
    @FXML
    private Button Storage_ADDBtn;

    @FXML
    private ComboBox<?> Storage_BrandCombo;

    @FXML
    private TextField Storage_IDTxt;

    @FXML
    private TextField Storage_Pricetxt;

    @FXML
    private TextField Storage_Quantitytxt;

    @FXML
    private ComboBox<?> Storage_StatusCombo;

    @FXML
    private TableView<?> Storage_Table;

    @FXML
    private TableColumn<?, ?> Storage_Table_BName;

    @FXML
    private TableColumn<?, ?> Storage_Table_Price;

    @FXML
    private TableColumn<?, ?> Storage_Table_Quantity;

    @FXML
    private TableColumn<?, ?> Storage_Table_Status;

    @FXML
    private TableColumn<?, ?> Storage_Table_Type;

    @FXML
    private ComboBox<?> Storage_TypeCombo;

    @FXML
    private ImageView Storage_imageViewer;


    @FXML
    private AnchorPane rootNode;


    private Image image;

    Data data = new Data();
    String path = data.path;

    private String[] Typelist ={"HDD","SSD","Nvme SSD"};
    private  String[] brandList={"Samsung","WD","Seagate","Toshiba","Sandisk","Adata"};

    private String[] statusList ={"Avalaible","Not Available"};
    StorageModel storageModel =new StorageModel();
    StorageDto storageDto = new StorageDto();
    @FXML
    void AddtoDatabase(ActionEvent event)  {
        String id = Storage_IDTxt.getText();
        String brand = String.valueOf(Storage_BrandCombo.getSelectionModel().getSelectedItem());
        String type = String.valueOf(Storage_TypeCombo.getSelectionModel().getSelectedItem());
        Double price = Double.valueOf(Storage_Pricetxt.getText());
        int quanity = Integer.parseInt(Storage_Quantitytxt.getText());
        String status = String.valueOf(Storage_StatusCombo.getSelectionModel().getSelectedItem());
        String path = data.path;
        if (path != null) {
            path = path.replace("\\", "\\\\");
        } else {
            // Handle the case where path is null, depending on your requirements.
            // For example, you could set a default value or log a warning.
            System.out.println("Warning: Image path is null.");
        }

        //  String image = Storage_imageViewer.getAccessibleText();

        try {
           boolean check = storageModel.AddTOdataDabase(id,brand,type,price,quanity,status,path);
           if (check){
               new Alert(Alert.AlertType.CONFIRMATION,"SuccessFul").show();
            }else {
               new Alert(Alert.AlertType.ERROR,"").show();
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void inventoryBrandKist(){
        List<String>brandB=new ArrayList<>();
        for (String data : brandList){
            brandB.add(data);
        }
        ObservableList observableList =FXCollections.observableList(brandB);
        Storage_BrandCombo.setItems(observableList);
    }
    public void InventoryType(){
        List<String>typeL=new ArrayList<>();
        for (String data :Typelist){
           typeL.add(data);
        }
        ObservableList listData = FXCollections.observableList(typeL);
        Storage_TypeCombo.setItems(listData);
    }

    public void InventoryStatus(){
        List<String>StatusL = new ArrayList<>();
        for (String data :statusList){
            StatusL.add(data);
        }
        ObservableList observableList = FXCollections.observableList(StatusL);
        Storage_StatusCombo.setItems(observableList);
    }
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

    @FXML
    void ImageViewACT(ActionEvent event) {
        FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("Open Image File", "*png", "*jpg"));

        File file = openFile.showOpenDialog(rootNode.getScene().getWindow());
        if (file != null) {
            data.path = file.getAbsolutePath();
            if (data.path != null && !data.path.isEmpty()) { // Ensure path is not null or empty
                image = new Image(new File(data.path).toURI().toString(), 200, 204, false, true);
                Storage_imageViewer.setImage(image);
            } else {
                // Handle the case where the file path is null or empty
                System.out.println("Error: File path is null or empty");
            }
        } else {
            // Handle the case where the user canceled the file dialog
            System.out.println("User canceled the file dialog");
        }
    }
    public void initialize(){
        InventoryType();
        inventoryBrandKist();
        InventoryStatus();
    }
}
