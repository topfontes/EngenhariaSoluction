/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.easyportal.modelos_pdf.AC_APagarXls;
import br.com.easynet.easyportal.modelos_pdf.AC_Pagas;
import br.com.easynet.easyportal.modelos_pdf.ADM_Apagar;
import br.com.easynet.easyportal.modelos_pdf.ADM_Pagas;
import br.com.easynet.easyportal.modelos_pdf.AdmXlsPagas;
import br.com.easynet.easyportal.modelos_pdf.CeliPagasXLS;
import br.com.easynet.easyportal.modelos_pdf.Celi_ApagarXLS;
import br.com.easynet.easyportal.modelos_pdf.DiconAPagarXls;
import br.com.easynet.easyportal.modelos_pdf.DiconPagas;
import br.com.easynet.easyportal.modelos_pdf.EngebAPagarXLS;
import br.com.easynet.easyportal.modelos_pdf.EngebPagasXLS;
import br.com.easynet.easyportal.modelos_pdf.LMarquezzoAPagarXLS;
import br.com.easynet.easyportal.modelos_pdf.LMarquezzoPagasXLS;
import br.com.easynet.easyportal.modelos_pdf.MarquezzoAPagar;
import br.com.easynet.easyportal.modelos_pdf.MarquezzoPagas;
import br.com.easynet.easyportal.modelos_pdf.ModuloAPagar;
import br.com.easynet.easyportal.modelos_pdf.ModuloPagas;
import br.com.easynet.easyportal.modelos_pdf.Nassal;
import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.transfer.Arq_arquivoT;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 *
 * @author marcos
 */
public class ImportacaoContaPagarJB extends SystemBase implements INotSecurity {

