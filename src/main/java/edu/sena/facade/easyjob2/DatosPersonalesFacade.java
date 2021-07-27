/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.easyjob2;

import edu.sena.entity.easyjob2.DatosPersonales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fabio
 */
@Stateless
public class DatosPersonalesFacade extends AbstractFacade<DatosPersonales> implements DatosPersonalesFacadeLocal {

    @PersistenceContext(unitName = "edu.sena_easyjob2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatosPersonalesFacade() {
        super(DatosPersonales.class);
    }
   @Override
    public boolean registrarUsuario(DatosPersonales usuRegd){
        try {
            Query qt = em.createNativeQuery("INSERT INTO tbl_datos_personales (id, primerNombre, segundoNombre, primerApellido, segundoApellido) VALUES (?, ?, ?, ?, ?)");
            qt.setParameter(1, usuRegd.getId());
            qt.setParameter(2, usuRegd.getPrimerNombre());
            qt.setParameter(3, usuRegd.getSegundoNombre());
            qt.setParameter(4, usuRegd.getPrimerApellido());
            qt.setParameter(5, usuRegd.getSegundoApellido());
            qt.executeUpdate();
            return true;            
        } catch (Exception e) {
            System.out.println("Error::registrarUsuario -> " + e.getMessage());
            return false;
        }
    }
    @Override
    public int MayorId(){
     Query q = em.createQuery("SELECT MAX(e.id) From DatosPersonales e");
     return (int) q.getSingleResult();
    }
}
