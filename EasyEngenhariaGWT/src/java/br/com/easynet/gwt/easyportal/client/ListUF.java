/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client;

import com.google.gwt.user.client.Window;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class ListUF {

    private String[] valor;
    private String[] display;
    private List<UFTGWT> list;
    private TreeMap<String, UFTGWT> treeUF;

    public ListUF() {
        valor = new String[27];
        display = new String[27];
        valor[0] = "AC";
        valor[1] = "AL";
        valor[2] = "AM";
        valor[3] = "AP";
        valor[4] = "BA";
        valor[5] = "CE";
        valor[6] = "DF";
        valor[7] = "ES";
        valor[8] = "GO";
        valor[9] = "MA";
        valor[10] = "MG";
        valor[11] = "MS";
        valor[12] = "MT";
        valor[13] = "PA";
        valor[14] = "PB";
        valor[15] = "PE";
        valor[16] = "PI";
        valor[17] = "PR";
        valor[18] = "RJ";
        valor[19] = "RN";
        valor[20] = "RO";
        valor[21] = "RR";
        valor[22] = "RS";
        valor[23] = "SC";
        valor[24] = "SE";
        valor[25] = "SP";
        valor[26] = "TO";

        display[0] = "ACRE";
        display[1] = "ALAGOAS";
        display[2] = "AMAZONAS";
        display[3] = "AMAPA";
        display[4] = "BAHIA";
        display[5] = "CEARA";
        display[6] = "DISTRITO FEDERAL";
        display[7] = "ESPIRITO SANTO";
        display[8] = "GOIAS";
        display[9] = "MARANHAO";
        display[10] = "MINA GERAIS";
        display[11] = "MATO GROSSO DO SUL";
        display[12] = "MATO GROSSO";
        display[13] = "PARA";
        display[14] = "PARAIBA";
        display[15] = "PERNAMBUCO";
        display[16] = "PIAUI";
        display[17] = "PARANA";
        display[18] = "RIO DE JANEIRO";
        display[19] = "RIO GRANDE DO NORTE";
        display[20] = "RONDONIA";
        display[21] = "RORAIMA";
        display[22] = "RIO GRANDE DO SUL";
        display[23] = "SANTA CATARINA";
        display[24] = "SERGIPE";
        display[25] = "SÃO PAULO";
        display[26] = "TOCANTINS";
    }

    public String[] getValor() {
        return valor;
    }

    public String[] getDisplay() {
        return display;
    }

    /**
     * @return the list
     */
    public List<UFTGWT> getList() {
        return list;
    }

    public void povoa() {
        list = new Vector<UFTGWT>();
        setTreeUF(new TreeMap<String, UFTGWT>());
        for (int i = 0; i < valor.length; i++) {
            UFTGWT uftgwt = new UFTGWT();
            uftgwt.setValue(valor[i]);
            uftgwt.setDisplay(display[i]);
            list.add(uftgwt);
            getTreeUF().put(uftgwt.getValue(), uftgwt);
        }

    }

    /**
     * @param list the list to set
     */
    public void setList(List<UFTGWT> list) {
        this.list = list;
    }

    /**
     * @return the treeUF
     */
    public TreeMap<String, UFTGWT> getTreeUF() {
        return treeUF;
    }

    /**
     * @param treeUF the treeUF to set
     */
    public void setTreeUF(TreeMap<String, UFTGWT> treeUF) {
        this.treeUF = treeUF;
    }
}
