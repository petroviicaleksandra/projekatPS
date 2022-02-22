/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.OpstiDomenskiObjekat;
import forme.ServerskaForma;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;
import so.klijent.SODodajKlijenta;
import so.klijent.SOIzmeniKlijenta;
import so.klijent.SOPronadjiKlijenta;
import so.klijent.SOVratiKlijente;
import so.narudzbina.SODodajNarudzbinu;
import so.narudzbina.SOPronadjiNarudzbinu;
import so.narudzbina.SOVratiNarudzbine;
import so.prodavac.SOPronadjiProdavca;
import so.proizvod.SODodajProizvod;
import so.proizvod.SOIzmeniProizvod;
import so.proizvod.SOPronadjiProizvod;
import so.proizvod.SOVratiProizvode;

/**
 *
 * @author aleks
 */
public class Kontroler {

    private static Kontroler instance;
    private ServerskaForma forma;
    ArrayList<Socket> listaKorisnika = new ArrayList<>();

    private Kontroler() {

    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public ServerskaForma getForma() {
        return forma;
    }

    public void setForma(ServerskaForma forma) {
        this.forma = forma;
    }

    public ArrayList<Socket> getListaKorisnika() {
        return listaKorisnika;
    }

    public static void setInstance(Kontroler instance) {
        Kontroler.instance = instance;
    }

    public void dodajKorisnika(Socket socket) {
        listaKorisnika.add(socket);
    }

    public List<OpstiDomenskiObjekat> vratiListuKlijenata(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiKlijente();
        oso.izvrsi(odo);
        return ((SOVratiKlijente) oso).getLista();
    }

    public List<OpstiDomenskiObjekat> vratiListuNarudzbina(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiNarudzbine();
        oso.izvrsi(odo);
        return ((SOVratiNarudzbine) oso).getLista();
    }

    public List<OpstiDomenskiObjekat> vratiListuProizvoda(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiProizvode();
        oso.izvrsi(odo);
        return ((SOVratiProizvode) oso).getLista();
    }

    public List<OpstiDomenskiObjekat> pretraziKlijente(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOPronadjiKlijenta();
        oso.izvrsi(odo);
        return ((SOPronadjiKlijenta) oso).getLista();
    }

    public Object pretraziProdavce(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOPronadjiProdavca();
        oso.izvrsi(odo);
        return ((SOPronadjiProdavca) oso).getLista();
    }

    public List<OpstiDomenskiObjekat> pretraziProizvode(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOPronadjiProizvod();
        oso.izvrsi(odo);
        return ((SOPronadjiProizvod) oso).getLista();
    }

    public List<OpstiDomenskiObjekat> pretraziNarudzbine(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOPronadjiNarudzbinu();
        oso.izvrsi(odo);
        return ((SOPronadjiNarudzbinu) oso).getLista();
    }

    public void izmeniKlijenta(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOIzmeniKlijenta();
        oso.izvrsi(odo);
    }

    public void izmeniProizvod(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOIzmeniProizvod();
        oso.izvrsi(odo);
    }

    public void zapamtiKlijenta(OpstiDomenskiObjekat odo) throws Exception {

        OpstaSistemskaOperacija oso = new SODodajKlijenta();
        oso.izvrsi(odo);
    }

    public void zapamtiProizvod(OpstiDomenskiObjekat odo) throws Exception {

        OpstaSistemskaOperacija oso = new SODodajProizvod();
        oso.izvrsi(odo);
    }

    public void zapamtiNarudzbinu(OpstiDomenskiObjekat odo) throws Exception {

        OpstaSistemskaOperacija oso = new SODodajNarudzbinu();
        oso.izvrsi(odo);
    }

}
