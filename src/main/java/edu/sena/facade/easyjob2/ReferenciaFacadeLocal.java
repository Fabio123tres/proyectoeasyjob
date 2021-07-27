/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.easyjob2;

import edu.sena.entity.easyjob2.Referencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fabio
 */
@Local
public interface ReferenciaFacadeLocal {

    void create(Referencia referencia);

    void edit(Referencia referencia);

    void remove(Referencia referencia);

    Referencia find(Object id);

    List<Referencia> findAll();

    List<Referencia> findRange(int[] range);

    int count();

    public boolean registrarreferencia(Referencia refReg);
    
}
