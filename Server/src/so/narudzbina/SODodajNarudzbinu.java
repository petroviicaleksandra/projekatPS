/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.narudzbina;

import baza.DBBroker;
import domen.Narudzbina;
import domen.OpstiDomenskiObjekat;
import domen.StavkaNarudzbine;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author aleks
 */
public class SODodajNarudzbinu extends OpstaSistemskaOperacija {

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if(odo==null || !(odo instanceof Narudzbina)){
            throw new Exception("Los parametar");
        }
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        DBBroker.getInstance().sacuvaj(odo);
        sacuvajStavke(odo);
    }

    private void sacuvajStavke(OpstiDomenskiObjekat odo) throws Exception {

        Narudzbina nar = (Narudzbina) odo;
        ArrayList<OpstiDomenskiObjekat> stavke = nar.getListaStavkiNarudzbine();
        for (OpstiDomenskiObjekat objekat : stavke) {
            
            StavkaNarudzbine sn = (StavkaNarudzbine) objekat;
            sn.setNarudzbina(nar);
            DBBroker.getInstance().sacuvaj(sn);
        }
    }

}
