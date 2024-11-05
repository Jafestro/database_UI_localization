package org.example.database_ui_localization;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private Stage stage;
    private HelloService helloService = new HelloService();
    public Label firstNameText;
    public Label lastNameText;
    public Label emailText;
    public ChoiceBox<String> selection;
    public TextField firstNameField;
    public TextField lastNameField;
    public TextField emailField;
    public Button saveButton;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selection.getItems().addAll("English", "Farsi", "Japanese");
        selection.setValue("English"); // Set default value
        selection.setOnAction(this::onLanguageChange); // Set the event handler
    }

    @FXML
    public void onLanguageChange(ActionEvent actionEvent) {
        if (stage == null) {
            if (selection.getScene() != null) {
                stage = (Stage) selection.getScene().getWindow();
            } else {
                return; // Exit if scene is not ready
            }
        }

        // Language change logic
        if ("English".equals(selection.getValue())) {
            firstNameText.setText("First Name");
            lastNameText.setText("Last Name");
            emailText.setText("Email");
            saveButton.setText("Save");
            stage.setTitle("Employee Management");
        } else if ("Farsi".equals(selection.getValue())) {
            firstNameText.setText("نام");
            lastNameText.setText("نام خانوادگی");
            emailText.setText("ایمیل");
            saveButton.setText("ذخیره");
            stage.setTitle("مدیریت کارکنان");
        } else if ("Japanese".equals(selection.getValue())) {
            firstNameText.setText("名");
            lastNameText.setText("姓");
            emailText.setText("Eメール");
            saveButton.setText("セーブ");
            stage.setTitle("従業員管理");
        }
    }


    public void save(ActionEvent actionEvent) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        helloService.insertEmployeeData(firstName, lastName, email, selection.getValue());
    }
}