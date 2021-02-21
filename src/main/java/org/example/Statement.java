package org.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class Statement implements Initializable {
    @FXML
    private ListView<String> list1;
    @FXML
    private ListView<String> list2;
    @FXML
    private ListView<String> list3;
    static String[] a = new String[1000];
    static int xx;

    public static void State(String[] arr, int x) {
        xx = x;
        if (x >= 0) System.arraycopy(arr, 0, a, 0, x);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int i = 0; i < xx; i += 3) {
            list1.getItems().add(a[i]);
            list2.getItems().add(a[i + 1]);
            list3.getItems().add(a[i + 2]);
        }
    }
}
