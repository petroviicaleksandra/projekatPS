/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author aleks
 */
public class Zahtev implements Serializable{
    private int operacija;
    private Object parametar;

    public Zahtev(int operacija, Object parametar) {
        this.operacija = operacija;
        this.parametar = parametar;
    }

    public Object getParametar() {
        return parametar;
    }

    public int getOperacija() {
        return operacija;
    }
}
