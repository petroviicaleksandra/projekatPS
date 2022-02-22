/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Operacije;
import komunikacija.PrimanjePoruka;
import komunikacija.Zahtev;
import komunikacija.Odgovor;
import komunikacija.TipOdgovora;
import komunikacija.Posiljalac;
import forme.ServerskaForma;

/**
 *
 * @author aleks
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        new ServerskaForma().setVisible(true);
    }
    
}

