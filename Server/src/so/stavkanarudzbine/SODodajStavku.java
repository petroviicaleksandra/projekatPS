/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stavkanarudzbine;

import baza.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.StavkaNarudzbine;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author aleks
 */
public class SODodajStavku extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if(odo == null || !(odo instanceof StavkaNarudzbine)){
            throw new Exception("Los parametar!");
        }
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        DBBroker.getInstance().sacuvaj(odo);
    }
    
}
