/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas.finitos;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

/**
 *
 * @author Juan Carlos
 */
public class EscritorioController implements Initializable {

    @FXML
    private MenuItem automataF, analizador, sintactico, autor;

    @FXML
    private void nuevo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/automatas/finitos/Automata.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setWidth(500);
        stage.setHeight(300);
        stage.setTitle("Automata Finito");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void analizador(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/analizador/lexico/Analizador.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        // stage.setWidth(700);//Ancho
        //stage.setHeight(500);//Alto
        stage.setTitle("Analizador léxico");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
    }
    
        @FXML
    private void sintactico(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/analizador/sintactico/Sintactico.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        // stage.setWidth(700);//Ancho
        //stage.setHeight(500);//Alto
        stage.setTitle("Analizador Sintáctico");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    public void autor() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Acerca del autor");
        alert.setContentText("Juan Carlos Stempreiss Vidal 143422");
        alert.showAndWait();
        
    }
    @FXML
    public void salir(){
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
