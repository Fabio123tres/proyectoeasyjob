/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.easyjob2;

import edu.sena.entity.easyjob2.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fabio
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> implements ProductoFacadeLocal {

    @PersistenceContext(unitName = "edu.sena_easyjob2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    @Override
    public boolean registrarproducto(Producto proReg){
        try {
            Query qt = em.createNativeQuery("INSERT INTO tbl_producto (id, nombreProducto, descripcion) VALUES (?, ?, ?)");
            qt.setParameter(1, proReg.getId());
            qt.setParameter(2, proReg.getNombreProducto());
            qt.setParameter(3, proReg.getDescripcion());
            qt.executeUpdate();
            return true;            
        } catch (Exception e) {
            System.out.println("Error::registrarProducto -> " + e.getMessage());
            return false;
        }
    }
    
    
     @Override
    public List<Producto> leerproductos(){
        try{
            Query q = em.createQuery("SELECT p FROM Producto p");
            
            return q.getResultList();
        }catch (Exception e) {
            System.out.println("error -> " + e.getMessage());
            return null;
        }
    
    }
    
}
