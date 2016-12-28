/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.eqc_equivalencia_composicao;

import br.com.easynet.gwt.easyportal.client.Constantes;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.form.LabelField;

/**
 *
 * @author marcos
 */
public class imprimirEqcCompGWT extends Window{

    public imprimirEqcCompGWT() {
        this.setHeading("Download Equivalência");
        this.setSize(200, 200);
        String page = Constantes.URL + "easyEngenharia/easyconstru/eqc_equivalencia_composicao/imprimir.jsp?op=imprimir&tipo=PDF";
        LabelField lf = new LabelField("<a href ="+page+">Download<a/>");
        this.add(lf);
        layout();

    }


}
