/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpa;

import DB.Quizz;
import DB.ResulatTest1;
import DB.ResulatTest2;
import DB.ResulatTest3;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author K.S.M
 */
public class HResultsController implements Initializable {

    @FXML
    private TableView<ResulatTest1> tableResult;
    @FXML
    private TableColumn<ResulatTest1, Integer> colResult;
    @FXML
    private TableView<ResulatTest2> tableResult2;
    @FXML
    private TableColumn<ResulatTest2, Integer> colResult2;

    @FXML
    private TableView<ResulatTest3> tableResult3;
    @FXML
    private TableColumn<ResulatTest3, Integer> colResult3;

    ObservableList<ResulatTest1> oblist = FXCollections.observableArrayList();
    ObservableList<ResulatTest2> oblist2 = FXCollections.observableArrayList();
    ObservableList<ResulatTest3> oblist3 = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Quizz con = new Quizz();

        try {
            con.UsersData(oblist);
            con.UsersData2(oblist2);
            con.UsersData3(oblist3);

        } catch (SQLException ex) {
            Logger.getLogger(HResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colResult.setCellValueFactory(new PropertyValueFactory<>("ResulatTest1"));

        tableResult.setItems(oblist);

        colResult2.setCellValueFactory(new PropertyValueFactory<>("ResulatTest2"));

        tableResult2.setItems(oblist2);

        colResult3.setCellValueFactory(new PropertyValueFactory<>("ResulatTest3"));

        tableResult3.setItems(oblist3);

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

}
