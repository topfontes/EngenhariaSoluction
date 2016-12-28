/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.transfer.Arq_arquivoT;
import java.io.ByteArrayInputStream;

/**
 *
 * @author marcos
 */
public class ImportarXML extends SystemBase implements INotSecurity {

    private Arq_arquivoT arq_arquivoT = new Arq_arquivoT();

    public void importar() {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(arq_arquivoT.getArq_bt_arquivo());
        } catch (Exception e) {
            setMsg("Erro ao tentar importar, verifique se todos os parametros estão preechidos");
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
