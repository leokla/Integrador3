/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.playlist;

import bibliotecademusicas.musica.Musica;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class PlayList extends ArrayList<Musica>{
    
    private String nome;

    public PlayList(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
