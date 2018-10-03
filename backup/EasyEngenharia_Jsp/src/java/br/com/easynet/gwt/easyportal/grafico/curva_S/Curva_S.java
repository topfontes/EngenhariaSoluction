/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.grafico.curva_S;

import br.com.easynet.database.DataSet;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.dao.Ipo_item_plano_contas_obraDAO;
import br.com.easynet.gwt.easyportal.dao.Pms_planilha_medicao_servicoDAO;
import br.com.easynet.gwt.easyportal.dao.Vw_equiv_insumo_pmsDAO;
import br.com.easynet.gwt.easyportal.dao.Vw_insumo_plc_pmsDAO;
import br.com.easynet.gwt.easyportal.jb.Cronograma_fisico_fin_originalJB;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.transfer.Meo_meses_obraT;
import br.com.easynet.gwt.easyportal.transfer.Vw_insumo_plc_pmsT;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author marcos
 */
public class Curva_S extends RelatorioBase implements INotSecurity {

    public List<Meo_meses_obraT> list = new Vector();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        try {
            povoarObjeto();
            String path = application.getRealPath("jasper/datailCurva_S.jasper");
            path = path.substring(0, path.indexOf("datailCurva_S.jasper"));
            getParameters().put("SUBREPORT_DIR", path);
            jRDataSource = new JRBeanCollectionDataSource(list);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
            getParameters().put("list", dataSource);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = Curva_S.class.getResourceAsStream("curva_S.jasper");
            } else {
                url = Curva_S.class.getResource("curva_S.jasper");
            }
            String fileName = "Curva_S" + getMeo_meses_obraT().getMes() + "-" + getMeo_meses_obraT().getAno();
            print(fileName, "CURVA S - GERAL");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void povoarObjeto() throws Exception {
        try {
            Cronograma_fisico_fin_originalJB jB = new Cronograma_fisico_fin_originalJB();
            jB.getVw_importacao_orcamentoT().setObr_nr_id(getObr_obrasT().getObr_nr_id());
            jB.setPage(page);
            jB.consult();
            list = jB.getListTotalMeses();

            Vw_insumo_plc_pmsDAO pmsDao = getVw_insumo_plc_pmsDAO();

            Vw_insumo_plc_pmsDAO vw_insumo_plc_pmsDAO = getVw_insumo_plc_pmsDAO();
            DataSet ds = vw_insumo_plc_pmsDAO.getResumoPmsMesAno(getObr_obrasT().getObr_nr_id());

            Ipo_item_plano_contas_obraDAO idao = getIpo_item_plano_contas_obraDAO();
            float totalObra = idao.getTotalObr_nr_id(getObr_obrasT().getObr_nr_id());
            int qtSem = 0;
            for (Meo_meses_obraT meo_meses_obraT : list) {
                meo_meses_obraT.setQuantidade(meo_meses_obraT.getQuantidade() * 100);
                meo_meses_obraT.setCalc_quantidade_original(meo_meses_obraT.getCalc_quantidade_original() * 100);
                for (int i = 0; i < ds.getList().size(); i++) {
                    int mesDs = Integer.parseInt(ds.getList().get(i).getColumn("pms_nr_mes").toString());
                    int anoDs = Integer.parseInt(ds.getList().get(i).getColumn("pms_nr_ano").toString());
                    float valor = Float.parseFloat(ds.getList().get(i).getColumn("valor").toString());
                    valor = valor / totalObra;
                    valor = valor * 100;
                    if (mesDs == meo_meses_obraT.getMes() & anoDs == meo_meses_obraT.getAno()) {
                        meo_meses_obraT.setDif_origenal_copia(valor);
                    }
                }

                if (qtSem > 0) {
                    meo_meses_obraT.setCalc_quantidade_original(0);
                }
                double vl = roundDouble(meo_meses_obraT.getCalc_quantidade_original());
                if (vl == 100) {
                    qtSem = 1;
                }
            }

        } catch (Exception e) {
            throw e;
        }

    }

    public double roundDouble(double vl) {
        double r = vl;
        int decimalPlace = 2;
        BigDecimal bd = new BigDecimal(r);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        r = bd.doubleValue();
        return r;
    }
}
