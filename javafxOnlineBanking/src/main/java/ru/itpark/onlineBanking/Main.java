package ru.itpark.onlineBanking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootWindow;

    public static void main(String[] args) {
        launch(args);
    }

    public Main() {

    }

    public Main(Stage primaryStage, BorderPane rootWindow) {
        this.primaryStage = primaryStage;
        this.rootWindow = rootWindow;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }



    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("OnlineBanking");

        signin();

       // initRootWindow(primaryStage);

      //  showMainWindow();
    }

    /**
     * Инициализирует корневой макет.
     */
    public void initRootWindow() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/views/rootWindow.fxml"));
            //loader.setLocation(Main.class.getResource("windows/rootWindow.fxml"));
            rootWindow = loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootWindow);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Показывает в корневом макете сведения об адресатах.
     */
    public void showMainWindow() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/views/mainWindow.fxml"));
            AnchorPane personOverview = loader.load();

            // Помещаем сведения об адресатах в центр корневого макета.
            rootWindow.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void signin() {
        try {
            // объявляем загружатель fxml-файлов
            FXMLLoader loader = new FXMLLoader();
            // загружаем файл
            loader.setLocation(getClass().getResource("/views/loginWindow.fxml"));
            // создаем родительское окно
            AnchorPane root = loader.load();
            // кладем сцену с окном
            Scene scene = new Scene(root);
            //scene.getStylesheets().add(getClass().getResource("/css/list-ru.itpark.onlineBanking.view-style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void signinOk() {
        initRootWindow();

        showMainWindow();
    }*/

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
