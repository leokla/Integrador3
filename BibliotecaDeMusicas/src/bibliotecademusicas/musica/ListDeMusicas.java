/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.musica;


import bibliotecademusicas.exceptions.ExcecaoDeListaCheia;
import bibliotecademusicas.exceptions.ExcecaoDeMusicaJaExistente;
import bibliotecademusicas.exceptions.ExcecaoDeMusicaNaoEncontrada;

public class ListDeMusicas {

    private int capacidade = 100;
    private int proximoLivre = 0;
    private Musica[] musicas = new Musica[capacidade];

    public void incluirNoInicio(Musica musica) throws ExcecaoDeListaCheia{
        if (this.proximoLivre < capacidade) {
            for(int i = this.proximoLivre; i > 0; --i) {
                this.musicas[i] = this.musicas[i - 1];
            }
            this.musicas[0] = musica;
            ++this.proximoLivre;
        }else{
            throw new ExcecaoDeListaCheia("Lista de Musicas cheia!!");
        }
    }
    public void incluirNoFim(Musica musica) throws ExcecaoDeListaCheia {
        if (this.proximoLivre < this.capacidade) {
            this.musicas[this.proximoLivre] = musica;
            ++this.proximoLivre;
        }else{
            throw new ExcecaoDeListaCheia("Lista de Musicas cheia!!");
        }
    }
    
    public void removeMusica(Musica m)throws ExcecaoDeMusicaNaoEncontrada {
        boolean removeu = false;
        Musica[] musicasAux = new Musica[100];
        int index = 0;
        for (Musica musica : musicas) {
            if (musica != m) {
                musicasAux[index] = musica;
                index++;
            } else {
                removeu = true;
            }
        }
        musicas = musicasAux;
        
        if(!removeu)
            throw new ExcecaoDeMusicaNaoEncontrada("Musica não existe!!");
    }

    public void existMusica(Musica m) throws ExcecaoDeMusicaJaExistente {
        for(Musica m1 : musicas){
            if(m1.equals(m))
                throw new ExcecaoDeMusicaJaExistente("Musica já existe");
        }
    }

    public boolean isEmpty(){
        return musicas.length ==0;
    }
    public Musica[] getListMusica() {
        return musicas;
    }
    public int tamanho(){ return this.proximoLivre;}
}
