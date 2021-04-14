 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpa.Admin;

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
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author K.S.M
 */
public class AddLectureController implements Initializable {

    FileChooser fc = new FileChooser();
    @FXML
    private Button save1;
    @FXML
    private Button load1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fc.setInitialDirectory(new File("C:\\Users\\Ammar\\Lectures"));
    }


    @FXML
    private void User(ActionEvent event) throws IOException {
                 ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("ViewInfoStudnt.fxml"));
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.show();
    }

    private void fileChoose(ActionEvent event) {

        Stage stage = new Stage();

        FileChooser f = new FileChooser();
        f.setTitle("ABC");
        File f2 = f.showSaveDialog(stage);

    }

    @FXML
    private void save(ActionEvent event) {

        Window stage = save1.getScene().getWindow();
        fc.setTitle("Saving");
        fc.setInitialFileName("mySaving");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text", "*.text","mp4", "*.mp4"));        
        //  new FileChooser.ExtensionFilter("pdf", "*.pdf");
        //new FileChooser.ExtensionFilter("All Files", "*.*");

        try {

            File file = fc.showSaveDialog(stage);
            fc.setInitialDirectory(file.getParentFile());
            //TODO save

        } catch (Exception ex) {

        }

    }

    @FXML
    private void load(ActionEvent event) {

        Window stage = load1.getScene().getWindow();
        fc.setTitle("Loading");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text", "*.text","mp4", "*.mp4"));
        //  new FileChooser.ExtensionFilter("pdf", "*.pdf");
        //new FileChooser.ExtensionFilter("All Files", "*.*");

        try {

            File file = fc.showOpenDialog(stage);
            fc.setInitialDirectory(file.getParentFile());
            //TODO Load

        } catch (Exception ex) {

        }

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
