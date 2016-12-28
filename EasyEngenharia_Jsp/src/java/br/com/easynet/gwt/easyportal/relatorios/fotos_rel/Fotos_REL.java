/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.fotos_rel;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.dao.Fto_fotosDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.transfer.Fto_fotosT;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Fotos_REL extends RelatorioBase implements INotSecurity {

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        try {
//http://localhost:8084/engenharia/easyEngenharia/easyconstru/relatorios/fotos.jsp?op=imprimir&obr_obrasT.obr_nr_id=43&meo_meses_obraT.mes=3&meo_meses_obraT.ano=2011&tipo=PDF
            Fto_fotosDAO fto_fotosDAO = getFto_fotosDAO();
            Fto_fotosT fto_fotosT = new Fto_fotosT();
            fto_fotosT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            fto_fotosT.setFto_nr_mes(getMeo_meses_obraT().getMes());
            fto_fotosT.setFto_nr_ano(getMeo_meses_obraT().getAno());
            List<Fto_fotosT> list = fto_fotosDAO.getByObraMesAno(fto_fotosT);

            jRDataSource = new JRBeanCollectionDataSource(list);

            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = Fotos_REL.class.getResourceAsStream("fotos_rel.jasper");
            } else {
                url = Fotos_REL.class.getResource("fotos_rel.jasper");
            }
            print("FOTOS", "FOTOS");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
