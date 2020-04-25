/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.musica;

import java.util.ArrayList;
import java.util.List;


public class ListDeMusicas {
    
    private  List<Musica> listPersistMusica = new ArrayList<>();

    public void addMusica(Musica m) throws Exception{}
    
    public void removeMusica(Musica m)throws Exception{
        
        Musica encontrada = null;
        for(Musica m1: listPersistMusica){
            if(m1.equals(m)){
                encontrada = m1;
                break;
            }
        }
        
        if(encontrada == null)
            throw new Exception("Musica não existe!!");
        else
            listPersistMusica.remove(encontrada);
        
    }
    
    public void existMusica(Musica m) throws Exception{
        
        for(Musica m1 : listPersistMusica){ 
            if(m1.equals(m))
                throw new Exception("Musica já existe");
        } 
    }
    
    public void addAll(List<Musica> list){
        listPersistMusica.addAll(list);
    }
    
    
    public List<Musica> getListPersistMusica() {
        return listPersistMusica;
    }

    public void setListPersistMusica(List<Musica> listPersistMusica) {
        this.listPersistMusica = listPersistMusica;
    }
    
    
    
}
