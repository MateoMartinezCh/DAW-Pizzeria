package com.mycompany.pizzeria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.stage.WindowEvent;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private Image icono;
    private String pathicono = "pizza.png";

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"),1220,750);// 1440, 900);
        ClassLoader classLoader = getClass().getClassLoader();
        this.icono = new Image(classLoader.getResource(this.pathicono).toString());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Interfaz Gráfica Mateo");
        stage.setOnCloseRequest((WindowEvent t) -> {
            Platform.exit();
            System.exit(0);
        });
        stage.getIcons().add(icono);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