    private int tipoArquivo;
    private Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
    private Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
    private String pathBase = "/home/marcoa/Downloads/contas.pdf";
    private String status;
    private int tipoStatus;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
        System.out.println("load ");
    }

    private void salvarArquivo() {
        try {
            String dir = pathBase.concat(getSession().getId());
            FileOutputStream fos = new FileOutputStream(pathBase.concat(getSession().getId()));
            fos.write(arq_arquivoT.getArq_bt_arquivo());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void replace() {

        try {
            Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();
            ctp_conta_pagarT.setObr_nr_id(60);

            List<Ctp_conta_pagarT> list = cdao.getByObr_nr_id(ctp_conta_pagarT);
            for (Ctp_conta_pagarT ctp_conta_pagarT : list) {
                ctp_conta_pagarT.setCtp_tx_obs(ctp_conta_pagarT.getCtp_tx_obs().replace("&", "E"));
                ctp_conta_pagarT.setCtp_tx_obs(ctp_conta_pagarT.getCtp_tx_obs().replace("Ç", "c"));
                ctp_conta_pagarT.setCtp_tx_obs(ctp_conta_pagarT.getCtp_tx_obs().replace("ç", "c"));
                cdao.update(ctp_conta_pagarT);
            }

        } catch (Exception e) {
        } finally {
            close();
        }
    }

//    public static void lerArquivo() {
//        try {
//            //File file = new File(pathBase.concat(getSession().getId()));
//            File file = new File(pathBase);
//            FileInputStream fis = new FileInputStream(file);
//            byte[] buffer = new byte[1024];
//            int controle = -1;
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            while ((controle = fis.read(buffer)) != -1) {
//                byte[] bufferTemp = new byte[controle];
//                System.arraycopy(buffer, 0, bufferTemp, 0, controle);
//                baos.write(bufferTemp);
//            }
//            fis.close();
////            file.delete();
//            arq_arquivoT.setArq_bt_arquivo(baos.toByteArray());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] arg) {
//        try {
//            
//            lerArquivo();
//            ByteArrayInputStream bais = new ByteArrayInputStream(arq_arquivoT.getArq_bt_arquivo());
//            MarquezzoAPagar marquezzo = new MarquezzoAPagar(ctp_conta_pagarT, null, bais);
//            String msg = (marquezzo.read());
//        } catch (Exception e) {
//        }
//    }
    public void importar() {
        try {

            System.out.println(" Importando ");
            ctp_conta_pagarT.setCtp_tx_status(tipoStatus == 0 ? "P" : "A");
            ByteArrayInputStream bais = new ByteArrayInputStream(arq_arquivoT.getArq_bt_arquivo());
            ByteArrayInputStream bais_anexo = null;
            if (arq_arquivoT.getArq_bt_arquivo_anexo() != null) {
                bais_anexo = new ByteArrayInputStream(arq_arquivoT.getArq_bt_arquivo_anexo());
            }

            Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();
            switch (tipoArquivo) {
                case 1: {
                    Nassal nassal = new Nassal(ctp_conta_pagarT, cdao, bais);
                    setMsg(nassal.read());
                    break;
                }
                case 2: {
                    if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
                        MarquezzoAPagar marquezzo = new MarquezzoAPagar(ctp_conta_pagarT, cdao, bais);
                        setMsg(marquezzo.read());
                        System.out.println("ok");

                    } else {
                        MarquezzoPagas marquezzoPagas = new MarquezzoPagas(ctp_conta_pagarT, cdao, bais);
                        setMsg(marquezzoPagas.read());
                    }
                    break;
                }

                case 3: {
                    if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
                        //Ac_Apagar2  apagar = new Ac_Apagar2(ctp_conta_pagarT, cdao, bais, ctp_conta_pagarT.getCtp_tx_status());
                        //AcAPagar acAPagar = new AcAPagar(ctp_conta_pagarT, cdao, bais, ctp_conta_pagarT.getCtp_tx_status());
                        AC_APagarXls apagar = new AC_APagarXls(ctp_conta_pagarT, cdao, bais);
                        setMsg(apagar.read());
                    } else {
                        System.out.println("Importando dicon");
                        AC_Pagas aC_Pagas = new AC_Pagas(ctp_conta_pagarT, cdao, bais);
                        setMsg(aC_Pagas.read());
                    }
                    break;
                }
                case 4: {
                    if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
                        DiconAPagarXls diconAPagar = new DiconAPagarXls(ctp_conta_pagarT, cdao, bais);
                        setMsg(diconAPagar.read());
                    } else {
                        DiconPagas diconPagas = new DiconPagas(ctp_conta_pagarT, cdao, bais);
                        setMsg(diconPagas.read());
                    }
                    break;
                }
                case 6: {
                    if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
                        EngebAPagarXLS engebAPagarXLS = new EngebAPagarXLS(ctp_conta_pagarT, cdao, bais);
                        setMsg(engebAPagarXLS.read());
                    } else {
                        EngebPagasXLS engebPagasXLS = new EngebPagasXLS(ctp_conta_pagarT, cdao, bais);
                        setMsg(engebPagasXLS.read());
                    }
                    break;
                }
                case 7: {
                    if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
                        MarquezzoAPagar marquezzo = new MarquezzoAPagar(ctp_conta_pagarT, cdao, bais);
                        setMsg(marquezzo.read());
                    } else {
                        LMarquezzoPagasXLS lMarquezzoPagasXLS = new LMarquezzoPagasXLS(ctp_conta_pagarT, cdao, bais);
                        setMsg(lMarquezzoPagasXLS.read());

//                        MarquezzoPagas_newPDF marquezzoPagas_new_pdf = new MarquezzoPagas_newPDF(ctp_conta_pagarT, cdao, bais);
//                        setMsg(marquezzoPagas_new_pdf.read());
                    }
                    break;
                }
                case 8: {
                    if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
                        Celi_ApagarXLS celi_ApagarXLS = new Celi_ApagarXLS(ctp_conta_pagarT, cdao, bais, bais_anexo);
                        setMsg(celi_ApagarXLS.read());
                    } else {
                        CeliPagasXLS celiPagasXLS = new CeliPagasXLS(ctp_conta_pagarT, cdao, bais, bais_anexo);
                        setMsg(celiPagasXLS.read());
                    }
                    break;
                }
                case 9: {
                    if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
                        ModuloAPagar moduloAPagar = new ModuloAPagar(ctp_conta_pagarT, cdao, bais);
                        setMsg(moduloAPagar.read());
                    } else {
                        ModuloPagas moduloPagas = new ModuloPagas(ctp_conta_pagarT, cdao, bais);
                        setMsg(moduloPagas.read());
                    }
                    break;
                }

                case 10: {
                    if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
                        ADM_Apagar admapagar = new ADM_Apagar(ctp_conta_pagarT, cdao, bais);
                        setMsg(admapagar.read());
                    } else {
                        ADM_Pagas admapagar = new ADM_Pagas(ctp_conta_pagarT, cdao, bais);
                        setMsg(admapagar.read());
                    }
                    break;
                }
                case 14: {
                    if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
                        LMarquezzoAPagarXLS lMarquezzoAPagarXLS = new LMarquezzoAPagarXLS(ctp_conta_pagarT, cdao, bais);
                        setMsg(lMarquezzoAPagarXLS.read());
                    }
                    break;
                }
<<<<<<< HEAD
                case 15: {
                    if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("P")) {
                        AdmXlsPagas adm = new AdmXlsPagas(ctp_conta_pagarT, cdao, bais);
                        setMsg(adm.read());
                    }
                    break;
                }
=======
>>>>>>> a4db9ab892e1ea7d1c17dcf771babd5319390c3c

            }

        } catch (Exception e) {
            setMsg("Erro ao tentar importar, verifique se todos os parametros estão preechidos");
            e.printStackTrace();
        } finally {
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
     * @return the ctp_conta_pagarT
     */
    public Ctp_conta_pagarT getCtp_conta_pagarT() {
        return ctp_conta_pagarT;
    }

    /**
     * @param ctp_conta_pagarT the ctp_conta_pagarT to set
     */
    public void setCtp_conta_pagarT(Ctp_conta_pagarT ctp_conta_pagarT) {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
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
     * @return the tipoStatus
     */
    public int getTipoStatus() {
        return tipoStatus;
    }

    /**
     * @param tipoStatus the tipoStatus to set
     */
    public void setTipoStatus(int tipoStatus) {
        this.tipoStatus = tipoStatus;
    }
}
