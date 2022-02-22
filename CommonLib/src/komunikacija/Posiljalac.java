/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleks
 */
public class Posiljalac {

    private Socket socket;

    public Posiljalac(Socket socket) {
        this.socket = socket;
    }

    public void send(Object object) throws Exception {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeObject(object);
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom slanja objekta: " + ex.getMessage());
        }

    }
}
