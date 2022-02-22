/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Klijent;
import domen.Narudzbina;
import domen.OpstiDomenskiObjekat;
import domen.Prodavac;
import domen.Proizvod;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Operacije;
import komunikacija.PrimanjePoruka;
import komunikacija.Zahtev;
import komunikacija.Odgovor;
import komunikacija.TipOdgovora;
import komunikacija.Posiljalac;
import kontroler.Kontroler;

/**
 *
 * @author aleks
 */
public class ObradaKlijentskihZahteva extends Thread {

    private Socket socket;
    private Prodavac prodavac;
    List<ObradaKlijentskihZahteva> prodavci;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                Zahtev request = (Zahtev) new PrimanjePoruka(socket).receive();
                Odgovor response = handleRequest(request);
                new Posiljalac(socket).send(response);
            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    private Odgovor handleRequest(Zahtev request) {
        int operation = request.getOperacija();
        switch (operation) {
            case Operacije.LOGIN:
                return login(request);
            case Operacije.VRATI_KLIJENTE:
                return vratiKlijente(request);
            case Operacije.IZMENI_KLIJENTE:
                return izmeniKlijenta(request);
            case Operacije.DODAJ_KLIJENTA:
                return dodajKlijenta(request);
            case Operacije.NADJI_KLIJENTE:
                return nadjiKlijente(request);
            case Operacije.VRATI_PROIZVODE:
                return vratiProizvode(request);
            case Operacije.IZMENI_PROIZVODE:
                return izmeniProizvod(request);
            case Operacije.NADJI_PROIZVODE:
                return nadjiProizvode(request);
            case Operacije.DODAJ_PROIZVOD:
                return dodajProizvode(request);
            case Operacije.VRATI_NARUDZBINE:
                return vratiNarudzbine(request);
            case Operacije.NADJI_NARUDZBINE:
                return nadjiNarudzbine(request);
            case Operacije.DODAJ_NARUDZBINU:
                return dodajNarudzbinu(request);
        }
        return null;
    }

    private Odgovor login(Zahtev request) {
        Odgovor response = new Odgovor();

        Prodavac requestProdavac = (Prodavac) request.getParametar();

        try {
            List<Prodavac> prod = (List<Prodavac>) Kontroler.getInstance().pretraziProdavce(requestProdavac);
            Prodavac p = prod.get(0);
            Kontroler.getInstance().getForma().vratiTabeluKorisnika().dodajProdavca(p);

            p.setDatumPrijave(new Date());

            System.out.println("Uspesna prijava na sistem.");
            response.setResponseType(TipOdgovora.SUCCESS);
            response.setResult(p);
            this.prodavac = p;
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(TipOdgovora.ERROR);
            response.setException(ex);
        }
        return response;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }

