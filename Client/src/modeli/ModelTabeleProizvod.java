/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Proizvod;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleProizvod extends AbstractTableModel {

    List<Proizvod> lista;
    String[] kolone = {"Proizvod ID", "Cena", "Naziv"};

    public ModelTabeleProizvod() {
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
        Proizvod p = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getProizvodID();
            case 1:
                return p.getCena();
            case 2:
                return p.getNaziv();

            default:
                return "return!";
        }
    }

    public List<Proizvod> getLista() {
        return lista;
    }

    public void setLista(List<Proizvod> proizvodi) {
        lista = proizvodi;
        fireTableDataChanged();
    }

    public Proizvod vratiProizvod(int row) {
        return lista.get(row);
    }

    public void izmeniProizvod(int selectedRow, Proizvod p) {
        lista.set(selectedRow, p);
        fireTableDataChanged();
    }

}
