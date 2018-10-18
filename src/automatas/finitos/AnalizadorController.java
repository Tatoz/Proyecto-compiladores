package automatas.finitos;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;


/**
 * FXML Controller class
 *
 * @author Juan Carlos
 */
public class AnalizadorController implements Initializable {
   
       @FXML
       private Button btnAna;
       @FXML
       public TextArea taAuto, taLex;
       
       
       
       //En este método esta todo el analizador para un fututo aplicar Reingeniería
       public void analiza(){
       //Dentro de este String coloco las palabras reservadas/Tokens del analizar para que al momento de ingresarlos sean reconocidos
       String pr ="(Automata)|(Estados)|(Inicial)|(Aceptacion)|(Alfabeto)|(Transiciones)|(:)|(,)|(;)|(Fin)|([0-9]+)|([(-)]+)|(-)|([*|+|'|?|¡|¿|_]+)";
       
      /**
       * Utilizo esta cadena como ejemplo para simplemente copiar y pegar en el analizador léxico
       * Para ingresar al analizador es dar clic en Nuevo > Analizador léxico
       * Después introducir la cadena deseada y se mostrará en el otro TextArea y en la consola del IDE
       Automata 
       Estados:3; 
       Inicial:0; 
       Aceptacion:1; 
       Alfabeto:01; 
       Transiciones:(039);
       Fin
      */
        String auto =taAuto.getText();
        //taAuto.setText(auto);
      // String regx=("(while)|([a-zA-Z]+)|([>|<|=]+)|([0-9]+)|([{|}]+)|(;)");
       
       Pattern p = Pattern.compile(pr);
       Matcher matcher = p.matcher(auto);
       
           while (matcher.find()) {
               String tokenTipo1 = matcher.group(1);
                if(tokenTipo1 != null){
                  System.out.println("Inicio de automata: "+ tokenTipo1);
                   //taLex.setText("Palabra Reservada: "+tokenTipo1+"\n");
                   taLex.appendText("Inicio de autómata: "+tokenTipo1+"\n");
                   
               }
               
               String tokenTipo2 = matcher.group(2);
               if(tokenTipo2 != null){
                   System.out.println("Palabra resevada: "+ tokenTipo2);
                   //taLex.setText("Palabra Reservada: "+tokenTipo2);
                   taLex.appendText("Palabra reservada: "+tokenTipo2+"\n");
               }
               
               String tokenTipo3 = matcher.group(3);
               if(tokenTipo3 != null){
                   System.out.println("Palabra resevada: "+ tokenTipo3);
                  // taLex.setText("Palabra Reservada: "+tokenTipo3);
                  taLex.appendText("Palabra reservada: "+tokenTipo3+"\n");
               }
               
               String tokenTipo4 = matcher.group(4);
               if(tokenTipo4 != null){
                   System.out.println("Palabra resevada: "+ tokenTipo4);
                   //taLex.setText("Palabra Reservada: "+tokenTipo4);
                   taLex.appendText("Palabra reservada: "+tokenTipo4+"\n");
               }
               
               String tokenTipo5 = matcher.group(5);
               if(tokenTipo5 != null){
                   System.out.println("Palabra resevada: "+ tokenTipo5);
                   //taLex.setText("Palabra Reservada: "+tokenTipo5);
                   taLex.appendText("Palabra reservada: "+tokenTipo5+"\n");
               }
               
               String tokenTipo6 = matcher.group(6);
               if(tokenTipo6 != null){
                   System.out.println("Palabra resevada: "+ tokenTipo6);
                   //taLex.setText("Palabra Reservada: "+tokenTipo6);
                   taLex.appendText("Palabra reservada: "+tokenTipo6+"\n");
                   
               }
               
               String tokenTipo7 = matcher.group(7);
               if(tokenTipo7 != null){
                   System.out.println("Dos puntos: "+ tokenTipo7);
                   //taLex.setText("Dos puntos: "+tokenTipo7);
                   taLex.appendText("Dos puntos: "+tokenTipo7+"\n");
               }
               
               String tokenTipo8 = matcher.group(8);
               if(tokenTipo8 != null){
                   System.out.println("Coma: "+ tokenTipo8);
                  // taLex.setText("Coma: "+tokenTipo8);
                  taLex.appendText("Coma: "+tokenTipo8+"\n");
                  
               }
               
               String tokenTipo9 = matcher.group(9);
               if(tokenTipo9 != null){
                   System.out.println("Fin instruccion: "+ tokenTipo9);
                   //taLex.setText("Fin instruccion: "+tokenTipo9+"\n");
                   taLex.appendText("Fin instruccion: "+tokenTipo9+"\n");
                   
                   
               }
               
               String tokenTipo10 = matcher.group(10);
               if(tokenTipo10 != null){
                  System.out.println("Fin automata: "+ tokenTipo10);
                   taLex.appendText("Fin Automata: "+tokenTipo10+"\n");
                   
               }
               
                String tokenTipo11 = matcher.group(11);
               if(tokenTipo11 != null){
                   System.out.println("Valor: "+ tokenTipo11);
                   taLex.appendText("Valor: "+tokenTipo11+"\n");
                  
               }
               String tokenTipo12 = matcher.group(12);
               if(tokenTipo12 != null){
                   System.out.println("Parentesis: "+ tokenTipo12);
                   taLex.appendText("Parentesis: "+tokenTipo12+"\n");
                  
               }
               String tokenTipo13 = matcher.group(13);
               if(tokenTipo13 != null){
                   System.out.println("Guion: "+ tokenTipo13);
                   taLex.appendText("Guión: "+tokenTipo13+"\n");
               }
                 String tokenTipo14 = matcher.group(14);
               if(tokenTipo14 != null){
                   System.out.println("Caracter incorrecto: "+ tokenTipo14);
                   taLex.appendText("Caracter incorrecto: "+tokenTipo14+"\n");
               }
               
           } 
                   
                   
                   
                   
       }
       

      
       
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
