/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import baza.DBProperties;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import domen.Prodavac;

/**
 *
 * @author aleks
 */

public class ServerNit extends Thread{
    private ServerSocket serverSocket;
    private List<ObradaKlijentskihZahteva> prodavci;

    public ServerNit() throws IOException {
        
//        serverSocket=new ServerSocket(9000);
        prodavci=new ArrayList<>();
    }
    
    

    @Override
    public void run() {
        
            try {
                DBProperties dbp = new DBProperties();
                int port = Integer.parseInt(dbp.vratiDBPort());
                serverSocket = new ServerSocket(port);
                System.out.println("Cekam klijenta...");
                while(!serverSocket.isClosed()){
                Socket socket=serverSocket.accept();
                ObradaKlijentskihZahteva thread=new ObradaKlijentskihZahteva(socket);
                thread.start();
                prodavci.add(thread);
                System.out.println("Klijent se povezao!");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
        stopAllThreads();
    }
    
    private void stopAllThreads(){
        for (ObradaKlijentskihZahteva prodavac : prodavci) {
            try {
                prodavac.getSocket().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public List<Prodavac> getSveProdavce(){
        List<Prodavac> korisnici=new ArrayList<>();
        for (ObradaKlijentskihZahteva prodavac : prodavci) {
            korisnici.add(prodavac.getProdavac());
            System.out.println(prodavac.getProdavac().getIme());
        }
        return korisnici;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
    
    
    
}
