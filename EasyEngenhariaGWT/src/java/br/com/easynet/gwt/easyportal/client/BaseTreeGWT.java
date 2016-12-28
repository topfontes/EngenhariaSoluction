/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author marcos
 */

public class BaseTreeGWT extends BaseTreeModel implements Serializable{
  private static int ID = 0;

  public BaseTreeGWT() {
    set("id", ID++);
  }

  public BaseTreeGWT(String name) {
    set("id", ID++);
    set("name", name);
  }

  public BaseTreeGWT(String name, BaseTreeModel[] children) {
    this(name);
    for (int i = 0; i < children.length; i++) {
      add(children[i]);
    }
  }

  public Integer getId() {
    return (Integer) get("id");
  }

  public String getName() {
    return (String) get("name");
  }

  public String toString() {
    return getName();
  }

}
