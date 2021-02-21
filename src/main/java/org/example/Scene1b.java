package org.example;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Scene1b implements Initializable {

    static String[] arrx = new String[3];

    @FXML
    private JFXTextField name;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private Parent root;
    @FXML
    private Label incorrect;
    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        incorrect.setVisible(false);
    }

    @FXML
    private void Signin() throws IOException {
        if (name.getText().equals(arrx[0]) && pass.getText().equals(arrx[2])) {
            Scene2.validate(arrx);
            root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
            anchorPane.getChildren().add(root);
        } else incorrect.setVisible(true);
    }

    @FXML
    private void Signup() throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene1a.fxml"));
        anchorPane.getChildren().add(root);
    }

    public static void validate(String[] arr) {
        arrx[0] = arr[0];
        arrx[1] = arr[1];
        arrx[2] = arr[2];
    }


}
