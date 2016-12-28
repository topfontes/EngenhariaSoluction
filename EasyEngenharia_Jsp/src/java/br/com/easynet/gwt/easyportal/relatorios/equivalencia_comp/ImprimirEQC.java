/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.equivalencia_comp;

import br.com.easynet.database.DataSet;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class ImprimirEQC extends RelatorioBase implements INotSecurity {

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }
   public List<ImprimirEQCT> list = new ArrayList();

    public void imprimir() {
        try {

            DataSet ds = getEqc_equivalencia_composicaoDAO().getAllDs();
            setObjeto(ds);
            jRDataSource = new JRBeanCollectionDataSource(list);
            is = ImprimirEQC.class.getResourceAsStream("imprimirEQC.jasper");
            print("Equivalencias", "Default");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void setObjeto(DataSet ds) {
        if (ds != null) {
            for (int i = 0; i < ds.getList().size(); i++) {
                ImprimirEQCT imprimirEQCT = new ImprimirEQCT();
                imprimirEQCT.setCodigo_anterior(ds.getList().get(i).getColumn("coa_tx_codigo").toString());
                imprimirEQCT.setDesc_anterior(ds.getList().get(i).getColumn("coa_tx_descricao").toString());
                imprimirEQCT.setCodigo_novo(ds.getList().get(i).getColumn("con_tx_codigo").toString());
                imprimirEQCT.setDesc_nova(ds.getList().get(i).getColumn("con_tx_descricao").toString());
                imprimirEQCT.setUnd(ds.getList().get(i).getColumn("con_tx_unidade").toString());
                list.add(imprimirEQCT);
            }
        }
    }
}
