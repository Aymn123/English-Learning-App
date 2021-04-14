/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpa;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author K.S.M
 */
public class HomePageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void levels(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("SelectLevel.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();
    }

    @FXML
    private void Results(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("HResults.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();
    }

    @FXML
    private void Logout(MouseEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/projectpa/FXMLDocument.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();
    }

}
