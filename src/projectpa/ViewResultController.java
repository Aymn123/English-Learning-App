/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpa;

import DB.Quizz;
import DB.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
 * FXML Controller class
 *
 * @author Ammar Ft
 */
public class ViewResultController implements Initializable {

    static int sum;
    @FXML
    private Label viewResult;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String str3 = String.valueOf(sum);
        viewResult.setText(str3);

    }

    @FXML
    private void HomeDatabase(ActionEvent event) throws IOException, SQLException {

        Quizz q = new Quizz();
        
        
        q.add(viewResult.getText());

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();

    }

    public void calculate() {

        sum += 1;

    }

}
