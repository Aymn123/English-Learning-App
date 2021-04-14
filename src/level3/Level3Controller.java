/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level3;

import java.io.File;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ammar Ft
 */
public class Level3Controller implements Initializable {

    @FXML
    private ListView<String> l1Lec;
    @FXML
    private MediaView mv;
    MediaPlayer ma;
    File dir_path;
    File dir_path2;
    @FXML
    private TextField txtPlay;
    private ListView<String> l1Lec2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dir_path = new File("C:/Users/Ammar/Lectures/L3");
        String lectures[] = dir_path.list();

        for (int i = 0; i < lectures.length; i++) {

            System.out.println(lectures[i]);
            l1Lec.getItems().add(lectures[i]);
        }
    }

    private void Lecture1(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Lecture1.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();
    }

    private void Lecture2(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Lecture2.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();

    }

    private void Lecture3(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Lecture3.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();
    }

    @FXML
    private void Test(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("TestSure.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {

        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/projectpa/HomePage.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();

    }

    @FXML
    private void fileView(MouseEvent event) {

        String lNum = l1Lec.getSelectionModel().getSelectedItem();
        System.out.println(lNum);
        File fileNames[];
        fileNames = dir_path.listFiles();
        File f1;

        f1 = fileNames[l1Lec.getSelectionModel().getSelectedIndex()];
        /*f2 = fileNames[1];
        f3 = fileNames[2];*/

        String s = f1.getAbsolutePath();
        String s1 = s.replaceAll("\\\\", "/");

        /*String s2 = f2.getAbsolutePath();
        String s3 = s2.replaceAll("\\\\", "/");
        
         String s4 = f3.getAbsolutePath();
        String s5 = s4.replaceAll("\\\\", "/");*/
        String VUrl = "file:/" + s1;
        System.out.println(VUrl);
        txtPlay.setText(VUrl);

    }

    @FXML
    private void pause(MouseEvent event) {

        ma.pause();

    }

    @FXML
    private void play(MouseEvent event) {

        Media m = new Media(txtPlay.getText());
        ma = new MediaPlayer(m);

        mv.setMediaPlayer(ma);

        ma.pause();

        ma.play();

    }

}
