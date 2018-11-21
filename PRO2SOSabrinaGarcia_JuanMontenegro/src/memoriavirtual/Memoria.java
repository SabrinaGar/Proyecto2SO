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
        IniciarMP();
        IniciarMS();
        System.out.println(this.tamanioTMP);
    }
    

    private void IniciarMP() {
        for(int i = 0; i < marcosMP;i++) {
            this.paginasMP[i] = new Pagina(i);
        }
    }
    
    private void IniciarMS() {
        for(int i = 0; i < marcosMS;i++) {
            this.paginasMS[i] = new Pagina(i);
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
        paginasMP[pos] = new Pagina(pos);
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
        paginasMP[pos] = new Pagina(pos);
        marcosMPDisponibles++;
    }
    
    public void activarProceso(Proceso proceso, int pagina) {
        eliminarProcesoAlmacenamiento(proceso.getTablaPaginas()[pagina].getIdMarco());
        agregarProcesoMemoria(proceso, pagina);
        memoriaPrincipal -= tamañoPagina;
        proceso.setPaginasMemoriaPrincipal(proceso.getPaginasMemoriaPrincipal()+1);
        proceso.setPaginasMemoriaSecundaria(proceso.getPaginasMemoriaSecundaria()-1);
        procesoActivoListo(proceso);
        textArea.append("- Se ha puesto la pagina del proceso de id "+proceso.getIdProceso()+" pasando "+proceso.getPaginasMemoriaSecundaria()+" paginas de memoria secundaria a memoria principal\n");
        mostrarEspaciosDisponibles();
        mostrarEspaciosDisponiblesAlmacenamiento();
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
            
}
