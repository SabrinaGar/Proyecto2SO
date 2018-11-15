package memoriavirtual;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sabrina
 */
public class Pagina {
    private int tamanio;
    private boolean enMP;
    private int  marcoIndex;
    private int pagIndex;
    private int IdProceso;

    public Pagina(int tamanio, boolean enMP, int marcoIndex, int pagIndex, int IdProceso) {
        this.tamanio = tamanio;
        this.enMP = enMP;
        this.marcoIndex = marcoIndex;
        this.pagIndex = pagIndex;
        this.IdProceso = IdProceso;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public boolean isEnMP() {
        return enMP;
    }

    public void setEnMP(boolean enMP) {
        this.enMP = enMP;
    }

    public int getMarcoIndex() {
        return marcoIndex;
    }

    public void setMarcoIndex(int marcoIndex) {
        this.marcoIndex = marcoIndex;
    }

    public int getPagIndex() {
        return pagIndex;
    }

    public void setPagIndex(int pagIndex) {
        this.pagIndex = pagIndex;
    }

    public int getIdProceso() {
        return IdProceso;
    }

    public void setIdProceso(int IdProceso) {
        this.IdProceso = IdProceso;
    }
    
    
    
    
    
    
}
