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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author K.S.M
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtPass;
    @FXML
    public TextField txtName;
    @FXML
    private Label lblOut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Login(ActionEvent event) throws IOException, SQLException {

        String Admin="Admin";
        
        String Password="123";
        
        User creat = new User();
        int a = creat.login(txtName.getText(), txtPass.getText());

        if (txtName.getText().isEmpty()) {

            lblOut.setText("please Enter User Name");

        } else if (txtPass.getText().isEmpty()) {

            lblOut.setText("please Enter Password");
        } else if (a!=0) {
              //  System.out.println(a);
                ((Node) event.getSource()).getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                Scene Scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(Scene);
                stage.show();

            } else {

                lblOut.setText("Wrong Username or Password");
               
               
               
        }
             if(Admin.equals(txtName.getText()) && Password.equals(txtPass.getText())){
                 
                 ((Node) event.getSource()).getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("/projectpa/Admin/AdminLecture.fxml"));
                Scene Scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(Scene);
                stage.show();
                 
             }
                    
                    
        
        
        

             
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

}
