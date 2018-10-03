/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.programacao;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.dao.Pro_programacaoDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.transfer.Pro_programacaoT;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Programacao extends RelatorioBase implements INotSecurity {

    private List<Pro_programacaoT> list = new ArrayList<Pro_programacaoT>();
    private Pro_programacaoT pro_programacaoT = new Pro_programacaoT();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }
    

    public void imprimir() {
        try {

            Pro_programacaoDAO pdao = getPro_programacaoDAO();
            pro_programacaoT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            pro_programacaoT.setPro_nr_mes(getMeo_meses_obraT().getMes());
            pro_programacaoT.setPro_nr_ano(getMeo_meses_obraT().getAno());
            list = pdao.getByObraMesAno(pro_programacaoT);

            jRDataSource = new JRBeanCollectionDataSource(list);
            is = Programacao.class.getResourceAsStream("programacao.jasper");
            String filename = "programacao-" + getObr_obrasT().getObr_tx_nome() + "-" + getMeo_meses_obraT().getMes() + "-" + getMeo_meses_obraT().getAno();
            print(filename, "PROGRAMAÇÃO DO PRÓXIMO RELATÓRIO");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }
}
