/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.menuprincipal;

import bibliotecademusicas.util.MensagemErro;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class Menu {

    public static final String MUSICA = "1"; 
    public static final String PLAYLIST = "2";
    public static final String SAIR = "0";
    
    public Menu() {
    }
    
    public void startMenu(){
        
        System.out.println("Iniciando programa");
        boolean perssisteMenu = true;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Para menu Musicas informe " + MUSICA);
            System.out.println("Para menu PlayLists informe " + PLAYLIST);
            System.out.println("Para sair informe " + SAIR);
            
            String in = scanner.nextLine();
            switch(in){
                case MUSICA:
                    break;
                    
                case PLAYLIST:
                    break;
                    
                case SAIR:
                    perssisteMenu = false;
                    break;
                    
                default:
                    
                    MensagemErro.imprimeErro();
            }
            
        }while (perssisteMenu);
        
        System.out.println("Fim do programa");
        
    }
    
    
}
