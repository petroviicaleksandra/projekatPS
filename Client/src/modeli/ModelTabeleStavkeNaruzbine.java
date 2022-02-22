/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import domen.StavkaNarudzbine;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleStavkeNaruzbine extends AbstractTableModel {

    ArrayList<OpstiDomenskiObjekat> lista;
    String[] kolone = {"Proizvod", "Cena", "Kolicina", "Iznos"};

    public ModelTabeleStavkeNaruzbine() {
        lista = new ArrayList<>();
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
        StavkaNarudzbine sn = (StavkaNarudzbine) lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return sn.getProizvod();
            case 1:
                return sn.getCena();
            case 2:
                return sn.getKolicina();
            case 3:
                return sn.getIznos();

            default:
                return "return!";
        }
    }

    public ArrayList<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void dodajStavku(StavkaNarudzbine sn) {
        lista.add(sn);
        fireTableDataChanged();
    }

    public void obrisiStavku(int selectedRow) {
        lista.remove(selectedRow);
        fireTableDataChanged();
    }

}
