package ru.itpark.onlineBanking.controllers;

import javafx.fxml.FXML;
import ru.itpark.onlineBanking.Main;
import ru.itpark.onlineBanking.app.OnlineBankingRestTemp;
import ru.itpark.onlineBanking.models.User;

public class RootWindowController {

    private Main main;

    private User user;

    private OnlineBankingRestTemp onlineBankingRestTemp;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOnlineBankingRestTemp(OnlineBankingRestTemp onlineBankingRestTemp) {
        this.onlineBankingRestTemp = onlineBankingRestTemp;
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    public void showProfileWindow() {
        main.showProfileWindow(user);
    }
}
