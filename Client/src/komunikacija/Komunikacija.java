/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.net.Socket;

/**
 *
 * @author aleks
 */
public class Komunikacija {

    private static Komunikacija instance;
    private Socket socket;

    private Komunikacija() {

    }

    public static Komunikacija getInstance() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Odgovor login(Zahtev request) throws Exception {
        //posalji zahtev
        new Posiljalac(socket).send(request);
        System.out.println("Zahtev za prijavom na sistem je poslat.");
        return (Odgovor) new PrimanjePoruka(socket).receive();
    }

    public Odgovor vratiKlijente(Zahtev request) throws Exception {
        new Posiljalac(socket).send(request);
        System.out.println("Zahtev vratiKlijente je poslat.");
        return (Odgovor) new PrimanjePoruka(socket).receive();
    }

    public Odgovor izmeniKlijenta(Zahtev request) throws Exception {
        new Posiljalac(socket).send(request);
        System.out.println("Zahtev izmeniKlijenta je poslat.");
        return (Odgovor) new PrimanjePoruka(socket).receive();
    }

    public Odgovor dodajKlijenta(Zahtev request) throws Exception {
        new Posiljalac(socket).send(request);
        System.out.println("Zahtev dodajKlijenta je poslat.");
        return (Odgovor) new PrimanjePoruka(socket).receive();
    }

    public Odgovor nadjiKlijente(Zahtev request) throws Exception {
        new Posiljalac(socket).send(request);
        System.out.println("Zahtev nadjiKlijente je poslat.");
        return (Odgovor) new PrimanjePoruka(socket).receive();
    }

    public Odgovor izmeniProizvod(Zahtev request) throws Exception {
        new Posiljalac(socket).send(request);
        System.out.println("Zahtev izmeniProizvod je poslat.");
        return (Odgovor) new PrimanjePoruka(socket).receive();
    }

    public Odgovor vratiProizvode(Zahtev request) throws Exception {
        new Posiljalac(socket).send(request);
        System.out.println("Zahtev vratiProizvode je poslat.");
        return (Odgovor) new PrimanjePoruka(socket).receive();
    }

    public Odgovor dodajProizvod(Zahtev request) throws Exception {
        new Posiljalac(socket).send(request);
        System.out.println("Zahtev dodajProizvod je poslat.");
        return (Odgovor) new PrimanjePoruka(socket).receive();
    }

    public Odgovor nadjiProizvode(Zahtev request) throws Exception {
        new Posiljalac(socket).send(request);
        System.out.println("Zahtev nadjiProizvode je poslat.");
        return (Odgovor) new PrimanjePoruka(socket).receive();
    }

    public Odgovor vratiNarudzbine(Zahtev request) throws Exception {
        new Posiljalac(socket).send(request);
        System.out.println("Zahtev vratiNarudzbine je poslat.");
        return (Odgovor) new PrimanjePoruka(socket).receive();
    }

    public Odgovor nadjiNarudzbine(Zahtev request) throws Exception {
        new Posiljalac(socket).send(request);
        System.out.println("Zahtev nadjiNarudzbine je poslat.");
        return (Odgovor) new PrimanjePoruka(socket).receive();
    }

    public Odgovor dodajNarudzbinu(Zahtev request) throws Exception {
        new Posiljalac(socket).send(request);
        System.out.println("Zahtev dodajNarudzbinu je poslat.");
        return (Odgovor) new PrimanjePoruka(socket).receive();
    }

}
