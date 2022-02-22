/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleks
 */
public class PrimanjePoruka {
    private Socket socket;

    public PrimanjePoruka(Socket socket) {
        this.socket = socket;
    }
    
    public Object receive() throws Exception{
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw  new Exception("Greska prilikom preuzimanja objekta:" + ex.getMessage());
        }
       
    }
}
