/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Klijent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleKlijent extends AbstractTableModel {

    List<Klijent> lista;
    String[] kolone = {"Klijent ID", "Broj telefona", "Adresa", "Ime", "Prezime"};

    public ModelTabeleKlijent() {
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
        Klijent k = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getKlijentID();
            case 1:
                return k.getTelefon();
            case 2:
                return k.getAdresa();
            case 3:
                return k.getIme();
            case 4:
                return k.getPrezime();

            default:
                return "return!";
        }
    }

    public List<Klijent> getLista() {
        return lista;
    }

    public void setLista(List<Klijent> klijenti) {
        this.lista = klijenti;
        fireTableDataChanged();
    }

    public Klijent vratiKlijente(int row) {
        return lista.get(row);
    }

    public void izmeniKlijenta(int selectedRow, Klijent k) {
        lista.set(selectedRow, k);
        fireTableDataChanged();
    }

}
