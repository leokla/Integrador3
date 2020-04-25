/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.playlist;

import bibliotecademusicas.musica.Musica;
import java.util.ArrayList;
import java.util.Objects;


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

    @Override
    public String toString() {
        return "PlayList{" + "nome= " + nome + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlayList other = (PlayList) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }  
}
