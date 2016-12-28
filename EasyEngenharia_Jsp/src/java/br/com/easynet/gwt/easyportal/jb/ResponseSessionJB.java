/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;

/**
 *
 * @author topfontes
 */
public class ResponseSessionJB extends  SystemBase implements INotSecurity{
    public static String SESSION_RESPONSE="resposta";
    
    public void realizado(){
        String res = (String)getSession().getAttribute(SESSION_RESPONSE);
        if(res == null){
            setMsg("false");
        }else{
            setMsg(res);
        }
    }
    
}
