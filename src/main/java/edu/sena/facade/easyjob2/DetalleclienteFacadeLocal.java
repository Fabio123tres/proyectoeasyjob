/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.easyjob2;

import edu.sena.entity.easyjob2.Detallecliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fabio
 */
@Local
public interface DetalleclienteFacadeLocal {

    void create(Detallecliente detallecliente);

    void edit(Detallecliente detallecliente);

    void remove(Detallecliente detallecliente);

    Detallecliente find(Object id);

    List<Detallecliente> findAll();

    List<Detallecliente> findRange(int[] range);

    int count();
    
}
