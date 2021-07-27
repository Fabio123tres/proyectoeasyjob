/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.easyjob2;

import edu.sena.entity.easyjob2.Contacto;
import edu.sena.entity.easyjob2.DatosPersonales;
import edu.sena.entity.easyjob2.Roles;
import edu.sena.entity.easyjob2.Usuario;
import edu.sena.facade.easyjob2.ContactoFacadeLocal;
import edu.sena.facade.easyjob2.DatosPersonalesFacadeLocal;
import edu.sena.facade.easyjob2.RolesFacadeLocal;
import edu.sena.facade.easyjob2.UsuarioFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author fabio
 */
@Named(value = "usuarioSession")
@SessionScoped
public class UsuarioSession implements Serializable {

    @EJB
    private RolesFacadeLocal rolesFacade;

    @EJB
    private ContactoFacadeLocal contactoFacade;

    @EJB
    private DatosPersonalesFacadeLocal datosPersonalesFacadeLocal;

    /**
     * Creates a new instance of UsuarioSession
     */
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;

    private Usuario usuReg = new Usuario();
    private Usuario usuLog = new Usuario();
    private DatosPersonales usuRegd = new DatosPersonales();
    private Contacto contactoIn = new Contacto();
    private String usuarioIn = "";
    private String contrasenaIn = "";

    
    private int rolidIn = 0;

    private String mensajes = "";

    public UsuarioSession() {

    }

    public void registarUsuario() throws IOException {
        Roles rl = rolesFacade.find(rolidIn);
        usuReg.setRolId(rl);
        datosPersonalesFacadeLocal.create(usuRegd);
        if (usuRegd == null) {
            //usuReg.setDatosId(usuRegd);

            mensajes = "regBad";
        } else {
            System.out.println("datos - Creado");
        }
        contactoFacade.create(contactoIn);
        if (contactoIn == null) {

            mensajes = "regBad";

        } else {

            System.out.println("contacto - Creado");
        }
        usuReg.setDatosId(usuRegd);
        usuReg.setContactoId(contactoIn);
        usuarioFacadeLocal.create(usuReg);
        if (usuReg == null) {
            mensajes = "regBad";
            System.out.println("Error - Creando usuario");

        } else {
            mensajes = "regOk";
            System.out.println("Usuario - Creado");
        }
        usuReg = new Usuario();
        usuRegd = new DatosPersonales();
        contactoIn = new Contacto();

    }

    public void actualizarDatos() {
        try {
            usuarioFacadeLocal.edit(usuLog);
            
            mensajes = "regOk";
        } catch (Exception e) {
            mensajes = "regBad";
        }
    }

    public void validarUsuario() throws IOException {
        usuLog = usuarioFacadeLocal.iniciarSession(usuarioIn, contrasenaIn);
        if (usuLog == null) {
            mensajes = "iniBad";
        } else {
            if (usuLog.getRolId().equals(1)) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().redirect("Administrador/index.xhtml");
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().redirect("Inventario/index.xhtml");
            
        }
            
            
        }

    }

    public List<Usuario> leertodos() {

        return usuarioFacadeLocal.leertodos();

    }

    public List<Roles> leerroles() {

        return rolesFacade.findAll();

    }

    public List<DatosPersonales> leerDatos() {

        return datosPersonalesFacadeLocal.findAll();

    }

    public List<Contacto> leerContacto() {

        return contactoFacade.findAll();

    }

    public Usuario getUsuReg() {
        return usuReg;
    }

    public void setUsuReg(Usuario usuReg) {
        this.usuReg = usuReg;
    }

    public Usuario getUsuLog() {
        return usuLog;
    }

    public void setUsuLog(Usuario usuLog) {
        this.usuLog = usuLog;
    }

    public String getUsuarioIn() {
        return usuarioIn;
    }

    public void setUsuarioIn(String usuarioIn) {
        this.usuarioIn = usuarioIn;
    }

    public String getContrasenaIn() {
        return contrasenaIn;
    }

    public void setContrasenaIn(String contrasenaIn) {
        this.contrasenaIn = contrasenaIn;
    }

    public String getMensajes() {
        return mensajes;
    }

    public void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    }

    public DatosPersonales getUsuRegd() {
        return usuRegd;
    }

    public void setUsuRegd(DatosPersonales usuRegd) {
        this.usuRegd = usuRegd;
    }

    public Contacto getContactoIn() {
        return contactoIn;
    }

    public void setContactoIn(Contacto contactoIn) {
        this.contactoIn = contactoIn;
    }

    public int getRolidIn() {
        return rolidIn;
    }

    public void setRolidIn(int rolidIn) {
        this.rolidIn = rolidIn;
    }


}
