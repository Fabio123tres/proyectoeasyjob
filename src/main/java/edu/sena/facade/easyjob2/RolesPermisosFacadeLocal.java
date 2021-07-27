/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.easyjob2;

import edu.sena.entity.easyjob2.RolesPermisos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fabio
 */
@Local
public interface RolesPermisosFacadeLocal {

    void create(RolesPermisos rolesPermisos);

    void edit(RolesPermisos rolesPermisos);

    void remove(RolesPermisos rolesPermisos);

    RolesPermisos find(Object id);

    List<RolesPermisos> findAll();

    List<RolesPermisos> findRange(int[] range);

    int count();
    
}
