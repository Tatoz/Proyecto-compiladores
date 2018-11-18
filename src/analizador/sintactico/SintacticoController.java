package analizador.sintactico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 * @author Juan Carlos
 */
public class SintacticoController implements Initializable {
    
    @FXML
    private TextArea taSintac;
    @FXML
    private Button btnValidar;
    
    
    //Método para validar expresion
    public boolean validarExpresion(){
        Pila pila = new Pila();
        String cadena = taSintac.getText();
        
        for(int i = 0; i<cadena.length(); i++){
            if (cadena.charAt(i)=='(' || cadena.charAt(i)=='{') {
                pila.insertar(cadena.charAt(i));
            } else {
                
                if (cadena.charAt(i)==')') {
                    if (pila.extraer() !='(') {
                        return false;
                    }
                } else{
                    if (cadena.charAt(i)=='}') {
                        if (pila.extraer() != '{') {
                            return false;
                            
                        }
                    } 
                        
                        
                    
                }
                
                
            }
        }
        return pila.pilaVacia();
    }
    
    @FXML   
    private void mostrarValidacion(){
        if (validarExpresion()) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Resultado");
        alert.setContentText("Cadena introducida correctamente");
        alert.showAndWait();
        }else{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Resultado");
        alert.setContentText("Datos mal introducidos, verifique cadena");
        alert.showAndWait();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
