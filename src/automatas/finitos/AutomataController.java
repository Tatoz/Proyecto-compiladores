
package automatas.finitos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Juan Carlos
 */
public class AutomataController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tCadena, tAce, tErr;
    @FXML
    private Button btnTrans, btnCad, btnEst, btnAlf, btnVal;
    
    //Metodo de limpiar textfield
    void limpiar(){
        tCadena.setText("");
    }
    //Metodo limpiar variables
        void limpiarvariables(){
         nestados = 0;
         finalesta = new char[0];
         fin = "";
         nalfabeto = 0;
        tablatransicion1 = new int[0][0];
         v1 = "";
        alfabeto = new char[0];
        contador = 0;
        tablatransicion1=new int[0][0];
        btnEst.setDisable(false);
        btnAlf.setDisable(false);
        btnTrans.setDisable(false);
    }
        
        //Metodo para ingresar estados 
     public void estados(){ 
        //Se utiliza un try catch para cualquier posible error 
        try{     
        String e=JOptionPane.showInputDialog("Numero de Estados: ");
        nestados=Integer.parseInt(e);
        String t=JOptionPane.showInputDialog("Numero de Estados Finales: ");
        finalesta=new char[Integer.parseInt(t)];
        for(int i=0; i<finalesta.length; i++){
            String f=JOptionPane.showInputDialog("Estado Final "+i+": ");
            fin=fin+f;
        }
        finalesta=fin.toCharArray();
        for(int i=0; i<finalesta.length; i++){
            JOptionPane.showMessageDialog(null,"Caracter "+finalesta[i]+" ingresado");
        }
        btnEst.setDisable(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un Error "+e); 
            nestados=0;
            finalesta=new char[0];
            fin="";
        }
    }
     
         //Metodo para ingresar el alfabeto
    void alfabeto(){
        //Se utiliza un try catch para cualquier posible error
        try{
        String a=JOptionPane.showInputDialog("Tamaño del Alfabeto: ");
        nalfabeto=Integer.parseInt(a);
        tablatransicion1=new int[nestados][nalfabeto];
        for(int i=0; i<nalfabeto; i++){
            String v=JOptionPane.showInputDialog("Caracter "+i+" del alfabeto:");
            v1=v1+v;
        }
        alfabeto=v1.toCharArray();
        for(int i=0; i<alfabeto.length; i++){
            JOptionPane.showMessageDialog(null,"Caracter "+alfabeto[i]+" ingresado");
        }
        btnAlf.setDisable(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un Error "+e); 
            nalfabeto=0;
            tablatransicion1=new int[0][0];
            v1="";
            alfabeto=new char[0];
        }
    }
        //Metodo para ingresar la tabla de transicion
    void datostransicion(){
        //Se utiliza un try catch para cualquier posible error
        try{
        contador=1;
        for(int ii=0; ii<nestados; ii++){
            for(int jj=0; jj<nalfabeto; jj++){
                String r=JOptionPane.showInputDialog("Ingrese el valor de la tabla de transicion en["+ii+"]["+jj+"]");
                tablatransicion1[ii][jj]=Integer.parseInt(r);
            }
        }
        for(int ii=0; ii<nestados; ii++){
            for(int jj=0; jj<nalfabeto; jj++){
                JOptionPane.showMessageDialog(null,"Valor en posicion["+ii+"]["+jj+"]="+tablatransicion1[ii][jj]);
            }
        }
        btnTrans.setDisable(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un Error "+e);
            contador=0;
            tablatransicion1=new int[0][0];
        }
    } 
    
        //Metodo para obtener la posicion de la letra
    public int obtenerposicionletra(char n){
        int posicion=0;
        for(int i=0; i<alfabeto.length; i++){
            if(alfabeto[i]==n){ posicion=i; }
        }
        return posicion;        
    }
    //Metodo para obtener la letra
    public char obtenerletra(char n){
        char e=' ';
        for(int i=0; i<alfabeto.length; i++){
            if(alfabeto[i]==n){ e=alfabeto[i]; }
        }
        return e;
    }
    //Metodo para verificar los estados finales
    public int obteneref(int n){
        int ef=-1;
        String s="";
        s=s+Integer.toString(n);
        char [] ff=s.toCharArray();
        for(int i=0; i<finalesta.length; i++){
            if(finalesta[i]==ff[0]){ 
                String f="";
                f=f+finalesta[i];
                ef=Integer.parseInt(f);
            }
        }
        return ef;
    } 
    
    public void alfabetos(){
        if(nestados!=0){alfabeto();}
        else{JOptionPane.showMessageDialog(null,"Falta ingresar Estados!!");}
    }
    
    public void transiciones(){
        if(nalfabeto!=0){datostransicion();}
        else{JOptionPane.showMessageDialog(null,"Falta ingresar Alfabeto");}
    }
    
    public void evaluar(){
         
        //Aqui nos encontramos con el codigo que se ejecuta al momento de evaluar una cadena
        //Inicializamos est en 0 ,tAce con nada y txtErr con nada
        tAce.setText("");
        tErr.setText("");
        est=0;
        //Verificamos que se halla ingresado correctamente la tabla de transicion
        if(tCadena.getText().length()==0 || contador==0){JOptionPane.showMessageDialog(null,"Falta Ingresar Algunas Cosas");}
        else{
            //Codigo para evaluar la cadena
            cad=tCadena.getText().toCharArray(); 
            salestado=new int[cad.length+1];
            salestado[0]=0;
            //Este ciclo recorre todo la cadena para evaluarla
            for(int i=0; i<cad.length; i++){                
                    if(cad[i]==obtenerletra(cad[i])){
                        est=tablatransicion1[est][obtenerposicionletra(cad[i])];
                        bandera=true;
                        salestado[i+1]=est; 
                    }
                    else{
                        tAce.setText("No Aceptado");
                        tErr.setText("Caracter No Aceptado");
                        est=99;
                        salestado[i+1]=est;
                        bandera=false;
                        break;                        
                    }
            }
           //Verificamos el estado final sea correcto
           if(bandera!=false){
               if(est==obteneref(est)){
                   bandera=true;
               }
               else{
                   bandera=false;
                   tAce.setText("NO Aceptado");
                   tErr.setText("Estado de Aceptacion");
               }   
           } 
            //Se imprime lo siguiente si no hubo ningun problema en la cadena
            if(bandera==true){tAce.setText("Aceptado"); 
            tErr.setText("Ninguno");}
        //En este ciclo se imprime los cambios que existierion en el estado
        for(int i=0; i<salestado.length; i++){
            JOptionPane.showMessageDialog(null,"Estado "+salestado[i]);
        }
        }
        //Llamamos al metodo limpiar
        limpiar();
    }
    
    public void limpio(){
        System.out.println("Datos eliminados!!!");
         limpiarvariables();
    }
     //Variables a utilizar
    int contador=0;
    int nestados;
    int estadosf;
    String fin="";
    char finalesta[];
    int nalfabeto;
    char [] alfabeto;
    String v1="";
    int tablatransicion1[][];
    int salestado[];
    
    boolean bandera;
    int est;
    char []cad;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
