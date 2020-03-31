/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.menumusica;

import bibliotecademusicas.menu.Menu;
import bibliotecademusicas.musica.Musica;
import bibliotecademusicas.util.ConstantesMenu;
import bibliotecademusicas.util.MensagemErro;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MenuInsereMusica implements Menu{

    private static final String STRING = "STRING";
    private static final String DATE = "DATE";
    private static final String FORMAT_DATE = "dd/MM/yyyy";
    
    private List<Musica> listMusicasInseridas = new ArrayList<>();
    private  Scanner scanner = new Scanner(System.in); 

    public List<Musica> getListMusicasInseridas() {
        return listMusicasInseridas;
    }

    public void setListMusicasInseridas(List<Musica> listMusicasInseridas) {
        this.listMusicasInseridas = listMusicasInseridas;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    
    
    public List<Musica> getListMusica() {
        return listMusicasInseridas;
    }

    public void setListMusica(List<Musica> listMusica) {
        this.listMusicasInseridas = listMusica;
    }
    
    @Override
    public void startMenu() {
        
        boolean permanceMenu = true;
        do{
            
            Musica musica = new Musica();
            
            String nome = (String) validarEntrada("Informe o nome da m�sica: ", true, STRING);
            musica.setNome(nome);
            
            String cantor = (String) validarEntrada("Informe o cantor(a): ", true, STRING);
            musica.setCantor(cantor);
            
            String nomeBanda = (String) validarEntrada("Informen o nome da banda: ", true, STRING);
            musica.setGrupo(nomeBanda);

            String nomeAlbum = (String) validarEntrada("Informen o nome do alb�m: ", false, STRING);
            musica.setGrupo(nomeAlbum);

            String genero = (String) validarEntrada("Informen o g�nero da m�sica: ", true, STRING);
            musica.setGrupo(genero);

            Date anoLancamento = (Date) validarEntrada("Informe a data de lan�amento: ", true, DATE);
            musica.setAnoLancamento(anoLancamento);
            
            listMusicasInseridas.add(musica);
            
            System.out.println("Deseja inserir mais uma musica? (S/N)"); 
            do{
                String resp = scanner.nextLine();
                if(resp.equalsIgnoreCase(ConstantesMenu.NAO)){
                    permanceMenu = false;
                    break;
                }
                else if(resp.equalsIgnoreCase(ConstantesMenu.SIM)){
                    break;
                }
                else{
                    MensagemErro.imprimeErro();
                }
            }while(true);
           
        }
        while(permanceMenu);
    }
    
    public Object validarEntrada(String comando, boolean validar, String format){
        
       
        String data;
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
            else if(validar && format.equals(DATE)){
              
               DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
               try {
                   date = dateFormat.parse(data);
                   validar = false;
               } catch (ParseException ex) {
                   System.out.println("Entrada invalida!!");
               }
               
                System.out.println(validar);
            } 
        }
        while(validar);
        
        if(format.equals(STRING))
            return data;
        else if(format.equals(DATE))     
            return date;
        
        return null;
    }
    
    
}
