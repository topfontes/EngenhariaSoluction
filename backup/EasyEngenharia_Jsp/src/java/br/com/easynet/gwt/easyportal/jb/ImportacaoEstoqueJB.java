/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.modelos_pdf.MarquezzoEstoque;
import br.com.easynet.easyportal.modelos_pdf.NassalEstoque;
import br.com.easynet.gwt.easyportal.dao.Est_estoqueDAO;
import br.com.easynet.gwt.easyportal.transfer.Arq_arquivoT;
import br.com.easynet.gwt.easyportal.transfer.Est_estoqueT;
import java.io.ByteArrayInputStream;

/**
 *
 * @author marcos
 */
public class ImportacaoEstoqueJB extends SystemBase {

    private int tipoArquivo;
    private Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
    private Est_estoqueT est_estoqueT = new Est_estoqueT();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void importar() throws Exception {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(arq_arquivoT.getArq_bt_arquivo());
            Est_estoqueDAO edao = getEst_estoqueDAO();
            switch (tipoArquivo) {
                case 1: {
                    NassalEstoque nassal = new NassalEstoque(getEst_estoqueT(), edao, bais);
                    setMsg(nassal.read());
                    break;
                }
                case 2: {
                    MarquezzoEstoque marquezzoEstoque = new MarquezzoEstoque(getEst_estoqueT(), edao, bais);
                    setMsg(marquezzoEstoque.read());
                    break;
                }
                case 3: {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close();
        }
 

    }

    /**
     * @return the tipoArquivo
     */
    public int getTipoArquivo() {
        return tipoArquivo;
    }

    /**
     * @param tipoArquivo the tipoArquivo to set
     */
    public void setTipoArquivo(int tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
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
     * @return the est_estoqueT
     */
    public Est_estoqueT getEst_estoqueT() {
        return est_estoqueT;
    }

    /**
     * @param est_estoqueT the est_estoqueT to set
     */
    public void setEst_estoqueT(Est_estoqueT est_estoqueT) {
        this.est_estoqueT = est_estoqueT;
    }
}
