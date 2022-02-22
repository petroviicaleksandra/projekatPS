/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Narudzbina;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleNarudzbina extends AbstractTableModel {

    List<Narudzbina> lista;
    String[] kolone = {"Narudzbina ID", "Iznos", "Datum", "Prodavac", "Klijent"};

    public ModelTabeleNarudzbina() {
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
        Narudzbina n = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        switch (columnIndex) {
            case 0:
                return n.getNarudzbinaID();
            case 1:
                return n.getIznos();
            case 2:
                return sdf.format(n.getDatum());
            case 3:
                return n.getProdavac().getIme();
            case 4:
                return n.getKlijent().getIme();

            default:
                return "return!";
        }
    }

    public List<Narudzbina> getLista() {
        return lista;
    }

    public void setLista(List<Narudzbina> narudzbine) {
        lista = narudzbine;
        fireTableDataChanged();
    }

}
