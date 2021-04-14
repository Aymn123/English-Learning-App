/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CoPeR00
 */
public class Test_Q1Controller implements Initializable {

    @FXML
    private RadioButton a;
    @FXML
    private RadioButton c;
    @FXML
    private RadioButton b;
    @FXML
    private RadioButton d;
    @FXML
    private ToggleGroup q1;
    static int x;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Next(ActionEvent event) throws IOException {

       ViewResultController v1 = new ViewResultController();

        if (a.isSelected()) {
            x = 1;
            v1.calculate();
        } else if (b.isSelected()) {
            x = 0;
        } else if (c.isSelected()) {
            x = 0;
        } else if (d.isSelected()) {
            x = 0;
        }

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Test_Q2.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();
    }

}
