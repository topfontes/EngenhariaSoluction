package br.com.easynet.gwt.easyportal.relatorios.folha_pagamento;

import br.com.easynet.gwt.easyportal.dao.Fol_folha_pagamentoDAO;
import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.transfer.Fol_folha_pagamentoT;
import br.com.easynet.gwt.easyportal.transfer.Folha_PagamentoTMP;
import java.util.List;
import java.util.Vector;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import org.jdesktop.swingx.tips.TipOfTheDayModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marcos
 */
public class FolhaPagamentoAnaliticaREL extends RelatorioBase {

    private Fol_folha_pagamentoT fol_folha_pagamentoT = new Fol_folha_pagamentoT();
    private List<Folha_PagamentoTMP> list = new Vector();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        try {
            Obr_obrasDAO odao = getObr_obrasDAO();
            setObr_obrasT(odao.getByObr_nr_id(getObr_obrasT()).get(0));

            Fol_folha_pagamentoDAO fdao = getFol_folha_pagamentoDAO();

            fol_folha_pagamentoT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            fol_folha_pagamentoT.setFol_nr_mes(getMeo_meses_obraT().getMes());
            fol_folha_pagamentoT.setFol_nr_ano(getMeo_meses_obraT().getAno());
            setDs(fdao.getAll_GroupBy(fol_folha_pagamentoT));
            povoaList();

            jRDataSource = new JRBeanCollectionDataSource(list);

            if(! getTipo().equalsIgnoreCase("XLS")){
                is = FolhaPagamentoAnaliticaREL.class.getResourceAsStream("folha_pagamento_analitica.jasper");
            }else{
                url  = FolhaPagamentoAnaliticaREL.class.getResource("folha_pagamento_analitica.jasper") ;
            }

            print("FolhaPag.Analitica", "FOLHA DE PAGAMENTO ANÁLITICA");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void povoaList() {
        for (int i = 0; i < getDs().getList().size(); i++) {
            Folha_PagamentoTMP ft = new Folha_PagamentoTMP();
            ft.setFol_tx_funcao(getDs().getList().get(i).getColumn("fol_tx_funcao").toString());
            ft.setSubClasse(getDs().getList().get(i).getColumn("plc_tx_nome").toString());
            ft.setClasse(getDs().getList().get(i).getColumn("plc_tx_super").toString());
            ft.setFol_nr_numero_funcionario(Integer.parseInt(getDs().getList().get(i).getColumn("fol_nr_numero_funcionario").toString()));

            ft.setFol_nr_salario_bruto_oficial(Float.parseFloat(getDs().getList().get(i).getColumn("fol_nr_salario_bruto_oficial").toString()));
            ft.setFol_nr_adiantamento_oficial(Float.parseFloat(getDs().getList().get(i).getColumn("fol_nr_adiantamento_oficial").toString()));
            ft.setFol_nr_horas_extra_oficial(Float.parseFloat(getDs().getList().get(i).getColumn("fol_nr_horas_extra_oficial").toString()));

            ft.setFol_nr_salario_bruto_nao_oficial(Float.parseFloat(getDs().getList().get(i).getColumn("fol_nr_salario_bruto_nao_oficial").toString()));
            ft.setFol_nr_adiantamento_nao_oficial(Float.parseFloat(getDs().getList().get(i).getColumn("fol_nr_adiantamento_nao_oficial").toString()));
            ft.setFol_nr_horas_extra_nao_oficial(Float.parseFloat(getDs().getList().get(i).getColumn("fol_nr_horas_extra_nao_oficial").toString()));
            list.add(ft);
        }
    }
}
