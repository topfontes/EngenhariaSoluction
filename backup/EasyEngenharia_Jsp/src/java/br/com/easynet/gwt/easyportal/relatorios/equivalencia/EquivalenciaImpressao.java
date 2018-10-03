/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.equivalencia;

import br.com.easynet.gwt.easyportal.dao.Vw_equivalenciaDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class EquivalenciaImpressao extends RelatorioBase {

    public EquivalenciaImpressao() {
    }

    public void imprimir() {
        Vw_equivalenciaDAO dao = null;
        try {
            dao = getVw_equivalenciaDAO();
            jRDataSource = new JRBeanCollectionDataSource(dao.getAll());
            is = EquivalenciaImpressao.class.getResourceAsStream("equivalencia.jasper");
            print("Equivalencias", "Default");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
