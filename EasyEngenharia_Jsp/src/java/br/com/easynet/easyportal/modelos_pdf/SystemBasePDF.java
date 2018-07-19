/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import br.com.jdragon.dao.DAOFactory;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author topfontes
 */
public class SystemBasePDF extends SystemBase {

    protected List<Ctp_conta_pagarT> list;
    protected TreeMap<String, Ctp_conta_pagarT> treeConta = new TreeMap<String, Ctp_conta_pagarT>();
    protected Ctp_conta_pagarT ctp_conta_pagarT;
    protected Ctp_conta_pagarT ctp_conta_pagarT_Insert = new Ctp_conta_pagarT();
    protected Ctp_conta_pagarDAO ctp_conta_pagarDAO;
    protected static String linha;
    protected InputStream is;
    protected int posDoc = 0;
    protected Funcoes funcoes = new Funcoes();
    protected DAOFactory dao;
    protected double totalImp;
    protected double total;
    protected TreeMap<String, Integer> TreeNumeros = new TreeMap<String, Integer>();
    protected int posVirgula;
    protected TreeMap<String, Ctp_conta_pagarT> treeMesLan = new TreeMap<String, Ctp_conta_pagarT>();
    protected SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public SystemBasePDF(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is) {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
        this.ctp_conta_pagarDAO = cdao;
        this.is = is;
        TreeNumeros.put("0", 0);
        TreeNumeros.put("1", 1);
        TreeNumeros.put("2", 2);
        TreeNumeros.put("3", 3);
        TreeNumeros.put("4", 4);
        TreeNumeros.put("5", 5);
        TreeNumeros.put("6", 6);
        TreeNumeros.put("7", 7);
        TreeNumeros.put("8", 8);
        TreeNumeros.put("9", 9);
    }

    protected boolean isContaExiste(String key) {
        if (treeConta.get(key) != null) {
            return true;
        }
        return false;
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

        protected int posLastCaracterReal(String valor, String caracter) throws Exception {
        int p = valor.length();
        valor = valor.trim();
        for (int i = valor.length(); i > 0; i--) {
            String l = valor.substring(i - 1, i);
            if (l.equalsIgnoreCase(caracter)) {
                return i;
            }
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

    public void addObjectCTP(String fornecedor, String documento, Date vencimento, float valor, String hist) throws Exception {
        try {
            ctp_conta_pagarT_Insert.setCtp_nr_ano(this.ctp_conta_pagarT.getCtp_nr_ano());
            ctp_conta_pagarT_Insert.setCtp_nr_mes(this.ctp_conta_pagarT.getCtp_nr_mes());
            ctp_conta_pagarT_Insert.setObr_nr_id(this.ctp_conta_pagarT.getObr_nr_id());
            ctp_conta_pagarT_Insert.setCtp_tx_status(this.ctp_conta_pagarT.getCtp_tx_status());
            ctp_conta_pagarT_Insert.setCtp_tx_fornecedor(fornecedor);
            ctp_conta_pagarT_Insert.setPlc_nr_id(0);
            ctp_conta_pagarT_Insert.setCtp_nr_documento(documento.trim());
            ctp_conta_pagarT_Insert.setCtp_dt_vencimento(vencimento);
            ctp_conta_pagarT_Insert.setCtp_nr_valor(valor);

            String obs = hist;
            if (hist.length() > 299) {
                obs = hist.substring(0, 299).trim();
            }
            ctp_conta_pagarT_Insert.setCtp_tx_obs(obs);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String key = ctp_conta_pagarT.getCtp_nr_documento() + "." + sdf.format(vencimento);
            treeConta.put(key, ctp_conta_pagarT);

            ctp_conta_pagarDAO.insert(ctp_conta_pagarT_Insert);
            totalImp = totalImp + ctp_conta_pagarT_Insert.getCtp_nr_valor();

        } catch (Exception e) {
            System.out.println("Erro: " + documento);
            e.printStackTrace();

        }

    }

}
