package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import module.DriverName;
import module.Park;


import java.io.IOException;
import java.util.ArrayList;

import static controller.ParkingFormController.driverList;
import static controller.ParkingFormController.parkList;


public class InParkingController {
    public ComboBox cmbParkingDelivery;
    public TableView tblInParking;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;
    public TableView tblOnDelivery;
    public TableColumn colVehicleNumberTwo;
    public TableColumn colVehicleTypeTwo;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;
    public AnchorPane parkingContext;
    private String type = "In parking";

    static ArrayList<Park> parkArrayList = parkList;
    static ArrayList<DriverName> driverNameArrayList = driverList;
    public void initialize() {
        loadAllVehicle();
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory<>("slotNumber"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory<>("parkedTime"));
        loadAllDriver();
        colVehicleNumberTwo.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colVehicleTypeTwo.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));
        checkResultInComboBox();
        cmbParkingDelivery.getItems().addAll(
                "In Parking", "On Delivery");

        cmbParkingDelivery.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            type = String.valueOf(newValue);
            checkResultInComboBox();
        });
    }

    private void loadAllDriver() {
        ObservableList<DriverName> ObservableList = FXCollections.observableArrayList();
        for (DriverName temp:driverList) {
            ObservableList.add(new DriverName(temp.getVehicleNumber(),temp.getVehicleType(),temp.getDriverName(),temp.getLeftTime()));
        }
        tblOnDelivery.setItems(ObservableList);
    }

    private void loadAllVehicle() {
        ObservableList<Park> ObservableList = FXCollections.observableArrayList();
        for (Park temp:parkList) {
            ObservableList.add(new Park(temp.getVehicleNumber(),temp.getVehicleType(),temp.getSlotNumber(),temp.getParkedTime()));
        }
        tblInParking.setItems(ObservableList);
    }


    private void checkResultInComboBox() {
        if (type.equals("On Delivery")) {
            tblInParking.setVisible(false);
            tblOnDelivery.setVisible(true);
        }
        if (type.equals("In Parking")) {
            tblInParking.setVisible(true);
            tblOnDelivery.setVisible(false);
        }
    }

    public void addVehicle(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddVehicle.fxml"));
        Parent parent = loader.load();
        AddVehicleController controller = loader.getController();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();

        controller.closeStage(parkingContext);
        stage.setScene(scene);
        stage.setTitle("Add Vehicle");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    public void addDriver(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddDriver.fxml"));
        Parent parent = loader.load();
        AddDriverController controller = loader.getController();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();

        controller.closeStage(parkingContext);
        stage.setScene(scene);
        stage.setTitle("Add Driver");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) parkingContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ParkingForm.fxml"))));
    }

   /* public void setArrayList(ArrayList<Park> parkList1) {
        parkList=parkList1;
    }

    public void setArrayList1(ArrayList<DriverName> driverNameArrayList1) {
        driverList=driverNameArrayList1;
    }*/
}
