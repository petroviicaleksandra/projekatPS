/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.proizvod;

import baza.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Proizvod;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author aleks
 */
public class SOPronadjiProizvod extends OpstaSistemskaOperacija
{
    List<OpstiDomenskiObjekat> lista;

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if(odo==null || !(odo instanceof Proizvod)){
            throw new Exception("Los parametar");
        }
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        lista = DBBroker.getInstance().vratiSaUslovom(odo);
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
}
