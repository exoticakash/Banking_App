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

public class Scene1a implements Initializable {
    String[] store = new String[3];
    @FXML
    private JFXTextField name, id;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private Label thank;
    @FXML
    private Parent root;
    @FXML
    private AnchorPane anchorPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        thank.setVisible(false);
    }

    @FXML
    private void Signup() {

        if (!name.getText().equals("") && !name.getText().equals("") && !pass.getText().equals("")) {
            store[0] = name.getText();
            store[1] = id.getText();
            store[2] = pass.getText();
            thank.setVisible(true);
        } else
            thank.setVisible(false);
    }

    @FXML
    private void Signin() throws IOException {
        Scene1b.validate(store);
        root = FXMLLoader.load(getClass().getResource("Scene1b.fxml"));
        anchorPane.getChildren().add(root);
    }


}
