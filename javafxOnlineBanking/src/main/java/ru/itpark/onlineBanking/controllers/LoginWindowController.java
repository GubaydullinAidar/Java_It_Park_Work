package ru.itpark.onlineBanking.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ru.itpark.onlineBanking.Main;
import ru.itpark.onlineBanking.app.OnlineBankingRestTemp;
import ru.itpark.onlineBanking.models.User;

public class LoginWindowController {

    private Main main = new Main();

    private OnlineBankingRestTemp onlineBankingRestTemp = new OnlineBankingRestTemp();

    @FXML
    private Label lblMessage;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    public void signinOk(ActionEvent event) {
        if (username.getText().length() == 0 || password.getText().length() == 0) {
            lblMessage.setText("Введите логин и пароль");
        } else {
            String token = onlineBankingRestTemp.login(username.getText(), password.getText());
            if (token != null) {
                //}else if (true) {
                ((Node) event.getSource()).getScene().getWindow().hide();
                User user = onlineBankingRestTemp.getUser(token);
                main.initRootWindow();
                main.showMainWindow(user);
            } else {
                lblMessage.setText("Неверный логин или пароль");
            }
        }
    }

    public void signup() {
        User user = new User();
        boolean okClicked = main.showSignupWindow(user);
    }
}