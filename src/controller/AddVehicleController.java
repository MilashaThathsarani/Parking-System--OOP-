package controller;



import com.jfoenix.controls.JFXTextField;
import com.sun.deploy.net.MessageHeader;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import module.Vehicle;

import java.util.ArrayList;

import static controller.ParkingFormController.vehicleList;


public class AddVehicleController {
    public AnchorPane context;
    public JFXTextField txtVehicleNumber;
    public JFXTextField txtMaximumWeight;
    public JFXTextField txtPassengers;
    public ComboBox cmbVehicleType;

   static ArrayList<Vehicle>vehicleArrayList= vehicleList;

    public void closeStage(AnchorPane context) {
        this.context = context;
    }

    public void moveToMaximumWeight(ActionEvent actionEvent) {
        txtMaximumWeight.requestFocus();
    }

    public void moveToPassengers(ActionEvent actionEvent) {
        txtPassengers.requestFocus();
    }
    
        public void initialize(){
           cmbVehicleType.getItems().addAll(
                    "Bus",
                    "Van",
                    "Cargo Lorry"
            );
    }

    public void addVehicleOnAction(ActionEvent actionEvent) {
        Vehicle vehicle = new Vehicle(txtVehicleNumber.getText(),cmbVehicleType.getValue().toString(),Integer.valueOf(txtMaximumWeight.getText()),Integer.valueOf(txtPassengers.getText()));
        if (vehicleList.add(vehicle)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again..",ButtonType.CLOSE).show();
        }
    }
}

