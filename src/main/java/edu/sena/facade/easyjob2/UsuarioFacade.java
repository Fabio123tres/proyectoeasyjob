/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.easyjob2;

import edu.sena.entity.easyjob2.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "edu.sena_easyjob2_war_1.0-SNAPSHOTPU")
     private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public boolean registrarUsuario(Usuario usuReg){
        try {
            Query qt = em.createNativeQuery("INSERT INTO tbl_usuario (cedula, nomUser, contrasena, datos_id, rol_id, contacto_id) VALUES (?, ?, ?, ?, ?, ?)");
            qt.setParameter(1, usuReg.getCedula());
            qt.setParameter(2, usuReg.getNomUser());
            qt.setParameter(3, usuReg.getContrasena());
            qt.setParameter(4, usuReg.getDatosId());
            qt.setParameter(5, usuReg.getRolId());
            qt.setParameter(6, usuReg.getContactoId());
            qt.executeUpdate();
            return true;            
        } catch (Exception e) {
            System.out.println("Error::registrarUsuario -> " + e.getMessage());
            return false;
        }
    }
    
    
    @Override
    public Usuario iniciarSession(String usuarioIn, String contrasenaIn){
        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.nomUser =:usuarioIn AND u.contrasena = :contrasenaIn");
            q.setParameter("usuarioIn", usuarioIn);
            q.setParameter("contrasenaIn", contrasenaIn);
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error::iniciarSession -> " + e.getMessage());
            return null;
        }
    }
    
    /*@Override
    public List<Usuario> leertodos(){
        try{
            Query q = em.createQuery("SELECT p FROM Usuario p");
            
            return q.getResultList();
        }catch (Exception e) {
            System.out.println("error -> " + e.getMessage());
            return null;
        }
    
    }*/
    @Override
    public List<Usuario> leertodos(){
        try{
            Query q = em.createQuery("SELECT p FROM Usuario p JOIN  p.datosId dp JOIN p.rolId r ");
            
            return q.getResultList();
        }catch (Exception e) {
            System.out.println("error -> " + e.getMessage());
            return null;
        }
    
    }
    
    
}
