/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpa.Admin;

import DB.User;
import DB.infoStudent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ammar Ft
 */
public class ViewInfoStudntController implements Initializable {

    @FXML
    private TableView<infoStudent> tableViewStudnt;
    @FXML
    private TableColumn<infoStudent, Integer> colId;
    @FXML
    private TableColumn<infoStudent, String> colUsername;
    @FXML
    private TableColumn<infoStudent, String> colEmail;
    @FXML
    private TableColumn<infoStudent, String> colPassword;
    ObservableList<infoStudent> oblist = FXCollections.observableArrayList();
    @FXML
    private TextField txtSearch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User con = new User();

        try {
            con.StudentInfo(oblist);

        } catch (SQLException ex) {
            Logger.getLogger(ViewInfoStudntController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
        tableViewStudnt.setItems(oblist);

        // TODO
    }


    @FXML
    private void btnLecture(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/projectpa/Admin/Lecture.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();
    }


    @FXML
    private void btnSearch(ActionEvent event) throws SQLException {
        tableViewStudnt.getItems().clear();
        User con = new User();
        con.SearchUser(oblist, txtSearch.getText());
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
        tableViewStudnt.setItems(oblist);
    }

    @FXML
    private void btnUpdate(ActionEvent event) {
        User con = new User();
        tableViewStudnt.getItems().clear();
        try {
            con.StudentInfo(oblist);

        } catch (SQLException ex) {
            Logger.getLogger(ViewInfoStudntController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
        tableViewStudnt.setItems(oblist);
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AdminLecture.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();
    }

}
