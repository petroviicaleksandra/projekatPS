/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import baza.DBBroker;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author aleks
 */
public class SOVratiKlijente extends OpstaSistemskaOperacija{

    List<OpstiDomenskiObjekat> lista;
    
    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if(odo==null || !(odo instanceof Klijent)){
            throw new Exception("Los parametar");
        }
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        lista = DBBroker.getInstance().vratiBezUslova(odo);
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
}
