/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.musica;

import java.util.Date;

/**
 *
 * @author Rafael
 */
public class Musica {
    
    private String nome;
    private String cantor;
    private String grupo;
    private String album;
    private String genero;
    private Date anoLancamento;

    public Musica() {
    }

    public Musica(String nome, String cantor, String grupo, String album, String genero, Date anoLancamento) {
        this.nome = nome;
        this.cantor = cantor;
        this.grupo = grupo;
        this.album = album;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Date anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    
    
    
    
    
}
 