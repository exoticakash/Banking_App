package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Scene2 implements Initializable {

    static String[] arrx = new String[2];
    private final String[] trans = new String[1000];

    @FXML
    private AnchorPane layer, layer2;
    @FXML
    private Label label, not;

    private int balance;
    private int i = 0;
    String s;

    @FXML
    TextField text, text1, CustomerName, CustomerId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CustomerName.setText(arrx[0]);
        CustomerId.setText(arrx[1]);
        not.setVisible(false);
        layer2.setVisible(false);
        CustomerName.setEditable(false);
        CustomerId.setEditable(false);
        text.setEditable(false);
        update();
    }

    @FXML
    private void done() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy   HH:mm:ss");
        Date date = new Date();
        s = text1.getText();
        int amt = Integer.parseInt(s);
        if (label.getText().equals("Deposit")) {
            if (amt != 0) {
                balance = balance + amt;
                trans[i] = format.format(date);
                trans[i + 1] = "Deposited";
                trans[i + 2] = "" + amt;
                i += 3;

            }
        }
        if (label.getText().equals("Withdraw")) {
            if (amt != 0 && amt <= balance) {
                balance = balance - amt;
                trans[i] = format.format(date);
                trans[i + 1] = "Withdrawn";
                trans[i + 2] = "" + amt;
                i += 3;
            } else {
                not.setVisible(true);
                not.setLayoutY(200);

            }
        }
        update();
        layer2.setVisible(false);
        text1.setText("");
    }

    @FXML
    private void deposit() {
        not.setVisible(false);
        label.setText("Deposit");
        layer2.setVisible(true);
    }

    @FXML
    private void withdraw() {
        not.setVisible(false);
        label.setText("Withdraw");
        layer2.setVisible(true);
    }

    @FXML
    private void statement() throws IOException {
        Statement.State(trans, i);
        Stage stage = new Stage();
        Parent state = FXMLLoader.load(getClass().getResource("Statement.fxml"));
        stage.setTitle("Statement");
        Image ico = new Image("mainicon.png");
        stage.getIcons().add(ico);
        stage.setScene(new Scene(state, 800, 400));
        stage.setResizable(false);
        stage.show();
    }


    @FXML
    private void logout() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
        layer.getChildren().add(root);
    }

    public void update() {
        text1.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                text1.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        text.setText("" + balance);
    }

    public static void validate(String[] arr) {
        arrx[0] = arr[0];
        arrx[1] = arr[1];
    }
}