    private Odgovor vratiKlijente(Zahtev request) {
        Odgovor response = new Odgovor();

        try {
            List<OpstiDomenskiObjekat> klijenti = Kontroler.getInstance().vratiListuKlijenata(new Klijent());

            System.out.println("Uspesno ucitana lista klijenata.");
            response.setResponseType(TipOdgovora.SUCCESS);
            response.setResult(klijenti);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(TipOdgovora.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Odgovor izmeniKlijenta(Zahtev request) {
        Odgovor response = new Odgovor();
        OpstiDomenskiObjekat klijent = (OpstiDomenskiObjekat) request.getParametar();
        try {

            Kontroler.getInstance().izmeniKlijenta(klijent);

            System.out.println("Uspesno izmenjen klijent.");
            response.setResponseType(TipOdgovora.SUCCESS);
            response.setResult(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(TipOdgovora.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Odgovor dodajKlijenta(Zahtev request) {
        Odgovor response = new Odgovor();
        OpstiDomenskiObjekat klijent = (OpstiDomenskiObjekat) request.getParametar();
        try {

            Kontroler.getInstance().zapamtiKlijenta(klijent);
            System.out.println("Uspesno dodat klijent.");
            response.setResponseType(TipOdgovora.SUCCESS);
            response.setResult(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(TipOdgovora.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Odgovor nadjiKlijente(Zahtev request) {
        Odgovor response = new Odgovor();
        Klijent k = (Klijent) request.getParametar();
        try {
            List<OpstiDomenskiObjekat> klijenti = Kontroler.getInstance().pretraziKlijente(k);

            System.out.println("Uspesno ucitana lista pronadjenih klijenata.");
            response.setResponseType(TipOdgovora.SUCCESS);
            response.setResult(klijenti);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(TipOdgovora.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Odgovor vratiProizvode(Zahtev request) {
        Odgovor response = new Odgovor();

        try {
            List<OpstiDomenskiObjekat> proizvodi = Kontroler.getInstance().vratiListuProizvoda(new Proizvod());

            System.out.println("Uspesno ucitana lista proizvoda.");
            response.setResponseType(TipOdgovora.SUCCESS);
            response.setResult(proizvodi);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(TipOdgovora.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Odgovor izmeniProizvod(Zahtev request) {
        Odgovor response = new Odgovor();
        OpstiDomenskiObjekat p = (OpstiDomenskiObjekat) request.getParametar();
        try {

            Kontroler.getInstance().izmeniProizvod(p);

            System.out.println("Uspesno izmenjen proizvod.");
            response.setResponseType(TipOdgovora.SUCCESS);
            response.setResult(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(TipOdgovora.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Odgovor dodajProizvode(Zahtev request) {
        Odgovor response = new Odgovor();
        OpstiDomenskiObjekat proizvod = (OpstiDomenskiObjekat) request.getParametar();
        try {
            Kontroler.getInstance().zapamtiProizvod(proizvod);

            System.out.println("Uspesno kreiran proizvod.");
            response.setResponseType(TipOdgovora.SUCCESS);
            response.setResult(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(TipOdgovora.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Odgovor nadjiProizvode(Zahtev request) {
        Odgovor response = new Odgovor();
        Proizvod p = (Proizvod) request.getParametar();
        try {
            List<OpstiDomenskiObjekat> proizvodi = Kontroler.getInstance().pretraziProizvode(p);

            System.out.println("Uspesno ucitana lista pronadjenih proizvoda.");
            response.setResponseType(TipOdgovora.SUCCESS);
            response.setResult(proizvodi);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(TipOdgovora.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Odgovor vratiNarudzbine(Zahtev request) {
        Odgovor response = new Odgovor();

        try {
            List<OpstiDomenskiObjekat> narudzbine = Kontroler.getInstance().vratiListuNarudzbina(new Narudzbina());

            System.out.println("Uspesno ucitana lista narudzbina.");
            response.setResponseType(TipOdgovora.SUCCESS);
            response.setResult(narudzbine);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(TipOdgovora.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Odgovor nadjiNarudzbine(Zahtev request) {
        Odgovor response = new Odgovor();
        Narudzbina n = (Narudzbina) request.getParametar();
        try {
            List<OpstiDomenskiObjekat> narudzbine = Kontroler.getInstance().pretraziNarudzbine(n);

            System.out.println("Uspesno ucitana lista pronadjenih narudzbina.");
            response.setResponseType(TipOdgovora.SUCCESS);
            response.setResult(narudzbine);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(TipOdgovora.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Odgovor dodajNarudzbinu(Zahtev request) {
        Odgovor response = new Odgovor();
        OpstiDomenskiObjekat narudzbina = (OpstiDomenskiObjekat) request.getParametar();
        try {
            Kontroler.getInstance().zapamtiNarudzbinu(narudzbina);

            System.out.println("Uspesno kreiran proizvod.");
            response.setResponseType(TipOdgovora.SUCCESS);
            response.setResult(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(TipOdgovora.ERROR);
            response.setException(ex);
        }
        return response;
    }

}
