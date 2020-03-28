/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicas.util;

import bibliotecademusicas.menuprincipal.Menu;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class MensagemErro {
    
    public static void imprimeErro(){
        
        System.out.println("Opção inválida!!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        for (int i = 0; i < 1000; ++i)  
            System.out.println(); 
    }
    
}
