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
public class Proizvod implements OpstiDomenskiObjekat {

    private int proizvodID;
    private String naziv;
    private int cena;
    private String pretraga;

    public Proizvod() {
    }

    public Proizvod(int proizvodID, String naziv, int cena) {
        this.proizvodID = proizvodID;
        this.naziv = naziv;
        this.cena = cena;

    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(int proizvodID) {
        this.proizvodID = proizvodID;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "proizvod";
    }

    @Override
    public String vratiVrednostiZaAdd() {
        return "'" + naziv + "','" + cena + "'";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "naziv = '" + naziv + "', cena = '" + cena + "'";
    }

    @Override
    public String vratiUslovZaOperacijuUpdate() {
        return "proizvodid = '" + proizvodID + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        try {
            List<OpstiDomenskiObjekat> proizvodi = new ArrayList<>();
            while (rs.next()) {
                Proizvod proizvod = new Proizvod();
                proizvod.setProizvodID(rs.getInt("proizvodid"));
                proizvod.setNaziv(rs.getString("naziv"));
                proizvod.setCena(rs.getInt("cena"));
                proizvodi.add(proizvod);

            }
            rs.close();
            System.out.println("Uspesno ucitavanje liste proizvoda!");
            return proizvodi;
        } catch (SQLException ex) {
            System.out.println("Neuspesno ucitavanje liste proizvoda!");
            throw ex;
        }

    }

    @Override
    public String vratiUslovZaPretragu() {
        return "naziv LIKE " + "'%" + pretraga + "%'";
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
        return "naziv, cena";
    }

    @Override
    public void setId(int id) {
        this.proizvodID = id;
    }

}
