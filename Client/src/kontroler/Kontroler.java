/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Klijent;
import domen.Narudzbina;
import domen.Prodavac;
import domen.Proizvod;
import java.util.List;
import komunikacija.Komunikacija;
import komunikacija.Operacije;
import komunikacija.Zahtev;
import komunikacija.Odgovor;
import komunikacija.TipOdgovora;

/**
 *
 * @author aleks
 */
public class Kontroler {

    private static Kontroler instance;
    private Prodavac trenutniProdavac;

    private Kontroler() {

    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Prodavac login(String username, String password) throws Exception {
        Prodavac prodavac = new Prodavac();
        prodavac.setLozinka(password);
        prodavac.setIme(username);

        Zahtev request = new Zahtev(Operacije.LOGIN, prodavac);
        Odgovor response = Komunikacija.getInstance().login(request);

        if (response.getResponseType().equals(TipOdgovora.SUCCESS)) {
            Prodavac p = (Prodavac) response.getResult();
            return p;
        } else {
            throw response.getException();
        }
    }

    public void setCurrentProdavac(Prodavac prod) {
        this.trenutniProdavac = prod;
    }

    public Prodavac getCurrentProdavac() {
        return trenutniProdavac;
    }

    public List<Klijent> vratiKlijente() throws Exception {
        Zahtev request = new Zahtev(Operacije.VRATI_KLIJENTE, null);
        Odgovor response = Komunikacija.getInstance().vratiKlijente(request);

        if (response.getResponseType().equals(TipOdgovora.SUCCESS)) {
            List<Klijent> klijenti = (List<Klijent>) response.getResult();
            return klijenti;
        } else {
            throw response.getException();
        }
    }

    public void izmeniKlijenta(Klijent k) throws Exception {
        Zahtev request = new Zahtev(Operacije.IZMENI_KLIJENTE, k);
        Odgovor response = Komunikacija.getInstance().izmeniKlijenta(request);

        if (response.getResponseType().equals(TipOdgovora.SUCCESS)) {

        } else {
            throw response.getException();
        }
    }

    public void dodajKlijenta(Klijent k) throws Exception {
        Zahtev request = new Zahtev(Operacije.DODAJ_KLIJENTA, k);
        Odgovor response = Komunikacija.getInstance().dodajKlijenta(request);

        if (response.getResponseType().equals(TipOdgovora.SUCCESS)) {

        } else {
            throw response.getException();
        }
    }

    public List<Klijent> nadjiKlijente(Klijent klijent) throws Exception {
        Zahtev request = new Zahtev(Operacije.NADJI_KLIJENTE, klijent);
        Odgovor response = Komunikacija.getInstance().nadjiKlijente(request);

        if (response.getResponseType().equals(TipOdgovora.SUCCESS)) {
            List<Klijent> klijenti = (List<Klijent>) response.getResult();
            return klijenti;
        } else {
            throw response.getException();
        }
    }

    public List<Proizvod> vratiProizvode() throws Exception {
        Zahtev request = new Zahtev(Operacije.VRATI_PROIZVODE, null);
        Odgovor response = Komunikacija.getInstance().vratiProizvode(request);

        if (response.getResponseType().equals(TipOdgovora.SUCCESS)) {
            List<Proizvod> proizvodi = (List<Proizvod>) response.getResult();
            return proizvodi;
        } else {
            throw response.getException();
        }
    }

    public void izmeniProizvod(Proizvod p) throws Exception {
        Zahtev request = new Zahtev(Operacije.IZMENI_PROIZVODE, p);
        Odgovor response = Komunikacija.getInstance().izmeniProizvod(request);

        if (response.getResponseType().equals(TipOdgovora.SUCCESS)) {

        } else {
            throw response.getException();
        }
    }

    public List<Proizvod> nadjiProizvode(Proizvod p) throws Exception {
        Zahtev request = new Zahtev(Operacije.NADJI_PROIZVODE, p);
        Odgovor response = Komunikacija.getInstance().nadjiProizvode(request);

        if (response.getResponseType().equals(TipOdgovora.SUCCESS)) {
            List<Proizvod> proizvodi = (List<Proizvod>) response.getResult();
            return proizvodi;
        } else {
            throw response.getException();
        }
    }

    public void dodajProizvod(Proizvod p) throws Exception {
        Zahtev request = new Zahtev(Operacije.DODAJ_PROIZVOD, p);
        Odgovor response = Komunikacija.getInstance().dodajProizvod(request);

        if (response.getResponseType().equals(TipOdgovora.SUCCESS)) {

        } else {
            throw response.getException();
        }
    }

    public List<Narudzbina> vratiNarudzbine() throws Exception {
        Zahtev request = new Zahtev(Operacije.VRATI_NARUDZBINE, null);
        Odgovor response = Komunikacija.getInstance().vratiNarudzbine(request);

        if (response.getResponseType().equals(TipOdgovora.SUCCESS)) {
            List<Narudzbina> narudzbine = (List<Narudzbina>) response.getResult();
            return narudzbine;
        } else {
            throw response.getException();
        }
    }

    public List<Narudzbina> nadjiNarudzbine(Narudzbina n) throws Exception {
        Zahtev request = new Zahtev(Operacije.NADJI_NARUDZBINE, n);
        Odgovor response = Komunikacija.getInstance().nadjiNarudzbine(request);

        if (response.getResponseType().equals(TipOdgovora.SUCCESS)) {
            List<Narudzbina> narudzbine = (List<Narudzbina>) response.getResult();
            return narudzbine;
        } else {
            throw response.getException();
        }
    }

    public void dodajNarudzbinu(Narudzbina n) throws Exception {
        Zahtev request = new Zahtev(Operacije.DODAJ_NARUDZBINU, n);
        Odgovor response = Komunikacija.getInstance().dodajNarudzbinu(request);

        if (response.getResponseType().equals(TipOdgovora.SUCCESS)) {

        } else {
            throw response.getException();
        }
    }

}
