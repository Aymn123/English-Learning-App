/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpa;

import DB.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ammar Ft
 */
public class RegsController implements Initializable {

    @FXML
    private TextField txtuser;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtpassword;
    @FXML
    private ComboBox<String> Comb1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> list = FXCollections.observableArrayList("Beginner", "Average", "Advance");
        Comb1.setItems(list);

    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();
    }

    @FXML
    private void register(ActionEvent event) throws SQLException {
        User u = new User();
        u.add(txtuser.getText(), txtemail.getText(), txtpassword.getText(), Comb1.getValue());
    }

    @FXML
    private void selecetLevel(ActionEvent event) {

        String s = Comb1.getSelectionModel().getSelectedItem().toString();

    }

}
