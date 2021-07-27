/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.easyjob2;

import edu.sena.entity.easyjob2.Clasificacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fabio
 */
@Local
public interface ClasificacionFacadeLocal {

    void create(Clasificacion clasificacion);

    void edit(Clasificacion clasificacion);

    void remove(Clasificacion clasificacion);

    Clasificacion find(Object id);

    List<Clasificacion> findAll();

    List<Clasificacion> findRange(int[] range);

    int count();
    
}
