package ru.itpark.onlineBanking.controllers;

import javafx.stage.Stage;
import ru.itpark.onlineBanking.Main;

public class MainWindowController {

    public MainWindowController() {
    }



    private Main main = new Main();

    private void initialize() {

    }

    public void signinOk() {

        main.initRootWindow();
        main.showMainWindow();
    }
}
