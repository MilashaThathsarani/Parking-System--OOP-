package controller;

import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import module.DriverName;
import module.Drivers;
import module.Park;
import module.Vehicle;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static controller.AddVehicleController.vehicleArrayList;


public class ParkingFormController {
    public AnchorPane parkingSystemContext;
    public ComboBox cmbSelectVehicle;
    public ComboBox cmbDriver;
    public TextField txtVehicleType;
    public TextField txtDate;
    public TextField txtSlotNumber;
    public JFXButton button1;
    public JFXButton button2;
    private String selectedVehicleNumber;

    static ArrayList<Drivers> addDriverList = new ArrayList();
    static ArrayList<Park> parkList = new ArrayList();
    static ArrayList<DriverName> driverList = new ArrayList();
    static ArrayList<Vehicle> vehicleList = new ArrayList();

    static int[] slot = new int[14];

    public void initialize() {

        loadAllAddDriver();
        loadAllVehicle();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy   HH:mm");
        Date date = new Date();
        txtDate.setText(formatter.format(date));

        InParkingController.driverNameArrayList = driverList;
        InParkingController.parkArrayList = parkList;
    }

    private void loadAllVehicle() {
        ObservableList<String> ObservableList = FXCollections.observableArrayList();
        for (Vehicle temp : vehicleList) {
            ObservableList.add(temp.getVehicleNumber());
        }
        cmbSelectVehicle.setItems(ObservableList);

        cmbSelectVehicle.getSelectionModel().selectedItemProperty().addListener((ObservableValue observable, Object oldValue, Object newValue) -> {
            String type = "none";
            for (Vehicle temp1 : vehicleList
            ) {
                if (newValue.equals(temp1.getVehicleNumber())) {
                    type = temp1.getVehicleType();
                }
            }
            txtVehicleType.setText(type);
        });
    }

    private void loadAllAddDriver() {
        ObservableList<String> ObservableList = FXCollections.observableArrayList();
        for (Drivers temp : addDriverList) {
            ObservableList.add(temp.getDriverName());
        }
        cmbDriver.setItems(ObservableList);
    }

    public void managementLogIN(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/LogIn.fxml"));
        Parent parent = loader.load();
        LogInController controller = loader.getController();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();

        controller.closeStage(parkingSystemContext);
        stage.setScene(scene);
        stage.setTitle("log In");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    public void parkVehicle(ActionEvent actionEvent) throws IOException {
        button1.setDisable(false);
        button2.setDisable(true);

        if (cmbSelectVehicle.getValue().equals(null) && cmbDriver.getValue().equals(null)) {
            new Alert(Alert.AlertType.WARNING, "Pick Up vehicle Number", ButtonType.CLOSE).show();
        } else {
            check(txtVehicleType.getText());
            driverList.removeIf(temp2 -> cmbSelectVehicle.getSelectionModel().getSelectedItem().toString().equals(temp2.getVehicleNumber()));
            parkList.add(new Park(cmbSelectVehicle.getValue().toString(), txtVehicleType.getText(), txtSlotNumber.getText(), txtDate.getText()));
        }
        System.out.println(parkList);
    }

    private void check(String text) {
        if (text.equalsIgnoreCase("Bus")) {
           if (slot[13] == 14) {
               new Alert(Alert.AlertType.WARNING, "Can't be park", ButtonType.CLOSE).show();
            } else {
            txtSlotNumber.setText("14");
            slot[13] = 14;
        }
        } else if (text.equalsIgnoreCase("Van")) {
            if (slot[0] == 0) {
                txtSlotNumber.setText("1");
                slot[0] = 1;
            } else if (slot[1] == 0) {
                txtSlotNumber.setText("2");
                slot[1] = 2;
            } else if (slot[2] == 0) {
                txtSlotNumber.setText("3");
                slot[2] = 3;
            } else if (slot[3] == 0) {
                txtSlotNumber.setText("4");
                slot[3] = 4;
            } else if (slot[11] == 0) {
                txtSlotNumber.setText("12");
                slot[11] = 12;
            } else if (slot[12] == 0) {
                txtSlotNumber.setText("13");
                slot[12] = 13;
            }
        } else if (text.equalsIgnoreCase("Cargo Lorry")) {
            if (slot[4] == 0) {
                txtSlotNumber.setText("5");
                slot[4] = 5;
            } else if (slot[5] == 0) {
                txtSlotNumber.setText("6");
                slot[5] = 6;
            } else if (slot[6] == 0) {
                txtSlotNumber.setText("7");
                slot[6] = 7;
            } else if (slot[7] == 0) {
                txtSlotNumber.setText("8");
                slot[7] = 8;
            } else if (slot[8] == 0) {
                txtSlotNumber.setText("9");
                slot[8] = 9;
            } else if (slot[9] == 0) {
                txtSlotNumber.setText("10");
                slot[9] = 10;
            } else if (slot[10] == 0) {
                txtSlotNumber.setText("11");
                slot[10] = 11;
            }
        }
    }

    public void onDeliveryShift(ActionEvent actionEvent) throws IOException {

        button1.setDisable(true);
        button2.setDisable(false);

        if (cmbDriver.getValue().equals(null) && cmbSelectVehicle.getValue().equals(null)) {
            new Alert(Alert.AlertType.WARNING, "Pick Up Driver Name", ButtonType.CLOSE).show();
        } else {
            parkList.removeIf(temp3 -> cmbSelectVehicle.getSelectionModel().getSelectedItem().toString().equals(temp3.getVehicleNumber()));
            driverList.add(new DriverName(cmbSelectVehicle.getValue().toString(), txtVehicleType.getText(), cmbDriver.getValue().toString(), txtDate.getText()));
        }
    }

    public void setType(ActionEvent actionEvent) {
        if (checkParkList() == 1) {
            getType();
            button1.setDisable(true);
            button2.setDisable(false);
        } else {
            getType();
            button2.setDisable(true);
            button1.setDisable(false);
        }
        System.out.println(txtVehicleType.getText());
    }

    private int checkParkList() {
        int i = 0;
        for (Park temp : parkList) {
            if (cmbSelectVehicle.getValue().equals(temp.getVehicleNumber())) {
                i = 1;
            }
        }
        return i;
    }

    private void getType() {
        for (Vehicle t : vehicleArrayList) {
            if (cmbSelectVehicle.getValue().equals(t.getVehicleNumber())) {
                txtVehicleType.setText(t.getVehicleType());
            }
        }
    }
}