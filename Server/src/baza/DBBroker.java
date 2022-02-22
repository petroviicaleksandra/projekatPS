/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleks
 */
public class DBBroker {

    private static DBBroker instance;
    private Connection konekcija;

    private DBBroker() throws IOException, SQLException, ClassNotFoundException {
        DBProperties dbp = new DBProperties();
        String url = dbp.vratiDBURL();
        String user = dbp.vratiDBKorisnik();
        String password = dbp.vratiDBSifra();

        konekcija = DriverManager.getConnection(url, user, password);
        konekcija.setAutoCommit(false);
    }

    public static DBBroker getInstance() throws IOException, SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public void zatvoriKonekciju() throws SQLException {
        konekcija.close();
    }

    public void potvrdiTransakciju() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ponistiTransakciju() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void izmeni(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaUpdate() + " WHERE " + odo.vratiUslovZaOperacijuUpdate();
        System.out.println(sql);
        Statement s = konekcija.createStatement();
        s.executeUpdate(sql);
        s.close();
    }

    public List<OpstiDomenskiObjekat> vratiSaUslovom(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaPretragu();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public List<OpstiDomenskiObjekat> vratiBezUslova(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public List<OpstiDomenskiObjekat> vratiSaUslovomTriTabele(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " JOIN "
                + odo.vratiJoinTabelu() + " ON " + odo.vratiUslovZaJoin() + " JOIN "
                + odo.vratiJoinTabelu2() + " ON " + odo.vratiUslovZaJoin2() + " WHERE " + odo.vratiUslovZaPretragu();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public List<OpstiDomenskiObjekat> vratiJoinovaneTriTabele(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " JOIN "
                + odo.vratiJoinTabelu() + " ON " + odo.vratiUslovZaJoin() + " JOIN "
                + odo.vratiJoinTabelu2() + " ON " + odo.vratiUslovZaJoin2();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public void sacuvaj(OpstiDomenskiObjekat odo) throws Exception {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + "(" + odo.vratiParametre() + ") VALUES (" + odo.vratiVrednostiZaAdd() + ")";
        System.out.println(upit);
        PreparedStatement sqlStatement = konekcija.prepareStatement(upit);
        sqlStatement.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);
        ResultSet rsKey = sqlStatement.getGeneratedKeys();
        if (rsKey.next()) {
            int id = rsKey.getInt(1);
            odo.setId(id);
        }
    }

}
