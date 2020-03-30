/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.menumusica;

import bibliotecademusicas.menu.Menu;
import bibliotecademusicas.musica.Musica;
import bibliotecademusicas.util.ContantesMenu;
import static bibliotecademusicas.util.ContantesMenu.CADASTRAMUSICA;
import static bibliotecademusicas.util.ContantesMenu.PLAYLIST;
import static bibliotecademusicas.util.ContantesMenu.SAIR;
import bibliotecademusicas.util.MensagemErro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuMusica implements Menu{

    public List<Musica> listMusica = new ArrayList<>();
    
    @Override
    public void startMenu() {
        
        boolean permanecerMenuMusica = true;
        Scanner scanner = new Scanner(System.in);
         MenuInsereMusica inseremusica = new MenuInsereMusica();
        do{
           System.out.println("Para cadastrar uma musica informe " + CADASTRAMUSICA);
           System.out.println("Para sair informe " + SAIR); 
           
           String in = scanner.nextLine();
           switch(in){
                case CADASTRAMUSICA:
                    inseremusica.startMenu();
                    break;
                    
                case SAIR:
                    permanecerMenuMusica = false;
                    break;
                    
                default:
                    MensagemErro.imprimeErro();
            } 
            
        }
        while(permanecerMenuMusica);    
        
        
    }
}
