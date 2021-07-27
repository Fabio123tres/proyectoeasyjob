/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.easyjob2;

import edu.sena.entity.easyjob2.Proveedor;
import edu.sena.facade.easyjob2.ProveedorFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author fabio
 */
@Named(value = "provedorSession")
@SessionScoped
public class ProvedorSession implements Serializable {

    @EJB
    private ProveedorFacadeLocal proveedorFacade;

    /**
     * Creates a new instance of ProvedorSession
     */
    private Proveedor proveedorIn = new Proveedor();
    private String mensajes = "";

    public ProvedorSession() {
    }

    public List<Proveedor> leerProveedor() {

        return proveedorFacade.findAll();

    }

    public void crearProveedor() throws IOException {
        proveedorFacade.create(proveedorIn);
        if (proveedorIn == null) {
            mensajes = "regBad";
            System.out.println("error - Creando proveedor");
        } else {
            mensajes = "regOk";
            System.out.println("proveedor - Creado");
        }
        proveedorIn = new Proveedor();
    }

    public void eliminarProveedor(Proveedor objpro)  {
        
        
        proveedorFacade.remove(objpro);

    }

    public Proveedor getProveedorIn() {
        return proveedorIn;
    }

    public void setProveedorIn(Proveedor proveedorIn) {
        this.proveedorIn = proveedorIn;
    }

    public String getMensajes() {
        return mensajes;
    }

    public void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    }

}
