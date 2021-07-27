/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.easyjob2;

import edu.sena.entity.easyjob2.Referencia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fabio
 */
@Stateless
public class ReferenciaFacade extends AbstractFacade<Referencia> implements ReferenciaFacadeLocal {

    @PersistenceContext(unitName = "edu.sena_easyjob2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReferenciaFacade() {
        super(Referencia.class);
    }
    
    @Override
    public boolean registrarreferencia(Referencia refReg){
        try {
            Query qt = em.createNativeQuery("INSERT INTO tbl_referencia (id, cantidaDisponible, precioVenta, producto_id) VALUES (?, ?, ?, ?)");
            qt.setParameter(1, refReg.getId());
            qt.setParameter(2, refReg.getCantidaDisponible());
            qt.setParameter(3, refReg.getPrecioVenta());
            qt.setParameter(4, refReg.getProductoId());
            qt.executeUpdate();
            return true;            
        } catch (Exception e) {
            System.out.println("Error::registrarReferncia -> " + e.getMessage());
            return false;
        }
    }
    
}
