package ru.itpark.onlineBanking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.itpark.onlineBanking.app.OnlineBankingRestTemp;
import ru.itpark.onlineBanking.controllers.*;
import ru.itpark.onlineBanking.models.User;

import java.io.IOException;

public class Main extends Application {

    private OnlineBankingRestTemp onlineBankingRestTemp = new OnlineBankingRestTemp();

    private BorderPane rootWindow;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        // загружаем файл
        loader.setLocation(Main.class.getResource("/views/loginWindow.fxml"));
        // создаем родительское окно
        AnchorPane root = loader.load();
        // кладем сцену с окном
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("/css/list-ru.itpark.onlineBanking.view-style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

        LoginWindowController controller = loader.getController();
        controller.setMain(this);
        controller.setOnlineBankingRestTemp(onlineBankingRestTemp);
    }

    /**
     * Инициализирует корневой макет.
     */
    public void initRootWindow(User user) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/views/rootWindow.fxml"));
            rootWindow = loader.load();
            Scene scene = new Scene(rootWindow);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Online Banking");
            primaryStage.setScene(scene);
            primaryStage.show();

            RootWindowController controller = loader.getController();
            controller.setMain(this);
            controller.setUser(user);
            controller.setOnlineBankingRestTemp(onlineBankingRestTemp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMainWindow(User user) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/views/mainWindow.fxml"));
            AnchorPane mainWindow = loader.load();
            rootWindow.setCenter(mainWindow);

            MainWindowController controller = loader.getController();
            controller.setUser(user);
            controller.setMain(this);
            controller.setOnlineBankingRestTemp(onlineBankingRestTemp);
            controller.getSavingsBalance();
            controller.getPrimaryBalance();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSignupWindow(User user) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/views/signUpWindow.fxml"));
            AnchorPane signupWindow = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Окно регистрации");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Stage primaryStage = new Stage();
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(signupWindow);
            dialogStage.setScene(scene);

            SignupWindowController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setUser(user);
            controller.setOnlineBankingRestTemp(onlineBankingRestTemp);

            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRefillDebitWindow(User user) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/views/refillDebitWindow.fxml"));
            AnchorPane refillDebitWindow = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Окно пополнения/списания");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Stage primaryStage = new Stage();
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(refillDebitWindow);
            dialogStage.setScene(scene);

            RefillDebitWindowController controller = loader.getController();
            controller.setUser(user);
            controller.setOnlineBankingRestTemp(onlineBankingRestTemp);

            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showProfileWindow(User user) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/views/profileWindow.fxml"));
            AnchorPane profileWindow = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Личный кабинет");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Stage primaryStage = new Stage();
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(profileWindow);
            dialogStage.setScene(scene);

            ProfileWindowController controller = loader.getController();
            controller.setMain(this);
            controller.setDialogStage(dialogStage);
            controller.setUser(user);
            controller.setOnlineBankingRestTemp(onlineBankingRestTemp);
            controller.init();

            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
