package br.com.easynet.gwt.easyportal.client;

import br.com.easynet.gwt.easyportal.client.*;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author geoleite
 */
public class EasyAccessURL {

    protected JSONValue jsonValue = null;
    private IListenetResponse listener;
    private MessageBox mb;

    public EasyAccessURL(IListenetResponse elr) throws Exception {
        this.listener = elr;
    }

    /**
     * Acessa o JSP e envia e recebe dados
     *
     * @param url
     * @throws java.lang.Exception
     */
    public void accessJSonNoProgress(String url) throws Exception {
        RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, url);

        rb.sendRequest(null, new RequestCallback() {

            public void onResponseReceived(Request req, Response res) {
                String dados = res.getText();

                dados = dados.trim();

                jsonValue = JSONParser.parse(dados);

                listener.read(jsonValue);

            }

            public void onError(Request arg0, Throwable arg1) {
                com.google.gwt.user.client.Window.alert("Erro no accessJSON:EasyAccessURL" + arg1.getMessage());
            }
        });
    }

    public void accessJSon(String url) throws Exception {
        mb = MessageBox.wait("Requisicao", "Requisitando a servidor", "Esperando resposta.");

        RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, url);

        rb.sendRequest(null, new RequestCallback() {

            public void onResponseReceived(Request req, Response res) {
                String dados = res.getText();
//                com.extjs.gxt.ui.client.widget.Window w = new com.extjs.gxt.ui.client.widget.Window();
//                w.addText(dados);
//                w.setSize(500, 700);
//                w.setScrollMode(Style.Scroll.AUTO);
//                w.show();
                 
                dados = dados.trim();
                
                mb.close();
                
 
                jsonValue = JSONParser.parse(dados);
  

                listener.read(jsonValue);
                
            }

            public void onError(Request arg0, Throwable arg1) {
                com.google.gwt.user.client.Window.alert("Erro no accessJSON:EasyAccessURL" + arg1.getMessage());
            }
        });
    }

    /**
     * Acessa o JSP e envia e recebe dados
     *
     * @param url
     * @throws java.lang.Exception
     */
    public void accessJSonMap(String url, HashMap map) throws Exception {

        url += "?controlidentity=" + System.currentTimeMillis() + "&";
        Set<String> keys = map.keySet();
        Iterator<String> iter = keys.iterator();

        for (Iterator<String> it = keys.iterator(); it.hasNext();) {
            String key = it.next();
            String value = null;
            if (map.containsKey(key)) {
                value = map.get(key).toString();
            }
            if (value != null) {
                url += key + "=" + value + "&";
            }
        }
        if(url.indexOf("debug") != -1){
            Window.alert(url);
        }
        
        accessJSon(url);
    }

    public void accessJSonMapNoProgress(String url, HashMap map) throws Exception {

        url += "?controlidentity=" + System.currentTimeMillis() + "&";
        Set<String> keys = map.keySet();
        Iterator<String> iter = keys.iterator();

        for (Iterator<String> it = keys.iterator(); it.hasNext();) {
            String key = it.next();
            String value = null;
            if (map.containsKey(key)) {
                value = map.get(key).toString();
            }
            if (value != null) {
                url += key + "=" + value + "&";
            }
        }

        accessJSonNoProgress(url);
    }

    public IListenetResponse getListener() {
        return listener;
    }

    public void setListener(IListenetResponse listener) {
        this.listener = listener;
    }
}
