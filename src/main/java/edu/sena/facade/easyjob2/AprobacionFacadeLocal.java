/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.easyjob2;

import edu.sena.entity.easyjob2.Aprobacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fabio
 */
@Local
public interface AprobacionFacadeLocal {

    void create(Aprobacion aprobacion);

    void edit(Aprobacion aprobacion);

    void remove(Aprobacion aprobacion);

    Aprobacion find(Object id);

    List<Aprobacion> findAll();

    List<Aprobacion> findRange(int[] range);

    int count();
    
}
