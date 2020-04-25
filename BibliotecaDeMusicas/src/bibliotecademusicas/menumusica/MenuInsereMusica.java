/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.menumusica;

import bibliotecademusicas.menu.Menu;
import bibliotecademusicas.menuprincipal.MenuPrincipal;
import bibliotecademusicas.musica.Musica;
import bibliotecademusicas.util.ConstantesMenu;
import bibliotecademusicas.util.MensagemErro;
import bibliotecademusicas.util.OrdenaAlfabMusica;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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

    private DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
    
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

            String nomeAlbum = (String) validarEntrada("Informen o nome do album: ", false, STRING);
            musica.setAlbum(nomeAlbum);

            String genero = (String) validarEntrada("Informen o genero da musica: ", true, STRING);
            musica.setGenero(genero);

            Date anoLancamento = (Date) validarEntrada("Informe a data de lancamento: ", true, DATE);
            musica.setAnoLancamento(anoLancamento);
            
            
            // Tratativa para não inserir musicas duplicadas
            try {
                MenuPrincipal.listDeMusicas.existMusica(musica);
                listMusicasInseridas.add(musica);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
           
            do{
                System.out.println("Deseja inserir mais uma musica? (S/N)"); 
                String resp = scanner.nextLine();
                if(resp.equalsIgnoreCase(ConstantesMenu.NAO)){
                    MenuPrincipal.listDeMusicas.addAll(listMusicasInseridas);
                    listMusicasInseridas.clear();
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
    
    private Object validarEntrada(String comando, boolean validar, String format){
        
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

               try {
                   date = dateFormat.parse(data);
                   validar = false;
               } catch (ParseException ex) {
                   System.out.println("Entrada invalida!!");
               }
               
               // System.out.println(validar);
            } 
        }
        while(validar);
        
        if(format.equals(STRING))
            return data;
        else if(format.equals(DATE))     
            return date;
        
        return null;
    }
    
    void listaMusicaAlfab(){
        
        if(MenuPrincipal.listDeMusicas.getListPersistMusica().isEmpty()){
            System.out.println("Nenhuma musica cadastrada!!");
        }
        else{
            
            List<Musica> tempList = new ArrayList<>();
            tempList.addAll(MenuPrincipal.listDeMusicas.getListPersistMusica());
            Collections.sort(tempList, new OrdenaAlfabMusica());
            for(Musica m : tempList)
                System.out.println(m.getNome());
            
        }
    }
    
    void apresentaPorGenero(){
        
        boolean permanece = true;
        do{
            System.out.println("Informe o genero: ");
            String genero = scanner.nextLine();
            boolean encontrouUma = false;
            for(Musica m : MenuPrincipal.listDeMusicas.getListPersistMusica()){
                if(m.getGenero() != null && m.getGenero().equalsIgnoreCase(genero)){
                    encontrouUma = true;
                    System.out.println(m.getNome());
                }    
            }
            if(!encontrouUma)  System.out.println("Nenhuma musica com o genero!");
            
            System.out.println("Deseja pesquisar novamente? (S/N)"); 
            do{
                String resp = scanner.nextLine();
                if(resp.equalsIgnoreCase(ConstantesMenu.NAO)){
                    permanece = false;
                    break;
                }
                else if(resp.equalsIgnoreCase(ConstantesMenu.SIM)){
                    break;
                }
                else{
                    MensagemErro.imprimeErro();
                    System.out.println("Deseja pesquisar novamente? (S/N)");
                }
            }while(true);
            
        }while(permanece);
    }
    void apresentaPorBanda(){

        boolean permaneceBusca = true;
        do{
            System.out.println("Informe a banda: ");
            String banda = scanner.nextLine();
            boolean encontrouUma = false;
            for(Musica m :MenuPrincipal.listDeMusicas.getListPersistMusica()){
                if(m.getGrupo() != null && m.getGenero().equalsIgnoreCase(banda)){
                    encontrouUma = true;
                    System.out.println(m.getNome());
                }
            }
            if(!encontrouUma)  System.out.println("Nenhuma musica desta banda!");

            System.out.println("Deseja pesquisar novamente? (S/N)");
            do{
                String resp = scanner.nextLine();
                if(resp.equalsIgnoreCase(ConstantesMenu.NAO)){
                    permaneceBusca = false;
                    break;
                } else if(resp.equalsIgnoreCase(ConstantesMenu.SIM)){
                    break;
                } else{
                    MensagemErro.imprimeErro();
                    System.out.println("Deseja pesquisar novamente? (S/N)");
                }
            }while(true);

        }while(permaneceBusca);
    }
    void apresentaPorEntreDatas(){

        boolean permanece = true;
        do{
            Date data1 = null;
            Date data2 = null;
            boolean podeBuscar =true;
            System.out.println("Informe a primeira Data: ");
            try {
                data1 =  dateFormat.parse(scanner.nextLine());
            } catch (ParseException e) {
                podeBuscar  =false;
                System.out.println("Entrada invalida!!");
            }
            if(podeBuscar){
                System.out.println("Informe a segunda Data: ");
                try {
                    data2 =  dateFormat.parse(scanner.nextLine());
                } catch (ParseException e) {
                    podeBuscar = false;
                    System.out.println("Entrada invalida!!");
                }
            }

            if(podeBuscar && data1!=null && data2 != null){
                if(data2.before(data1)){
                    System.out.println("A segunda data nao pode ser anterior a primeira data!");
                }else if(!listouMusicas(data1,data2)){
                    System.out.println("Nenhuma musica entre as datas informadas!");
                }
            }

            System.out.println("Deseja pesquisar novamente? (S/N)");
            do{
                String resp = scanner.nextLine();
                if(resp.equalsIgnoreCase(ConstantesMenu.NAO)){
                    permanece = false;
                    break;
                }
                else if(resp.equalsIgnoreCase(ConstantesMenu.SIM)){
                    break;
                }
                else{
                    MensagemErro.imprimeErro();
                    System.out.println("Deseja pesquisar novamente? (S/N)");
                }
            }while(true);

        }while(permanece);
    }

    private boolean listouMusicas(Date data1, Date data2) {
        boolean encontrouMusicas = false;
        for(Musica m : MenuPrincipal.listDeMusicas.getListPersistMusica()){
            if(m.getAnoLancamento().after(data1) && m.getAnoLancamento().before(data2)){
                encontrouMusicas = true;
                System.out.println(m.getNome());
            }
        }
        return encontrouMusicas;
    }
}
