/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.util;

import bibliotecademusicas.musica.Musica;
import java.util.Comparator;


public class OrdenaAlfabMusica implements Comparator<Musica>{

    @Override
    public int compare(Musica o1, Musica o2) {
       return o1.getNome().compareTo(o2.getNome());
    }
}
