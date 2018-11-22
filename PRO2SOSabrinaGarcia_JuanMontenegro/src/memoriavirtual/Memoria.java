package memoriavirtual;

import java.util.ArrayDeque;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sabrina
 */
public class Memoria {
    private int tamanioMP;
    private int tamanioMS;
    private int tamanioPagina;
    private Pagina paginasMP[];
    private Pagina paginasMS[];
    private int tamanioTMP;
    private int tamanioTMS;
    private int marcosMPDisponibles;
    private int marcosMSDisponibles;
    private int marcosMP, marcosMS;
    private ArrayDeque listaFifo;

    public Memoria(int tamanioMP, int tamanioMS, int tamanioPagina) {
        this.tamanioMP = tamanioMP;
        this.tamanioMS = tamanioMS;
        this.tamanioPagina = tamanioPagina;
        this.tamanioTMP = (this.tamanioMP/tamanioPagina)*tamanioPagina;
        this.tamanioTMS = (this.tamanioMS/tamanioPagina)*tamanioPagina;
        this.paginasMP = new Pagina [tamanioTMP/tamanioPagina]; 
        this.paginasMS = new Pagina [tamanioTMS/tamanioPagina]; 
        this.marcosMP = tamanioTMP/tamanioPagina;
        this.marcosMS = tamanioTMS/tamanioPagina;
        this.marcosMPDisponibles = marcosMP;
        this.marcosMSDisponibles = marcosMS;
        this.listaFifo = new ArrayDeque<Proceso>();
        IniciarMP();
        IniciarMS();
        System.out.println(this.tamanioTMP);
    }
    

    private void IniciarMP() {
        for(int i = 0; i < marcosMP;i++) {
            this.paginasMP[i] = new Pagina(i,true);
        }
    }
    
    private void IniciarMS() {
        for(int i = 0; i < marcosMS;i++) {
            this.paginasMS[i] = new Pagina(i,false);
        }
    }
    
    private void agregarPaginaMP(Proceso proceso, int i) {
        int espacio = getMarcoMPDisponible();
        if(espacio>-1){
            marcosMPDisponibles--;
            proceso.getTablaPaginas()[i].setMarcoIndex(espacio);
            proceso.getTablaPaginas()[i].setEnMP(true);
            this.paginasMP[espacio] = proceso.getTablaPaginas()[i];
        }
        
    }
    
    private void eliminarPaginaMP(int pos) {
        paginasMP[pos] = new Pagina(pos,true);
        marcosMPDisponibles++;
    }
    
    private void agregarPaginaMS(Proceso proceso, int i) {
        int espacio = getMarcoMSDisponible();
        if(espacio>-1){
            marcosMPDisponibles--;
            proceso.getTablaPaginas()[i].setMarcoIndex(espacio);
            proceso.getTablaPaginas()[i].setEnMP(false);
            this.paginasMP[espacio] = proceso.getTablaPaginas()[i];
        }
        
    }
    
    private void eliminarPaginaMS(int pos) {
        paginasMP[pos] = new Pagina(pos,false);
        marcosMPDisponibles++;
    }
    
    public void activarProceso(Proceso proceso) {
        int j=0;
        for (int i = 0; i < paginasMP.length; i++) {
            
            if(paginasMP[i].getIdProceso() == proceso.getId()){
                j++;
            }
        }
        if(j>proceso.getTotalPaginas()/2){
            System.out.println("El proceso se encuentra en ejecucion");
            return;
        }
        j=0;
        for (int i = 0; i < proceso.getTablaPaginas().length; i++) {
            if(!proceso.getTablaPaginas()[i].isEnMP() && proceso.getPaginasPrincipal()>proceso.getTotalPaginas()/2){
                int aux = getMarcoMPDisponible();
                paginasMP[aux] = proceso.getTablaPaginas()[i];
                proceso.getTablaPaginas()[i].setMarcoIndex(aux);
                proceso.getTablaPaginas()[i].setEnMP(true);
            }
            
        }
        listaFifo.addFirst(proceso);
    }
    
    private void SuspenderProceso(Proceso proceso){
        if(proceso.getEstado().toLowerCase().equals("suspendido")){
            System.out.println("El proceso ya se encuentra suspendido.");
        }
        for (int i = 0; i < paginasMP.length; i++) {
            if(paginasMP[i].getIdProceso()==proceso.getId()){
                int aux = getMarcoMSDisponible();
                paginasMS[aux]=paginasMP[i];
                paginasMP[i]= new Pagina(i,true);
            }
            
        }
        proceso.setEstado("Suspendido");
        listaFifo.remove(proceso);
    }
    
        private void BloquearProceso(Proceso proceso){
        if(proceso.getEstado().toLowerCase().equals("bloqueado")){
            System.out.println("El proceso ya se encuentra bloqueado.");
        }
        proceso.setEstado("Bloqueado");
        
    }
    
    private int getMarcoMPDisponible() {
        int disponible = -1;
        for (int i = 0; i < paginasMP[i].getIdProceso(); i++) {
            disponible = paginasMP[i].getIdProceso();
            if(disponible < -1){
                return i;
            }
        }
        return disponible;
    }
    
    private int getMarcoMSDisponible() {
        int disponible = -1;
        for (int i = 0; i < paginasMS[i].getIdProceso(); i++) {
            disponible = paginasMS[i].getIdProceso();
            if(disponible < -1){
                return i;
            }
        }
        return disponible;
    }
    
    private void procesoActivoListo(Proceso proceso) {
        if((proceso.getTotalPaginas() / 2) <= proceso.getPaginasPrincipal()) {
            proceso.setEstado("Activo");
        } else {
            proceso.setEstado("Listo");
        }
    }
    
    private int Fifo(){
        Proceso proceso = (Proceso) listaFifo.getFirst();
        for (int i = 0; i < paginasMP.length; i++) {
            if(proceso.getTablaPaginas()[i].isEnMP()){
                procesoActivoListo(proceso);
            return proceso.getTablaPaginas()[i].getMarcoIndex();
        }
    }
        listaFifo.removeFirst();
        return Fifo();
    }
    
}
