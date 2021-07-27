/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.easyjob2;

import edu.sena.entity.easyjob2.Contacto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fabio
 */
@Stateless
public class ContactoFacade extends AbstractFacade<Contacto> implements ContactoFacadeLocal {

    @PersistenceContext(unitName = "edu.sena_easyjob2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactoFacade() {
        super(Contacto.class);
    }
    @Override
    public boolean registrarUsuario(Contacto contactoIn){
        try {
            Query qt = em.createNativeQuery("INSERT INTO tbl_contacto (id, telefono, correoElectronico, direccion_id) VALUES (?, ?, ?, ?)");
            qt.setParameter(1, contactoIn.getId());
            qt.setParameter(2, contactoIn.getTelefono());
            qt.setParameter(3, contactoIn.getCorreoElectronico());
            qt.setParameter(4, contactoIn.getDireccionId());
            qt.executeUpdate();
            return true;            
        } catch (Exception e) {
            System.out.println("Error::registrarUsuario -> " + e.getMessage());
            return false;
        }
    }
    
}
