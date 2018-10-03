/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.jb;

/**
 *
 * @author marcos
 */
public class SessionExisteJB extends SystemBase{

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult(){
        setMsg("False");
        if (getSession().getAttribute("listfatorPlc")!= null){
            setMsg("True");
        }
    }
}
