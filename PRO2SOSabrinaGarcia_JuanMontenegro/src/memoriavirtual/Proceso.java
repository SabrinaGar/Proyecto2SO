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
public class Proceso {
    
    private String nombre;
    private int tamanio;
    private String estado;
    private Pagina tablaPaginas[];
    private int tamanioT;
    private int totalPaginas;
    private int paginasPrincipal;
    private int paginasSecundaria;
    private int id;// no se si  lo usaremos
    private int tamanioPagina;

    public Proceso(String nombre, int tamanio, int id, int tamanioPagina) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.id = id;
        this.tamanioPagina = tamanioPagina;
        this.totalPaginas = this.tamanio/this.tamanioPagina;
        this.tamanioT = this.totalPaginas*this.tamanioPagina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pagina[] getTablaPaginas() {
        return tablaPaginas;
    }

    public void setTablaPaginas(Pagina[] tablaPaginas) {
        this.tablaPaginas = tablaPaginas;
    }

    public int getTamanioT() {
        return tamanioT;
    }

    public void setTamanioT(int tamanioT) {
        this.tamanioT = tamanioT;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public int getPaginasPrincipal() {
        return paginasPrincipal;
    }

    public void setPaginasPrincipal(int paginasPrincipal) {
        this.paginasPrincipal = paginasPrincipal;
    }

    public int getPaginasSecundaria() {
        return paginasSecundaria;
    }

    public void setPaginasSecundaria(int paginasSecundaria) {
        this.paginasSecundaria = paginasSecundaria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTamanioPagina() {
        return tamanioPagina;
    }

    public void setTamanioPagina(int tamanioPagina) {
        this.tamanioPagina = tamanioPagina;
    }
    
    
    
    
    
    }
    
    


    
    
    
    
    

