package ru.itpark.onlineBanking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.itpark.onlineBanking.app.OnlineBankingRestTemp;
import ru.itpark.onlineBanking.controllers.MainWindowController;
import ru.itpark.onlineBanking.controllers.RefilDebitWindowController;
import ru.itpark.onlineBanking.controllers.SignupWindowController;
import ru.itpark.onlineBanking.models.User;

import java.io.IOException;

public class Main extends Application {

    private OnlineBankingRestTemp onlineBankingRestTemp = new OnlineBankingRestTemp();

    //private Stage primaryStage;
    private BorderPane rootWindow;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //this.primaryStage = primaryStage;

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
    }

    /**
     * Инициализирует корневой макет.
     */
    public void initRootWindow() {
        try {
            rootWindow = FXMLLoader.load(Main.class.getResource("/views/rootWindow.fxml"));
            Scene scene = new Scene(rootWindow);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Online Banking");
            primaryStage.setScene(scene);
            primaryStage.show();
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

    public void showrefilDebitWindow(User user) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/views/refillDebitWindow.fxml"));
            AnchorPane refilDebitWindow = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Окно пополнения/списания");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Stage primaryStage = new Stage();
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(refilDebitWindow);
            dialogStage.setScene(scene);

            RefilDebitWindowController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setUser(user);
            controller.setOnlineBankingRestTemp(onlineBankingRestTemp);

            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Открывает диалоговое окно для изменения деталей указанного адресата.
     * Если пользователь кликнул OK, то изменения сохраняются в предоставленном
     * объекте адресата и возвращается значение true.
     *
     * @param person - объект адресата, который надо изменить
     * @return true, если пользователь кликнул OK, в противном случае false.
     */
    /*public boolean showPersonEditDialog(Person person) {
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("ru.itpark.onlineBanking.view/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }*/
}
