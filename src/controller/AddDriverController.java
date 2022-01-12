package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import module.Drivers;
import module.Vehicle;

import java.util.ArrayList;

import static controller.ParkingFormController.addDriverList;

public class AddDriverController {
    public AnchorPane context;
    public JFXTextField txtNic;
    public JFXTextField txtDriverName;
    public JFXTextField txtDrivingLicence;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;

    static ArrayList<Drivers> addDriverArrayList =addDriverList;

    public void closeStage(AnchorPane context) {
        this.context = context;
    }

    public void moveToNic(ActionEvent actionEvent) {
        txtNic.requestFocus();
    }

    public void moveToDrivingLicence(ActionEvent actionEvent) {
        txtDrivingLicence.requestFocus();
    }

    public void moveToAddress(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void addDriverOnAction(ActionEvent actionEvent) {
        Drivers drivers = new Drivers(txtDriverName.getText(),txtNic.getText(),txtDrivingLicence.getText(),txtAddress.getText(),Integer.valueOf(txtContact.getText()));
        if (addDriverList.add(drivers)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again..",ButtonType.CLOSE).show();
        }
    }


    public void moveToContact(ActionEvent actionEvent) {
        txtContact.requestFocus();
    }
}
