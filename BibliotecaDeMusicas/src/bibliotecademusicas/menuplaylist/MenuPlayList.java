/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.menuplaylist;

import bibliotecademusicas.menu.Menu;
import static bibliotecademusicas.util.ConstantesMenu.CADASTRAPLAY;
import static bibliotecademusicas.util.ConstantesMenu.SAIR;
import bibliotecademusicas.util.MensagemErro;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class MenuPlayList implements Menu{

    private MenuCadastraPlay cadastraPlay = new MenuCadastraPlay();

    public MenuCadastraPlay getCadastraPlay() {
        return cadastraPlay;
    }

    public void setCadastraPlay(MenuCadastraPlay cadastraPlay) {
        this.cadastraPlay = cadastraPlay;
    }
    
    @Override
    public void startMenu() {
        
        Scanner scanner = new Scanner(System.in);
        boolean permaneceMenuPlay = true;
        
        do{
     
            System.out.println("Para cadastrar playlist informe " + CADASTRAPLAY);
            System.out.println("Para sair informe " + SAIR); 
            String in = scanner.nextLine();
           switch(in){
                case CADASTRAPLAY:
                    
                    cadastraPlay.startMenu();
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
}
