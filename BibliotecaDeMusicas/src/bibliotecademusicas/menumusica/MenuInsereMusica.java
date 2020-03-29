/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.menumusica;

import bibliotecademusicas.menu.Menu;
import bibliotecademusicas.musica.Musica;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class MenuInsereMusica implements Menu{

    private static final String STRING = "STRING";
    private static final String DATE = "DATE";
    private static final String FORMAT_DATE = "dd/MM/yyyy";
    
    
    @Override
    public void startMenu() {
        
        boolean permanceMenu = true;
        do{
            
            Musica musica = new Musica();
            
            String nome = (String) validarEntrada("Informe o nome da musica: ", true, STRING);
            musica.setNome(nome);
            
            String cantor = (String) validarEntrada("Informe o cantor(a): ", true, STRING);
            musica.setCantor(cantor);
            
            String nomeBanda = (String) validarEntrada("Informen o nome da banda: ", true, STRING);
            musica.setGrupo(nomeBanda);
            
        }
        while(permanceMenu);
    }
    
    public Object validarEntrada(String comando, boolean validar, String format){
        
        Scanner scanner = new Scanner(System.in); 
        String data = "";
        Date date = null;
        do{
            System.out.println(comando);
            data = scanner.nextLine();
            if(validar && format.equals(STRING)){

                if(data == (null) || data.equals("")){
                    System.out.println("Entrada invalida!!");
                }
                else{
                    validar = false;
                }
            }        
            else if(validar && data.equals(DATE)){
               
               DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
               try {
                   date = dateFormat.parse(data);
                   validar = false;
               } catch (ParseException ex) {
                   System.out.println("Entrada invalida!!");
               }
            } 
        }
        while(validar);
        
        if(format.equals(STRING))
            return data;
        else if(data.equals(DATE))     
            return date;
        
        return null;
    }
    
    
}
