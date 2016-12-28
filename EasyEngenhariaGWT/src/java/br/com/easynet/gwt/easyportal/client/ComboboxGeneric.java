/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.user.client.ui.ListBox;

public class ComboboxGeneric {

    private ComboBox<ListGeneric> cb;
    private ListBox listBox;
    private String[]values;
    private String[]display;

    public ComboboxGeneric(String[] values, String[] display) {
        this.values = values;
        this.display = display;
    }

    public void getResult() {
        if (cb != null) {
            ListStore<ListGeneric> store = new ListStore<ListGeneric>();
            for (int i = 0; i < values.length; i++) {
                ListGeneric lg = new ListGeneric();
                lg.setValue(values[i]);
                lg.setDisplay(display[i]);
                store.add(lg);
            }
            cb.setStore(store);
            cb.setEmptyText("Escolha a operação");
            cb.setValueField("value");
            cb.setDisplayField("display");
            cb.setTypeAhead(true);
            cb.setWidth(200);
            cb.setTriggerAction(ComboBox.TriggerAction.ALL);
        } else if (listBox != null) {
            for (int i = 0; i < values.length; i++) {
                listBox.addItem( display[i],values[i]);
            }
        }
    }
    
    public int getIndexList(String value){
        int index = 0;
        for (int i = 0; i < listBox.getItemCount(); i++) {
            if (listBox.getValue(i).equalsIgnoreCase(value)){
                index = i;
                break;
            }
        }
        return index;
    }
    /**
     * @return the cb
     */
    public ComboBox<ListGeneric> getCb() {
        return cb;
    }

    /**
     * @param cb the cb to set
     */
    public void setCb(ComboBox<ListGeneric> cb) {
        this.cb = cb;
    }

    /**
     * @return the listBox
     */
    public ListBox getListBox() {
        return listBox;
    }

    /**
     * @param listBox the listBox to set
     */
    public void setListBox(ListBox listBox) {
        this.listBox = listBox;
    }
}
