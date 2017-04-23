package ru.itpark;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Student9 on 19.04.2017.
 */
public class App extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) throws Exception {
        /*
        Text text = new Text(10, 40, "Hello World!");
        text.setFont(new Font(40));
        */
        /*
        Button button = new Button ("Click me!");
        */
        /*
        RadioButton radioButton = new RadioButton("R");
        */

        CheckBox checkBox = new CheckBox("Check me!");
        Scene scene = new Scene(new Group(checkBox));

        stage.setTitle("Welcome to JavaFX!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
