package ru.itpark.onlineBanking.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.itpark.onlineBanking.app.OnlineBankingRestTemp;
import ru.itpark.onlineBanking.models.User;

public class RefilDebitWindowController {

    private OnlineBankingRestTemp onlineBankingRestTemp;

    @FXML
    private TextField primaryAmount;

    @FXML
    private TextField savingsAmount;

    private Stage dialogStage;
    private User user;
    private boolean okClicked = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOnlineBankingRestTemp (OnlineBankingRestTemp onlineBankingRestTemp) {
        this.onlineBankingRestTemp = onlineBankingRestTemp;
    }

    @FXML
    public void handleRefilPrimaryAccount(){
        if (primaryAmount.getText() != null || primaryAmount.getText() != "") {
            String refilPrimaryAccount = onlineBankingRestTemp.refilPrimaryAccount(user.getToken(), primaryAmount.getText());

            if (refilPrimaryAccount != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Платеж прошел успешно. Баланс: " + refilPrimaryAccount);

                alert.showAndWait();
            }  else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Извините, произошла ошибка");
                alert.showAndWait();
            }
        }
    }
}
