package unisa.ingsoft;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("/unisa/ingsoft/gui_calc.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 510, 400);
        stage.setTitle("Calcolatrice Scientifica");
        stage.setScene(scene);

        //caricamento icona
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/unisa/ingsoft/icon.png"))));


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}