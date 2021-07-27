/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.easyjob2;

import edu.sena.entity.easyjob2.Estadosolicitud;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fabio
 */
@Local
public interface EstadosolicitudFacadeLocal {

    void create(Estadosolicitud estadosolicitud);

    void edit(Estadosolicitud estadosolicitud);

    void remove(Estadosolicitud estadosolicitud);

    Estadosolicitud find(Object id);

    List<Estadosolicitud> findAll();

    List<Estadosolicitud> findRange(int[] range);

    int count();
    
}
