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
import java.util.Date;
import java.util.List;

/**
 *
 * @author aleks
 */
public class Prodavac implements OpstiDomenskiObjekat {

    private int prodavacID;
    private String ime;
    private String telefon;
    private String lozinka;
    private Date datumPrijave;

    public Prodavac() {
    }

    public Prodavac(int prodavacID, String ime, String telefon, String lozinka) {
        this.prodavacID = prodavacID;
        this.ime = ime;
        this.telefon = telefon;
        this.lozinka = lozinka;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getProdavacID() {
        return prodavacID;
    }

    public void setProdavacID(int prodavacID) {
        this.prodavacID = prodavacID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return ime;
    }

    @Override
    public String vratiNazivTabele() {
        return "prodavac";
    }

    @Override
    public String vratiVrednostiZaAdd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

            List<OpstiDomenskiObjekat> prodavci = new ArrayList<>();

            while (rs.next()) {
                Prodavac prod = new Prodavac();
                prod.setProdavacID(rs.getInt("prodavacid"));
                prod.setIme(rs.getString("ime"));
                prod.setTelefon(rs.getString("telefon"));
                prod.setLozinka(rs.getString("lozinka"));
                prodavci.add(prod);
            }
            System.out.println("Uspesno ucitana lista prodavaca!");
            return prodavci;
        } catch (SQLException ex) {
            System.out.println("Neuspesno ucitavanje liste prodavaca!\n" + ex);
            throw ex;
        }

    }

    @Override
    public String vratiUslovZaPretragu() {
        return "ime = '" + ime + "' AND lozinka = '" + lozinka + "'";
    }

    @Override
    public String vratiUslovZaID() {
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

    @Override
    public String vratiParametre() {
        return "ime, telefon, lozinka";
    }

    @Override
    public String vratiIme(ResultSet rs) {
        return "ime";
    }

    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Date getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(Date datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

}
