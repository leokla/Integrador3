/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.menuplaylist;

import bibliotecademusicas.menu.Menu;
import bibliotecademusicas.playlist.PlayList;
import bibliotecademusicas.util.ConstantesMenu;
import static bibliotecademusicas.util.ConstantesMenu.PLAYALEATORIA;
import static bibliotecademusicas.util.ConstantesMenu.PLAYESCOLHENDO;
import static bibliotecademusicas.util.ConstantesMenu.SAIR;
import bibliotecademusicas.util.MensagemErro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class MenuCadastraPlay implements Menu{

    private List<PlayList> listPlay = new ArrayList<>();
    
    
    @Override
    public void startMenu() {
        
        Scanner scanner = new Scanner(System.in);
        boolean permaneceMenuPlay = true;
        
        do{
            
            System.out.println("Para criar playlist com musicas aleatorias informe " + PLAYALEATORIA);
            System.out.println("Para criarplaylist escolhendo musicas informe " + PLAYESCOLHENDO);
            System.out.println("Para sair informe " + SAIR); 
            String in = scanner.nextLine();
            switch(in){
                case PLAYALEATORIA:
                    aleatorio();
                    break;
                
                case PLAYESCOLHENDO:
                   escolhendo();
                    break;    
                case SAIR:
                    permaneceMenuPlay = false;
                    break;
                
                default:
                    MensagemErro.imprimeErro();
            }     
        }
        while(permaneceMenuPlay);
        
    }
    
    
    private void aleatorio(){
        
        
        
        
    }
    
    
    private void escolhendo(){
        
    }
    
}
