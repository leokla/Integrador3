/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.menuplaylist;

import bibliotecademusicas.menu.Menu;
import static bibliotecademusicas.util.ConstantesMenu.*;

import bibliotecademusicas.menuprincipal.MenuPrincipal;
import bibliotecademusicas.musica.Musica;
import bibliotecademusicas.playlist.PlayList;
import bibliotecademusicas.util.MensagemErro;
import java.util.Scanner;


public class MenuPlayList implements Menu{

    private MenuCadastraPlay cadastraPlay = new MenuCadastraPlay();

    public MenuCadastraPlay getCadastraPlay() {
        return cadastraPlay;
    }

    public void setCadastraPlay(MenuCadastraPlay cadastraPlay) {
        this.cadastraPlay = cadastraPlay;
    }

    private Scanner scanner = new Scanner(System.in);
    @Override
    public void startMenu() {


        boolean permaneceMenuPlay = true;
        
        do{
     
            System.out.println("Para cadastrar playlist informe " + CADASTRAPLAY);
            System.out.println("Para buscar uma playlist pelo nome informe " + PLAYBUSCAR);
            System.out.println("Para sair informe " + SAIR); 
            String in = scanner.nextLine();
           switch(in){
                case CADASTRAPLAY:
                    cadastraPlay.startMenu();
                    break;

               case PLAYBUSCAR:
                   buscarPlaylist();
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

    private void buscarPlaylist(){
        System.out.println("Informe o nome da Playlist:");
        String nome = scanner.nextLine();
        for(PlayList pl: MenuPrincipal.listPersistPlay){
            if(pl.getNome().equalsIgnoreCase(nome)){
                System.out.println("==========================================");
                System.out.println("--" + pl.getNome() + "--");
                System.out.println("Musicas:");
                for (Musica m : pl.getListMusica()) {
                    if(m!=null)
                        System.out.println(m);
                    else
                        break;

                }
                System.out.println("==========================================");
            }
        }
        startMenu();
    }
}
