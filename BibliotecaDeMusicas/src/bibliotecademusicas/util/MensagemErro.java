/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.util;

import bibliotecademusicas.menuprincipal.MenuPrincipal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MensagemErro {
    
    public static void imprimeErro(){
        
        System.out.println("Opcao invalida!!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        for (int i = 0; i < 5; ++i)
            System.out.println(); 
    }
    
}
