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
public class Odgovor implements Serializable{
    private TipOdgovora responseType;
    private Object result;
    private Exception exception;

    public Odgovor() {
    }

    public TipOdgovora getResponseType() {
        return responseType;
    }

    public void setResponseType(TipOdgovora responseType) {
        this.responseType = responseType;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
    
}
