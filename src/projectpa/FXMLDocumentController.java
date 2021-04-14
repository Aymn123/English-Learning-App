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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author K.S.M
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    
    private void handleButtonAction(ActionEvent event) {
  
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Login(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();
    }

    @FXML
    private void regs(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("regs.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();
    }
    
}
