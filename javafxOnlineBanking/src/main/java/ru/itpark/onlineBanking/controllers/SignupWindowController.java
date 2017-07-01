package ru.itpark.onlineBanking.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.itpark.onlineBanking.models.User;

public class SignupWindowController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;


    private Stage dialogStage;
    private User user;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setUser(User user) {
        this.user = user;

        firstNameField.setText(user.getFirstName());
        lastNameField.setText(user.getLastName());
        phoneNumberField.setText(user.getPhone());
        emailField.setText(user.getEmail());
        loginField.setText(user.getLogin());
        passwordField.setText(user.getPassword());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            user.setFirstName(firstNameField.getText());
            user.setLastName(lastNameField.getText());
            user.setPhone(phoneNumberField.getText());
            user.setEmail(emailField.getText());
            user.setLogin(loginField.getText());
            user.setPassword(passwordField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (phoneNumberField.getText() == null || phoneNumberField.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }

        if (emailField.getText() == null || emailField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        }

        if (loginField.getText() == null || loginField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }

        if (passwordField.getText() == null || passwordField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            /*Dialogs.create()
                    .title("Invalid Fields")
                    .masthead("Please correct invalid fields")
                    .message(errorMessage)
                    .showError();*/

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка полей");
            alert.setHeaderText(null);
            alert.setContentText("Пожалуйста, измените поля с ошибками");
            alert.showAndWait();
            return false;
        }
    }
}
