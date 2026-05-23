package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleLogin(ActionEvent event) {

        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("admin123")) {

            try {

                Parent root = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));

                Stage stage = (Stage) usernameField.getScene().getWindow();

                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                messageLabel.setText("Gagal membuka dashboard. Cek console.");
                e.printStackTrace();
            }

        } else {
            messageLabel.setText("Username atau password salah!");
        }
    }
}
