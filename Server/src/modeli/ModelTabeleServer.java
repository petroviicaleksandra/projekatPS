/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.OpstiDomenskiObjekat;
import domen.Prodavac;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import niti.ObradaKlijentskihZahteva;

/**
 *
 * @author aleks
 */
public class ModelTabeleServer extends AbstractTableModel {

    List<OpstiDomenskiObjekat> lista;
    String[] kolone = {"Prodavac ID", "Ime", "Telefon", "Datum prijave"};

    public ModelTabeleServer() {
        lista = new ArrayList<>();
    }

    public ModelTabeleServer(ArrayList<OpstiDomenskiObjekat> listaKorisnika) {
        this.lista = listaKorisnika;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prodavac p = (Prodavac) lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        switch (columnIndex) {
            case 0:
                return p.getProdavacID();
            case 1:
                return p.getIme();
            case 2:
                return p.getTelefon();
            case 3:
                return sdf.format(p.getDatumPrijave());

            default:
                return "return!";
        }
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> prodavci) {
        this.lista = prodavci;
        fireTableDataChanged();
    }

    public void dodajProdavca(Prodavac p) {
        lista.add(p);
        fireTableDataChanged();
    }

}
