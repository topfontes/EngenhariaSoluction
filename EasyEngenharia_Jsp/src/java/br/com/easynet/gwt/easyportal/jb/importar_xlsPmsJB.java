/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.Ccff_copia_cronograma_fisico_financeiroDAO;
import br.com.easynet.gwt.easyportal.dao.Pms_planilha_medicao_servicoDAO;
import br.com.easynet.gwt.easyportal.transfer.Arq_arquivoT;
import br.com.easynet.gwt.easyportal.transfer.Ccff_copia_cronograma_fisico_financeiroT;
import br.com.easynet.gwt.easyportal.transfer.Cffo_cronograma_fisico_financeiro_origenalT;
import br.com.easynet.gwt.easyportal.transfer.Pms_planilha_medicao_servicoT;
import br.com.easynet.gwt.easyportal.transfer.Vw_importacao_orcamentoT;
import br.com.jdragon.dao.DAOFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;
import java.util.Vector;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author marcos
 */
public class importar_xlsPmsJB extends SystemBase {

    private Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
    private Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT = new Pms_planilha_medicao_servicoT();
    private String pathBase;
    List<Vw_importacao_orcamentoT> list = new Vector();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();

        File diretorio = new File(PATH_WEB);
        if (diretorio.exists()) {
            pathBase = PATH_WEB;
        } else {
            pathBase = PATH_LOCAL;
        }
    }

    public boolean celulaValida(Cell celula) {
        boolean res = false;
        String cel = celula.getContents();
        cel = cel.replace(".", "");
        cel = cel.replace(",", ".");
        try {
            float teste = Float.parseFloat(cel);
            if (teste > 0) {
                res = true;
            } else {
                res = false;
            }
        } catch (Exception e) {
            res = false;
        }
        return res;
    }

    public boolean cffoDigitadoOK() throws Exception {
        boolean res = true;
        try {
            Cffo_cronograma_fisico_financeiro_origenalT ct = new Cffo_cronograma_fisico_financeiro_origenalT();
            ct.setObr_nr_id(pms_planilha_medicao_servicoT.getObr_nr_id());
            ct.setIpo_nr_id(pms_planilha_medicao_servicoT.getIpo_nr_id());
            ct.setPlco_nr_id(pms_planilha_medicao_servicoT.getPlco_nr_id());
            Cffo_digitadoJB cffo_digitadoJB = new Cffo_digitadoJB();
            cffo_digitadoJB.setCffo_cronograma_fisico_financeiro_origenalT(ct);
            list = cffo_digitadoJB.getCffo_digitado(getDAO());
            res = list.size() == 0;
        } catch (Exception e) {
            throw e;
        }
        return res;
    }

    public void importar() {

        DAOFactory factory = null;
        try {
            if (cffoDigitadoOK()) {
                Pms_planilha_medicao_servicoDAO pdao = getPms_planilha_medicao_servicoDAO();
                factory = pdao.getDAOFactory();
                factory.beginTransaction();

                ByteArrayInputStream bais = new ByteArrayInputStream(getArq_arquivoT().getArq_bt_arquivo());
                Workbook arquivo = Workbook.getWorkbook(bais);
                Sheet linha = arquivo.getSheet(0);
                int totLinhas = linha.getRows();
                for (int i = 4; i < totLinhas; i++) {
                    Cell celula = linha.getCell(6, i);
                    if (celulaValida(celula)) {
                        Cell ipo_nr_id = linha.getCell(0, i);
                        Cell plc_nr_id = linha.getCell(1, i);
                        Cell super_nr_id = linha.getCell(2, i);

                        Cell qtdeOrcada = linha.getCell(6, i);
                        String quantOrcada = qtdeOrcada.getContents().replace(".", "");
                        quantOrcada = quantOrcada.replace(",", ".");
                        float f_qtde_Orcada = Float.parseFloat(quantOrcada);

                        float f_qtde_Acumulada = 0;
                        Cell qtdeAcumulada = linha.getCell(7, i);
                        if (celulaValida(qtdeAcumulada)) {
                            String quantAcumulada = qtdeAcumulada.getContents().replace(".", "");
                            quantAcumulada = quantAcumulada.replace(",", ".");
                            f_qtde_Acumulada = Float.parseFloat(quantAcumulada);
                        }

                        float f_qtde_Mes = 0;
                        Cell qtdeMes = linha.getCell(8, i);
                        if (celulaValida(qtdeMes)) {
                            String quantMes = qtdeMes.getContents().replace(".", "");
                            quantMes = quantMes.replace(",", ".");
                            f_qtde_Mes = Float.parseFloat(quantMes);
                        }

                        float dif = f_qtde_Orcada - f_qtde_Mes;
                        float percMes = 100 - dif * 100 / f_qtde_Orcada;

                        getPms_planilha_medicao_servicoT().setIpo_nr_id(Integer.parseInt(ipo_nr_id.getContents()));
                        getPms_planilha_medicao_servicoT().setPlco_nr_id(Integer.parseInt(plc_nr_id.getContents()));
                        getPms_planilha_medicao_servicoT().setIpo_nr_id_super(Integer.parseInt(super_nr_id.getContents()));
                        getPms_planilha_medicao_servicoT().setPms_nr_quantidade_servico(f_qtde_Mes);
                        getPms_planilha_medicao_servicoT().setPms_nr_percentual(percMes);

                        getPms_planilha_medicao_servicoT().setPms_nr_id(inserir());

                        if (getPms_planilha_medicao_servicoT().getPms_nr_id() == 0) {
                            pdao.insert(getPms_planilha_medicao_servicoT());
                        } else {
                            pdao.update(getPms_planilha_medicao_servicoT());
                        }
                        
                        //lançar automaticamente o percentual informado na pms
                        AtualizarCopiaCronograma();
                    }
                }
                factory.commitTransaction();
                setMsg("importação efetuada com sucesso!");
            }else{
                setMsg("importação efetuada com Erro!");
            }
        } catch (Exception e) {
            factory.rollbackTransaction();
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public int inserir() throws Exception {
        int id = 0;
        try {
            Pms_planilha_medicao_servicoDAO dAO = getPms_planilha_medicao_servicoDAO();
            id = dAO.insertValido(getPms_planilha_medicao_servicoT());
        } catch (Exception e) {
            throw e;
        }

        return id;
    }

    public void AtualizarCopiaCronograma() throws Exception {
        try {
            Ccff_copia_cronograma_fisico_financeiroT copiaCcff = new Ccff_copia_cronograma_fisico_financeiroT();
            copiaCcff.setObr_nr_id(getPms_planilha_medicao_servicoT().getObr_nr_id());
            copiaCcff.setPlco_nr_id(getPms_planilha_medicao_servicoT().getPlco_nr_id());
            copiaCcff.setCcff_nr_mes(getPms_planilha_medicao_servicoT().getPms_nr_mes());
            copiaCcff.setCcff_nr_ano(getPms_planilha_medicao_servicoT().getPms_nr_ano());
            copiaCcff.setCcff_nr_peso(getPms_planilha_medicao_servicoT().getPms_nr_percentual());
            copiaCcff.setIpo_nr_id_super(getPms_planilha_medicao_servicoT().getIpo_nr_id_super());
            copiaCcff.setIpo_nr_id(getPms_planilha_medicao_servicoT().getIpo_nr_id());
            Ccff_copia_cronograma_fisico_financeiroDAO cdao = getCcff_copia_cronograma_fisico_financeiroDAO();
            List<Ccff_copia_cronograma_fisico_financeiroT> list;
            list = cdao.locateRegistro(copiaCcff);
            if (list.size() > 0) {
                copiaCcff.setCcff_nr_id(list.get(0).getCcff_nr_id());
                cdao.update(copiaCcff);
            } else {
                cdao.insert(copiaCcff);
            }
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * @return the arq_arquivoT
     */
    public Arq_arquivoT getArq_arquivoT() {
        return arq_arquivoT;
    }

    /**
     * @param arq_arquivoT the arq_arquivoT to set
     */
    public void setArq_arquivoT(Arq_arquivoT arq_arquivoT) {
        this.arq_arquivoT = arq_arquivoT;
    }

    /**
     * @return the pms_planilha_medicao_servicoT
     */
    public Pms_planilha_medicao_servicoT getPms_planilha_medicao_servicoT() {
        return pms_planilha_medicao_servicoT;
    }

    /**
     * @param pms_planilha_medicao_servicoT the pms_planilha_medicao_servicoT to set
     */
    public void setPms_planilha_medicao_servicoT(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) {
        this.pms_planilha_medicao_servicoT = pms_planilha_medicao_servicoT;
    }
}
