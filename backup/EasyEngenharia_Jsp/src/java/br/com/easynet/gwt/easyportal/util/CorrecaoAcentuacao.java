/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.util;

/**
 *
 * @author marcos
 */

public class CorrecaoAcentuacao {

    public static String getCorrecao(String valor) {
        String txt = valor;
        return txt;
    }

    public String corrigir(String valor) {
        String vl;
        vl = valor.replace("Ã¢", "â");
        vl = vl.replace("ÃƒÂ¢", "â");
        vl = vl.replace("ÃƒÂ,", "");
        vl = vl.replace("ÃƒÂ", "à");
        vl = vl.replace("Ã‚Â°C", "°C");
        vl = vl.replace("Â°C", "°C");
        vl = vl.replace("Ã‚Â³", "³");
        vl = vl.replace("Â³", "³");
        vl = vl.replace("Ã‚Â²", "²");
        vl = vl.replace("Â²", "²");
        vl = vl.replace("Ã‚Âª", "ª");
        return vl;
    }
}
