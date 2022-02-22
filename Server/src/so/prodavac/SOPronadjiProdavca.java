/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.prodavac;

import baza.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Prodavac;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author aleks
 */
public class SOPronadjiProdavca extends OpstaSistemskaOperacija{

    List<OpstiDomenskiObjekat> lista;
    
    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if(odo==null || !(odo instanceof Prodavac)){
            throw new Exception("Los parametar");
        }
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        lista= DBBroker.getInstance().vratiSaUslovom(odo);
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
}