/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleks
 */
public class Klijent implements OpstiDomenskiObjekat {

    private int klijentID;
    private String telefon;
    private String adresa;
    private String ime;
    private String prezime;
    private String pretraga;

    public Klijent() {
    }

    public Klijent(int klijentID, String telefon, String adresa, String ime, String prezime) {
        this.klijentID = klijentID;
        this.telefon = telefon;
        this.adresa = adresa;
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "klijent";
    }

    @Override
    public String vratiVrednostiZaAdd() {
        return "'" + telefon + "','" + adresa + "','" + ime + "','" + prezime + "'";

    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "telefon = '" + telefon + "', adresa = '" + adresa + "', ime = '" + ime
                + "', prezime = '" + prezime + "'";
    }

    @Override
    public String vratiUslovZaOperacijuUpdate() {
        return "klijentID = '" + klijentID + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {

        try {
            List<OpstiDomenskiObjekat> klijenti = new ArrayList<>();
            while (rs.next()) {
                Klijent klijent = new Klijent();
                klijent.setKlijentID(rs.getInt("klijentid"));
                klijent.setTelefon(rs.getString("telefon"));
                klijent.setAdresa(rs.getString("adresa"));
                klijent.setIme(rs.getString("ime"));
                klijent.setPrezime(rs.getString("prezime"));

                klijenti.add(klijent);
            }
            System.out.println("Uspesno ucitana lista klijenata!");
            return klijenti;
        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    @Override
    public String vratiUslovZaPretragu() {
        return "ime LIKE " + "'" + pretraga + "%'";
    }

    @Override
    public String vratiUslovZaID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiIme(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoinTabelu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJoin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoinTabelu2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJoin2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPretraga() {
        return pretraga;
    }

    public void setPretraga(String pretraga) {
        this.pretraga = pretraga;
    }

    @Override
    public String vratiParametre() {
        return "telefon, adresa, ime, prezime";
    }

    @Override
    public void setId(int id) {
        this.klijentID = id;
    }

}
