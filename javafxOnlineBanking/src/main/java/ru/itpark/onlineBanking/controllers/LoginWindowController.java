package ru.itpark.onlineBanking.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ru.itpark.onlineBanking.Main;
import ru.itpark.onlineBanking.app.OnlineBankingRestTemp;

public class LoginWindowController {

    private Main main = new Main();

    private OnlineBankingRestTemp onlineBankingRestTemp = new OnlineBankingRestTemp();

    @FXML
    private Label lblMessage;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    public void signinOk(ActionEvent event) {
        if (login.getText().length() == 0 || password.getText().length() == 0) {
            lblMessage.setText("Введите логин и пароль");
        }else if (onlineBankingRestTemp.login(login.getText(), password.getText()) != null) {
            ((Node) event.getSource()).getScene().getWindow().hide();
            main.initRootWindow();
            main.showMainWindow();
        } else {
            lblMessage.setText("Неверный логин или пароль");
        }
    }

    public void signup(ActionEvent event) {

    }
}
