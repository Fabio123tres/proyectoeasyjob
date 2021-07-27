/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.easyjob2;

import edu.sena.entity.easyjob2.Producto;
import edu.sena.entity.easyjob2.Referencia;
import edu.sena.facade.easyjob2.ProductoFacadeLocal;
import edu.sena.facade.easyjob2.ReferenciaFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author fabio
 */
@Named(value = "inventarioSession")
@SessionScoped
public class InventarioSession implements Serializable {

    @EJB
    private ProductoFacadeLocal productoFacade;

    @EJB
    private ReferenciaFacadeLocal referenciaFacadeLocal;

    private Referencia rfproducto = new Referencia();
    private Producto proReg = new Producto();
    private String mensajes = "";

    /**
     * Creates a new instance of ProductoSession
     */
    public InventarioSession() {

    }

    public List<Referencia> leerReferencia() {

        return referenciaFacadeLocal.findAll();

    }

    public void crearProducto() throws IOException {

        productoFacade.create(proReg);
        if (proReg == null) {

            mensajes = "regBad";
            System.out.println("producto - Creado");
        } else {

            System.out.println("Error - Creando producto");

        }

        rfproducto.setProductoId(proReg);
        referenciaFacadeLocal.create(rfproducto);
        if (rfproducto == null) {
            mensajes = "regBad";
            System.out.println("Error - Creando referncia");
        } else {

            mensajes = "regOk";
            System.out.println("referencia - Creado");
        }
        rfproducto = new Referencia();
        proReg = new Producto();
    }

    public void eliminarProducto(Producto objpro) {
        productoFacade.remove(objpro);
        

    }
    
    public void eliminarReferencia(Referencia objpro) {
        
        referenciaFacadeLocal.remove(objpro);

    }
    

    public Referencia getRfproducto() {
        return rfproducto;
    }

    public void setRfproducto(Referencia rfproducto) {
        this.rfproducto = rfproducto;
    }

    public String getMensajes() {
        return mensajes;
    }

    public void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    }

    public Producto getProReg() {
        return proReg;
    }

    public void setProReg(Producto proReg) {
        this.proReg = proReg;
    }

}
