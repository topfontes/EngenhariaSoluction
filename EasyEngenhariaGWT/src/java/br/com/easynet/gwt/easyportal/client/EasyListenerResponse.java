/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author geoleite
 */
public class EasyListenerResponse implements IListenetResponse {
    private TreeMap<String, Object> map = new TreeMap<String, Object>();
    public void read(JSONValue jsonValue) {
        readJSON(jsonValue);
    }
    
    private Object readJSON(JSONValue jsonValue) {
        JSONObject jsonObj = null;
        JSONString jsonStr = null;
        JSONArray jsonArr = null;
        
        if ((jsonStr = jsonValue.isString()) != null) {// verifica se é uma string
            //Window.alert("Str" + jsonValue.toString());
            return jsonValue.toString();
        } else if ((jsonArr = jsonValue.isArray()) != null) {//Verifica se o valor é um array
            int total = jsonArr.size();
            List list = new Vector();
            for (int i = 0; i < total; i++) {
                JSONValue jsonValueTemp = jsonArr.get(i);
                list.add(readJSON(jsonValueTemp));
            }
            //Window.alert("Arr" + list);
            return list;
        } else if ((jsonObj = jsonValue.isObject()) != null) {//Verifica se o valor é um objeto
            Set<String> keys = jsonObj.keySet();
            Iterator<String> iter = keys.iterator();
            TreeMap<String, Object> map = new TreeMap<String, Object>();
            while(iter.hasNext()) {
                String key = iter.next();
                
                JSONValue jsonValueTemp = jsonObj.get(key);
               // Window.alert("Key" + key);
                map.put(key, readJSON(jsonValueTemp));
            }
            //Window.alert("Obj " + map);
            return map;
        }
        return null;
    }
}
