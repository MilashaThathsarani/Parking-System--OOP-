package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {
    public AnchorPane logInContext;
    public AnchorPane context;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;

    public void closeStage(AnchorPane context) {
        this.context = context;
    }

    public void moveToPassword(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void logParkingOnAction(ActionEvent actionEvent) throws IOException {
        if (txtUserName.getText().equalsIgnoreCase("Admin") && txtPassword.getText().equalsIgnoreCase("1234")) {
            Stage stage= (Stage)logInContext.getScene().getWindow();
            stage.close();
            Stage window = (Stage) context.getScene().getWindow();
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/InParking.fxml"))));
        }
    }

    public void cancel(ActionEvent actionEvent) {
        Stage stage= (Stage)logInContext.getScene().getWindow();
        stage.close();
    }
}