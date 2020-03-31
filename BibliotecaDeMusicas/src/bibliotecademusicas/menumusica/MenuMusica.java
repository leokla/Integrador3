/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.menumusica;

import bibliotecademusicas.menu.Menu;
import static bibliotecademusicas.util.ConstantesMenu.CADASTRAMUSICA;
import static bibliotecademusicas.util.ConstantesMenu.LISTA_ALFAB_MUSICA;
import static bibliotecademusicas.util.ConstantesMenu.SAIR;
import bibliotecademusicas.util.MensagemErro;

import java.util.Scanner;

public class MenuMusica implements Menu{

    
    private MenuInsereMusica inseremusica = new MenuInsereMusica();

    public MenuInsereMusica getInseremusica() {
        return inseremusica;
    }

    public void setInseremusica(MenuInsereMusica inseremusica) {
        this.inseremusica = inseremusica;
    }
    
    @Override
    public void startMenu() {
        
        boolean permanecerMenuMusica = true;
        Scanner scanner = new Scanner(System.in);
        
        do{
           System.out.println("Para cadastrar uma musica informe " + CADASTRAMUSICA);
           System.out.println("Para listar as musicas em ordem alfabetica informe " + LISTA_ALFAB_MUSICA);
           System.out.println("Para sair informe " + SAIR); 
           
           String in = scanner.nextLine();
           switch(in){
                case CADASTRAMUSICA:
                    inseremusica.startMenu();
                    break;
                    
                case SAIR:
                    permanecerMenuMusica = false;
                    break;
                
                case LISTA_ALFAB_MUSICA:
                    inseremusica.listaMusicaAlfab();
                    break;
                    
                default:
                    MensagemErro.imprimeErro();
            } 
            
        }
        while(permanecerMenuMusica);    
        
        
    }
}
