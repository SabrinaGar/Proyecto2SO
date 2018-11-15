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

    public Memoria(int tamanioMP, int tamanioMS, int tamanioPagina) {
        this.tamanioMP = tamanioMP;
        this.tamanioMS = tamanioMS;
        this.tamanioPagina = tamanioPagina;
        this.tamanioTMP = (this.tamanioMP/tamanioPagina)*tamanioPagina;
        this.tamanioTMS = (this.tamanioMS/tamanioPagina)*tamanioPagina;
        System.out.println(this.tamanioTMP);
    }
    
    
    
            
}
