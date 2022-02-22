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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleks
 */
public class Narudzbina implements OpstiDomenskiObjekat {

    private int narudzbinaID;
    private int iznos;
    private Date datum;
    private Prodavac prodavac;
    private Klijent klijent;
    private ArrayList<OpstiDomenskiObjekat> listaStavkiNarudzbine;
    private String pretraga;

    public Narudzbina() {
    }

    public Narudzbina(int narudzbinaID, int iznos, Date datum, Prodavac prodavac, Klijent klijent) {
        this.narudzbinaID = narudzbinaID;
        this.iznos = iznos;
        this.datum = datum;
        this.prodavac = prodavac;
        this.klijent = klijent;
        this.listaStavkiNarudzbine = new ArrayList<>();
    }

    public int getNarudzbinaID() {
        return narudzbinaID;
    }

    public void setNarudzbinaID(int narudzbinaID) {
        this.narudzbinaID = narudzbinaID;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }

    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public ArrayList<OpstiDomenskiObjekat> getListaStavkiNarudzbine() {
        return listaStavkiNarudzbine;
    }

    public void setListaStavkiNarudzbine(ArrayList<OpstiDomenskiObjekat> listaStavkiNarudzbine) {
        this.listaStavkiNarudzbine = listaStavkiNarudzbine;
    }

    @Override
    public String vratiNazivTabele() {
        return "narudzbina";
    }

    @Override
    public String vratiVrednostiZaAdd() {

        return "'" + iznos + "','" + datum + "','" + prodavac.getProdavacID() + "','" + klijent.getKlijentID() + "'";

    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaOperacijuUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        try {
            List<OpstiDomenskiObjekat> narudzbine = new ArrayList<>();

            while (rs.next()) {
                Prodavac p = new Prodavac(rs.getInt("prodavac.prodavacid"), rs.getString("prodavac.ime"),
                        rs.getString("prodavac.telefon"), rs.getString("prodavac.lozinka"));
                Klijent k = new Klijent(rs.getInt("klijent.klijentid"), rs.getString("klijent.telefon"),
                        rs.getString("klijent.adresa"), rs.getString("klijent.ime"), rs.getString("klijent.prezime"));

                Narudzbina narudzbina = new Narudzbina();
                narudzbina.setNarudzbinaID(rs.getInt("narudzbina.narudzbinaid"));
                narudzbina.setIznos(rs.getInt("narudzbina.iznos"));
                narudzbina.setDatum(rs.getDate("narudzbina.datum"));
                narudzbina.setProdavac(p);
                narudzbina.setKlijent(k);

                narudzbine.add(narudzbina);
            }
            return narudzbine;
        } catch (SQLException ex) {
            throw new SQLException("Neuspesno ucitavanje liste narudzbina!\n", ex);
        }

    }

    @Override
    public String vratiUslovZaPretragu() {
        return "narudzbina.narudzbinaid =" + "'" + pretraga + "%'";
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
        return "prodavac";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "narudzbina.prodavacid=prodavac.prodavacid";
    }

    @Override
    public String vratiJoinTabelu2() {
        return "klijent";
    }

    @Override
    public String vratiUslovZaJoin2() {
        return "narudzbina.klijentid=klijent.klijentid";
    }

    public String getPretraga() {
        return pretraga;
    }

    public void setPretraga(String pretraga) {
        this.pretraga = pretraga;
    }

    @Override
    public String vratiParametre() {
        return "iznos, datum, prodavacid, klijentid";
    }

    @Override
    public void setId(int id) {
        this.narudzbinaID = id;
    }

}
