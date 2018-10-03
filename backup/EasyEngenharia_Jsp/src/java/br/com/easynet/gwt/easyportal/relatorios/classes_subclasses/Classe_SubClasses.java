/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.classes_subclasses;

import br.com.easynet.database.DataSet;
import br.com.easynet.gwt.easyportal.dao.Plc_plano_contasDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.temp.ClasseSubClasseTMP;
import java.util.List;
import java.util.Vector;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Classe_SubClasses extends RelatorioBase {

    private List<ClasseSubClasseTMP> list;
    DataSet ds;

    public Classe_SubClasses() {
    }

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        try {
            Plc_plano_contasDAO pdao = getPlc_plano_contasDAO();
            ds = pdao.getByContaSubClasse();
            povoaList();

            jRDataSource = new JRBeanCollectionDataSource(list);

            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = Classe_SubClasses.class.getResourceAsStream("Classe_SubClasses.jasper");
            } else {
                url = Classe_SubClasses.class.getResource("Classe_SubClasses.jasper");
            } 

            print("CLASSE_SUB-CLASSES", "CLASSES E SUAS SUB-CLASSES");

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close();
        }
    }

    public void povoaList() {
        list = new Vector();
        for (int i = 0; i < ds.getList().size(); i++) {
            ClasseSubClasseTMP classeTMP = new ClasseSubClasseTMP();

            classeTMP.setClasse(ds.getList().get(i).getColumn("plc_nr_id_super").toString() + " - " + ds.getList().get(i).getColumn("super").toString());
            classeTMP.setSubClasse(ds.getList().get(i).getColumn("plc_tx_nome").toString());
            classeTMP.setParcelamento(ds.getList().get(i).getColumn("par_tx_nome").toString());
            list.add(classeTMP);
        }
    }
}
