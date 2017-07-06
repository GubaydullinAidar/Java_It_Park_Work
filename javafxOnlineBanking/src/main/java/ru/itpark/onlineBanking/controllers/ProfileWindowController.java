package ru.itpark.onlineBanking.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.itpark.onlineBanking.Main;
import ru.itpark.onlineBanking.app.OnlineBankingRestTemp;
import ru.itpark.onlineBanking.models.User;

public class ProfileWindowController {

    @FXML
    private Label firstname;

    @FXML
    private Label lastname;

    @FXML
    private Label email;

    @FXML
    private Label phone;

    @FXML
    private TextField changeFirstname;

    @FXML
    private TextField changeLastname;

    @FXML
    private TextField changeEmail;

    @FXML
    private TextField changePhone;

    @FXML
    private TextField changeUsername;

    @FXML
    private TextField changePassword;

    private Main main;
    private User user;
    private OnlineBankingRestTemp onlineBankingRestTemp;
    private Stage dialogStage;

    public ProfileWindowController() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOnlineBankingRestTemp(OnlineBankingRestTemp onlineBankingRestTemp) {
        this.onlineBankingRestTemp = onlineBankingRestTemp;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Label getFirstname() {
        return firstname;
    }

    public void setFirstname(Label firstname) {
        this.firstname = firstname;
    }

    public Label getLastname() {
        return lastname;
    }

    public void setLastname(Label lastname) {
        this.lastname = lastname;
    }

    public Label getEmail() {
        return email;
    }

    public void setEmail(Label email) {
        this.email = email;
    }

    public Label getPhone() {
        return phone;
    }

    public void setPhone(Label phone) {
        this.phone = phone;
    }

    public TextField getChangeFirstname() {
        return changeFirstname;
    }

    public void setChangeFirstname(TextField changeFirstname) {
        this.changeFirstname = changeFirstname;
    }

    public TextField getChangeLastname() {
        return changeLastname;
    }

    public void setChangeLastname(TextField changeLastname) {
        this.changeLastname = changeLastname;
    }

    public TextField getChangeEmail() {
        return changeEmail;
    }

    public void setChangeEmail(TextField changeEmail) {
        this.changeEmail = changeEmail;
    }

    public TextField getChangePhone() {
        return changePhone;
    }

    public void setChangePhone(TextField changePhone) {
        this.changePhone = changePhone;
    }

    public TextField getChangeUsername() {
        return changeUsername;
    }

    public void setChangeUsername(TextField changeUsername) {
        this.changeUsername = changeUsername;
    }

    public TextField getChangePassword() {
        return changePassword;
    }

    public void setChangePassword(TextField changePassword) {
        this.changePassword = changePassword;
    }

    public Main getMain() {
        return main;
    }

    public User getUser() {
        return user;
    }

    public void init() {
        firstname.setText(user.getFirstName());
        lastname.setText(user.getLastName());
        phone.setText(user.getPhone());
        email.setText(user.getEmail());
    }

    public void saveChange() {
        user.setFirstName(changeFirstname.getText());
        user.setLastName(changeLastname.getText());
        user.setEmail(changeEmail.getText());
        user.setUsername(changeUsername.getText());
        user.setPassword(changePassword.getText());
        init();
        onlineBankingRestTemp.saveShange(user);
    }
}
