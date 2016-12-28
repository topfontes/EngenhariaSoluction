/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

import br.com.easynet.gwt.easyportal.jb.SystemBase;

/**
 *
 * @author topfontes
 */
 interface ModeloPDF{
    
    String getDocumento();
    String getVencimento();
    float getValor();
     
    String getFornecedor();
    String getObs();
    String read();
    boolean isInicioItem();
    String getFormatDouble(String valor);
    
    
}
