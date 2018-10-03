/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

import br.com.easynet.gwt.easyportal.dao.Est_estoqueDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Est_estoqueT;
import br.com.jdragon.dao.DAOFactory;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author topfontes
 */
public class SystemBaseEstoquePDF{

    protected List<Est_estoqueT> list;
    protected Est_estoqueDAO est_estoqueDAO;
    protected TreeMap<String, Est_estoqueT> treeEst;
    protected Est_estoqueT est_estoqueT;
    protected DAOFactory factory;
    protected InputStream is;
    protected File file;
    protected String linha;
    protected static final String ASPAS = "\"";
    protected float valorLido = 0;
    protected float valorImp = 0;

    public SystemBaseEstoquePDF(Est_estoqueT est_estoqueT, Est_estoqueDAO dAO, InputStream is) {
        this.est_estoqueDAO = dAO;
        this.est_estoqueT = est_estoqueT;
        this.is = is;
        povoaEstoque();
    }

    public void povoaEstoque() {
        try {
            treeEst = est_estoqueDAO.getByObr_nr_idTree(est_estoqueT);
        } catch (Exception e) {
            
        }
    }

    protected String replaceFormatBR(String valor) {
        String v = valor.replace(".", "");
        v = v.replace(",", ".");
        return v;
    }
    
    
    protected int posNextCaracter(String valor, String caracter) {
        int p = 0;
        try {
            p = valor.indexOf(caracter);
        } catch (Exception e) {
            return 0;
        }
        return p;
    }

    protected int posLastCaracter(String valor, String caracter) throws Exception {
        int p = 0;
        valor = valor.trim();
        for (int i = valor.length(); i > 0; i--) {
            String l = valor.substring(i - 1, i);
            if (l.equalsIgnoreCase(caracter)) {
                return i;
            }
        }
        return p;
    }


    public void addObjectEstoque(float valorTotal, float valor_unit, float quantidade, String unidade, String produto, String key) {
        try {
            if (valorTotal != 0) {
                est_estoqueT.setEst_nr_vl_total(valorTotal);
                est_estoqueT.setEst_nr_vl_unitario(valor_unit);
                est_estoqueT.setEst_nr_quantidade(quantidade);

                est_estoqueT.setEst_tx_key(key);
                est_estoqueT.setEst_tx_unidade(unidade);
                produto = produto.replace(ASPAS, "''");
                est_estoqueT.setEst_tx_nome(trata(produto));
                valorImp = valorImp + valorTotal;
                est_estoqueDAO.insert(est_estoqueT);
                //}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String trata(String passa) {
        passa = passa.replaceAll("[ÂÀÁÄÃ]", "A");
        passa = passa.replaceAll("[âãàáä]", "a");
        passa = passa.replaceAll("[ÊÈÉË]", "E");
        passa = passa.replaceAll("[êèéë]", "e");
        passa = passa.replaceAll("ÎÍÌÏ", "I");
        passa = passa.replaceAll("îíìï", "i");
        passa = passa.replaceAll("[ÔÕÒÓÖ]", "O");
        passa = passa.replaceAll("[ôõòóö]", "o");
        passa = passa.replaceAll("[ÛÙÚÜ]", "U");
        passa = passa.replaceAll("[ûúùü]", "u");
        passa = passa.replaceAll("Ç", "C");
        passa = passa.replaceAll("ç", "c");
        passa = passa.replaceAll("[ýÿ]", "y");
        passa = passa.replaceAll("Ý", "Y");
        passa = passa.replaceAll("ñ", "n");
        passa = passa.replaceAll("Ñ", "N");
        passa = passa.replaceAll("´", "");
        passa = passa.replaceAll("'", "");
        passa = passa.replaceAll("['<>\\|/]", "");
        System.out.println(passa);

        return passa;
    }

    public String read() {
        return "Total Lido = R$ " + Funcoes.FormatoMoedaBR(valorLido) + " Total Importado = R$ " + Funcoes.FormatoMoedaBR(valorImp);
    }

}
