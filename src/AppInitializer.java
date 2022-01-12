import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import module.Vehicle;

import java.io.IOException;
import java.net.URL;

import static javafx.fxml.FXMLLoader.load;

public class AppInitializer extends Application {

    public void start(Stage primaryStage) throws IOException {
        URL resource = getClass().getResource("view/ParkingForm.fxml");
        Parent load = load(resource);
        Scene scene = new Scene(load);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Parking System(v-1.0.0)");
        primaryStage.show();
    }
}
