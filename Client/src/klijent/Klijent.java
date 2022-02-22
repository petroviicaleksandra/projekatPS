/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Komunikacija;
import forme.LoginForma;

/**
 *
 * @author aleks
 */
public class Klijent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //pokreni server program
        Klijent client = new Klijent();
        try {
            client.connect();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void connect() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9000);
        System.out.println("Klijent se povezao...");
        
        Komunikacija.getInstance().setSocket(socket);
        //otvori formu za prijavu na sistem
        new LoginForma().setVisible(true);
    }
    
}
