/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.menuplaylist;

import bibliotecademusicas.exceptions.ExcecaoDeListaCheia;
import bibliotecademusicas.exceptions.ExcecaoDeMusicaNaoEncontrada;
import bibliotecademusicas.menu.Menu;
import bibliotecademusicas.menuprincipal.MenuPrincipal;
import bibliotecademusicas.musica.ListDeMusicas;
import bibliotecademusicas.musica.Musica;
import bibliotecademusicas.playlist.PlayList;
import bibliotecademusicas.util.ConstantesMenu;
import bibliotecademusicas.util.MensagemErro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static bibliotecademusicas.util.ConstantesMenu.*;

/**
 *
 * @author Rafael
 */
public class MenuCadastraPlay implements Menu {

    private List<PlayList> listPlay = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void startMenu() {

        boolean permaneceMenuPlay = true;

        do {

            System.out.println("Para criar playlist com musicas aleatorias informe " + PLAYALEATORIA);
            System.out.println("Para criarplaylist escolhendo musicas informe " + PLAYESCOLHENDO);
            System.out.println("Para sair informe " + SAIR);
            String in = scanner.nextLine();
            switch (in) {
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
        } while (permaneceMenuPlay);

    }

    private void aleatorio() {

        String nome = "";
        int qtd = 0;
        boolean permaneceMenu = true;
        do {

            System.out.println("Infome o nome da playlist");
            nome = scanner.nextLine();

            do {
                System.out.println("Informe a quantidade de musicas aleatorias: ");
                try {
                    qtd = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Quantidade invalida");
                }
            } while (true);

            if (MenuPrincipal.listDeMusicas.isEmpty()) {
                System.out.println("Nao ha musicas cadastradas");
                permaneceMenu = false;
            } else {

                PlayList list = new PlayList(nome);

                if (MenuPrincipal.listDeMusicas.tamanho() < qtd) {
                    System.out.println("Não há esta quantidade de musicas disponiveis ");
                    System.out.println("Serão adicionadas " + MenuPrincipal.listDeMusicas.tamanho());

                    qtd = MenuPrincipal.listDeMusicas.tamanho();
                }

                for (int i = 0; i < qtd; i++) {
                    try {
                        list.incluirNoFim(MenuPrincipal.listDeMusicas.getListMusica()[i]);
                    } catch (ExcecaoDeListaCheia listaCheia) {
                        System.out.println(listaCheia.getMessage());;
                    }
                }

                listPlay.add(list);
            }

            do {
                System.out.println("Deseja incluir mais uma playlist? (S/N) ");
                String resp = scanner.nextLine();
                if (resp.equalsIgnoreCase(ConstantesMenu.NAO)) {
                    MenuPrincipal.listPersistPlay.addAll(listPlay);
                    listPlay.clear();
                    permaneceMenu = false;
                    break;
                } else if (resp.equalsIgnoreCase(ConstantesMenu.SIM)) {
                    break;
                } else {
                    MensagemErro.imprimeErro();
                }
            } while (true);
        } while (permaneceMenu);

    }

    private void escolhendo() {

        String nome;

        ListDeMusicas listprov = MenuPrincipal.listDeMusicas;
        boolean permaneceMenu = true;
        do {

            System.out.println("Infome o nome da playlist");
            nome = scanner.nextLine();

            if (MenuPrincipal.listDeMusicas.isEmpty()) {
                System.out.println("Não há musicas cadastradas");
                permaneceMenu = false;
            } else {
                PlayList list = new PlayList(nome);
                
                int indice = -1;
                boolean permaneceMenuEscolheMusica = true;
                do {
                    System.out.println("Escolha as musicas ");
                    int i = 1;
                    for (Musica m : listprov.getListMusica()) {
                        System.out.println(i + " - " + m.getNome());
                        i++;
                    }

                    do {
                        System.out.println("Informe o indice da musica: ");
                        try {
                            indice = Integer.parseInt(scanner.nextLine());
                           
                        } catch (Exception e) {
                            System.out.println("Indice invalido");
                        }
                        
                        if(indice <= 0 || indice > listprov.tamanho()){
                           System.out.println("Indice invalido"); 
                        }
                        else{
                             break;
                        }  
                    } while (true);

                    Musica m = listprov.getListMusica()[indice-1];
                    try {
                        list.incluirNoFim(m);
                        listprov.removeMusica(m);
                    } catch (ExcecaoDeListaCheia | ExcecaoDeMusicaNaoEncontrada ex) {
                        System.out.println();
                    }

                    do {
                        System.out.println("Deseja incluir mais uma musica? (S/N) ");
                        String resp = scanner.nextLine();
                        if (resp.equalsIgnoreCase(ConstantesMenu.NAO)) {
                            permaneceMenuEscolheMusica = false;
                            break;
                        } else if (resp.equalsIgnoreCase(ConstantesMenu.SIM)) {
                            break;
                        } else {
                            MensagemErro.imprimeErro();
                        }
                    } while (true);
                       
                } while (permaneceMenuEscolheMusica);
                listPlay.add(list);
            }

            do {
                System.out.println("Deseja incluir mais uma playlist? (S/N) ");
                String resp = scanner.nextLine();
                if (resp.equalsIgnoreCase(ConstantesMenu.NAO)) {
                    MenuPrincipal.listPersistPlay.addAll(listPlay);
                    listPlay.clear();
                    permaneceMenu = false;
                    break;
                } else if (resp.equalsIgnoreCase(ConstantesMenu.SIM)) {
                    break;
                } else {
                    MensagemErro.imprimeErro();
                }
            } while (true);
        } while (permaneceMenu);

    }

}
