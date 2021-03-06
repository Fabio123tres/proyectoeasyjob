/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.easyjob2;

import edu.sena.entity.easyjob2.Detalleventa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fabio
 */
@Stateless
public class DetalleventaFacade extends AbstractFacade<Detalleventa> implements DetalleventaFacadeLocal {

    @PersistenceContext(unitName = "edu.sena_easyjob2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleventaFacade() {
        super(Detalleventa.class);
    }
    
}
