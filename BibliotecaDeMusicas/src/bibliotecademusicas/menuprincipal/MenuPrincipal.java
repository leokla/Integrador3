/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.menuprincipal;

import bibliotecademusicas.menu.Menu;
import bibliotecademusicas.menumusica.MenuMusica;
import bibliotecademusicas.musica.Musica;
import bibliotecademusicas.playlist.PlayList;
import static bibliotecademusicas.util.ConstantesMenu.MUSICA;
import static bibliotecademusicas.util.ConstantesMenu.PLAYLIST;
import static bibliotecademusicas.util.ConstantesMenu.SAIR;
import bibliotecademusicas.util.MensagemErro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MenuPrincipal implements Menu{

    
    public MenuMusica musica;
    
    public static List<PlayList> listPersistPlay = new ArrayList<>();
    public static List<Musica> listPersistMusica = new ArrayList<>();
    
    public MenuPrincipal() {
    }
    
    @Override
    public void startMenu(){
        
        System.out.println("Iniciando programa");
        boolean perssisteMenu = true;
        Scanner scanner = new Scanner(System.in);
        
        musica = new MenuMusica();
        
        do{
            System.out.println("Para menu Musicas informe " + MUSICA);
            System.out.println("Para menu PlayLists informe " + PLAYLIST);
            System.out.println("Para sair informe " + SAIR);
            
            String in = scanner.nextLine();
            switch(in){
                case MUSICA:
                    
                    
                    musica.startMenu();
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
