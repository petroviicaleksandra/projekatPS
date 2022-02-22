/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author aleks
 */
public interface OpstiDomenskiObjekat extends Serializable {

    public String vratiNazivTabele();

    public String vratiParametre();

    public String vratiVrednostiZaAdd();

    public String vratiVrednostiZaUpdate();

    public String vratiUslovZaOperacijuUpdate();

    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException;

    public String vratiUslovZaPretragu();

    public String vratiUslovZaID();

    public String vratiIme(ResultSet rs);

    public String vratiJoinTabelu();

    public String vratiUslovZaJoin();

    public String vratiJoinTabelu2();

    public String vratiUslovZaJoin2();

    public void setId(int id);
}
